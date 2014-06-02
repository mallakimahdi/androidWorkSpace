package com.example.listviewsorte;

import java.util.GregorianCalendar;

public class struct 
{
	private Integer id;
	private double visitLat;
	private double visitLong;
	private Integer isSend;
	private boolean isMasfa;
	private GregorianCalendar gc;
	
	
	public GregorianCalendar getGc() {
		return gc;
	}

	public void setGc(GregorianCalendar gc) {
		this.gc = gc;
	}

	public Integer getIsSend() {
		return isSend;
	}

	public void setIsSend(Integer isSend) {
		this.isSend = isSend;
	}

	public double getVisitLat() {
		return visitLat;
	}

	public void setVisitLat(double visitLat) {
		this.visitLat = visitLat;
	}

	public double getVisitLong() {
		return visitLong;
	}

	public void setVisitLong(double visitLong) {
		this.visitLong = visitLong;
	}

	public Integer isSend() {
		return isSend;
	}

	public void setSend(Integer isSend) {
		this.isSend = isSend;
	}

	public boolean isMasfa() {
		return isMasfa;
	}

	public void setMasfa(boolean isMasfa) {
		this.isMasfa = isMasfa;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
}
