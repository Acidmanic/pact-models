/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.pact.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author diego
 */
public class DataPath {

    private ArrayList<String> segments;

    public DataPath() {
        this.segments = new ArrayList<>();
    }

    public boolean isRelative() {

        return this.segments.isEmpty() || !"$".equals(this.segments.get(0));
    }

    public String getObjectName() {

        if (isRelative()) {

            return null;
        }
        return this.segments.get(1);
    }

    public DataPath relativizeToBaseObject() {

        DataPath relative = new DataPath();

        relative.segments.addAll(this.segments);

        if (this.isRelative()) {

            return relative;
        }
        //remove $ and object name
        relative.segments.remove(0);
        if (!relative.segments.isEmpty()) {
            relative.segments.remove(0);
        }
        return relative;
    }

    @Override
    public String toString() {

        String path = "";

        String sep = "";

        for (String segment : this.segments) {

            path += sep + segment;

            sep = ".";
        }
        return path;
    }

    public boolean pointsToWholeObject() {

        return !isRelative() && this.segments.size() == 2;
    }

    public DataPath fromString(String path) {

        String[] pathSegments = path.split("\\.");

        this.segments = new ArrayList<>();

        this.segments.addAll(Arrays.asList(pathSegments));

        return this;
    }

    public List<String> getSegments() {

        ArrayList<String> pathSegments = new ArrayList<>();

        pathSegments.addAll(this.segments);

        return pathSegments;
    }

    public DataPath subPath(int start, int end) {

        int length = end - start;

        if (start < 0 || length < 0) {
            return new DataPath();
        }
        DataPath sub = new DataPath();

        sub.segments = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            sub.segments.add(this.segments.get(start + i));
        }
        return sub;
    }

    public int getSegmentsCount() {

        return this.segments.size();
    }
}
