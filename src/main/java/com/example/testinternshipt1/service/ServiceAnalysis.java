package com.example.testinternshipt1.service;

import com.example.testinternshipt1.model.AnalysisRequest;
import com.example.testinternshipt1.model.AnalysisResponse;
public interface ServiceAnalysis {
    AnalysisResponse analyze(AnalysisRequest analysisRequest);
}
