/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abv
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
public class bjl
implements bjq {
    private static final bjo a = new bjo("textures/colormap/grass.png");

    public void a(bjp par1ResourceManager) {
        try {
            abv.a((int[])bip.a(par1ResourceManager, a));
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

