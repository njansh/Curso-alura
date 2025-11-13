public class Principal {
    public static void main(String[] args) {
        Filme meuFilme=new Filme();
        meuFilme.nome="o poderoso Chefao";
        meuFilme.anoDeLancamento=1970;
        meuFilme.duracaoEmMinutos=80;
        meuFilme.incluidoNoPlano=true;
        meuFilme.avalia(10);
        meuFilme.avalia(10);
        meuFilme.avalia(10);

        System.out.println("A media de notas foi "+meuFilme.pegaMedia()+" Com "+meuFilme.totalDeAvaliacoes+" Avaliações");


                }



    }
