/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Вадим
 */
public class ChatTableModel extends AbstractTableModel {

    final String[] colNames = {"Имя", "Сообщение", "Время"};
    ArrayList<Message> messages;

    public ChatTableModel() {
        messages = new ArrayList();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public int getRowCount() {
        return messages.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Message message = (Message) messages.get(row);
        switch (col) {
            case 0:
                return message.getName();
            case 1:
                return message.getText();
            case 2:
                return message.getTime();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        Message message = (Message) messages.get(row);
        switch (column) {
            case 0:
                message.setName((String) value);
                break;
            case 1:
                message.setText((String) value);
                break;
            case 2:
                message.setTime((String) value);
                break;
            default:
                System.out.println("invalid index");
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return (String.class);
    }
}
