/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.pact.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class Service {

    private List<EndPoint> endpoints;

    public Service() {

        this.endpoints = new ArrayList<>();
    }

    public List<EndPoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<EndPoint> endpoints) {
        this.endpoints = endpoints;
    }

}
