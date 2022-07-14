package br.com.javacode.locadora.enuns;

public enum ClienteTipoEnum {

	PF("Pessoa Física"), PJ("Pessoa Jurídica");
	
	private final String nome;

	ClienteTipoEnum(String nomeValue) {
		nome = nomeValue;
	}

	public String getNome() {
		return nome;
	}
}
