/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.encoders.Encoder;
import org.bouncycastle.util.encoders.HexEncoder;

public class Hex {
    private static final Encoder encoder = new HexEncoder();

    public static byte[] encode(byte[] byArray) {
        return Hex.encode(byArray, 0, byArray.length);
    }

    public static byte[] encode(byte[] byArray, int n, int n2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.encode(byArray, n, n2, byteArrayOutputStream);
        }
        catch (IOException iOException) {
            throw new RuntimeException("exception encoding Hex string: " + iOException);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int encode(byte[] byArray, OutputStream outputStream) throws IOException {
        return encoder.encode(byArray, 0, byArray.length, outputStream);
    }

    public static int encode(byte[] byArray, int n, int n2, OutputStream outputStream) throws IOException {
        return encoder.encode(byArray, n, n2, outputStream);
    }

    public static byte[] decode(byte[] byArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.decode(byArray, 0, byArray.length, byteArrayOutputStream);
        }
        catch (IOException iOException) {
            throw new RuntimeException("exception decoding Hex string: " + iOException);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] decode(String string) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.decode(string, byteArrayOutputStream);
        }
        catch (IOException iOException) {
            throw new RuntimeException("exception decoding Hex string: " + iOException);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int decode(String string, OutputStream outputStream) throws IOException {
        return encoder.decode(string, outputStream);
    }
}

