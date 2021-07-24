/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.pact.helpers;

/**
 *
 * @author diego
 * @param <T> the type of the incoming data to be normalized
 */
public interface Normalizer<T> {

    T normalize(T value);
}
