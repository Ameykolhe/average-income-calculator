package com.ameykolhe.average_income_calculator.entity;

public class Pair {
	private Double first;
	private Integer second;
	
	public Pair(Double first, Integer second) {
		super();
		this.first = first;
		this.second = second;
	}
	public Double getFirst() {
		return first;
	}
	public void setFirst(Double first) {
		this.first = first;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
}
