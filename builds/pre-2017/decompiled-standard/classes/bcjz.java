/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;
import net.minecraft.util.sajh;

public class bcjz
extends tycn {
    public double _d = 0.01;

    public bcjz() {
    }

    @Override
    public String _a() {
        return "Mineshaft";
    }

    public bcjz(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            if (!((String)entry.getKey()).equals("chance")) continue;
            this._d = sajh._a((String)entry.getValue(), this._d);
        }
    }

    @Override
    public boolean _a(int n, int n2) {
        return this._b.nextDouble() < this._d && this._b.nextInt(80) < Math.max(Math.abs(n), Math.abs(n2));
    }

    @Override
    public tycc _b(int n, int n2) {
        return new yfou(this._c, this._b, n, n2);
    }
}

