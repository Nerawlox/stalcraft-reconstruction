/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

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

public class srok {
    public static final DateFormat _a = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    public static IntBuffer _b;
    public static int[] _c;

    public static String _a(File file, int n, int n2) {
        return srok._a(file, null, n, n2);
    }

    public static String _a(File file, String string, int n, int n2) {
        try {
            File file2 = new File(file, "screenshots");
            file2.mkdir();
            int n3 = n * n2;
            if (_b == null || _b.capacity() < n3) {
                _b = BufferUtils.createIntBuffer(n3);
                _c = new int[n3];
            }
            GL11.glPixelStorei(3333, 1);
            GL11.glPixelStorei(3317, 1);
            _b.clear();
            GL11.glReadPixels(0, 0, n, n2, 32993, 33639, _b);
            _b.get(_c);
            srok._a(_c, n, n2);
            BufferedImage bufferedImage = new BufferedImage(n, n2, 1);
            bufferedImage.setRGB(0, 0, n, n2, _c, 0, n);
            File file3 = string == null ? srok._a(file2) : new File(file2, string);
            ImageIO.write((RenderedImage)bufferedImage, "png", file3);
            return "Saved screenshot as " + file3.getName();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "Failed to save: " + exception;
        }
    }

    public static File _a(File file) {
        String string = _a.format(new Date()).toString();
        int n = 1;
        File file2;
        while ((file2 = new File(file, string + (n == 1 ? "" : "_" + n) + ".png")).exists()) {
            ++n;
        }
        return file2;
    }

    public static void _a(int[] nArray, int n, int n2) {
        int[] nArray2 = new int[n];
        int n3 = n2 / 2;
        for (int i = 0; i < n3; ++i) {
            System.arraycopy(nArray, i * n, nArray2, 0, n);
            System.arraycopy(nArray, (n2 - 1 - i) * n, nArray, i * n, n);
            System.arraycopy(nArray2, 0, nArray, (n2 - 1 - i) * n, n);
        }
    }
}

