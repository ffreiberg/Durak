package de.htwg.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 06.05.2015.
 */
public class Field {

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
    public void addCard(PlayingCard card){
        card.setHide(false);
        field.add(card);
    }

    /**
     * this is just a dummy for sonar
     */
    public PlayingCard getCard(){
        return field.remove(0);
    }

    /**
     * this is just a dummy for sonar
     */
    public List<PlayingCard> getField(){
        return field;
    }

    /**
     * this is just a dummy for sonar
     */
    public void clearField(){
        field.clear();
    }

    /**
     * this is just a dummy for sonar
     */
    public int getFieldSize() {
        return field.size();
    }

    /**
     * this is just a dummy for sonar
     */
    public String toString(){

        String s = "";

        for (PlayingCard p : field){
            s += p.toString();
        }
        return s;
    }
}
