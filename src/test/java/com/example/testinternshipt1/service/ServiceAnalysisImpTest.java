package com.example.testinternshipt1.service;

import com.example.testinternshipt1.model.AnalysisRequest;
import com.example.testinternshipt1.model.AnalysisResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class ServiceAnalysisImpTest {
    @InjectMocks
    private ServiceAnalysisImp serviceTestImp;
    private AnalysisRequest analysisRequest;
    private AnalysisResponse analysisResponse;

    @BeforeEach
    void setUp() {
        analysisRequest = new AnalysisRequest().setName("aaabbbbbc");
        analysisResponse = serviceTestImp.analyze(analysisRequest);
    }

    @Test
    public void analyzeTestNotNull() {
        Assertions.assertNotNull(analysisResponse.getAnalysis());
    }

    @Test
    public void analyzeTest() {
        Map<String, Long> expectedMap = new HashMap<>();
        expectedMap.put("a", 3L);
        expectedMap.put("b", 5L);
        expectedMap.put("c", 1L);
        Assertions.assertEquals(expectedMap, analysisResponse.getAnalysis());
    }

    @Test
    public void analyzeTestSort() {
        List<Map.Entry<String, Long>> entryList = new ArrayList<>(analysisResponse.getAnalysis().entrySet());
        for (int i = 1; i < entryList.size(); i++) {
            Map.Entry<String, Long> prevEntry = entryList.get(i - 1);
            Map.Entry<String, Long> currentEntry = entryList.get(i);
            Assertions.assertTrue(prevEntry.getValue() >= currentEntry.getValue());
        }

    }
}
