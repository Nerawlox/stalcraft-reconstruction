/*
 * Decompiled with CFR 0.152.
 */
public class ejdy
extends ncyh {
    public ejdy(tvlv tvlv2, float f, ejcz ejcz2) {
        super(tvlv2, 0.0f, f, ejcz2);
        this.isDistortionParticle = true;
    }

    @Override
    public boolean shouldRenderInPass(int n) {
        return n == 2;
    }

    @Override
    public int getBrightness(int n, int n2, int n3) {
        return 0xF000F0;
    }
}

