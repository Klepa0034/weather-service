package com.etl.factory;

import com.etl.dto.GeneralWeather;
import org.springframework.stereotype.Component;

import java.util.TimeZone;

@Component
public class GeneralWeatherFactory {
    public GeneralWeather create(){
        return new GeneralWeather(
                55,
                83,
                35.4496240615845,
                25200L,
                TimeZone.getTimeZone("Asia/Novosibirsk"),
                "GMT+7",
                135,
                null,
                null,
                null,
                null
        );
    }
}