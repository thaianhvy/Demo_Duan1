/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class tableModel extends DefaultTableModel {

    @Override
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0 : 
                return Integer.class;
            case 1 :
                return String.class;
            case 2 :
                return ImageIcon.class;
        }
        return null;
    }
    
}
