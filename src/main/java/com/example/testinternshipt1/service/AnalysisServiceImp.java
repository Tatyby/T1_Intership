package com.example.testinternshipt1.service;

import com.example.testinternshipt1.model.AnalysisRequest;
import com.example.testinternshipt1.model.AnalysisResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalysisServiceImp implements AnalysisService {
    @Override
    public AnalysisResponse analyze(AnalysisRequest analysisRequest) {
        String lowerCaseName = analysisRequest.getName().toLowerCase();
        Map<String, Long> frequencyMap = lowerCaseName.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new AnalysisResponse().setAnalysis(sortByFrequency(frequencyMap));
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortByFrequency(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}
