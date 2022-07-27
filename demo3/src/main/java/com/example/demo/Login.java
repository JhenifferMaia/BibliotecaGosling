package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfnome;
	private JPasswordField tfsenha;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfnome = new JTextField();
		tfnome.setBounds(132, 71, 163, 27);
		contentPane.add(tfnome);
		tfnome.setColumns(10);
		
		tfsenha = new JPasswordField();
		tfsenha.setBounds(132, 109, 163, 27);
		contentPane.add(tfsenha);
		
		JLabel lblNewLabel = new JLabel("Usuário:");
		lblNewLabel.setBounds(66, 77, 56, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(66, 115, 56, 14);
		contentPane.add(lblSenha);
		

			//@SuppressWarnigs("unchecked")
		

		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					Connection conn = Conexao.getConnection();
					
					String sql = "SELECT*FROM USUARIO WHERE nome =? AND senha=?";
					
					PreparedStatement pst = conn.prepareStatement(sql);
					
					pst.setString(1, tfnome.getText());
					
//					pst.setString(2,tfsenha.getText())
					
					pst.setString(2,new String(tfsenha.getPassword()));
					
					ResultSet result = pst.executeQuery();
						
					if(result.next()) {
						
						
						
						setVisible(false);
						
						PrimeiraTela j = new PrimeiraTela();
						j.setVisible(true);
						dispose();						
						//j.fecharJ(this);
						
						//p.entrarButMouseClicked(e);
						
						
						//JOptionPane.showMessageDialog(null,"existe");
						
						
					}else {
						
						JOptionPane.showMessageDialog(null,"Credenciais Erradas");

						
					}
					
					pst.close();
					conn.close();
				}catch(SQLException a){
					
					a.printStackTrace();
				}
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(170, 191, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/com/example/demo/Biblioteca.png")));
		lblNewLabel_1.setBounds(0, 0, 434, 351);
		contentPane.add(lblNewLabel_1);
	}
}
