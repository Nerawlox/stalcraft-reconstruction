/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;

class WTauNafPreCompInfo
implements PreCompInfo {
    private ECPoint.F2m[] preComp = null;

    WTauNafPreCompInfo(ECPoint.F2m[] f2mArray) {
        this.preComp = f2mArray;
    }

    protected ECPoint.F2m[] getPreComp() {
        return this.preComp;
    }
}

