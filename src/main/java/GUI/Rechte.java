package GUI;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Rechte {

	private JFrame frame;

	/**cx
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rechte window = new Rechte();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Rechte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblRechte = new JLabel("Rechte");
		lblRechte.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JTextPane txtAdmin = new JTextPane();
		txtAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAdmin.setText("Der Admin besitzt Lese- und Schreibrechte.");
		txtAdmin.setEditable(false);

		JTextPane txtGast = new JTextPane();
		txtGast.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGast.setText("Der Gast besitzt Leserechte. Er kann außerdem die Ansichten wechseln.");
		txtGast.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(39)
								.addComponent(txtAdmin, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
								.addComponent(txtGast, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
								.addGap(71))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(273)
								.addComponent(lblRechte, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(316, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(21)
								.addComponent(lblRechte, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGap(38)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtAdmin, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtGast, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(52, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}