/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.encoders.Base64Encoder;
import org.bouncycastle.util.encoders.Encoder;

public class Base64 {
    private static final Encoder encoder = new Base64Encoder();

    public static byte[] encode(byte[] byArray) {
        int n = (byArray.length + 2) / 3 * 4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n);
        try {
            encoder.encode(byArray, 0, byArray.length, byteArrayOutputStream);
        }
        catch (IOException iOException) {
            throw new RuntimeException("exception encoding base64 string: " + iOException);
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
        int n = byArray.length / 4 * 3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n);
        try {
            encoder.decode(byArray, 0, byArray.length, byteArrayOutputStream);
        }
        catch (IOException iOException) {
            throw new RuntimeException("exception decoding base64 string: " + iOException);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] decode(String string) {
        int n = string.length() / 4 * 3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n);
        try {
            encoder.decode(string, byteArrayOutputStream);
        }
        catch (IOException iOException) {
            throw new RuntimeException("exception decoding base64 string: " + iOException);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int decode(String string, OutputStream outputStream) throws IOException {
        return encoder.decode(string, outputStream);
    }
}

