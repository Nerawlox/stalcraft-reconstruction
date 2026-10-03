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
    public void func_70316_g() {
        if (!StalkerMobsMod.getNoMobs()) {
            super.func_70316_g();
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
        return this.hasAdvancedPermissions(entityPlayer) || !this.wasApproved && Intrinsics.areEqual(entityPlayer.func_70005_c_(), this.author);
    }

    @Override
    public void func_70308_a(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        super.func_70308_a(ozlu2);
        if (!ozlu2.field_72995_K) {
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
        kksf kksf2 = new kksf(new Point(this.field_70329_l + this.getXMin(), this.field_70327_n + this.getZMin()), new Point(this.field_70329_l + this.getXMax(), this.field_70327_n + this.getZMin()), new Point(this.field_70329_l + this.getXMax(), this.field_70327_n + this.getZMax()));
        collection.add(kksf2);
        collection = ncwn2._f();
        kksf2 = new kksf(new Point(this.field_70329_l + this.getXMax(), this.field_70327_n + this.getZMax()), new Point(this.field_70329_l + this.getXMin(), this.field_70327_n + this.getZMax()), new Point(this.field_70329_l + this.getXMin(), this.field_70327_n + this.getZMin()));
        collection.add(kksf2);
        ncwn2._d(this.field_70330_m + this.getYMin());
        ncwn2._e(this.field_70330_m + this.getYMax());
        ncwn2._a(true);
    }

    @Override
    public void func_70310_b(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.func_70310_b(qoac2);
        qoac2._a("spawnenabled", this.getSpawnEnabled());
        String string = this.author;
        if (string == null) {
            string = "";
        }
        qoac2._a("author", string);
        qoac2._a("wasApproved", this.wasApproved);
    }

    @Override
    public void readSpawnerNbt(@NotNull qoac qoac2, boolean bl, @Nullable EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.readSpawnerNbt(qoac2, bl, entityPlayer);
        this.setSpawnEnabled(qoac2._o("spawnenabled"));
        if (!bl || entityPlayer != null && this.hasAdvancedPermissions(entityPlayer)) {
            this.author = owkq._a(qoac2._j("author"));
            this.wasApproved = qoac2._o("wasApproved");
        }
    }

    @Override
    public void readConfigTags(@NotNull bsyv bsyv2) {
        Intrinsics.checkParameterIsNotNull(bsyv2, "tag");
        Iterator iterator = bsyv2._c.iterator();
        while (iterator.hasNext()) {
            Object e;
            Object e2 = e = iterator.next();
            if (e2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
            }
            qoac qoac2 = (qoac)e2;
            ArrayList<qman> arrayList = this._configuration.getPossibleSpawnEntries();
            String string = qoac2._j("name");
            Intrinsics.checkExpressionValueIsNotNull(string, "nbt.getString(\"name\")");
            arrayList.add(new MutantSpawnEntryInfo(string, qoac2._h("weight")));
        }
    }

    @Override
    @NotNull
    public bsyv writeConfigTags(@NotNull bsyv bsyv2) {
        Intrinsics.checkParameterIsNotNull(bsyv2, "tag");
        for (qman qman2 : this._configuration.getPossibleSpawnEntries()) {
            qoac qoac2 = new qoac();
            qoac2._a("name", qman2.getConfigurationName());
            qoac2._a("weight", qman2.getWeight());
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public TileEntityMutantSpawner() {
        this.setSpawnEnabled(false);
    }
}

