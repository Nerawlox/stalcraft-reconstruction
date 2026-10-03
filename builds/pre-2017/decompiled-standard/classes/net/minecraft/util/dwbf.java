/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class dwbf {
    public String _a;

    public dwbf(String string) {
        this._a = string;
    }

    public String _a(String string) {
        try {
            String string2 = this._a + string;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(string2.getBytes(), 0, string2.length());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
    }
}

