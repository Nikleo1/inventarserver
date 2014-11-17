/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.gyhoevents.inventarserver.managers;

import de.gyhoevents.inventarserver.GyHoInventarServer;
import de.gyhoevents.inventarserver.database.tables.Benutzer;
import de.gyhoevents.inventarserver.database.tables.Permission;
import de.gyhoevents.inventarserver.helpers.PermissionHelper;
import de.gyhoevents.inventarserver.objects.Client;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Programmieren
 */
public class UserManager {
    private HashMap<String,Client> clients;
    private List<Permission> permcash;
    private PermissionHelper permhelp;

    public UserManager() {
        clients = new HashMap<>();
        permhelp  = new PermissionHelper();
    }
    
    public void permCashLaden(){
        System.out.println("Beginne Permission Cash zu laden");
        permcash = GyHoInventarServer.getInstance().getDatenbank().find(Permission.class).findList();
        System.out.println("Cash geladen");
    }

    public HashMap<String, Client> getClients() {
        return clients;
    }
    public void login(String pip, Benutzer b){
        clients.get(pip).setEingeloggt(true);
        clients.get(pip).setBenutzer(b);
        clients.get(pip).setPermissions(permhelp.getUserPerms(b.getId()));
        
    }

    public List<Permission> getPermcash() {
        return permcash;
    }
    
    
    
}
