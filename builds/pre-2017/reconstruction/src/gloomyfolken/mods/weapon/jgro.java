/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import cpw.mods.fml.common.Loader;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.weapon.trace.ezey;
import gloomyfolken.mods.weapon.trace.jxtc;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00018B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002BE\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0010J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0007J\u0010\u00105\u001a\u0002022\u0006\u00106\u001a\u000207H\u0007R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00140\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u0019\u0010\u0003\u001a\n (*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R$\u0010+\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\u0019\u0010\u0005\u001a\n (*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010*R#\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00140\u001b8F\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u001d\u00a8\u00069"}, d2={"Lgloomyfolken/mods/weapon/ShotInfo;", "", "()V", "sourcePos", "Lnet/minecraft/util/Vec3;", "targetPos", "shots", "", "candidateTargets", "", "Lnet/minecraft/entity/Entity;", "aim", "", "expectedDelay", "", "flags", "(Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ILjava/util/List;ZFI)V", "_entityPositions", "Ljava/util/HashMap;", "_traceMeshBuilders", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilder;", "<set-?>", "getAim", "()Z", "setAim", "(Z)V", "entityPositions", "", "getEntityPositions", "()Ljava/util/Map;", "getExpectedDelay", "()F", "setExpectedDelay", "(F)V", "getFlags", "()I", "setFlags", "(I)V", "getShots", "setShots", "kotlin.jvm.PlatformType", "getSourcePos", "()Lnet/minecraft/util/Vec3;", "stateBits", "getStateBits", "setStateBits", "getTargetPos", "traceMeshBuilders", "getTraceMeshBuilders", "read", "", "input", "Ljava/io/DataInput;", "write", "output", "Ljava/io/DataOutput;", "SmartInfo", "minecraft"})
public final class jgro {
    private final HashMap<Integer, ezey<Entity>> _a;
    private final HashMap<Integer, Vec3> _b;
    private int _c;
    private int _d;
    private final Vec3 _e;
    private final Vec3 _f;
    private boolean _g;
    private float _h;
    private int _i;

    @NotNull
    public final Map<Integer, ezey<Entity>> _a() {
        return this._a;
    }

    @NotNull
    public final Map<Integer, Vec3> _b() {
        return this._b;
    }

    public final int _c() {
        return this._c;
    }

    private final void _b(int n) {
        this._c = n;
    }

    public final int _d() {
        return this._d;
    }

    private final void _c(int n) {
        this._d = n;
    }

    public final Vec3 _e() {
        return this._e;
    }

    public final Vec3 _f() {
        return this._f;
    }

    public final boolean _g() {
        return this._g;
    }

    private final void _a(boolean bl) {
        this._g = bl;
    }

    public final float _h() {
        return this._h;
    }

    public final void _a(float f) {
        this._h = f;
    }

    public final int _i() {
        return this._i;
    }

    public final void _a(int n) {
        this._i = n;
    }

    public final void _a(@NotNull DataOutput dataOutput) throws IOException {
        Map.Entry entry;
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
        dataOutput.writeBoolean(this._g);
        dataOutput.writeFloat(this._h);
        dataOutput.writeInt(this._i);
        dataOutput.writeShort(this._d);
        dataOutput.writeDouble(this._e._c);
        dataOutput.writeDouble(this._e._d);
        dataOutput.writeDouble(this._e._e);
        dataOutput.writeDouble(this._f._c);
        dataOutput.writeDouble(this._f._d);
        dataOutput.writeDouble(this._f._e);
        dataOutput.writeByte(this._c);
        dataOutput.writeByte(this._a.size());
        dataOutput.writeShort(this._b.size());
        Iterable iterable = this._b.entrySet();
        for (Object t : iterable) {
            entry = (Map.Entry)t;
            Object k = entry.getKey();
            Intrinsics.checkExpressionValueIsNotNull(k, "entry.key");
            dataOutput.writeInt(((Number)k).intValue());
            dataOutput.writeFloat((float)((Vec3)entry.getValue())._c);
            dataOutput.writeFloat((float)((Vec3)entry.getValue())._d);
            dataOutput.writeFloat((float)((Vec3)entry.getValue())._e);
        }
        iterable = this._a.entrySet();
        for (Object t : iterable) {
            entry = (Map.Entry)t;
            Object k = entry.getKey();
            Intrinsics.checkExpressionValueIsNotNull(k, "entry.key");
            dataOutput.writeInt(((Number)k).intValue());
            Object v = entry.getValue();
            Intrinsics.checkExpressionValueIsNotNull(v, "entry.value");
            dataOutput.writeByte(ezey._a._a((ezey)v));
            ((ezey)entry.getValue())._a(dataOutput);
        }
    }

    public final void _a(@NotNull DataInput dataInput) throws IOException {
        Object object;
        ezey<?> ezey2;
        int n;
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
        this._g = dataInput.readBoolean();
        this._h = dataInput.readFloat();
        this._i = dataInput.readInt();
        this._d = dataInput.readShort();
        VecExtensionsKt.set(this._e, dataInput.readDouble(), dataInput.readDouble(), dataInput.readDouble());
        VecExtensionsKt.set(this._f, dataInput.readDouble(), dataInput.readDouble(), dataInput.readDouble());
        this._c = dataInput.readByte();
        byte by = dataInput.readByte();
        short s = dataInput.readShort();
        int n2 = 0;
        int n3 = s - 1;
        if (n2 <= n3) {
            while (true) {
                n = dataInput.readInt();
                Vec3 vec3 = VecExtensionsKt.vec3(dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat());
                ezey2 = this._b;
                object = TuplesKt.to(n, vec3);
                ezey2.put(((Pair)object).getFirst(), ((Pair)object).getSecond());
                if (n2 == n3) break;
                ++n2;
            }
        }
        if (by > 256) {
            throw (Throwable)new IllegalStateException("Player requested too many shot targets, probably hacked client.\nThe player will be kicked by server with the 'end of stream' message.");
        }
        n2 = 0;
        n3 = by - 1;
        if (n2 <= n3) {
            while (true) {
                n = dataInput.readInt();
                byte by2 = dataInput.readByte();
                if (by2 >= 0) {
                    ezey2 = ezey._a._a(by2);
                    if (ezey2 != null) {
                        ezey2._a(dataInput);
                        this._a.put(n, (ezey<Entity>)ezey2);
                    } else {
                        object = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
                        Logger.severe("Error while trying to read shot client hit data: could not found any trace mesh builder suitable for ID: " + by2 + "!\nThis is bad, probably hacked client.\nNext player will be kicked " + "by server for an invalid packet.\nCurrent time: " + (String)object, new Object[0]);
                    }
                }
                if (n2 == n3) break;
                ++n2;
            }
        }
    }

    public jgro() {
        jgro jgro2 = this;
        HashMap hashMap = new HashMap();
        jgro2._a = hashMap;
        jgro2 = this;
        hashMap = new HashMap();
        jgro2._b = hashMap;
        this._e = VecExtensionsKt.vec3();
        this._f = VecExtensionsKt.vec3();
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public jgro(@NotNull Vec3 vec3, @NotNull Vec3 vec32, int n, @NotNull List<? extends Entity> list2, boolean bl, float f, int n2) {
        Intrinsics.checkParameterIsNotNull(vec3, "sourcePos");
        Intrinsics.checkParameterIsNotNull(vec32, "targetPos");
        Intrinsics.checkParameterIsNotNull(list2, "candidateTargets");
        jgro jgro2 = this;
        HashMap hashMap = new HashMap();
        jgro2._a = hashMap;
        jgro2 = this;
        hashMap = new HashMap();
        jgro2._b = hashMap;
        this._e = VecExtensionsKt.vec3();
        this._f = VecExtensionsKt.vec3();
        VecExtensionsKt.set(this._e, vec3);
        VecExtensionsKt.set(this._f, vec32);
        this._d = n;
        this._g = bl;
        this._h = f;
        this._i = n2;
        Iterator iterator2 = list2.stream().distinct().collect(Collectors.toList()).iterator();
        while (iterator2.hasNext()) {
            Entity entity;
            Entity entity2 = entity = (Entity)iterator2.next();
            Intrinsics.checkExpressionValueIsNotNull(entity2, "entity");
            final ezey<Entity> ezey2 = ezey._a._b(entity2);
            if (ezey2 != null) {
                InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                    @Override
                    public final void run() {
                        Entity entity2 = entity;
                        Intrinsics.checkExpressionValueIsNotNull(entity2, "entity");
                        ezey2._a(entity2);
                    }
                });
                this._a.put(entity.entityId, ezey2);
            }
            this._b.put(entity.entityId, McExtensionsKt.getPos(entity));
        }
        if (Loader.isModLoaded("mod_SmartMoving")) {
            kjui._a._a(this);
        }
    }

    public static final /* synthetic */ int _a(jgro jgro2) {
        return jgro2._c;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/weapon/ShotInfo$SmartInfo;", "", "()V", "addSmartInfo", "", "shotInfo", "Lgloomyfolken/mods/weapon/ShotInfo;", "minecraft"})
    public static final class kjui {
        public static final kjui _a;

        @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
        public final void _a(@NotNull jgro jgro2) {
            Intrinsics.checkParameterIsNotNull(jgro2, "shotInfo");
            SmartMoving smartMoving = SmartMovingFactory.getInstance(Minecraft._E()._t);
            Intrinsics.checkExpressionValueIsNotNull(smartMoving, "SmartMovingFactory.getIn\u2026getMinecraft().thePlayer)");
            jgro2._c = jxtc._b._a(smartMoving);
        }

        private kjui() {
            _a = this;
        }

        static {
            new kjui();
        }
    }
}

