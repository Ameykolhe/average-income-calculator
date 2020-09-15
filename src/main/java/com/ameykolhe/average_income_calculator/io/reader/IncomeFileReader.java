package com.ameykolhe.average_income_calculator.io.reader;

import java.io.IOException;
import java.util.List;

import com.ameykolhe.average_income_calculator.entity.IncomeRecord;

public interface IncomeFileReader {
	
	public List<IncomeRecord> readFile(String fileName) throws IOException;

}
