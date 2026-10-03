/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;

public class cegk
extends zhix {
    public final ResourceLocation _a;

    public cegk(ResourceLocation resourceLocation) {
        this._a = resourceLocation;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void func_110551_a(xsfs xsfs2) {
        InputStream inputStream = null;
        try {
            htyg htyg2 = xsfs2._a(this._a);
            inputStream = htyg2._a();
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            boolean bl = false;
            boolean bl2 = false;
            if (htyg2._b()) {
                try {
                    dyqm dyqm2 = (dyqm)htyg2._a("texture");
                    if (dyqm2 != null) {
                        bl = dyqm2._e();
                        bl2 = dyqm2._f();
                    }
                }
                catch (RuntimeException runtimeException) {
                    xpzm._E()._O()._a("Failed reading metadata of: " + this._a, runtimeException);
                }
            }
            bsfn._a(this.func_110552_b(), bufferedImage, bl, bl2);
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}

