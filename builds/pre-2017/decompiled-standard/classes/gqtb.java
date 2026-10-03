/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.util.ResourceLocation;

public class gqtb
extends zhix {
    public final List _a;

    public gqtb(String ... stringArray) {
        this._a = Lists.newArrayList(stringArray);
    }

    @Override
    public void func_110551_a(xsfs xsfs2) {
        BufferedImage bufferedImage = null;
        try {
            for (String string : this._a) {
                if (string == null) continue;
                InputStream inputStream = xsfs2._a(new ResourceLocation(string))._a();
                BufferedImage bufferedImage2 = ImageIO.read(inputStream);
                if (bufferedImage == null) {
                    bufferedImage = new BufferedImage(bufferedImage2.getWidth(), bufferedImage2.getHeight(), 2);
                }
                bufferedImage.getGraphics().drawImage(bufferedImage2, 0, 0, null);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
        bsfn._a(this.func_110552_b(), bufferedImage);
    }
}

