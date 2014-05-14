/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.ai;

import static bot.gui.Bot.rating;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Вадим
 */
public class MessageData {
    private final ArrayList<Message> userText;
    private final ArrayList<Message> botText;
    
    public MessageData(){
        userText = new ArrayList();
        botText = new ArrayList();
    }
    
    public void addMessageData(String a, int b, boolean k){
        if (k)
            userText.add(new Message(b, a));
        else
            botText.add(new Message(b, a));
    }
    
    public Message getRandomAnswer(){
        Random r = new Random();
        Message m = new Message(botText.get(r.nextInt(botText.size())));
        changeRating(m.getRating());
        return m;
    }
    
    private void changeRating(int r){
        if (r < 5){
            rating += 10-5/2;
        } 
        else if (r > 5){
            rating -= 10-5/2;
        }
        
        if (rating < 0)
            rating = 0;
        else if (rating > 100)
            rating = 100;        
    }

    /**
     * @return the userText
     */
    public ArrayList<Message> getUserText() {
        return userText;
    }

    /**
     * @return the botText
     */
    public ArrayList<Message> getBotText() {
        return botText;
    }
    
    
}
