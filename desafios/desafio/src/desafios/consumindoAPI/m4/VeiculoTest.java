package desafios.consumindoAPI.m4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VeiculoTest {
    public static void main(String[] args) {
        Veiculo v1=new Veiculo("Ferrari", "Vermelha", 2015);
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(v1);
        System.out.println(json);


    }
}
