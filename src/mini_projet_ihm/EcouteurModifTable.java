/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

/**
 *
 * @author Natashaa
 */
public class EcouteurModifTable implements EventHandler {
     private Formulaire formModif;
    private Mini_projet_IHM ihm;
    private Etudiant Etu;
    private TableView etus;
    
    public EcouteurModifTable(Formulaire myForm, Mini_projet_IHM myIhm, Etudiant myEtu, TableView<Etudiant> etus)
    {
        formModif=myForm;
        ihm=myIhm;
        Etu = myEtu;
        etus = etus;
    }
    
    @Override
    public void handle(Event event) {
        // get Selected Item

            Etudiant currentEtu = (Etudiant) getTableView().getItems().get(TableauEtu.ButtonCell.this.getIndex());
            //remove selected item from the table list
            formModif = new Formulaire(currentEtu);
            System.out.println("aaa");
            formModif.setVisible(true);
            System.out.println("bbb");
            currentEtu.setPrenom("Josette");
            System.out.println("ccc");
            //table.getItems().remove(currentEtu);
            table.refresh();
                }
    }
           

