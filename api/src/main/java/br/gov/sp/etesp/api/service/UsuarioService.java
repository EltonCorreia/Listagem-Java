package br.gov.sp.etesp.api.service;

import java.util.List;

import br.gov.sp.etesp.api.dto.Usuario;
import br.gov.sp.etesp.api.entity.UsuarioEntity;

public interface UsuarioService {
	public void cadastrarUsuario(Usuario usuario);//cadastra usuários
	public void excluirUsuario(Long ID);//exclui usuários
	public List<UsuarioEntity> listaDeUsuarios();//lista usuários cadastrados
	public Usuario consultarUsuarioPorEmail(String email);//consulta usuários de forma unitária através do email
	public void atualizarUsuario(Usuario usuario); // altera cadastro de usuário, a chave de busca é o proprio usuario
}
