package br.com.nadson.screeanmatch;

import br.com.nadson.screeanmatch.model.DadosEpsodio;
import br.com.nadson.screeanmatch.model.DadosSerie;
import br.com.nadson.screeanmatch.service.ConsumoApi;
import br.com.nadson.screeanmatch.service.ConverterDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringScreeanmatchApplication implements CommandLineRunner {

	@Autowired
	private ConsumoApi consumoApi;
	@Autowired
	private ConverterDados conversor;

	public static void main(String[] args) {
		SpringApplication.run(SpringScreeanmatchApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls");
		System.out.println(json);
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=1");
		DadosEpsodio dadosEpsodio = conversor.obterDados(json, DadosEpsodio.class);
		System.out.println(dadosEpsodio);
	}
}
