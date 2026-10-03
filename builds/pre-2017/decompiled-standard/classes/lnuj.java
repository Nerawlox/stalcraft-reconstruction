/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;

public class lnuj
implements uyvo.kjui {
    @Override
    public InputStream _a(ResourceLocation resourceLocation) throws IOException {
        if (xpzm._E() != null) {
            htyg htyg2 = xpzm._E()._S()._a(resourceLocation);
            if (htyg2._b() && htyg2 instanceof dynm) {
                dynm dynm2 = (dynm)htyg2;
                dynm2._d.close();
            }
            return htyg2._a();
        }
        return null;
    }
}

