package com.ameykolhe.average_income_calculator.io.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.ameykolhe.average_income_calculator.entity.IncomeRecord;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

public class CSVIncomeFileReader implements IncomeFileReader {

	@Override
	public List<IncomeRecord> readFile(String fileName) throws IOException {
		Path myPath = Paths.get(fileName);
		BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8);

        HeaderColumnNameMappingStrategy<IncomeRecord> strategy
                = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(IncomeRecord.class);

        CsvToBean<IncomeRecord> csvToBean = new CsvToBeanBuilder<IncomeRecord>(br)
                .withMappingStrategy(strategy)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        List<IncomeRecord> records = csvToBean.parse();
        
        br.close();
		return records;
	}

}
