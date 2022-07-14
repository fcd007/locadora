package br.com.javacode.locadora.enuns;

public enum SexoEnum {

	MASCULINO("Masculino"), FEMININO("Feminino"), OUTRO("Outro");
	
	private final String nome;

	SexoEnum(String nomeValue) {
		nome = nomeValue;
	}

	public String getNome() {
		return nome;
	}
}
