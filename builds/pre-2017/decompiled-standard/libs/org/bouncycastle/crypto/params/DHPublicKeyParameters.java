/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.params.DHKeyParameters;
import org.bouncycastle.crypto.params.DHParameters;

public class DHPublicKeyParameters
extends DHKeyParameters {
    private BigInteger y;

    public DHPublicKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(false, dHParameters);
        this.y = bigInteger;
    }

    public BigInteger getY() {
        return this.y;
    }

    public int hashCode() {
        return this.y.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object object) {
        if (!(object instanceof DHPublicKeyParameters)) {
            return false;
        }
        DHPublicKeyParameters dHPublicKeyParameters = (DHPublicKeyParameters)object;
        return dHPublicKeyParameters.getY().equals(this.y) && super.equals(object);
    }
}

