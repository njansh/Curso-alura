package desafios.orientacaoobjetos.java_oo_m3;

public class Animal {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void  emitirSom(){
        //cada classe deve definir
    }
}
 class Cachorro extends Animal{
    public void abanarRabo (){
         System.out.println("abanando");
     }
     @Override
     public void emitirSom() {
         System.out.println("Auauauau");
     }
 }
class Gato extends Animal{
    public void arranharMoveis(){
         System.out.println("arranhando");
     }
     @Override
     public void emitirSom() {
         System.out.println("miauu");
     }
 }

