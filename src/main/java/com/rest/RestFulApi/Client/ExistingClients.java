package com.rest.RestFulApi.Client;


import com.rest.RestFulApi.Product.OficialProduct;

import java.util.ArrayList;
import java.util.List;

public class ExistingClients {
    private List<OficialClient> clients;

    private static ExistingClients instance = null;
    public static ExistingClients getInstance(){
        if (instance == null) {
            instance = new ExistingClients();
        }
        return instance;
    }

    public ExistingClients() {
        clients = new ArrayList<OficialClient>();
    }

    public Boolean checkUsername(String username) {
        for (OficialClient c : clients) {
            if (c.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    // create client
    public OficialClient createClient(String username, String password) {
        OficialClient newOficialClient = new OficialClient(username, password);
        clients.add(newOficialClient);
        return newOficialClient;
    }

    public OficialClient getUserByUsername(String username) {
        for (OficialClient c : clients) {
            if (c.getUsername().equals(username)) {
                return c;
            }
        }
        return null;
    }
}
