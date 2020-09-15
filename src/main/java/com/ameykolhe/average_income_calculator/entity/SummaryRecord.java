package com.ameykolhe.average_income_calculator.entity;

import java.util.Comparator;

public class SummaryRecord implements Comparable<SummaryRecord>{
	private String countryOrCity;
	private String gender;
	private double averageIncome;
	
	public SummaryRecord(String countryOrCity, String gender) {
		super();
		this.countryOrCity = countryOrCity;
		this.gender = gender;
	}
	
	public String getCountryOrCity() {
		return countryOrCity;
	}
	public void setCountryOrCity(String countryOrCity) {
		this.countryOrCity = countryOrCity;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getAverageIncome() {
		return averageIncome;
	}
	public void setAverageIncome(double averageIncome) {
		this.averageIncome = averageIncome;
	}
	
	@Override
	public int compareTo(SummaryRecord o) {
	    return Comparator.comparing(SummaryRecord::getCountryOrCity)
	      .thenComparing(SummaryRecord::getGender)
	      .thenComparing(SummaryRecord::getAverageIncome)
	      .compare(this, o);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return false;
		}
		if (!(obj instanceof SummaryRecord)) {
			return false;
		}
		SummaryRecord other = (SummaryRecord) obj;
		
		if (countryOrCity == null) {
			if (other.countryOrCity != null) {
				return false;
			}
		} else if (!countryOrCity.equals(other.countryOrCity)) {
			return false;
		}
		if (gender == null) {
			if (other.gender != null) {
				return false;
			}
		} else if (!gender.equals(other.gender)) {
			return false;
		}
		return true;
	}
}
