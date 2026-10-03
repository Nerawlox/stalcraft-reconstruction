/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.nio.IntBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class aup {
    private static final DateFormat a = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    private static IntBuffer b;
    private static int[] c;

    public static String a(File par0File, int par1, int par2) {
        return aup.a(par0File, null, par1, par2);
    }

    public static String a(File par0File, String par1Str, int par2, int par3) {
        try {
            File file2 = new File(par0File, "screenshots");
            file2.mkdir();
            int k = par2 * par3;
            if (b == null || b.capacity() < k) {
                b = BufferUtils.createIntBuffer((int)k);
                c = new int[k];
            }
            GL11.glPixelStorei((int)3333, (int)1);
            GL11.glPixelStorei((int)3317, (int)1);
            b.clear();
            GL11.glReadPixels((int)0, (int)0, (int)par2, (int)par3, (int)32993, (int)33639, (IntBuffer)b);
            b.get(c);
            aup.a(c, par2, par3);
            BufferedImage bufferedimage = new BufferedImage(par2, par3, 1);
            bufferedimage.setRGB(0, 0, par2, par3, c, 0, par2);
            File file3 = par1Str == null ? aup.a(file2) : new File(file2, par1Str);
            ImageIO.write((RenderedImage)bufferedimage, "png", file3);
            return "Saved screenshot as " + file3.getName();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "Failed to save: " + exception;
        }
    }

    private static File a(File par0File) {
        String s2 = a.format(new Date()).toString();
        int i = 1;
        File file2;
        while ((file2 = new File(par0File, s2 + (i == 1 ? "" : "_" + i) + ".png")).exists()) {
            ++i;
        }
        return file2;
    }

    private static void a(int[] par0ArrayOfInteger, int par1, int par2) {
        int[] aint1 = new int[par1];
        int k = par2 / 2;
        for (int l = 0; l < k; ++l) {
            System.arraycopy(par0ArrayOfInteger, l * par1, aint1, 0, par1);
            System.arraycopy(par0ArrayOfInteger, (par2 - 1 - l) * par1, par0ArrayOfInteger, l * par1, par1);
            System.arraycopy(aint1, 0, par0ArrayOfInteger, (par2 - 1 - l) * par1, par1);
        }
    }
}

