/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.util.ModLogger;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LanguageHandler {
    public static void init(FMLPreInitializationEvent fMLPreInitializationEvent) {
        try {
            ZipFile zipFile = new ZipFile(fMLPreInitializationEvent.getSourceFile());
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                ZipEntry zipEntry = enumeration.nextElement();
                if (!zipEntry.getName().endsWith(".lang")) continue;
                String string = zipEntry.getName().substring(zipEntry.getName().indexOf("/lang/") + 6, zipEntry.getName().indexOf(".lang"));
                LanguageRegistry.instance().loadLocalization("/" + zipEntry.getName(), string, false);
            }
            zipFile.close();
        }
        catch (Exception exception) {
            ModLogger.log(Level.WARNING, "Encountered a problem while loading language files.");
        }
    }
}

