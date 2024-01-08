package a3lachi.dummyspring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@RestController
public class DummyspringApplication {

    @GetMapping("/listen")
    public Results listen(@RequestParam(value="audio") String audio) {
        return new Results("fkassi ma lean w "+audio);
    }

    @GetMapping("/raps")
    public RapSongs raps(String param) {
        System.out.println("hearing raps");
        String[] names = {"2024","BACKR00MS"} ;
        String[] rappers = {"Playboi Carti","Travis Scott"};
        return new RapSongs(names,rappers);
    }

    @GetMapping("/products")
    public Results products(String param) {
        return new Results("loading...");
    }

    @GetMapping(value="/nested")
    public Nested nested(@RequestParam(value="text")  String text , @RequestParam(value="stevie") String stevie) {
        Results rzlt = new Results("success");
        Random rnd = new Random("trust","the","process");
        Nested nested = new Nested(rzlt,rnd,text+" "+stevie);
        return nested;
    }

    @GetMapping("/random")
    public Random random(String param) {
        return new Random("hello","world","!");
    }

    @PostMapping("/load")
    public NestedPost load(@RequestParam("load") String load, @RequestParam("status") String status) {
        Results rzlt = new Results(load);
        NestedPost nested = new NestedPost(rzlt, status);
        return nested;
    }

    @GetMapping("/fetch")
    public FetchedData fetch(@RequestParam("id") String id) {
        // String fetched =  Fetch.FetchData("http://dummyjson.com/products/"+id);
        String fetched = "{\"id\":1,\"title\":\"iPhone 9\",\"description\":\"An apple mobile which is nothing like apple\",\"price\":549,\"discountPercentage\":12.96,\"rating\":4.69,\"stock\":94,\"brand\":\"Apple\",\"category\":\"smartphones\",\"thumbnail\":\"https://cdn.dummyjson.com/product-images/1/thumbnail.jpg\",\"images\":[\"https://cdn.dummyjson.com/product-images/1/1.jpg\",\"https://cdn.dummyjson.com/product-images/1/2.jpg\",\"https://cdn.dummyjson.com/product-images/1/3.jpg\",\"https://cdn.dummyjson.com/product-images/1/4.jpg\",\"https://cdn.dummyjson.com/product-images/1/thumbnail.jpg\"]}" ;

        if (!fetched.equals("")) {
            FetchedData fData = FormatData.format(fetched);
            return fData;
        } else {
            return null;
        }
    }


	public static void main(String[] args) {
		SpringApplication.run(DummyspringApplication.class, args);
	}

}
