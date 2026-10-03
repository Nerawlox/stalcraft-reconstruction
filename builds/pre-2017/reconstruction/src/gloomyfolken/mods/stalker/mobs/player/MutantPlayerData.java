/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.player;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.stalker.mobs.player.PlayerSoundSource;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawnerSpecial;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0007J\u0010\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u0006J\b\u0010!\u001a\u00020\u001bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006#"}, d2={"Lgloomyfolken/mods/stalker/mobs/player/MutantPlayerData;", "Lgloomyfolken/mods/core/player/PlayerHandler;", "info", "Lgloomyfolken/mods/core/player/PlayerInfo;", "(Lgloomyfolken/mods/core/player/PlayerInfo;)V", "configTargetTileEntity", "Lgloomyfolken/mods/stalker/mobs/tile/TileEntityMutantSpawnerSpecial;", "editingSpawnerX", "", "editingSpawnerY", "editingSpawnerZ", "soundSource", "Lgloomyfolken/mods/stalker/mobs/player/PlayerSoundSource;", "getSoundSource", "()Lgloomyfolken/mods/stalker/mobs/player/PlayerSoundSource;", "vampireSuckTimeLeft", "getVampireSuckTimeLeft", "()I", "setVampireSuckTimeLeft", "(I)V", "getConfigTarget", "getNoiseAmountForEntity", "", "entity", "Lnet/minecraft/entity/Entity;", "lastOpenedSpawner", "onActivatedSpawner", "", "tile", "Lnet/minecraft/tileentity/TileEntity;", "resetEffectEvents", "setConfigTarget", "tileEntity", "tick", "Companion", "minecraft"})
public final class MutantPlayerData
extends tehy {
    @NotNull
    private final PlayerSoundSource soundSource;
    private int editingSpawnerX;
    private int editingSpawnerY;
    private int editingSpawnerZ;
    private TileEntityMutantSpawnerSpecial configTargetTileEntity;
    private int vampireSuckTimeLeft;
    @JvmField
    @NotNull
    public static final String ID = "MUTANT_PLAYER_DATA";
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final PlayerSoundSource getSoundSource() {
        return this.soundSource;
    }

    public final int getVampireSuckTimeLeft() {
        return this.vampireSuckTimeLeft;
    }

    public final void setVampireSuckTimeLeft(int n) {
        this.vampireSuckTimeLeft = n;
    }

    @Override
    public void tick() {
        super.tick();
        this.soundSource.updateSoundInfo();
        if (!this.player.worldObj.isRemote) {
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this){
                final /* synthetic */ MutantPlayerData this$0;

                public final void run() {
                }
                {
                    this.this$0 = mutantPlayerData;
                }
            });
        }
    }

    public final void onActivatedSpawner(@Nullable TileEntity tileEntity) {
        if (tileEntity instanceof TileEntityMutantSpawnerSpecial) {
            this.editingSpawnerX = tileEntity.xCoord;
            this.editingSpawnerY = tileEntity.yCoord;
            this.editingSpawnerZ = tileEntity.zCoord;
        } else {
            this.editingSpawnerX = 0;
            this.editingSpawnerY = 0;
            this.editingSpawnerZ = 0;
        }
    }

    public final void setConfigTarget(@Nullable TileEntityMutantSpawnerSpecial tileEntityMutantSpawnerSpecial) {
        this.configTargetTileEntity = tileEntityMutantSpawnerSpecial;
    }

    @Nullable
    public final TileEntityMutantSpawnerSpecial lastOpenedSpawner() {
        TileEntity tileEntity = this.player.worldObj.getBlockTileEntity(this.editingSpawnerX, this.editingSpawnerY, this.editingSpawnerZ);
        if (!(tileEntity instanceof TileEntityMutantSpawnerSpecial)) {
            tileEntity = null;
        }
        return (TileEntityMutantSpawnerSpecial)tileEntity;
    }

    @Nullable
    public final TileEntityMutantSpawnerSpecial getConfigTarget() {
        return this.configTargetTileEntity;
    }

    public final float getNoiseAmountForEntity(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return this.soundSource.getNoiseAmountForEntity(entity);
    }

    public MutantPlayerData(@NotNull ccxr ccxr2) {
        Intrinsics.checkParameterIsNotNull(ccxr2, "info");
        super(ccxr2);
        EntityPlayer entityPlayer = this.player;
        Intrinsics.checkExpressionValueIsNotNull(entityPlayer, "player");
        this.soundSource = new PlayerSoundSource(entityPlayer);
    }

    static {
        ID = ID;
    }

    @JvmStatic
    @Nullable
    public static final MutantPlayerData get(@Nullable ccxr ccxr2) {
        return Companion.get(ccxr2);
    }

    @JvmStatic
    @Nullable
    public static final MutantPlayerData get(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        return Companion.get(entityPlayer);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/stalker/mobs/player/MutantPlayerData$Companion;", "", "()V", "ID", "", "get", "Lgloomyfolken/mods/stalker/mobs/player/MutantPlayerData;", "info", "Lgloomyfolken/mods/core/player/PlayerInfo;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "minecraft"})
    public static final class Companion {
        @JvmStatic
        @Nullable
        public final MutantPlayerData get(@Nullable ccxr ccxr2) {
            tehy tehy2;
            Object object = ccxr2;
            if (!((object != null && (object = ((ccxr)object)._h) != null ? (tehy)((HashMap)object).get(ID) : (tehy2 = null)) instanceof MutantPlayerData)) {
                tehy2 = null;
            }
            return (MutantPlayerData)tehy2;
        }

        @JvmStatic
        @Nullable
        public final MutantPlayerData get(@NotNull EntityPlayer entityPlayer) {
            Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
            return this.get(ncwh._a(entityPlayer));
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

