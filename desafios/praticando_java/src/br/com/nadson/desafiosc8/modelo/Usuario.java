package br.com.nadson.desafiosc8.modelo;

public class Usuario {
	private String senha;

	public Usuario(String senha) {
		this.senha = senha;
	}

	public boolean validarSenhaAtual(String senhaAtual) {
		return this.senha.equals(senhaAtual);
	}

	public void setSenha(String senhaAtual, String novaSenha) {
		if (validarSenhaAtual(senhaAtual)) {
			this.senha = novaSenha;
			System.out.println("Senha alterada com sucesso.");
		} else {
			System.out.println("Senha atual incorreta. Não foi possível alterar a senha.");
		}
	}

}
