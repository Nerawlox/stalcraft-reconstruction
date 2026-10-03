/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.launchwrapper.Launch;

public class kkhn {
    public static void _a(dftb<String> dftb2, boolean bl) {
        String string = System.getProperty("java.class.path");
        ArrayList<String> arrayList = Lists.newArrayList(string.split(System.getProperty("path.separator")));
        HashSet<File> hashSet = new HashSet<File>();
        for (URL serializable : Launch.classLoader.getSources()) {
            try {
                hashSet.add(new File(serializable.toURI()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (!bl) {
            Iterator iterator2 = System.getProperty("java.home");
            File file = new File(iterator2 + File.separator + "lib");
            hashSet.remove(file);
        }
        for (File file : hashSet) {
            if (file != null && file.exists()) {
                System.out.println("Lib: " + file.getPath());
                kkhn._a(file, file, true, dftb2);
                continue;
            }
            System.out.println("File not found: " + file);
        }
    }

    private static boolean _a(File file, File file2, boolean bl, dftb<String> dftb2) {
        if (file2.isDirectory()) {
            for (File file3 : file2.listFiles()) {
                if (kkhn._a(file, file3, bl, dftb2)) continue;
                return false;
            }
        } else if ((file2.getName().toLowerCase().endsWith(".jar") || file2.getName().toLowerCase().endsWith(".zip")) && bl) {
            ZipFile zipFile = null;
            try {
                zipFile = new ZipFile(file2);
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (zipFile != null) {
                Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
                while (enumeration.hasMoreElements()) {
                    ZipEntry zipEntry = enumeration.nextElement();
                    String string = zipEntry.getName();
                    int n = string.lastIndexOf(".class");
                    if (n <= 0 || dftb2._a(string.substring(0, n).replace("/", "."))) continue;
                    return false;
                }
            }
        } else if (file2.getName().toLowerCase().endsWith(".class") && !dftb2._a(kkhn._a(file, file2))) {
            return false;
        }
        return true;
    }

    private static String _a(File file, File file2) {
        StringBuffer stringBuffer = new StringBuffer();
        String string = file2.getName();
        stringBuffer.append(string.substring(0, string.lastIndexOf(".class")));
        for (file2 = file2.getParentFile(); file2 != null && !file2.equals(file); file2 = file2.getParentFile()) {
            stringBuffer.insert(0, '.').insert(0, file2.getName());
        }
        return stringBuffer.toString();
    }
}

