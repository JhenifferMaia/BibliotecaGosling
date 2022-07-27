package com.example.demo;

public class Livro {
	private String cod;
	private String titulo, autor, genero;
	
	
	public Livro(String autor, String titulo, String genero, String cod) {
		
		this.autor = autor;
		this.titulo=titulo;
		this.genero = genero;
		this.cod=cod;
	}
	
	public Livro() {
		
	}
	
	public String getCod() {
		return cod;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	@Override
	public String toString() { 			
		
		//return "Livro\n|_____________Cod_____________|" +  "|_____________Titulo_____________|" + "|_____________Autor_____________|" +"|_____________Genero_____________|"+
		//"\n                              "+cod+"                                                            "+titulo+"                                                      "+autor+"                                                    "+genero+"                     ";
						            
		return "Livro |cod = " + cod + ", Titulo = " + titulo + ", autor = " + autor + ", genero = " + genero+" |" ;
	}

	
	

	

	
}
