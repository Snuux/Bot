/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.ai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Вадим
 */
public class Generator {
    ArrayList<MessageData> messages;
    Proverbs proverb;

    public Generator() {
        messages = new ArrayList();
        proverb = new Proverbs();
        init("Generator.txt");
        proverb.init("Proverbs.txt");
    }
    
    public void init(String name){
        try {
            loadFile(name);
        } catch (Exception ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadFile(String name) throws Exception{
        InputStream is = getClass().getResourceAsStream(name);
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);//new FileReader(name));
        String line = br.readLine();
        while (line != null) {
            loadMessageData(line);
            line = br.readLine();
        }
        br.close();
        isr.close();
        is.close();
    }
    
    private void loadMessageData(String line){
        String[] blocks = line.split(" // ");
        String[] words;
        words = blocks[0].split("( =)|(= )|(=)");
        MessageData t = new MessageData();
        for (int i = 0; i < words.length; i += 2){
            t.addMessageData(words[i], Integer.parseInt(words[i+1]), true);
        }
        
        words = blocks[1].split("( =)|(= )|(=)");
        for (int i = 0; i < words.length; i += 2){
            t.addMessageData(words[i], Integer.parseInt(words[i+1]), false);
        }
        
        messages.add(t);
    }
    
    public String getAnswer(String prev){
        for (MessageData m : messages){
            for (Message userText : m.getUserText())
                if (prev.equals(userText.getText())){
                    return m.getRandomAnswer().getText();        
                }
        }
        
        return proverb.getRandomAnswer();
    }
}
