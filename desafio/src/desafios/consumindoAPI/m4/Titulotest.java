package desafios.consumindoAPI.m4;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import desafios.list_e_colections.m4.Titulo;

public class Titulotest {
    public static void main(String[] args) {

    Titulo titulo =new Titulo("Matrix");
     titulo.setNota(10);
     titulo.setDuracao(200);
     Gson gson= new GsonBuilder().setPrettyPrinting().create();
     String json= gson.toJson(titulo);
        System.out.println(json);
}
}