package br.gov.sp.etesp.api.entity;

import br.gov.sp.etesp.api.dto.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_usuario") //importar entity
public class UsuarioEntity { // criar classe
	@Id //importar id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // importar generated value
	private Long id;
	private String nome;
	@Column(unique = true) // isso faz com que o email seja unico, e não hajam usuários com o mesmo email cadastrados
	private String email;
	private String senha;
	private String celular;
	
	public UsuarioEntity() {}//construtor vazio, ou seja, não precisa passar parâmetro
	
	public UsuarioEntity (Usuario usuario) {//classe Usuario.java foi importada aqui, este é outro método construtor, onde o argumento esperado é o Usuario
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.celular = usuario.getCelular();
		this.senha = usuario.getSenha();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

}
