/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.stalker.smplayer.zwat;
import gloomyfolken.mods.weapon.trace.ezey;
import gloomyfolken.mods.weapon.trace.ugqx;
import gloomyfolken.mods.weapon.trace.zwaw;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingFactory;
import net.smart.render.ModelRotationRenderer;
import net.smart.render.SmartRenderModel;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003&'(B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0002H\u0017J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0002H\u0007J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0007R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderPlayer;", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderBiped;", "Lnet/minecraft/entity/player/EntityPlayer;", "()V", "indexToMeshName", "", "", "getIndexToMeshName", "()[Ljava/lang/String;", "[Ljava/lang/String;", "rotations", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderPlayer$SmartTraceRotation;", "getRotations", "()[Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderPlayer$SmartTraceRotation;", "[Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderPlayer$SmartTraceRotation;", "stateBits", "", "buildTraceResultInternal", "Lgloomyfolken/mods/weapon/trace/TraceResult;", "entity", "getRotationByName", "string", "read", "", "input", "Ljava/io/DataInput;", "readMeshEntry", "index", "setFromClientEntity", "setRotations", "mp", "Lnet/smart/render/SmartRenderModel;", "setupDelicateRotationProps", "write", "output", "Ljava/io/DataOutput;", "writeMeshEntry", "traceRotation", "Companion", "SmartTraceRotation", "TraceMeshPlayer", "minecraft"})
public final class jxtc
extends zwaw<EntityPlayer> {
    @NotNull
    private final String[] _c;
    @NotNull
    private final pidb[] _d;
    private int _e;
    private static final eidj _f;
    private static final gloomyfolken.mods.weapon.trace.kjui _g;
    public static final kjui _b;

    @NotNull
    public final String[] _h() {
        return this._c;
    }

    @NotNull
    public final pidb[] _i() {
        return this._d;
    }

    @Override
    public void _a(final @NotNull DataInput dataInput) {
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
        this._e = dataInput.readByte();
        final int n = 0;
        int n2 = ((Object[])this._d).length - 1;
        if (n <= n2) {
            while (true) {
                InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

                    @Override
                    public final void run() {
                    }
                });
                if (n == n2) break;
                ++n;
            }
        }
    }

    @Override
    public void _a(final @NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
        dataOutput.writeByte(this._e);
        InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

            @Override
            public final void run() {
                Object[] objectArray = this._i();
                for (int i = 0; i < objectArray.length; ++i) {
                    Object object = objectArray[i];
                    pidb pidb2 = (pidb)object;
                    this._a(pidb2, dataOutput);
                }
            }
        });
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public final void _a(@NotNull pidb pidb2, @NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(pidb2, "traceRotation");
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
        this._a(pidb2._d(), dataOutput);
        this._a(pidb2._e(), dataOutput);
        this._a(pidb2._f(), dataOutput);
        dataOutput.writeByte(pidb2._a());
        dataOutput.writeBoolean(pidb2._b());
        dataOutput.writeBoolean(pidb2._c());
    }

    @NotNull
    public final pidb _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "string");
        return this._d[ArraysKt.indexOf((Object[])this._c, string)];
    }

    @NotNull
    protected ugqx _a(final @NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "entity");
        InvokeSideOnly.frontend(!entityPlayer.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeFrontendOnly(){

            @Override
            public final void run() {
            }
        });
        jxtc._b._b()._a(this);
        jxtc._b._a()._a(jxtc._b._b());
        if ((_b._a(this._e) || _b._c(this._e) || _b._d(this._e) || _b._b(this._e)) && entityPlayer.field_70170_p.field_72995_K) {
            jxtc jxtc2 = this;
            float f = jxtc2._f();
            jxtc2._b(f + -1.0f);
        }
        jxtc._b._a()._a((float)entityPlayer.field_70165_t + this._e(), (float)entityPlayer.field_70163_u + this._f(), (float)entityPlayer.field_70161_v + this._g(), 0.0f, 0.9375f);
        return ugqx._a._a(jxtc._b._a());
    }

    @Override
    public /* synthetic */ ugqx _c(Entity entity) {
        return this._a((EntityPlayer)entity);
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    @NotNull
    public jxtc _b(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "entity");
        AbstractClientPlayer abstractClientPlayer = (AbstractClientPlayer)entityPlayer;
        tfvm tfvm2 = gqqu._b._a(entityPlayer);
        if (!(tfvm2 instanceof gloomyfolken.mods.stalker.smplayer.ezey)) {
            tfvm2 = null;
        }
        gloomyfolken.mods.stalker.smplayer.ezey ezey2 = (gloomyfolken.mods.stalker.smplayer.ezey)tfvm2;
        if (ezey2 == null) {
            throw (Throwable)new IllegalStateException("Default player renderer is unsupported for constructing state skeleton!");
        }
        gloomyfolken.mods.stalker.smplayer.ezey ezey3 = ezey2;
        SmartMoving smartMoving = SmartMovingFactory.getInstance(entityPlayer);
        ezey3._a(abstractClientPlayer, 0.0f, false);
        SmartMoving smartMoving2 = smartMoving;
        Intrinsics.checkExpressionValueIsNotNull(smartMoving2, "smart");
        this._e = _b._a(smartMoving2);
        SmartRenderModel smartRenderModel = ezey3._f();
        Intrinsics.checkExpressionValueIsNotNull(smartRenderModel, "renderer.renderModel");
        this._a(smartRenderModel);
        return this;
    }

    @Override
    public /* synthetic */ ezey _a(Entity entity) {
        return this._b((EntityPlayer)entity);
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public final void _a(@NotNull SmartRenderModel smartRenderModel) {
        Intrinsics.checkParameterIsNotNull(smartRenderModel, "mp");
        List<ModelRotationRenderer[]> list = CollectionsKt.listOf(new ModelRotationRenderer[]{smartRenderModel.bipedHead, smartRenderModel.bipedNeck, smartRenderModel.bipedOuter, smartRenderModel.bipedTorso, smartRenderModel.bipedBody, smartRenderModel.bipedBreast, smartRenderModel.bipedLeftShoulder, smartRenderModel.bipedRightShoulder, smartRenderModel.bipedLeftArm, smartRenderModel.bipedRightArm, smartRenderModel.bipedPelvic, smartRenderModel.bipedLeftLeg, smartRenderModel.bipedRightLeg});
        Iterable iterable = list;
        int n = 0;
        for (Object t : iterable) {
            int n2 = n++;
            ModelRotationRenderer modelRotationRenderer = (ModelRotationRenderer)t;
            int n3 = n2;
            pidb pidb2 = this._d[n3];
            ModelRotationRenderer modelRotationRenderer2 = modelRotationRenderer;
            Intrinsics.checkExpressionValueIsNotNull(modelRotationRenderer2, "it");
            pidb2._a(modelRotationRenderer2);
        }
    }

    public jxtc() {
        Object[] objectArray = new String[]{"head", "neck", "outer", "torso", "body", "breast", "left_shoulder", "right_shoulder", "left_arm", "right_arm", "pelvic", "left_leg", "right_leg"};
        jxtc jxtc2 = this;
        Object[] objectArray2 = objectArray;
        jxtc2._c = (String[])objectArray2;
        int n = ((Object[])this._c).length;
        jxtc2 = this;
        pidb[] pidbArray = new pidb[n];
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            do {
                int n4 = ++n2;
                int n5 = n2;
                objectArray2 = pidbArray;
                pidb pidb2 = new pidb();
                objectArray2[n5] = pidb2;
            } while (n2 != n3);
        }
        objectArray2 = pidbArray;
        jxtc2._d = objectArray2;
    }

    static {
        _b = new kjui(null);
        _f = new eidj();
        _g = new gloomyfolken.mods.weapon.trace.kjui(jxtc._b._a()._a());
    }

    @JvmStatic
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static final int _a(@NotNull SmartMoving smartMoving) {
        Intrinsics.checkParameterIsNotNull(smartMoving, "smart");
        return _b._a(smartMoving);
    }

    @JvmStatic
    public static final boolean _c(int n) {
        return _b._a(n);
    }

    @JvmStatic
    public static final boolean _d(int n) {
        return _b._b(n);
    }

    @JvmStatic
    public static final boolean _e(int n) {
        return _b._c(n);
    }

    @JvmStatic
    public static final boolean _f(int n) {
        return _b._d(n);
    }

    @JvmStatic
    public static final boolean _g(int n) {
        return _b._e(n);
    }

    @JvmStatic
    public static final boolean _h(int n) {
        return _b._f(n);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderPlayer$TraceMeshPlayer;", "Lgloomyfolken/mods/weapon/trace/TraceMesh;", "()V", "createModel", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaModelData;", "minecraft"})
    private static final class eidj
    extends gloomyfolken.mods.weapon.trace.eidj {
        @Override
        @NotNull
        public rpms _c() {
            return new rpms(new ResourceLocation("gloomycore", "colliders/steve/collider.mcvd"));
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0006"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderPlayer$SmartTraceRotation;", "Lgloomyfolken/mods/stalker/smplayer/SmartMeshRotationImpl;", "()V", "setFromRenderer", "render", "Lnet/smart/render/ModelRotationRenderer;", "minecraft"})
    public static final class pidb
    extends zwat {
        @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
        @NotNull
        public final pidb _a(@NotNull ModelRotationRenderer modelRotationRenderer) {
            Intrinsics.checkParameterIsNotNull(modelRotationRenderer, "render");
            this._a(modelRotationRenderer.rotationOrder);
            this._b(modelRotationRenderer.ignoreSuperRotation);
            this._a(modelRotationRenderer.ignoreBase);
            this._a(modelRotationRenderer.field_78795_f);
            this._b(modelRotationRenderer.field_78796_g);
            this._c(modelRotationRenderer.field_78808_h);
            this._g(modelRotationRenderer.translationOffsetX());
            this._h(modelRotationRenderer.translationOffsetY());
            this._i(modelRotationRenderer.translationOffsetZ());
            this._d(modelRotationRenderer.rotationPointX());
            this._e(modelRotationRenderer.rotationPointY());
            this._f(modelRotationRenderer.rotationPointZ());
            this._j(modelRotationRenderer.scaleY);
            return this;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderPlayer$Companion;", "", "()V", "smartAnimation", "Lgloomyfolken/mods/weapon/trace/AnimationEntrySmartmovingServer;", "getSmartAnimation", "()Lgloomyfolken/mods/weapon/trace/AnimationEntrySmartmovingServer;", "traceModel", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderPlayer$TraceMeshPlayer;", "getTraceModel", "()Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderPlayer$TraceMeshPlayer;", "getStateBits", "", "smart", "Lnet/smart/moving/SmartMoving;", "isCrawl", "", "stateBits", "isDive", "isFeetClimb", "isHandsClimb", "isSlide", "isSwim", "minecraft"})
    public static final class kjui {
        private final eidj _a() {
            return _f;
        }

        private final gloomyfolken.mods.weapon.trace.kjui _b() {
            return _g;
        }

        @JvmStatic
        @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
        public final int _a(@NotNull SmartMoving smartMoving) {
            Intrinsics.checkParameterIsNotNull(smartMoving, "smart");
            int n = 0;
            n |= owkq._d(smartMoving.isSwimming) << 0;
            n |= owkq._d(smartMoving.isDiving) << 1;
            n |= owkq._d(smartMoving.isCrawling && !smartMoving.isClimbing) << 2;
            n |= owkq._d(smartMoving.isSliding) << 3;
            n |= owkq._d(smartMoving.actualHandsClimbType != 0) << 4;
            return n |= owkq._d(smartMoving.actualFeetClimbType != 0) << 5;
        }

        @JvmStatic
        public final boolean _a(int n) {
            return (n & 1) > 0;
        }

        @JvmStatic
        public final boolean _b(int n) {
            return (n & 2) > 0;
        }

        @JvmStatic
        public final boolean _c(int n) {
            return (n & 4) > 0;
        }

        @JvmStatic
        public final boolean _d(int n) {
            return (n & 8) > 0;
        }

        @JvmStatic
        public final boolean _e(int n) {
            return (n & 0x10) > 0;
        }

        @JvmStatic
        public final boolean _f(int n) {
            return (n & 0x20) > 0;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

