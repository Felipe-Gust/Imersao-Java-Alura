import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
	//usada para estudo e não publicação
    public static void main(String[] args) throws Exception {

        //fazer uma conexão HTTP e buscar os top 250 filmes
		String url = "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json";
		//String url = "https://imdb-api.com/en/API/Top250Movies/k_dof21y0k";
		URI endereco = URI.create(url);		
		//fazer client
		var client = HttpClient.newHttpClient();
		//fazer request
		var request = HttpRequest.newBuilder(endereco).GET().build();
		//fazer response
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body(); //body é o texto que o site IMDB API liberou
		
		//extrair (ou parsear) só os dados que interessam (título, poster, classificação/rating)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		//System.out.println(listaDeFilmes.size()); //fez para verificar se tem os 250 filmes
		//System.out.println(listaDeFilmes.get(0)); //ver primeiro item
		
		//exibir e manipular os dados
		for (Map<String,String> filme : listaDeFilmes) {
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));
			System.out.println();
		}

    }
}
