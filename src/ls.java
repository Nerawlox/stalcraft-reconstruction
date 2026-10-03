/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class ls {
    private static float[] a = new float[65536];

    public static final float a(float par0) {
        return a[(int)(par0 * 10430.378f) & 0xFFFF];
    }

    public static final float b(float par0) {
        return a[(int)(par0 * 10430.378f + 16384.0f) & 0xFFFF];
    }

    public static final float c(float par0) {
        return (float)Math.sqrt(par0);
    }

    public static final float a(double par0) {
        return (float)Math.sqrt(par0);
    }

    public static int d(float par0) {
        int i2 = (int)par0;
        return par0 < (float)i2 ? i2 - 1 : i2;
    }

    @SideOnly(value=Side.CLIENT)
    public static int b(double par0) {
        return (int)(par0 + 1024.0) - 1024;
    }

    public static int c(double par0) {
        int i2 = (int)par0;
        return par0 < (double)i2 ? i2 - 1 : i2;
    }

    public static long d(double par0) {
        long i2 = (long)par0;
        return par0 < (double)i2 ? i2 - 1L : i2;
    }

    public static float e(float par0) {
        return par0 >= 0.0f ? par0 : -par0;
    }

    public static int a(int par0) {
        return par0 >= 0 ? par0 : -par0;
    }

    public static int f(float par0) {
        int i2 = (int)par0;
        return par0 > (float)i2 ? i2 + 1 : i2;
    }

    public static int f(double par0) {
        int i2 = (int)par0;
        return par0 > (double)i2 ? i2 + 1 : i2;
    }

    public static int a(int par0, int par1, int par2) {
        return par0 < par1 ? par1 : (par0 > par2 ? par2 : par0);
    }

    public static float a(float par0, float par1, float par2) {
        return par0 < par1 ? par1 : (par0 > par2 ? par2 : par0);
    }

    public static double a(double par0, double par2) {
        if (par0 < 0.0) {
            par0 = -par0;
        }
        if (par2 < 0.0) {
            par2 = -par2;
        }
        return par0 > par2 ? par0 : par2;
    }

    @SideOnly(value=Side.CLIENT)
    public static int a(int par0, int par1) {
        return par0 < 0 ? -((-par0 - 1) / par1) - 1 : par0 / par1;
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean a(String par0Str) {
        return par0Str == null || par0Str.length() == 0;
    }

    public static int a(Random par0Random, int par1, int par2) {
        return par1 >= par2 ? par1 : par0Random.nextInt(par2 - par1 + 1) + par1;
    }

    public static double a(Random par0Random, double par1, double par3) {
        return par1 >= par3 ? par1 : par0Random.nextDouble() * (par3 - par1) + par1;
    }

    public static double a(long[] par0ArrayOfLong) {
        long i2 = 0L;
        long[] along1 = par0ArrayOfLong;
        int j2 = par0ArrayOfLong.length;
        for (int k2 = 0; k2 < j2; ++k2) {
            long l2 = along1[k2];
            i2 += l2;
        }
        return (double)i2 / (double)par0ArrayOfLong.length;
    }

    public static float g(float par0) {
        if ((par0 %= 360.0f) >= 180.0f) {
            par0 -= 360.0f;
        }
        if (par0 < -180.0f) {
            par0 += 360.0f;
        }
        return par0;
    }

    public static double g(double par0) {
        if ((par0 %= 360.0) >= 180.0) {
            par0 -= 360.0;
        }
        if (par0 < -180.0) {
            par0 += 360.0;
        }
        return par0;
    }

    public static int a(String par0Str, int par1) {
        int j2 = par1;
        try {
            j2 = Integer.parseInt(par0Str);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return j2;
    }

    public static int a(String par0Str, int par1, int par2) {
        int k2 = par1;
        try {
            k2 = Integer.parseInt(par0Str);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (k2 < par2) {
            k2 = par2;
        }
        return k2;
    }

    public static double a(String par0Str, double par1) {
        double d1 = par1;
        try {
            d1 = Double.parseDouble(par0Str);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return d1;
    }

    public static double a(String par0Str, double par1, double par3) {
        double d2 = par1;
        try {
            d2 = Double.parseDouble(par0Str);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (d2 < par3) {
            d2 = par3;
        }
        return d2;
    }

    static {
        for (int i2 = 0; i2 < 65536; ++i2) {
            ls.a[i2] = (float)Math.sin((double)i2 * Math.PI * 2.0 / 65536.0);
        }
    }
}

