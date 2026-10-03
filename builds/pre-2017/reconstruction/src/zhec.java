/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.EntityRenderer;

public class zhec
implements Callable {
    public final /* synthetic */ htou _a;
    public final /* synthetic */ EntityRenderer _b;

    public zhec(EntityRenderer entityRenderer, htou htou2) {
        this._b = entityRenderer;
        this._a = htou2;
    }

    public String _a() {
        return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", this._a._a(), this._a._b(), EntityRenderer.getRendererMinecraft((EntityRenderer)this._b)._n, EntityRenderer.getRendererMinecraft((EntityRenderer)this._b)._o, this._a._e());
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

