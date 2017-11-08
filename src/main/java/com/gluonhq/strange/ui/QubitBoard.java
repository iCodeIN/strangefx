package com.gluonhq.strange.ui;

import com.gluonhq.strange.Model;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;

public class QubitBoard extends VBox {

    private Model model = Model.getInstance();
    private ObservableList<Qubit> qubits = FXCollections.observableArrayList();

    public QubitBoard() {
        getChildren().setAll(qubits);
        qubits.addListener( (Observable o) -> {
            getChildren().clear();
            getChildren().setAll(qubits);
            model.setNQubits(qubits.size());
        });
    }

    public ObservableList<Qubit> getQubits() {
        return qubits;
    }

    public void appendQubit() {
        qubits.add( new Qubit(qubits.size()));
    }
}