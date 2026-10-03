/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atu
 *  bib
 *  bjo
 *  bjp
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bip {
    private static final IntBuffer c = atu.f((int)0x400000);
    public static final bib a = new bib(16, 16);
    public static final int[] b = a.c();

    public static int a() {
        return GL11.glGenTextures();
    }

    public static int a(int par0, BufferedImage par1BufferedImage) {
        return bip.a(par0, par1BufferedImage, false, false);
    }

    public static void a(int par0, int[] par1ArrayOfInteger, int par2, int par3) {
        bip.b(par0);
        bip.a(par1ArrayOfInteger, par2, par3, 0, 0, false, false);
    }

    public static void a(int[] par0ArrayOfInteger, int par1, int par2, int par3, int par4, boolean par5, boolean par6) {
        int j1;
        int i1 = 0x400000 / par1;
        bip.b(par5);
        bip.a(par6);
        for (int k1 = 0; k1 < par1 * par2; k1 += par1 * j1) {
            int l1 = k1 / par1;
            j1 = Math.min(i1, par2 - l1);
            int i2 = par1 * j1;
            bip.a(par0ArrayOfInteger, k1, i2);
            GL11.glTexSubImage2D((int)3553, (int)0, (int)par3, (int)(par4 + l1), (int)par1, (int)j1, (int)32993, (int)33639, (IntBuffer)c);
        }
    }

    public static int a(int par0, BufferedImage par1BufferedImage, boolean par2, boolean par3) {
        bip.a(par0, par1BufferedImage.getWidth(), par1BufferedImage.getHeight());
        return bip.a(par0, par1BufferedImage, 0, 0, par2, par3);
    }

    public static void a(int par0, int par1, int par2) {
        bip.b(par0);
        GL11.glTexImage2D((int)3553, (int)0, (int)6408, (int)par1, (int)par2, (int)0, (int)32993, (int)33639, (IntBuffer)null);
    }

    public static int a(int par0, BufferedImage par1BufferedImage, int par2, int par3, boolean par4, boolean par5) {
        bip.b(par0);
        bip.a(par1BufferedImage, par2, par3, par4, par5);
        return par0;
    }

    private static void a(BufferedImage par0BufferedImage, int par1, int par2, boolean par3, boolean par4) {
        int k = par0BufferedImage.getWidth();
        int l2 = par0BufferedImage.getHeight();
        int i1 = 0x400000 / k;
        int[] aint = new int[i1 * k];
        bip.b(par3);
        bip.a(par4);
        for (int j1 = 0; j1 < k * l2; j1 += k * i1) {
            int k1 = j1 / k;
            int l1 = Math.min(i1, l2 - k1);
            int i2 = k * l1;
            par0BufferedImage.getRGB(0, k1, k, l1, aint, 0, k);
            bip.a(aint, i2);
            GL11.glTexSubImage2D((int)3553, (int)0, (int)par1, (int)(par2 + k1), (int)k, (int)l1, (int)32993, (int)33639, (IntBuffer)c);
        }
    }

    private static void a(boolean par0) {
        if (par0) {
            GL11.glTexParameteri((int)3553, (int)10242, (int)10496);
            GL11.glTexParameteri((int)3553, (int)10243, (int)10496);
        } else {
            GL11.glTexParameteri((int)3553, (int)10242, (int)10497);
            GL11.glTexParameteri((int)3553, (int)10243, (int)10497);
        }
    }

    private static void b(boolean par0) {
        if (par0) {
            GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        } else {
            GL11.glTexParameteri((int)3553, (int)10241, (int)9728);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9728);
        }
    }

    private static void a(int[] par0ArrayOfInteger, int par1) {
        bip.a(par0ArrayOfInteger, 0, par1);
    }

    private static void a(int[] par0ArrayOfInteger, int par1, int par2) {
        int[] aint1 = par0ArrayOfInteger;
        if (atv.w().u.g) {
            aint1 = bip.a(par0ArrayOfInteger);
        }
        c.clear();
        c.put(aint1, par1, par2);
        c.position(0).limit(par2);
    }

    static void b(int par0) {
        GL11.glBindTexture((int)3553, (int)par0);
    }

    public static int[] a(bjp par0ResourceManager, bjo par1ResourceLocation) throws IOException {
        BufferedImage bufferedimage = ImageIO.read(par0ResourceManager.a(par1ResourceLocation).b());
        int i2 = bufferedimage.getWidth();
        int j2 = bufferedimage.getHeight();
        int[] aint = new int[i2 * j2];
        bufferedimage.getRGB(0, 0, i2, j2, aint, 0, i2);
        return aint;
    }

    public static int[] a(int[] par0ArrayOfInteger) {
        int[] aint1 = new int[par0ArrayOfInteger.length];
        for (int i2 = 0; i2 < par0ArrayOfInteger.length; ++i2) {
            int j2 = par0ArrayOfInteger[i2] >> 24 & 0xFF;
            int k = par0ArrayOfInteger[i2] >> 16 & 0xFF;
            int l2 = par0ArrayOfInteger[i2] >> 8 & 0xFF;
            int i1 = par0ArrayOfInteger[i2] & 0xFF;
            int j1 = (k * 30 + l2 * 59 + i1 * 11) / 100;
            int k1 = (k * 30 + l2 * 70) / 100;
            int l1 = (k * 30 + i1 * 70) / 100;
            aint1[i2] = j2 << 24 | j1 << 16 | k1 << 8 | l1;
        }
        return aint1;
    }

    static {
        int i2 = -16777216;
        int j2 = -524040;
        int[] aint = new int[]{-524040, -524040, -524040, -524040, -524040, -524040, -524040, -524040};
        int[] aint1 = new int[]{-16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216};
        int k = aint.length;
        for (int l2 = 0; l2 < 16; ++l2) {
            System.arraycopy(l2 < k ? aint : aint1, 0, b, 16 * l2, k);
            System.arraycopy(l2 < k ? aint1 : aint, 0, b, 16 * l2 + k, k);
        }
        a.a();
    }
}

