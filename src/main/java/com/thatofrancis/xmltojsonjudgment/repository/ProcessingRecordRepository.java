package com.thatofrancis.xmltojsonjudgment.repository;

import com.thatofrancis.xmltojsonjudgment.entity.ProcessingRecord;

import java.util.Collection;
import java.util.Optional;

public interface ProcessingRecordRepository {

    ProcessingRecord save(ProcessingRecord record);

    Optional<ProcessingRecord> findByContentId(String contentId);

    Collection<ProcessingRecord> findAll();
}
