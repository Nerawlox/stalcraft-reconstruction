/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.tile;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigJsonHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0017J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0017J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0006H\u0007J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lgloomyfolken/mods/stalker/mobs/tile/TileEntityMutantSpawnerSpecial;", "Lgloomyfolken/mods/stalker/mobs/tile/TileEntityMutantSpawner;", "()V", "firstUpdate", "", "overrideMutantConfig", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "getConfigNamePostfix", "", "getTileConfig", "isEntityPositionValidForSpawn", "entity", "Lnet/minecraft/entity/EntityLiving;", "nextSpawnEntry", "placeTile", "", "x", "", "y", "z", "readSpawnerNbt", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "isRemoteEdit", "editAuthor", "Lnet/minecraft/entity/player/EntityPlayer;", "searchStartPosition", "Lnet/minecraft/util/Vec3;", "setTileConfig", "mutantConfiguration", "updateEntity", "writeToNBT", "minecraft"})
public final class TileEntityMutantSpawnerSpecial
extends TileEntityMutantSpawner {
    private boolean firstUpdate;
    private MutantConfiguration overrideMutantConfig;

    private final String getConfigNamePostfix() {
        return "#@x" + Integer.toHexString(this.xCoord) + 'y' + Integer.toHexString(this.yCoord) + 'z' + Integer.toHexString(this.zCoord);
    }

    @Nullable
    public MutantConfiguration nextSpawnEntry() {
        return this.overrideMutantConfig;
    }

    @Override
    public void placeTile(int n, int n2, int n3) {
        super.placeTile(n, n2, n3);
        this.overrideMutantConfig.getCommon().setName("tile" + this.getConfigNamePostfix());
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (this.firstUpdate) {
            this.firstUpdate = false;
            if (!this.worldObj.isRemote) {
                InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this){
                    final /* synthetic */ TileEntityMutantSpawnerSpecial this$0;

                    public final void run() {
                    }
                    {
                        this.this$0 = tileEntityMutantSpawnerSpecial;
                    }
                });
            }
        }
    }

    @NotNull
    public final MutantConfiguration getTileConfig() {
        return this.overrideMutantConfig;
    }

    @Override
    public void readSpawnerNbt(@NotNull NBTTagCompound nBTTagCompound, boolean bl, @Nullable EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        super.readSpawnerNbt(nBTTagCompound, bl, entityPlayer);
        String string = nBTTagCompound._j("configJson");
        CharSequence charSequence = string;
        if (!(charSequence.length() == 0)) {
            String string2 = string;
            Intrinsics.checkExpressionValueIsNotNull(string2, "configJson");
            this.overrideMutantConfig = ConfigJsonHelper.Companion.read(string2, MutantConfiguration.class);
            this.overrideMutantConfig.getCommon().setName(StringsKt.substringBefore$default(this.overrideMutantConfig.getCommon().getName(), "#@", null, 2, null) + this.getConfigNamePostfix());
        }
    }

    @Override
    public void writeToNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        super.writeToNBT(nBTTagCompound);
        String string = ConfigJsonHelper.Companion.write(this.overrideMutantConfig);
        nBTTagCompound._a("configJson", string);
    }

    public TileEntityMutantSpawnerSpecial() {
        this.get_configuration().setMaxEntityCount(1);
        this.setXMin(0);
        this.setXMax(0);
        this.setYMin(0);
        this.setYMax(0);
        this.setZMin(0);
        this.setZMax(0);
        this.firstUpdate = true;
        this.overrideMutantConfig = new MutantConfiguration();
    }

    @NotNull
    public static final /* synthetic */ MutantConfiguration access$getOverrideMutantConfig$p(TileEntityMutantSpawnerSpecial tileEntityMutantSpawnerSpecial) {
        return tileEntityMutantSpawnerSpecial.overrideMutantConfig;
    }

    public static final /* synthetic */ void access$setOverrideMutantConfig$p(TileEntityMutantSpawnerSpecial tileEntityMutantSpawnerSpecial, @NotNull MutantConfiguration mutantConfiguration) {
        tileEntityMutantSpawnerSpecial.overrideMutantConfig = mutantConfiguration;
    }
}

