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
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
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
    public final pidb _a(@NotNull World world, @NotNull qlgf qlgf2) {
        Vec3 vec3;
        Intrinsics.checkParameterIsNotNull(world, "world");
        Intrinsics.checkParameterIsNotNull(qlgf2, "throwableSetup");
        ArrayList<Vec3> arrayList = new ArrayList<Vec3>();
        boolean bl = false;
        Vec3 vec32 = VecExtensionsKt.vec3(qlgf2._b());
        Vec3 vec33 = vec3 = VecExtensionsKt.vec3(qlgf2._c());
        Intrinsics.checkExpressionValueIsNotNull(vec33, "currentPos");
        Vec3 vec34 = VecExtensionsKt.vec3(vec33);
        arrayList.add(VecExtensionsKt.vec3(vec3));
        int n = 0;
        int n2 = this._c - 1;
        if (n <= n2) {
            while (true) {
                Vec3 vec35 = vec32;
                Intrinsics.checkExpressionValueIsNotNull(vec35, "currentSpeed");
                VecExtensionsKt.addl(vec3, vec35);
                VecExtensionsKt.mull(vec32, qlgf2._d());
                VecExtensionsKt.addl(vec32, qlgf2._a());
                Vec3 vec36 = vec34;
                Intrinsics.checkExpressionValueIsNotNull(vec36, "prevPos");
                MovingObjectPosition movingObjectPosition = world.func_72831_a(VecExtensionsKt.vec3(vec36), VecExtensionsKt.vec3(vec3), false, true);
                if (movingObjectPosition != null && Intrinsics.areEqual((Object)movingObjectPosition._c, (Object)EnumMovingObjectType._a)) {
                    bl = true;
                    arrayList.add(movingObjectPosition._h);
                    break;
                }
                arrayList.add(VecExtensionsKt.vec3(vec3));
                VecExtensionsKt.set(vec34, vec3);
                if (n == n2) break;
                ++n;
            }
        }
        return new pidb((List<? extends Vec3>)arrayList, bl);
    }

    public final void _a(@NotNull World world, @NotNull EntityPlayer entityPlayer) {
        block15: {
            block14: {
                Intrinsics.checkParameterIsNotNull(world, "world");
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
        EntityLivingBase entityLivingBase = Minecraft._E()._u;
        double d = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * (double)Minecraft._E()._p._d;
        double d2 = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * (double)Minecraft._E()._p._d;
        double d3 = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * (double)Minecraft._E()._p._d;
        gloomyfolken.mods.core.entity.jxtc jxtc3 = gloomyfolken.mods.core.entity.jxtc._a._a(entityPlayer);
        if (jxtc3 == null) {
            Intrinsics.throwNpe();
        }
        pidb pidb2 = this._a(world, jxtc3._l());
        ArrayList arrayList = new ArrayList();
        Vec3 vec3 = null;
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
            for (Vec3 vec32 : pidb2._a()) {
                if (Intrinsics.areEqual(CollectionsKt.last(pidb2._a()), vec32)) {
                    if (pidb2._b()) {
                        vec3 = vec32;
                        bl = true;
                        GL11.glVertex3d(VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec32));
                        GL11.glVertex3d(VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec32));
                        GL11.glVertex3d(VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec32));
                        GL11.glVertex3d(VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec32));
                        GL11.glEnd();
                    }
                } else {
                    Vec3 vec33 = pidb2._a().get(n + 1);
                    Vec3 vec34 = VecExtensionsKt.subVector(vec33, vec32);
                    Vec3 vec35 = VecExtensionsKt.vec3(0.0, -1.0, 0.0);
                    double d4 = 0.1;
                    Vec3 vec36 = VecExtensionsKt.mul(VecExtensionsKt.normalized(vec34)._c(vec35), d4);
                    double d5 = 0.0;
                    if (n == 0) {
                        d5 = 1.0;
                    }
                    GL11.glTexCoord2d(d5, 0.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(vec32) + VecExtensionsKt.getX(vec36) * 0.5, VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec32) + VecExtensionsKt.getZ(vec36) * 0.5);
                    GL11.glTexCoord2d(d5, 1.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(vec32) - VecExtensionsKt.getX(vec36) * 0.5, VecExtensionsKt.getY(vec32), VecExtensionsKt.getZ(vec32) - VecExtensionsKt.getZ(vec36) * 0.5);
                    GL11.glTexCoord2d(0.0, 1.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(vec33) - VecExtensionsKt.getX(vec36) * 0.5, VecExtensionsKt.getY(vec33), VecExtensionsKt.getZ(vec33) - VecExtensionsKt.getZ(vec36) * 0.5);
                    GL11.glTexCoord2d(0.0, 0.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(vec33) + VecExtensionsKt.getX(vec36) * 0.5, VecExtensionsKt.getY(vec33), VecExtensionsKt.getZ(vec33) + VecExtensionsKt.getZ(vec36) * 0.5);
                    GL11.glTexCoord2d(d5, 0.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec32) - d4 * 0.5, VecExtensionsKt.getZ(vec32));
                    GL11.glTexCoord2d(d5, 1.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(vec32), VecExtensionsKt.getY(vec32) + d4 * 0.5, VecExtensionsKt.getZ(vec32));
                    GL11.glTexCoord2d(0.0, 1.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(vec33), VecExtensionsKt.getY(vec33) + d4 * 0.5, VecExtensionsKt.getZ(vec33));
                    GL11.glTexCoord2d(0.0, 0.0);
                    GL11.glVertex3d(VecExtensionsKt.getX(vec33), VecExtensionsKt.getY(vec33) - d4 * 0.5, VecExtensionsKt.getZ(vec33));
                }
                ++n;
            }
            if (!bl) {
                GL11.glEnd();
            }
        }
        if (pidb2._b()) {
            VecExtensionsKt.set(EntityRenderer.throwHintPos, CollectionsKt.last(pidb2._a()));
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
        private final List<Vec3> _a;
        private final boolean _b;

        @NotNull
        public final List<Vec3> _a() {
            return this._a;
        }

        public final boolean _b() {
            return this._b;
        }

        public pidb(@NotNull List<? extends Vec3> list2, boolean bl) {
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

