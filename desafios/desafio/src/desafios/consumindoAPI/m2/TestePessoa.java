package desafios.consumindoAPI.m2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestePessoa {
    public static void main(String[] args) {
        String jsonPessoa=" {\"nome\":\"Nadson\",\"idade\":20,\"cidade\":\"Petrolina\"}";

        Gson gson=new Gson();

        Pessoa pessoa=gson.fromJson(jsonPessoa, Pessoa.class);

        System.out.println("pessoa "+pessoa);

        String jsonPessoa1=" {\"nome\":\"Nadson Jhone\",\"idade\":20,\"cidade\":\"Petrolina\"}";
        Gson gson1=new GsonBuilder().setLenient().create();
        Pessoa pessoa1=gson1.fromJson(jsonPessoa1, Pessoa.class);
        System.out.println("pessoa "+pessoa1);




    }
}
