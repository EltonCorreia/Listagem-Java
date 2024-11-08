package br.gov.sp.etesp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.gov.sp.etesp.api.dto.LoginDto;
import br.gov.sp.etesp.api.dto.Usuario;
import br.gov.sp.etesp.api.service.LoginService;
import br.gov.sp.etesp.api.service.UsuarioService;

@RestController
@CrossOrigin("*")
public class ApiController {
	@Autowired
	UsuarioService service;
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/autenticar")
	public ResponseEntity<?> autenticar(@RequestBody LoginDto login) {
		LoginDto loginRetorno = loginService.autenticar(login);
		return ResponseEntity.ok (loginRetorno);
	}
	@PostMapping("/cadastrar-usuario")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario){
		service.cadastrarUsuario(usuario);
		return ResponseEntity.ok("Usuário castrado com sucesso");
	}
	
	@GetMapping("/listar-usuarios")
	public ResponseEntity<?> listarUsuarios(){
		return ResponseEntity.ok(service.listaDeUsuarios());
	}
	
	@DeleteMapping ("/deletar-usuario/{id}")
	public void deletarUsuario(@PathVariable Long ID) {
		service.excluirUsuario(ID);
	}
	
	@PostMapping ("/atualizar-usuario")
	public void atualizarUsuario(@RequestBody Usuario usuario) {
		service.atualizarUsuario(usuario);
	}
}
