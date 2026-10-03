/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;

class PBEKey
implements SecretKey {
    static final long serialVersionUID = -2234768909660948176L;
    private byte[] key;

    public PBEKey(PBEKeySpec pBEKeySpec) throws InvalidKeySpecException {
        char[] cArray = pBEKeySpec.getPassword();
        if (cArray == null) {
            cArray = new char[]{};
        }
        int n = 0;
        while (n < cArray.length) {
            if (cArray[n] < ' ' || cArray[n] > '~') {
                throw new InvalidKeySpecException("Password is not ASCII");
            }
            ++n;
        }
        this.key = new byte[cArray.length];
        int n2 = 0;
        while (n2 < cArray.length) {
            this.key[n2] = (byte)(cArray[n2] & 0x7F);
            ++n2;
        }
        Arrays.fill(cArray, ' ');
    }

    public byte[] getEncoded() {
        return (byte[])this.key.clone();
    }

    public String getAlgorithm() {
        return "PBEWithMD5AndDES";
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
        return n ^= this.getAlgorithm().toLowerCase().hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecretKey)) {
            return false;
        }
        SecretKey secretKey = (SecretKey)object;
        if (!secretKey.getAlgorithm().equalsIgnoreCase("PBEWithMD5AndDES")) {
            return false;
        }
        byte[] byArray = secretKey.getEncoded();
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

