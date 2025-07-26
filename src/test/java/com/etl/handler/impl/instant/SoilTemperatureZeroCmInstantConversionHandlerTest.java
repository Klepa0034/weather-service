package com.etl.handler.impl.instant;

import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import com.etl.handler.impl.Instant.SoilTemperatureZeroCmInstantConversionHandler;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class SoilTemperatureZeroCmInstantConversionHandlerTest {
    @Autowired
    private SoilTemperatureZeroCmInstantConversionHandler handler;

    @Test
    @DisplayName("Проверка то что handler преобразуют поле")
    void conversion() {
        GeneralWeatherDto generalWeatherDto = Instancio.create(GeneralWeatherDto.class);
        WeatherReportDto weatherReportDto = Instancio.create(WeatherReportDto.class);

        handler.conversion(weatherReportDto, generalWeatherDto);

        assertThat(weatherReportDto.getGeneralMetrics().getSoilTemperatureZeroCmPerS()).isNotNull();
    }
}