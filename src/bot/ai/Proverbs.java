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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Вадим
 */
public class Proverbs {
    
    ArrayList<String> messages;
    
    public Proverbs() {
        messages = new ArrayList();
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
            messages.add(line);
            line = br.readLine();
        }
        br.close();
        isr.close();
        is.close();
        
    }
    
    public String getRandomAnswer(){
        Random r = new Random();
        return messages.get(r.nextInt(messages.size()));
    }
}
