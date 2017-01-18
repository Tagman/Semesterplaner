package GUI;

import Backend.Semesterplan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Confirmation {

    private JFrame frame;
    public  static JLabel ConfirmationText = new JLabel("");

    /**
     * Launch the application.
     * @param sp
     */
    public static void startConfirmation(Semesterplan sp) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Confirmation window = new Confirmation(sp);
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
    public Confirmation(Semesterplan sp) {
        initialize(sp);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Semesterplan sp) {
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

                Object[] etwas = sp.collectArgs();
                for(int i=0; i<etwas.length;i++)
                {
                    Object[] jenes = (Object[])etwas[i];
                    for(int j = 0;i<MainGUI.daten.length;i++)
                    {
                        if(MainGUI.daten[j]==null)
                        {
                            MainGUI.daten[j]=jenes;
                            break;
                        }
                    }

                }
                System.out.println(" for dem aktualisieren");
                MainGUI.aktualisieren(MainGUI.model);
                System.out.println(" danach");

                frame.dispose();
            }
        });
        Bestätigen_button.setBounds(118, 186, 200, 50);
        frame.getContentPane().add(Bestätigen_button);
    }
    public static void confirm( String text)
    {
        ConfirmationText.setText(text);
        System.out.println(text);
    }
}
