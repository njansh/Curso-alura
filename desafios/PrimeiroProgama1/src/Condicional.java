public class Condicional {
    public static void main(String[] args) {
        int anoDeLacamento=2022;

        boolean incluidoNoPlano=true;
        double nota=8.1;
        String tipoPlano="PLUS";

        if(anoDeLacamento>=2022){
            System.out.println("Lançamento que os clientes estão curtindo");
        }else{
            System.out.println("Filme retro que vale a pen aassistir!");
        }

        if (incluidoNoPlano || tipoPlano.equals("PLUS")){
            System.out.println("Filme liberado");
        }else{
            System.out.println("Alugue o filme");
        }
    }
}
