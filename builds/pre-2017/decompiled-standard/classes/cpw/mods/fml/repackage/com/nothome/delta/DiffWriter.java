/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.repackage.com.nothome.delta;

import java.io.Closeable;
import java.io.IOException;

public interface DiffWriter
extends Closeable {
    public void addCopy(long var1, int var3) throws IOException;

    public void addData(byte var1) throws IOException;

    public void flush() throws IOException;

    @Override
    public void close() throws IOException;
}

