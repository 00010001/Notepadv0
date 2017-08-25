package pl.sdacademy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    MenuItem menuItemOpen;
    @FXML
    MenuItem menuItemSave;
    @FXML
    public TabPane mainTabPane;

    private Desktop desktop = Desktop.getDesktop();
    final FileChooser fileChooser = new FileChooser();

    List<EditController> controllers = new ArrayList<>();

    public void initialize(Stage stage) {

        menuItemOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                configureFileChooser(fileChooser);
                List<File> list =
                        fileChooser.showOpenMultipleDialog(stage);
                if (list != null) {
                    for (File file : list) {

                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("edit.fxml"));
                        Tab fileTab;
                        try {
                            fileTab = fxmlLoader.load();
                        } catch (IOException e1) {
                            throw new RuntimeException();
                        }
                        EditController EditController = fxmlLoader.getController();
                        EditController.initialize(file );
                        mainTabPane.getTabs().add(fileTab);



                    }
                }
            }
        });


        menuItemSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                configureFileChooser(fileChooser);
                List<File> list =
                        fileChooser.showOpenMultipleDialog(stage);
                if (list != null) {
                    for (File file : list) {

                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("edit.fxml"));
                        Tab fileTab;
                        try {
                            fileTab = fxmlLoader.load();
                        } catch (IOException e1) {
                            throw new RuntimeException();
                        }
                        EditController EditController = fxmlLoader.getController();
                        EditController.initialize(file );
                        mainTabPane.getTabs().add(fileTab);



                    }
                }
            }
        });
    }

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Notes");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                //   new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("TXT", "*.txt")
                //new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

//    private void openFile(File file) {
//        try {
//            desktop.open(file);
//        } catch (IOException ex) {
//            Logger.getLogger(Notepad.class.getName()).log(
//                    Level.SEVERE, null, ex
//            );
//        }
//    }

}
