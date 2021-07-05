/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.pact.helpers;

import com.acidmanic.pact.models.DataPath;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author diego
 */
public class DataReader {

    public Object read(LinkedHashMap data, DataPath path) {

        List<String> segments = path.getSegments();

        int index = 1;

        if (path.isRelative()) {
            index = 0;
        }

        LinkedHashMap currentData = data;

        while (index < segments.size()) {

            String segment = segments.get(index);

            if (currentData.containsKey(segment)) {

                Object value = currentData.get(segment);

                if (index == segments.size() - 1) {

                    return value;
                }
                if (value instanceof LinkedHashMap) {

                    currentData = (LinkedHashMap) value;
                } else {

                    return null;
                }
            } else {
                return null;
            }
            index += 1;
        }
        return null;
    }
}
