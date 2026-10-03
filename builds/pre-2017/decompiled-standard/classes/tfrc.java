/*
 * Decompiled with CFR 0.152.
 */
public class tfrc
extends Thread {
    public final /* synthetic */ jzwn _a;

    public tfrc(jzwn jzwn2) {
        this._a = jzwn2;
    }

    @Override
    public void run() {
        rqmi rqmi2 = new rqmi(jzwn._a(this._a)._P());
        try {
            jzwn._a(this._a, rqmi2._e()._a);
        }
        catch (twsl twsl2) {
            jzwn._b(this._a)._O()._c(twsl2.toString());
        }
    }
}

