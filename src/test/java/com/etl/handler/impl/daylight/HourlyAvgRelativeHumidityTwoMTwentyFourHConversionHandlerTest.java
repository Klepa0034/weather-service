package com.etl.handler.impl.daylight;

import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class HourlyAvgRelativeHumidityTwoMTwentyFourHConversionHandlerTest {
    @Autowired
    private HourlyAvgRelativeHumidityTwoMTwentyFourHConversionHandler handler;

    @Test
    @DisplayName("Проверка то что handler преобразуют поле")
    void conversion() {
        WeatherReportDto weatherReportDto = Instancio.create(WeatherReportDto.class);
        GeneralWeatherDto generalWeatherDto = Instancio.create(GeneralWeatherDto.class);

        handler.conversion(weatherReportDto, generalWeatherDto);

        System.out.println(weatherReportDto.getAvgDaylightReport().getRelativeHumidityTwoMDaylight());
        System.out.println(generalWeatherDto.getHourlyDto().getRelativeHumidityTwoM());
    }
}