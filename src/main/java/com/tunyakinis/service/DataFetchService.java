package com.tunyakinis.service;

import com.tunyakinis.client.VossClient;
import com.tunyakinis.mapper.ApiResponseMapper;
import com.tunyakinis.model.ApiResponse;
import com.tunyakinis.model.ApiResponseDto;
import io.micronaut.scheduling.annotation.Scheduled;
import io.micronaut.serde.annotation.SerdeImport;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SerdeImport(ApiResponseDto.class)
@Singleton
public class DataFetchService {

  private static final Logger LOG = LoggerFactory.getLogger(DataFetchService.class);

  @Inject
  private VossClient client;

  @Inject
  private DataPersistenceService dataPersistenceService;

  @Inject
  private ApiResponseMapper mapper;

  public DataFetchService(VossClient client, DataPersistenceService dataPersistenceService,
      ApiResponseMapper mapper) {
    this.client = client;
    this.dataPersistenceService = dataPersistenceService;
    this.mapper = mapper;
  }

  @Scheduled(fixedDelay = "${myapp.schedule.fetch-data-delay}")
  public void fetchData() {
    try {
      ApiResponseDto response = client.getData();
      ApiResponse apiResponse = mapResponseToApiEntity(response);
      dataPersistenceService.saveData(apiResponse);
    } catch (Exception e) {
      LOG.error("Error occurred while fetching data from Voss service: {}", e.getMessage(), e);
    }
  }

  private ApiResponse mapResponseToApiEntity(ApiResponseDto responseDto) {
    if (responseDto == null) {
      LOG.warn("No data provided by Voss service, voss service is unavailable");
    }

    return responseDto != null ? mapper.toApiResponse(responseDto) : null;
  }
}