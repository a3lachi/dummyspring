package a3lachi.dummyspring;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList ;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


class CartProducts {
    int id ;
    String title ;
    int price ;
    int quantity ;
    int total ;
    float discountPercentage ;
    int discountedPrice ;
    String thumbnail ;


   public CartProducts( int id , String title, int price , int quantity, int total, float discountPercentage, int discountedPrice, String thumbnail) {
    this.thumbnail = thumbnail ;
    this.discountedPrice = discountedPrice ;
    this.discountPercentage = discountPercentage ;
    this.total = total ;
    this.id = id ;
    this.title = title;
    this.price = price;
    this.quantity = quantity ;
   } 

   public String geTthumbnail() {
    return this.thumbnail ;
   }

   public int getDiscountedPrice() {
    return this.discountedPrice ;
   }

   public float getDiscountPercentage(){
    return this.discountPercentage ;
   }

   public int getTotal() {
    return this.total ;
   }

   public int getQuantity() {
    return this.quantity ;
   }
   public int getId() {
    return this.id;
   }
   public String getTitle() {
    return this.title ;
   }
   public int getPrice() {
    return this.price;
   }
}

class CartData {
    int id;
    ArrayList<CartProducts> products ;
    int total ;
    int discountedTotal ;
    int userId ;
    int totalProducts ;
    int totalQuantity ;

    public CartData(int id , ArrayList<CartProducts> products, int total, int discountedTotal, int userId, int totalProducts , int totalQuantity) {
        this.totalQuantity = totalQuantity ;
        this.totalProducts = totalProducts ;
        this.userId = userId ;
        this.discountedTotal = discountedTotal ;
        this.total = total ;
        this.id = id;
        this.products = products ;
    }

    public int getTotalQuantity() {
        return this.totalQuantity ;
    }

    public int getTotalProducts() {
        return this.totalProducts ;
    }

    public int getUserId() {
        return this.userId ;
    }

    public int getDiscountedTotal() {
        return this.discountedTotal ;
    }

    public int getTotal() {
        return this.total ;
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
