/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  net.minecraft.server.MinecraftServer
 *  t
 */
import net.minecraft.server.MinecraftServer;

public class kh
implements ad {
    public static final kh a = new kh();
    private StringBuffer b = new StringBuffer();

    public void d() {
        this.b.setLength(0);
    }

    public String e() {
        return this.b.toString();
    }

    public String c_() {
        return "Rcon";
    }

    public void a(cv par1ChatMessageComponent) {
        this.b.append(par1ChatMessageComponent.toString());
    }

    public boolean a(int par1, String par2Str) {
        return true;
    }

    public t b() {
        return new t(0, 0, 0);
    }

    public abw f_() {
        return MinecraftServer.F().f_();
    }
}

