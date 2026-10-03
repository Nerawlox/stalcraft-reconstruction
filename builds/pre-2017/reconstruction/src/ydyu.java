/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import net.minecraft.client.audio.SoundPool;
import net.minecraft.util.ResourceLocation;

public class ydyu
extends URLConnection {
    public final ResourceLocation _a;
    public final /* synthetic */ SoundPool _b;

    public ydyu(SoundPool soundPool, URL uRL) {
        this._b = soundPool;
        super(uRL);
        this._a = new ResourceLocation(uRL.getPath());
    }

    @Override
    public void connect() {
    }

    @Override
    public InputStream getInputStream() {
        return SoundPool._a(this._b)._a(this._a)._a();
    }

    public /* synthetic */ ydyu(SoundPool soundPool, URL uRL, bryy bryy2) {
        this(soundPool, uRL);
    }
}

