package br.com.nadson.fipeapi.principal;

import br.com.nadson.fipeapi.model.*;
import br.com.nadson.fipeapi.service.FipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    private final FipeService fipeService;

    public Principal(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @Override
    public void run(String... args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                int tipo = escolherTipoVeiculo(sc);
                if (tipo == 0) break;

                fipeService.tipoVeiculo(tipo);

                String codigoMarca = escolherMarca(sc);
                if (codigoMarca == null) continue;

                String codigoModelo = escolherModelo(sc, codigoMarca);
                if (codigoModelo == null) continue;

                List<Ano> anos = fipeService.listarAno(codigoMarca, codigoModelo);
                if (anos == null || anos.isEmpty()) {
                    System.out.println("Nenhum ano encontrado para este modelo.");
                    continue;
                }

                mostrarAnos(anos);

                escolherPreco(sc, codigoMarca, codigoModelo, anos);

                if (!voltarMenu(sc)) break;
            }
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    private int escolherTipoVeiculo(Scanner sc) {
        while (true) {
            try {
                System.out.println("\n--- MENU FIPE ---");
                System.out.println("1 - Carro");
                System.out.println("2 - Moto");
                System.out.println("3 - Caminhão");
                System.out.println("0 - Sair");
                System.out.print("Escolha o tipo de veículo: ");
                int tipo = sc.nextInt();
                sc.nextLine(); // Limpa buffer
                if (tipo >= 0 && tipo <= 3) return tipo;
                System.out.println("Opção inválida, tente novamente.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, digite um número.");
                sc.nextLine(); // Limpa buffer
            }
        }
    }

    private String escolherMarca(Scanner sc) {
        List<Marca> marcas = fipeService.listarMarcas();
        if (marcas == null || marcas.isEmpty()) {
            System.out.println("Nenhuma marca encontrada.");
            return null;
        }
        marcas.forEach(m -> System.out.println(m.codigo() + " | " + m.nome()));

        while (true) {
            System.out.print("Escolha o código da marca: ");
            String codigoMarca = sc.nextLine();
            if (marcas.stream().anyMatch(m -> m.codigo().equals(codigoMarca))) return codigoMarca;
            System.out.println("Código de marca inválido, tente novamente.");
        }
    }

    private String escolherModelo(Scanner sc, String codigoMarca) {
        List<Modelo> modelos = fipeService.listarModelos(codigoMarca);
        if (modelos == null || modelos.isEmpty()) {
            System.out.println("Nenhum modelo encontrado para esta marca.");
            return null;
        }
        modelos.forEach(m -> System.out.println(m.codigo() + " | " + m.nome()));

        while (true) {
            System.out.print("Escolha o código do modelo: ");
            String codigoModelo = sc.nextLine();
            if (modelos.stream().anyMatch(m -> m.codigo().equals(codigoModelo))) return codigoModelo;
            System.out.println("Código de modelo inválido, tente novamente.");
        }
    }

    private void mostrarAnos(List<Ano> anos) {
        System.out.println("\n--- Anos disponíveis ---");
        anos.forEach(a -> System.out.println(a.codigo() + " | " + a.nome()));
    }

    private void escolherPreco(Scanner sc, String codigoMarca, String codigoModelo, List<Ano> anos) {
        System.out.print("\nDeseja ver o preço de todos os anos ou de um ano específico? (1 - Todos, 2 - Específico): ");
        int opcao;
        while (true) {
            try {
                opcao = sc.nextInt();
                sc.nextLine();
                if (opcao == 1 || opcao == 2) break;
                System.out.println("Opção inválida, digite 1 ou 2.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, digite 1 ou 2.");
                sc.nextLine();
            }
        }

        if (opcao == 1) {
            for (Ano ano : anos) {
                ValorVeiculo valor = fipeService.listarValorVeiculo(codigoMarca, codigoModelo, ano.codigo());
                if (valor != null) {
                    System.out.println("Ano: " + ano.nome() + " | Modelo: " + valor.modelo() + " | Preço: " + valor.valor());
                } else {
                    System.out.println("Ano: " + ano.nome() + " | Valor não encontrado.");
                }
            }
        } else {
            while (true) {
                System.out.print("Digite o código do ano para consultar o preço: ");
                String codigoAno = sc.nextLine();
                if (anos.stream().anyMatch(a -> a.codigo().equals(codigoAno))) {
                    ValorVeiculo valor = fipeService.listarValorVeiculo(codigoMarca, codigoModelo, codigoAno);
                    if (valor != null) {
                        System.out.println("\n--- Detalhes do Veículo ---");
                        System.out.println("Valor: " + valor.valor());
                        System.out.println("Marca: " + valor.marca());
                        System.out.println("Modelo: " + valor.modelo());
                        System.out.println("Ano Modelo: " + valor.anoModelo());
                        System.out.println("Combustível: " + valor.combustivel());
                        System.out.println("Código Fipe: " + valor.codigoFipe());
                        System.out.println("Mês Referência: " + valor.mesReferencia());
                        System.out.println("Tipo Veículo: " + valor.tipoVeiculo());
                        System.out.println("Sigla Combustível: " + valor.siglaCombustivel());
                    } else {
                        System.out.println("Nenhum valor encontrado para este ano.");
                    }
                    break;
                }
                System.out.println("Código de ano inválido, tente novamente.");
            }
        }
    }

    private boolean voltarMenu(Scanner sc) {
        System.out.print("\nDeseja voltar ao menu principal? (S/N): ");
        String voltar = sc.nextLine();
        return voltar.equalsIgnoreCase("S");
    }
}
