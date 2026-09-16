package com.thatofrancis.xmltojsonjudgment.dto;

public record DiagnosticDto(String severity, int line, int column, String message) {
}
