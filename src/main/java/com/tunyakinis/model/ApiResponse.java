package com.tunyakinis.model;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public class ApiResponse {

  @Id
  private Long id;
  private Long callTime;
  private int dataLength;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCallTime() {
    return callTime;
  }

  public void setCallTime(Long callTime) {
    this.callTime = callTime;
  }

  public int getDataLength() {
    return dataLength;
  }

  public void setDataLength(int dataLength) {
    this.dataLength = dataLength;
  }
}
