import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura de imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg")); //dessa forma ele busca pela pasta/diretório
        //InputStream inputStream = new URL("https://img.ecartelera.com/noticias/45700/45781-m.jpg?v=2.0").openStream(); //aqui está pegando da internet, não mais do diretório
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        // cria nova imagem em memória com transparência e novo tamanho
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 250;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null); //usa a imagemOriginal, pois o graphics já é a nova
        
        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setColor(Color.RED);
        graphics.setFont(fonte);
        
        // escrever uma frase na nova imagem
        graphics.drawString("OI, BORA ME VER?!", 300, novaAltura - 100);

        // escrever a imagem nova em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

        }
    
    /* usado só para testar
    public static void main(String[] args) throws Exception {

        // criando novo diretório
        /*
        File directory = new File("/path/saida");

        if(directory.mkdir()){
            System.out.println("Diretório criado com sucesso.");
        }

        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    } */
    
}
