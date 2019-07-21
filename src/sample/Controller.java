package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;


public class Controller {


    @FXML
    public void close(MouseEvent mouseEvent) {
        ((Label) mouseEvent.getSource()).getScene().getWindow().hide();
    }


    public void newNote(MouseEvent mouseEvent) {
        Note note = new Note();
        Node source = (Node) mouseEvent.getSource();
        Window theStage = source.getScene().getWindow();
        note.openNewNote(new double[]{theStage.getX(), theStage.getY()});
    }
}
