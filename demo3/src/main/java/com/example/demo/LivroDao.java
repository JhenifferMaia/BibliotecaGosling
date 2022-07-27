package com.example.demo;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class LivroDao {
	
	
	public void salvarLivro(Livro livro) {
		String sql = "INSERT INTO LIVRO VALUES (?, ?, ?, ?)";
		
		
		try {
			Connection conn = Conexao.getConnection();
			//connection
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, livro.getAutor());
			pst.setString(2, livro.getTitulo());
			pst.setString(3, livro.getGenero());
			pst.setString(4, livro.getCod());
			
			pst.execute();
			
			pst.close();
			conn.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	public ArrayList<Livro> listarLivros() {
		
		ArrayList<Livro> livros = new ArrayList<>();
		
		String sql = "SELECT * FROM LIVRO ";
		//consulta
		
		try {
			Connection conn = Conexao.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet resultSet = pst.executeQuery();
			//retorna o ResultSet (resultado da consulta)
			
			//resultSet.getString(1);
			//resultSet.getString(2);
			
			while(resultSet.next()) {
				String autor = resultSet.getString("Autor");
				String titulo = resultSet.getString("Titulo");
				String genero = resultSet.getString("Genero");
				String cod = resultSet.getString("Cod");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return livros;
	}
	

	public List<Livro> buscarLivros(String codl) {
		
		List<Livro> livros = new ArrayList<>();
		
        String sql = "SELECT * FROM LIVRO WHERE Cod like ?";
        try {
			Connection conn = Conexao.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(sql);
			String auxCod = "%"+ codl+"%"; 

            pst.setString(1, auxCod);

            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
            	String autor = resultSet.getString("Autor");
				String titulo = resultSet.getString("Titulo");
				String genero = resultSet.getString("Genero");
				String cod = resultSet.getString("Cod");
				Livro l = new Livro(autor, titulo, genero, cod);
				livros.add(l);

                
            }

            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return livros;
	}
	
	
	
	/*public ArrayList<Livros> read() {

        Connection conn = Conexao.getConnection();
        
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<Livro> livros = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT * FROM produto");
            rs = pst.executeQuery();

            while (rs.next()) {

                Livro livro = new Livro();
                
               
    	while(resultSet.next()) {

                String autor = livro.getString("Autor");
                String titulo = livro.getString("Titulo");
               String genero = livro.getString("Genero");
                int cod = livro.getInt("Cod");

                livros.add(livro);
    	}
            }

        } catch (SQLException ex) {
        	
            Logger.getLogger(LivroDao.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            Conexao.closeConexao(conn, pst, rs);
        }

        return livros;

    }*/

}
