/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import net.minecraft.network.packet.Packet44UpdateAttributes;

public class apzo {
    public final String _a;
    public final double _b;
    public final Collection _c;
    public final /* synthetic */ Packet44UpdateAttributes _d;

    public apzo(Packet44UpdateAttributes packet44UpdateAttributes, String string, double d, Collection collection) {
        this._d = packet44UpdateAttributes;
        this._a = string;
        this._b = d;
        this._c = collection;
    }

    public String _a() {
        return this._a;
    }

    public double _b() {
        return this._b;
    }

    public Collection _c() {
        return this._c;
    }
}

