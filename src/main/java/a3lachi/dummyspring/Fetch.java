package a3lachi.dummyspring;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;


class Fetch {

    public static String FetchData(String apiUrl) {

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

            if (statusCode == 200) {
                return responseBody;
            } else {
                return "";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }

    }
}

class FetchedData {
    int id ;
    String title ;
    String description ;
    double price;
    double discountPercentage;
    double rating;

    public FetchedData(int id, String title, String description, double price,double discountPercentage, double rating ) {
        this.id = id;
        this.title = title ;
        this.description = description ;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating ;
    }

    public String toString() {
        return "id : "+this.id+", title : "+this.title+", description : "+this.description ;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description ;
    }

    public double getPrice() {
        return this.price ;
    }

    public double getDiscountPercentage() {
        return this.discountPercentage;
    }

    public double getRating() {
        return this.rating ;
    }
}

class FormatData {

    public static FetchedData format(String data) {

        String dataSub = data.substring(data.indexOf(":")+1);
        String idStr = dataSub.substring(0,dataSub.indexOf(","));
        int id = Integer.parseInt(idStr);
        dataSub = dataSub.substring(dataSub.indexOf(":\"")+2);
        String title = dataSub.substring(0, dataSub.indexOf("\""));
        dataSub = dataSub.substring(dataSub.indexOf(":\"")+2);
        String description = dataSub.substring(0, dataSub.indexOf("\""));
        dataSub = dataSub.substring(dataSub.indexOf(":")+1);
        double price = Double.parseDouble(dataSub.substring(0, dataSub.indexOf(",")));
        dataSub = dataSub.substring(dataSub.indexOf(":")+1);
        double discountPercentage = Double.parseDouble(dataSub.substring(0, dataSub.indexOf(",")));
        dataSub = dataSub.substring(dataSub.indexOf(":")+1);
        double rating = Double.parseDouble(dataSub.substring(0, dataSub.indexOf(",")));
        System.out.println(dataSub);
        FetchedData fetchedData = new FetchedData(id,title,description,price,discountPercentage,rating);

        return fetchedData ;
    }
}


