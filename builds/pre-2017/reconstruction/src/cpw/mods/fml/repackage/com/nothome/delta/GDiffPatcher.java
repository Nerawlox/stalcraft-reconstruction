/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.repackage.com.nothome.delta;

import cpw.mods.fml.repackage.com.nothome.delta.ByteBufferSeekableSource;
import cpw.mods.fml.repackage.com.nothome.delta.PatchException;
import cpw.mods.fml.repackage.com.nothome.delta.RandomAccessFileSeekableSource;
import cpw.mods.fml.repackage.com.nothome.delta.SeekableSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class GDiffPatcher {
    private ByteBuffer buf = ByteBuffer.allocate(1024);
    private byte[] buf2 = this.buf.array();

    public void patch(File file, File file2, File file3) throws IOException {
        RandomAccessFileSeekableSource randomAccessFileSeekableSource = new RandomAccessFileSeekableSource(new RandomAccessFile(file, "r"));
        FileInputStream fileInputStream = new FileInputStream(file2);
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        try {
            this.patch(randomAccessFileSeekableSource, (InputStream)fileInputStream, (OutputStream)fileOutputStream);
        }
        catch (IOException iOException) {
            throw iOException;
        }
        finally {
            randomAccessFileSeekableSource.close();
            ((InputStream)fileInputStream).close();
            ((OutputStream)fileOutputStream).close();
        }
    }

    public void patch(byte[] byArray, InputStream inputStream, OutputStream outputStream) throws IOException {
        this.patch(new ByteBufferSeekableSource(byArray), inputStream, outputStream);
    }

    public byte[] patch(byte[] byArray, byte[] byArray2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.patch(byArray, (InputStream)new ByteArrayInputStream(byArray2), (OutputStream)byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void patch(SeekableSource seekableSource, InputStream inputStream, OutputStream outputStream) throws IOException {
        int n;
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        if (dataInputStream.readUnsignedByte() != 209 || dataInputStream.readUnsignedByte() != 255 || dataInputStream.readUnsignedByte() != 209 || dataInputStream.readUnsignedByte() != 255 || dataInputStream.readUnsignedByte() != 4) {
            throw new PatchException("magic string not found, aborting!");
        }
        block11: while ((n = dataInputStream.readUnsignedByte()) != 0) {
            if (n <= 246) {
                this.append(n, dataInputStream, dataOutputStream);
                continue;
            }
            switch (n) {
                case 247: {
                    int n2 = dataInputStream.readUnsignedShort();
                    this.append(n2, dataInputStream, dataOutputStream);
                    continue block11;
                }
                case 248: {
                    int n2 = dataInputStream.readInt();
                    this.append(n2, dataInputStream, dataOutputStream);
                    continue block11;
                }
                case 249: {
                    int n3 = dataInputStream.readUnsignedShort();
                    int n2 = dataInputStream.readUnsignedByte();
                    this.copy(n3, n2, seekableSource, dataOutputStream);
                    continue block11;
                }
                case 250: {
                    int n3 = dataInputStream.readUnsignedShort();
                    int n2 = dataInputStream.readUnsignedShort();
                    this.copy(n3, n2, seekableSource, dataOutputStream);
                    continue block11;
                }
                case 251: {
                    int n3 = dataInputStream.readUnsignedShort();
                    int n2 = dataInputStream.readInt();
                    this.copy(n3, n2, seekableSource, dataOutputStream);
                    continue block11;
                }
                case 252: {
                    int n3 = dataInputStream.readInt();
                    int n2 = dataInputStream.readUnsignedByte();
                    this.copy(n3, n2, seekableSource, dataOutputStream);
                    continue block11;
                }
                case 253: {
                    int n3 = dataInputStream.readInt();
                    int n2 = dataInputStream.readUnsignedShort();
                    this.copy(n3, n2, seekableSource, dataOutputStream);
                    continue block11;
                }
                case 254: {
                    int n3 = dataInputStream.readInt();
                    int n2 = dataInputStream.readInt();
                    this.copy(n3, n2, seekableSource, dataOutputStream);
                    continue block11;
                }
                case 255: {
                    long l = dataInputStream.readLong();
                    int n2 = dataInputStream.readInt();
                    this.copy(l, n2, seekableSource, dataOutputStream);
                    continue block11;
                }
            }
            throw new IllegalStateException("command " + n);
        }
        dataOutputStream.flush();
    }

    private void copy(long l, int n, SeekableSource seekableSource, OutputStream outputStream) throws IOException {
        seekableSource.seek(l);
        while (n > 0) {
            int n2 = Math.min(this.buf.capacity(), n);
            this.buf.clear().limit(n2);
            int n3 = seekableSource.read(this.buf);
            if (n3 == -1) {
                throw new EOFException("in copy " + l + " " + n);
            }
            outputStream.write(this.buf.array(), 0, n3);
            n -= n3;
        }
    }

    private void append(int n, InputStream inputStream, OutputStream outputStream) throws IOException {
        while (n > 0) {
            int n2 = Math.min(this.buf2.length, n);
            int n3 = inputStream.read(this.buf2, 0, n2);
            if (n3 == -1) {
                throw new EOFException("cannot read " + n);
            }
            outputStream.write(this.buf2, 0, n3);
            n -= n3;
        }
    }

    public static void main(String[] stringArray) {
        if (stringArray.length != 3) {
            System.err.println("usage GDiffPatch source patch output");
            System.err.println("aborting..");
            return;
        }
        try {
            File file = new File(stringArray[0]);
            File file2 = new File(stringArray[1]);
            File file3 = new File(stringArray[2]);
            if (file.length() > Integer.MAX_VALUE || file2.length() > Integer.MAX_VALUE) {
                System.err.println("source or patch is too large, max length is 2147483647");
                System.err.println("aborting..");
                return;
            }
            GDiffPatcher gDiffPatcher = new GDiffPatcher();
            gDiffPatcher.patch(file, file2, file3);
            System.out.println("finished patching file");
        }
        catch (Exception exception) {
            System.err.println("error while patching: " + exception);
        }
    }
}

