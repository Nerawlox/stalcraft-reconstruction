/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class xqmv {
    private static final String[] _a = new String[]{"scala.", "kotlin.", "org.objectweb.", "com.google.", "com.sun.", "org.apache.", "joptsimple.", "org.lwjgl.", "ch.epfl.", "org.bouncycastle.", "argo.", "net.java.games.", "oracle.", "javafx.", "sun.", "com.oracle.", "jdk.", "java.", "javax.", "org.omg.", "org.ietf.", "netscape.sequrity.", "org.jdesktop.", "com.mysql.", "com.bulletphysics.", "LZMA.", "com.jcraft.", "paulscode.sound.", "cz.advel.", "org.gjt.", "akka.", "com.ibm.", "gnu.trove."};

    public void _a() {
        boolean bl = System.getProperty("obf.gloomyfolken.preloadClasses", "false").equals("true");
        boolean bl2 = bl || System.getProperty("obf.gloomyfolken.exitAfterStart", "false").equals("true");
        try {
            if (bl) {
                int n = this._b();
                int n2 = 0;
                dwuw dwuw2 = new dwuw();
                kkhn._a(dwuw2, false);
                block4: for (String string : dwuw2._a) {
                    for (String string2 : _a) {
                        if (string.startsWith(string2)) continue block4;
                    }
                    string = FMLDeobfuscatingRemapper.INSTANCE.map(string).replace('/', '.');
                    System.out.println(string);
                    try {
                        Class.forName(string);
                    }
                    catch (Throwable throwable) {
                        throwable.printStackTrace();
                        ++n2;
                    }
                }
                System.out.println("Loaded " + (this._b() - n) + " classes.");
                System.out.println(n2 + " classes was failed to load.");
            }
            if (bl2) {
                Method method = System.class.getMethod("exit", Integer.TYPE);
                method.invoke(null, 47);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private int _b() {
        try {
            Field field = ClassLoader.class.getDeclaredField("classes");
            field.setAccessible(true);
            Vector vector = (Vector)field.get(this.getClass().getClassLoader());
            return vector.size();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return 0;
        }
    }

    private static List<File> _a(File file, String string) throws IOException {
        ArrayList<File> arrayList = new ArrayList<File>();
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    arrayList.addAll(xqmv._a(file2, string));
                    continue;
                }
                if (!file2.getName().endsWith(string)) continue;
                arrayList.add(file2);
            }
        }
        return arrayList;
    }
}

