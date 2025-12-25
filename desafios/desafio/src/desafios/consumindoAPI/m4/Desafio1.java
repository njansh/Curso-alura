package desafios.consumindoAPI.m4;

import java.io.FileWriter;
import java.io.IOException;

public class Desafio1 {
    String test="Conteudo a ser gravado no Arquivo";

    FileWriter escrita;

    {
        try {
            escrita = new FileWriter("arquivo.txt");
            escrita.write(test);
            escrita.close();
            System.out.println("Funcionou");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
