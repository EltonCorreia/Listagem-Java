// JavaScript source code
var formulario = document.getElementById("form");
var nome = document.getElementById("nome");
var email = document.getElementById("email");
var senha = document.getElementById("senha");
var celular = document.getElementById("celular");

var formLogin = document.getElementById("btnEntrar");

function cadastrar() {
    //Endpoint da api de cadastro do usuario
    const urlApi = 'http://localhost:8080/cadastrar-usuario';

    //Dados do formul�rio a ser enviados no corpo da requisi��o
    const formData = {
        nome: nome.value,
        email: email.value,
        senha: senha.value,
        celular: celular.value
    }
    fetch(urlApi,
        {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(formData)
        }
    ).then(Response => {
        alert("Cadastro realizado com sucesso!")
        window.location.href = "login.html";
    }).catch(Error => {
        console.log("Cadastro não realizado.", Error)
    })
}

function limpar(){
    nome.value = "",
    email.value="",
    senha.value="",
    celular.value=""
}
function autenticar(){
    var user = document.getElementById("username").value;
    var pswd = document.getElementById("password").value;   
    
    const urlApi = 'http://localhost:8080/autenticar';

    //Dados do formul�rio a ser enviados no corpo da requisi��o
    const formData={
        login: user,
        senha: pswd
    }
    fetch(urlApi,
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(formData)
        }
    ).then(response=>{
        if(!response.ok){
            throw new Error("Falha na conexão com o Banco de Dados")
        }
        return response.json();
    }).then(data=>{
        if(data.autenticado){
            window.location.href= 'home.html';
        }else{
            alert("usuário não atenticado")
        }
    })
}

formLogin.addEventListener('click', function (){
    autenticar();
});

formulario.addEventListener('submit', function (event){
    event.preventDefault();
    cadastrar();
    limpar();
});