package com.example.testinternshipt1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnalysisResponse {
    @Schema(description = "Частота встречи символов по заданной строке")
    private Map<String, Long> analysis;
    @Schema(description = "Ошибки валидации")
    private List<String> errors;

}
