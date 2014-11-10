/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.gyhoevents.inventarserver.objects;

import de.gyhoevents.inventarserver.database.tables.Benutzer;

/**
 *
 * @author Programmieren
 */
public class User {
    private Benutzer benutzer;
    private UserPermissions perms;

    public UserPermissions getPerms() {
        return perms;
    }

    public void setPerms(UserPermissions perms) {
        this.perms = perms;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }
    
    
}
