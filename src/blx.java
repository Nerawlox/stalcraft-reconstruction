/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
class blx
extends Thread {
    final blw a;

    blx(blw par1StatsSyncher) {
        this.a = par1StatsSyncher;
    }

    @Override
    public void run() {
        try {
            if (blw.a(this.a) != null) {
                blw.a(this.a, blw.a(this.a), blw.b(this.a), blw.c(this.a), blw.d(this.a));
            } else if (blw.b(this.a).exists()) {
                blw.a(this.a, blw.a(this.a, blw.b(this.a), blw.c(this.a), blw.d(this.a)));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            blw.a(this.a, false);
        }
    }
}

