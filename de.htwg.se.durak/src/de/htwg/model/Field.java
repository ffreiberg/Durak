package de.htwg.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jawaigel on 06.05.2015.
 */
public class Field {

    private List<PlayingCard> field;

    public Field(){
        field = new LinkedList<PlayingCard>();
    }

    public void addCard(PlayingCard card){
        card.setHide(false);
        field.add(card);
    }

    public PlayingCard getCard(){
        return field.remove(0);
    }

    public List<PlayingCard> getField(){
        return field;
    }

    public void clearField(){
        field.clear();
    }

    public int getFieldSize() {
        return field.size();
    }

    public String toString(){

        String s = "";

        for (PlayingCard p : field){
            s += p.toString();
        }
        return s;
    }
}
