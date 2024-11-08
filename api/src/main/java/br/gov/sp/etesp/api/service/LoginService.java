package br.gov.sp.etesp.api.service;

import br.gov.sp.etesp.api.dto.LoginDto;

public interface LoginService {
	public LoginDto autenticar(LoginDto login);
		
}
