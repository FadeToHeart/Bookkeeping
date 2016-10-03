/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookkeeping.mine;

import javafx.scene.control.Label;


/**
 *
 * @author Shadow
 */
public class Team extends Problem{
    Label teamName;
    
    public void Team(int teamNum, int nameX, int labelX, int coordY, int timerX,  int buttonX, int probNum){
        teamName.setText("Team "+teamNum);
        teamName.setLayoutX(nameX);
        teamName.setLayoutY(coordY);
        for(int i=0;i<probNum;i++){
            
        }//end for
    }//end Team()
}//end class team


