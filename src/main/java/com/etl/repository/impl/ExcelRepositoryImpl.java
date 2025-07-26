package com.etl.repository.impl;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.etl.entity.report.WeatherReport;
import com.etl.repository.ExcelRepository;
import com.etl.settings.ExcelSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository implementation for saving weather reports to Excel files.
 * <p>
 * Uses {@link ExcelWriterBuilder} to write data to an Excel file configured in {@link ExcelSettings}.
 * The output file location and sheet name are determined by {@code ExcelSettings}.
 *
 * @see ExcelRepository
 * @see ExcelSettings
 * @see ExcelWriterBuilder
 */

@Repository
@RequiredArgsConstructor
public class ExcelRepositoryImpl implements ExcelRepository {

    private final ExcelSettings excelSettings;
    private final ExcelWriterBuilder excelWriterBuilder;

    @Override
    public void save(WeatherReport weatherReport) {
        excelWriterBuilder
                .file(excelSettings.getPath())
                .head(weatherReport.getClass())
                .sheet(excelSettings.getSheetName())
                .doWrite(List.of(weatherReport));
    }
}
