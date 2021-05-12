package cvut.fel.dbs.lib.zapocet.view;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import static java.lang.Character.isDigit;

public class ViewUtilities {
    protected static JLabel addMyLabelCell(int pos, String labelstr, JPanel panel) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = pos;
        JLabel label = new JLabel(labelstr);
        panel.add(label, gridBagConstraints);
        return label;
    }

    protected static JLabel addMyLabelCell(int posCol, int posRow, String labelstr, JPanel panel) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = posCol;
        gridBagConstraints.gridy = posRow;
        JLabel label = new JLabel(labelstr);
        panel.add(label, gridBagConstraints);
        return label;
    }

    protected static JButton addMyUpdateButtonCell(int posCol, int posRow, JPanel panel, int teacherId, ActionListener actionListener) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = posCol;
        gridBagConstraints.gridy = posRow;
        JButton btn = new JButton("Update");
        btn.setActionCommand("update "+teacherId);
        btn.addActionListener(actionListener);
        panel.add(btn, gridBagConstraints);
        return btn;
    }

    protected static JButton addMyDeleteButtonCell(int posCol, int posRow, JPanel panel, int teacherId, ActionListener actionListener) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = posCol;
        gridBagConstraints.gridy = posRow;
        JButton btn = new JButton("Delete");
        btn.setActionCommand("delete "+teacherId);
        btn.addActionListener(actionListener);
        panel.add(btn, gridBagConstraints);
        return btn;
    }

    protected static JButton addMyButtonCell(int posCol, int posRow, JPanel panel, ActionListener actionListener, String actionCommand, String btnText) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = posCol;
        gridBagConstraints.gridy = posRow;
        JButton btn = new JButton(btnText);
        btn.setActionCommand(actionCommand);
        btn.addActionListener(actionListener);
        panel.add(btn, gridBagConstraints);
        return btn;
    }


    protected static JTextField addMyTextFieldCell(int pos, String text, JPanel panel) {
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

    protected static JFormattedTextField addMyTextFieldCell(int pos, String text, JPanel panel, boolean t) {
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

    /**
     * Number formatted text fields can produce texts such as 100,000. These give a NumberFormatException.
     * This method transforms such texts into a format parasble to integer through Integere.parseInt() method
     * @return return String in format parsable to integer.
     */
    protected static String getParsableToInt(String numberToTransform) {
        String res = "";
        for (int i = 0; i < numberToTransform.length(); i++) {
            char c = numberToTransform.charAt(i);
            if (isDigit(c)){
                res += c;
            }
        }
        return res;
    }

    /**
     * Transforms number formatted textfield to integer.
     * @return integer from textfield
     */
    protected static int getIntegerFromTextField(String textfield) {
        int res = Integer.parseInt(getParsableToInt(textfield));
        return res;
    }
}
