package br.com.nadson.desafiosc8.modelo;

public class Login {
	private String login,senha;
	
	
	public Login(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public boolean validateLogin(String login, String senha) {
        if(this.login.equals(login) && this.senha.equals(senha)) {
            return true;
        } else {
            return false;
        }
    }

	
	public void logar(String login, String senha) {
		if (validateLogin(login, senha)) {
			System.out.println("Login realizado com sucesso!");
		} else {
			System.out.println("Login ou senha incorretos!");
		}
	}
	
}
