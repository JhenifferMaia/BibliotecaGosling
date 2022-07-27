package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao {
	
	public void registrarEmprestimo(Emprestimo emprestimos) {
		String sql = "INSERT INTO EMPRESTIMO VALUES (?, ?, ?, ?,?)";
		
		
		try {
			Connection conn = Conexao.getConnection();
			//connection
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, emprestimos.getPrazo());
			pst.setString(2, emprestimos.getData());
			pst.setString(3, emprestimos.getCpf());
			pst.setString(4, emprestimos.getNome());
			pst.setString(5, emprestimos.getIdentcod());
			
			pst.execute();
			
			pst.close();
			conn.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Emprestimo> listarEmprestimos() {
		
		ArrayList<Emprestimo> emprestimos = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPRESTIMO ";
		//consulta
		
		try {
			Connection conn = Conexao.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet resultSet = pst.executeQuery();
			//retorna o ResultSet (resultado da consulta)
			
			//resultSet.getString(1);
			//resultSet.getString(2);
			
			while(resultSet.next()) {
				//String prazo, String data, String cpf, String nome, String identcod
				String prazo = resultSet.getString("Prazo");
				String data = resultSet.getString("Data");
				String cpf = resultSet.getString("CPF");
				String nome = resultSet.getString("Nome");
				String identcod = resultSet.getString("Identcod");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emprestimos;
	}
	
	
	public ArrayList<Emprestimo> buscarEmprestimosPorCod(String idenc) {
		
		ArrayList<Emprestimo> emprestimos = new ArrayList<>();
		
        String sql = "SELECT * FROM EMPRESTIMO WHERE Identcod like ?";
        try {
			Connection conn = Conexao.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(sql);
			String auxCod = "%"+ idenc+"%"; 

            pst.setString(1, auxCod);

            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
            	String prazo = resultSet.getString("Prazo");
				String data = resultSet.getString("Data");
				String cpf = resultSet.getString("CPF");
				String nome = resultSet.getString("Nome");
				String identcod = resultSet.getString("Identcod");
				Emprestimo l = new Emprestimo(prazo, data, cpf, nome, identcod);
				emprestimos.add(l);

                
            }

            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return emprestimos;
	}
	
	public ArrayList<Emprestimo> buscarEmprestimosPorData(String datac) {
		
		ArrayList<Emprestimo> emprestimos = new ArrayList<>();
		
        String sql = "SELECT * FROM EMPRESTIMO WHERE Data like ?";
        try {
			Connection conn = Conexao.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(sql);
			String auxCod = "%"+ datac+"%"; 

            pst.setString(1, auxCod);

            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
            	String prazo = resultSet.getString("Prazo");
				String data = resultSet.getString("Data");
				String cpf = resultSet.getString("CPF");
				String nome = resultSet.getString("Nome");
				String identcod = resultSet.getString("Identcod");
				Emprestimo l = new Emprestimo(prazo, data, cpf, nome, identcod);
				emprestimos.add(l);

                
            }

            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return emprestimos;
	}
	

}
