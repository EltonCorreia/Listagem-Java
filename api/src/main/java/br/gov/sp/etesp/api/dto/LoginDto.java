package br.gov.sp.etesp.api.dto;

public class LoginDto {
	private String login;
	private String senha;
	private boolean isAutenticado;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAutenticado() {
		return isAutenticado;
	}
	public void setAutenticado(boolean isAutenticado) {
		this.isAutenticado = isAutenticado;
	}
}
