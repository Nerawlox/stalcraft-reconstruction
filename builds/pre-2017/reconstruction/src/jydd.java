/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.mods.anomaly.jxtc;
import gloomyfolken.mods.anomaly.zwaw;
import gloomyfolken.mods.core.misc.sajz;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002>?B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020%\u0018\u00010$H\u0014J\u000f\u0010&\u001a\u0004\u0018\u00010'H\u0016\u00a2\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0018H\u0016J\u0010\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0003J\u001a\u0010-\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0018H\u0014J\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u001aH\u0016J\u0010\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u001aH\u0014J\u0010\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010;\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010<\u001a\u00020\u0018H\u0016J\u0010\u0010=\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u001aH\u0016R$\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006@"}, d2={"Lgloomyfolken/mods/anomaly/tile/TileEntityTeleport;", "Lgloomyfolken/mods/anomaly/tile/TileEntityAnomaly;", "Lgloomyfolken/mods/anomaly/ITeleport;", "Lgloomyfolken/mods/core/misc/IRemoteEditableTile;", "()V", "activeTeleportTasks", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/anomaly/tile/TileEntityTeleport$TeleportTask;", "Lkotlin/collections/ArrayList;", "getActiveTeleportTasks", "()Ljava/util/ArrayList;", "available", "", "getAvailable", "()Z", "setAvailable", "(Z)V", "teleportSettings", "Lgloomyfolken/mods/anomaly/TeleportSettings;", "getTeleportSettings", "()Lgloomyfolken/mods/anomaly/TeleportSettings;", "setTeleportSettings", "(Lgloomyfolken/mods/anomaly/TeleportSettings;)V", "applyEdit", "", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "editor", "Lnet/minecraft/entity/player/EntityPlayer;", "canTeleportEntity", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "canUpdate", "getDescriptionPacket", "Lnet/minecraft/network/packet/Packet;", "getEmitterClass", "Ljava/lang/Class;", "Lgloomyfolken/mods/effects/client/particle/ParticleEmitter;", "getTeleportRuleId", "", "()Ljava/lang/Integer;", "invalidate", "isValidTarget", "target", "Lgloomyfolken/mods/anomaly/TeleportSettings$TargetLocation;", "onDataPacket", "net", "Lnet/minecraft/network/INetworkManager;", "pkt", "Lnet/minecraft/network/packet/Packet132TileEntityData;", "progressTeleportingTargets", "readFromNBT", "nbt", "readTeleportNbt", "baseNbt", "setWorldObj", "par1World", "Lnet/minecraft/world/World;", "teleportEntity", "tryStartTeleportingTarget", "updateEntity", "writeToNBT", "Companion", "TeleportTask", "minecraft"})
public class jydd
extends royz
implements zwaw,
sajz {
    private boolean _e;
    @NotNull
    private final ArrayList<pidb> _f;
    @NotNull
    private jxtc _g;
    public static final int _c = 5;
    public static final kjui _d = new kjui(null);

    public final boolean _g() {
        return this._e;
    }

    public final void _a(boolean bl) {
        this._e = bl;
    }

    @NotNull
    protected final ArrayList<pidb> _h() {
        return this._f;
    }

    @NotNull
    public final jxtc _i() {
        return this._g;
    }

    public final void _a(@NotNull jxtc jxtc2) {
        Intrinsics.checkParameterIsNotNull(jxtc2, "<set-?>");
        this._g = jxtc2;
    }

    @Override
    @Nullable
    public Integer _a() {
        return this._g._c();
    }

    @Override
    @Nullable
    protected Class<? extends iekw> _d() {
        return null;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void invalidate() {
        Iterable iterable = this._f;
        for (Object t : iterable) {
            pidb pidb2 = (pidb)t;
            if (!(pidb2._b() instanceof EntityPlayer)) continue;
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(pidb2){
                final /* synthetic */ pidb _a;

                public final void run() {
                }
                {
                    this._a = pidb2;
                }
            });
        }
        this._f.clear();
        this.tileEntityInvalid = true;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!this.worldObj.isRemote) {
            int n = this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord);
            if (!(Block.blocksList[n] instanceof uybl)) {
                this.worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
                return;
            }
            this._j();
        }
    }

    protected void _j() {
        Iterable iterable = this._f;
        for (Object t : iterable) {
            pidb pidb2;
            pidb pidb3 = pidb2 = (pidb)t;
            pidb3._a(pidb3._a() + -1);
            if (pidb3._a() > 0) continue;
            if (pidb2._b() instanceof EntityPlayer) {
                InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(pidb2){
                    final /* synthetic */ pidb _a;

                    public final void run() {
                    }
                    {
                        this._a = pidb2;
                    }
                });
            }
            this._d(pidb2._b());
        }
        this._f.removeIf(zwat._a);
    }

    public final void _b(final @NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entity");
        if (!this.worldObj.isRemote && this._c(entityLivingBase)) {
            boolean bl;
            Iterable iterable;
            block5: {
                iterable = this._f;
                for (Object t : iterable) {
                    pidb pidb2 = (pidb)t;
                    if (!Intrinsics.areEqual(pidb2._b(), entityLivingBase)) continue;
                    bl = false;
                    break block5;
                }
                bl = true;
            }
            if (bl) {
                Object t = InvokeWithResult.frontend(new InvokeWithResult.InvokeFrontendOnly<T>(){

                    public final boolean _a() {
                        return false;
                    }
                });
                Intrinsics.checkExpressionValueIsNotNull(t, "InvokeWithResult.fronten\u2026ny(this::isValidTarget) }");
                if (((Boolean)t).booleanValue()) {
                    iterable = this._f;
                    pidb pidb3 = new pidb(entityLivingBase);
                    iterable.add(pidb3);
                    if (entityLivingBase instanceof EntityPlayer) {
                        InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

                            @Override
                            public final void run() {
                            }
                        });
                    }
                }
            }
        }
    }

    private final boolean _c(EntityLivingBase entityLivingBase) {
        EntityPlayer entityPlayer;
        EntityLivingBase entityLivingBase2 = entityLivingBase;
        if (!(entityLivingBase2 instanceof EntityPlayer)) {
            entityLivingBase2 = null;
        }
        return (entityPlayer = (EntityPlayer)entityLivingBase2) != null && this._a(entityPlayer) && !entityPlayer.capabilities._d || this._g._f();
    }

    private final void _d(final EntityLivingBase entityLivingBase) {
        if (!this.worldObj.isRemote && entityLivingBase instanceof EntityPlayerMP) {
            if (!((EntityPlayerMP)entityLivingBase).isEntityAlive()) {
                return;
            }
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

                @Override
                public final void run() {
                }
            });
        }
    }

    @Override
    public void applyEdit(@NotNull NBTTagCompound nBTTagCompound, @Nullable EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        this._a(nBTTagCompound);
    }

    protected void _a(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "baseNbt");
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("teleport");
        this._g._a(owkq._c(nBTTagCompound2._i("size"), 32.0));
        int n = nBTTagCompound2._f("rule");
        Object object = this._g;
        int n2 = n;
        Object object2 = n2 >= 0 ? Integer.valueOf(n2) : null;
        ((jxtc)object)._a((Integer)object2);
        this._g._b(nBTTagCompound2._o("teleport_npcs"));
        this._g._a().clear();
        if (nBTTagCompound2._c("visible")) {
            this._g._a(nBTTagCompound2._o("visible"));
        }
        if (nBTTagCompound2._c("locations")) {
            NBTTagList nBTTagList = nBTTagCompound2._n("locations");
            Iterable iterable = nBTTagList._c;
            Iterator iterator2 = iterable.iterator();
            while (iterator2.hasNext()) {
                jxtc.kjui kjui2;
                Object t;
                Object t2;
                Object t3 = t2 = (t = iterator2.next());
                if (t3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
                }
                NBTTagCompound nBTTagCompound3 = (NBTTagCompound)t3;
                String string = nBTTagCompound3._j("loc");
                int n3 = nBTTagCompound3._f("z");
                int n4 = nBTTagCompound3._f("y");
                int n5 = nBTTagCompound3._f("x");
                jxtc.kjui kjui3 = kjui2;
                jxtc.kjui kjui4 = kjui2;
                ArrayList<jxtc.kjui> arrayList = this._g._a();
                String string2 = string;
                if (string2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String string3 = ((Object)StringsKt.trim((CharSequence)string2)).toString();
                kjui3(n5, n4, n3, owkq._a(string3), nBTTagCompound3._h("weight"));
                arrayList.add(kjui4);
            }
        } else {
            jxtc.kjui kjui5;
            String string = nBTTagCompound2._j("target_loc");
            int n6 = nBTTagCompound2._f("z");
            int n7 = nBTTagCompound2._f("y");
            int n8 = nBTTagCompound2._f("x");
            jxtc.kjui kjui6 = kjui5;
            object2 = kjui5;
            object = this._g._a();
            String string4 = string;
            if (string4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String string5 = ((Object)StringsKt.trim((CharSequence)string4)).toString();
            kjui6(n8, n7, n6, owkq._a(string5), 0.0f, 16, null);
            ((ArrayList)object).add(object2);
        }
    }

    @Override
    public void writeToNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "baseNbt");
        super.writeToNBT(nBTTagCompound);
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        NBTTagList nBTTagList = new NBTTagList();
        Iterable iterable = this._g._a();
        for (Object t : iterable) {
            jxtc.kjui kjui2 = (jxtc.kjui)t;
            NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
            ezpx._a(nBTTagCompound3, "x", kjui2._a());
            ezpx._a(nBTTagCompound3, "y", kjui2._b());
            ezpx._a(nBTTagCompound3, "z", kjui2._c());
            String string = kjui2._d();
            if (string == null) {
                string = "";
            }
            ezpx._a(nBTTagCompound3, "loc", string);
            ezpx._a(nBTTagCompound3, "weight", kjui2._e());
            nBTTagList._a(nBTTagCompound3);
        }
        ezpx._a(nBTTagCompound2, "visible", this._g._d());
        ezpx._a(nBTTagCompound2, "locations", nBTTagList);
        ezpx._a(nBTTagCompound2, "size", this._g._b());
        Integer n = this._g._c();
        ezpx._a(nBTTagCompound2, "rule", n != null ? n : -1);
        ezpx._a(nBTTagCompound2, "teleport_npcs", this._g._f());
        nBTTagCompound._a("teleport", (NBTBase)nBTTagCompound2);
    }

    @Override
    public void readFromNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "nbt");
        super.readFromNBT(nBTTagCompound);
        this._a(nBTTagCompound);
    }

    @Override
    public void onDataPacket(@Nullable jjpj jjpj2, @NotNull wpte wpte2) {
        Intrinsics.checkParameterIsNotNull(wpte2, "pkt");
        NBTTagCompound nBTTagCompound = wpte2._e;
        Intrinsics.checkExpressionValueIsNotNull(nBTTagCompound, "pkt.data");
        this._a(nBTTagCompound);
    }

    @Override
    @NotNull
    public Packet getDescriptionPacket() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        return new wpte(this.xCoord, this.yCoord, this.zCoord, 1, nBTTagCompound);
    }

    @Override
    public void setWorldObj(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "par1World");
        super.setWorldObj(world);
        if (!world.isRemote) {
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

                @Override
                public final void run() {
                }
            });
        }
    }

    public jydd() {
        jydd jydd2 = this;
        ArrayList arrayList = new ArrayList();
        jydd2._f = arrayList;
        this._g = new jxtc();
    }

    @Override
    public boolean _a(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        return zwaw.kjui._a(this, entityPlayer);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lgloomyfolken/mods/anomaly/tile/TileEntityTeleport$TeleportTask;", "", "target", "Lnet/minecraft/entity/EntityLivingBase;", "(Lnet/minecraft/entity/EntityLivingBase;)V", "getTarget", "()Lnet/minecraft/entity/EntityLivingBase;", "ticksBeforeTeleport", "", "getTicksBeforeTeleport", "()I", "setTicksBeforeTeleport", "(I)V", "minecraft"})
    protected static final class pidb {
        private int _a;
        @NotNull
        private final EntityLivingBase _b;

        public final int _a() {
            return this._a;
        }

        public final void _a(int n) {
            this._a = n;
        }

        @NotNull
        public final EntityLivingBase _b() {
            return this._b;
        }

        public pidb(@NotNull EntityLivingBase entityLivingBase) {
            Intrinsics.checkParameterIsNotNull(entityLivingBase, "target");
            this._b = entityLivingBase;
            this._a = 5;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0084\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/anomaly/tile/TileEntityTeleport$Companion;", "", "()V", "TICKS_BEFORE_TELEPORT", "", "minecraft"})
    protected static final class kjui {
        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

