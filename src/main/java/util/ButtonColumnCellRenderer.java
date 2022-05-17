package util;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonColumnCellRenderer extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String buttonType;

		
	public ButtonColumnCellRenderer(String buttonType) {
		super();
		this.buttonType = buttonType;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
		
		JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		label.setHorizontalAlignment(CENTER);
		label.setIcon(new ImageIcon(getClass().getResource("/" + buttonType + ".png")));
		
		return label;
	}

}
