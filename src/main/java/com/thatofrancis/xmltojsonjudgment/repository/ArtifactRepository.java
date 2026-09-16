package com.thatofrancis.xmltojsonjudgment.repository;

import com.thatofrancis.xmltojsonjudgment.constant.ArtifactType;

import java.util.Optional;

public interface ArtifactRepository {

    void store(String contentId, ArtifactType type, String content, String collection);

    Optional<String> retrieve(String contentId, ArtifactType type, String collection);
}
