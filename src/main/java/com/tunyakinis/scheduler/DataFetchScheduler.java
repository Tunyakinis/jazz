package com.tunyakinis.scheduler;

import com.tunyakinis.service.DataFetchService;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;

@Singleton
public class DataFetchScheduler {

  private final DataFetchService dataFetchService;

  public DataFetchScheduler(DataFetchService dataFetchService) {
    this.dataFetchService = dataFetchService;
  }

  @Scheduled(fixedDelay = "${myapp.schedule.fetch-data-delay}")
  public void scheduleFetchData() {
    dataFetchService.fetchData();
  }
}