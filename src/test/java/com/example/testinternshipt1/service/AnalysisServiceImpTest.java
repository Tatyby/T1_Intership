package com.example.testinternshipt1.service;

import com.example.testinternshipt1.model.AnalysisRequest;
import com.example.testinternshipt1.model.AnalysisResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = {AnalysisServiceImp.class})
@ExtendWith(MockitoExtension.class)
public class AnalysisServiceImpTest {

    @Autowired
    private AnalysisServiceImp serviceTestImp;
    private AnalysisResponse analysisResponse;
    private AnalysisRequest analysisRequest;

    @BeforeEach
    void setUp() {
        analysisRequest = new AnalysisRequest().setName("aaabbbbbc");
    }

    @Test
    public void analyzeTestNotNull() {
        analysisResponse = serviceTestImp.analyze(analysisRequest);
        Assertions.assertNotNull(analysisResponse.getAnalysis());
    }

    @Test
    public void analyzeTest() {
        analysisResponse = serviceTestImp.analyze(analysisRequest);
        Map<String, Long> expectedMap = new HashMap<>();
        expectedMap.put("a", 3L);
        expectedMap.put("b", 5L);
        expectedMap.put("c", 1L);
        Assertions.assertEquals(expectedMap, analysisResponse.getAnalysis());
    }

    @Test
    public void analyzeTestSort() {
        analysisResponse = serviceTestImp.analyze(analysisRequest);
        List<Map.Entry<String, Long>> entryList = new ArrayList<>(analysisResponse.getAnalysis().entrySet());
        for (int i = 1; i < entryList.size(); i++) {
            Map.Entry<String, Long> prevEntry = entryList.get(i - 1);
            Map.Entry<String, Long> currentEntry = entryList.get(i);
            Assertions.assertTrue(prevEntry.getValue() >= currentEntry.getValue());
        }

    }
}
