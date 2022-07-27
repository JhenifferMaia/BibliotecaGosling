package com.example.demo;

public class Cliente {
	private String endereco, nome, cpf;
	 private String email; 
	 private String telefone;
	 
	 
	 public Cliente(String nome, String cpf, String telefone, String email, String endereco){

		    this.nome = nome;
		    this.cpf = cpf;		    
		    this.telefone = telefone;
		    this.endereco = endereco;
		    this.email = email;
		 
	 }

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente |endereco = " + endereco + ", nome = " + nome + ", cpf = " + cpf + ", email = " + email + ", telefone = "
				+ telefone + "|";
	}
	 
	
	 
}
