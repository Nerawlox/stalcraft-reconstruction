/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import java.util.concurrent.TimeUnit;

public class qlgf
extends iuww {
    public qlgf() {
        super("\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435", "savepoint", TimeUnit.MINUTES.toMillis(1L));
    }

    @Override
    public String getInfoText(bqdo bqdo2) {
        qoac qoac2 = bqdo2._d();
        switch (qoac2._j("type")) {
            case "suggestion": {
                return String.format("\u0425\u043e\u0442\u0438\u0442\u0435 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c \u0442\u043e\u0447\u043a\u0443 \u0432\u043e\u0437\u0440\u043e\u0436\u0434\u0435\u043d\u0438\u044f \u043d\u0430 \u0431\u0430\u0437\u0435 \"%s\"?", qoac2._j("BaseName"));
            }
            case "set": {
                return String.format("\u0422\u0435\u043f\u0435\u0440\u044c \u0432\u044b \u0432\u043e\u0437\u0440\u043e\u0436\u0434\u0430\u0435\u0442\u0435\u0441\u044c \u043d\u0430 \u0431\u0430\u0437\u0435 \"%s\"", qoac2._j("BaseName"));
            }
        }
        return null;
    }

    @Override
    public iuww.kjui getViewType(bqdo bqdo2) {
        return bqdo2._d()._j("type").equals("suggestion") ? iuww.kjui._a : iuww.kjui._c;
    }

    @Override
    public void onAction(bqdo bqdo2, boolean bl) {
        qoac qoac2 = bqdo2._d();
        switch (qoac2._j("type")) {
            case "suggestion": {
                if (!bl) break;
                new loij(qoac2._f("x"), qoac2._f("y"), qoac2._f("z")).sendToServer();
            }
        }
    }
}

