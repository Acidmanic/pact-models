/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.pact.models;

import com.acidmanic.pactmodels.Contract;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class Pact {

    private List<Contract> contracts;

    public Pact() {
        this.contracts = new ArrayList<>();
    }

    public Pact(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

}
