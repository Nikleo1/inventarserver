/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.gyhoevents.inventarserver.helpers;

import de.gyhoevents.inventarserver.GyHoInventarServer;
import de.gyhoevents.inventarserver.database.tables.Benutzergruppe;
import de.gyhoevents.inventarserver.database.tables.Permission;
import java.util.HashMap;
import java.util.List;



/**
 *
 * @author Programmieren
 */
public class PermissionHelper {
    private HashMap<String,HashMap> perms;

    public PermissionHelper() {
        perms = new HashMap<>();
    }
    public HashMap<String,HashMap> getUserPerms(int uid){
        perms.clear();
         List<Benutzergruppe> gruppen = GyHoInventarServer.getInstance().getDatenbank().find(Benutzergruppe.class).where().ilike("uid", uid + "").findList();
        for(Permission p : GyHoInventarServer.getInstance().getUsermanager().getPermcash()){
           for(Benutzergruppe b: gruppen){
               if(b.getGid() == p.getGid()){
                   String[] perm = p.getNode().split(".");
                   HashMap<String,HashMap> pointer = perms;
                   
                   for(String s : perm){
                       if(pointer.get(s) != null){
                           pointer = pointer.get(s);
                       }else{
                           pointer.put(s, new HashMap<String,HashMap>());
                           pointer = pointer.get(s);
                       }
                   }
               }
           }
            
        }
        
        return perms;
    }
    
    
    
    
}
