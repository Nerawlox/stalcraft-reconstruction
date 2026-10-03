/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.tile;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.stalker.mobs.StalkerMobsMod;
import gloomyfolken.mods.stalker.mobs.spawn.MutantSpawnController;
import gloomyfolken.mods.stalker.mobs.spawn.MutantSpawnEntryInfo;
import gloomyfolken.mods.stalker.mobs.spawn.MutantSpawnerConfiguration;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020!H\u0016J\"\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\u0010\u0010*\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020!H\u0016J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020#H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006,"}, d2={"Lgloomyfolken/mods/stalker/mobs/tile/TileEntityMutantSpawner;", "Lgloomyfolken/mods/core/spawn/TileEntityStalkerSpawner;", "Lgloomyfolken/mods/stalker/mobs/spawn/MutantSpawnController;", "()V", "_configuration", "Lgloomyfolken/mods/stalker/mobs/spawn/MutantSpawnerConfiguration;", "get_configuration", "()Lgloomyfolken/mods/stalker/mobs/spawn/MutantSpawnerConfiguration;", "set_configuration", "(Lgloomyfolken/mods/stalker/mobs/spawn/MutantSpawnerConfiguration;)V", "author", "", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "wasApproved", "", "getWasApproved", "()Z", "setWasApproved", "(Z)V", "getConfiguration", "hasEditPermissions", "entityPlayer", "Lnet/minecraft/entity/player/EntityPlayer;", "initSpawnerTag", "", "tag", "Lgloomyfolken/mods/core/spawn/EntitySpawnerTag;", "entity", "Lnet/minecraft/entity/EntityLiving;", "readConfigTags", "Lnet/minecraft/nbt/NBTTagList;", "readSpawnerNbt", "Lnet/minecraft/nbt/NBTTagCompound;", "isRemoteEdit", "editAuthor", "setWorldObj", "world", "Lnet/minecraft/world/World;", "updateEntity", "writeConfigTags", "writeToNBT", "minecraft"})
public class TileEntityMutantSpawner
extends bqyt
implements MutantSpawnController {
    @NotNull
    private MutantSpawnerConfiguration _configuration = new MutantSpawnerConfiguration();
    private boolean wasApproved;
    @Nullable
    private String author;

    @NotNull
    protected final MutantSpawnerConfiguration get_configuration() {
        return this._configuration;
    }

    protected final void set_configuration(@NotNull MutantSpawnerConfiguration mutantSpawnerConfiguration) {
        Intrinsics.checkParameterIsNotNull(mutantSpawnerConfiguration, "<set-?>");
        this._configuration = mutantSpawnerConfiguration;
    }

    public final boolean getWasApproved() {
        return this.wasApproved;
    }

    public final void setWasApproved(boolean bl) {
        this.wasApproved = bl;
    }

    @Nullable
    public final String getAuthor() {
        return this.author;
    }

    public final void setAuthor(@Nullable String string) {
        this.author = string;
    }

    @Override
    public void updateEntity() {
        if (!StalkerMobsMod.getNoMobs()) {
            super.updateEntity();
        }
    }

    @Override
    @NotNull
    public MutantSpawnerConfiguration getConfiguration() {
        return this._configuration;
    }

    @Override
    public boolean hasEditPermissions(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "entityPlayer");
        return this.hasAdvancedPermissions(entityPlayer) || !this.wasApproved && Intrinsics.areEqual(entityPlayer.getCommandSenderName(), this.author);
    }

    @Override
    public void setWorldObj(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        super.setWorldObj(world);
        if (!world.isRemote) {
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this){
                final /* synthetic */ TileEntityMutantSpawner this$0;

                public final void run() {
                }
                {
                    this.this$0 = tileEntityMutantSpawner;
                }
            });
        }
    }

    public void initSpawnerTag(@NotNull ncwn ncwn2, @Nullable EntityLiving entityLiving) {
        Intrinsics.checkParameterIsNotNull(ncwn2, "tag");
        Collection collection = ncwn2._f();
        kksf kksf2 = new kksf(new Point(this.xCoord + this.getXMin(), this.zCoord + this.getZMin()), new Point(this.xCoord + this.getXMax(), this.zCoord + this.getZMin()), new Point(this.xCoord + this.getXMax(), this.zCoord + this.getZMax()));
        collection.add(kksf2);
        collection = ncwn2._f();
        kksf2 = new kksf(new Point(this.xCoord + this.getXMax(), this.zCoord + this.getZMax()), new Point(this.xCoord + this.getXMin(), this.zCoord + this.getZMax()), new Point(this.xCoord + this.getXMin(), this.zCoord + this.getZMin()));
        collection.add(kksf2);
        ncwn2._d(this.yCoord + this.getYMin());
        ncwn2._e(this.yCoord + this.getYMax());
        ncwn2._a(true);
    }

    @Override
    public void writeToNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("spawnenabled", this.getSpawnEnabled());
        String string = this.author;
        if (string == null) {
            string = "";
        }
        nBTTagCompound._a("author", string);
        nBTTagCompound._a("wasApproved", this.wasApproved);
    }

    @Override
    public void readSpawnerNbt(@NotNull NBTTagCompound nBTTagCompound, boolean bl, @Nullable EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        super.readSpawnerNbt(nBTTagCompound, bl, entityPlayer);
        this.setSpawnEnabled(nBTTagCompound._o("spawnenabled"));
        if (!bl || entityPlayer != null && this.hasAdvancedPermissions(entityPlayer)) {
            this.author = owkq._a(nBTTagCompound._j("author"));
            this.wasApproved = nBTTagCompound._o("wasApproved");
        }
    }

    @Override
    public void readConfigTags(@NotNull NBTTagList nBTTagList) {
        Intrinsics.checkParameterIsNotNull(nBTTagList, "tag");
        Iterator iterator = nBTTagList._c.iterator();
        while (iterator.hasNext()) {
            Object e;
            Object e2 = e = iterator.next();
            if (e2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
            }
            NBTTagCompound nBTTagCompound = (NBTTagCompound)e2;
            ArrayList<qman> arrayList = this._configuration.getPossibleSpawnEntries();
            String string = nBTTagCompound._j("name");
            Intrinsics.checkExpressionValueIsNotNull(string, "nbt.getString(\"name\")");
            arrayList.add(new MutantSpawnEntryInfo(string, nBTTagCompound._h("weight")));
        }
    }

    @Override
    @NotNull
    public NBTTagList writeConfigTags(@NotNull NBTTagList nBTTagList) {
        Intrinsics.checkParameterIsNotNull(nBTTagList, "tag");
        for (qman qman2 : this._configuration.getPossibleSpawnEntries()) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("name", qman2.getConfigurationName());
            nBTTagCompound._a("weight", qman2.getWeight());
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public TileEntityMutantSpawner() {
        this.setSpawnEnabled(false);
    }
}

