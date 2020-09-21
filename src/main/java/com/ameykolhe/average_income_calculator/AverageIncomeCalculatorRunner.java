package com.ameykolhe.average_income_calculator;

import java.io.IOException;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ameykolhe.average_income_calculator.config.AppConfig;
import com.ameykolhe.average_income_calculator.entity.IncomeRecord;
import com.ameykolhe.average_income_calculator.entity.SummaryRecord;
import com.ameykolhe.average_income_calculator.io.reader.IncomeFileReader;
import com.ameykolhe.average_income_calculator.io.writer.SummaryFileWriter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AverageIncomeCalculatorRunner {

	public static void main(String[] args) {
		
		Options options = new Options();

        Option input = new Option("i", "input", true, "input file");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("o", "output", true, "output file");
        output.setRequired(true);
        options.addOption(output);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(1);
        }
        
        String inputFilePath = cmd.getOptionValue("input");
        String outputFilePath = cmd.getOptionValue("output");
        

        String readerBeanId = inputFilePath.split("\\.")[1] + "IncomeFileReader";
        String writerBeanId = outputFilePath.split("\\.")[1] + "SummaryFileWriter";


		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){
			
			IncomeFileReader reader = context.getBean(readerBeanId, IncomeFileReader.class);
			AverageIncomeCalculator calculator = context.getBean(AverageIncomeCalculator.class);
			SummaryFileWriter writer = context.getBean(writerBeanId, SummaryFileWriter.class);;
			
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("                          Average Income Calculator");
			System.out.println("\n\n");
			System.out.println("---------  READING Income FILE");
			
			List<IncomeRecord> incomeRecords = reader.readFile(inputFilePath);
			
			System.out.println("---------  CALCULATING Average Income");
			List<SummaryRecord> summaryRecords = calculator.calculateAverageIncome(incomeRecords);
			
			System.out.println("---------  WRITING SUMMARY FILE");
			writer.writeFile(outputFilePath, summaryRecords);
			
			System.out.println("\n\n");
			System.out.println("----------------------------------------------------------------------------------");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
