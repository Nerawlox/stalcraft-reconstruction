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
class atw
extends Thread {
    final atv a;

    atw(atv par1Minecraft, String par2Str) {
        super(par2Str);
        this.a = par1Minecraft;
    }

    @Override
    public void run() {
        while (this.a.D) {
            try {
                Thread.sleep(Integer.MAX_VALUE);
            }
            catch (InterruptedException interruptedException) {}
        }
    }
}

