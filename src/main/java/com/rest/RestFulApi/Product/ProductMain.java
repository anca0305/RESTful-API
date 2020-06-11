package com.rest.RestFulApi.Product;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
public class ProductMain {
    Date date = new Date();
    GenerateProducts myProducts = GenerateProducts.getInstance();

    @GetMapping("/Store/MyStore")
    public String getHelloPage() {
        return "Hello! :)";
    }

    @GetMapping("/Store/MyStore/Products")
    public String getProducts() {
        if (myProducts.getProducts().size() == 0) {
            return "You have no products yet. Add some if you want!";
        }
        return "Here are your products: \n"
                + myProducts.getProducts().toString();
    }

    @GetMapping("/Store/MyStore/Products/Id={id}")
    public String getProductById(@PathVariable String id) {
            if (myProducts.getProductById(Integer.parseInt(id)) == null) {
                return "There is no product with this id!";
            }
            return "Here is your product based on your search:\n"
                    + myProducts.getProductById(Integer.parseInt(id)).toString();
    }

    @GetMapping("/Store/MyStore/Products/Name={name}")
    public String getProductByName(@PathVariable String name) {
        if (myProducts.getProductByName(name) == null) {
            return "There is no product with this name!";
        }
        return "Here is your product based on your search:\n"
                + myProducts.getProductByName(name).toString();
    }

    @GetMapping("/Store/MyStore/Products/Category={category}")
    public String getProductByCategory(@PathVariable String category) {
        if (myProducts.getProductByCategory(category).size() == 0) {
            return "There are no products in this category!";
        }
        return "Here are your products based on the selected category = "
                + category + ":\n" + myProducts.getProductByCategory(category).toString();
    }

    @PostMapping("/Store/MyStore/Products")
    public String create(@RequestBody Map<String, String> body) {
        int id = myProducts.getProducts().size() + 1;
        String name = body.get("name");
        double price = Double.parseDouble(body.get("price"));
        String category = body.get("category");
        return myProducts.createProduct(id, name, price, category).toString();
    }

    @DeleteMapping("/Store/MyStore/Products/{id}")
    public String delete(@PathVariable String id) {
        int productId = Integer.parseInt(id);
        if (myProducts.delete(productId)) {
            return "You have successfully deleted this product!";
        }
        return "There is no product with this id. Try again!";
    }

    @PutMapping("/Store/MyStore/Products/{id}")
    public String update(@PathVariable String id, @RequestBody Map<String, String> body){
        int idIndex = Integer.parseInt(body.get("id"));
        if (myProducts.getProducts().size() == 0) {
            return "There are no products at all!";
        }
        int ok = 0;
        for (OficialProduct p : myProducts.getProducts()) {
            if (p.getId() == idIndex) {
                ok = 1;
                continue;
            }
        }
        if (ok == 0) {
            return "There is no product with this id. Try again!";
        }
        String name = body.get("name");
        String category = body.get("category");
        if (name != null) {
            return "Here is your updated product:\n"
                    + myProducts.updateName(idIndex, name).toString();
        } else if (category != null) {
            return "Here is your updated product:\n"
                    + myProducts.updateCategory(idIndex, category).toString();
        } else {
            double price = Double.parseDouble(body.get("price"));
            return "Here is your updated product:\n"
                    + myProducts.updatePrice(idIndex, price).toString();
        }
    }
}
