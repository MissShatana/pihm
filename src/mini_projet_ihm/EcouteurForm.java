
package mini_projet_ihm;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import java.time.LocalDate;

/**
 * This class listens the Validate button of the form to add a student
 * @author Natasha
 */
public class EcouteurForm implements EventHandler {
    private final Formulaire form;
    private final Mini_projet_IHM ihm;
    
    /**
     * This method builds the listener of the form to add a student
     * @param myForm the form completed
     * @param myIhm the main class
     */
    public EcouteurForm(Formulaire myForm, Mini_projet_IHM myIhm)
    {
        form=myForm;
        ihm=myIhm;
    }
    
    /**
     * This method show a message depending of how the form is complete
     * @param alertType
     * @param owner
     * @param title
     * @param message 
     */
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
    }
    
    /**
     * This class allow the button to add the student to the table
     * @param event 
     */
    @Override
    public void handle(Event event) {
        if(form.getName().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, form.getPane().getScene().getWindow(), "Erreur!", "Entrez un nom");
            return;
        }
        if(form.getPrenom().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, form.getPane().getScene().getWindow(), "Erreur!", "Entrez un prénom");
            return;
        }
        if(form.getNaissance()==null) {
            showAlert(Alert.AlertType.ERROR, form.getPane().getScene().getWindow(), "Erreur!", "Entrez une date de naissance");
            return;
        }
        if(form.getPromo()==null) {
            showAlert(Alert.AlertType.ERROR, form.getPane().getScene().getWindow(), "Erreur!", "Entrez une promo");
            return;
        }
        if(form.getNaissance().isBefore(LocalDate.now())==false) {
            showAlert(Alert.AlertType.ERROR, form.getPane().getScene().getWindow(), "Erreur !","S'il vous plait entrer une date avant aujourd'hui");
            return;
        }

        form.setVisible(false);
        ihm.setEtu(new Etudiant(form.getName(), form.getPrenom(), form.getNaissance(), form.getPromo()));
        form.setField();
        showAlert(Alert.AlertType.CONFIRMATION, form.getPane().getScene().getWindow(), "Registration Successful!", "Welcome " + form.getName());

    }
    
}

