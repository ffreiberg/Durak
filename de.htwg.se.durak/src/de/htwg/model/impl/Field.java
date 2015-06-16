package de.htwg.model.impl;

import de.htwg.model.IField;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 06.05.2015.
 */
public class Field implements IField {

    private List<PlayingCard> field;

    /**
     * this is just a dummy for sonar
     */
    public Field(){
        this.field = new LinkedList<PlayingCard>();
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void addCard(PlayingCard card){
        card.setHide(false);
        field.add(card);
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public PlayingCard getCard(){
        return field.remove(0);
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public List<PlayingCard> getField(){
        return field;
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public void clearField(){
        field.clear();
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public int getFieldSize() {
        return field.size();
    }

    /**
     * this is just a dummy for sonar
     */
    @Override
    public String toString(){

        String s = "";

        for (PlayingCard p : field){
            s += p.toString();
        }
        return s;
    }
}
