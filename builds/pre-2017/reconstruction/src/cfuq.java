/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class cfuq
extends cfum {
    protected boolean _a = true;
    protected KeyBinding _b;
    protected int _c;
    protected List<KeyBinding> _d = Lists.newArrayList();

    private cfuq() {
    }

    public static cfuq _a() {
        return new cfuq();
    }

    public cfuq _a(KeyBinding keyBinding) {
        this._b = keyBinding;
        return this;
    }

    public cfuq _a(int n) {
        this._c = n;
        return this;
    }

    public cfuq _a(KeyBinding ... keyBindingArray) {
        for (KeyBinding keyBinding : keyBindingArray) {
            this._d.add(keyBinding);
        }
        return this;
    }

    public boolean _b(KeyBinding keyBinding) {
        boolean bl = true;
        for (KeyBinding keyBinding2 : this._d) {
            if (Keyboard.isKeyDown(keyBinding2._d)) continue;
            bl = false;
        }
        if (keyBinding != null && bl) {
            if (this._b != null) {
                return this._b == keyBinding;
            }
            return this._c == keyBinding._d;
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
            public void _a(KeyBinding keyBinding) {
                if (!cfuq.this._a && cfuq.this._b(keyBinding)) {
                    cfuq.this._a(cfuq.this, this);
                }
            }

            @Override
            public void _b(KeyBinding keyBinding) {
                if (cfuq.this._a && cfuq.this._b(keyBinding)) {
                    cfuq.this._a(cfuq.this, this);
                }
            }
        };
        return this._i;
    }
}

