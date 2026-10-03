/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.qlgf;
import gloomyfolken.mods.effects.client.mcsa.ugqx;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.MinecraftForgeClient;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/anomaly/client/render/RenderTeleportBubble;", "Lnet/minecraft/client/renderer/tileentity/TileEntitySpecialRenderer;", "()V", "renderTileEntityAt", "", "tileentity", "Lnet/minecraft/tileentity/TileEntity;", "x", "", "y", "z", "frame", "", "Companion", "minecraft"})
public final class uyct
extends TileEntitySpecialRenderer {
    private static final Minecraft _b;
    private static final gloomyfolken.mods.effects.client.mcsa.kjui _c;
    public static final kjui _a;

    @Override
    public void renderTileEntityAt(@NotNull TileEntity tileEntity, double d, double d2, double d3, float f) {
        Intrinsics.checkParameterIsNotNull(tileEntity, "tileentity");
        ivab ivab2 = (ivab)tileEntity;
        if (uyct._a._b()._i()) {
            ezfc._a();
            Vec3 vec3 = VecExtensionsKt.vec3(d + 0.5, d2 + 0.5, d3 + 0.5);
            ezfc._a(VecExtensionsKt.getXf(vec3), VecExtensionsKt.getYf(vec3), VecExtensionsKt.getZf(vec3));
            float f2 = (float)(System.currentTimeMillis() % (long)1000000) * 0.004f;
            double d4 = ivab2._i()._b() + 1.0;
            float f3 = (float)(d4 + (double)McExtensionsKt.cos(f2) * McExtensionsKt.cos((double)f2 * 4.0) * 0.015);
            ezfc._a(f2 * 20.0f, 0.0f, 0.0f, 1.0f);
            ezfc._a(90.0f, 1.0f, 0.0f, 0.0f);
            ezfc._b(f3, f3, f3);
            Iterable iterable = uyct._a._b()._a().getMeshes();
            for (Object t : iterable) {
                qlgf qlgf2 = (qlgf)t;
                ezfa.kjui kjui2 = new ezfa.kjui(f2){
                    final /* synthetic */ float _a;
                    {
                        this._a = f;
                    }

                    protected void render(float f) {
                        this.renderer._e._a("distortionsPass", MinecraftForgeClient.getRenderPass() > 1 ? 1.0f : 0.0f);
                        this.renderer._e._a("time", this._a);
                        this.renderer._e._a("back", Intrinsics.areEqual(this.renderer._c._l, "in") ? 1.0f : 0.0f);
                        super.render(f);
                    }

                    public void load(ugqx.kjui kjui2, cucv cucv2) {
                        super.load(kjui2, cucv2);
                    }
                };
                ugqx.kjui kjui3 = ((ugqx)uyct._a._b()._u_())._a(qlgf2._l);
                Intrinsics.checkExpressionValueIsNotNull(kjui3, "bubbleRenderer.get().getMeshRenderer(it.name)");
                kjui2.load(kjui3, null);
                ezfa._a._a(kjui2);
            }
            ezfc._b();
        }
    }

    static {
        _a = new kjui(null);
        _b = Minecraft._E();
        _c = new iefv("/assets/effects/models/unit_sphere.mcsa")._a("teleport_bubble");
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/anomaly/client/render/RenderTeleportBubble$Companion;", "", "()V", "bubbleRenderer", "Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;", "kotlin.jvm.PlatformType", "getBubbleRenderer", "()Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;", "mc", "Lnet/minecraft/client/Minecraft;", "getMc", "()Lnet/minecraft/client/Minecraft;", "minecraft"})
    public static final class kjui {
        private final Minecraft _a() {
            return _b;
        }

        private final gloomyfolken.mods.effects.client.mcsa.kjui _b() {
            return _c;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

