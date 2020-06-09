package examen;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ContentPanel {

    // JTextField field
    private String fieldText = "";
    private JTextField field = new JTextField(fieldText);

    // JButton button Coder
    private final String buttonCoder_text = "Coder";
    private final JButton buttonCoder = new JButton(buttonCoder_text);

    // JButton button reset
    private final String buttonReset_text = "Reset";
    private final JButton buttonReset = new JButton(buttonReset_text);

    // JLabel button
    private final String message_text = "Attention seul les Majuscules et les caractères spéciaux sont accepté.";
    private final JLabel message = new JLabel(message_text);
    private final JFrame window;
    private final JPanel textFormPanel;
    private final JPanel buttonGeneratePanel;

    public ContentPanel(JFrame window, JPanel textFormPanel, JPanel buttonGeneratePanel) {
        this.window = window;
        this.textFormPanel = textFormPanel;
        this.buttonGeneratePanel = buttonGeneratePanel;
    }

    public void content() {
        // JPanel textFormPanel
        textFormPanel.setLayout(new FlowLayout());
        textFormPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
        textFormPanel.setBackground(new Color(241, 241, 241));

        // JPanel buttonGeneratePanel
        buttonGeneratePanel.setLayout(new FlowLayout());
        buttonGeneratePanel.setBorder(new EmptyBorder(20, 10, 10, 10));
        buttonGeneratePanel.setBackground(new Color(64, 64, 64));

        // JTextField field
        Font message_font = new Font("SansSerif", Font.BOLD, 12);
        message.setFont(message_font);
        message.setForeground(new Color(85, 85, 85));
        message.setPreferredSize(new Dimension(450, 20));
        message.setVerticalAlignment(JLabel.TOP);
        message.setVerticalTextPosition(JLabel.TOP);
        textFormPanel.add(message);

        // JTextField field
        boolean field_editable = true;
        field.setEditable(field_editable);
        Font field_font = new Font("SansSerif", Font.BOLD, 20);
        field.setFont(field_font);
        field.setColumns(18);
        field.setForeground(new Color(85, 85, 85));
        Border border = BorderFactory.createLineBorder(new Color(212, 212, 212), 1);
        field.setBorder(border);
        textFormPanel.add(field);

        // JButton button Coder
        buttonCoder.setPreferredSize(new Dimension(110, 35));
        field.setFont(field_font);
        textFormPanel.add(buttonCoder);

        // JButton button Reset
        buttonReset.setPreferredSize(new Dimension(110, 35));
        buttonReset.setVisible(false);
        textFormPanel.add(buttonReset);

        CoderButtonAction coderButtonAction = new CoderButtonAction(field, buttonGeneratePanel, window, buttonReset);
        ResetButtonAction resetButtonAction = new ResetButtonAction(field, buttonGeneratePanel, buttonCoder);
        KeyActions keyActions = new KeyActions(field, message);

        // Action du bouton Coder
        buttonCoder.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(field.getText().isEmpty()){
                            message.setForeground(new Color(215, 11, 0));
                            message.setText("Attention le champs est vide.");
                        } else {
                            coderButtonAction.coderAction(e);
                        }
                    }
                }
        );

        // Action du bouton reset
        buttonReset.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent f) {
                        resetButtonAction.resetButton(f);
                    }
                }
        );

        // Action sur le champs
        field.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent k) {
                        keyActions.checkField(k);
                    }
                }
        );


    }
}
