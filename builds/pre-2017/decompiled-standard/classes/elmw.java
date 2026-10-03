/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class elmw
extends plxv {
    public elmw(File file, String string, boolean bl) {
        super(file, string, bl);
    }

    @Override
    public bcgt func_75763_a(rrte rrte2) {
        File file = this._c();
        if (rrte2._m() != null) {
            File file2 = new File(file, rrte2._m());
            file2.mkdirs();
            return new nffs(file2);
        }
        return new nffs(file);
    }

    @Override
    public void func_75755_a(iyev iyev2, qoac qoac2) {
        iyev2._d(19133);
        super.func_75755_a(iyev2, qoac2);
    }

    @Override
    public void func_75759_a() {
        try {
            xcnz._a._b();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        suyl._a();
    }
}

