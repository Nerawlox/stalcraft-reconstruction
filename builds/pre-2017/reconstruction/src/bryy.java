/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import net.minecraft.client.audio.SoundPool;

public class bryy
extends URLStreamHandler {
    public final /* synthetic */ SoundPool _a;

    public bryy(SoundPool soundPool) {
        this._a = soundPool;
    }

    @Override
    public URLConnection openConnection(URL uRL) {
        return new ydyu(this._a, uRL, null);
    }
}

