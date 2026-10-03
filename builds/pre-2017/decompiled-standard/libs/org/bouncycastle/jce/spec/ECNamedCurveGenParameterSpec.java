/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;

public class ECNamedCurveGenParameterSpec
implements AlgorithmParameterSpec {
    private String name;

    public ECNamedCurveGenParameterSpec(String string) {
        this.name = string;
    }

    public String getName() {
        return this.name;
    }
}

