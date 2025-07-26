package com.etl.adapter.impl;

import com.etl.adapter.ConversionAdapter;
import com.etl.dto.service.WeatherReportDto;
import com.etl.entity.report.WeatherReport;
import com.etl.mapper.ConversionMapper;
import com.etl.repository.ExcelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adapter implementation for weather report data conversion and persistence.
 * <p>
 * Handles the final adaptation stage of the conversion pipeline by:
 * <ol>
 *   <li>Mapping the {@link WeatherReportDto} to a persistable {@link WeatherReport} entity</li>
 *   <li>Saving the entity via {@link ExcelRepository}</li>
 * </ol>
 *
 * @see ConversionAdapter
 * @see ExcelRepository
 * @see ConversionMapper
 */

@Component
@RequiredArgsConstructor
public class ConversionAdapterImpl implements ConversionAdapter {

    private final ExcelRepository excelRepository;
    private final ConversionMapper conversionMapper;

    @Override
    public void adapt(WeatherReportDto weatherReportDto) {
        WeatherReport weatherReport = conversionMapper.toWeatherReport(weatherReportDto);
        excelRepository.save(weatherReport);
    }
}
