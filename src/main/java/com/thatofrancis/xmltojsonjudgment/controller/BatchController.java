package com.thatofrancis.xmltojsonjudgment.controller;

import com.thatofrancis.xmltojsonjudgment.dto.BatchRequest;
import com.thatofrancis.xmltojsonjudgment.dto.BatchResponse;
import com.thatofrancis.xmltojsonjudgment.exception.DocumentNotFoundException;
import com.thatofrancis.xmltojsonjudgment.mapper.BatchJobMapper;
import com.thatofrancis.xmltojsonjudgment.service.BatchProcessingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
@RequiredArgsConstructor
@Tag(name = "Batches", description = "Submit folders of XML files for concurrent processing")
public class BatchController {

    private final BatchProcessingService batchService;
    private final BatchJobMapper mapper;

    @Operation(summary = "Submit a folder of XML files for asynchronous batch processing")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BatchResponse> submit(@Valid @RequestBody BatchRequest request) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(mapper.toResponse(batchService.submit(request.inputDir())));
    }

    @Operation(summary = "List all batch jobs")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BatchResponse> list() {
        return batchService.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Operation(summary = "Get progress and result counts for a batch job")
    @GetMapping(value = "/{batchId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BatchResponse status(@PathVariable String batchId) {
        return batchService.findById(batchId)
                .map(mapper::toResponse)
                .orElseThrow(() -> new DocumentNotFoundException(batchId));
    }
}
