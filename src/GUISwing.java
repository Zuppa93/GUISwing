
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class GUISwing {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu datei = new JMenu("Datei");
        JMenu menuWeg = new JMenu("Menu Weg");
        JMenu titelAndern = new JMenu("Titel Ändern");
        JMenuItem beenden = new JMenuItem("Beenden");
        JLabel ausgabe = new JLabel("Testausgabe");

        datei.add(beenden);

        menuBar.add(datei);
        menuBar.add(menuWeg);
        menuBar.add(titelAndern);

        frame.setJMenuBar(menuBar);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(ausgabe);

        // Listeners
        beenden.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        menuWeg.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBar.setVisible(false);
            }
        });

        ausgabe.addMouseListener(new java.awt.event.MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && e.getButton() == e.BUTTON3) {

                    menuBar.setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        titelAndern.addMouseListener(new java.awt.event.MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JDialog dialog = new JDialog();
                JButton jButtonOK = new JButton("OK");
                JButton jButtonAbbrechen = new JButton("Abbrechen");
                JTextField eingabe = new JTextField();

                dialog.setResizable(false);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setAlwaysOnTop(true);
                frame.setEnabled(false);

                JPanel panel = new JPanel(new GridBagLayout());

                GroupLayout layout = new GroupLayout(panel);
                panel.setLayout(layout);

                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true);
                /*
                Woah wie sick ist das denn ? 
                Keiner Wunder dass in NetBeans immer dieser riesige Haufen Code entstanden ist
                
                Was passiert hier : 
                Der Group Manager enthält 2 Gruppen einmal eine Horizontale und eine Vertikale Gruppe
                Die Elemente die wir dort implementieren wollen müssen in beide Gruppen eingeordnet werden
                
                Dabei ist zu beachten dass man die Elemente sequentiell oder parallel einordnen kann 
                
                Sequentiell bedeutet wir reihen die Elemente nebeneinander ein
                Parallel bedeutet wir stapeln die Elemente aufeinander
                
                Bei der Horizontalen Gruppe sieht das so aus : 
                
                Sequentiell : 
                 _____    _____   _____
                |     |  |     | |     |
                | E1  |  | E2  | | E3  |
                |_____|  |_____| |_____|
                
                Parallel
                 _____  
                |     | 
                | E1  |  
                |_____|                  
                 _____  
                |     | 
                | E1  |  
                |_____|                  
                 _____  
                |     | 
                | E1  |  
                |_____|  
                
                WICHTIG !!!
                
                Bei der Vertialen Gruppe ist die Anordnung umgekehrt
                Dort gilt : 
                
                Sequentiell :
                 _____
                |     | 
                | E1  |  
                |_____|                  
                 _____            
                |     | 
                | E1  |  
                |_____|                  
                 _____  
                |     | 
                | E1  |  
                |_____|  
                
                Parallel                
                 _____    _____   _____
                |     |  |     | |     |
                | E1  |  | E2  | | E3  |
                |_____|  |_____| |_____|
                
                
                 */
                layout.setHorizontalGroup(layout.createParallelGroup()
                        .addComponent(eingabe, 0, 400, 400)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonOK)
                                .addComponent(jButtonAbbrechen)));

                layout.setVerticalGroup(layout.createSequentialGroup()
                        .addComponent(eingabe, 0, 20, 20)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(jButtonOK)
                                .addComponent(jButtonAbbrechen)));

                jButtonOK.addActionListener((ActionEvent evt) -> {

                    frame.setTitle(eingabe.getText());
                    ausgabe.setText(eingabe.getText());
                    frame.setEnabled(true);
                    dialog.dispose();

                });
                
                dialog.addWindowListener( new java.awt.event.WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        frame.setEnabled(true);
                        frame.setAlwaysOnTop(true);
                        dialog.dispose();
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {
                       
                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {
                        
                    }

                    @Override
                    public void windowActivated(WindowEvent e) {
                        }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
                    }
                });

                jButtonAbbrechen.addActionListener((ActionEvent evt) -> {
                    frame.setEnabled(true);
                    dialog.dispose();
                });

                dialog.setSize(200, 100);
                
                dialog.setLocationRelativeTo(frame);
                
                dialog.add(panel);
                dialog.setVisible(true);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.setSize(400, 400);
        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
