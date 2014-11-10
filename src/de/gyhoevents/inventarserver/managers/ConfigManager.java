/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gyhoevents.inventarserver.managers;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programmieren
 */
public class ConfigManager {

    private Properties prop;
    private FileOutputStream out;
    private FileInputStream in;

    File f = new File("server.properties");

    public ConfigManager() {
        prop = new Properties();
        try {
            if (!f.exists()) {
                //f.createNewFile();
                out = new FileOutputStream(f);
                neu();
            } else {
                in = new FileInputStream(f);
               
                lese();
            }
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void lese() {
        try {
            prop.load(in);
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void schreibe() {
        try {       
             out = new FileOutputStream(f);
            prop.store(out, null);
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void neu() {
       try {
            prop.setProperty("mysql.user", "mysqluser");
            prop.setProperty("mysql.password", "password");
            prop.setProperty("mysql.dbname", "dbname");

           
            prop.store(out, null);
            System.out.println("Config wurde angelegt bitte anpassen und dann neu starten ...");
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public String getProperty(String key){
        return prop.getProperty(key);
    }
    public EbeanServer verbindeDatenbank() {
        // Datenbank verbinden
        ServerConfig c = new ServerConfig();
        c.setName("TicTacToe");

        // Mysql einstellungen (Eigene Daten eintragen ) 
        DataSourceConfig mysql = new DataSourceConfig();
        mysql.setDriver("com.mysql.jdbc.Driver");
        
        mysql.setUsername(prop.getProperty("mysql.user"));
        mysql.setPassword(prop.getProperty("mysql.password"));
        mysql.setUrl("jdbc:mysql://127.0.0.1:3306/" + prop.getProperty("mysql.dbname"));
        mysql.setHeartbeatSql("select count(*) from users");

        c.setDataSourceConfig(mysql);

        c.setDdlGenerate(true);
        //wenn tabbelen generiert werden sollen beim ersten start auf true setzen
        c.setDdlRun(false);

        c.setDefaultServer(false);
        c.setRegister(true);

        c.addPackage("de.gyhoevents.inventarserver.database.tables");

        return EbeanServerFactory.create(c);

    }

}
