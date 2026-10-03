/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;

@SideOnly(value=Side.CLIENT)
public class avu
extends aut {
    public avu(int par1, int par2, int par3, int par4, int par5, String par6Str) {
        super(par1, par2, par3, par4, par5, par6Str);
    }

    public void a(String par1Str) {
        try {
            URI uri = new URI(par1Str);
            Class<?> oclass = Class.forName("java.awt.Desktop");
            Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            oclass.getMethod("browse", URI.class).invoke(object, uri);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

