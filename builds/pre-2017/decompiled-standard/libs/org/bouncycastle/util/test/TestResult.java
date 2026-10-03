/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util.test;

public interface TestResult {
    public boolean isSuccessful();

    public Throwable getException();

    public String toString();
}

