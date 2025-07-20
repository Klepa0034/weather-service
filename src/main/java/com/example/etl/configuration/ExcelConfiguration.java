package com.example.etl.configuration;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExcelConfiguration {

    @Bean
    public ExcelWriterBuilder excelWriterBuilder() {
        return EasyExcel.write()
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy());
    }

    @Bean
    public ExcelReaderBuilder excelReaderBuilder() {
        return EasyExcel.read()
                .ignoreEmptyRow(true)
                .autoTrim(true);
    }

}
