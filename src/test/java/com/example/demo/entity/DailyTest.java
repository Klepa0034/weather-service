package com.example.demo.entity;

import com.example.demo.dto.Daily;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.from;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class DailyTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    @DisplayName("Сущность Daily конвертируется в json успешно")
    public void jsonToEntityTest(){
        String json= """
                    {
                    "time": [1747328400, 1747414800, 1747501200, 1747587600, 1747674000, 1747760400, 1747846800, 1747933200, 1748019600, 1748106000, 1748192400, 1748278800, 1748365200, 1748451600, 1748538000],
                    "sunrise": [1747347493, 1747433791, 1747520091, 1747606393, 1747692698, 1747779005, 1747865315, 1747951628, 1748037944, 1748124263, 1748210585, 1748296910, 1748383239, 1748469570, 1748555905],
                    "sunset": [1747405835, 1747492341, 1747578846, 1747665349, 1747751851, 1747838351, 1747924849, 1748011346, 1748097840, 1748184332, 1748270821, 1748357307, 1748443792, 1748530276, 1748616758],
                    "daylight_duration": [58329.96, 58538.27, 58743.19, 58944.46, 59141.8, 59334.93, 59523.54, 59707.36, 59886.07, 60059.36, 60226.91, 60388.44, 60545.06, 60697.22, 60844.73]
                    }
                """;

        Daily daily = objectMapper.readValue(json, Daily.class);

        assertThat(daily)
                .returns(new long[]{1747328400, 1747414800, 1747501200, 1747587600, 1747674000, 1747760400, 1747846800, 1747933200, 1748019600, 1748106000, 1748192400, 1748278800, 1748365200, 1748451600, 1748538000},from(Daily::getTime))
                .returns(new long[]{1747347493, 1747433791, 1747520091, 1747606393, 1747692698, 1747779005, 1747865315, 1747951628, 1748037944, 1748124263, 1748210585, 1748296910, 1748383239, 1748469570, 1748555905},from(Daily::getSunrise))
                .returns(new long[]{1747405835, 1747492341, 1747578846, 1747665349, 1747751851, 1747838351, 1747924849, 1748011346, 1748097840, 1748184332, 1748270821, 1748357307, 1748443792, 1748530276, 1748616758},from(Daily::getSunset))
                .returns(new double[]{58329.96, 58538.27, 58743.19, 58944.46, 59141.8, 59334.93, 59523.54, 59707.36, 59886.07, 60059.36, 60226.91, 60388.44, 60545.06, 60697.22, 60844.73},from(Daily::getDaylightDuration));
    }
}
//todo поменять на правильные примитивы