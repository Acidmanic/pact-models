/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.pact.helpers;

import com.acidmanic.pact.models.EndPoint;
import com.acidmanic.pact.models.Service;
import com.acidmanic.pactmodels.Interaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author diego
 */
public class PactClassifier {

    private final Normalizer<String> defaultNormalizer = s -> s;

    public List<Service> splitByService(List<EndPoint> endpoints, NameExtractor<EndPoint> extractor) {

        return splitByService(endpoints, extractor, this.defaultNormalizer);
    }

    public List<Service> splitByService(List<EndPoint> endpoints, NameExtractor<EndPoint> extractor, Normalizer<String> nameNormalizer) {

        HashMap<String, List<EndPoint>> groupedItems = split(endpoints, extractor, nameNormalizer);

        List<Service> services = new ArrayList<>();

        for (String serviceName : groupedItems.keySet()) {

            Service service = new Service();

            List<EndPoint> groupEndpoints = groupedItems.get(serviceName);

            service.getEndpoints().addAll(groupEndpoints);

            services.add(service);
        }
        return services;
    }

    public List<EndPoint> splitByEndpoint(List<Interaction> interactions, NameExtractor<Interaction> extractor) {

        return splitByEndpoint(interactions, extractor, this.defaultNormalizer);
    }

    public List<EndPoint> splitByEndpoint(List<Interaction> interactions, NameExtractor<Interaction> extractor, Normalizer<String> nameNormalizer) {

        HashMap<String, List<Interaction>> groupedItems = split(interactions, extractor, nameNormalizer);

        List<EndPoint> endpoints = new ArrayList<>();

        for (String interactionName : groupedItems.keySet()) {

            EndPoint endpoint = new EndPoint();

            List<Interaction> groupEndpoints = groupedItems.get(interactionName);

            endpoint.getInteractions().addAll(groupEndpoints);

            endpoints.add(endpoint);
        }
        return endpoints;

    }

    public <T> HashMap<String, List<T>> split(List<T> items, NameExtractor<T> extractor) {

        return split(items, extractor, this.defaultNormalizer);
    }

    public <T> HashMap<String, List<T>> split(List<T> items, NameExtractor<T> extractor, Normalizer<String> nameNormalizer) {

        HashMap<String, List<T>> result = new HashMap<>();

        for (T item : items) {

            String name = extractor.extract(item);

            String key = nameNormalizer.normalize(name);

            if (!result.containsKey(key)) {

                result.put(key, new ArrayList<>());
            }

            List<T> currentGroup = result.get(key);

            currentGroup.add(item);
        }
        return result;
    }
}
