package com.etl.handler.impl.instant;

import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import com.etl.handler.impl.Instant.SnowfallInstantConversionHandler;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class SnowfallInstantConversionHandlerTest {
    @Autowired
    private SnowfallInstantConversionHandler handler;

    @Test
    @DisplayName("Проверка то что handler преобразуют поле")
    void conversion() {
        WeatherReportDto weatherReportDto = Instancio.create(WeatherReportDto.class);
        GeneralWeatherDto generalWeatherDto = Instancio.create(GeneralWeatherDto.class);

        handler.conversion(weatherReportDto, generalWeatherDto);

        assertThat(weatherReportDto.getGeneralMetrics().getSnowfallMmPerS()).isNotNull();
    }
}