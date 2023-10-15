package com.example.testinternshipt1.controller;

import com.example.testinternshipt1.model.AnalysisRequest;
import com.example.testinternshipt1.model.AnalysisResponse;
import com.example.testinternshipt1.service.AnalysisServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Analysis REST API")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AnalysisController {

    private final AnalysisServiceImp serviceAnalysis;

    @Operation(summary = "Получение частоты символов во входящей строке")
    @PostMapping(value = "/analyze", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AnalysisResponse> analyze(@Valid @RequestBody AnalysisRequest analysisRequest, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(new AnalysisResponse().setErrors(errorMessages), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(serviceAnalysis.analyze(analysisRequest), HttpStatus.CREATED);
    }

}
