/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  nb
 */
package ru.stalcraft.server.command;

public class CommandSuicide
extends z {
    public String c() {
        return "player";
    }

    public String c(ad icommandsender) {
        return "";
    }

    public void b(ad icommandsender, String[] astring) {
        String string = astring[0];
        if (string.equals("suicide")) {
            ((uf)icommandsender).a(nb.e, 100.0f);
        }
    }
}

