package com.example.testinternshipt1.service;

import com.example.testinternshipt1.model.AnalysisRequest;
import com.example.testinternshipt1.model.AnalysisResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
@RequiredArgsConstructor
public class ServiceAnalysisImp implements ServiceAnalysis {
    @Override
    public AnalysisResponse analyze(AnalysisRequest analysisRequest) {
        String lowerCaseName = analysisRequest.getName().toLowerCase();
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (char c : lowerCaseName.toCharArray()) {
            String character = String.valueOf(c);
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }
        frequencyMap = sortByFrequency(frequencyMap);
        return new AnalysisResponse().setAnalysis(frequencyMap);
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortByFrequency(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Map<K, V> result = new LinkedHashMap<>();
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}
