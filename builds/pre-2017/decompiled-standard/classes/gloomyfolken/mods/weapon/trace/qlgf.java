/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.stalker.player.jgro;
import gloomyfolken.mods.weapon.trace.ezey;
import gloomyfolken.mods.weapon.trace.ugqx;
import gloomyfolken.mods.weapon.trace.zwaw;
import java.io.DataInput;
import java.io.DataOutput;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.AnimationEntryNpcServer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.model.ModelNPCMale;
import noppes.npcs.client.renderer.RenderNPCHumanMaleOptimized;
import noppes.npcs.entity.EntityNPCHumanMale;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003()*B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0002H\u0017J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0007R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderNpc;", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderBiped;", "Lnoppes/npcs/EntityNPCInterface;", "()V", "indexToMeshName", "", "", "getIndexToMeshName", "()[Ljava/lang/String;", "[Ljava/lang/String;", "rotations", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderNpc$NpcMeshRotation;", "getRotations", "()[Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderNpc$NpcMeshRotation;", "[Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderNpc$NpcMeshRotation;", "sendRotations", "", "buildTraceResultInternal", "Lgloomyfolken/mods/weapon/trace/TraceResult;", "entity", "getRotationByName", "string", "read", "", "input", "Ljava/io/DataInput;", "readMeshEntry", "index", "", "setFromClientEntity", "setRotations", "mp", "Lnoppes/npcs/client/model/ModelNPCMale;", "setupDelicateRotationProps", "Lnoppes/npcs/entity/EntityNPCHumanMale;", "write", "output", "Ljava/io/DataOutput;", "writeMeshEntry", "traceRotation", "Companion", "NpcMeshRotation", "TraceMeshNpc", "minecraft"})
public final class qlgf
extends zwaw<EntityNPCInterface> {
    @NotNull
    private final String[] _c;
    @NotNull
    private final pidb[] _d;
    private boolean _e;
    @NotNull
    private static final eidj _f;
    @NotNull
    private static final AnimationEntryNpcServer _g;
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
        byte by = dataInput.readByte();
        final int n = 0;
        int n2 = by - 1;
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
        dataOutput.writeByte(this._e ? ((Object[])this._d).length : 0);
        if (this._e) {
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
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public final void _a(@NotNull pidb pidb2, @NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(pidb2, "traceRotation");
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
        this._a(pidb2._a(), dataOutput);
        this._a(pidb2._b(), dataOutput);
        this._a(pidb2._c(), dataOutput);
    }

    @NotNull
    public final pidb _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "string");
        return this._d[ArraysKt.indexOf((Object[])this._c, string)];
    }

    @NotNull
    protected ugqx _a(final @NotNull EntityNPCInterface entityNPCInterface) {
        ugqx ugqx2;
        Intrinsics.checkParameterIsNotNull(entityNPCInterface, "entity");
        if (entityNPCInterface.func_82150_aj()) {
            ugqx2 = ugqx._a._d();
        } else if (entityNPCInterface instanceof EntityNPCHumanMale) {
            InvokeSideOnly.frontend(!entityNPCInterface.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeFrontendOnly(){

                @Override
                public final void run() {
                }
            });
            _b._b().setRotationsSource(this);
            _b._a()._a(_b._b());
            _b._a()._a((float)entityNPCInterface.field_70165_t + this._e(), (float)entityNPCInterface.field_70163_u + this._f(), (float)entityNPCInterface.field_70161_v + this._g(), entityNPCInterface.field_70761_aq, 0.9375f * ((float)entityNPCInterface.display.modelSize / 5.0f));
            ugqx2 = ugqx._a._a(_b._a());
        } else {
            ugqx2 = ugqx._a._a(entityNPCInterface);
        }
        return ugqx2;
    }

    @Override
    public /* synthetic */ ugqx _c(Entity entity) {
        return this._a((EntityNPCInterface)entity);
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    @NotNull
    public qlgf _b(@NotNull EntityNPCInterface entityNPCInterface) {
        Intrinsics.checkParameterIsNotNull(entityNPCInterface, "entity");
        if (entityNPCInterface instanceof EntityNPCHumanMale) {
            this._e = true;
            tfvm tfvm2 = gqqu._b._a(entityNPCInterface);
            if (!(tfvm2 instanceof RenderNPCHumanMaleOptimized)) {
                tfvm2 = null;
            }
            RenderNPCHumanMaleOptimized renderNPCHumanMaleOptimized = (RenderNPCHumanMaleOptimized)tfvm2;
            if (renderNPCHumanMaleOptimized == null) {
                return this;
            }
            RenderNPCHumanMaleOptimized renderNPCHumanMaleOptimized2 = renderNPCHumanMaleOptimized;
            renderNPCHumanMaleOptimized2.loadSkeletonState(entityNPCInterface, 0.0f);
            ModelNPCMale modelNPCMale = renderNPCHumanMaleOptimized2.getBipedModel();
            Intrinsics.checkExpressionValueIsNotNull(modelNPCMale, "renderer.bipedModel");
            this._a(modelNPCMale);
        }
        return this;
    }

    @Override
    public /* synthetic */ ezey _a(Entity entity) {
        return this._b((EntityNPCInterface)entity);
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public final void _a(@NotNull ModelNPCMale modelNPCMale) {
        Intrinsics.checkParameterIsNotNull(modelNPCMale, "mp");
        Iterable iterable = CollectionsKt.listOf(new ModelRenderer[]{modelNPCMale.bipedHead, modelNPCMale.bipedBody, modelNPCMale.bipedLeftArm, modelNPCMale.bipedRightArm, modelNPCMale.bipedLeftLeg, modelNPCMale.bipedRightLeg});
        int n = 0;
        for (Object t : iterable) {
            int n2 = n++;
            ModelRenderer modelRenderer = (ModelRenderer)t;
            int n3 = n2;
            pidb pidb2 = this._d[n3];
            ModelRenderer modelRenderer2 = modelRenderer;
            Intrinsics.checkExpressionValueIsNotNull(modelRenderer2, "it");
            pidb2._a(modelRenderer2);
        }
    }

    public qlgf() {
        Object[] objectArray = new String[]{"head", "body", "left_arm", "right_arm", "left_leg", "right_leg"};
        qlgf qlgf2 = this;
        Object[] objectArray2 = objectArray;
        qlgf2._c = (String[])objectArray2;
        int n = ((Object[])this._c).length;
        qlgf2 = this;
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
        qlgf2._d = objectArray2;
    }

    static {
        _b = new kjui(null);
        _f = new eidj();
        _g = new AnimationEntryNpcServer(_b._a()._a());
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderNpc$TraceMeshNpc;", "Lgloomyfolken/mods/weapon/trace/TraceMesh;", "()V", "createModel", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaModelData;", "minecraft"})
    private static final class eidj
    extends gloomyfolken.mods.weapon.trace.eidj {
        @Override
        @NotNull
        public rpms _c() {
            return new rpms(new ResourceLocation("gloomycore", "colliders/steve/collider.mcvd"));
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0006"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderNpc$NpcMeshRotation;", "Lgloomyfolken/mods/stalker/player/MeshRotationImpl;", "()V", "setFromRenderer", "render", "Lnet/minecraft/client/model/ModelRenderer;", "minecraft"})
    public static final class pidb
    extends jgro {
        @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
        @NotNull
        public final pidb _a(@NotNull ModelRenderer modelRenderer) {
            Intrinsics.checkParameterIsNotNull(modelRenderer, "render");
            this._a(modelRenderer.field_78795_f);
            this._b(modelRenderer.field_78796_g);
            this._c(modelRenderer.field_78808_h);
            this._d(modelRenderer.field_78800_c);
            this._e(modelRenderer.field_78797_d);
            this._f(modelRenderer.field_78798_e);
            return this;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderNpc$Companion;", "", "()V", "npcAnimation", "Lnoppes/npcs/AnimationEntryNpcServer;", "getNpcAnimation", "()Lnoppes/npcs/AnimationEntryNpcServer;", "traceModel", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderNpc$TraceMeshNpc;", "getTraceModel", "()Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderNpc$TraceMeshNpc;", "minecraft"})
    private static final class kjui {
        @NotNull
        public final eidj _a() {
            return _f;
        }

        @NotNull
        public final AnimationEntryNpcServer _b() {
            return _g;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

