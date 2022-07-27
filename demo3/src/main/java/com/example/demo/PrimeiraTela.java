package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PrimeiraTela extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraTela frame = new PrimeiraTela();
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
	public PrimeiraTela() {
		setTitle("Biblioteca Gosling");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 395);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem-vindo(a) ao sistema da biblioteca Gosling. ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(66, 22, 467, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Cliente");
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrodeCliente c = new CadastrodeCliente();
				c.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(58, 93, 134, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Cadastrar Livros");
		btnNewButton_1_1.setBackground(Color.YELLOW);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastrodeLivros c = new CadastrodeLivros();
				c.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_1.setBounds(235, 93, 134, 32);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Pesquisar Livros");
		btnNewButton_1_1_1.setBackground(Color.YELLOW);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExibirLivros l = new ExibirLivros();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setBounds(235, 152, 134, 32);
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha um opção:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(146, 51, 134, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Pesquisar Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExibirCliente c = new ExibirCliente();
				c.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBounds(58, 152, 134, 32);
		contentPane.add(btnNewButton);
		
		JButton btnPesquisarEmprstimos = new JButton("Pesquisar Empréstimos");
		btnPesquisarEmprstimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEmprestimos m = new MenuEmprestimos();
				m.setVisible(true);
				dispose();
			}
		});
		btnPesquisarEmprstimos.setBackground(Color.YELLOW);
		btnPesquisarEmprstimos.setBounds(235, 212, 180, 32);
		contentPane.add(btnPesquisarEmprstimos);
		
		JButton btnRegistrarEmprstimos = new JButton("Registrar Empréstimos");
		btnRegistrarEmprstimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEmprestimo v = new RegistrarEmprestimo();
				v.setVisible(true);
				dispose();
			}
		});
		btnRegistrarEmprstimos.setBackground(Color.YELLOW);
		btnRegistrarEmprstimos.setBounds(12, 212, 180, 32);
		contentPane.add(btnRegistrarEmprstimos);
		
		JButton btnNewButton_1_2 = new JButton("Emprestimos por data");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExibirEmprestimo p = new ExibirEmprestimo();
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setBackground(Color.YELLOW);
		btnNewButton_1_2.setBounds(12, 273, 180, 32);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Emprestimos por cod.");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExibirEmprestimo v = new ExibirEmprestimo();
				v.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2_1.setBackground(Color.YELLOW);
		btnNewButton_1_2_1.setBounds(235, 273, 180, 32);
		contentPane.add(btnNewButton_1_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(PrimeiraTela.class.getResource("/com/example/demo/Biblioteca.png")));
		lblNewLabel_1_1_1.setBounds(0, -21, 425, 389);
		contentPane.add(lblNewLabel_1_1_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cadastrar Cliente");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Cadastrar Livros");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	void entrarButMouseClicked(ActionEvent e) { 
		PrimeiraTela p = new PrimeiraTela(); 
		p.setVisible(true); 
		dispose(); 
	}
	
	public void fecharJ(Login e) {
        this.fecharJ(e);
        e.setVisible(true);
        e.setVisible(false);
    }
}
