package com.ameykolhe.average_income_calculator.io.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ameykolhe.average_income_calculator.entity.IncomeRecord;


public class XLSXIcomeFileReader implements IncomeFileReader {

	@Override
	public List<IncomeRecord> readFile(String fileName) throws IOException {
		List<IncomeRecord> incomeRecords = new ArrayList<>();
		
		FileInputStream fis = new FileInputStream(fileName);
		
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		
		Iterator<Row> rowIterator = mySheet.iterator();
		
		rowIterator.next();
		
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			
			IncomeRecord record = new IncomeRecord();
			
			Cell city = row.getCell(0);
			Cell country = row.getCell(1);
			Cell gender = row.getCell(2);
			Cell currency = row.getCell(3);
			Cell averageIncome = row.getCell(4);
			
			record.setCity(city.getStringCellValue());
			if(country != null) {
				record.setCountry(country.getStringCellValue());
			}
			record.setGender(gender.getStringCellValue());
			record.setCurrency(currency.getStringCellValue());
			record.setAverageIncome(averageIncome.getNumericCellValue());
			
			incomeRecords.add(record);
		}
		
		myWorkBook.close();
		fis.close();
		return incomeRecords;
	}

}
