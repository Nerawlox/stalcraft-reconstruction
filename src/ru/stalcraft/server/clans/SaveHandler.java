/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.clans;

import cpw.mods.fml.relauncher.ReflectionHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import net.minecraft.server.MinecraftServer;
import ru.stalcraft.server.clans.ClanManager;

public class SaveHandler {
    private final File clansFile;

    public SaveHandler() {
        File saveDir = (File)ReflectionHelper.getPrivateValue(alr.class, (Object)((alr)MinecraftServer.F().P()), (String[])new String[]{"savesDirectory", "field_75808_a", "a"});
        String dir = MinecraftServer.F().b[0].M().g();
        this.clansFile = new File(saveDir.getPath() + File.separator + dir + File.separator + "clans.dat");
    }

    public void loadClans(ClanManager manager) {
        try {
            if (this.clansFile.exists()) {
                manager.readClans(ci.a(new FileInputStream(this.clansFile)));
            }
        }
        catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    public void saveClans(ClanManager manager) {
        try {
            by e2 = new by();
            manager.writeClans(e2);
            if (this.clansFile.exists()) {
                this.clansFile.delete();
            }
            ci.a(e2, new FileOutputStream(this.clansFile));
        }
        catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    public static by getOfflinePlayer(String username) {
        File saveDir = (File)ReflectionHelper.getPrivateValue(alr.class, (Object)((alr)MinecraftServer.F().P()), (String[])new String[]{"savesDirectory", "field_75808_a", "a"});
        String dir = MinecraftServer.F().b[0].M().g();
        File playerFile = new File(saveDir.getPath() + File.separator + dir + File.separator + "players" + File.separator + username + ".dat");
        if (!playerFile.exists()) {
            return new by();
        }
        try {
            return ci.a(new FileInputStream(playerFile));
        }
        catch (Exception var5) {
            var5.printStackTrace();
            return new by();
        }
    }
}

