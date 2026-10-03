/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileFilter;

public final class lpdf
implements FileFilter {
    @Override
    public boolean accept(File file) {
        boolean bl = file.isFile() && file.getName().endsWith(".zip");
        boolean bl2 = file.isDirectory() && new File(file, "pack.mcmeta").isFile();
        return bl || bl2;
    }
}

