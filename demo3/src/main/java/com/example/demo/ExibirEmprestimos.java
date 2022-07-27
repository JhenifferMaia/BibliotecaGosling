package com.example.demo;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JPopupMenu;


import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class ExibirEmprestimos extends JFrame {

	private JPanel contentPane;
	private JTextField tfcod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirEmprestimos frame = new ExibirEmprestimos();
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
	public ExibirEmprestimos() {
		setTitle("Pesquisar Emprestimos Por Cod");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escreva o código de identificação do empréstimo");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(53, 35, 319, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EmprestimoDao l = new EmprestimoDao();
				
				String c = tfcod.getText();
				
				List<Emprestimo> listaEmprestimos = l.buscarEmprestimosPorCod(c);
				
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
		btnNewButton.setBounds(169, 168, 89, 23);
		contentPane.add(btnNewButton);
		
		tfcod = new JTextField();
		tfcod.setBounds(123, 88, 190, 28);
		contentPane.add(tfcod);
		tfcod.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela p =new PrimeiraTela();
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ExibirEmprestimos.class.getResource("/com/example/demo/Biblioteca.png")));
		lblNewLabel_1.setBounds(0, -65, 434, 326);
		contentPane.add(lblNewLabel_1);
		
		
			
			
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
