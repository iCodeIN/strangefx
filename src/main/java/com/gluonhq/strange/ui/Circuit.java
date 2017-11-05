package com.gluonhq.strange.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.input.TransferMode;

public class Circuit extends Control {

    private CircuitOutput output = new CircuitOutput();
    private int idx; // the number of the qubit
    private ObservableList<Gate> gates = FXCollections.observableArrayList();
    
    public int getIndex() {
        return this.idx;
    }
    
    public Circuit(int idx) {
        this.idx = idx;
        setPrefHeight(70);
//        setPrefWidth(Double.MAX_VALUE);
        //setStyle("-fx-background-color: white");
        getStyleClass().add("circuit");
        this.setOnDragOver(event -> {
            
             if (event.getGestureSource() != this &&
                event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
        }
        
        event.consume();
         
        });
        
        this.setOnDragDropped(e -> {
            e.getSource();
            System.out.println("drag dropped: "+e.getSource());
            gates.add(new Gate("D", 1));
        });
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new CircuitSkin(this);
    }

    public ObservableList<Gate> getGates() {
        return this.gates;
    }
    
    public CircuitOutput getOutput() {
        return output;
    }
    
    
}
