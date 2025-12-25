package desafios.orientacaoobjetos.java_oo_m3;

public class ContaBancaria {
  private  String titular;
    protected double saldo;

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void depositar(double deposito){
        saldo+=deposito;  System.out.println("Deposito realizado com sucesso, saldo atual:"+saldo);
    }public void sacar(double saque){
       if(saldo>=saque) {saldo-=saque;
           System.out.println("Saque realizado com sucesso, saldo atual:"+saldo);}else{
           System.out.println("Saldo insuficiente");
    }
}
 public static class ContaCorrente extends ContaBancaria{double taxaMensal;
    public void taxaMensal(double taxa){
        this.saldo-=taxa;
    }
}}
class Pricipal {
    public static void main(String[] args) {
        ContaBancaria c1=new ContaBancaria();
        c1.depositar(1000);
        c1.sacar(300);
        ContaBancaria.ContaCorrente c2=new ContaBancaria.ContaCorrente();
        c2.depositar(2000);
        c2.sacar(34);
        c2.taxaMensal(40);
        c2.getSaldo();
    }
}