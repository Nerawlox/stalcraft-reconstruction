/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.buffer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import net.sf.kdgcommons.io.IOUtil;
import net.sf.kdgcommons.lang.StringUtil;

public class BufferUtil {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static MappedByteBuffer map(File file, long l, long l2, FileChannel.MapMode mapMode) throws IOException {
        String string = mapMode.equals(FileChannel.MapMode.READ_ONLY) ? "r" : "rw";
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, string);
        try {
            MappedByteBuffer mappedByteBuffer = randomAccessFile.getChannel().map(mapMode, l, l2);
            return mappedByteBuffer;
        }
        finally {
            IOUtil.closeQuietly(randomAccessFile);
        }
    }

    public static String getUTF8String(ByteBuffer byteBuffer, int n, int n2) {
        byte[] byArray = new byte[n2];
        byteBuffer.position(n);
        byteBuffer.get(byArray, 0, n2);
        return StringUtil.fromUTF8(byArray);
    }

    public static char[] getChars(ByteBuffer byteBuffer, int n, int n2) {
        char[] cArray = new char[n2];
        byteBuffer.position(n);
        for (int i = 0; i < n2; ++i) {
            cArray[i] = byteBuffer.getChar();
        }
        return cArray;
    }
}

