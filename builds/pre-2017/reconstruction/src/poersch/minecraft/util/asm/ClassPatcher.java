/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.asm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.launchwrapper.IClassTransformer;
import poersch.minecraft.util.asm.IClassPatcher;

public class ClassPatcher
implements IClassTransformer {
    private static HashMap<String, File> toOverwrite = new HashMap();
    private static HashMap<String, ArrayList<IClassPatcher>> toPatch = new HashMap();
    public static Logger logger = Logger.getLogger("PoerschCore");

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        File file = null;
        try {
            file = toOverwrite.remove(string);
        }
        catch (ClassCircularityError classCircularityError) {
            logger.log(Level.WARNING, "ClassCircularityError");
        }
        if (file != null) {
            byArray = this.overwriteClass(string, byArray, file);
        }
        ArrayList<IClassPatcher> arrayList = null;
        try {
            arrayList = toPatch.remove(string);
        }
        catch (ClassCircularityError classCircularityError) {
            logger.log(Level.WARNING, "ClassCircularityError");
        }
        if (arrayList != null) {
            for (IClassPatcher iClassPatcher : arrayList) {
                byArray = iClassPatcher.patchClass(string, byArray);
            }
        }
        return byArray;
    }

    private byte[] overwriteClass(String string, byte[] byArray, File file) {
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry zipEntry = zipFile.getEntry("patches/" + string.replace('.', '/') + ".class");
            if (zipEntry == null) {
                logger.log(Level.WARNING, "Class \"" + string + "\" not found in " + file.getName());
            } else {
                int n;
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                int n2 = (int)zipEntry.getSize();
                byArray = new byte[n2];
                for (int i = 0; i < n2; i += n) {
                    n = inputStream.read(byArray, i, n2 - i);
                    if (n > 0) continue;
                    throw new IOException();
                }
                inputStream.close();
                logger.log(Level.INFO, "Patched class: " + string);
            }
            zipFile.close();
        }
        catch (Exception exception) {
            logger.log(Level.SEVERE, "Error overwriting class \"" + string + "\" from " + file.getName(), exception);
        }
        return byArray;
    }

    public static void addPatcherFor(String string, IClassPatcher iClassPatcher) {
        ArrayList<IClassPatcher> arrayList = toPatch.get(string);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(iClassPatcher);
        toPatch.put(string, arrayList);
    }

    public static void addPatchesFrom(File file) {
        if (file == null) {
            return;
        }
        int n = 0;
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                String string = enumeration.nextElement().getName();
                if (!string.startsWith("patches/") || !string.endsWith(".class")) continue;
                toOverwrite.put(string.substring(8, string.length() - 6), file);
                ++n;
            }
            zipFile.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        logger.log(Level.INFO, "Found " + n + " patches in " + file.getName());
    }
}

