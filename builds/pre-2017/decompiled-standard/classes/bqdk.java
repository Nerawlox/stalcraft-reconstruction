/*
 * Decompiled with CFR 0.152.
 */
public class bqdk
extends iuww {
    public static final bqdk _a = new bqdk();

    public bqdk() {
        super("\u0414\u0440\u0443\u0437\u044c\u044f", "friends");
    }

    @Override
    public String getInfoText(bqdo bqdo2) {
        return String.format("\u041d\u043e\u0432\u044b\u0439 \u0437\u0430\u043f\u0440\u043e\u0441 \u0432 \u0434\u0440\u0443\u0437\u044c\u044f \u043e\u0442 %s", bqdo2._d()._j("Author"));
    }

    @Override
    public iuww.kjui getViewType(bqdo bqdo2) {
        return iuww.kjui._a;
    }

    @Override
    public void onAction(bqdo bqdo2, boolean bl) {
        new eikj(bqdo2._d()._j("Author"), bl).sendClientToBackend();
    }
}

