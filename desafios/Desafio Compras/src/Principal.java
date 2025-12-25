import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);

        Compras compra1=new Compras("Computador",2000);
        Compras compra2=new Compras("Caneta",2.4);

        CartaoDeCredito cartao1=new CartaoDeCredito();
        cartao1.setCompras(compra1);
        cartao1.setCompras(compra2);
       cartao1.getCompras();
        System.out.println("Digite o limite do cartão");
        double limite= entrada.nextDouble();
        cartao1.setLimite(limite);
       while(true){

           System.out.println("Deseja Fazer uma compra? Digite 1 para sim e 2 para não");
           int resposta=entrada.nextInt();
           entrada.nextLine();
           if (resposta==1){
               Compras compra=new Compras();
               System.out.println("qual o nome do produto");
               String nome =entrada.nextLine();
               compra.setNome(nome);
               System.out.println("Qual o valor do produto");
               double preco=entrada.nextDouble();
               entrada.nextLine();

               compra.setPreco(preco);
               cartao1.setCompras(compra);
               System.out.println("Compra Realizada");
           }   else if (resposta == 2) {
            System.out.println("Finalizando...");
                     break;
        } else {
            System.out.println("Opção inválida. Digite 1 ou 2.");
        }

       }


    }
}
