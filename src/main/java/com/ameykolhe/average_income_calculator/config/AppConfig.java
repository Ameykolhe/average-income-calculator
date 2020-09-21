package com.ameykolhe.average_income_calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ameykolhe.average_income_calculator.AverageIncomeCalculator;
import com.ameykolhe.average_income_calculator.io.reader.CSVIncomeFileReader;
import com.ameykolhe.average_income_calculator.io.reader.XLSXIcomeFileReader;
import com.ameykolhe.average_income_calculator.io.writer.CSVSummaryFileWriter;
import com.ameykolhe.average_income_calculator.io.writer.XLSXSummaryFileWriter;

@Configuration
@ComponentScan("com.ameykolhe.average_income_calculator")
public class AppConfig {
	
	@Bean
	public XLSXIcomeFileReader xlsxIncomeFileReader() {
		return new XLSXIcomeFileReader();
	}
	
	@Bean
	public CSVIncomeFileReader csvIncomeFileReader() {
		return new CSVIncomeFileReader();
	}
	
	@Bean
	public XLSXSummaryFileWriter xlsxSummaryFileWriter() {
		return new XLSXSummaryFileWriter();
	}
	
	@Bean
	public CSVSummaryFileWriter csvSummaryFileWriter() {
		return new CSVSummaryFileWriter();
	}
	
	@Bean
	public AverageIncomeCalculator averageIncomeCalculator() {
		return new AverageIncomeCalculator();
	}
}
