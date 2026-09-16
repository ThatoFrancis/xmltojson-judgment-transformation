package com.thatofrancis.xmltojsonjudgment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thatofrancis.xmltojsonjudgment.constant.ProcessingStatus;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DocumentResponse(
        String contentId,
        ProcessingStatus status,
        String contentHash,
        Instant receivedAt,
        Instant publishedAt,
        boolean duplicate,
        List<DiagnosticDto> diagnostics) {
}
