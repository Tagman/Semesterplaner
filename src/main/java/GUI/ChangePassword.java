package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import Backend.Controller;
import Backend.Semesterplan;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Font;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
   
    
  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(143, 100, 212, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNeuesPasswort = new JLabel("neues Passwort");
		lblNeuesPasswort.setBounds(41, 103, 92, 14);
		contentPane.add(lblNeuesPasswort);
		
		JButton btnBesttigen = new JButton("best\u00E4tigen");
		btnBesttigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (
						Controller.isAdmin()
						){
					
					Semesterplan.setPassword(textField.getText());
				
				JOptionPane.showMessageDialog(null, "Passwort erfolgreich ge�ndert!");
				
				}
				else  JOptionPane.showMessageDialog(null, "bitte zuerst als Admin anmelden!");
				
				dispose();
				
				
			}
		});
		btnBesttigen.setBounds(172, 186, 89, 23);
		contentPane.add(btnBesttigen);
		
		JLabel lblPasswortndern = new JLabel("Passwort \u00E4ndern");
		lblPasswortndern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPasswortndern.setBounds(166, 26, 114, 33);
		contentPane.add(lblPasswortndern);
	}
}