package br.com.nadson.screeanmatch;

import br.com.nadson.screeanmatch.model.DadosEpisodio;
import br.com.nadson.screeanmatch.model.DadosSerie;
import br.com.nadson.screeanmatch.model.DadosTemporada;
import br.com.nadson.screeanmatch.service.ConsumoApi;
import br.com.nadson.screeanmatch.service.ConverterDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println("buscando uma serie completa");
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls");
		System.out.println(json);
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		System.out.println("buscando um episodio isolado");
		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=1");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);
		System.out.println("buscando uma temporada completa");
		json=consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1");
		DadosTemporada dadosTemporada=conversor.obterDados(json,DadosTemporada.class);
 		List<DadosEpisodio> episodiosComTemporada =
				dadosTemporada.episodios().stream()
						.map(e -> new DadosEpisodio(
								e.titulo(),
								dadosTemporada.numero(),
								e.numero(),
								e.imdbRating(),
								e.dataLancamento()
						))
						.toList();

		System.out.println(episodiosComTemporada);

		System.out.println("Obtendo todas as temporadas");
		List<DadosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i);
			DadosTemporada dadosDaTemporada = conversor.obterDados(json, DadosTemporada.class);
			episodiosComTemporada =
					dadosDaTemporada.episodios().stream()
							.map(e -> new DadosEpisodio(
									e.titulo(),
									dadosDaTemporada.numero(),
									e.numero(),
									e.imdbRating(),
									e.dataLancamento()
							))
							.toList();

			temporadas.add(
					new DadosTemporada(dadosDaTemporada.numero(), episodiosComTemporada)
			);
		}

		System.out.println(temporadas);
	}
}
