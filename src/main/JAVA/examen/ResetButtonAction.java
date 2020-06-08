package examen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonAction {
    public ResetButtonAction(ActionEvent e, JTextField field, JPanel buttonGeneratePanel, JButton button_coder) {
        reset_button(e, field, buttonGeneratePanel, button_coder);
    }

    private void reset_button(ActionEvent e, JTextField field, JPanel buttonGeneratePanel, JButton button_coder) {
        JButton button_reset = ((JButton) e.getSource());
        buttonGeneratePanel.removeAll();
        buttonGeneratePanel.repaint();
        field.setEditable(true);
        button_reset.setVisible(false);
        button_coder.setVisible(true);

    }
}
