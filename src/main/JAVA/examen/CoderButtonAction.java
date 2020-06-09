package examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class CoderButtonAction {
    private final JTextField field;
    private final JPanel buttonGeneratePanel;
    private final JFrame window;
    private final JButton buttonReset;
    private int fieldLengthChar = 0;

    //lettersArrayList :
    // liste de tableau contenant uniquement les lettres insérées dans le champs
    private final ArrayList<String> lettersArrayList;

    // allCharactersArrayList :
    // liste de tableau contenant tous les caractères insérés dans le champs
    private final ArrayList<String> allCharactersArrayList;

    // correlationAllCharactersArrayList :
    // liste de tableau de contenant la position des lettre, les espaces, les caractères spéciaux
    private final ArrayList<String> correlationAllCharactersArrayList;

    // correlationAllCharactersArrayList :
    // liste de tableau bidimentionnel regroupant allCharactersArrayList & correlationAllCharactersArrayList
    private final ArrayList<ArrayList<String>> bidimensionalArrayList;

    private final Font buttonFont;
    // System.out.println(test);

    // génération des boutons
    private final JButton[] buttonsGenerate = new JButton[fieldLengthChar];

    // regex
    private final String regexLetter;
    private final String regexSpecial;
    private final String regexSpace;

    public CoderButtonAction(JTextField field, JPanel buttonGeneratePanel, JFrame window, JButton buttonReset) {
        this.field = field;
        this.buttonGeneratePanel = buttonGeneratePanel;
        this.window = window;
        this.buttonReset = buttonReset;
        lettersArrayList = new ArrayList<>();
        allCharactersArrayList = new ArrayList<>();
        correlationAllCharactersArrayList = new ArrayList<>();
        bidimensionalArrayList = new ArrayList<>();
        buttonFont = new Font("SansSerif", Font.BOLD, 12);
        regexLetter = "[A-Z]";
        regexSpecial = "[A-Za-z0-9- ]";
        regexSpace = "[ ]";
    }

    public void coderAction(ActionEvent e) {
        window.setSize(500, 410);
        window.setLocationRelativeTo(null);

        field.setEditable(false);

        ArrayList<ArrayList<String>> correlationTable;
        correlationTable = new ArrayList<>(matchArrayGenerator(field));

        for (int i = 0; i < correlationTable.get(0).size(); i++) {

            // Generation des boutons Lettre
            if(correlationTable.get(0).get(i).matches(regexLetter)){
                buttonsGenerate[i] = new JButton(correlationTable.get(1).get(i));
                buttonsGenerate[i].setPreferredSize(new Dimension(45, 45));
                buttonsGenerate[i].setFont(buttonFont);
                buttonsGenerate[i].setForeground(new Color(85, 85, 85));
                buttonGeneratePanel.add(buttonsGenerate[i]);
                int finalI = i;

                buttonsGenerate[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        for (int k = 0; k < correlationTable.get(0).size(); k++) {
                            if(correlationTable.get(0).get(finalI).equals(correlationTable.get(0).get(k))) {
                                buttonsGenerate[k].setBackground(new Color(21, 139, 212));
                                buttonsGenerate[k].setText(correlationTable.get(0).get(finalI));
                                buttonsGenerate[k].setOpaque(true);
                            }
                        }
                    }

                    public void mouseExited(MouseEvent e) {
                        for (int k = 0; k < correlationTable.get(0).size(); k++) {
                            if(correlationTable.get(0).get(finalI).equals(correlationTable.get(0).get(k))) {
                                buttonsGenerate[k].setText(correlationTable.get(1).get(finalI));
                                buttonsGenerate[k].setOpaque(false);
                            }
                        }
                    }

                });
            }

            // Generation des boutons de caractère spéciaux
            if(!correlationTable.get(0).get(i).matches(regexSpecial)){
                buttonsGenerate[i] = new JButton(correlationTable.get(0).get(i));
                buttonsGenerate[i].setPreferredSize(new Dimension(45, 45));
                buttonsGenerate[i].setEnabled(false);
                buttonGeneratePanel.add(buttonsGenerate[i]);
            }

            // Generation des boutons espace
            if(correlationTable.get(0).get(i).matches(regexSpace)){
                buttonsGenerate[i] = new JButton(correlationTable.get(0).get(i));
                buttonsGenerate[i].setPreferredSize(new Dimension(60, 28));
                buttonGeneratePanel.add(buttonsGenerate[i]);
            }
        }

        // switch bouton
        JButton buttonCoder = ((JButton) e.getSource());
        buttonCoder.setVisible(false);
        buttonReset.setVisible(true);
    }

    private ArrayList<ArrayList<String>> matchArrayGenerator(JTextField fieldText) {

        // Récupération du text inséré dans la champs
        String t_text = fieldText.getText();

        // Comptage du nombre de lettre du champs récupéré
        fieldLengthChar = t_text.length();

        // Insertion de chaque caractère dans deux arraylist
        for (int i = 0; i <= fieldLengthChar - 1; i++) {
            allCharactersArrayList.add(t_text.substring(i, i + 1));
            correlationAllCharactersArrayList.add(t_text.substring(i, i + 1));
        }

        // Insertion uniquement des lettres dans une nouvelle arraylist
        for (int i = 0; i < fieldLengthChar; i++) {
            String letter = String.valueOf(allCharactersArrayList.get(i));
            if (letter.matches(regexLetter)) {
                //lettersArrayList.add(allCharactersArrayList.get(i));
                lettersArrayList.add(allCharactersArrayList.get(i).toUpperCase());
            }
        }

        // lettersArrayList : supprime les lettres en double tout en gardant l'ordre initiale
        Set<String> set = new LinkedHashSet<>(lettersArrayList);
        ArrayList<String> clean_temp_allCharactersArrayList = new ArrayList<>(set);
        clean_temp_allCharactersArrayList.clear();
        clean_temp_allCharactersArrayList.addAll(set);

        // Comparaison correlationAllCharactersArrayList avec lettersArrayList
        // pour y inserer la position des lettres
        for (int i = 0; i < correlationAllCharactersArrayList.size(); i++) {
            boolean flag = true;
            int l;
            for (l = 0; (l < clean_temp_allCharactersArrayList.size()) && flag; l++) {

                if(correlationAllCharactersArrayList.get(i).equals(clean_temp_allCharactersArrayList.get(l))) {
                    correlationAllCharactersArrayList.set(i, String.valueOf(clean_temp_allCharactersArrayList.indexOf(clean_temp_allCharactersArrayList.get(l)) + 1));
                    flag = false;
                }

                String letter = String.valueOf(allCharactersArrayList.get(i));
                if(!letter.matches(regexSpecial)) {
                    correlationAllCharactersArrayList.set(i , "Special");
                    flag = false;
                }

                if(correlationAllCharactersArrayList.get(i).equals(" ")) {
                    correlationAllCharactersArrayList.set(i , "Espace");
                    flag = false;
                }
            }
        }

        bidimensionalArrayList.add(allCharactersArrayList);
        bidimensionalArrayList.add(correlationAllCharactersArrayList);

        return  bidimensionalArrayList;
    }
}


