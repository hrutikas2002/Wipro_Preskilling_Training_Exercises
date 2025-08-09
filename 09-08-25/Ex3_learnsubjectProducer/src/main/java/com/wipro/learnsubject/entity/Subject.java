package com.wipro.learnsubject.entity;

public class Subject {
	private String subjectCode;
    private String subjectValue;
	public Subject(String subjectCode, String subjectValue) {
		super();
		this.subjectCode = subjectCode;
		this.subjectValue = subjectValue;
	}
	public Subject() {
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectValue() {
		return subjectValue;
	}
	public void setSubjectValue(String subjectValue) {
		this.subjectValue = subjectValue;
	}
	@Override
	public String toString() {
		return "Subject [subjectCode=" + subjectCode + ", subjectValue=" + subjectValue + "]";
	} 
}
