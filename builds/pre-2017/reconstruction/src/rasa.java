/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.bundle.pidb;
import net.minecraft.logging.ILogAgent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.storage.ISaveHandler;

public class rasa
extends WorldServer {
    public rasa(MinecraftServer minecraftServer, ISaveHandler iSaveHandler, String string, int n, WorldSettings worldSettings, WorldServer worldServer, fokl fokl2, ILogAgent iLogAgent) {
        iSaveHandler = pidb._a(iSaveHandler, string);
        string = pidb._a(string);
        super(minecraftServer, iSaveHandler, string, n, worldSettings, fokl2, iLogAgent);
        this.mapStorage = worldServer.mapStorage;
        this.worldScoreboard = worldServer.getScoreboard();
        this.worldInfo = new oirf(worldServer.getWorldInfo());
    }

    @Override
    public void saveLevel() throws xcad {
        this.perWorldStorage._a();
    }
}

