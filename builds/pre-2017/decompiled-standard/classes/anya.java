/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.effects.client.main.zwaw;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.lwjgl.opengl.GL20;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/FxaaShader;", "Lgloomyfolken/mods/effects/client/main/Shader;", "()V", "applyFxaaToScreen", "", "minecraft"})
public final class anya
extends jxtc {
    public static final anya _c;

    @JvmStatic
    public static final void _h() {
        if (zwaw._p() && zwaw._n()) {
            _c._e();
            _c._a("resolution", (float)zwaw._b(), (float)zwaw._d());
            _c._a("screenTexture", 0);
            hsmn._e();
            zwaw._b(kjui._a);
            hsmn._f();
            GL20.glUseProgram(0);
        }
    }

    private anya() {
        super("effects", "fxaa");
        _c = this;
    }

    static {
        new anya();
    }
}

