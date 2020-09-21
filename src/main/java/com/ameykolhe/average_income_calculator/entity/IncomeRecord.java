package com.ameykolhe.average_income_calculator.entity;

import com.opencsv.bean.CsvBindByName;

public class IncomeRecord {
	
	@CsvBindByName(column="City")
	private String city;
	
	@CsvBindByName(column="Country")
	private String country;
	
	@CsvBindByName(column="Gender")
	private String gender;
	
	@CsvBindByName(column="Currency")
	private String currency;
	
	@CsvBindByName(column="Average Income")
	private double averageIncome;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getAverageIncome() {
		return averageIncome;
	}
	public void setAverageIncome(double averageIncome) {
		this.averageIncome = averageIncome;
	}
	@Override
	public String toString() {
		return "SummaryRecord [city=" + city + ", country=" + country + ", gender=" + gender + ", currency=" + currency
				+ ", averageIncome=" + averageIncome + "]";
	}
}
