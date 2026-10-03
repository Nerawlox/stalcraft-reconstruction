/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class bsfn {
    public static final IntBuffer _a = pklh._d(0x400000);
    public static final sctt _b = new sctt(16, 16);
    public static final int[] _c = _b._b();

    public static int _a() {
        return GL11.glGenTextures();
    }

    public static int _a(int n, BufferedImage bufferedImage) {
        return bsfn._a(n, bufferedImage, false, false);
    }

    public static void _a(int n, int[] nArray, int n2, int n3) {
        bsfn._a(n);
        bsfn._a(nArray, n2, n3, 0, 0, false, false);
    }

    public static void _a(int[] nArray, int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5;
        int n6 = 0x400000 / n;
        bsfn._b(bl);
        bsfn._a(bl2);
        for (int i = 0; i < n * n2; i += n * n5) {
            int n7 = i / n;
            n5 = Math.min(n6, n2 - n7);
            int n8 = n * n5;
            bsfn._a(nArray, i, n8);
            GL11.glTexSubImage2D(3553, 0, n3, n4 + n7, n, n5, 32993, 33639, _a);
        }
    }

    public static int _a(int n, BufferedImage bufferedImage, boolean bl, boolean bl2) {
        bsfn._a(n, bufferedImage.getWidth(), bufferedImage.getHeight());
        return bsfn._a(n, bufferedImage, 0, 0, bl, bl2);
    }

    public static void _a(int n, int n2, int n3) {
        bsfn._a(n);
        GL11.glTexImage2D(3553, 0, 6408, n2, n3, 0, 32993, 33639, (IntBuffer)null);
    }

    public static int _a(int n, BufferedImage bufferedImage, int n2, int n3, boolean bl, boolean bl2) {
        bsfn._a(n);
        bsfn._a(bufferedImage, n2, n3, bl, bl2);
        return n;
    }

    public static void _a(BufferedImage bufferedImage, int n, int n2, boolean bl, boolean bl2) {
        int n3 = bufferedImage.getWidth();
        int n4 = bufferedImage.getHeight();
        int n5 = 0x400000 / n3;
        int[] nArray = new int[n5 * n3];
        bsfn._b(bl);
        bsfn._a(bl2);
        for (int i = 0; i < n3 * n4; i += n3 * n5) {
            int n6 = i / n3;
            int n7 = Math.min(n5, n4 - n6);
            int n8 = n3 * n7;
            bufferedImage.getRGB(0, n6, n3, n7, nArray, 0, n3);
            bsfn._a(nArray, n8);
            GL11.glTexSubImage2D(3553, 0, n, n2 + n6, n3, n7, 32993, 33639, _a);
        }
    }

    public static void _a(boolean bl) {
        if (bl) {
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
        } else {
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
        }
    }

    public static void _b(boolean bl) {
        if (bl) {
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
        } else {
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
        }
    }

    public static void _a(int[] nArray, int n) {
        bsfn._a(nArray, 0, n);
    }

    public static void _a(int[] nArray, int n, int n2) {
        int[] nArray2 = nArray;
        if (Minecraft._E()._M.anaglyph) {
            nArray2 = bsfn._a(nArray);
        }
        _a.clear();
        _a.put(nArray2, n, n2);
        _a.position(0).limit(n2);
    }

    public static void _a(int n) {
        GL11.glBindTexture(3553, n);
    }

    public static int[] _a(ResourceManager resourceManager, ResourceLocation resourceLocation) {
        BufferedImage bufferedImage = ImageIO.read(resourceManager._a(resourceLocation)._a());
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = new int[n * n2];
        bufferedImage.getRGB(0, 0, n, n2, nArray, 0, n);
        return nArray;
    }

    public static int[] _a(int[] nArray) {
        int[] nArray2 = new int[nArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i] >> 24 & 0xFF;
            int n2 = nArray[i] >> 16 & 0xFF;
            int n3 = nArray[i] >> 8 & 0xFF;
            int n4 = nArray[i] & 0xFF;
            int n5 = (n2 * 30 + n3 * 59 + n4 * 11) / 100;
            int n6 = (n2 * 30 + n3 * 70) / 100;
            int n7 = (n2 * 30 + n4 * 70) / 100;
            nArray2[i] = n << 24 | n5 << 16 | n6 << 8 | n7;
        }
        return nArray2;
    }

    static {
        int n = -16777216;
        int n2 = -524040;
        int[] nArray = new int[]{-524040, -524040, -524040, -524040, -524040, -524040, -524040, -524040};
        int[] nArray2 = new int[]{-16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216};
        int n3 = nArray.length;
        for (int i = 0; i < 16; ++i) {
            System.arraycopy(i < n3 ? nArray : nArray2, 0, _c, 16 * i, n3);
            System.arraycopy(i < n3 ? nArray2 : nArray, 0, _c, 16 * i + n3, n3);
        }
        _b._a();
    }
}

