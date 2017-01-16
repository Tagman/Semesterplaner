package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Confirmation {

    private JFrame frame;
    public  static JLabel ConfirmationText = new JLabel("");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Confirmation window = new Confirmation();
                    window.frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Confirmation() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        ConfirmationText.setBounds(10, 11, 414, 164);
        frame.getContentPane().add(ConfirmationText);

        JButton Bestätigen_button = new JButton("Best\u00E4tigen");
        Bestätigen_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0)
            {
                MainGUI.aktualisieren();
                frame.dispose();
            }
        });
        Bestätigen_button.setBounds(118, 186, 200, 50);
        frame.getContentPane().add(Bestätigen_button);
    }
    public static void confirm( String text)
    {
        ConfirmationText.setText(text);
    }
}
