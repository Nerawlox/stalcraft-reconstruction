/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.piet;

public class rrqs
extends piet {
    public final qoac _a;
    public final String _b;
    public final /* synthetic */ qokq _c;

    public rrqs(qokq qokq2, qoac qoac2) {
        this._c = qokq2;
        super(qoac2._f("Weight"));
        qoac qoac3 = qoac2._m("Properties");
        String string = qoac2._j("Type");
        if (string.equals("Minecart")) {
            if (qoac3 != null) {
                switch (qoac3._f("Type")) {
                    case 1: {
                        string = "MinecartChest";
                        break;
                    }
                    case 2: {
                        string = "MinecartFurnace";
                        break;
                    }
                    case 0: {
                        string = "MinecartRideable";
                    }
                }
            } else {
                string = "MinecartRideable";
            }
        }
        this._a = qoac3;
        this._b = string;
    }

    public rrqs(qokq qokq2, qoac qoac2, String string) {
        this._c = qokq2;
        super(1);
        if (string.equals("Minecart")) {
            if (qoac2 != null) {
                switch (qoac2._f("Type")) {
                    case 1: {
                        string = "MinecartChest";
                        break;
                    }
                    case 2: {
                        string = "MinecartFurnace";
                        break;
                    }
                    case 0: {
                        string = "MinecartRideable";
                    }
                }
            } else {
                string = "MinecartRideable";
            }
        }
        this._a = qoac2;
        this._b = string;
    }

    public qoac _a() {
        qoac qoac2 = new qoac();
        qoac2._a("Properties", this._a);
        qoac2._a("Type", this._b);
        qoac2._a("Weight", this.field_76292_a);
        return qoac2;
    }
}

