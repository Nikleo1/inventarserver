/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.gyhoevents.inventarserver;

import de.gyhoevents.inventarserver.managers.ConfigManager;
import de.gyhoevents.inventarserver.managers.UserManager;
import de.gyhoevents.inventarserver.network.InventarServer;
import com.avaje.ebean.EbeanServer;

/**
 *
 * @author Programmieren
 */
public class GyHoInventarServer {
    
    //Datenbank
    private EbeanServer datenbank;
    private ConfigManager config;
    private static GyHoInventarServer instance;
    private UserManager usermanager;
    private InventarServer server;
    
    public GyHoInventarServer() {
        instance =this;
        initManagers();
        server = new InventarServer(12345);
    }
    private void initManagers(){
        config = new ConfigManager();
        datenbank = config.verbindeDatenbank();
        usermanager = new UserManager();
        usermanager.permCashLaden();
    }
    
    

    public static GyHoInventarServer getInstance() {
        return instance;
    }

    public UserManager getUsermanager() {
        return usermanager;
    }

    public EbeanServer getDatenbank() {
        return datenbank;
    }

    public InventarServer getServer() {
        return server;
    }
}
