package com.example.listviewsorte;

public class struct 
{
	private Integer id;
	private double visitLat;
	private double visitLong;
	private Integer isSend;
	private boolean isMasfa;
	
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
