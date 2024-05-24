package org.example.school_manager2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.example.school_manager2.db.IDBConfig;
import org.example.school_manager2.models.Student;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StudentControllers implements Initializable {

    @FXML
    private DatePicker date;

    @FXML
    private TextField first;

    @FXML
    private TextField last;

    @FXML
    private TextField place;


    @FXML
    private Button register;

    @FXML
    private ComboBox<String> state;
    @FXML
    private ComboBox<String> classroom;
    private Connection connection;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            connection = IDBConfig.getConnection();

            if (this.connection != null) {
                String req = "SELECT * FROM classroom";
                PreparedStatement preparedStatement = this.connection.prepareStatement(req);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    classroom.getItems().add(String.valueOf(resultSet.getInt("Id")));
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        state.getItems().add("0");
        state.getItems().add("1");
        state.getItems().add("2");
    }


    public void create() {

        String firstname = first.getText();
        String lastname = last.getText();
        Date dateOfBirth = Date.valueOf(date.getValue());
        String placeOfBirth = place.getText();
        int state1 = Integer.parseInt(state.getValue());
        int classromId = Integer.parseInt(classroom.getValue());

        Student student = new Student();

        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setDateOfBirth(dateOfBirth);
        student.setPlaceOfBirth(placeOfBirth);
        student.setState(state1);
        student.setClassroom(classromId);

        student.create(student);

    }
}


