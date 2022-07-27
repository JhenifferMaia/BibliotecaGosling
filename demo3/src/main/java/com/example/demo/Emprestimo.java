package com.example.demo;

public class Emprestimo {
	
	private String prazo, data, cpf, nome,identcod;

	public Emprestimo(String prazo, String data, String cpf, String nome, String identcod) {
		//super();
		this.prazo = prazo;
		this.data = data;
		this.cpf = cpf;
		this.nome = nome;
		this.identcod = identcod;
	}
	

	


	public String getIdentcod() {
		return identcod;
	}

	public void setIdentCod(String identCod) {
		this.identcod = identCod;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Emprestimo | prazo = " + prazo + ", data = " + data + ", cpf = " + cpf + ", nome = " + nome +", Identcod = "+identcod +"|";
	}





	public String getIdentcod1() {
		// TODO Auto-generated method stub
		return identcod;
	}


	

}
