package com.tunyakinis.service;

import com.tunyakinis.model.ApiResponse;
import com.tunyakinis.repository.ApiResponseRepository;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class DataPersistenceService {

  private static final Logger LOG = LoggerFactory.getLogger(DataPersistenceService.class);

  private final ApiResponseRepository repository;

  public DataPersistenceService(ApiResponseRepository repository) {
    this.repository = repository;
  }

  public void saveData(ApiResponse apiResponse) {
    try {
      repository.save(apiResponse);
    } catch (Exception e) {
      LOG.error("Error saving data to the database", e);
    }
  }
}
