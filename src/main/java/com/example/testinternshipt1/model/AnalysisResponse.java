package com.example.testinternshipt1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Accessors(chain = true)
public class AnalysisResponse {
    @Schema(description = "Частота встречи символов по заданной строке")
    private Map<String, Long> analysis;
}
