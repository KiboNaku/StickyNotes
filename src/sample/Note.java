package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

class Note {

    private Stage noteStage;

    private double yOffset = 0;
    private double xOffset = 0;

    void openNewNote(double[] previousPos) {
        try {
            boolean isFirst = previousPos == null || previousPos.length < 2;
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            noteStage = new Stage();
            noteStage.initStyle(StageStyle.TRANSPARENT);
            noteStage.setTitle("Note");


            //grab your root here
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            //move around here
            root.setOnMouseDragged(event -> {
                noteStage.setX(event.getScreenX() - xOffset);
                noteStage.setY(event.getScreenY() - yOffset);
            });

            noteStage.setScene(new Scene(root, 270, 240));
            int DEFAULT_X_POS = 20;
            noteStage.setX(DEFAULT_X_POS + (isFirst ? 0 : previousPos[0]));
            int DEFAULT_Y_POS = 20;
            noteStage.setY(DEFAULT_Y_POS + (isFirst ? 0 : previousPos[1]));


            noteStage.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    void openNewNote() {
        openNewNote(null);
    }
}
