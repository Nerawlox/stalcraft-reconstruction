/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.effects.client.main.pidb;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

public class ytsw {
    public static float[] _a = new float[3];
    public static float[] _b = new float[3];
    private static dwwj[] _f;
    static int _c;
    static int _d;
    static int _e;

    public static void _a(int n, int n2) {
        _c = n;
        _d = n2;
        _e = n + n2;
    }

    public static void _a() {
        _f = null;
    }

    public static void _b() {
        _f = ytsw._d();
    }

    private static void _c() {
        ResourceLocation resourceLocation = new ResourceLocation("gloomycore:sky/config.properties");
        Properties properties = ytsw._a(resourceLocation);
        if (properties != null) {
            try {
                _a = ytsw._a(Integer.parseInt(properties.getProperty("skyColor", "0"), 16));
                _b = ytsw._a(Integer.parseInt(properties.getProperty("fogColor", "0"), 16));
            }
            catch (NumberFormatException numberFormatException) {
                gloomyfolken.bundle.common.core.pidb._b("Can not parse color", numberFormatException, new String[0]);
            }
        }
    }

    private static float[] _a(int n) {
        return new float[]{(float)(n >> 16) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f};
    }

    private static dwwj[] _d() {
        Logger.fine("Reading custom sky config...", new Object[0]);
        ArrayList<dwwj> arrayList = new ArrayList<dwwj>();
        String string = "/assets/gloomycore/sky/world0/";
        List<String> list = srxe._a(string);
        for (String string2 : list) {
            dwwj dwwj2;
            ResourceLocation resourceLocation;
            Properties properties;
            if (!string2.endsWith(".properties") || (properties = ytsw._a(resourceLocation = uyvo._a(string2))) == null || !(dwwj2 = new dwwj(properties))._a(string2)) continue;
            dwwj2._a();
            arrayList.add(dwwj2);
        }
        Collections.sort(arrayList);
        return arrayList.toArray(new dwwj[arrayList.size()]);
    }

    private static Properties _a(ResourceLocation resourceLocation) {
        try {
            htyg htyg2 = Minecraft._E()._S()._a(resourceLocation);
            InputStream inputStream = htyg2._a();
            if (inputStream == null) {
                return null;
            }
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public static void _a(World world, float f, float f2) {
        if (_f == null) {
            return;
        }
        long l = world.getWorldTime();
        int n = (int)(l % (long)_e);
        ofxs.pidb pidb2 = new ofxs.pidb(f2);
        MinecraftForge.EVENT_BUS.post(pidb2);
        ResourceLocation resourceLocation = null;
        float f3 = 0.0f;
        for (int i = 0; i < _f.length; ++i) {
            dwwj dwwj2 = _f[i];
            Float f4 = pidb2._a.get(dwwj2._e);
            if (f4 == null || !(f4.floatValue() > 0.0f) || !dwwj2._a(n) || !fmib._a(dwwj2._c)) continue;
            dwwj2._a(n, f, f4.floatValue());
            if (!dwwj2._d || !(f4.floatValue() > f3)) continue;
            resourceLocation = dwwj2._c;
            f3 = f4.floatValue();
        }
        pidb._a(resourceLocation);
        MinecraftForge.EVENT_BUS.post(new ofxs.kjui());
        ytsw._a(f2);
    }

    public static boolean _a(World world) {
        if (_f == null) {
            return false;
        }
        return _f.length > 0;
    }

    private static void _a(float f) {
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f - f);
    }

    static {
        ytsw._a(12000, 12000);
    }
}

