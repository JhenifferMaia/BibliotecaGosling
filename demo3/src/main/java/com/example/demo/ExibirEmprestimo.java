package com.example.demo;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;

import java.util.List;
import java.awt.event.ActionEvent;

public class ExibirEmprestimo extends JFrame {

	private JPanel contentPane;
	private JTextField tfdata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirEmprestimo frame = new ExibirEmprestimo();
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
	public ExibirEmprestimo() {
		setTitle("Procurar Empréstimo Por Data Feito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite a data que deseja ver os empréstimos (use \"/\")");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(40, 27, 354, 31);
		contentPane.add(lblNewLabel);
		
		tfdata = new JTextField();
		tfdata.setBounds(88, 87, 269, 31);
		contentPane.add(tfdata);
		tfdata.setColumns(10);
		
		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmprestimoDao l = new EmprestimoDao();
				
				String c = tfdata.getText();
				
				List<Emprestimo> listaEmprestimos = l.buscarEmprestimosPorData(c);
				
				if (listaEmprestimos.isEmpty()) {

					JOptionPane.showMessageDialog(null,"Nada encontrado" );
				}else {
					for (Emprestimo a : listaEmprestimos) {
						JOptionPane.showMessageDialog(null, a);
					}
				}
			}
		});
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton.setBounds(320, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela p = new PrimeiraTela();
				p.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnVoltar.setBackground(Color.YELLOW);
		btnVoltar.setBounds(25, 213, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ExibirEmprestimo.class.getResource("/com/example/demo/Biblioteca.png")));
		lblNewLabel_1.setBounds(0, 0, 434, 334);
		contentPane.add(lblNewLabel_1);
	}
}
