/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.party;

public class eidj
extends iuww {
    public eidj() {
        super("\u041e\u0442\u0440\u044f\u0434", "party");
    }

    @Override
    public String getInfoText(bqdo bqdo2) {
        qoac qoac2 = bqdo2._d();
        switch (qoac2._j("type")) {
            case "invited": {
                return String.format("\u041d\u043e\u0432\u043e\u0435 \u043f\u0440\u0438\u0433\u043b\u0430\u0448\u0435\u043d\u0438\u0435 \u0432 \u043e\u0442\u0440\u044f\u0434 \u043e\u0442 \"%s\"", qoac2._j("Player"));
            }
            case "kicked": {
                return String.format("\u0412\u044b \u0431\u044b\u043b\u0438 \u0438\u0441\u043a\u043b\u044e\u0447\u0435\u043d\u044b \u0438\u0437 \u043e\u0442\u0440\u044f\u0434\u0430 \u0438\u0433\u0440\u043e\u043a\u0430 \"%s\"", qoac2._j("Player"));
            }
        }
        return null;
    }

    @Override
    public iuww.kjui getViewType(bqdo bqdo2) {
        return bqdo2._d()._j("type").equals("invited") ? iuww.kjui._a : iuww.kjui._c;
    }

    @Override
    public void onAction(bqdo bqdo2, boolean bl) {
        qoac qoac2 = bqdo2._d();
        switch (qoac2._j("type")) {
            case "invited": {
                if (!bl) break;
                ncul._b(new rord(qoac2._f("PartyId")));
            }
        }
    }
}

