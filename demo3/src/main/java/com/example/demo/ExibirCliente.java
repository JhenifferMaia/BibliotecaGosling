package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ExibirCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfcpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirCliente frame = new ExibirCliente();
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
	public ExibirCliente() {
		setTitle("Pesquisa Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClienteDao l = new ClienteDao();
				String c = tfcpf.getText();
				List<Cliente> listaCliente = l.buscarClientes(c);
				//List<Cliente> v = dao.listarCliente();
				if (listaCliente.isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Nada encontrado. Algo pode ter sido digitado errado" );
					
				}else {
					for (Cliente a : listaCliente) {
						JOptionPane.showMessageDialog(null, a);
					}
					
				
				}
				
				
				
				
				
				
				
				
				/*if (listaCliente.isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Nada encontrado. Algo pode ter sido digitado errado" );
					
				}else {
					ClienteDao dao = new ClienteDao();
					List<Cliente> v = dao.listarCliente();
					
					for (Cliente a : v) {
						JOptionPane.showMessageDialog(null, a);
					}
					
				}*/
			}
		});
		btnNewButton.setBounds(155, 133, 103, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Pesquise usando o CPF do cliente desejado");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(74, 31, 291, 14);
		contentPane.add(lblNewLabel);
		
		tfcpf = new JTextField();
		tfcpf.setBounds(74, 73, 270, 30);
		contentPane.add(tfcpf);
		tfcpf.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela p = new PrimeiraTela();
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setBounds(10, 172, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ExibirCliente.class.getResource("/com/example/demo/Biblioteca.png")));
		lblNewLabel_1.setBounds(0, 0, 426, 206);
		contentPane.add(lblNewLabel_1);
	}

}
