package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Suchen {

    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Suchen window = new Suchen();
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
    public Suchen() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblSuchenVonEinheiten = new JLabel("Suchen von Einheiten und Terminen");
        lblSuchenVonEinheiten.setBounds(0, 0, 484, 33);
        lblSuchenVonEinheiten.setFont(new Font("Tahoma", Font.PLAIN, 27));
        frame.getContentPane().add(lblSuchenVonEinheiten);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Name der Veranstaltung", "Veranstaltungsart", "Startzeit", "Endzeit", "Raumbezeichnung", "Name des Lehrenden", "Datum", "Intervall", "Pflicht (true oder false als Begriff)"}));
        comboBox.setToolTipText("W\u00E4hlen sie hier bitte einen Filter f\u00FCr ihre Suchergebnisse aus.");
        comboBox.setBounds(10, 83, 437, 35);
        frame.getContentPane().add(comboBox);

        JLabel lblGewnschterSuchbereich = new JLabel("Gew\u00FCnschter Suchbereich");
        lblGewnschterSuchbereich.setBounds(9, 58, 139, 14);
        frame.getContentPane().add(lblGewnschterSuchbereich);

        textField = new JTextField();
        textField.setToolTipText("Hier bitte den Schl\u00FCsselbegriff eingeben nach welchem gesucht werden soll.");
        textField.setBounds(10, 154, 437, 33);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblSuchbegriff = new JLabel("Suchbegriff");
        lblSuchbegriff.setBounds(10, 129, 138, 14);
        frame.getContentPane().add(lblSuchbegriff);

        JButton btnNewButton = new JButton("Suchen");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                int Filter = comboBox.getSelectedIndex();
                String Suchwort = textField.getText();
                if(Filter==0)
                {
                    for(int i=0;i<=MainGUI.daten.length; i++)
                    {
                        Object[] inhalt = (Object[]) MainGUI.daten[i];
                        if (Suchwort.equals(""+inhalt[Filter]+"")) {
                            System.out.println(Suchwort+" gefunden!");
                            break;
                        }
                    }
                }
                else if(Filter == 1)
                {
                    for(int i=0;i<=MainGUI.daten.length; i++)
                    {
                        Object[] inhalt = (Object[]) MainGUI.daten[i];
                        if (Suchwort.equals(""+inhalt[Filter]+"")) {
                            //Tu Was
                            break;
                        }
                    }
                }
                else if(Filter == 2)
                {
                    for(int i=0;i<=MainGUI.daten.length; i++)
                    {
                        Object[] inhalt = (Object[]) MainGUI.daten[i];
                        if (Suchwort.equals(""+inhalt[Filter]+"")) {
                            //Tu Was
                            break;
                        }
                    }
                }
                else if(Filter == 3)
                {
                    for(int i=0;i<=MainGUI.daten.length; i++)
                    {
                        Object[] inhalt = (Object[]) MainGUI.daten[i];
                        if (Suchwort.equals(""+inhalt[Filter]+"")) {
                            //Tu Was
                            break;
                        }
                    }
                }
                else if(Filter == 4)
                {
                    for(int i=0;i<=MainGUI.daten.length; i++)
                    {
                        Object[] inhalt = (Object[]) MainGUI.daten[i];
                        if (Suchwort.equals(""+inhalt[Filter]+"")) {
                            //Tu Was
                            break;
                        }
                    }
                }
                else if(Filter == 5)
                {
                    for(int i=0;i<=MainGUI.daten.length; i++)
                    {
                        Object[] inhalt = (Object[]) MainGUI.daten[i];
                        if (Suchwort.equals(""+inhalt[Filter]+"")) {
                            //Tu Was
                            break;
                        }
                    }
                }
                else if(Filter == 6)
                {
                    for(int i=0;i<=MainGUI.daten.length; i++)
                    {
                        Object[] inhalt = (Object[]) MainGUI.daten[i];
                        if (Suchwort.equals(""+inhalt[Filter]+"")) {
                            //Tu Was
                            break;
                        }
                    }
                }
                else if(Filter == 7)
                {
                    for(int i=0;i<=MainGUI.daten.length; i++)
                    {
                        Object[] inhalt = (Object[]) MainGUI.daten[i];
                        if (Suchwort.equals(""+inhalt[Filter]+"")) {
                            //Tu Was
                            break;
                        }
                    }
                }
                else if(Filter == 8)
                {
                    for(int i=0;i<=MainGUI.daten.length; i++)
                    {
                        Object[] inhalt = (Object[]) MainGUI.daten[i];
                        if (Suchwort.equals(""+inhalt[Filter]+"")) {
                            //Tu Was
                            break;
                        }
                    }
                }
            }
        });
        btnNewButton.setBounds(173, 217, 117, 33);
        frame.getContentPane().add(btnNewButton);
    }
}