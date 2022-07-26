import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Integer starCode = 0x2B50;
        char[] starChar = Character.toChars(starCode);
        var starString = new String(starChar);

        // Fazer uma requisição HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI uri = URI.create(url);
        var client =  HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // Filtrar apenas os dados de interesse (titulo, rating, poster)
        var jsonParser = new JsonParser();
        List<Map<String, String>> movieList = jsonParser.parse(body);
        // Exibir e manipular os dados
        for (Map<String,String> movie : movieList) {
            System.out.println("Título: " + movie.get("title"));
            System.out.println("Classificação: " + starString + movie.get("imDbRating"));
            System.out.println(movie.get("image") + "\n");
        }
    }
}
