package com.tunyakinis.mapper;

import com.tunyakinis.model.ApiResponse;
import com.tunyakinis.model.ApiResponseDto;
import jakarta.inject.Singleton;

@Singleton
public class ApiResponseMapper {

  public ApiResponse toApiResponse(ApiResponseDto dto) {
    ApiResponse apiResponse = new ApiResponse();

    apiResponse.setId(dto.getId());
    apiResponse.setCallTime(System.currentTimeMillis());
    apiResponse.setDataLength(dto.getData().length());

    return apiResponse;
  }
}