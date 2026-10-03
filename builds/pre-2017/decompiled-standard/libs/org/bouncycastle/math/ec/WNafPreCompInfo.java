/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;

class WNafPreCompInfo
implements PreCompInfo {
    private ECPoint[] preComp = null;
    private ECPoint twiceP = null;

    WNafPreCompInfo() {
    }

    protected ECPoint[] getPreComp() {
        return this.preComp;
    }

    protected void setPreComp(ECPoint[] eCPointArray) {
        this.preComp = eCPointArray;
    }

    protected ECPoint getTwiceP() {
        return this.twiceP;
    }

    protected void setTwiceP(ECPoint eCPoint) {
        this.twiceP = eCPoint;
    }
}

