/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package todoapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author tasif
 */
public class ToDoController {

    @FXML
    private TextField taskInput;

    @FXML
    private ListView<String> taskList;

    private int selectedTaskIndex = -1;

    @FXML
    private void handleAddTask() {
        String task = taskInput.getText();
        if (!task.isEmpty()) {
            if (selectedTaskIndex == -1) {
                taskList.getItems().add(task);
            } else {
                taskList.getItems().set(selectedTaskIndex, task);
                selectedTaskIndex = -1;
            }
            taskInput.clear();
        }
    }

    @FXML
    private void handleDeleteTask() {
        int selectedTaskIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedTaskIndex >= 0) {
            taskList.getItems().remove(selectedTaskIndex);
            taskInput.clear();
        }
    }

    @FXML
    private void handleMarkAsDone() {
        int selectedTaskIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedTaskIndex >= 0) {
            String selectedTask = taskList.getItems().get(selectedTaskIndex);
            taskList.getItems().set(selectedTaskIndex, selectedTask + " (Done)");
        }
    }

    @FXML
    private void handleEditTask(ActionEvent event) {
        selectedTaskIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedTaskIndex >= 0) {
            String selectedTask = taskList.getItems().get(selectedTaskIndex);
            taskInput.setText(selectedTask);
        }
    }
}
