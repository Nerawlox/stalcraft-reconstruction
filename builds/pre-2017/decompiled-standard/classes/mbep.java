/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileNotFoundException;

public class mbep
extends FileNotFoundException {
    public mbep(File file, String string) {
        super(String.format("'%s' in ResourcePack '%s'", string, file));
    }
}

