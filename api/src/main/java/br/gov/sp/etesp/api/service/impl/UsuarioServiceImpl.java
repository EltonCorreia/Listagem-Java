package br.gov.sp.etesp.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etesp.api.dto.Usuario;
import br.gov.sp.etesp.api.entity.UsuarioEntity;
import br.gov.sp.etesp.api.repository.UsuarioRepository;
import br.gov.sp.etesp.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioRepository repository;// aqui é feita a conexão entre repository e service, ao criar variável
									// repository no service--repository só aceita variável tipo entity

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		UsuarioEntity entity = new UsuarioEntity(usuario);// aqui estamos usando o método usuarioEntity
		repository.save(entity);

	}

	@Override
	public void excluirUsuario(Long ID) {
		repository.deleteById(ID);
	}

	@Override
	public List<UsuarioEntity> listaDeUsuarios() {
		
		List<UsuarioEntity> lista = repository.findAll();
		return lista;
	}
	
	@Override
	public Usuario consultarUsuarioPorEmail(String email) {
		UsuarioEntity response = repository.findByEmail(email);
		if (response != null) {
			Usuario user = new Usuario();
			user.setEmail(email);
			user.setSenha(response.getSenha());
			return user;
		}
		return null;
	}

	@Override
	public void atualizarUsuario(Usuario usuario) {
		UsuarioEntity retorno = repository.findByEmail(usuario.getEmail());
		if(retorno!= null) {
			retorno.setNome(usuario.getNome());
			retorno.setEmail(usuario.getEmail());
			retorno.setCelular(usuario.getCelular());
			retorno.setSenha(usuario.getSenha());
			repository.save(retorno);
		}
	}

}
