/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class dyir {
    public ArrayList _a = new ArrayList();
    public boolean _b;

    public synchronized boolean _a() {
        return this._b;
    }

    public synchronized void _b() {
        this._b = false;
    }

    public synchronized List _c() {
        return Collections.unmodifiableList(this._a);
    }

    public synchronized void _a(String string, InetAddress inetAddress) {
        String string2 = scql._a(string);
        String string3 = scql._b(string);
        if (string3 == null) {
            return;
        }
        string3 = inetAddress.getHostAddress() + ":" + string3;
        boolean bl = false;
        for (ohgi ohgi2 : this._a) {
            if (!ohgi2._b().equals(string3)) continue;
            ohgi2._c();
            bl = true;
            break;
        }
        if (!bl) {
            this._a.add(new ohgi(string2, string3));
            this._b = true;
        }
    }
}

