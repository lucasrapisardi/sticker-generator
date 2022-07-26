import java.io.File;

public class CriaDiretorio  {
    public void dir(){
        File file = new File("saida");  

        if (!file.exists()) {
            file.mkdirs();
        }
    }
}

