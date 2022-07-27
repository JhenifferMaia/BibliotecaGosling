package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrodeLivros extends JFrame {

	private JPanel contentPane;
	private JTextField autor;
	private JTextField titulo;
	private JTextField cod;
	private JTextField genero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrodeLivros frame = new CadastrodeLivros();
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
	public CadastrodeLivros() {
		setTitle("Cadastro Livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 266);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		autor = new JTextField();
		autor.setBackground(new Color(230, 230, 250));
		autor.setBounds(53, 38, 169, 29);
		contentPane.add(autor);
		autor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Autor:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGnero = new JLabel("Gênero:");
		lblGnero.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblGnero.setBounds(264, 92, 46, 14);
		contentPane.add(lblGnero);
		String excecao = "Selecione uma opção";
		LivroDao livro = new LivroDao();
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblTitulo.setBounds(10, 92, 46, 14);
		contentPane.add(lblTitulo);
		
		titulo = new JTextField();
		titulo.setBackground(new Color(230, 230, 250));
		titulo.setColumns(10);
		titulo.setBounds(53, 86, 169, 29);
		contentPane.add(titulo);
		
		JLabel lblCdigoDeIdentificao = new JLabel("Cod. de Ident.:");
		lblCdigoDeIdentificao.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblCdigoDeIdentificao.setBounds(232, 44, 105, 14);
		contentPane.add(lblCdigoDeIdentificao);
		
		cod = new JTextField();
		cod.setBackground(new Color(230, 230, 250));
		cod.setColumns(10);
		cod.setBounds(313, 38, 116, 29);
		contentPane.add(cod);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					LivroDao l = new LivroDao();
					Connection conn = Conexao.getConnection();
					

					String sql = "INSERT INTO LIVRO (Autor, Titulo, Genero, Cod) VALUES(?,?,?,?);";
					PreparedStatement pst = conn.prepareStatement(sql);

					
					

					pst.setString(1, autor.getText());
					pst.setString(2,titulo.getText());
					pst.setString(3,genero.getText());
					pst.setString(4,cod.getText());
					Livro livro = new Livro(autor.getText(), titulo.getText(), genero.getText(),cod.getText());//new String(pst.setString(1, tfautor.getText())), new String(pst.setString(2,tftitulo.getText())),pst.setString(3,tfgenero.getText()),pst.setString(4,tfcod.getText()));
					l.salvarLivro(livro);

					pst.close();
					conn.close();
					
					//System.exit(EXIT_ON_CLOSE);
					
				}catch (SQLException a){
					
					a.printStackTrace();
					JOptionPane.showMessageDialog(btnNewButton, a, excecao, ABORT, null);
				}
				//PrimeiraTela t = new PrimeiraTela();
				//t.setVisible(true);
			}
	
			
		});
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setBackground(new Color(138, 43, 226));
		btnNewButton.setBounds(313, 176, 116, 40);
		contentPane.add(btnNewButton);
		
		genero = new JTextField();
		genero.setBounds(313, 86, 116, 29);
		contentPane.add(genero);
		genero.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setForeground(new Color(230, 230, 250));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela l = new PrimeiraTela();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(138, 43, 226));
		btnNewButton_1.setBounds(10, 176, 105, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CadastrodeLivros.class.getResource("/com/example/demo/Biblioteca.png")));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(0, -94, 439, 321);
		contentPane.add(lblNewLabel_1);
	}
}
