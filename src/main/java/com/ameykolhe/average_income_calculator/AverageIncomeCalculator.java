package com.ameykolhe.average_income_calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ameykolhe.average_income_calculator.entity.IncomeRecord;
import com.ameykolhe.average_income_calculator.entity.Pair;
import com.ameykolhe.average_income_calculator.entity.SummaryRecord;

public class AverageIncomeCalculator {
	
	public List<SummaryRecord> calculateAverageIncome(List<IncomeRecord> incomeRecords) {
		
		Map<SummaryRecord, Pair> accumulator = new TreeMap<>();
		
		Map<String, Double> currencyConversionRate = new HashMap<>();	
		currencyConversionRate.put("USD", 1.0);
		currencyConversionRate.put("GBP", 1/0.67);
		currencyConversionRate.put("INR", 1/67.0);
		currencyConversionRate.put("SGP", 1/1.5);
		currencyConversionRate.put("HKD", 1/8.0);
		
		incomeRecords.forEach(  incomeRecord -> {
			String countryOrCity = incomeRecord.getCountry() != null ? incomeRecord.getCountry(): incomeRecord.getCity();
			String gender = incomeRecord.getGender();
			SummaryRecord summaryRecord = new SummaryRecord(countryOrCity, gender);
			
			if(accumulator.containsKey(summaryRecord)) {
				accumulator.replace(summaryRecord, new Pair(
								accumulator.get(summaryRecord).getFirst() + incomeRecord.getAverageIncome() * currencyConversionRate.get(incomeRecord.getCurrency()),
								accumulator.get(summaryRecord).getSecond() + 1
							));
			}
			else {
				accumulator.put(summaryRecord, new Pair(incomeRecord.getAverageIncome() * currencyConversionRate.get(incomeRecord.getCurrency()), 1));
			}
		});
		
		
		
		List<SummaryRecord> summaryRecords = new ArrayList<>();
		accumulator.forEach( (key, value) -> {
			key.setAverageIncome(value.getFirst()/value.getSecond());
			summaryRecords.add(key);
		});
		
		return summaryRecords;
	}
}
