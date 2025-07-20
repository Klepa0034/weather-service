package com.etl.dto;

import com.etl.constant.JsonValue;
import com.etl.factory.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DtoConversionToJsonTest {
    @Autowired
    private DailyFactory dailyFactory;
    @Autowired
    private DailyUnitsFactory dailyUnitsFactory;
    @Autowired
    private GeneralWeatherFactory generalWeatherFactory;
    @Autowired
    private HourlyFactory hourlyFactory;
    @Autowired
    private HourlyUnitsFactory hourlyUnitsFactory;

    @Autowired
    private ObjectMapper objectMapper;

    static Stream<Arguments> provideClassesAndJsonValues() {
        return Stream.of(
                Arguments.of(Daily.class, JsonValue.JSON_DAILY),
                Arguments.of(DailyUnits.class, JsonValue.JSON_DAILY_UNITS),
                Arguments.of(GeneralWeather.class, JsonValue.JSON_GENERAL_WEATHER),
                Arguments.of(Hourly.class, JsonValue.JSON_HOURLY),
                Arguments.of(HourlyUnits.class, JsonValue.JSON_HOURLY_UNITS)
        );
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("provideClassesAndJsonValues")
    @DisplayName("Проверка конвертации JSON в сущность")
    <T> void jsonToEntityTest(Class<T> entityClass, JsonValue jsonValue) {
        T expectedEntity = createExpectedEntity(entityClass);


        T entity = objectMapper.readValue(jsonValue.getValue(), entityClass);

        assertThat(entity)
                .usingRecursiveComparison()
                .isEqualTo(expectedEntity);
    }


    <T> T createExpectedEntity(Class<T> entityClass) {
        if (entityClass == Daily.class) {
            return (T) dailyFactory.create();
        } else if (entityClass == DailyUnits.class) {
            return (T) dailyUnitsFactory.create();
        } else if (entityClass == GeneralWeather.class) {
            return (T) generalWeatherFactory.create();
        }
        else if (entityClass == Hourly.class) {
            return (T) hourlyFactory.create();
        }
        else if (entityClass == HourlyUnits.class) {
            return (T) hourlyUnitsFactory.create();
        }
        return null;
    }
}