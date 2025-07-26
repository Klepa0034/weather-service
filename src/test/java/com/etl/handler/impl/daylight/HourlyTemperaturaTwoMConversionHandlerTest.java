package com.etl.handler.impl.daylight;

import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class HourlyTemperaturaTwoMConversionHandlerTest {

    @Autowired
    private HourlyTemperaturaTwoMConversionHandler hourlyTemperaturaTwoMConversionHandler;

    @Test
    @DisplayName("Проверка то что handler преобразуют поле")
    void conversion() {
        WeatherReportDto weatherReportDto = Instancio.create(WeatherReportDto.class);
        GeneralWeatherDto generalWeatherDto = Instancio.create(GeneralWeatherDto.class);

        hourlyTemperaturaTwoMConversionHandler.conversion(weatherReportDto, generalWeatherDto);

        assertThat(weatherReportDto.getAvgDaylightReport().getTemperatureTwoMCelsiusDaylight()).isNotNull();

    }
}