/*
 * Decompiled with CFR 0.152.
 */
package api.player.forge;

import api.player.forge.RenderPlayerAPIForgePlugin;
import java.io.DataInputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.launchwrapper.IClassTransformer;

public class RenderPlayerAPIForgeTransformer
implements IClassTransformer {
    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (RenderPlayerAPIForgePlugin.location == null || string.equals(string2) || string.contains(".")) {
            return byArray;
        }
        try {
            byte[] byArray2 = RenderPlayerAPIForgeTransformer.GetClassBytes(string, RenderPlayerAPIForgePlugin.location);
            return byArray2 != null ? byArray2 : byArray;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Can not replace class '" + string2 + "' (obfusacted '" + string + "')", iOException);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static byte[] GetClassBytes(String string, File file) throws IOException {
        ZipFile zipFile = null;
        FilterInputStream filterInputStream = null;
        try {
            zipFile = new ZipFile(file);
            ZipEntry zipEntry = zipFile.getEntry(string + ".class");
            if (zipEntry == null) {
                byte[] byArray = null;
                return byArray;
            }
            filterInputStream = new DataInputStream(zipFile.getInputStream(zipEntry));
            byte[] byArray = new byte[(int)zipEntry.getSize()];
            ((DataInputStream)filterInputStream).readFully(byArray);
            byte[] byArray2 = byArray;
            return byArray2;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Can not read from file '" + file.getAbsolutePath() + "'", iOException);
        }
        finally {
            if (filterInputStream != null) {
                filterInputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
        }
    }
}

