package br.gov.sp.etesp.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etesp.api.dto.LoginDto;
import br.gov.sp.etesp.api.dto.Usuario;
import br.gov.sp.etesp.api.service.LoginService;
import br.gov.sp.etesp.api.service.UsuarioService;
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	UsuarioService usuarioService;

	@Override
	public LoginDto autenticar(LoginDto login) {
		
		Usuario usuarioRetorno =  usuarioService.consultarUsuarioPorEmail(login.getLogin());
		if(usuarioRetorno != null && usuarioRetorno.getSenha().equals(login.getSenha())){
			login.setAutenticado(true);
			return login;
		}
		// TODO Auto-generated method stub
		login.setAutenticado(false);
		return login;
	}

}
