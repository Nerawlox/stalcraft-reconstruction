/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.bundle.common.core;

public enum tupg {
    _a("\u041e\u0434\u0438\u043d\u043e\u0447\u043a\u0438", "\u041e\u0434\u0438\u043d\u043e\u0447\u043a\u0430", ""),
    _b("\u0421\u0442\u0430\u043b\u043a\u0435\u0440\u044b", "\u0421\u0442\u0430\u043b\u043a\u0435\u0440", "(C) "){

        @Override
        public boolean _a(tupg tupg2) {
            return tupg2 == _c;
        }
    }
    ,
    _c("\u0411\u0430\u043d\u0434\u0438\u0442\u044b", "\u0411\u0430\u043d\u0434\u0438\u0442", "(\u0411) "){

        @Override
        public boolean _a(tupg tupg2) {
            return tupg2 == _b;
        }
    };

    public final String _d;
    public final String _e;
    public final String _f;

    private tupg(String string2, String string3, String string4) {
        this._d = string2;
        this._e = string3;
        this._f = string4;
    }

    public boolean _a(tupg tupg2) {
        return false;
    }
}

