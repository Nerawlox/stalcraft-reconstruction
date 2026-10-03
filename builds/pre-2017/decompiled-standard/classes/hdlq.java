/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.zwat;
import net.minecraft.util.zwaw;

public class hdlq
implements nemo {
    public static final hdlq _a = new hdlq();
    public StringBuffer _b = new StringBuffer();

    public void _a() {
        this._b.setLength(0);
    }

    public String _b() {
        return this._b.toString();
    }

    @Override
    public String func_70005_c_() {
        return "Rcon";
    }

    @Override
    public void func_70006_a(zwat zwat2) {
        this._b.append(zwat2.toString());
    }

    @Override
    public boolean func_70003_b(int n, String string) {
        return true;
    }

    @Override
    public zwaw func_82114_b() {
        return new zwaw(0, 0, 0);
    }

    @Override
    public ozlu func_130014_f_() {
        return dzfd._I().func_130014_f_();
    }
}

