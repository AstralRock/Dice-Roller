import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.time.LocalDate;
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
        return new Dimension((int) (screenSize.height * PERCENT_HEIGHT * 3/2), (int) (screenSize.height * PERCENT_HEIGHT));
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
        private JTextField textField;

        public mainPanel() {
            super(new BorderLayout());
            add(new JLabel("Hello World"), BorderLayout.CENTER);
            setPreferredSize(new Dimension((int)(windowSize().width * 0.9), windowSize().height));
            add(createTextField(), BorderLayout.SOUTH);
        }

        private JTextField createTextField() {
            textField = new JTextField();
            textField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = textField.getText();
                    System.out.println("User input: " + input);
                    textField.setText("");
                }
            });
            int textFieldHeight = (int) (getHeight() * 0.05);
            int textFieldWidth = textFieldHeight * 3;
            int textFieldX = (int) (getWidth() * 0.1);
            int textFieldY = (int) (getHeight() * 0.1);
            textField.setBounds(textFieldX, textFieldY, textFieldWidth, textFieldHeight);
            return textField;
        }
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        frame f = new frame();
        String[] hurtFulMessages = {"Tyler smells", "chatGPT is bad at it's job", "severe copium defficiency","L+RATIO+CLOWN"};
        for (int i = 0; i < 100; i++) {
            System.out.println(hurtFulMessages[(int)(Math.random() * hurtFulMessages.length)]);
        }
    }
}


