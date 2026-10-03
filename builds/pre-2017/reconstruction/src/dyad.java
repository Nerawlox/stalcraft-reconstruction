/*
 * Decompiled with CFR 0.152.
 */
import paulscode.sound.SoundSystem;

public class dyad
implements Runnable {
    public final /* synthetic */ jzqf _a;

    public dyad(jzqf jzqf2) {
        this._a = jzqf2;
    }

    @Override
    public void run() {
        jzqf._a(this._a, new SoundSystem());
        jzqf._a(this._a, true);
    }
}

