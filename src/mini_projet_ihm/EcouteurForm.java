/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Window;

import javafx.scene.Parent;

/**
 *
 * @author Natashaa
 */
public class EcouteurForm implements EventHandler {
    private ArrayList<Etudiant> listEtu = new ArrayList<Etudiant>();
    private Formulaire form;
    private Mini_projet_IHM ihm;
    
    public EcouteurForm(Formulaire myForm, Mini_projet_IHM myIhm)
    {
        form=myForm;
        ihm=myIhm;
    }

    EcouteurForm(Menu_Items ajouter, Mini_projet_IHM ihm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
    }

    @Override
    public void handle(Event event) {
        if(form.getName().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, form.getPane().getScene().getWindow(), "Form Error!", "Please enter your name");
            return;
        }
        if(form.getPrenom().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, form.getPane().getScene().getWindow(), "Form Error!", "Please enter your email id");
            return;
        }
        if(form.getNaissance()==null) {
            showAlert(Alert.AlertType.ERROR, form.getPane().getScene().getWindow(), "Form Error!", "Please enter a password");
            return;
        }
        if(form.getPromo()==null) {
            showAlert(Alert.AlertType.ERROR, form.getPane().getScene().getWindow(), "Form Error!", "Please enter a password");
            return;
        }

        form.setVisible(false);
        //ajouter etu à la liste
//        ihm.getEtu().add(etu);
//        listEtu.add(etu);
        ihm.setEtu(new Etudiant(form.getName(), form.getPrenom(), form.getNaissance(), form.getPromo()));
//        System.out.println(listEtu);
//        System.out.println(ihm.getEtu().size());
        
        showAlert(Alert.AlertType.CONFIRMATION, form.getPane().getScene().getWindow(), "Registration Successful!", "Welcome " + form.getName());

    }
    
}

