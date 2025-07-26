package com.etl.handler;

import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;

public interface ConversionHandler {
    void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto);

}
