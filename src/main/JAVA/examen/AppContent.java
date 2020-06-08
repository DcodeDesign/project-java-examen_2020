package examen;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class AppContent {

    // JTextField field
    private String field_text = "";
    private boolean field_editable = true;
    Font field_font = new Font("SansSerif", Font.BOLD, 20);
    private JTextField field = new JTextField(field_text);

    // JButton button Coder
    private String button_coder_text = "Coder";
    private JButton button_coder = new JButton(button_coder_text);

    // JButton button reset
    private String button_reset_text = "Reset";
    private JButton button_reset = new JButton(button_reset_text);

    // JLabel button
    private String label_text = "Attention seul les Majuscules et les caractères spéciaux sont accepté.";
    Font label_font = new Font("SansSerif", Font.BOLD, 12);
    private JLabel jLabel = new JLabel(label_text);

    CoderButtonAction btnActions;
    ResetButtonAction resetButtonAction;
    KeyActions keyActions;

    public AppContent(JFrame window, JPanel textFormPanel, JPanel buttonGeneratePanel) {

        // JPanel textFormPanel
        textFormPanel.setLayout(new FlowLayout());
        textFormPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
        textFormPanel.setBackground(new Color(241, 241, 241));

        // JPanel buttonGeneratePanel
        buttonGeneratePanel.setLayout(new FlowLayout());
        buttonGeneratePanel.setBorder(new EmptyBorder(20, 10, 10, 10));
        buttonGeneratePanel.setBackground(new Color(64, 64, 64));

        // JTextField field
        jLabel.setFont(label_font);
        jLabel.setForeground(new Color(85, 85, 85));
        jLabel.setPreferredSize(new Dimension(450, 20));
        jLabel.setVerticalAlignment(JLabel.TOP);
        jLabel.setVerticalTextPosition(JLabel.TOP);
        textFormPanel.add(jLabel);

        // JTextField field
        field.setEditable(field_editable);
        field.setFont(field_font);
        field.setColumns(18);
        field.setForeground(new Color(85, 85, 85));
        Border border = BorderFactory.createLineBorder(new Color(212, 212, 212), 1);
        field.setBorder(border);
        textFormPanel.add(field);

        // JButton button Coder
        button_coder.setPreferredSize(new Dimension(110, 35));
        field.setFont(field_font);
        textFormPanel.add(button_coder);

        // JButton button Reset
        button_reset.setPreferredSize(new Dimension(110, 35));
        button_reset.setVisible(false);
        textFormPanel.add(button_reset);

        // Action du bouton Coder
        button_coder.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new CoderButtonAction(e, field, buttonGeneratePanel, window, button_reset);
                }
            }
        );

        // Action du bouton reset
        button_reset.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ResetButtonAction(e, field, buttonGeneratePanel, button_coder);
                    }
                }
        );

        // Action sur le champs
        field.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    new KeyActions(e, field, jLabel);
                }
            }
        );
    }
}
