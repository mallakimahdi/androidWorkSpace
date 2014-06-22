package com.example.listviewsorte;

import java.util.GregorianCalendar;

public class struct 
{
	private Integer id;
	private Double visitLat;
	private Double visitLong;
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

	public Double getVisitLat() {
		return visitLat;
	}

	public void setVisitLat(int visitLat) {
		this.visitLat = (double) visitLat;
	}

	public Double getVisitLong() {
		return visitLong;
	}

	public void setVisitLong(int visitLong) {
		this.visitLong = (double) visitLong;
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
