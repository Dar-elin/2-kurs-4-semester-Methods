import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class lb2 {
    private JPanel lb2;
    private JTextField textField1;
    private JButton button1;
    private JLabel label;


    public lb2() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] characters = textField1.getText().toCharArray();
                String newStringg = "";
                for (char ch : characters) {
                    newStringg = newStringg + ch + " ";
                }
                label.setText(newStringg);
            }
        });
    }

    private void createUIComponents() {
        lb2 = new JPanel();
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("lb2");
        jFrame.setContentPane(new lb2().lb2);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
