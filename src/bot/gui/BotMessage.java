/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.gui;

/**
 *
 * @author Вадим
 */
public class BotMessage extends Message{    
    public BotMessage(String prev) {
        super();
        text = "";
        text = Bot.generator.getAnswer(prev);
        name = "Bot";        
    }
    
}