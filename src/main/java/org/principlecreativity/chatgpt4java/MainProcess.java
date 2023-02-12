package org.principlecreativity.chatgpt4java;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainProcess extends Application {
    public static Stage stage;
    public static int width = 720;
    public static int height = 480;
    public String title = "OpenAI-ChatGPT4Java";
    @Override
    public void start(Stage stage) throws Exception {
        MainProcess.stage = stage;
        stage.setResizable(false);
        stage.getIcons().add(new Image("org/principlecreativity/chatgpt4java/icon/icon.png"));
        stage.setTitle(title);
        stage.setScene(new MainScene());
        stage.show();
    }
    static class MainScene extends Scene {
        private static final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("org/principlecreativity/chatgpt4java/mainfxml.fxml"));
        public MainScene() throws IOException {
            super(loader.load(), width, height);
        }
    }
}
