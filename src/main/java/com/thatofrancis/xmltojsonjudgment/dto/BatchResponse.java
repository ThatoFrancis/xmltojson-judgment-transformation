package com.thatofrancis.xmltojsonjudgment.dto;

import com.thatofrancis.xmltojsonjudgment.constant.BatchStatus;

import java.time.Instant;

public record BatchResponse(
        String batchId,
        BatchStatus status,
        String inputDir,
        int totalFiles,
        int published,
        int rejected,
        int duplicates,
        int failed,
        Instant submittedAt,
        Instant completedAt) {
}
