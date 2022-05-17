package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import model.Task;

public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
		
		JLabel label;
		label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		label.setHorizontalAlignment(CENTER);
		
		TaskTableModel taskModel = (TaskTableModel) table.getModel();
		Task task = taskModel.getTasks().get(row);
		
		if(task.getDeadline().after(new Date())) {
			label.setForeground(new Color(0, 100, 0));
		} else {
			label.setForeground(Color.RED);
		}
		
		return label;
	}
}
