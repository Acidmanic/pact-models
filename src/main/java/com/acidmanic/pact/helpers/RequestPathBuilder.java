/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.pact.helpers;

import com.acidmanic.pact.models.RequestPath;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author diego
 */
public class RequestPathBuilder {

    public String stripParameters(String pathString) {

        if (pathString.contains("?")) {

            int st = pathString.indexOf("?");

            pathString = pathString.substring(0, st);
        }
        return pathString;
    }

    public RequestPath build(String pathString) {

        RequestPath requestPath = new RequestPath();

        requestPath.setParameters(new HashMap<>());

        String query = "";

        if (pathString.contains("?")) {

            int st = pathString.indexOf("?");

            query = pathString.substring(st + 1, pathString.length());

            pathString = pathString.substring(0, st);
        }
        if (!query.isEmpty()) {

            String[] segments = query.split("&");

            for (String segment : segments) {
                String name = segment;
                String value = "";
                if (segment.contains("=")) {
                    int st = segment.indexOf("=");
                    name = segment.substring(0, st);
                    value = segment.substring(st + 1, segment.length());
                }
                requestPath.getParameters().put(name, value);
            }
        }
        String[] uriSegments = pathString.split("/");

        requestPath.setUriPath(new ArrayList<>());

        for (String segment : uriSegments) {

            if (segment != null && segment.length() > 0) {

                requestPath.getUriPath().add(segment);
            }
        }
        return requestPath;
    }
}
