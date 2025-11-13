import br.com.nadson.modelo.Filme;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme=new Filme();
        meuFilme.setNome("o poderoso Chefao");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(80);
        meuFilme.setIncluidoNoPlano(true);
        meuFilme.avalia(10);
        meuFilme.avalia(10);
        meuFilme.avalia(10);

        System.out.println("A media de notas foi "+meuFilme.pegaMedia()+" Com "+ meuFilme.getTotalDeAvaliacoes() +" Avaliações");


                }



    }
