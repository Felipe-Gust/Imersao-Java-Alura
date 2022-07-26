//App antes
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //fazer uma conexão HTTP e buscar 10 dos top 250 filmes
		// String url = "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json";
		// ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

		// String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
		// ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

		String url = "http://localhost:8080/linguagens"; // essa é uma url local (minha máquina)
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB(); //aqui posso fazer uma delegação, pois existem dois ExtratorDeConteudoDoIMDB

		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		//exibir e manipular os dados		
		List<Conteudo> conteudos = extrator.extraiConteudos(json);

		var geradora = new GeradoraDeFigurinhas();
	
		for (int i = 0; i < 3; i++) {

			Conteudo conteudo = conteudos.get(i);

			InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
			String nomeArquivo = "saida/" + conteudo.titulo() + ".png";

			geradora.cria(inputStream, nomeArquivo);

			System.out.println("\u001b[1mTítulo: " + conteudo.titulo());
			// quando a impressão for da url IMDB
			// System.out.println("\u001b[mPoster: " + conteudo.urlImagem());
			// System.out.println("Ano: " + conteudo.ano());
			// System.out.println("\u001b[33m\u001b[45m\u001b[3mNota IMDB: " + conteudo.classificacao() + "\u001b[m");
			System.out.println();
		}

    }
}
