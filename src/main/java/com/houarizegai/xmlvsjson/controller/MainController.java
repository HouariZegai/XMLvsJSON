package com.houarizegai.xmlvsjson.controller;

import com.houarizegai.xmlvsjson.App;
import com.houarizegai.xmlvsjson.engine.json.JSONParser;
import com.houarizegai.xmlvsjson.engine.xml.XMLParserSAX;
import com.houarizegai.xmlvsjson.global.Utils;
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

    private FileChooser fileChooserXML, fileChooserJSON;

    private File jsonFile, xmlFile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooserXML = new FileChooser();
        fileChooserXML.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON/XML file", "*.xml"));

        fileChooserJSON = new FileChooser();
        fileChooserJSON.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON/XML file", "*.json"));
    }

    @FXML
    private void onLoadJSON() {
        jsonFile = fileChooserJSON.showOpenDialog(App.stage);
        if(jsonFile == null)
            return;

        areaJSON.setText(Utils.readStringFromFile(jsonFile));

    }

    @FXML
    private void onLoadXML() {
        xmlFile = fileChooserXML.showOpenDialog(App.stage);
        if(xmlFile == null)
            return;

        areaXML.setText(Utils.readStringFromFile(xmlFile));
    }

    @FXML
    private void onCalculate() {
        areaLog.setText(null);

        lblNbrLinesXML.setText(String.valueOf(Utils.getNumberOfLinesInFile(String.valueOf(xmlFile))));
        lblNbrLinesJSON.setText(String.valueOf(Utils.getNumberOfLinesInFile(String.valueOf(jsonFile))));

        if(xmlFile != null) {
            long currentTime = System.currentTimeMillis();
            areaLog.appendText(String.valueOf(XMLParserSAX.parseXML(String.valueOf(xmlFile))));
            lblTimeXML.setText(System.currentTimeMillis() - currentTime + " ms");
        }

        if(jsonFile != null) {
            long currentTime = System.currentTimeMillis();
            areaLog.appendText(String.valueOf(JSONParser.parseJSON(String.valueOf(jsonFile))));
            lblTimeJSON.setText(System.currentTimeMillis() - currentTime + " ms");
        }
    }
}
