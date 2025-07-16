package com.example.demo.entity;

import com.example.demo.dto.DailyUnits;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.from;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DailyUnitsTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    @DisplayName("Сущность DailyUnits конвертируется в json успешно")
    public void jsonToEntityTest() {
        String json = """
                 {
                    "time": "unixtime",
                     "sunrise": "unixtime",
                     "sunset": "unixtime",
                     "daylight_duration": "s"
                 } 
                """;

        DailyUnits dailyUnits = objectMapper.readValue(json, DailyUnits.class);

        assertThat(dailyUnits)
                .returns("unixtime",from(DailyUnits::getTime))
                .returns("unixtime",from(DailyUnits::getSunrise))
                .returns("unixtime",from(DailyUnits::getSunset))
                .returns("s",from(DailyUnits::getDaylightDuration));
    }
}