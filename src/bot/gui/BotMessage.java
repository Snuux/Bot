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
        
        if (prev == "11/11")
            text = "меня зовут Bot. Ты можешь со мной пообщаться";
        else if (prev == "22/22")
            text = "только пиши с маленькой буквы! А то я не очень понимаю большие";
    }
    
}