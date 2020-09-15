package com.ameykolhe.average_income_calculator.io.writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.ameykolhe.average_income_calculator.entity.SummaryRecord;

public interface SummaryFileWriter {
	
	public void writeFile(String fileName, List<SummaryRecord> summaryRecords) throws FileNotFoundException, IOException;
	
}
