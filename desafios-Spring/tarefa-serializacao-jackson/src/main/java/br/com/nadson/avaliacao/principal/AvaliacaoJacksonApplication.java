package br.com.nadson.avaliacao.principal;

import br.com.nadson.avaliacao.model.Assinatura;
import br.com.nadson.avaliacao.model.Avaliacao;
import br.com.nadson.avaliacao.model.Produto;
import br.com.nadson.avaliacao.model.Servico;
import br.com.nadson.avaliacao.service.AvaliacaoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AvaliacaoJacksonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoJacksonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Produto produto1 = new Produto("Livro Java Avançado");
		Produto produto2 = new Produto("Curso Spring Boot");

		Avaliacao<Produto> avaliacao1 = new Avaliacao<>(produto1, 4.5, "Muito bom, conteúdo excelente!");
		Avaliacao<Produto> avaliacao2 = new Avaliacao<>(produto1, 5.0, "Perfeito para aprofundar conhecimentos.");
		Avaliacao<Produto> avaliacao3 = new Avaliacao<>(produto2, 3.8, "Bom, mas poderia ter mais exemplos práticos.");
		Avaliacao<Produto> avaliacao4 = new Avaliacao<>(produto2, 4.0, "Didática clara e objetiva.");

		List<Avaliacao<Produto>> avaliacoesProduto = Arrays.asList(avaliacao1, avaliacao2, avaliacao3, avaliacao4);

		double mediaProdutos=new AvaliacaoService().calcularMedia(avaliacoesProduto);
		System.out.println("Média das avaliações de Produtos: " + mediaProdutos);
		
		Servico servico1 = new Servico("Consultoria de TI");
		Servico servico2 = new Servico("Manutenção de Software");

		Avaliacao<Servico> avaliacaoServico1 = new Avaliacao<>(servico1, 4.2, "Atendimento rápido e eficiente.");
		Avaliacao<Servico> avaliacaoServico2 = new Avaliacao<>(servico2, 3.5, "Poderia ser mais ágil na resolução.");

		List<Avaliacao<Servico>> avaliacoesServico = Arrays.asList(avaliacaoServico1, avaliacaoServico2);

		double mediaServicos = new AvaliacaoService().calcularMedia(avaliacoesServico);
		System.out.println("Média das avaliações de Serviços: " + mediaServicos);
		
		Assinatura assinatura1 = new Assinatura("Premium");
		Assinatura assinatura2 = new Assinatura("Básico");

		Avaliacao<Assinatura> avaliacaoAssinatura1 = new Avaliacao<>(assinatura1, 4.8, "Ótimos benefícios, vale a pena!");
		Avaliacao<Assinatura> avaliacaoAssinatura2 = new Avaliacao<>(assinatura2, 3.0, "Funcional, mas com poucas opções.");

		List<Avaliacao<Assinatura>> avaliacoesAssinatura = Arrays.asList(avaliacaoAssinatura1, avaliacaoAssinatura2);

		double mediaAssinaturas = new AvaliacaoService().calcularMedia(avaliacoesAssinatura);
		System.out.println("Média das avaliações de Assinaturas: " + mediaAssinaturas);

	}
}
