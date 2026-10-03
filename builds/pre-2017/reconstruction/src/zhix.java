/*
 * Decompiled with CFR 0.152.
 */
public abstract class zhix
implements sctg {
    public int _h = -1;

    @Override
    public int getGlTextureId() {
        if (this._h == -1) {
            this._h = bsfn._a();
        }
        return this._h;
    }
}

