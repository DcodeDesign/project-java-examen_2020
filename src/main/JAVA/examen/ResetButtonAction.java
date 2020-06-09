package examen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResetButtonAction {
    private final JTextField field;
    private final JPanel buttonGeneratePanel;
    private final JButton buttonCoder;
    private ActionEvent e;

    public ResetButtonAction(JTextField field, JPanel buttonGeneratePanel, JButton buttonCoder) {
        this.field = field;
        this.buttonGeneratePanel = buttonGeneratePanel;
        this.buttonCoder = buttonCoder;
    }

    public void resetButton(ActionEvent e) {
        this.e = e;
        JButton buttonReset = ((JButton) e.getSource());
        buttonGeneratePanel.removeAll();
        buttonGeneratePanel.repaint();
        field.setEditable(true);
        buttonReset.setVisible(false);
        buttonCoder.setVisible(true);
    }
}
