package a3lachi.dummyspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetFetch {

  @ResponseBody
  @GetMapping("/products")
    public FetchedData fetch(@RequestParam("id") String id) {
        String fetched =  Fetch.FetchData("http://dummyjson.com/products/"+id);
        if (!fetched.equals("")) {
            FetchedData fData = FormatData.format(fetched);
            return fData;
        } else {
            return null;
        }
    }
  
}