package br.gov.sp.etesp.api.dto;

import java.time.LocalDate;

public class Autenticado {
	private String status;
	private LocalDate data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Autenticado(String status, LocalDate data) {
		super();
		this.status = status;
		this.data = data;
	}
	
}
