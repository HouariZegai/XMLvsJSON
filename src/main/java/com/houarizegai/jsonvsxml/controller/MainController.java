package com.houarizegai.jsonvsxml.controller;

import com.houarizegai.jsonvsxml.App;
import com.houarizegai.jsonvsxml.global.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextArea areaXML, areaJSON, areaLog;

    @FXML
    private Label lblTimeXML, lblTimeJSON, lblNbrLinesXML, lblNbrLinesJSON;

    private FileChooser fileChooser;

    private File jsonFile, xmlFile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON/XML file", "*.xml", "*.json"));
    }

    @FXML
    private void onLoadJSON() {
        jsonFile = fileChooser.showOpenDialog(App.stage);
        areaJSON.setText(Utils.readStringFromFile(jsonFile));

    }

    @FXML
    private void onLoadXML() {
        xmlFile = fileChooser.showOpenDialog(App.stage);
        areaXML.setText(Utils.readStringFromFile(xmlFile));
    }

    @FXML
    private void onCalculate() {
        lblNbrLinesXML.setText(String.valueOf(Utils.getNumberOfLinesInFile(String.valueOf(xmlFile))));
        lblNbrLinesJSON.setText(String.valueOf(Utils.getNumberOfLinesInFile(String.valueOf(jsonFile))));
    }
}
