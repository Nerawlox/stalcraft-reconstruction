/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lgloomyfolken/mods/anomaly/tile/TileEntityTeleportBubble;", "Lgloomyfolken/mods/anomaly/tile/TileEntityTeleport;", "()V", "UPDATE_AVAILABILITY_TICKS", "", "aabb", "Lnet/minecraft/util/AxisAlignedBB;", "kotlin.jvm.PlatformType", "center", "Lnet/minecraft/util/Vec3;", "ticks", "onDataPacket", "", "net", "Lnet/minecraft/network/INetworkManager;", "pkt", "Lnet/minecraft/network/packet/Packet132TileEntityData;", "shouldRenderInPass", "", "pass", "updateEntity", "updatePositionAndSize", "validate", "minecraft"})
public final class ivab
extends jydd {
    private int _e = 400;
    private int _f;
    private final Vec3 _g = VecExtensionsKt.vec3();
    private AxisAlignedBB _h = McExtensionsKt.AxisAlignedBB();

    private final void _k() {
        VecExtensionsKt.set(this._g, (double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5);
        Vec3 vec3 = this._g;
        Intrinsics.checkExpressionValueIsNotNull(vec3, "center");
        McExtensionsKt.setMin(this._h, vec3);
        Vec3 vec32 = this._g;
        Intrinsics.checkExpressionValueIsNotNull(vec32, "center");
        McExtensionsKt.setMax(this._h, vec32);
        this._h = this._h._b(this._i()._b() + 2.0, this._i()._b() + 2.0, this._i()._b() + 2.0);
    }

    @Override
    public void validate() {
        super.validate();
        this._k();
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!this.worldObj.isRemote) {
            this._k();
            Iterable iterable = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this._h);
            Iterable iterable2 = iterable;
            Collection collection3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Object object = iterable2.iterator();
            while (object.hasNext()) {
                Object t;
                Object t2 = t = object.next();
                Collection collection2 = collection3;
                Object t3 = t2;
                if (!(t3 instanceof EntityLivingBase)) {
                    t3 = null;
                }
                EntityLivingBase entityLivingBase = (EntityLivingBase)t3;
                collection2.add(entityLivingBase);
            }
            iterable = CollectionsKt.filterNotNull((List)collection3);
            for (Collection collection3 : iterable) {
                object = (EntityLivingBase)((Object)collection3);
                if (!(VecExtensionsKt.add(McExtensionsKt.getPos((Entity)object), 0.0, (double)((Entity)object).height / 2.0, 0.0)._d(this._g) <= this._i()._b())) continue;
                this._b((EntityLivingBase)object);
            }
        } else {
            int n = this._f;
            this._f = n + 1;
            if (n % this._e == 0) {
                InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                    @Override
                    public final void run() {
                        new pzub(this, false).sendToServer();
                    }
                });
            }
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void onDataPacket(@Nullable jjpj jjpj2, @NotNull wpte wpte2) {
        Intrinsics.checkParameterIsNotNull(wpte2, "pkt");
        super.onDataPacket(jjpj2, wpte2);
        new pzub(this, false).sendToServer();
    }

    @Override
    public boolean shouldRenderInPass(int n) {
        if (!this._i()._d() || !this._g()) {
            return false;
        }
        return n == 1 || n == 2;
    }
}

