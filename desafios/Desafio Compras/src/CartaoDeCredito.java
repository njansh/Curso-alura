import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CartaoDeCredito {
    private double limite;
    private List<Compras> compras=new ArrayList<>();
    private Compras compra;
    private double somaTotal;
    public double getSomaTotal() {
        return somaTotal=compras.stream()
                .mapToDouble(Compras::getPreco)
                .sum();
    }



    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void getCompras() {
         compras.stream().sorted(Comparator.comparing(Compras::getPreco).reversed())
                .collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("Valor total das compras: " + getSomaTotal());

    }

    public void setCompras(Compras compras) {
     this.compra=compras;

     if (compras.getPreco()<getLimite()){
      this.compras.add(compras) ;}
     else {
         System.out.println("Saldo insulficiente"+ " \n\nLimite Atual: "+(getLimite()-getSomaTotal()));
     }


    }
}
