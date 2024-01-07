package com.example.dummy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;



class Results {
    
    String text ;

    public Results(String text) {
        this.text = text ;
    }

    public String getText() {
        return this.text ;
    }

    void setText(String text) {
        this.text = text ;
    }
}


class RapSongs {
    String[] names ;
    String[] rappers;

    public RapSongs(String[] names , String[] rappers) {
        this.names = names ;
        this.rappers = rappers ;
    }

    public String[] getNames() {
        return this.names;
    }

    public String[] getRappers() {
        return this.rappers;
    }
}


class Random {
    String one;
    String two;
    String three;

    public Random(String one, String two, String three) {
        this.one = one ;
        this.two = two ;
        this.three = three ;
    }

    public String getOne() {
        return this.one;
    }

    public String getTwo() {
        return this.two ;
    }

    public String getThree() {
        return this.three; 
    }

    public void setOne(String one) {
        this.one = one ;
    }

    public void setTwo(String two) {
        this.two = two ;
    }

    public void setThree(String three) {
        this.three = three ;
    }
}


class Nested {

    Results rzlt;
    Random rnd ;
    String str ;

    public Nested(Results rzlt , Random rnd, String str) {
        this.rzlt = rzlt ;
        this.rnd = rnd ;
        this.str = str ;
    }

    public String getStr() {
        return this.str ;
    }

    public Results getRzlt() {
        return this.rzlt ;
    }

    public void setRzlt(Results rzlt) {
        this.rzlt = rzlt ;
    }

    public Random getRnd() {
        return this.rnd ;
    }
}

class NestedPost {
    Results load ;
    String status ;

    public NestedPost(Results load, String status) {
        this.load = load ;
        this.status = status ;
    }

    public Results getLoad() {
        return this.load;
    }

    public String getStatus() {
        return this.status ;
    }
}

class FetchData {

    String data ;

    public FetchData() {

        String apiUrl = "http://dummyjson.com/products/1";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(apiUrl))
            .build();

        CompletableFuture<String> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        // Retrieve the fetched data from the CompletableFuture
        future.thenAccept(data -> {
            // Use the fetched data here or store it in a variable
            String fetchedData = data;
            System.out.println("Fetched Data: " + fetchedData);

            // You can use the 'fetchedData' String elsewhere in your code
            // ...
        });

        // Wait for the response to be processed before exiting
        future.join();

        // client.sendAsync(request, BodyHandlers.ofString())
        //     .thenApply(HttpResponse::body)
        //     .thenAccept(System.out::println)
        //     .join();



        // URI uri = Paths.get(apiUrl).toUri() ;
        // URL url = uri.toURL();
        // // URL url = new URL(apiUrl);
        // URL varz = new URL("http://example.com");

        // HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // connection.setRequestMethod("GET");
        // int responseCode = connection.getResponseCode();
        // if (responseCode == HttpURLConnection.HTTP_OK) {
        //     BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        //     String inputLine;
        //     StringBuilder response = new StringBuilder();

        //     while ((inputLine = in.readLine()) != null) {
        //         response.append(inputLine);
        //     }
        //     in.close();

        //     // Process the response data here (contained in response.toString())
        //     System.out.println("Response: " + response.toString());
        // } else {
        //     System.out.println("Error: Unable to fetch data. Response code: " + responseCode);
        // }
        // connection.disconnect();
    }
}


