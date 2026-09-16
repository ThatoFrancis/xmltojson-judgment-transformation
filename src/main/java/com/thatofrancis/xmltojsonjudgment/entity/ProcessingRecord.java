package com.thatofrancis.xmltojsonjudgment.entity;

import com.thatofrancis.xmltojsonjudgment.constant.ProcessingStatus;
import com.thatofrancis.xmltojsonjudgment.dto.DiagnosticDto;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class ProcessingRecord {

    private String contentId;
    private ProcessingStatus status;
    private String contentHash;
    private String collection;
    private Instant receivedAt;
    private Instant publishedAt;
    private List<DiagnosticDto> diagnostics;
}
