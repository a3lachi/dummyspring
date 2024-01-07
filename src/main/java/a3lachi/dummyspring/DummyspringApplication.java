package a3lachi.dummyspring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DummyspringApplication {

    @GetMapping("/listen")
    public Results listen(@RequestParam(value="audio") String audio) {
        return new Results("fkassi ma lean w "+audio);
    }

    @GetMapping("/raps")
    public RapSongs raps(String param) {
        String[] names = {"2024","BACKR00MS"} ;
        String[] rappers = {"Playboi Carti","Travis Scott"};
        return new RapSongs(names,rappers);
    }

    @GetMapping("/products")
    public Results products(String param) {
        return new Results("loading...");
    }

    @GetMapping(value="/nested")
    public @ResponseBody Nested nested(@RequestParam(value="text")  String text , @RequestParam(value="stevie") String stevie) {
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

	public static void main(String[] args) {
		SpringApplication.run(DummyspringApplication.class, args);
	}

}
