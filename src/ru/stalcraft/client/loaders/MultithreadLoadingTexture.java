/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bia
 *  bjn
 *  bjo
 *  bjp
 *  bkw
 */
package ru.stalcraft.client.loaders;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class MultithreadLoadingTexture
extends bia {
    private final bjo textureLocation;
    private BufferedImage bufferedimage;
    private boolean flag;
    private boolean flag1;

    public MultithreadLoadingTexture(bjo par1ResourceLocation) {
        this.textureLocation = par1ResourceLocation;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(bjp par1ResourceManager) throws IOException {
        block7: {
            InputStream inputstream = null;
            try {
                bjn resource = par1ResourceManager.a(this.textureLocation);
                inputstream = resource.b();
                this.bufferedimage = ImageIO.read(inputstream);
                if (!resource.c()) break block7;
                try {
                    bkw runtimeexception = (bkw)resource.a("texture");
                    if (runtimeexception != null) {
                        this.flag = runtimeexception.a();
                        this.flag1 = runtimeexception.b();
                    }
                }
                catch (RuntimeException var8) {
                    atv.w().an().b("Failed reading metadata of: " + this.textureLocation, (Throwable)var8);
                }
            }
            finally {
                if (inputstream != null) {
                    inputstream.close();
                }
            }
        }
    }

    public void upload() {
        try {
            bip.a(this.b(), this.bufferedimage, this.flag, this.flag1);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

