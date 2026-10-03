/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.server.MinecraftServer;

public class vmwi
extends Thread {
    public final /* synthetic */ MinecraftServer _a;

    public vmwi(MinecraftServer minecraftServer, String string) {
        this._a = minecraftServer;
        super(string);
    }

    @Override
    public void run() {
        this._a.run();
    }
}

