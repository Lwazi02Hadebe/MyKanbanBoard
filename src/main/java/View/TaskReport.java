/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static View.AddTaskDetailsDialog.TASKS_DB;

/**
 * @author ME
 */
public final class TaskReport extends javax.swing.JFrame {


    private DefaultTableModel model;
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TaskReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TaskReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TaskReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TaskReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TaskReport().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBackToLogIn;
    private javax.swing.JButton jButtonBackToTaskBoard;
    private javax.swing.JButton jButtonDeleteTask;
    private javax.swing.JButton jButtonSearchWithTaskName;
    private javax.swing.JButton jButtonSearchWithTaskNameBasedOnDeveloper;
    private javax.swing.JComboBox<String> jComboBoxDeleteWithTaskName;
    private javax.swing.JComboBox<String> jComboBoxSearchWithTaskNameBasedOnDeveloper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelWelcomeMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableDevelopersWithDoneTasks;
    private javax.swing.JTable jTableReportWithFullDetailsOfTasksOfDevelopers;
    private javax.swing.JTable jTableTaskSearchResults1;
    private javax.swing.JTable jTableTasksAssignedToDeveloperSearchResults;
    private javax.swing.JTextArea jTextAreaLongestDuration;
    private javax.swing.JTextField jTextFieldSearchTaskWithName;
    private javax.swing.JTextField jTextFieldSearchWithTaskNameBasedOnDeveloper;
    /**
     * Creates new form TaskReport
     */
    public TaskReport() {
//        try{
//
//            TASKS_DB.put(TASKS_DB.size(), new Task("Login Feature",
//                    String.valueOf(TASKS_DB.size()), "Create Login to authenticate users",
//                   new DeveloperDetails("Robyn", "Harrison"),
//                   "10", "To Do"));
//            TASKS_DB.put(TASKS_DB.size(), new Task("Logout Feature",
//                    String.valueOf(TASKS_DB.size()), "Create Logout exit session",
//                   new DeveloperDetails("Robyn", "Harrison"),
//                   "10", "To Do"));
//            TASKS_DB.put(TASKS_DB.size(), new Task("Add Task Feature"
//                    , String.valueOf(TASKS_DB.size()), "Create Add Task feature to add task users",
//            new DeveloperDetails("Mike", "Smith"), "12", "In Progress"));
//            TASKS_DB.put(TASKS_DB.size(), new Task("Add Other Dope Task Feature"
//                    , String.valueOf(TASKS_DB.size()), "Create Other Dope Add Task feature to add task users",
//            new DeveloperDetails("Jameson", "Zachary"), "55", "Done"));
//            TASKS_DB.put(TASKS_DB.size(), new Task("Add Some Other Dope Task Feature"
//                    , String.valueOf(TASKS_DB.size()), "Create Some Dope Add Task feature to add task users",
//            new DeveloperDetails("Jake", "Smith"), "11", "Done"));
//            TASKS_DB.put(TASKS_DB.size(), new Task("Add Some Other Other Dope Task Feature"
//                    , String.valueOf(TASKS_DB.size()), "Create Some Other Dope Add Task feature to add task users",
//            new DeveloperDetails("Will", "Smith"), "1", "In Progress"));
//        }catch(Exception exc){
//            System.out.println("Show me the exception: "+exc);
//        }

        initComponents();
        initializeAllData();
    }

    public static Task findDeveloperWithTheLongestDuration() {
        Map<Integer, Object> sortedDB = AddTaskDetailsDialog.TASKS_DB.entrySet()
                .stream()
                .sorted(((e1, e2) ->
                        ((Task) e1.getValue()).getTaskDuration()
                                .compareTo(((Task) e2.getValue()).getTaskDuration())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        List<Object> sortedTasks = sortedDB.values().stream().collect(
                Collectors.toList()
        );
        if (!sortedTasks.isEmpty()) {
            return (Task) sortedTasks.get(sortedTasks.size() - 1);
        }
        return null;
    }

    public static List<Object> fullDetailsOfTasks() {
        return AddTaskDetailsDialog.TASKS_DB.entrySet().stream()
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public static List<Object> searchForTasks(String queryString) {
        return AddTaskDetailsDialog.TASKS_DB
                .entrySet()
                .stream()
                .filter(e -> ((Task) e.getValue()).getTaskName().trim()
                        .toLowerCase().contains(queryString.trim()
                                .toLowerCase())).map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<Object> searchTaskWithDeveloper(
            String queryTextDeveloper,
            String queryTextTask) {
        return AddTaskDetailsDialog.TASKS_DB.entrySet().stream().filter(e ->
                        ((Task) e.getValue()).getTaskDeveloperDetails()
                                .equals((Object) queryTextDeveloper) && ((Task) e.getValue())
                                .getTaskName().trim().toLowerCase()
                                .contains(queryTextTask.trim().toLowerCase()))
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public static boolean deleteTask(String queryText) {
        return TASKS_DB.entrySet().removeIf(e -> ((Task) e.getValue())
                .getTaskName().trim().toLowerCase()
                .equals(queryText.trim().toLowerCase()));
    }

    public void initializeAllData() {
        initializeTableWithExistingData();
        initializeTextAreaWithExistingData();
        initializeExistingDevelopersToComboBox();
        initializeTableWithExistingDevelopersWithDoneTasksData();
        initializedExistingTasksToDeleteComboxBox();
    }

    public void initializeTextAreaWithExistingData() {
        jTextAreaLongestDuration.setText("");
        Task developerWithLongestDuration =
                findDeveloperWithTheLongestDuration();
        jTextAreaLongestDuration.setText(developerWithLongestDuration
                .getTaskDeveloperDetails().toString() + "\n"
                + "Duration: " + developerWithLongestDuration
                .getTaskDuration());
    }

    public void initializeTableWithExistingData() {
        model = (DefaultTableModel) jTableReportWithFullDetailsOfTasksOfDevelopers.getModel();
        model.setRowCount(0);
        // Append a row
        fullDetailsOfTasks().forEach(e ->
                model.addRow(new String[]
                        {
                                ((Task) e).getTaskName(),
                                ((Task) e).getTaskDeveloperDetails()
                                        .getDevFirstName(),
                                ((Task) e).getTaskDeveloperDetails()
                                        .getDevLastName(),
                                ((Task) e).getTaskDuration().toString(),
                                ((Task) e).getTaskStatus(),
                                ((Task) e).getTaskID()
                        })
        );
        jTableReportWithFullDetailsOfTasksOfDevelopers.setModel(model);
    }

    public void initializeTableWithExistingDevelopersWithDoneTasksData() {
        model = (DefaultTableModel) jTableDevelopersWithDoneTasks.getModel();
        model.setRowCount(0);

        // Append a row
        AddTaskDetailsDialog.TASKS_DB.entrySet()
                .stream()
                .filter(e -> ((Task) e.getValue()).getTaskStatus()
                        .equals("Done"))
                .forEach(e ->
                        model.addRow(new String[]
                                {
                                        ((Task) e.getValue()).getTaskDeveloperDetails()
                                                .getDevFirstName(),
                                        ((Task) e.getValue()).getTaskDeveloperDetails()
                                                .getDevLastName(),
                                        ((Task) e.getValue()).getTaskName(),
                                        ((Task) e.getValue()).getTaskDuration().toString(),
                                })
                );
        jTableDevelopersWithDoneTasks.setModel(model);
    }

    public void initializeExistingDevelopersToComboBox() {
        //start by removing all existing items, then populate
        jComboBoxSearchWithTaskNameBasedOnDeveloper.removeAllItems();
        List<Object> comboBoxItems = AddTaskDetailsDialog.TASKS_DB.entrySet().stream().distinct().filter(e ->
                        !((Task) e.getValue()).getTaskName().isEmpty()).distinct()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        List<String> developerNames = new ArrayList<>();
        comboBoxItems.forEach(e -> {
            developerNames.add(((Task) e).getTaskDeveloperDetails().getDevFirstName() + "," +
                    ((Task) e).getTaskDeveloperDetails().getDevLastName());
        });

        List<String> listWithNoDuplicates = developerNames.stream().distinct()
                .collect(Collectors.toList());
        listWithNoDuplicates.forEach(e ->
                jComboBoxSearchWithTaskNameBasedOnDeveloper.addItem(e));
    }

    public void initializedExistingTasksToDeleteComboxBox() {
        //start by removing all existing items first then populate
        jComboBoxDeleteWithTaskName.removeAllItems();
        TASKS_DB.entrySet()
                .stream()
                .filter(e -> !((Task) e.getValue())
                        .getTaskName().isEmpty()).forEach(e -> {
                    jComboBoxDeleteWithTaskName.addItem(((Task) e.getValue()).getTaskName());
                });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelWelcomeMessage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldSearchTaskWithName = new javax.swing.JTextField();
        jButtonSearchWithTaskName = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTasksAssignedToDeveloperSearchResults = new javax.swing.JTable();
        jTextFieldSearchWithTaskNameBasedOnDeveloper = new javax.swing.JTextField();
        jButtonSearchWithTaskNameBasedOnDeveloper = new javax.swing.JButton();
        jComboBoxSearchWithTaskNameBasedOnDeveloper = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTaskSearchResults1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonDeleteTask = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaLongestDuration = new javax.swing.JTextArea();
        jComboBoxDeleteWithTaskName = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableDevelopersWithDoneTasks = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableReportWithFullDetailsOfTasksOfDevelopers = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButtonBackToTaskBoard = new javax.swing.JButton();
        jButtonBackToLogIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelWelcomeMessage.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabelWelcomeMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWelcomeMessage.setText("<html> Welcome to EasyKanban  <div align=\"center\"> <h4> Task Report </h4> </div> </html>");
        jLabelWelcomeMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextFieldSearchTaskWithName.setToolTipText("Search for a task with Task Name");

        jButtonSearchWithTaskName.setText("Search");
        jButtonSearchWithTaskName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchWithTaskNameActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search for task with task name");

        jTableTasksAssignedToDeveloperSearchResults.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Task", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableTasksAssignedToDeveloperSearchResults.setColumnSelectionAllowed(true);
        jTableTasksAssignedToDeveloperSearchResults.setShowGrid(true);
        jScrollPane3.setViewportView(jTableTasksAssignedToDeveloperSearchResults);
        jTableTasksAssignedToDeveloperSearchResults.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jTextFieldSearchWithTaskNameBasedOnDeveloper.setToolTipText("Search for a task with Task Name");

        jButtonSearchWithTaskNameBasedOnDeveloper.setText("Search");
        jButtonSearchWithTaskNameBasedOnDeveloper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchWithTaskNameBasedOnDeveloperActionPerformed(evt);
            }
        });

        jTableTaskSearchResults1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Task", "Name", "Surname", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableTaskSearchResults1.setColumnSelectionAllowed(true);
        jTableTaskSearchResults1.setShowGrid(true);
        jScrollPane4.setViewportView(jTableTaskSearchResults1);
        jTableTaskSearchResults1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search tasks assigned to a developer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldSearchTaskWithName)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonSearchWithTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldSearchWithTaskNameBasedOnDeveloper, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxSearchWithTaskNameBasedOnDeveloper, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonSearchWithTaskNameBasedOnDeveloper, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldSearchTaskWithName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSearchWithTaskName))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldSearchWithTaskNameBasedOnDeveloper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSearchWithTaskNameBasedOnDeveloper)
                                        .addComponent(jComboBoxSearchWithTaskNameBasedOnDeveloper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Developer with Longest Duration");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Developers with Done Tasks");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Delete a task using task name");

        jButtonDeleteTask.setText("Delete");
        jButtonDeleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteTaskActionPerformed(evt);
            }
        });

        jTextAreaLongestDuration.setEditable(false);
        jTextAreaLongestDuration.setColumns(20);
        jTextAreaLongestDuration.setRows(5);
        jScrollPane1.setViewportView(jTextAreaLongestDuration);

        jTableDevelopersWithDoneTasks.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Name", "Surname", "Task", "Duration"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableDevelopersWithDoneTasks.setShowGrid(true);
        jScrollPane5.setViewportView(jTableDevelopersWithDoneTasks);
        jTableDevelopersWithDoneTasks.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jComboBoxDeleteWithTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonDeleteTask, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 10, Short.MAX_VALUE))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(16, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBoxDeleteWithTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonDeleteTask))
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)
                                .addGap(139, 139, 139)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(156, Short.MAX_VALUE)))
        );

        jTableReportWithFullDetailsOfTasksOfDevelopers.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Task", "Name", "Surname", "Duration", "Status", "ID"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableReportWithFullDetailsOfTasksOfDevelopers.setColumnSelectionAllowed(true);
        jTableReportWithFullDetailsOfTasksOfDevelopers.setShowGrid(true);
        jScrollPane2.setViewportView(jTableReportWithFullDetailsOfTasksOfDevelopers);
        jTableReportWithFullDetailsOfTasksOfDevelopers.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Report that lists the full details of all captured tasks.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jButtonBackToTaskBoard.setText("Back");
        jButtonBackToTaskBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackToTaskBoardActionPerformed(evt);
            }
        });

        jButtonBackToLogIn.setText("Logout");
        jButtonBackToLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackToLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(15, 15, 15))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButtonBackToTaskBoard)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelWelcomeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonBackToLogIn)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelWelcomeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonBackToLogIn)
                                        .addComponent(jButtonBackToTaskBoard))
                                .addGap(56, 56, 56)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jLabelWelcomeMessage.getAccessibleContext().setAccessibleName("Welcome to EasyKanban Task Report");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchWithTaskNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchWithTaskNameActionPerformed
        // TODO add your handling code here:
        String queryString = jTextFieldSearchTaskWithName.getText();
        model =
                (DefaultTableModel) jTableTaskSearchResults1.getModel();
        if (jTableTaskSearchResults1.getRowCount() > 0) {
            model.setRowCount(0);
        }

        searchForTasks(queryString).forEach(e -> model.addRow(new String[]{
                ((Task) e).getTaskName(),
                ((Task) e).getTaskDeveloperDetails()
                        .getDevFirstName(),
                ((Task) e).getTaskDeveloperDetails()
                        .getDevLastName(),
                ((Task) e).getTaskStatus()
        }));
        jTableTaskSearchResults1.setModel(model);
    }//GEN-LAST:event_jButtonSearchWithTaskNameActionPerformed

    private void jButtonSearchWithTaskNameBasedOnDeveloperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchWithTaskNameBasedOnDeveloperActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) jTableTasksAssignedToDeveloperSearchResults
                .getModel();
        if (jTableTasksAssignedToDeveloperSearchResults.getRowCount() > 0) {
            model.setRowCount(0);
        }
        String selectedItemInCombo = (String)
                jComboBoxSearchWithTaskNameBasedOnDeveloper.getSelectedItem();
        String taskSearchedFor =
                jTextFieldSearchWithTaskNameBasedOnDeveloper.getText();

        searchTaskWithDeveloper(selectedItemInCombo, taskSearchedFor)
                .forEach(e -> model.addRow(new String[]{
                        ((Task) e).getTaskName(),
                        ((Task) e).getTaskStatus(),
                }));
        jTableTasksAssignedToDeveloperSearchResults.setModel(model);
    }//GEN-LAST:event_jButtonSearchWithTaskNameBasedOnDeveloperActionPerformed

    private void jButtonDeleteTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteTaskActionPerformed
        // TODO add your handling code here:
        String selectedTask = jComboBoxDeleteWithTaskName
                .getSelectedItem()
                .toString();

        if (!TASKS_DB.isEmpty()) {
            if (deleteTask(selectedTask)) {
                JOptionPane.showMessageDialog(this, "Entry \"" + selectedTask + "\" "
                        + "successfully deleted");
            }
        }
        initializeAllData();
    }//GEN-LAST:event_jButtonDeleteTaskActionPerformed

    private void jButtonBackToTaskBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackToTaskBoardActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonBackToTaskBoardActionPerformed

    private void jButtonBackToLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackToLogInActionPerformed
        // TODO add your handling code here:
        dispose();
        //Login form
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFormBeans().setVisible(true);
        });
    }//GEN-LAST:event_jButtonBackToLogInActionPerformed
    // End of variables declaration//GEN-END:variables
}
