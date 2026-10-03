/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.asm;

import codechicken.core.asm.MCPDeobfuscationTransformer;
import codechicken.lib.asm.ObfMapping;
import java.io.DataInputStream;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ClassOverrider {
    public static byte[] overrideBytes(String string, byte[] byArray, ObfMapping obfMapping, File file) {
        if (!obfMapping.isClass(string)) {
            return byArray;
        }
        System.out.println("Overriding bytes " + string + " at " + file);
        if (file == null) {
            return byArray;
        }
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry zipEntry = zipFile.getEntry(obfMapping.s_owner + ".class");
            if (zipEntry == null) {
                zipFile.close();
                if (ObfMapping.obfuscated) {
                    System.err.println(string + " not found in " + file.getName());
                } else {
                    String string2 = MCPDeobfuscationTransformer.unmap(obfMapping.s_owner);
                    if (string2 != null && !string2.equals(obfMapping.s_owner)) {
                        ObfMapping obfMapping2 = new ObfMapping(string2);
                        obfMapping2.s_owner = string2;
                        byte[] byArray2 = ClassOverrider.overrideBytes(string2.replace('/', '.'), byArray, obfMapping2, file);
                        return MCPDeobfuscationTransformer.instance().transform(string2, null, byArray2);
                    }
                }
            } else {
                DataInputStream dataInputStream = new DataInputStream(zipFile.getInputStream(zipEntry));
                byArray = new byte[(int)zipEntry.getSize()];
                dataInputStream.readFully(byArray);
                zipFile.close();
                System.out.println(string + " was overriden from " + file.getName());
            }
        }
        catch (Exception exception) {
            throw new RuntimeException("Error overriding " + string + " from " + file.getName(), exception);
        }
        return byArray;
    }
}

