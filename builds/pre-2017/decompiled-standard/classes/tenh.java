/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.jgro;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.effects.client.main.zwaw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/GhostShader;", "Lgloomyfolken/mods/effects/client/main/Shader;", "()V", "dirtColor", "Lnet/minecraft/util/ResourceLocation;", "getDirtColor", "()Lnet/minecraft/util/ResourceLocation;", "dirtTexture", "getDirtTexture", "flareApplyShader", "getFlareApplyShader", "()Lgloomyfolken/mods/effects/client/main/Shader;", "applyToScreen", "", "power", "", "minecraft"})
public final class tenh
extends jxtc {
    @NotNull
    private static final jxtc _d;
    @NotNull
    private static final ResourceLocation _e;
    @NotNull
    private static final ResourceLocation _f;
    public static final tenh _c;

    @NotNull
    public final jxtc _h() {
        return _d;
    }

    @NotNull
    public final ResourceLocation _i() {
        return _e;
    }

    @NotNull
    public final ResourceLocation _j() {
        return _f;
    }

    @JvmStatic
    public static final void _a(final float f) {
        jgro jgro2 = fmgg._a._a(2);
        if (jgro2 == null) {
            return;
        }
        final jgro jgro3 = jgro2;
        _c._e();
        _c._a("resolution", (float)zwaw._b(), (float)zwaw._d());
        _c._a("lensTex", 2);
        hsmn._e();
        jgro3._a(kjui._a);
        zwaw._b(new Function0<Unit>(){

            @Override
            public /* synthetic */ Object invoke() {
                this._a();
                return Unit.INSTANCE;
            }

            public final void _a() {
                _c._h()._e();
                _c._h()._a("resolution", (float)zwaw._b(), (float)zwaw._d());
                _c._h()._a("sceneTex", 0);
                _c._h()._a("lensTex", 2);
                _c._h()._a("dirtTex", 3);
                _c._h()._a("power", f);
                zwaw._z()._b(0);
                jgro3._j()._c()._b(2);
                GL13.glActiveTexture(33987);
                xpzm._E()._h._a(_c._j());
                GL13.glActiveTexture(33984);
                hsmn._c();
            }
        });
        hsmn._f();
        GL20.glUseProgram(0);
    }

    private tenh() {
        super("effects", "ghostgen");
        _c = this;
        _d = new jxtc("effects", "lens_flare");
        _e = new ResourceLocation("effects", "textures/lens_color.dds");
        _f = new ResourceLocation("effects", "textures/lens_dirt_1.dds");
        fmib._a(_e, _f);
    }

    static {
        new tenh();
    }
}

