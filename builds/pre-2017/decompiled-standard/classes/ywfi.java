/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

public class ywfi
extends ArrayList {
    public ywfi() {
    }

    public ywfi(qoac qoac2) {
        this._a(qoac2);
    }

    public ozjk _a(cvzo cvzo2, cvzo cvzo3, int n) {
        if (n > 0 && n < this.size()) {
            ozjk ozjk2 = (ozjk)this.get(n);
            if (cvzo2._d == ozjk2._a()._d && (cvzo3 == null && !ozjk2._c() || ozjk2._c() && cvzo3 != null && ozjk2._b()._d == cvzo3._d) && cvzo2._b >= ozjk2._a()._b && (!ozjk2._c() || cvzo3._b >= ozjk2._b()._b)) {
                return ozjk2;
            }
            return null;
        }
        for (int i = 0; i < this.size(); ++i) {
            ozjk ozjk3 = (ozjk)this.get(i);
            if (cvzo2._d != ozjk3._a()._d || cvzo2._b < ozjk3._a()._b || (ozjk3._c() || cvzo3 != null) && (!ozjk3._c() || cvzo3 == null || ozjk3._b()._d != cvzo3._d || cvzo3._b < ozjk3._b()._b)) continue;
            return ozjk3;
        }
        return null;
    }

    public void _a(ozjk ozjk2) {
        for (int i = 0; i < this.size(); ++i) {
            ozjk ozjk3 = (ozjk)this.get(i);
            if (!ozjk2._a(ozjk3)) continue;
            if (ozjk2._b(ozjk3)) {
                this.set(i, ozjk2);
            }
            return;
        }
        this.add(ozjk2);
    }

    public void _a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte((byte)(this.size() & 0xFF));
        for (int i = 0; i < this.size(); ++i) {
            ozjk ozjk2 = (ozjk)this.get(i);
            cezg.func_73270_a(ozjk2._a(), dataOutputStream);
            cezg.func_73270_a(ozjk2._d(), dataOutputStream);
            cvzo cvzo2 = ozjk2._b();
            dataOutputStream.writeBoolean(cvzo2 != null);
            if (cvzo2 != null) {
                cezg.func_73270_a(cvzo2, dataOutputStream);
            }
            dataOutputStream.writeBoolean(ozjk2._f());
        }
    }

    public static ywfi _a(DataInputStream dataInputStream) {
        ywfi ywfi2 = new ywfi();
        int n = dataInputStream.readByte() & 0xFF;
        for (int i = 0; i < n; ++i) {
            cvzo cvzo2 = cezg.func_73276_c(dataInputStream);
            cvzo cvzo3 = cezg.func_73276_c(dataInputStream);
            cvzo cvzo4 = null;
            if (dataInputStream.readBoolean()) {
                cvzo4 = cezg.func_73276_c(dataInputStream);
            }
            boolean bl = dataInputStream.readBoolean();
            ozjk ozjk2 = new ozjk(cvzo2, cvzo4, cvzo3);
            if (bl) {
                ozjk2._g();
            }
            ywfi2.add(ozjk2);
        }
        return ywfi2;
    }

    public void _a(qoac qoac2) {
        bsyv bsyv2 = qoac2._n("Recipes");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            this.add(new ozjk(qoac3));
        }
    }

    public qoac _a() {
        qoac qoac2 = new qoac();
        bsyv bsyv2 = new bsyv("Recipes");
        for (int i = 0; i < this.size(); ++i) {
            ozjk ozjk2 = (ozjk)this.get(i);
            bsyv2._a(ozjk2._h());
        }
        qoac2._a("Recipes", bsyv2);
        return qoac2;
    }
}

