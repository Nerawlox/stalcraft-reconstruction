/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.logging.ILogAgent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.storage.ISaveHandler;

public class zily
extends WorldServer {
    public static final long _a = "North Carolina".hashCode();
    public static final WorldSettings _b = new WorldSettings(_a, EnumGameType._b, true, false, nwix._d)._a();

    public zily(MinecraftServer minecraftServer, ISaveHandler iSaveHandler, String string, int n, fokl fokl2, ILogAgent iLogAgent) {
        super(minecraftServer, iSaveHandler, string, n, _b, fokl2, iLogAgent);
    }
}

