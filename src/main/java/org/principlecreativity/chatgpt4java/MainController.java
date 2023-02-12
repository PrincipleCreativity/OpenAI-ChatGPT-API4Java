package org.principlecreativity.chatgpt4java;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MainController {
    public static final OpenAIChatAPI API = new OpenAIChatAPI();
    private final Stage stage = MainProcess.stage;
    @FXML
    public TextArea inputArea;
    @FXML
    public TextArea outputArea;

    public MainController(){
    }

    @FXML
    public void generate(){
        String input = inputArea.getText();
        String output  = API.generateResponse(input);
        outputArea.setText(output);
    }
}
