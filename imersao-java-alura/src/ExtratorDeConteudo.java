import java.util.List;

//interface para unir as classes ExtratorDeConteudoDoImdb e ExtratorDeConteudoDaNasa
public interface ExtratorDeConteudo {

    List<Conteudo> extraiConteudos(String json);
    
}
