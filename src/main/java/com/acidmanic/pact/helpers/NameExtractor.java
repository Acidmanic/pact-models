/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.pact.helpers;

/**
 *
 * @author diego
 * @param <TSourceData> Type of the data, that the implementation should extract
 * the name of one specific parameter from this data. For example the sourceData
 * might be of type Interaction and the implementation be supposed to extract
 * the endpoint name from the interaction instance.
 */
public interface NameExtractor<TSourceData> {

    String extract(TSourceData sourceData);
}
