package examen;

import javax.swing.*;
import java.awt.*;

public class Launcher extends JFrame  {

    public Launcher() {
        JFrame window = new JFrame(getClass().getName());
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(500, 111);
        window.setBackground(Color.WHITE);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new FlowLayout());
        containerPanel.setBackground(new Color( 85, 85, 85));

        JPanel textFormPanel = new JPanel();
        textFormPanel.setBackground(Color.WHITE);
        textFormPanel.setPreferredSize(new Dimension(500, 80));

        JPanel buttonGeneratePanel = new JPanel();
        buttonGeneratePanel.setBackground(Color.RED);
        buttonGeneratePanel.setPreferredSize(new Dimension(500, 300));

        ContentPanel contentPanel = new ContentPanel(window, textFormPanel, buttonGeneratePanel);
        contentPanel.content();

        containerPanel.add(textFormPanel);
        containerPanel.add(buttonGeneratePanel);
        window.add(containerPanel);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    public static void main(String[] args) { new Launcher(); }
}
