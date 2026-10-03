/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.config;

import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;

public interface ProviderConfiguration {
    public ECParameterSpec getEcImplicitlyCa();

    public DHParameterSpec getDHDefaultParameters();
}

