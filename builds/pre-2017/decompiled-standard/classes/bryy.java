/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class bryy
extends URLStreamHandler {
    public final /* synthetic */ uiog _a;

    public bryy(uiog uiog2) {
        this._a = uiog2;
    }

    @Override
    public URLConnection openConnection(URL uRL) {
        return new ydyu(this._a, uRL, null);
    }
}

