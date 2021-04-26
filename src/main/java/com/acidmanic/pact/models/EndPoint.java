/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.pact.models;

import com.acidmanic.pactmodels.Interaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class EndPoint {

    private List<Interaction> interactions;

    public EndPoint() {
        this.interactions = new ArrayList<>();
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<Interaction> interactions) {
        this.interactions = interactions;
    }
}
