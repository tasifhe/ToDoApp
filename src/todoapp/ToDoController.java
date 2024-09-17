/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package todoapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ListCell;

/**
 *
 * @author tasif
 */
public class ToDoController implements Initializable {
    
    @FXML
    private TextField taskInput;

    @FXML
    private ListView<String> taskList;

    // Handle the Add Task button
    @FXML
    private void handleAddTask() {
        String task = taskInput.getText();
        if (!task.isEmpty()) {
            taskList.getItems().add(task);
            taskInput.clear();  // Clear the input field after adding the task
        }
    }

    // Handle the Delete Task button
    @FXML
    private void handleDeleteTask() {
        int selectedTaskIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedTaskIndex >= 0) {
            taskList.getItems().remove(selectedTaskIndex);  // Remove the selected task
        }
    }

    // Handle the Mark as Done button
    @FXML
    private void handleMarkAsDone() {
        int selectedTaskIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedTaskIndex >= 0) {
            String selectedTask = taskList.getItems().get(selectedTaskIndex);
            taskList.getItems().set(selectedTaskIndex, selectedTask + " (Done)");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}