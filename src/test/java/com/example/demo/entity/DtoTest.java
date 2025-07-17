package com.example.demo.entity;

import com.example.demo.dto.*;
import com.example.demo.entity.constant.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DtoTest {
    @Autowired
    private JsonValue jsonValue;
    @Autowired
    private ObjectMapper objectMapper;


    static Stream<Class<?>> provideClasses() {
        return Stream.of(
                Daily.class,
                DailyUnits.class,
                GeneralInformation.class,
                Hourly.class,
                HourlyUnits.class
        );
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("provideClasses")
    @DisplayName("Проверка конвертации JSON в сущность")
    <T> void jsonToEntityTest(Class<T> entityClass) {

        String getterName = "getJson" + entityClass.getSimpleName();
        Method method = jsonValue.getClass().getMethod(getterName);
        String invoke = (String) method.invoke(jsonValue);
        T entity = objectMapper.readValue(invoke, entityClass);

        assertThat(entity)
                .isNotNull();
    }
}
