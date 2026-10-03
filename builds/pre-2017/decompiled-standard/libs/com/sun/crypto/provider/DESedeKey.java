/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.DESKeyGenerator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.SecretKey;

class DESedeKey
implements SecretKey {
    static final long serialVersionUID = 2463986565756745178L;
    private byte[] key;

    DESedeKey(byte[] byArray) throws InvalidKeyException {
        this(byArray, 0);
    }

    DESedeKey(byte[] byArray, int n) throws InvalidKeyException {
        if (byArray == null || byArray.length - n < 24) {
            throw new InvalidKeyException("Wrong key size");
        }
        this.key = new byte[24];
        DESKeyGenerator.a(byArray, n);
        DESKeyGenerator.a(byArray, n + 8);
        DESKeyGenerator.a(byArray, n + 16);
        System.arraycopy(byArray, n, this.key, 0, 24);
    }

    public byte[] getEncoded() {
        return (byte[])this.key.clone();
    }

    public String getAlgorithm() {
        return "DESede";
    }

    public String getFormat() {
        return "RAW";
    }

    public int hashCode() {
        int n = 0;
        int n2 = 1;
        while (n2 < this.key.length) {
            n += this.key[n2] * n2;
            ++n2;
        }
        return n ^= "desede".hashCode();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SecretKey)) {
            return false;
        }
        String string = ((SecretKey)object).getAlgorithm();
        if (!string.equalsIgnoreCase("DESede") && !string.equalsIgnoreCase("TripleDES")) {
            return false;
        }
        byte[] byArray = ((SecretKey)object).getEncoded();
        boolean bl = Arrays.equals(this.key, byArray);
        Arrays.fill(byArray, (byte)0);
        return bl;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.key = (byte[])this.key.clone();
    }

    protected void finalize() {
        if (this.key != null) {
            Arrays.fill(this.key, (byte)0);
            this.key = null;
        }
    }
}

