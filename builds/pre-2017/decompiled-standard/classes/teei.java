/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.entity.qlgf;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.amww;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/core/client/render/ThrowTrajectoryRenderer;", "", "()V", "MAX_SIMULATION_TICKS", "", "shader", "Lgloomyfolken/mods/effects/client/main/Shader;", "renderTrajectory", "", "world", "Lnet/minecraft/world/World;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "simulateThrowable", "Lgloomyfolken/mods/core/client/render/ThrowTrajectoryRenderer$ThrowableSimulation;", "throwableSetup", "Lgloomyfolken/mods/core/entity/ThrowSimulationParams;", "Companion", "ThrowableSimulation", "minecraft"})
public final class teei {
    private final int _c = 200;
    private final jxtc _d = new jxtc("stalker", "throw_traj");
    @JvmField
    @NotNull
    public static final teei _a;
    public static final kjui _b;

    @NotNull
    public final pidb _a(@NotNull ozlu ozlu2, @NotNull qlgf qlgf2) {
        ofbx ofbx2;
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        Intrinsics.checkParameterIsNotNull(qlgf2, "throwableSetup");
        ArrayList<ofbx> arrayList = new ArrayList<ofbx>();
        boolean bl = false;
        ofbx ofbx3 = VecExtensionsKt.vec3(qlgf2._b());
        ofbx ofbx4 = ofbx2 = VecExtensionsKt.vec3(qlgf2._c());
        Intrinsics.checkExpressionValueIsNotNull(ofbx4, "currentPos");
        ofbx ofbx5 = VecExtensionsKt.vec3(ofbx4);
        arrayList.add(VecExtensionsKt.vec3(ofbx2));
        int n = 0;
        int n2 = this._c - 1;
        if (n <= n2) {
            while (true) {
                ofbx ofbx6 = ofbx3;
                Intrinsics.checkExpressionValueIsNotNull(ofbx6, "currentSpeed");
                VecExtensionsKt.addl(ofbx2, ofbx6);
                VecExtensionsKt.mull(ofbx3, qlgf2._d());
                VecExtensionsKt.addl(ofbx3, qlgf2._a());
                ofbx ofbx7 = ofbx5;
                Intrinsics.checkExpressionValueIsNotNull(ofbx7, "prevPos");
                hank hank2 = ozlu2.func_72831_a(VecExtensionsKt.vec3(ofbx7), VecExtensionsKt.vec3(ofbx2), false, true);
                if (hank2 != null && Intrinsics.areEqual((Object)hank2._c, (Object)amww._a)) {
                    bl = true;
                    arrayList.add(hank2._h);
                    break;
                }
                arrayList.add(VecExtensionsKt.vec3(ofbx2));
                VecExtensionsKt.set(ofbx5, ofbx2);
                if (n == n2) break;
                ++n;
            }
        }
        return new pidb((List<? extends ofbx>)arrayList, bl);
    }

    public final void _a(@NotNull ozlu ozlu2, @NotNull EntityPlayer entityPlayer) {
        block15: {
            block14: {
                Intrinsics.checkParameterIsNotNull(ozlu2, "world");
                Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
                if (ClientProxy.hideThrowMarker.enabled) break block14;
                gloomyfolken.mods.core.entity.jxtc jxtc2 = gloomyfolken.mods.core.entity.jxtc._a._a(entityPlayer);
                if (jxtc2 == null) {
                    Intrinsics.throwNpe();
                }
                if (jxtc2._m() > 0) break block15;
            }
            return;
        }
        EntityLivingBase entityLivingBase = xpzm._E()._u;
        double d = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * (double)xpzm._E()._p._d;
        double d2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)xpzm._E()._p._d;
        double d3 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * (double)xpzm._E()._p._d;
        gloomyfolken.mods.core.entity.jxtc jxtc3 = gloomyfolken.mods.core.entity.jxtc._a._a(entityPlayer);
        if (jxtc3 == null) {
            Intrinsics.throwNpe();
        }
        pidb pidb2 = this._a(ozlu2, jxtc3._l());
        ArrayList arrayList = new ArrayList();
        ofbx ofbx2 = null;
        GL11.glTranslated(-d, -d2, -d3);
        GL11.glDisable(3553);
        GL11.glDisable(2884);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        GL11.glDisable(3008);
        GL11.glDepthMask(false);
        this._d._e();
        boolean bl = false;
        if (pidb2._a().size() >= 2) {
            GL11.glColor4d(0.0, 1.0, 0.0, 1.0);
            GL11.glColor4d(0.25, 1.0, 0.1, 0.0);
            GL11.glBegin(7);
            int n = 0;
            for (ofbx ofbx3 : pidb2._a()) {
                if (Intrinsics.areEqual(CollectionsKt.last(pidb2._a()), ofbx3)) {
                    if (pidb2._b()) {
                        ofbx2 = ofbx3;
                        bl = true;
                        GL11.glVertex3d(VecExtensionsKt.getX(ofbx3), VecExtensionsKt.getY(ofbx3), VecExtensionsKt.getZ(ofbx3));
                        GL11.glVertex3d(VecExtensionsKt.getX(ofbx3), VecExtensionsKt.getY(ofbx3), VecExtensionsKt.getZ(ofbx3));
                        GL11.glVertex3d(VecExtensionsKt.getX(ofbx3), VecExtensionsKt.getY(ofbx3), VecExtensionsKt.getZ(ofbx3));
                        GL11.glVertex3d(VecExtensionsKt.getX(ofbx3), VecExtensionsKt.getY(ofbx3), VecExtensionsKt.getZ(ofbx3));
                        GL11.glEnd();
                    }
                } else {
                    ofbx ofbx4 = pidb2._a().get(n + 1);
                    ofbx ofbx5 = VecExtensionsKt.subVector(ofbx4, ofbx3);
                    ofbx ofbx6 = VecExtensionsKt.vec3(0.0, -1.0, 0.0);
                    double d4 = 0.1;
                    ofbx ofbx7 = VecExtensionsKt.mul(VecExtensionsKt.normalized(ofbx5)._c(ofbx6), d4);
                    double d5 = 0.0;
                    if (n == 0) {
                        d5 = 1.0;
                    }
                    GL11.glTexCoord2d(d5, 0.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(ofbx3) + VecExtensionsKt.getX(ofbx7) * 0.5, VecExtensionsKt.getY(ofbx3), VecExtensionsKt.getZ(ofbx3) + VecExtensionsKt.getZ(ofbx7) * 0.5);
                    GL11.glTexCoord2d(d5, 1.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(ofbx3) - VecExtensionsKt.getX(ofbx7) * 0.5, VecExtensionsKt.getY(ofbx3), VecExtensionsKt.getZ(ofbx3) - VecExtensionsKt.getZ(ofbx7) * 0.5);
                    GL11.glTexCoord2d(0.0, 1.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(ofbx4) - VecExtensionsKt.getX(ofbx7) * 0.5, VecExtensionsKt.getY(ofbx4), VecExtensionsKt.getZ(ofbx4) - VecExtensionsKt.getZ(ofbx7) * 0.5);
                    GL11.glTexCoord2d(0.0, 0.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(ofbx4) + VecExtensionsKt.getX(ofbx7) * 0.5, VecExtensionsKt.getY(ofbx4), VecExtensionsKt.getZ(ofbx4) + VecExtensionsKt.getZ(ofbx7) * 0.5);
                    GL11.glTexCoord2d(d5, 0.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(ofbx3), VecExtensionsKt.getY(ofbx3) - d4 * 0.5, VecExtensionsKt.getZ(ofbx3));
                    GL11.glTexCoord2d(d5, 1.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(ofbx3), VecExtensionsKt.getY(ofbx3) + d4 * 0.5, VecExtensionsKt.getZ(ofbx3));
                    GL11.glTexCoord2d(0.0, 1.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(ofbx4), VecExtensionsKt.getY(ofbx4) + d4 * 0.5, VecExtensionsKt.getZ(ofbx4));
                    GL11.glTexCoord2d(0.0, 0.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(ofbx4), VecExtensionsKt.getY(ofbx4) - d4 * 0.5, VecExtensionsKt.getZ(ofbx4));
                }
                ++n;
            }
            if (!bl) {
                GL11.glEnd();
            }
        }
        if (pidb2._b()) {
            VecExtensionsKt.set(tfsl.throwHintPos, CollectionsKt.last(pidb2._a()));
        }
        GL20.glUseProgram(0);
        GL11.glDepthMask(true);
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
        GL11.glEnable(3553);
        GL11.glTranslated(d, d2, d3);
    }

    static {
        _b = new kjui(null);
        _a = new teei();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/core/client/render/ThrowTrajectoryRenderer$ThrowableSimulation;", "", "positions", "", "Lnet/minecraft/util/Vec3;", "simulationFinished", "", "(Ljava/util/List;Z)V", "getPositions", "()Ljava/util/List;", "getSimulationFinished", "()Z", "minecraft"})
    public static final class pidb {
        @NotNull
        private final List<ofbx> _a;
        private final boolean _b;

        @NotNull
        public final List<ofbx> _a() {
            return this._a;
        }

        public final boolean _b() {
            return this._b;
        }

        public pidb(@NotNull List<? extends ofbx> list2, boolean bl) {
            Intrinsics.checkParameterIsNotNull(list2, "positions");
            this._a = list2;
            this._b = bl;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/core/client/render/ThrowTrajectoryRenderer$Companion;", "", "()V", "instance", "Lgloomyfolken/mods/core/client/render/ThrowTrajectoryRenderer;", "minecraft"})
    public static final class kjui {
        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

