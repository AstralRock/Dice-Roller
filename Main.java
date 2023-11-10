import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.time.LocalDateTime;




class frame extends JFrame
{   
    //this sets the window hieght to this percent of your monitor size
    public static final double PERCENT_HEIGHT = 0.8;

    

    public frame() {

        super("DICE-O-MATIC");

        setSize(windowSize().width, windowSize().height);

        // Create main panel and terminal panel
        mainPanel mainPanel = new mainPanel();
        TerminalPanel terminalPanel = new TerminalPanel();

        // Create split pane with main panel on the right and terminal panel on the left
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mainPanel, terminalPanel);
        splitPane.setResizeWeight(0.8);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);

        // Add split pane to frame
        add(splitPane);
        setContentPane(splitPane);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Redirect system streams to terminal panel
        terminalPanel.redirectSystemStreams();
    }

    public Dimension windowSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new Dimension((int) (screenSize.height * PERCENT_HEIGHT * 3/4), (int) (screenSize.height * PERCENT_HEIGHT));
    }

    public class TerminalPanel extends JPanel {
        private JTextArea textArea;

        public TerminalPanel() {
            setLayout(new BorderLayout());
            textArea = new JTextArea();
            textArea.setEditable(false);
            setPreferredSize(new Dimension((int)(windowSize().width * 0.2), windowSize().height));
            add(new JScrollPane(textArea), BorderLayout.CENTER);
            add(button(), BorderLayout.SOUTH);
        }

        public void appendText(String text) {
            textArea.append(text);
            // Scroll to the end of the text area
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }

        public void clear() {
            textArea.setText("");
        }

        

        public void redirectSystemStreams() {
            OutputStream out = new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    appendText(String.valueOf((char) b));
                }

                @Override
                public void write(byte[] b, int off, int len) throws IOException {
                    appendText(new String(b, off, len));
                }

                @Override
                public void write(byte[] b) throws IOException {
                    write(b, 0, b.length);
                }
            };

            System.setOut(new PrintStream(out, true));
            System.setErr(new PrintStream(out, true));
        }
        public JButton button() {
            JButton button = new JButton("Save log");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        LocalDateTime time = LocalDateTime.now();

                        FileOutputStream fos = new FileOutputStream("log-" + time + ".txt");
                        PrintStream ps = new PrintStream(fos);
                        ps.print(textArea.getText());
                        ps.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            return button;
        }
    }

    public class mainPanel extends JPanel {

        public mainPanel() {
            setPreferredSize(new Dimension((int)(windowSize().width * 0.9), windowSize().height));
            setBackground(new Color(255, 230, 230));
            setLayout(new BorderLayout());
            add(characterInput(), BorderLayout.NORTH);
            add(mainButtons(), BorderLayout.CENTER);
            add(textFeildMania(), BorderLayout.SOUTH);
        }
        public JPanel characterInput() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Set layout to BoxLayout
            panel.setBackground(new Color(230, 255, 230));

            JLabel Jl = new JLabel("Enter Character Name: ");
            Jl.setFont(new Font("Papyrus", Font.BOLD, (int)(PERCENT_HEIGHT*50)));
            panel.add(Jl);

            JTextField Jt = new JTextField(10);
            Jt.setFont(new Font("Arial", Font.PLAIN, 40));
            Jt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(Jt.getText());
                    
                }
            });
            panel.add(Jt);
            return panel;
        }

        public JPanel mainButtons() {
            JPanel panel = new JPanel(new GridLayout(5, 3, 10, 10)); // Use GridLayout to create 3 columns, with 10 pixels of horizontal and vertical gap
            panel.setBackground(new Color(230, 230, 255));
            String[][] buttons ={{"Melee","Stealth","Ranged"},
                                 {"Spell","Lock","Tech"},
                                 {"Dodge","Heal","Persuade"},
                                 {"Control","Coin Flip","roll"},
                                 {"Hack 1","Hack 2","Hack 3"}};
            Color[] buttonColors = {new Color(237, 149, 149), new Color(149, 237, 167), new Color(149, 168, 237), new Color(203, 149, 237), new Color(237, 149, 214)};
            
            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons[i].length; j++) {
                    JButton button = new JButton(buttons[i][j]);
                    button.setFont(new Font("Papyrus", Font.BOLD, (int)(PERCENT_HEIGHT*30)));
                    System.out.println(i);
                    button.setBackground(buttonColors[i]);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println(button.getText());
                        }
                    });
                    panel.add(button);
                }
            }
            return panel;
        }
        public JPanel textFeildMania(){
            JPanel panel = new JPanel();

            //block
                JPanel bp = new JPanel(new FlowLayout());
                JLabel bl = new JLabel("Block:");
                JTextField bt = new JTextField(10);
                bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("bro blocked with just"+bt.getText());
                        
                    }
                });
                bp.add(bl);
                bp.add(bt);
        


            panel.add(bp);
            return panel;
        }   
    }
}


public class Main 
{
    public static void main(String[] args) 
    {
        frame f = new frame();

    }
}


