/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.ai;

/**
 *
 * @author Вадим
 */
public class Message {
    private int rating;
    private String text;
    
    public Message(int r, String t){
        rating = r;
        text = t;
    }
    
    public Message(Message a){
        rating = a.getRating();
        text = a.getText();
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
    
    public boolean equals(Message n){
        return this.text.equals(n.text);
    }
    
    public boolean equalsWithString(String n){
        return this.text.equals(n);
    }
}
