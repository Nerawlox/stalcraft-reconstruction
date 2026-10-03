/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bia
 *  bjn
 *  bjo
 *  bjp
 *  bkw
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

@SideOnly(value=Side.CLIENT)
public class bif
extends bia {
    private final bjo b;

    public bif(bjo par1ResourceLocation) {
        this.b = par1ResourceLocation;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(bjp par1ResourceManager) throws IOException {
        InputStream inputstream = null;
        try {
            bjn resource = par1ResourceManager.a(this.b);
            inputstream = resource.b();
            BufferedImage bufferedimage = ImageIO.read(inputstream);
            boolean flag = false;
            boolean flag1 = false;
            if (resource.c()) {
                try {
                    bkw texturemetadatasection = (bkw)resource.a("texture");
                    if (texturemetadatasection != null) {
                        flag = texturemetadatasection.a();
                        flag1 = texturemetadatasection.b();
                    }
                }
                catch (RuntimeException runtimeexception) {
                    atv.w().an().b("Failed reading metadata of: " + this.b, (Throwable)runtimeexception);
                }
            }
            bip.a(this.b(), bufferedimage, flag, flag1);
        }
        finally {
            if (inputstream != null) {
                inputstream.close();
            }
        }
    }
}

