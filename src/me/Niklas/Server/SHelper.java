/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.Niklas.Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programmieren
 */
public class SHelper {
    

public static byte[] serialize(Object obj) {
    ObjectOutputStream os = null;
    try {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    } catch (IOException ex) {
        Logger.getLogger(SHelper.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    } finally {
        try {
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(SHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public static Object deserialize(byte[] data) {
    ObjectInputStream is = null;
    try {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        is = new ObjectInputStream(in);
        return is.readObject();
    } catch (IOException ex) {
        Logger.getLogger(SHelper.class.getName()).log(Level.SEVERE, null, ex);
     
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(SHelper.class.getName()).log(Level.SEVERE, null, ex);
         
    } finally {
        try {
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(SHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}


    
}
