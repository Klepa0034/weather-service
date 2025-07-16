package com.example.demo.entity;

import com.example.demo.dto.GeneralInformation;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.TimeZone;

import static org.assertj.core.api.Assertions.from;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GeneralInformationTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    @DisplayName("Сущность GeneralInformation конвертируется в json успешно")
    public void jsonToEntityTest(){
        String json= """
                {
                  "latitude": 55,
                  "longitude": 83,
                  "generationtime_ms": 35.4496240615845,
                  "utc_offset_seconds": 25200,
                  "timezone": "Asia/Novosibirsk",
                  "timezone_abbreviation": "GMT+7",
                  "elevation": 135
                  }
                """;

        GeneralInformation generalInformation = objectMapper.readValue(json, GeneralInformation.class);

        assertThat(generalInformation)
                .returns(55.0,from(GeneralInformation::getLatitude))
                .returns(83.0,from(GeneralInformation::getLongitude))
                .returns(35.4496240615845,from(GeneralInformation::getGenerationTimeMs))
                .returns(25200L,from(GeneralInformation::getUtcOffsetSeconds))
                .returns(TimeZone.getTimeZone("Asia/Novosibirsk"),from(GeneralInformation::getTimeZone))
                .returns(TimeZone.getTimeZone("GMT+7"),from(GeneralInformation::getTimezoneAbbreviation))
                .returns(135.0,from(GeneralInformation::getElevation));
    }

}