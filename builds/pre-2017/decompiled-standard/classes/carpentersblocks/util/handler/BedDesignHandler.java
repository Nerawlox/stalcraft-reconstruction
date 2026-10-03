/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.util.ModLogger;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.util.ResourceLocation;

public class BedDesignHandler {
    public static int maxNum = 256;
    public static boolean[] hasDesign = new boolean[maxNum];
    public static boolean[] hasPillow = new boolean[maxNum];
    public static boolean[] hasBlanket = new boolean[maxNum];
    public static ResourceLocation[] resource_blanket = new ResourceLocation[maxNum];

    public static boolean init(FMLPreInitializationEvent fMLPreInitializationEvent) {
        try {
            ZipFile zipFile = new ZipFile(fMLPreInitializationEvent.getSourceFile());
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            int n = 0;
            while (enumeration.hasMoreElements()) {
                ZipEntry zipEntry = enumeration.nextElement();
                if (!zipEntry.getName().contains("/bed/design_")) continue;
                int n2 = zipEntry.getName().indexOf("/bed/design_") + 12;
                int n3 = zipEntry.getName().indexOf("/", n2);
                int n4 = Integer.parseInt(zipEntry.getName().substring(n2, n3));
                if (n4 <= maxNum - 1 && n4 >= 1) {
                    if (zipEntry.isDirectory()) {
                        BedDesignHandler.hasDesign[n4] = true;
                        ++n;
                    }
                    if (zipEntry.getName().endsWith("blanket.png")) {
                        BedDesignHandler.hasBlanket[n4] = true;
                        BedDesignHandler.resource_blanket[n4] = new ResourceLocation("carpentersblocks", "textures/blocks/bed/design_" + n4 + "/blanket.png");
                    }
                    if (!zipEntry.getName().endsWith("pillow.png")) continue;
                    BedDesignHandler.hasPillow[n4] = true;
                    continue;
                }
                ModLogger.log(Level.WARNING, "Encountered out of range bed design " + zipEntry.getName() + ". This file will be ignored.");
            }
            if (n > 0) {
                ModLogger.log(Level.INFO, "Successfully loaded " + n + " bed design" + (n > 1 ? "s." : "."));
            }
            zipFile.close();
        }
        catch (Exception exception) {
            ModLogger.log(Level.WARNING, "Encountered a problem while initializing bed designs.");
        }
        return true;
    }

    public static int getNext(int n) {
        for (int i = ++n; i < maxNum; ++i) {
            if (!hasDesign[i]) continue;
            return i;
        }
        return 0;
    }

    public static int getPrev(int n) {
        if (n == 0) {
            n = maxNum;
        }
        for (int i = n - 1; i > 0; --i) {
            if (!hasDesign[i]) continue;
            return i;
        }
        return 0;
    }
}

