/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.pact.models;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author diego
 */
public class RequestPath {
    
    
    private HashMap<String,String> parameters;
    private List<String> uriPath;

    public List<String> getUriPath() {
        return uriPath;
    }

    public void setUriPath(List<String> uriPath) {
        this.uriPath = uriPath;
    }
    
    public RequestPath() {
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }

    
    
    
}
