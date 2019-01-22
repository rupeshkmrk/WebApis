package com.sms.model;

public class DashboardDetails {

	private String total;
	private String dac;
	private String ditiss;
	private String online;
	public DashboardDetails(String total, String dac, String ditiss, String online) {
		super();
		this.total = total;
		this.dac = dac;
		this.ditiss = ditiss;
		this.online = online;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getDac() {
		return dac;
	}
	public void setDac(String dac) {
		this.dac = dac;
	}
	public String getDitiss() {
		return ditiss;
	}
	public void setDitiss(String ditiss) {
		this.ditiss = ditiss;
	}
	public String getOnline() {
		return online;
	}
	public void setOnline(String online) {
		this.online = online;
	}
	
	
	
}
