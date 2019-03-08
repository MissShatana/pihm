
package mini_projet_ihm;

import java.time.LocalDate;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import javafx.scene.control.TableView;

/**
 * This class listens the form that modifies a student
 * @author Natasha Germain
 */
public class EcouteurModif implements EventHandler {
    private final Formulaire form;
    private final TableView<Etudiant> tab;
    private final Etudiant Etu;
    
    public EcouteurModif(Formulaire myForm, TableView<Etudiant> table, Etudiant myEtu)
    {
        form=myForm;
        tab=table;
        Etu = myEtu;
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
     * This class allow the button to modify the student to the table
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
            showAlert(Alert.AlertType.ERROR, form.getPane().getScene().getWindow(), "Erreur!", "Entrez une naissance");
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
        showAlert(Alert.AlertType.CONFIRMATION, form.getPane().getScene().getWindow(), "Modification Validée", "L'étudiant suivant a été modifié " + form.getName() + form.getPrenom());

        form.setVisible(false);
        Etu.setPrenom(form.getPrenom());
        Etu.setNom(form.getName());
        Etu.setPromo(form.getPromo());
        Etu.setNaissance(form.getNaissance());
        tab.setVisible(true);
        tab.refresh();
        
        
    }
    
}

