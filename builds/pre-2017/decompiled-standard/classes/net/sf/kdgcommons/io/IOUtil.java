/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

public class IOUtil {
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            return 0L;
        }
        long l = 0L;
        int n = 0;
        byte[] byArray = new byte[8192];
        while ((n = inputStream.read(byArray)) >= 0) {
            outputStream.write(byArray, 0, n);
            l += (long)n;
        }
        return l;
    }

    public static InputStream openFile(File file) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            inputStream = new BufferedInputStream(inputStream);
            if (file.getName().endsWith(".gz")) {
                inputStream = new GZIPInputStream(inputStream);
            }
            return inputStream;
        }
        catch (IOException iOException) {
            IOUtil.closeQuietly(inputStream);
            throw iOException;
        }
    }

    public static InputStream openFile(String string) throws IOException {
        return IOUtil.openFile(new File(string));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static File createTempFile(String string, long l) throws IOException {
        File file = File.createTempFile(string, null);
        file.deleteOnExit();
        if (l == 0L) {
            return file;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.setLength(l);
        }
        catch (Throwable throwable) {
            IOUtil.closeQuietly(randomAccessFile);
            throw throwable;
        }
        IOUtil.closeQuietly(randomAccessFile);
        return file;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static File createTempFile(InputStream inputStream, String string) throws IOException {
        File file = IOUtil.createTempFile(string, 0L);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            IOUtil.copy(inputStream, fileOutputStream);
        }
        catch (Throwable throwable) {
            IOUtil.closeQuietly(fileOutputStream);
            throw throwable;
        }
        IOUtil.closeQuietly(fileOutputStream);
        return file;
    }

    public static int readFully(InputStream inputStream, byte[] byArray) throws IOException {
        int n = 0;
        int n2 = 0;
        for (int i = byArray.length; i > 0 && (n2 = inputStream.read(byArray, n, i)) >= 0; i -= n2) {
            n += n2;
        }
        return n;
    }
}

