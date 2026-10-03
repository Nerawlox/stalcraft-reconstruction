/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util.test;

import org.bouncycastle.util.test.TestResult;

public interface Test {
    public String getName();

    public TestResult perform();
}

