/* @author fdd5501 */
package bookkeeping.mine;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class FXMLDocumentController extends Team implements Initializable  {

    boolean timerOn = false;
    boolean timerPaused = true;
    boolean subTimerPaused = true;
    int timerSeconds = 0;
    int timerMinutes = 0;
    int subTimerSeconds = 0;
    int subTimerMinutes = 0;
    int numTeams=0;
    Team[] teams=new Team[numTeams];
    Label[] teamNames = new Label[numTeams];

    EventHandler<ActionEvent> eventHandler = null;
    javafx.animation.Timeline timer = null;

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Label timerLabel;
    @FXML
    private Button subTimerButton;
    @FXML
    private Label subTimerLabel;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if (!timerOn) {

            timerOn = true;

            timer.play();
            timerPaused = false;
            button.setText("Pause Timer!");

            subTimerPaused = false;
            subTimerButton.setText("Pause Subtimer!");

        } else if (timerPaused) {

            timer.play();
            timerPaused = false;
            button.setText("Pause Timer!");

        } else if (!timerPaused) {

            timer.pause();
            timerPaused = true;
            button.setText("Start Timer!");

        }

    }

    @FXML
    private void handleSubTimer(ActionEvent event) {
        if (subTimerPaused)
            subTimerButton.setText("Pause Subtimer!");
        else
            subTimerButton.setText("Start Subtimer!");
        
        subTimerPaused = !subTimerPaused;
    }

   
    public void generateButtons(Pane pane) {

        int buttonYValue = 42;
        int labelYValue = 46;
        int timerYValue = 46;

        
        
    }
 @Override
    public void initialize(URL url, ResourceBundle rb) {

        eventHandler = e -> {

            timerSeconds++;
            if (timerSeconds == 60) {
                timerMinutes++;
                timerSeconds = 0;
            }

            if (!subTimerPaused) {
                subTimerSeconds++;
                if (subTimerSeconds == 60) {
                    subTimerMinutes++;
                    subTimerSeconds = 0;
                }
            }
            
            timerLabel.setText(String.format("%02d:%02d", timerMinutes, timerSeconds));
            subTimerLabel.setText(String.format("%02d:%02d", subTimerMinutes, subTimerSeconds));

        };

        timer = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler));
        timer.setCycleCount(180);

    }
}
