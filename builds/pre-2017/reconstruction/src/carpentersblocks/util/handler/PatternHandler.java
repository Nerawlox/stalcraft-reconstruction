/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.util.ModLogger;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class PatternHandler {
    public static int maxNum = 256;
    public static boolean[] hasPattern = new boolean[maxNum];

    public static boolean init(FMLPreInitializationEvent fMLPreInitializationEvent) {
        try {
            int n = 0;
            if (fMLPreInitializationEvent.getSourceFile().isDirectory()) {
                List list = PatternHandler.getFiles(fMLPreInitializationEvent.getSourceFile(), ".png");
                for (File file : list) {
                    int n2;
                    String string = file.getPath().replace(File.separatorChar, '/');
                    if (!string.contains("/pattern/pattern_")) continue;
                    int n3 = string.indexOf("/pattern/pattern_") + 17;
                    int n4 = Integer.parseInt(string.substring(n3, n2 = string.indexOf(".png")));
                    if (n4 <= maxNum - 1 && n4 >= 1) {
                        PatternHandler.hasPattern[n4] = true;
                        ++n;
                        continue;
                    }
                    ModLogger.log(Level.WARNING, "Encountered out of range chisel pattern " + string + ". This file will be ignored.");
                }
            } else {
                ZipFile zipFile = new ZipFile(fMLPreInitializationEvent.getSourceFile());
                Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
                while (enumeration.hasMoreElements()) {
                    ZipEntry zipEntry = enumeration.nextElement();
                    if (!zipEntry.getName().contains("/pattern/pattern_") || !zipEntry.getName().endsWith(".png")) continue;
                    int n5 = zipEntry.getName().indexOf("/pattern/pattern_") + 17;
                    int n6 = zipEntry.getName().indexOf(".png");
                    int n7 = Integer.parseInt(zipEntry.getName().substring(n5, n6));
                    if (n7 <= maxNum - 1 && n7 >= 1) {
                        PatternHandler.hasPattern[n7] = true;
                        ++n;
                        continue;
                    }
                    ModLogger.log(Level.WARNING, "Encountered out of range chisel pattern " + zipEntry.getName() + ". This file will be ignored.");
                }
                zipFile.close();
            }
            if (n > 0) {
                ModLogger.log(Level.INFO, "Successfully loaded " + n + " chisel pattern" + (n > 1 ? "s." : "."));
            }
        }
        catch (Exception exception) {
            ModLogger.log(Level.WARNING, "Encountered a problem while initializing pattern icons.");
            exception.printStackTrace();
        }
        return true;
    }

    private static List getFiles(File file, String string) throws IOException {
        ArrayList<File> arrayList = new ArrayList<File>();
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    arrayList.addAll(PatternHandler.getFiles(file2, string));
                    continue;
                }
                if (!file2.getName().endsWith(string)) continue;
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    public static int getNext(int n) {
        for (int i = n + 1; i < maxNum; ++i) {
            if (!hasPattern[i]) continue;
            return i;
        }
        return 0;
    }

    public static int getPrev(int n) {
        if (n == 0) {
            n = maxNum;
        }
        for (int i = n - 1; i > 0; --i) {
            if (!hasPattern[i]) continue;
            return i;
        }
        return 0;
    }
}

