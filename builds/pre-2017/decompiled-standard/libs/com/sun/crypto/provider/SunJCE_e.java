/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;

abstract class SunJCE_e {
    SunJCE_e() {
    }

    abstract int a();

    abstract void a(Key var1) throws InvalidKeyException;

    abstract void a(Key var1, AlgorithmParameterSpec var2) throws InvalidKeyException, InvalidAlgorithmParameterException;

    abstract void a(byte[] var1, int var2, int var3, byte[] var4, int var5) throws IllegalBlockSizeException;

    abstract void b(byte[] var1, int var2, int var3, byte[] var4, int var5) throws IllegalBlockSizeException;
}

