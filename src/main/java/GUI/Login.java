package GUI;

import java.awt.EventQueue;
import javax.swing.JOptionPane;




import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import Backend.Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;




public class Login implements ActionListener {

    private JFrame frame;
    private JTextField textField;
    private JComboBox combo1;

    private Controller controller = new Controller();

    String password = "123";

    String passwordEntered;

    private boolean pwCorrect = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
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
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);


        btnLogin.setBounds(181, 203, 89, 23);
        frame.getContentPane().add(btnLogin);


        JLabel lblBenutzername = new JLabel("Benutzername");
        lblBenutzername.setBounds(30, 95, 97, 32);
        frame.getContentPane().add(lblBenutzername);

        JLabel lblPasswort = new JLabel("Passwort");
        lblPasswort.setBounds(30, 145, 97, 32);
        frame.getContentPane().add(lblPasswort);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(199, 11, 39, 44);
        frame.getContentPane().add(lblLogin);

		/*JPanel panel = new JPanel();
		String comboBoxListe[] = {"Admin", "Gast"};
		JComboBox comboBox = new JComboBox(comboBoxListe);
		panel.add(comboBox);
		*/

        combo1 = new JComboBox();
        combo1.setModel(new DefaultComboBoxModel(new String[]{}));
        combo1.setToolTipText("");
        combo1.setBounds(133, 95, 196, 32);
        frame.getContentPane().add(combo1);
        combo1.addItem("Admin");
        combo1.addItem("Gast");


	     		/*JComboBox selectedChoice = (JComboBox) e.getSource();
	    		  	if ("Admin".equals(selectedChoice.getSelectedItem() ) )
	    		  		System.out.println(selectedChoice.getSelectedItem());  //ausgabe
	    			btnLogin.addActionListener(this);
	    	        btnLogin.addActionListener(new ActionListener() {

	    	            public void actionPerformed(ActionEvent e)
	    	            {
	    	            	if (passwordEntered.equals(password)  ) {
	    	            		JOptionPane.showMessageDialog(null,"richtig");
	    	            	}
	    	            	else {

	    	            	    JOptionPane.showMessageDialog(null,"Passwort falsch");
	    	            	    passwordEntered = (JOptionPane.showInputDialog("Neu eingeben"));
	    	            }

	    	            }
	    	        });
	    		  	*/


        textField = new JTextField();
        textField.setBounds(133, 145, 196, 32);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        passwordEntered = textField.getText();

        if (combo1.getSelectedItem().equals("Admin")) {

            while(!pwCorrect) {

                if (passwordEntered.equals(password)) {
                    JOptionPane.showMessageDialog(null, "richtig");
                    pwCorrect = true;
                    controller.setAdmin(true);
                    
                    MainGUI.main(null);
                    
                    

                    /*
                    HIER CODE FÜR WEITERLEITUNG ZUM NÃ„CHSTEN FENSTER EINFÃœGEN COmmit
                     */
                } else {

                    JOptionPane.showMessageDialog(null, "Passwort falsch");
                    passwordEntered = (JOptionPane.showInputDialog("Neu eingeben"));


                }
            }

        }else {
        	 MainGUI.main(null);
        }
    }
}

