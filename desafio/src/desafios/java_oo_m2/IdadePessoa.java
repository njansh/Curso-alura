package desafios.java_oo_m2;

public class IdadePessoa {
    private int idade;
    private String nome;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void verificarIdade(){
        if (idade>=18){
            System.out.println("Maior de idade ");
        }else {
            System.out.println("menor de idade");
        }
    }
}

class Principal{
    public static void main(String[] args) {
        IdadePessoa id=new IdadePessoa();
        id.setIdade(23);
        id.setNome("Nadson");
        id.verificarIdade();
    }
}
