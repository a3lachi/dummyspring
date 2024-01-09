package a3lachi.dummyspring;
import java.util.ArrayList;
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
                .GET()  
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
    int stock;
    String brand;
    String category;
    String thumbnail;
    // String[] images ;
    ArrayList<String> images ;

    public FetchedData(int id, String title, String description, double price,double discountPercentage, double rating , int stock, String brand,String category, String thumbnail , ArrayList<String> images ) {
        this.id = id;
        this.title = title ;
        this.description = description ;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating ;
        this.stock = stock ;
        this.brand = brand ;
        this.category = category ;
        this.thumbnail = thumbnail ;
        this.images = images ;
    }

    // public String[] getImages() {
    //     return this.images ;
    // }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public String getCategory() {
        return this.category ;
    }

    public String toString() {
        return "id : "+this.id+", title : "+this.title+", description : "+this.description ;
    }

    public String getBrand() {
        return this.brand ;
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

    public int getStock() {
        return this.stock;
    }

    public ArrayList<String> getImages() {
        return this.images ;
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
        dataSub = dataSub.substring(dataSub.indexOf(":")+1);
        int stock = Integer.parseInt(dataSub.substring(0, dataSub.indexOf(",")));
        dataSub = dataSub.substring(dataSub.indexOf(":")+2);
        String brand = dataSub.substring(0, dataSub.indexOf("\""));
        dataSub = dataSub.substring(dataSub.indexOf(":")+2);
        String category = dataSub.substring(0, dataSub.indexOf("\""));
        dataSub = dataSub.substring(dataSub.indexOf(":")+2);
        String thumbnail = dataSub.substring(0, dataSub.indexOf("\""));

        // String[] images = {"image 1", "image 2"};

        dataSub = dataSub.substring(dataSub.indexOf("[")+1);

        ArrayList<String> images = new ArrayList<>();

        while (dataSub.indexOf(",")>-1) {
            String pStr = dataSub.substring(1, dataSub.indexOf(",")-1);
            images.add(pStr);
            dataSub = dataSub.substring(dataSub.indexOf(",")+1);
        }

        String pStr = dataSub.substring(1, dataSub.indexOf("]")-1);
        images.add(pStr);
        System.out.println(images);

        FetchedData fetchedData = new FetchedData(id,title,description,price,discountPercentage,rating,stock,brand,category,thumbnail,images);

        return fetchedData ;
    }
}


