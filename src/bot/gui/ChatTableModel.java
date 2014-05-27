/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot.gui;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Вадим
 */
public class ChatTableModel extends AbstractTableModel {

    final String[] colNames = {"Имя", "Сообщение", "Время"};
    ArrayList<Message> messages;
    public static MultiLineCellRenderer multiLineCellRenderer;
    
    public ChatTableModel() {
        messages = new ArrayList();
        multiLineCellRenderer = new MultiLineCellRenderer();
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
    
    class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {

	public MultiLineCellRenderer() {
            //setLineWrap(true);
            //setWrapStyleWord(true);
            //setOpaque(false);
            //setEditable(false); //this line doesn't seem to be doing anything
  	}

        @Override
	public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column){
            if (isSelected){
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            }
            else{
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            setFont(table.getFont());
            if (hasFocus){
                //setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
                if (table.isCellEditable(row, column)) {
                    setForeground(UIManager.getColor("Table.focusCellForeground"));
                    setBackground(UIManager.getColor("Table.focusCellBackground"));
                }
            }
            else{
                    //setBorder(new EmptyBorder(1, 2, 1, 2));
            }
            setText((value == null) ? "" : value.toString());
            //setEditable(false); //this line doesn't seem to be doing anything
            return this;
	}
    }
}
