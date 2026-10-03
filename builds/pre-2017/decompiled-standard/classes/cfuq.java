/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.settings.eidj;
import org.lwjgl.input.Keyboard;

public class cfuq
extends cfum {
    protected boolean _a = true;
    protected eidj _b;
    protected int _c;
    protected List<eidj> _d = Lists.newArrayList();

    private cfuq() {
    }

    public static cfuq _a() {
        return new cfuq();
    }

    public cfuq _a(eidj eidj2) {
        this._b = eidj2;
        return this;
    }

    public cfuq _a(int n) {
        this._c = n;
        return this;
    }

    public cfuq _a(eidj ... eidjArray) {
        for (eidj eidj2 : eidjArray) {
            this._d.add(eidj2);
        }
        return this;
    }

    public boolean _b(eidj eidj2) {
        boolean bl = true;
        for (eidj eidj3 : this._d) {
            if (Keyboard.isKeyDown(eidj3._d)) continue;
            bl = false;
        }
        if (eidj2 != null && bl) {
            if (this._b != null) {
                return this._b == eidj2;
            }
            return this._c == eidj2._d;
        }
        return false;
    }

    public cfuq _b() {
        this._a = true;
        return this;
    }

    public cfuq _c() {
        this._a = false;
        return this;
    }

    @Override
    public ywts _a(dzyj dzyj2) {
        this._i = new ukhf.kjui(dzyj2){

            @Override
            public void _a(eidj eidj2) {
                if (!cfuq.this._a && cfuq.this._b(eidj2)) {
                    cfuq.this._a(cfuq.this, this);
                }
            }

            @Override
            public void _b(eidj eidj2) {
                if (cfuq.this._a && cfuq.this._b(eidj2)) {
                    cfuq.this._a(cfuq.this, this);
                }
            }
        };
        return this._i;
    }
}

