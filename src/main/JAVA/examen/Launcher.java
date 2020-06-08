package examen;

import javax.swing.*;
import java.awt.*;

public class Launcher extends JFrame  {
    private JFrame window = new JFrame(getClass().getName());
    private JPanel containerPanel = new JPanel();
    private JPanel TextFormPanel = new JPanel();
    private JPanel buttonGeneratePanel = new JPanel();

    public Launcher() {
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(500, 111);
        window.setBackground(Color.WHITE);

        containerPanel.setLayout(new FlowLayout());
        containerPanel.setBackground(new Color( 85, 85, 85));

        TextFormPanel.setBackground(Color.WHITE);
        TextFormPanel.setPreferredSize(new Dimension(500, 80));

        buttonGeneratePanel.setBackground(Color.RED);
        buttonGeneratePanel.setPreferredSize(new Dimension(500, 300));

        new AppContent(window, TextFormPanel, buttonGeneratePanel);

        containerPanel.add(TextFormPanel);
        containerPanel.add(buttonGeneratePanel);
        window.add(containerPanel);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame jframe = new Launcher();
    }
}
