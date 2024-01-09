package a3lachi.dummyspring;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList ;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

class CartProducts {
    int id ;
    String title ;

   public CartProducts( int id , String title) {
    this.id = id ;
    this.title = title;
   } 

   public int getId() {
    return this.id;
   }
   public String getTitle() {
    return this.title ;
   }
}


class CartData {
    int id;
    ArrayList<CartProducts> products ;

    public CartData(int id , ArrayList<CartProducts> products) {
        this.id = id;
        this.products = products ;
    }

    public int getId() {
        return this.id ;
    }

    public ArrayList<CartProducts> getProducts() {
        return this.products;
    }
}



@RestController
public class GetCart {

    @ResponseBody
    @GetMapping("/cart")
    public CartData cart(@RequestParam("id") String id) {
        String fetched =  Fetch.FetchData("http://dummyjson.com/carts/"+id);
        if (!fetched.equals("")) {
            CartData fData = FormatData.formatCart(Integer.parseInt(id),fetched);
            return fData;
        } else {
            return null;
        }
    }
    
}
