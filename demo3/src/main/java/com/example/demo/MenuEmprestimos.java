package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MenuEmprestimos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEmprestimos frame = new MenuEmprestimos();
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
	public MenuEmprestimos() {
		setTitle("Menu de Opções de Pesquisa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Pesquisar por Cod.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExibirEmprestimos o = new ExibirEmprestimos();
				o.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBounds(37, 110, 166, 33);
		contentPane.add(btnNewButton);
		
		JButton btnPesquisarPorData = new JButton("Pesquisar por data");
		btnPesquisarPorData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExibirEmprestimo o = new ExibirEmprestimo();
				o.setVisible(true);
				dispose();
			}
		});
		btnPesquisarPorData.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnPesquisarPorData.setBackground(Color.YELLOW);
		btnPesquisarPorData.setBounds(233, 110, 166, 33);
		contentPane.add(btnPesquisarPorData);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela o = new PrimeiraTela();
				o.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setBounds(10, 199, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Escolha uma opção de pesquisa");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(114, 34, 285, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuEmprestimos.class.getResource("/com/example/demo/Biblioteca.png")));
		lblNewLabel_1.setBounds(0, -14, 434, 374);
		contentPane.add(lblNewLabel_1);
	}

}
