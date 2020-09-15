package com.ameykolhe.average_income_calculator;

import java.io.IOException;
import java.util.List;

import com.ameykolhe.average_income_calculator.entity.IncomeRecord;
import com.ameykolhe.average_income_calculator.entity.SummaryRecord;
import com.ameykolhe.average_income_calculator.io.reader.IncomeFileReader;
import com.ameykolhe.average_income_calculator.io.reader.XLSXIcomeFileReader;
import com.ameykolhe.average_income_calculator.io.writer.SummaryFileWriter;
import com.ameykolhe.average_income_calculator.io.writer.XLSXSummaryFileWriter;

public class AverageIncomeCalculatorRunner {

	public static void main(String[] args) {

		IncomeFileReader reader = new XLSXIcomeFileReader();
		AverageIncomeCalculator calculator = new AverageIncomeCalculator();
		SummaryFileWriter writer = new XLSXSummaryFileWriter();

		try {
			
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("                          Average Income Calculator");
			System.out.println("\n\n");
			System.out.println("---------  READING Income FILE");
			
			List<IncomeRecord> incomeRecords = reader.readFile("Sample_input_file_Assignment_3.xlsx");
			
			System.out.println("---------  CALCULATING Average Income");
			List<SummaryRecord> summaryRecords = calculator.calculateAverageIncome(incomeRecords);
			
			System.out.println("---------  WRITING SUMMARY FILE");
			writer.writeFile("Average_Income_summary.xlsx", summaryRecords);
			
			System.out.println("\n\n");
			System.out.println("----------------------------------------------------------------------------------");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
