/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.repackage.com.nothome.delta;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface SeekableSource
extends Closeable {
    public void seek(long var1) throws IOException;

    public int read(ByteBuffer var1) throws IOException;
}

