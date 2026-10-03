/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.texture.TextureManager;

public class scti
implements Callable {
    public final /* synthetic */ sctg _a;
    public final /* synthetic */ TextureManager _b;

    public scti(TextureManager textureManager, sctg sctg2) {
        this._b = textureManager;
        this._a = sctg2;
    }

    public String _a() {
        return this._a.getClass().getName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

