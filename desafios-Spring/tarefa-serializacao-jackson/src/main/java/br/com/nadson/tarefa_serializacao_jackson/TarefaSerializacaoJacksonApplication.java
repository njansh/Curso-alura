package br.com.nadson.tarefa_serializacao_jackson;

import br.com.nadson.tarefa_serializacao_jackson.model.Tarefa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class TarefaSerializacaoJacksonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TarefaSerializacaoJacksonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("tarefa.json");

		// Serialização
		Tarefa tarefa = new Tarefa("Estudar Jackson para serialização", false, "Nadson");
		try {
			mapper.writeValue(file, tarefa);
			System.out.println("Tarefa serializada com sucesso para tarefa.json");
		} catch (IOException e) {
			System.err.println("Erro ao serializar a tarefa: " + e.getMessage());
		}

		// Desserialização
		try {
			Tarefa tarefaDesserializada = mapper.readValue(file, Tarefa.class);
			System.out.println("\nTarefa desserializada:");
			System.out.println(tarefaDesserializada);
		} catch (IOException e) {
			System.err.println("Erro ao desserializar a tarefa: " + e.getMessage());
		}
	}
}
