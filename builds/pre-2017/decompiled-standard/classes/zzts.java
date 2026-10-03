/*
 * Decompiled with CFR 0.152.
 */
public class zzts
extends plne {
    public qoac _a = new qoac("Features");

    public zzts(String string) {
        super(string);
    }

    @Override
    public void func_76184_a(qoac qoac2) {
        this._a = qoac2._m("Features");
    }

    @Override
    public void func_76187_b(qoac qoac2) {
        qoac2._a("Features", (huhy)this._a);
    }

    public void _a(qoac qoac2, int n, int n2) {
        String string = this._a(n, n2);
        qoac2._a(string);
        this._a._a(string, (huhy)qoac2);
    }

    public String _a(int n, int n2) {
        return "[" + n + "," + n2 + "]";
    }

    public qoac _a() {
        return this._a;
    }
}

