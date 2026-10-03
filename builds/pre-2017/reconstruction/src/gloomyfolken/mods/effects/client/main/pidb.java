/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.tupg;
import gloomyfolken.mods.effects.client.mcsa.jxtc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;

public class pidb {
    private static boolean _a = true;
    private static boolean _b = false;
    private static boolean _c = !Minecraft._b;
    private static anxd _d = anxd._c;
    private static File _e = new File(new File("."), "gloomyoptions_new.txt");
    private static ResourceLocation _f;

    public static void _a(ResourceLocation resourceLocation) {
        _f = resourceLocation;
    }

    public static ResourceLocation _a() {
        return _f;
    }

    public static void _a(iekw iekw2) {
        if (eidj._a != null) {
            eidj._a._e.add(iekw2);
        }
    }

    public static void _a(xqwz xqwz2) {
        if (eidj._a != null) {
            eidj._a._f.add(xqwz2);
        }
    }

    public static jxtc _a(String string) {
        try {
            return (jxtc)((Object)AdvancedModelLoader.loadModel(string));
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static void _a(rplk rplk2) {
        if (eidj._a == null) {
            throw new RuntimeException("Trying to register IIconList before @Init stage!");
        }
        if (eidj._a._m) {
            throw new RuntimeException("Trying to register IIconList after @Init stage!");
        }
        eidj._a._l.add(rplk2);
    }

    public static boolean _b() {
        return _a;
    }

    public static void _a(boolean bl) {
        _a = bl;
        pidb._g();
    }

    public static anxd _c() {
        return _d;
    }

    public static void _a(anxd anxd2) {
        _d = anxd2;
        pidb._g();
    }

    public static boolean _d() {
        return _b;
    }

    public static void _b(boolean bl) {
        _b = bl;
        qmdg._a._k();
        pidb._g();
    }

    public static boolean _e() {
        return _c;
    }

    public static void _c(boolean bl) {
        _c = bl;
        tupg._a._a(!bl);
        pidb._g();
    }

    public static boolean _f() {
        return uyvo._a;
    }

    public static void _d(boolean bl) {
        uyvo._a = bl;
        pidb._g();
    }

    public static void _g() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(_e));
            printWriter.println("opengl3:" + _c);
            printWriter.println("multithreaded_loading:" + _b);
            printWriter.println("memory_mapping:" + uyvo._a);
            printWriter.println("mapping:" + _a);
            printWriter.println("default_filtering:" + _d.name());
            printWriter.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void _h() {
        try {
            if (!_e.exists()) {
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(_e));
            String string = "";
            uyvo._a = true;
            while ((string = bufferedReader.readLine()) != null) {
                String[] stringArray = string.split(":");
                if (stringArray[0].equals("opengl3")) {
                    _c = stringArray[1].equals("true");
                }
                if (stringArray[0].equals("multithreaded_loading")) {
                    _b = stringArray[1].equals("true");
                }
                if (stringArray[0].equals("use_memory_mapping")) {
                    uyvo._a = stringArray[1].equals("true");
                }
                if (stringArray[0].equals("default_filtering")) {
                    _d = anxd.valueOf(stringArray[1]);
                }
                if (!stringArray[0].equals("mapping")) continue;
                _a = stringArray[1].equals("true");
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    static {
        pidb._h();
    }
}

