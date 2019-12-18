/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminaccess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.TextFlow;

public class AdminController {

    @FXML
    private Button upload;
    @FXML
    private Button DB;
    @FXML
    private ChoiceBox<?> sortBy;
    @FXML
    private TextFlow output;

    @FXML
    void fileSelector(ActionEvent event) {
    }

    @FXML
    void showDB(ActionEvent event) {
    }
}
