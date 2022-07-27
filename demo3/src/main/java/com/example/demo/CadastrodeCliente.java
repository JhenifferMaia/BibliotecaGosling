package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CadastrodeCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfnome;
	private JTextField tfcpf;
	private JTextField tftelefone;
	private JTextField tfendereco;
	private JTextField tfemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrodeCliente frame = new CadastrodeCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrodeCliente() {
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 344);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nome = new JLabel("Nome:");
		nome.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		nome.setBounds(86, 38, 46, 14);
		contentPane.add(nome);
		
		JLabel cpf = new JLabel("CPF:");
		cpf.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		cpf.setBounds(86, 85, 46, 14);
		contentPane.add(cpf);
		
		JLabel Telefone = new JLabel("Telefone:");
		Telefone.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		Telefone.setBounds(86, 132, 64, 14);
		contentPane.add(Telefone);
		
		JLabel endereco = new JLabel("Endereço:");
		endereco.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		endereco.setBounds(86, 180, 64, 14);
		contentPane.add(endereco);
		
		JLabel Email = new JLabel("E-mail:");
		Email.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		Email.setBounds(86, 225, 46, 14);
		contentPane.add(Email);
		
		tfnome = new JTextField();
		tfnome.setBounds(142, 33, 170, 26);
		contentPane.add(tfnome);
		tfnome.setColumns(10);
		
		tfcpf = new JTextField();
		tfcpf.setColumns(10);
		tfcpf.setBounds(142, 80, 170, 26);
		contentPane.add(tfcpf);
		
		tftelefone = new JTextField();
		tftelefone.setColumns(10);
		tftelefone.setBounds(142, 127, 170, 26);
		contentPane.add(tftelefone);
		
		tfendereco = new JTextField();
		tfendereco.setColumns(10);
		tfendereco.setBounds(142, 175, 170, 26);
		contentPane.add(tfendereco);
		
		tfemail = new JTextField();
		tfemail.setColumns(10);
		tfemail.setBounds(142, 220, 170, 26);
		contentPane.add(tfemail);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBackground(new Color(138, 43, 226));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					ClienteDao l = new ClienteDao();
					Connection conn = Conexao.getConnection();
					

					String sql = "INSERT INTO CLIENTE(Nome, CPF, Telefone, Email, Endereco) VALUES (?, ?, ?, ?, ?)";
					
					PreparedStatement pst = conn.prepareStatement(sql);

					
					

					pst.setString(1, tfnome.getText());
					pst.setString(2,tfcpf.getText());
					pst.setString(3,tftelefone.getText());
					pst.setString(4, tfemail.getText());
					pst.setString(5, tfendereco.getText());
					
					Cliente cliente = new Cliente(tfnome.getText(), tfcpf.getText(), tftelefone.getText(), tfemail.getText(), tfendereco.getText());

					l.salvarCliente(cliente);
					
					JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso" );

					pst.close();
					conn.close();
					
				}catch (SQLException a){
					
					a.printStackTrace();
				}
			
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton.setBounds(288, 271, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela p = new PrimeiraTela();
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(138, 43, 226));
		btnNewButton_1.setBounds(10, 272, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastrodeCliente.class.getResource("/com/example/demo/Biblioteca.png")));
		lblNewLabel.setBounds(0, 0, 399, 337);
		contentPane.add(lblNewLabel);
	}
}
