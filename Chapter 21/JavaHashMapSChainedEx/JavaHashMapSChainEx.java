/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahashmapschainex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author ziping
 */
public class JavaHashMapSChainEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        String fileName = "mlb_players.csv";
        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));

        Player[] players = new Player[1500];
        MyJavaHashMapSChain<String, Player> pHashMap = new MyJavaHashMapSChain(1500);
        String line;
        line = inputStream.readLine();
        int i = 0;        
        while ((line = inputStream.readLine()) != null) {            
            String[] tokens = line.split("[,]");
            if(tokens.length < 2)
                break;
            tokens[0] = tokens[0].replaceAll("\"", "");
            for(int k = 1; k < 6; k++)
                tokens[k] = tokens[k].replaceAll("[\"\\s]", "");

            players[i] = new Player(tokens[0], tokens[1], tokens[2],
                                        Integer.parseInt(tokens[3]), 
                                        Integer.parseInt(tokens[4]), 
                                        Float.parseFloat(tokens[5]));

            if(pHashMap.put(players[i].getName(), players[i]) != null)
                System.out.println(i + " " + players[i]);
            //System.out.println(i + " " + players[i]);
            i++;
        }
        
        System.out.println("\nplayers hashmap size: " + pHashMap.size());
        Set<String> nameSet = pHashMap.keySet();
        System.out.println("players nameset size: " + nameSet.size());
        
        // find out the same name players
        List<Player> arrStr = Arrays.asList(players);
        List<String> names = arrStr.stream().filter(p->p!=null).map(p -> p.getName()).collect(Collectors.toList());
        System.out.println("\nThe overlapped names: ");
        for(String s : nameSet)
            if(names.indexOf(s) != names.lastIndexOf(s))
                System.out.println(s);
            
        Collection<Player> playerArr = pHashMap.values();
        System.out.println("\nplayers size: ");
        System.out.println(playerArr.size());
        
        if(pHashMap.containsKey("Jorge Julio"))
            pHashMap.replace("Jorge Julio", pHashMap.get("Jorge Julio"), players[0]);
        System.out.println("\nJorge Julio's profile is hacked to: " + pHashMap.get("Jorge Julio"));
       
        pHashMap.remove("Jorge Julio");
        System.out.println("\nJorge Julio's profile still there? " + 
                pHashMap.containsKey("Jorge Julio"));
        
        if(pHashMap.containsKey("Tyler Johnson"))
            System.out.println("\nTyler Johnson's profile: " + pHashMap.get("Tyler Johnson"));
        // remove with both key and value
        pHashMap.remove("Tyler Johnson", new Player("Tyler Johnson", "STL", "ReliefPitcher", 74, 180, 25.73f));
        // using value to check if removed successfully
        System.out.println("\nTyler Johnson's profile still there? " + 
                pHashMap.containsValue(new Player("Tyler Johnson", "STL", "ReliefPitcher", 74, 180, 25.73f)));
       
        System.out.println();
        pHashMap.outputChains();
        inputStream.close();
    }
    
}
