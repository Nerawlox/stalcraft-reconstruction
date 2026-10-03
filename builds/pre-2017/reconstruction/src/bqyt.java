/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.gomc;
import gloomyfolken.mods.core.misc.sajz;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0006H\u0017J\u0010\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020/H\u0016J\u0010\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u00020/H\u0016J\u0010\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u000208H\u0017J\u0018\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016J \u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020\u0016H\u0016J\u0010\u0010B\u001a\u00020+2\u0006\u0010,\u001a\u00020CH\u0016J\u000e\u0010D\u001a\u00020+2\u0006\u0010,\u001a\u00020-J&\u0010E\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010F\u001a\u00020\u00102\n\b\u0002\u0010G\u001a\u0004\u0018\u00010/H\u0016J\b\u0010H\u001a\u00020IH\u0017J\u0010\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020+H\u0016J\u0010\u0010N\u001a\u00020C2\u0006\u0010,\u001a\u00020CH\u0016J\u0010\u0010O\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0085.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010'\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001a\u00a8\u0006P"}, d2={"Lgloomyfolken/mods/core/spawn/TileEntityStalkerSpawner;", "Lnet/minecraft/tileentity/TileEntity;", "Lgloomyfolken/mods/core/spawn/EntitySpawnController;", "Lgloomyfolken/mods/core/misc/IRemoteEditableTile;", "()V", "_spawnExecutor", "Lgloomyfolken/mods/core/spawn/BasicSpawnExecutor;", "get_spawnExecutor", "()Lgloomyfolken/mods/core/spawn/BasicSpawnExecutor;", "set_spawnExecutor", "(Lgloomyfolken/mods/core/spawn/BasicSpawnExecutor;)V", "drm", "Lgloomyfolken/mods/core/misc/TileEntityDRM;", "getDrm", "()Lgloomyfolken/mods/core/misc/TileEntityDRM;", "spawnEnabled", "", "getSpawnEnabled", "()Z", "setSpawnEnabled", "(Z)V", "xMax", "", "getXMax", "()I", "setXMax", "(I)V", "xMin", "getXMin", "setXMin", "yMax", "getYMax", "setYMax", "yMin", "getYMin", "setYMin", "zMax", "getZMax", "setZMax", "zMin", "getZMin", "setZMin", "applyEdit", "", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "editor", "Lnet/minecraft/entity/player/EntityPlayer;", "getDescriptionPacket", "Lnet/minecraft/network/packet/Packet;", "getSpawnExecutor", "hasAdvancedPermissions", "entityPlayer", "hasEditPermissions", "isEntityPositionValidForSpawn", "entity", "Lnet/minecraft/entity/EntityLiving;", "onDataPacket", "net", "Lnet/minecraft/network/INetworkManager;", "pkt", "Lnet/minecraft/network/packet/Packet132TileEntityData;", "placeTile", "x", "y", "z", "readConfigTags", "Lnet/minecraft/nbt/NBTTagList;", "readFromNBT", "readSpawnerNbt", "isRemoteEdit", "editAuthor", "searchStartPosition", "Lnet/minecraft/util/Vec3;", "setWorldObj", "world", "Lnet/minecraft/world/World;", "updateEntity", "writeConfigTags", "writeToNBT", "minecraft"})
public abstract class bqyt
extends TileEntity
implements sajz,
ivki {
    private int xMin = -2;
    private int yMin = -2;
    private int zMin = -2;
    private int xMax = 2;
    private int yMax = 2;
    private int zMax = 2;
    @NotNull
    private final gomc drm = new gomc(this);
    private boolean spawnEnabled = true;

    public final int getXMin() {
        return this.xMin;
    }

    public final void setXMin(int n) {
        this.xMin = n;
    }

    public final int getYMin() {
        return this.yMin;
    }

    public final void setYMin(int n) {
        this.yMin = n;
    }

    public final int getZMin() {
        return this.zMin;
    }

    public final void setZMin(int n) {
        this.zMin = n;
    }

    public final int getXMax() {
        return this.xMax;
    }

    public final void setXMax(int n) {
        this.xMax = n;
    }

    public final int getYMax() {
        return this.yMax;
    }

    public final void setYMax(int n) {
        this.yMax = n;
    }

    public final int getZMax() {
        return this.zMax;
    }

    public final void setZMax(int n) {
        this.zMax = n;
    }

    @NotNull
    public final gomc getDrm() {
        return this.drm;
    }

    public final boolean getSpawnEnabled() {
        return this.spawnEnabled;
    }

    public final void setSpawnEnabled(boolean bl) {
        this.spawnEnabled = bl;
    }

    public boolean hasAdvancedPermissions(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "entityPlayer");
        return McExtensionsKt.isOpped(entityPlayer);
    }

    @Override
    public boolean hasEditPermissions(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "entityPlayer");
        return this.hasAdvancedPermissions(entityPlayer);
    }

    @Override
    public void setWorldObj(final @NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        super.setWorldObj(world);
        if (!world.isRemote) {
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

                @Override
                public final void run() {
                }
            });
        }
    }

    public void placeTile(int n, int n2, int n3) {
        this.drm._a(n, n2, n3);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!this.worldObj.isRemote) {
            this.drm._a();
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

                @Override
                public final void run() {
                }
            });
        }
    }

    @Override
    public void writeToNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        super.writeToNBT(nBTTagCompound);
        this.drm._b(nBTTagCompound);
        nBTTagCompound._a("xMin", this.xMin);
        nBTTagCompound._a("xMax", this.xMax);
        nBTTagCompound._a("yMin", this.yMin);
        nBTTagCompound._a("yMax", this.yMax);
        nBTTagCompound._a("zMin", this.zMin);
        nBTTagCompound._a("zMax", this.zMax);
        nBTTagCompound._a("dayOfTimeType", this.getConfiguration().getDayOfTimeType());
        nBTTagCompound._a("spawncdmin", this.getConfiguration().getSpawnCooldownMin());
        nBTTagCompound._a("spawncdmax", this.getConfiguration().getSpawnCooldownMax());
        nBTTagCompound._a("maxentities", this.getConfiguration().getMaxEntityCount());
        nBTTagCompound._a("sufficientblocks", ArraysKt.toIntArray(this.getConfiguration().getSufficientBlocks()));
        NBTTagList nBTTagList = new NBTTagList();
        for (String string : this.getConfiguration().getDungeons()) {
            nBTTagList._a(new NBTTagString("name", string));
        }
        nBTTagCompound._a("dungeons", nBTTagList);
        nBTTagCompound._a("spawnentries", this.writeConfigTags(new NBTTagList()));
    }

    @NotNull
    public NBTTagList writeConfigTags(@NotNull NBTTagList nBTTagList) {
        Intrinsics.checkParameterIsNotNull(nBTTagList, "tag");
        return nBTTagList;
    }

    public void readConfigTags(@NotNull NBTTagList nBTTagList) {
        Intrinsics.checkParameterIsNotNull(nBTTagList, "tag");
    }

    @Override
    public void applyEdit(@NotNull NBTTagCompound nBTTagCompound, @Nullable EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        this.readSpawnerNbt(nBTTagCompound, true, entityPlayer);
    }

    public void readSpawnerNbt(@NotNull NBTTagCompound nBTTagCompound, boolean bl, @Nullable EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        this.drm._a(nBTTagCompound);
        this.xMin = nBTTagCompound._f("xMin");
        this.xMax = nBTTagCompound._f("xMax");
        this.yMin = nBTTagCompound._f("yMin");
        this.yMax = nBTTagCompound._f("yMax");
        this.zMin = nBTTagCompound._f("zMin");
        this.zMax = nBTTagCompound._f("zMax");
        if (nBTTagCompound._c("dayOfTimeType")) {
            this.getConfiguration().setDayOfTimeType(nBTTagCompound._f("dayOfTimeType"));
        }
        this.getConfiguration().setSpawnCooldownMin(nBTTagCompound._g("spawncdmin"));
        this.getConfiguration().setSpawnCooldownMax(nBTTagCompound._g("spawncdmax"));
        this.getConfiguration().setMaxEntityCount(nBTTagCompound._f("maxentities"));
        this.getConfiguration().setSufficientBlocks(ArraysKt.toTypedArray(nBTTagCompound._l("sufficientblocks")));
        this.getConfiguration().getPossibleSpawnEntries().clear();
        NBTTagList nBTTagList = nBTTagCompound._n("spawnentries");
        Intrinsics.checkExpressionValueIsNotNull(nBTTagList, "tag.getTagList(\"spawnentries\")");
        this.readConfigTags(nBTTagList);
        this.getConfiguration().getDungeons().clear();
        if (nBTTagCompound._c("dungeons")) {
            NBTTagList nBTTagList2 = nBTTagCompound._n("dungeons");
            Iterable iterable = nBTTagList2._c;
            Iterator iterator2 = iterable.iterator();
            while (iterator2.hasNext()) {
                Object t;
                Object t2;
                Object t3 = t2 = (t = iterator2.next());
                if (t3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagString");
                }
                String string = ((NBTTagString)t3)._c;
                this.getConfiguration().getDungeons().add(string);
            }
        }
    }

    public static /* synthetic */ void readSpawnerNbt$default(bqyt bqyt2, NBTTagCompound nBTTagCompound, boolean bl, EntityPlayer entityPlayer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readSpawnerNbt");
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            entityPlayer = null;
        }
        bqyt2.readSpawnerNbt(nBTTagCompound, bl, entityPlayer);
    }

    @Override
    public final void readFromNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        super.readFromNBT(nBTTagCompound);
        bqyt.readSpawnerNbt$default(this, nBTTagCompound, false, null, 6, null);
    }

    @Override
    @NotNull
    public Packet getDescriptionPacket() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        return new wpte(this.xCoord, this.yCoord, this.zCoord, 1, nBTTagCompound);
    }

    @Override
    public void onDataPacket(@NotNull jjpj jjpj2, @NotNull wpte wpte2) {
        Intrinsics.checkParameterIsNotNull(jjpj2, "net");
        Intrinsics.checkParameterIsNotNull(wpte2, "pkt");
        NBTTagCompound nBTTagCompound = wpte2._e;
        Intrinsics.checkExpressionValueIsNotNull(nBTTagCompound, "pkt.data");
        this.readFromNBT(nBTTagCompound);
    }
}

