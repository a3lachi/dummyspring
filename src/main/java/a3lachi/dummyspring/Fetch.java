package a3lachi.dummyspring;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;


class FetchData {

    String data ;

    public FetchData() {

        String apiUrl = "http://dummyjson.com/products/1";

        HttpClient httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET() // Perform a GET request
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            int statusCode = httpResponse.statusCode();
            String responseBody = httpResponse.body();
            this.data = responseBody ;

            System.out.println("Status Code: " + statusCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String getData() {
        return this.data ;
    }
}
