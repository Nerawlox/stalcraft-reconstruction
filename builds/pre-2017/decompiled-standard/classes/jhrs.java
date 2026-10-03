/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.jxtc;
import java.util.function.Supplier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/BlurShader;", "Lgloomyfolken/mods/effects/client/main/Shader;", "kernelSize", "", "(I)V", "getKernelSize", "()I", "minecraft"})
public final class jhrs
extends jxtc {
    private final int _c;

    public final int _h() {
        return this._c;
    }

    public jhrs(final int n) {
        super(1._a, new Supplier<String>(){

            @Override
            public /* synthetic */ Object get() {
                return this._a();
            }

            @NotNull
            public final String _a() {
                return dxcm._a(n);
            }
        }, "blur_" + n);
        this._c = n;
    }
}

