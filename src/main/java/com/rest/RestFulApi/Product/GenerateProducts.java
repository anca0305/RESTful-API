package com.rest.RestFulApi.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenerateProducts {
    private List<OficialProduct> products;

    private static GenerateProducts instance = null;
    public static GenerateProducts getInstance(){
        if (instance == null) {
            instance = new GenerateProducts();
        }
        return instance;
    }

    public GenerateProducts() {
        products = new ArrayList<OficialProduct>();
    }

    // return all products
    public List<OficialProduct> getProducts() {
        return products;
    }

    // return product by id
    public OficialProduct getProductById(int id) {
        for (OficialProduct p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // return product by name
    public OficialProduct getProductByName(String name) {
        for (OficialProduct p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    // return product by category
    public List<OficialProduct> getProductByCategory(String category) {
        List <OficialProduct> prod = new ArrayList<OficialProduct>();
        for (OficialProduct p : products) {
            if (p.getCategory().equals(category)) {
                prod.add(p);
            }
        }
        return prod;
    }

    // create product
    public OficialProduct createProduct(int id, String name, double price, String category) {
        Date date = new Date();
        OficialProduct newOficialProduct = new OficialProduct(id, name, price,
                category, date.toString(), date.toString());
        products.add(newOficialProduct);
        return newOficialProduct;
    }


    // update product price
    public OficialProduct updatePrice(int id, double price) {
        for (OficialProduct p : products) {
            if (p.getId() == id) {
                p.setPrice(price);
                Date date = new Date();
                p.setUpdatedDate(date.toString());
                return p;
            }
        }
        return null;
    }

    // update product name
    public OficialProduct updateName(int id, String name) {
        for (OficialProduct p : products) {
            if (p.getId() == id) {
                p.setName(name);
                Date date = new Date();
                p.setUpdatedDate(date.toString());
                return p;
            }
        }
        return null;
    }

    // update product category
    public OficialProduct updateCategory(int id, String category) {
        for (OficialProduct p : products) {
            if (p.getId() == id) {
                p.setCategory(category);
                Date date = new Date();
                p.setUpdatedDate(date.toString());
                return p;
            }
        }
        return null;
    }

    // delete product by id
    public boolean delete(int id) {
        int productIndex = -1;
        for (OficialProduct p : products) {
            if (p.getId() == id) {
                productIndex = products.indexOf(p);
                continue;
            }
        }
        if (productIndex > -1) {
            products.remove(productIndex);
            return true;
        }
        return false;
    }
}
