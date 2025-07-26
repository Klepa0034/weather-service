package com.etl.handler.impl.daily;

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
class VisibilityDayLightConversionHandlerTest {

    @Autowired
    private VisibilityDayLightConversionHandler handler;

    @Test
    @DisplayName("Проверка то что handler преобразуют поле")
    void conversion() {
        WeatherReportDto weatherReportDto = Instancio.create(WeatherReportDto.class);
        GeneralWeatherDto generalWeatherDto = Instancio.create(GeneralWeatherDto.class);

        handler.conversion(weatherReportDto, generalWeatherDto);

        assertThat(weatherReportDto.getAvgDailyReport().getAvgVisibilityTwentyFourH()).isNotNull();
    }
}