package com.example.testinternshipt1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisRequest {
    @Schema(description = "Значение входящей строки")
    @JsonProperty("name")
    @Pattern(regexp = "[a-zA-Z]+$", message = "{valid.pattern}")
    @Size(min = 3, max = 100, message = "{valid.size}")
    @NotBlank(message = "{valid.notBlank}")
    private String name;
}
