package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ProjectController;
import controller.TaskController;
import model.Project;
import model.Task;
import util.ButtonColumnCellRenderer;
import util.DeadlineColumnCellRenderer;
import util.TaskTableModel;

public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DefaultListModel projectsModel;
    TaskTableModel tasksModel;

    ProjectController projectController;
    TaskController taskController;

	
	private javax.swing.JLabel jLabelEmptyTasksImage;
    private javax.swing.JLabel jLabelEmptyTasksSubTitle;
    private javax.swing.JLabel jLabelEmptyTasksTitle;
    private javax.swing.JLabel jLabelInfos;
    private javax.swing.JLabel jLabelProjectsToolBarAdd;
    private javax.swing.JLabel jLabelProjectsToolBarTitle;
    private javax.swing.JLabel jLabelTasksToolBarAdd;
    private javax.swing.JLabel jLabelTasksToolBarTitle;
    private javax.swing.JLabel jLabelToolBarSubTitle;
    private javax.swing.JLabel jLabelToolBarTitle;
    private javax.swing.JList<String> jListProjects;
    private javax.swing.JPanel jPanelEmptyTasks;
    private javax.swing.JPanel jPanelEmptyTasksLayout;
    private javax.swing.JPanel jPanelProjects;
    private javax.swing.JPanel jPanelProjectsToolBar;
    private javax.swing.JPanel jPanelTasksTollBar;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPaneProjects;
    private javax.swing.JScrollPane jScrollPaneTasks;
    private javax.swing.JTable jTableTasks;
    
	/**
	 * Create the frame.
	 */
	public MainScreen() {
		initComponents();
		initDataController();
		initComponentsModel();
		decorateJTableTasks();
	}
	
	public void initComponents() {
		
		jScrollPaneTasks = new javax.swing.JScrollPane();
        jTableTasks = new javax.swing.JTable();
        jPanelToolBar = new javax.swing.JPanel();
        jLabelToolBarTitle = new javax.swing.JLabel();
        jLabelToolBarSubTitle = new javax.swing.JLabel();
        jLabelInfos = new javax.swing.JLabel();
        jPanelProjects = new javax.swing.JPanel();
        jScrollPaneProjects = new javax.swing.JScrollPane();
        jListProjects = new javax.swing.JList<>();
        jPanelTasksTollBar = new javax.swing.JPanel();
        jLabelTasksToolBarTitle = new javax.swing.JLabel();
        jLabelTasksToolBarAdd = new javax.swing.JLabel();
        jPanelProjectsToolBar = new javax.swing.JPanel();
        jLabelProjectsToolBarTitle = new javax.swing.JLabel();
        jLabelProjectsToolBarAdd = new javax.swing.JLabel();
        jPanelEmptyTasks = new javax.swing.JPanel();
        jPanelEmptyTasksLayout = new javax.swing.JPanel();
        jLabelEmptyTasksTitle = new javax.swing.JLabel();
        jLabelEmptyTasksSubTitle = new javax.swing.JLabel();
        jLabelEmptyTasksImage = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Todo App");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(600, 800));

        jScrollPaneTasks.setBorder(null);

        jTableTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableTasks.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16));
        jTableTasks.setFocusable(false);
        jTableTasks.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableTasks.setRowHeight(50);
        jTableTasks.setSelectionBackground(new java.awt.Color(100, 200, 200));
        jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTasks.setShowHorizontalLines(false);
        jTableTasks.setShowVerticalLines(false);
        jTableTasks.getTableHeader().setReorderingAllowed(false);
        jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTasksMouseClicked(evt);
            }
        });
        jScrollPaneTasks.setViewportView(jTableTasks);

        jPanelToolBar.setBackground(new Color(65, 105, 225));
        jPanelToolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelToolBarTitle.setFont(new Font("Segoe UI Emoji", Font.BOLD, 26));
        jLabelToolBarTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolBarTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelToolBarTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png")));
        jLabelToolBarTitle.setText("  App Tarefas");
        jLabelToolBarTitle.setToolTipText("");

        jLabelToolBarSubTitle.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        jLabelToolBarSubTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolBarSubTitle.setText("Anote tudo, n\u00E3o esque\u00E7a nada.");

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelToolBarSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                    .addComponent(jLabelToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelToolBarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelInfos)))
                .addContainerGap())
        );
        jPanelToolBarLayout.setVerticalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInfos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelToolBarTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelToolBarSubTitle)
                .addGap(15, 15, 15))
        );

        jPanelProjects.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjects.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jListProjects.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        jListProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProjects.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jListProjects.setFixedCellHeight(50);
        jListProjects.setSelectionBackground(new Color(100, 200, 200));
        jListProjects.setToolTipText("Clique com o botão direito do mouse para opções.");
        jListProjects.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent evt) {
        		jListProjectsMouseClicked(evt);
        	}
        });
        
        jScrollPaneProjects.setViewportView(jListProjects);

        javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
        jPanelProjects.setLayout(jPanelProjectsLayout);
        jPanelProjectsLayout.setHorizontalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelProjectsLayout.setVerticalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjects)
                .addContainerGap())
        );

        jPanelTasksTollBar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTasksTollBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTasksToolBarTitle.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        jLabelTasksToolBarTitle.setForeground(new Color(65, 105, 225));
        jLabelTasksToolBarTitle.setText("Tarefas");

        jLabelTasksToolBarAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTasksToolBarAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png")));
        jLabelTasksToolBarAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksToolBarAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTasksTollBarLayout = new javax.swing.GroupLayout(jPanelTasksTollBar);
        jPanelTasksTollBar.setLayout(jPanelTasksTollBarLayout);
        jPanelTasksTollBarLayout.setHorizontalGroup(
            jPanelTasksTollBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTasksTollBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTasksToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTasksToolBarAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelTasksTollBarLayout.setVerticalGroup(
            jPanelTasksTollBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTasksToolBarAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelTasksToolBarTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jPanelProjectsToolBar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjectsToolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelProjectsToolBarTitle.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        jLabelProjectsToolBarTitle.setForeground(new Color(65, 105, 225));
        jLabelProjectsToolBarTitle.setText("Projetos");

        jLabelProjectsToolBarAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProjectsToolBarAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png")));
        jLabelProjectsToolBarAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectsToolBarAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectsToolBarLayout = new javax.swing.GroupLayout(jPanelProjectsToolBar);
        jPanelProjectsToolBar.setLayout(jPanelProjectsToolBarLayout);
        jPanelProjectsToolBarLayout.setHorizontalGroup(
            jPanelProjectsToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProjectsToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProjectsToolBarAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelProjectsToolBarLayout.setVerticalGroup(
            jPanelProjectsToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProjectsToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
            .addComponent(jLabelProjectsToolBarAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelEmptyTasks.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEmptyTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelEmptyTasks.setLayout(new java.awt.BorderLayout());

        jPanelEmptyTasksLayout.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEmptyTasksTitle.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        jLabelEmptyTasksTitle.setForeground(new Color(65, 105, 225));
        jLabelEmptyTasksTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyTasksTitle.setText("Nenhuma Tarefa por aqui :D");

        jLabelEmptyTasksSubTitle.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        jLabelEmptyTasksSubTitle.setForeground(new java.awt.Color(153, 153, 153));
        jLabelEmptyTasksSubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyTasksSubTitle.setText("Clique no botão \"+\" para adicionar uma nova tarefa");

        jLabelEmptyTasksImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyTasksImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png")));

        javax.swing.GroupLayout jPanelEmptyTasksLayoutLayout = new javax.swing.GroupLayout(jPanelEmptyTasksLayout);
        jPanelEmptyTasksLayoutLayout.setHorizontalGroup(
        	jPanelEmptyTasksLayoutLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jLabelEmptyTasksImage, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        		.addGroup(jPanelEmptyTasksLayoutLayout.createSequentialGroup()
        			.addComponent(jLabelEmptyTasksSubTitle, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(jPanelEmptyTasksLayoutLayout.createSequentialGroup()
        			.addComponent(jLabelEmptyTasksTitle, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanelEmptyTasksLayoutLayout.setVerticalGroup(
        	jPanelEmptyTasksLayoutLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanelEmptyTasksLayoutLayout.createSequentialGroup()
        			.addContainerGap(48, Short.MAX_VALUE)
        			.addComponent(jLabelEmptyTasksImage)
        			.addGap(14)
        			.addComponent(jLabelEmptyTasksTitle)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabelEmptyTasksSubTitle)
        			.addGap(40))
        );
        jPanelEmptyTasksLayout.setLayout(jPanelEmptyTasksLayoutLayout);

        jPanelEmptyTasks.add(jPanelEmptyTasksLayout, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjectsToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTasksTollBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelEmptyTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjectsToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTasksTollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelEmptyTasks, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }
    
    private void initComponentsModel() {
        projectsModel = new DefaultListModel();
        loadProjects();

        tasksModel = new TaskTableModel();
        jTableTasks.setModel(tasksModel);
        
        if (!projectsModel.isEmpty()) {
            jListProjects.setSelectedIndex(0);
            int projectIndex = jListProjects.getSelectedIndex();
            Project project = (Project) projectsModel.get(projectIndex);
            loadTasks(project.getId());
        }

    }
    
    private void initDataController() {
        projectController = new ProjectController();
        taskController = new TaskController();
    }

    private void loadProjects() {
        List<Project> projects = projectController.getAll();

        projectsModel.clear();

        for (int i = 0; i < projects.size(); i++) {
            projectsModel.addElement(projects.get(i));
        }
        jListProjects.setModel(projectsModel);
    }

    private void loadTasks(int projectId) {
        List<Task> tasks = taskController.getAll(projectId);
        
        tasksModel.onRemoveAll();
        
        tasksModel.setTasks(tasks);        
        showJTableTasks(!tasks.isEmpty());
    }

    
    private void showJTableTasks(boolean isEmptyTable) {
        if (isEmptyTable) {
            if (jPanelEmptyTasksLayout.isVisible()) {
                jPanelEmptyTasksLayout.setVisible(false);
                jPanelEmptyTasks.remove(jPanelEmptyTasksLayout);
            }

            jPanelEmptyTasks.add(jScrollPaneTasks);
            jScrollPaneTasks.setVisible(true);
            jScrollPaneTasks.setSize(jPanelEmptyTasks.getWidth(), jPanelEmptyTasks.getHeight());
        } else {
            if (jScrollPaneTasks.isVisible()) {
                jScrollPaneTasks.setVisible(false);
                jPanelEmptyTasks.remove(jScrollPaneTasks);
            }

            jPanelEmptyTasks.add(jPanelEmptyTasksLayout);
            jPanelEmptyTasksLayout.setVisible(true);
            jPanelEmptyTasksLayout.setSize(jPanelEmptyTasks.getWidth(), jPanelEmptyTasks.getHeight());
        }
    }

    
    private void decorateJTableTasks() {
        //To style table header
        jTableTasks.getTableHeader().setFont(new Font("Segoe Emoji", Font.BOLD, 16));
        jTableTasks.getTableHeader().setOpaque(false);
        jTableTasks.getTableHeader().setBackground(new Color(65, 105, 225));
        jTableTasks.getTableHeader().setForeground(new Color(255, 255, 255));
        
        jTableTasks.getColumnModel().getColumn(2).setCellRenderer(new DeadlineColumnCellRenderer());
        jTableTasks.getColumnModel().getColumn(4).setCellRenderer(new ButtonColumnCellRenderer("edit"));
        jTableTasks.getColumnModel().getColumn(5).setCellRenderer(new ButtonColumnCellRenderer("delete"));


        //Auto sort dos items da jTable
        jTableTasks.setAutoCreateRowSorter(true);

        //Add event 
        jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());
                int columnIndex = jTableTasks.columnAtPoint(evt.getPoint());

                if (columnIndex == 3) {
                    Task task = tasksModel.getTasks().get(rowIndex);
                    taskController.update(task);
                }
            }
        });
    }
    
    private void jLabelProjectsToolBarAddMouseClicked(java.awt.event.MouseEvent evt) {
    	ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen(this, rootPaneCheckingEnabled);
    	projectDialogScreen.setVisible(true);
    	
    	projectDialogScreen.addWindowListener(new WindowAdapter() {
    		public void windowClosed(WindowEvent e) {
    			loadProjects();
    		}
		});
    }
    
    private void jLabelTasksToolBarAddMouseClicked(java.awt.event.MouseEvent evt) {
    	if(!jListProjects.isSelectionEmpty()) {
	    	int projectIndex = jListProjects.getSelectedIndex();
	    	Project project = (Project) projectsModel.get(projectIndex);
	    	TaskDialogScreen taskDialogScreen = new TaskDialogScreen(this, rootPaneCheckingEnabled);
	    	taskDialogScreen.setProject(project);
	    	taskDialogScreen.setVisible(true);
	    	
	    	taskDialogScreen.addWindowListener(new WindowAdapter() {
	    		public void windowClosed(WindowEvent e) {
	    			Project project = (Project) projectsModel.get(jListProjects.getSelectedIndex());
	    			loadTasks(project.getId());
	    		}
	    	});
    	} else {
    		JOptionPane.showMessageDialog(rootPane, "Nenhum projeto selecionado!\nSelecione um "
    				+ "projeto para adicionar uma tarefa", "Informação", JOptionPane.INFORMATION_MESSAGE);
    	}
    }
    
    private void jListProjectsMouseClicked(MouseEvent evt) {
		int projectIndex = jListProjects.getSelectedIndex();		
		Project project = (Project)projectsModel.get(projectIndex);
    	loadTasks(project.getId());
	}
	
	private void jTableTasksMouseClicked(MouseEvent evt) {
		int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());
		int columnIndex = jTableTasks.columnAtPoint(evt.getPoint());
		Task task = tasksModel.getTasks().get(rowIndex);
		
		switch (columnIndex) {
		case 3:
			taskController.update(task);
			break;
		case 4:
			TaskDialogScreen taskDialogScreen = new TaskDialogScreen(this, rootPaneCheckingEnabled, task);
	    	taskDialogScreen.setVisible(true);
	    	loadTasks(task.getIdProject());
			break;
		case 5:
			if (JOptionPane.showConfirmDialog(rootPane, "Confirma exclusão da tarefa: \n" + task.getName(),
					"Excluir Tarefa", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
				taskController.removeById(task.getId());
				loadTasks(task.getIdProject());
			}
			break;
		}
    }
}
