/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.patcher;

import com.google.common.hash.Hashing;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import cpw.mods.fml.repackage.com.nothome.delta.Delta;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenDiffSet {
    private static final List<String> RESERVED_NAMES = Arrays.asList("CON", "PRN", "AUX", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9");

    public static void main(String[] stringArray) throws IOException {
        String string = stringArray[0];
        String string2 = stringArray[1];
        String string3 = stringArray[2];
        String string4 = stringArray[3];
        String string5 = stringArray[4];
        Logger.getLogger("GENDIFF").log(Level.INFO, String.format("Creating patches at %s for %s from %s", string4, string, string2));
        Delta delta = new Delta();
        FMLDeobfuscatingRemapper fMLDeobfuscatingRemapper = FMLDeobfuscatingRemapper.INSTANCE;
        fMLDeobfuscatingRemapper.setupLoadOnly(string3, false);
        JarFile jarFile = new JarFile(string);
        boolean bl = string5.equalsIgnoreCase("true");
        File file = new File(string4);
        file.mkdirs();
        Iterator<String> iterator2 = fMLDeobfuscatingRemapper.getObfedClasses().iterator();
        while (iterator2.hasNext()) {
            String string6;
            String string7 = string6 = iterator2.next();
            String string8 = string6;
            if (RESERVED_NAMES.contains(string6.toUpperCase(Locale.ENGLISH))) {
                string7 = "_" + string6;
            }
            File file2 = new File(string2, string7.replace('/', File.separatorChar) + ".class");
            string8 = string8 + ".class";
            if (!file2.exists()) continue;
            String string9 = string6.replace('/', '.');
            String string10 = fMLDeobfuscatingRemapper.map(string6).replace('/', '.');
            JarEntry jarEntry = jarFile.getJarEntry(string8);
            byte[] byArray = jarEntry != null ? ByteStreams.toByteArray(jarFile.getInputStream(jarEntry)) : new byte[]{};
            byte[] byArray2 = Files.toByteArray(file2);
            byte[] byArray3 = delta.compute(byArray, byArray2);
            ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput(byArray3.length + 50);
            byteArrayDataOutput.writeUTF(string6);
            byteArrayDataOutput.writeUTF(string9);
            byteArrayDataOutput.writeUTF(string10);
            byteArrayDataOutput.writeBoolean(jarEntry != null);
            if (jarEntry != null) {
                byteArrayDataOutput.writeInt(Hashing.adler32().hashBytes(byArray).asInt());
            }
            byteArrayDataOutput.writeInt(byArray3.length);
            byteArrayDataOutput.write(byArray3);
            File file3 = new File(string4, string10 + ".binpatch");
            file3.getParentFile().mkdirs();
            Files.write(byteArrayDataOutput.toByteArray(), file3);
            Logger.getLogger("GENDIFF").info(String.format("Wrote patch for %s (%s) at %s", string6, string10, file3.getAbsolutePath()));
            if (!bl) continue;
            file2.delete();
            Logger.getLogger("GENDIFF").info(String.format("  Deleted target: %s", file2.toString()));
        }
        jarFile.close();
    }
}

