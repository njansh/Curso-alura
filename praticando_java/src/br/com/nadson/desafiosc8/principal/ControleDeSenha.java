package br.com.nadson.desafiosc8.principal;

import br.com.nadson.desafiosc8.modelo.Usuario;

public class ControleDeSenha {
	public static void main(String[] args) {
		Usuario usuaria1= new Usuario ("abc1234");
		usuaria1.setSenha("abc1234","novaSenha!2024");
		usuaria1.setSenha("senhaErrada","outraSenha!2024");
		
	}

}
