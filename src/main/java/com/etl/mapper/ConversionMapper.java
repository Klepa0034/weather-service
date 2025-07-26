package com.etl.mapper;

import com.etl.dto.api.GeneralWeather;
import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import com.etl.entity.report.WeatherReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * MapStruct mapper interface for converting between weather data representations.
 * <p>
 * Provides mapping between:
 * <ul>
 *   <li>{@link GeneralWeather} and {@link GeneralWeatherDto}</li>
 *   <li>{@link WeatherReportDto} and {@link WeatherReport}</li>
 * </ul>
 * <p>
 * Configured with Spring component model and strict unmapped target policy.
 *
 * @see GeneralWeather
 * @see GeneralWeatherDto
 * @see WeatherReport
 * @see WeatherReportDto
 */
@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ConversionMapper {
    /**
     * Maps {@link GeneralWeather} to {@link GeneralWeatherDto}.
     * <p>
     * Performs structural conversion between domain model and DTO,
     * including nested object mappings for daily and hourly data.
     *
     * @param generalWeather source domain object (not null)
     * @return converted DTO
     * @throws .MappingException if conversion fails
     */

    @Mapping(target = "dailyDto", source = "daily")
    @Mapping(target = "dailyUnitsDto", source = "dailyUnits")
    @Mapping(target = "hourlyDto", source = "hourly")
    @Mapping(target = "hourlyUnitsDto", source = "hourlyUnits")
    GeneralWeatherDto toGeneralWeatherDto(GeneralWeather generalWeather);

    /**
     * Maps {@link WeatherReportDto} to {@link WeatherReport}.
     * <p>
     * Performs comprehensive mapping of all weather report components:
     * <ul>
     *   <li>Daily averages and totals</li>
     *   <li>Daylight-specific metrics</li>
     *   <li>General weather measurements</li>
     * </ul>
     *
     * @param weatherReportDto source DTO (not null)
     * @return converted domain object
     * @throws .MappingException if conversion fails
     */

    @Mapping(target = "avgTemperatureTwoMTwentyFourH", source = "avgDailyReport.avgTemperatureTwoMTwentyFourH")
    @Mapping(target = "avgRelativeHumidityTwoMTwentyFourH", source = "avgDailyReport.avgTemperatureEightyMDTwentyFourH")
    @Mapping(target = "avgDewPointTwoMTwentyFourH", source = "avgDailyReport.avgDewPointTwoMTwentyFourH")
    @Mapping(target = "avgApparentTemperatureTwentyFourH", source = "avgDailyReport.avgApparentTemperatureTwentyFourH")
    @Mapping(target = "avgTemperatureEightyMTwentyFourH", source = "avgDailyReport.avgTemperatureEightyMDTwentyFourH")
    @Mapping(target = "avgTemperatureOneHundredAndTwentyMTwentyFourH", source = "avgDailyReport.avgTemperatureOneHundredAndTwentyMTwentyFourH")
    @Mapping(target = "avgWindSpeedTenMTwentyFourH", source = "avgDailyReport.avgWindSpeedTenMTwentyFourH")
    @Mapping(target = "avgWindSpeedEightyMTwentyFourH", source = "avgDailyReport.avgWindSpeedEightyMTwentyFourH")
    @Mapping(target = "avgVisibilityTwentyFourH", source = "avgDailyReport.avgVisibilityTwentyFourH")
    @Mapping(target = "totalRainTwentyFourH", source = "avgDailyReport.totalRainTwentyFourH")
    @Mapping(target = "totalShowersTwentyFourH", source = "avgDailyReport.totalShowersTwentyFourH")
    @Mapping(target = "totalSnowfallTwentyFourH", source = "avgDailyReport.totalSnowfallTwentyFourH")

    @Mapping(target = "avgTemperatureTwoMDaylight", source = "avgDaylightReport.temperatureTwoMCelsiusDaylight")
    @Mapping(target = "avgRelativeHumidityTwoMDaylight", source = "avgDaylightReport.relativeHumidityTwoMDaylight")
    @Mapping(target = "avgDewPointTwoMDaylight", source = "avgDaylightReport.dewPointTwoMDaylight")
    @Mapping(target = "avgApparentTemperatureDaylight", source = "avgDaylightReport.apparentTemperatureDaylight")
    @Mapping(target = "avgTemperatureEightyMDaylight", source = "avgDaylightReport.temperatureEightyMDaylight")
    @Mapping(target = "avgTemperatureOneHundredAndTwentyMDaylight", source = "avgDaylightReport.temperatureOneHundredAndTwentyDaylight")
    @Mapping(target = "avgWindSpeedTenMDaylight", source = "avgDaylightReport.windSpeedTenMDaylight")
    @Mapping(target = "avgWindSpeedEightyMDaylight", source = "avgDaylightReport.windSpeedEightyMDaylight")
    @Mapping(target = "avgVisibilityDaylight", source = "avgDaylightReport.visibilityDaylight")
    @Mapping(target = "totalRainDaylight", source = "avgDaylightReport.rainTwentyFourHDaylight")
    @Mapping(target = "totalShowersDaylight", source = "avgDaylightReport.showersTwentyFourHDaylight")
    @Mapping(target = "totalSnowfallDaylight", source = "avgDaylightReport.snowfallTwentyFourHDaylight")

    @Mapping(target = "windSpeedTenMMPerS", source = "generalMetrics.windSpeedTenMPerS")
    @Mapping(target = "windSpeedEightyMMPerS", source = "generalMetrics.windSpeedEightyMPerS")
    @Mapping(target = "temperatureTwoMCelsius", source = "generalMetrics.temperatureTwoMPerS")
    @Mapping(target = "apparentTemperatureCelsius", source = "generalMetrics.apparentTemperatureMPerS")
    @Mapping(target = "temperatureEightyMCelsius", source = "generalMetrics.temperatureEightyMPerS")
    @Mapping(target = "temperatureOneHundredAndTwentyMCelsius", source = "generalMetrics.temperatureOneHundredAndTwentyPerS")
    @Mapping(target = "soilTemperatureZeroCmCelsius", source = "generalMetrics.soilTemperatureZeroCmPerS")
    @Mapping(target = "soilTemperatureSixCmCelsius", source = "generalMetrics.soilTemperatureSixCmPerS")
    @Mapping(target = "rainMm", source = "generalMetrics.rainMmPerS")
    @Mapping(target = "showersMm", source = "generalMetrics.showerMmPerS")
    @Mapping(target = "snowfallMm", source = "generalMetrics.snowfallMmPerS")
    @Mapping(target = "daylightHours", source = "generalMetrics.daylightHours")
    @Mapping(target = "sunsetIso", source = "generalMetrics.sunsetIsoD")
    @Mapping(target = "sunriseIso", source = "generalMetrics.sunriseIsoD")
    WeatherReport toWeatherReport(WeatherReportDto weatherReportDto);

}
