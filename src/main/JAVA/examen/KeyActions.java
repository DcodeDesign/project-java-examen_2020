package examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyActions {

    private final String regexAcceped;
    private final JTextField field;
    private final JLabel message;

    public KeyActions (JTextField field, JLabel message) {
        this.field = field;
        this.message = message;
        regexAcceped = "[^0-9a-z]";
    }

    public void checkField (KeyEvent e) {
        String letterType = String.valueOf(e.getKeyChar());

        if (!field.isEditable()) {
            message.setForeground(new Color(85, 85, 85));
            message.setText("Pour éditer ce champs veiller cliquer sur Reset.");
        }else{
            if(!letterType.matches(regexAcceped))
            {
                e.consume();
                message.setForeground(new Color(215, 11, 0));
                message.setText(" '" + letterType + "' est  un caractère non valide.");
            } else {
                message.setForeground(new Color(85, 85, 85));
                message.setText("Attention seul les Majuscules et les caractères spéciaux sont accepté.");
            }
        }
    }
}
