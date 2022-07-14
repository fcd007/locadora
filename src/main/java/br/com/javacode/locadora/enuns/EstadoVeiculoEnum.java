package br.com.javacode.locadora.enuns;

public enum EstadoVeiculoEnum {

	// Atrasado - está fora do prazo para está no patio
	// Alocado - está locado dentro do prazo
	// Liberado - o veículo está livre para alocacao
	AT("Atrasado"), AL("Alocado"), LI("Liberado");

	private final String nome;

	EstadoVeiculoEnum(String nomeValue) {
		nome = nomeValue;
	}

	public String getNome() {
		return nome;
	}
}
