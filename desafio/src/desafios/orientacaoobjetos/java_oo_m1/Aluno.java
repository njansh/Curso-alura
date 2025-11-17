package desafios.orientacaoobjetos.java_oo_m1;

public class Aluno {
    String nome;
    int idade;
    void fichaTecnica(){
        System.out.printf("Ola meu nome é %s e tenho %d",nome,idade);
    }
}
class Princial3{
    public static void main(String[] args) {
        Aluno aluno =new Aluno();
        aluno.nome="Nadson";
        aluno.idade=24;
        aluno.fichaTecnica();
    }
}
