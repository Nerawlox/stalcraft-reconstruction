/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.EntityRenderer;

public class cecj
implements Callable {
    public final /* synthetic */ EntityRenderer _a;

    public cecj(EntityRenderer entityRenderer) {
        this._a = entityRenderer;
    }

    public String _a() {
        return EntityRenderer.getRendererMinecraft((EntityRenderer)this._a)._B.getClass().getCanonicalName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

