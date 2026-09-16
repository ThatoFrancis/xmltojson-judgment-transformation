package com.thatofrancis.xmltojsonjudgment.dto;

import jakarta.validation.constraints.NotBlank;

public record BatchRequest(@NotBlank String inputDir) {
}
