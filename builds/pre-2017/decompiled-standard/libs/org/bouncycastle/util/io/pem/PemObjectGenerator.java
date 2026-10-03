/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util.io.pem;

import org.bouncycastle.util.io.pem.PemGenerationException;
import org.bouncycastle.util.io.pem.PemObject;

public interface PemObjectGenerator {
    public PemObject generate() throws PemGenerationException;
}

