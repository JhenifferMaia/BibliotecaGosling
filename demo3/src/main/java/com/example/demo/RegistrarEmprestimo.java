package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class RegistrarEmprestimo extends JFrame {

	private JPanel contentPane;
	private JTextField tfprazo;
	private JTextField tfdataa;
	private JTextField tfcpff;
	private JTextField tfnomee;
	private JTextField tfcod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEmprestimo frame = new RegistrarEmprestimo();
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
	public RegistrarEmprestimo() {
		setTitle("Registro de Emprestimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfprazo = new JTextField();
		tfprazo.setBounds(131, 38, 207, 33);
		contentPane.add(tfprazo);
		tfprazo.setColumns(10);
		
		tfdataa = new JTextField();
		tfdataa.setColumns(10);
		tfdataa.setBounds(131, 92, 207, 33);
		contentPane.add(tfdataa);
		
		tfcpff = new JTextField();
		tfcpff.setColumns(10);
		tfcpff.setBounds(131, 156, 207, 33);
		contentPane.add(tfcpff);
		
		tfnomee = new JTextField();
		tfnomee.setColumns(10);
		tfnomee.setBounds(131, 221, 207, 33);
		contentPane.add(tfnomee);
		
		JLabel lblNewLabel = new JLabel("Prazo:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNewLabel.setBounds(75, 47, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblData.setBounds(75, 101, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblCpf.setBounds(75, 165, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do cliente:");
		lblNomeDoCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNomeDoCliente.setBounds(25, 230, 96, 14);
		contentPane.add(lblNomeDoCliente);
		
		tfcod = new JTextField();
		tfcod.setColumns(10);
		tfcod.setBounds(131, 281, 207, 33);
		contentPane.add(tfcod);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					EmprestimoDao l = new EmprestimoDao();
					
					
					Connection conn = Conexao.getConnection();
					

					String sql = "INSERT INTO EMPRESTIMO (Prazo, Data, CPF, Nome) VALUES(?, ?, ?, ?, ?);";
					PreparedStatement pst = conn.prepareStatement(sql);

					
					

					pst.setString(1, tfprazo.getText());
					pst.setString(2,tfdataa.getText());
					pst.setString(3,tfcpff.getText());
					pst.setString(4,tfnomee.getText());
					pst.setString(5,tfcod.getText());
					Emprestimo em = new Emprestimo(tfprazo.getText(), tfdataa.getText(), tfcpff.getText(),tfnomee.getText(), tfcod.getText());//new String(pst.setString(1, tfautor.getText())), new String(pst.setString(2,tftitulo.getText())),pst.setString(3,tfgenero.getText()),pst.setString(4,tfcod.getText()));
					l.registrarEmprestimo(em);
					
					//pst.setString(5, tfidentcod.);
					
					//pst.setString(5, );
					//Emprestimo v = new Emprestimo(tfprazo.getText(), tfdataa.getText(), tfcpff.getText(),tfnomee.getText());
					//l.registrarEmprestimo(v);

					pst.close();
					conn.close();
					
					JOptionPane.showMessageDialog(null,"Registrada Com Sucesso");
					
				}catch (SQLException a){
					
					a.printStackTrace();
					//String r = "Preencha todos os campos corretamente";

					JOptionPane.showMessageDialog(null,"Preencha todos os campos corretamente");				}
			}
		});
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBounds(328, 325, 96, 33);
		contentPane.add(btnNewButton);
		
		
		JLabel lblCodDeIdent = new JLabel("Cod. de Ident.:");
		lblCodDeIdent.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblCodDeIdent.setBounds(25, 290, 96, 14);
		contentPane.add(lblCodDeIdent);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela p = new PrimeiraTela();
				p.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBackground(Color.YELLOW);
		btnVoltar.setBounds(25, 325, 96, 33);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RegistrarEmprestimo.class.getResource("/com/example/demo/Biblioteca.png")));
		lblNewLabel_1.setBounds(0, 0, 434, 370);
		contentPane.add(lblNewLabel_1);
	}
}
