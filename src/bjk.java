/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abs
 *  bjo
 *  bjp
 *  bjq
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;

@SideOnly(value=Side.CLIENT)
public class bjk
implements bjq {
    private static final bjo a = new bjo("textures/colormap/foliage.png");

    public void a(bjp par1ResourceManager) {
        try {
            abs.a((int[])bip.a(par1ResourceManager, a));
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

