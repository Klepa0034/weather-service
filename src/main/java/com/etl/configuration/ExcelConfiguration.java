package com.etl.configuration;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration class for setting up Excel file operations using EasyExcel.
 * Provides pre-configured beans for both reading and writing Excel files with sensible defaults.
 *
 * <p>Configures common behaviors like:
 * <ul>
 *   <li>Automatic column width adjustment for writers</li>
 *   <li>Empty row skipping for readers</li>
 *   <li>Automatic string trimming for readers</li>
 * </ul>
 * </p>
 */
@Configuration
public class ExcelConfiguration {

    /**
     * Creates and configures an Excel writer builder with default settings.
     *
     * @return Pre-configured {@link ExcelWriterBuilder} with:
     *         <ul>
     *           <li>Automatic column width adjustment strategy</li>
     *         </ul>
     */
    @Bean
    public ExcelWriterBuilder excelWriterBuilder() {
        return EasyExcel.write()
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy());
    }

    /**
     * Creates and configures an Excel reader builder with default settings.
     *
     * @return Pre-configured {@link ExcelReaderBuilder} with:
     *         <ul>
     *           <li>Empty row skipping enabled</li>
     *           <li>Automatic string trimming enabled</li>
     *         </ul>
     */
    @Bean
    public ExcelReaderBuilder excelReaderBuilder() {
        return EasyExcel.read()
                .ignoreEmptyRow(true)
                .autoTrim(true);
    }
}