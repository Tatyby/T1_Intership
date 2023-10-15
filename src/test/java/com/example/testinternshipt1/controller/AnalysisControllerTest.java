package com.example.testinternshipt1.controller;

import com.example.testinternshipt1.model.AnalysisRequest;
import com.example.testinternshipt1.model.AnalysisResponse;
import com.example.testinternshipt1.service.AnalysisServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AnalysisController.class)
public class AnalysisControllerTest {
    @MockBean
    private AnalysisServiceImp serviceAnalysisImp;
    private AnalysisRequest analysisRequest;
    private AnalysisResponse analysisResponse;
    private Map<String, Long> expectedMap;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        analysisRequest = new AnalysisRequest().setName("aaabbbbbc");
        expectedMap = new HashMap<>();
        expectedMap.put("a", 3L);
        expectedMap.put("b", 5L);
        expectedMap.put("c", 1L);
        analysisResponse = new AnalysisResponse().setAnalysis(expectedMap);
    }

    @Test
    public void analyzeTest() throws Exception {
        when(serviceAnalysisImp.analyze(analysisRequest))
                .thenReturn(analysisResponse);
        mockMvc.perform(post("/analyze")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(analysisRequest)))
                .andExpect(status().isCreated());
    }
}

