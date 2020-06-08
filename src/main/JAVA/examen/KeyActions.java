package examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyActions {

    String regexAcceped = "[^0-9a-z]";

    public KeyActions (KeyEvent e, JTextField field, JLabel message) {
        checkFiled(e, field, message);
    }

    public void checkFiled (KeyEvent e, JTextField field, JLabel message) {
        String letterType = String.valueOf(e.getKeyChar());

        if (field.isEditable() == false) {
            message.setForeground(new Color(85, 85, 85));
            message.setText("Pour éditer ce champs veiller cliquer sur Reset.");
        }else{
            if(!letterType.matches(regexAcceped))
            {
                e.consume();
                //System.out.println(e.getKeyChar());
                message.setForeground(new Color(215, 11, 0));
                message.setText(" '" + letterType + "' est  un caractère non valide.");
            }else {
                message.setForeground(new Color(85, 85, 85));
                message.setText("Attention seul les Majuscules et les caractères spéciaux sont accepté.");
            }
        }
    }
}
