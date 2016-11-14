/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.norduni.javaoblig2;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 * Reference: http://beginnersbook.com/2013/12/how-to-serialize-arraylist-in-java/
 */
public class bookingDataStore {

    public static ArrayList readFile(String dataFileName) {
        
        ArrayList<Flight> objects = new ArrayList<>();
        try {
            
            FileInputStream fis = new FileInputStream(dataFileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            objects = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class Not Found.");
            c.printStackTrace();
        }
        
        return objects;
    }
    
    public static void writeFile(String dataFileName, ArrayList arrayList) {
        
        try {
            FileOutputStream fos = new FileOutputStream(dataFileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(arrayList);
            oos.close();
            fos.close();
            
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
            
    }
    
    
    
}
