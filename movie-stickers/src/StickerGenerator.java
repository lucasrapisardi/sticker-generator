import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;

public class StickerGenerator {
    public void criaFigurinha() throws Exception{
        // fazer a leitura da imagem
        //InputStream inputStream = new FileInputStream("entrada/imagem-grande.jpg");
        InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@.jpg")
                                            .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparencia e novo tamanho
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 150;
        BufferedImage novaImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, null, 0, 0);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 80);
        graphics.setColor(Color.RED);   
        graphics.setFont(fonte);  

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 150, novaAltura - 100);
        
        // escrever a nova imagem em um arquivo
        CriaDiretorio dir = new CriaDiretorio();
        dir.dir();
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
    }
    
    public static void main(String[] args) throws Exception {
        var geradora = new StickerGenerator();
        geradora.criaFigurinha();
    }
}
