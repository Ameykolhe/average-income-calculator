package com.ameykolhe.average_income_calculator.io.writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.ameykolhe.average_income_calculator.entity.SummaryRecord;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CSVSummaryFileWriter implements SummaryFileWriter {

	@Override
	public void writeFile(String fileName, List<SummaryRecord> summaryRecords)
			throws FileNotFoundException, IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		Path myPath = Paths.get(fileName);
		var writer = Files.newBufferedWriter(myPath, StandardCharsets.UTF_8);
		
		writer.write("City/Country,Gender,Average Income(in USD)\n");
		
		StatefulBeanToCsv<SummaryRecord> beanToCsv = new StatefulBeanToCsvBuilder<SummaryRecord>(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        beanToCsv.write(summaryRecords);
        
        writer.close();

	}

}
