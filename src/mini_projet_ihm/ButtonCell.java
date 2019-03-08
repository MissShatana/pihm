/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Natashaa
 */
public class ButtonCell extends TableCell<Etudiant, Boolean> {
        final Image img = new Image(TableauEtu.class.getResourceAsStream("images/quitter.jpg"));
        final ImageView imgv = new ImageView(img);
        final Button cellButton;
//        final TableView<Etudiant> table;
//        Formulaire formModif;
        
        ButtonCell(){
//                TableView<Etudiant> myTable, Formulaire myFormModif){
            imgv.setFitHeight(30);
            imgv.setFitWidth(30);
            cellButton = new Button("",imgv);
//            table=myTable;
//            formModif = myFormModif;
//        	//Action when the button is pressed
            
            
        
        }
    }
