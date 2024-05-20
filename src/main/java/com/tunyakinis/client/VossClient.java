package com.tunyakinis.client;

import com.tunyakinis.model.ApiResponseDto;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("${voss.url}")
public interface VossClient {

  @Get()
  ApiResponseDto getData();
}
