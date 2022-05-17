package view;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import controller.TaskController;
import model.Project;
import model.Task;
import java.awt.Font;

public class TaskDialogScreen extends JDialog {

	private javax.swing.JFormattedTextField jFormattedTextFieldDeadLine;
    private javax.swing.JLabel jLabelDeadLine;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNotes;
    private javax.swing.JLabel jLabelToolBarSave;
    private javax.swing.JLabel jLabelToolBarTitle;
    private javax.swing.JPanel jPanelRegisterTask;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPaneDescription;
    private javax.swing.JScrollPane jScrollPaneNotes;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextArea jTextAreaNotes;
    private javax.swing.JTextField jTextFieldName;
    
    private TaskController taskController;
    private Project project;
    private Task task = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TaskDialogScreen dialog = new TaskDialogScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });

	}

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public TaskDialogScreen(java.awt.Frame parent, boolean modal) {
		
		super(parent, modal);
		initComponents();
		taskController = new TaskController();
	}
	
	public TaskDialogScreen(java.awt.Frame parent, boolean modal, Task task) {
		super(parent, modal);
		initComponents();
		this.task = task;
		taskController = new TaskController();
		jTextFieldName.setText(this.task.getName());
		jTextAreaDescription.setText(this.task.getDescription());
		jTextAreaNotes.setText(this.task.getNotes());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		jFormattedTextFieldDeadLine.setText(dateFormat.format(this.task.getDeadline()));
	}
	
	private void initComponents() {
		jPanelRegisterTask = new javax.swing.JPanel();
        jLabelNotes = new javax.swing.JLabel();
        jScrollPaneDescription = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelDescription = new javax.swing.JLabel();
        jScrollPaneNotes = new javax.swing.JScrollPane();
        jTextAreaNotes = new javax.swing.JTextArea();
        jLabelDeadLine = new javax.swing.JLabel();
        jFormattedTextFieldDeadLine = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDeadLine.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        jPanelToolBar = new javax.swing.JPanel();
        jLabelToolBarTitle = new javax.swing.JLabel();
        jLabelToolBarSave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tarefa");
        setMinimumSize(new java.awt.Dimension(400, 550));
        setPreferredSize(new java.awt.Dimension(400, 550));

        jPanelRegisterTask.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRegisterTask.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelNotes.setFont(new java.awt.Font("Segoe Emoji", 0, 16));
        jLabelNotes.setText("Notas");

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setFont(new Font("Segoe Emoji", Font.PLAIN, 16));
        jTextAreaDescription.setLineWrap(true);
        jTextAreaDescription.setRows(5);
        jTextAreaDescription.setWrapStyleWord(true);
        jScrollPaneDescription.setViewportView(jTextAreaDescription);

        jLabelName.setFont(new java.awt.Font("Segoe Emoji", 0, 16));
        jLabelName.setText("Nome");

        jTextFieldName.setFont(new Font("Segoe Emoji", Font.PLAIN, 16));
        jTextFieldName.setToolTipText("");

        jLabelDescription.setFont(new java.awt.Font("Segoe Emoji", 0, 16));
        jLabelDescription.setText("Descrição");

        jTextAreaNotes.setColumns(20);
        jTextAreaNotes.setFont(new Font("Segoe Emoji", Font.PLAIN, 16));
        jTextAreaNotes.setLineWrap(true);
        jTextAreaNotes.setRows(5);
        jTextAreaNotes.setWrapStyleWord(true);
        jScrollPaneNotes.setViewportView(jTextAreaNotes);

        jLabelDeadLine.setFont(new java.awt.Font("Segoe Emoji", 0, 16));
        jLabelDeadLine.setText("Prazo");

        jFormattedTextFieldDeadLine.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout jPanelRegisterTaskLayout = new javax.swing.GroupLayout(jPanelRegisterTask);
        jPanelRegisterTask.setLayout(jPanelRegisterTaskLayout);
        jPanelRegisterTaskLayout.setHorizontalGroup(
            jPanelRegisterTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegisterTaskLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRegisterTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(jLabelNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneDescription, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDeadLine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldDeadLine))
                .addContainerGap())
        );
        jPanelRegisterTaskLayout.setVerticalGroup(
            jPanelRegisterTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegisterTaskLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNotes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelDeadLine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldDeadLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelToolBar.setBackground(new Color(65, 105, 225));
        jPanelToolBar.setForeground(new Color(65, 105, 225));
        jPanelToolBar.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabelToolBarTitle.setFont(new java.awt.Font("Segoe Emoji", 1, 26));
        jLabelToolBarTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolBarTitle.setText("Tarefa");

        jLabelToolBarSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelToolBarSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        jLabelToolBarSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelToolBarSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelToolBarSave, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelToolBarLayout.setVerticalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addGroup(jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelToolBarSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRegisterTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRegisterTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
		setLocationRelativeTo(null);
	}
	
	private void jLabelToolBarSaveMouseClicked(java.awt.event.MouseEvent evt) {
		try {
			if(this.task == null) {
				this.task = new Task();
				this.task.setIdProject(this.project.getId());
			}
			if(isFieldsValids()) {
				this.task.setName(jTextFieldName.getText());
				this.task.setDescription(jTextAreaDescription.getText());
				this.task.setNotes(jTextAreaNotes.getText());
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date deadLine = dateFormat.parse(jFormattedTextFieldDeadLine.getText());
				this.task.setDeadline(deadLine);
				this.task.setCompleted(false);
				if(this.task.getId() == 0) {
					this.taskController.save(task);
					JOptionPane.showMessageDialog(rootPane, "Tarefa salva com sucesso!");
					this.dispose();
				}
				else {
					this.taskController.update(this.task);
					JOptionPane.showMessageDialog(rootPane, "Tarefa atualizada com sucesso!");
					this.dispose();
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	private boolean isFieldsValids() {
		if(jTextFieldName.getText().isEmpty() || jTextAreaDescription.getText().isEmpty() ||
				jFormattedTextFieldDeadLine.getText().isEmpty()) {
			JOptionPane.showMessageDialog(rootPane, "Os campos 'Nome', 'Descrição' e 'Prazo' são obrigatórios!", "Alerta", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

}
