/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.util.Vector;

public class CertificateRequest {
    private short[] certificateTypes;
    private Vector certificateAuthorities;

    public CertificateRequest(short[] sArray, Vector vector) {
        this.certificateTypes = sArray;
        this.certificateAuthorities = vector;
    }

    public short[] getCertificateTypes() {
        return this.certificateTypes;
    }

    public Vector getCertificateAuthorities() {
        return this.certificateAuthorities;
    }
}

