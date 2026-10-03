/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.GuiScreen;

public class iyhq
extends cfum {
    protected GuiScreen _a;
    protected Class<? extends GuiScreen> _b;
    protected boolean _c;

    private iyhq() {
    }

    public static iyhq _a() {
        return new iyhq();
    }

    public iyhq _a(GuiScreen guiScreen) {
        this._a = guiScreen;
        return this;
    }

    public iyhq _a(Class<? extends GuiScreen> clazz) {
        this._b = clazz;
        return this;
    }

    public iyhq _b() {
        this._c = false;
        return this;
    }

    public iyhq _c() {
        this._c = true;
        return this;
    }

    public GuiScreen _d() {
        return this._a;
    }

    public Class<? extends GuiScreen> _e() {
        return this._a != null ? this._a.getClass() : this._b;
    }

    @Override
    public ywts _a(dzyj dzyj2) {
        this._i = new svcw.kjui(dzyj2){

            @Override
            public void _a(GuiScreen guiScreen) {
                if (!iyhq.this._c && guiScreen != null) {
                    if (iyhq.this._b != null && iyhq.this._b.isInstance(guiScreen)) {
                        iyhq.this._a(iyhq.this, this);
                    } else if (iyhq.this._a != null && iyhq.this._a == guiScreen) {
                        iyhq.this._a(iyhq.this, this);
                    }
                }
            }

            @Override
            public void _b(GuiScreen guiScreen) {
                if (iyhq.this._c && guiScreen != null) {
                    if (iyhq.this._b != null && iyhq.this._b.isInstance(guiScreen)) {
                        iyhq.this._a(iyhq.this, this);
                    } else if (iyhq.this._a != null && iyhq.this._a == guiScreen) {
                        iyhq.this._a(iyhq.this, this);
                    }
                }
            }
        };
        return this._i;
    }
}

