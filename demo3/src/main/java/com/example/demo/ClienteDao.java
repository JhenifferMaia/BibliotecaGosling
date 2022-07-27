package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
	
	
	public void salvarCliente(Cliente cliente) {
		
		String sql = "INSERT INTO CLIENTE VALUES (?, ?, ?, ?, ?)";
		
		
		try {
			Connection conn = Conexao.getConnection();
			//connection
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getCpf());
			pst.setString(3, cliente.getTelefone());
			pst.setString(4, cliente.getEmail());
			pst.setString(5, cliente.getEndereco());

			
			pst.execute();
			
			pst.close();
			conn.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	public List<Cliente> buscarClientes(String cpfc) {
		
		List<Cliente> clientes = new ArrayList<>();
		
        String sql = "SELECT * FROM CLIENTE WHERE CPF like ?";
        try {
			Connection conn = Conexao.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(sql);
			String auxCod = "%"+ cpfc+"%"; 

            pst.setString(1, auxCod);

            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
            	String nome = resultSet.getString("Nome");
				String cpf = resultSet.getString("CPF");
				String telefone = resultSet.getString("Telefone");
				String email = resultSet.getString("Email");
				String endereco = resultSet.getString("Endereco");

				Cliente c = new Cliente(nome, cpf, telefone,email, endereco);
				clientes.add(c);

                
            }

            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return clientes;
	}
	
	
	public ArrayList<Cliente> listarCliente() {
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM CLIENTE ";
		//consulta
		
		try {
			Connection conn = Conexao.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet resultSet = pst.executeQuery();
			//retorna o ResultSet (resultado da consulta)
			
			//resultSet.getString(1);
			//resultSet.getString(2);
			
			while(resultSet.next()) {
				String nome = resultSet.getString("Nome");
				String cpf = resultSet.getString("CPF");
				String telefone = resultSet.getString("Telefone");
				String email = resultSet.getString("Email");
				String endereco = resultSet.getString("Endereco");

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	
	

}
