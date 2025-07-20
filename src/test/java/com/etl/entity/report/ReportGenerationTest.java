package com.etl.entity.report;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.etl.configuration.ExcelConfiguration;
import lombok.SneakyThrows;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(
        classes = {ExcelConfiguration.class}
)
@DisplayName("Тестирование генерации Excel-отчётов")
class ReportGenerationTest {
    @Autowired
    private ExcelWriterBuilder excelWriterBuilder;

    @TempDir
    private static Path sharedTempDir;

    static Stream<Class<?>> provideClasses() {
        return Stream.of(
                AvgDailyReport.class,
                AvgDaylightReport.class,
                GeneralDailyReport.class,
                GeneralDaylightReport.class,
                GeneralMetrics.class
        );
    }

    @SneakyThrows
    @MethodSource("provideClasses")
    @DisplayName("Успешная конвертация отчёта в Excel")
    @ParameterizedTest(name = "[{index}] Проверка конвертации {0} в Excel")
    public void entityToExcelTest(Class<?> reportClass) {
        String fileName = "%s.xlsx".formatted(reportClass.getSimpleName().toLowerCase());
        List<?> testData = Instancio.createList(reportClass);
        Path outputPath = sharedTempDir.resolve(fileName);

        excelWriterBuilder
                .file(outputPath.toFile())
                .head(reportClass)
                .sheet("Данные")
                .doWrite(testData);

        assertThat(outputPath)
                .exists()
                .isRegularFile();
        assertThat(outputPath.toFile())
                .isNotEmpty()
                .hasFileName(fileName);
    }
}
