package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ExibirLivros extends JFrame {

	private JPanel contentPane;
	
	//LivroTableModel t = new LivroTableModel();
	private JTextField tfcod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirLivros frame = new ExibirLivros();
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
	public ExibirLivros() {
		setTitle("Livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 261);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lcod = new JLabel("Digite o código de identificação");
		Lcod.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		Lcod.setBounds(110, 31, 258, 20);
		contentPane.add(Lcod);
		
		tfcod = new JTextField();
		tfcod.setBounds(100, 93, 220, 33);
		contentPane.add(tfcod);
		tfcod.setColumns(10);
		
		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				LivroDao l = new LivroDao();
				String c = tfcod.getText();
				List<Livro> listaLivros = l.buscarLivros(c);
				if (listaLivros.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nada encontrado" );
				}else {
					for (Livro a : listaLivros) {
						JOptionPane.showMessageDialog(null, a);
					}
				}
			}
			
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton.setBounds(316, 169, 108, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela p = new PrimeiraTela();
				p.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setBounds(10, 170, 108, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ExibirLivros.class.getResource("/com/example/demo/Biblioteca.png")));
		lblNewLabel.setBounds(0, -12, 434, 234);
		contentPane.add(lblNewLabel);
	}
}
