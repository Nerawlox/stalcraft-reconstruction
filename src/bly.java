/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Map;

@SideOnly(value=Side.CLIENT)
class bly
extends Thread {
    final Map a;
    final blw b;

    bly(blw par1StatsSyncher, Map par2Map) {
        this.b = par1StatsSyncher;
        this.a = par2Map;
    }

    @Override
    public void run() {
        try {
            blw.a(this.b, this.a, blw.e(this.b), blw.f(this.b), blw.g(this.b));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            blw.a(this.b, false);
        }
    }
}

