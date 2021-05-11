package cvut.fel.dbs.lib.zapocet.view;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class ViewUtilities {
    public static JLabel addMyLabelCell(int pos, String labelstr, JPanel panel) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = pos;
        JLabel label = new JLabel(labelstr);
        panel.add(label, gridBagConstraints);
        return label;
    }

    public static JLabel addMyLabelCell(int posCol, int posRow, String labelstr, JPanel panel) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = posCol;
        gridBagConstraints.gridy = posRow;
        JLabel label = new JLabel(labelstr);
        panel.add(label, gridBagConstraints);
        return label;
    }

    private static JTextField addMyTextFieldCell(int pos, String text, JPanel panel) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.ipadx = 10;
        JTextField textField = new JTextField(text);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = pos;
        textField.setColumns(10);
        panel.add(textField, gridBagConstraints);
        return textField;
    }

    private static JFormattedTextField addMyTextFieldCell(int pos, String text, JPanel panel, boolean t) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.ipadx = 10;

        NumberFormat longFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setValueClass(Integer.class); //optional, ensures you will always get a long value
        numberFormatter.setAllowsInvalid(false); //this is the key!!
        numberFormatter.setMinimum(0); //Optional

        JFormattedTextField field = new JFormattedTextField(numberFormatter);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = pos;
        field.setColumns(10);
        panel.add(field, gridBagConstraints);
        return field;
    }
}
