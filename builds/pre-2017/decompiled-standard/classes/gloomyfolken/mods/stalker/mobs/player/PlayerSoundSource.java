/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.player;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.weapon.ugqx;
import gloomyfolken.mods.weapon.zwat;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u001c\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u00020\u0006*\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u00020\u0006*\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006$"}, d2={"Lgloomyfolken/mods/stalker/mobs/player/PlayerSoundSource;", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "(Lnet/minecraft/entity/player/EntityPlayer;)V", "noiseAmount", "", "getNoiseAmount", "()F", "setNoiseAmount", "(F)V", "noiseUpdate", "getNoiseUpdate", "setNoiseUpdate", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "noise", "Lgloomyfolken/mods/weapon/IGun;", "Lnet/minecraft/entity/Entity;", "getNoise", "(Lgloomyfolken/mods/weapon/IGun;)F", "silencedNoise", "getSilencedNoise", "addNoise", "", "amount", "clampNoise", "doAction", "doShot", "gun", "silenced", "", "getNoiseAmountForEntity", "entity", "updateSoundInfo", "Companion", "minecraft"})
public final class PlayerSoundSource {
    private float noiseAmount;
    private float noiseUpdate;
    @NotNull
    private final EntityPlayer player;
    @JvmField
    public static final float NOISE_AMOUNT_SHOT_SILENCED = 24.0f;
    @JvmField
    public static final float NOISE_AMOUNT_SHOT = 100.0f;
    @JvmField
    public static final float NOISE_AMOUNT_RUN = 24.0f;
    @JvmField
    public static final float NOISE_AMOUNT_WALK = 12.0f;
    @JvmField
    public static final float NOISE_AMOUNT_ACTION = 30.0f;
    @JvmField
    public static final float NOISE_AMOUNT_CRAWL = 8.0f;
    @JvmField
    public static final float NOISE_AMOUNT_LIE = 4.0f;
    @JvmField
    public static final float MAX_NOISE_AMOUNT = 500.0f;
    private static final float ADD_LOUDNESS_BASIC = 1.5f;
    private static final float ADD_LOUDNESS_STEALTH = 0.15f;
    private static final int MAX_LOUDNESS_TIME_REACH = 15;
    private static final float NOISE_PER_BLOCK_LOSS = 0.8f;
    private static final float NOISE_CURVE = 0.91f;
    public static final Companion Companion = new Companion(null);

    public final float getNoiseAmount() {
        return this.noiseAmount;
    }

    public final void setNoiseAmount(float f) {
        this.noiseAmount = f;
    }

    public final float getNoiseUpdate() {
        return this.noiseUpdate;
    }

    public final void setNoiseUpdate(float f) {
        this.noiseUpdate = f;
    }

    public final void updateSoundInfo() {
        this.noiseAmount *= PlayerSoundSource.Companion.getNOISE_CURVE();
        if (this.player.field_70170_p.field_72995_K) {
            return;
        }
        if (this.noiseAmount < 0.8f) {
            this.noiseAmount = 0.0f;
        }
        EntityPlayer entityPlayer = this.player;
        if (entityPlayer == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.player.EntityPlayerMP");
        }
        EntityPlayer entityPlayer2 = this.player;
        if (entityPlayer2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.player.EntityPlayerMP");
        }
        double d = owkq._c(((EntityPlayerMP)entityPlayer).field_71135_a.field_72579_o - VecExtensionsKt.getX(McExtensionsKt.getPos(this.player))) + owkq._c(((EntityPlayerMP)entityPlayer2).field_71135_a.field_72588_q - VecExtensionsKt.getZ(McExtensionsKt.getPos(this.player)));
        boolean bl = d < 1.0E-4;
        boolean bl2 = d > (double)0.15f;
        boolean bl3 = this.player.field_70131_O < 1.0f;
        boolean bl4 = ((EntityPlayerMP)this.player).func_70093_af();
        boolean bl5 = !bl2 && !bl3 && !bl4;
        float f = 0.0f;
        if (bl2 && !bl) {
            f = NOISE_AMOUNT_RUN - this.noiseAmount;
        } else if (bl3 && !bl) {
            f = NOISE_AMOUNT_LIE - this.noiseAmount;
        } else if (bl4 && !bl) {
            f = NOISE_AMOUNT_CRAWL - this.noiseAmount;
        } else if (bl5 && !bl) {
            f = NOISE_AMOUNT_WALK - this.noiseAmount;
        }
        ugqx ugqx2 = ugqx._a(this.player);
        if (ugqx2._n()) {
            f = NOISE_AMOUNT_ACTION - this.noiseAmount;
        }
        this.addNoise(RangesKt.coerceAtLeast(f, 0.0f));
        if (this.noiseUpdate > 0.0f) {
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this){
                final /* synthetic */ PlayerSoundSource this$0;

                public final void run() {
                }
                {
                    this.this$0 = playerSoundSource;
                }
            });
        }
        this.noiseUpdate = 0.0f;
    }

    public final void clampNoise() {
        if (this.noiseAmount > MAX_NOISE_AMOUNT) {
            this.noiseAmount = MAX_NOISE_AMOUNT;
        }
    }

    public final void doShot(@NotNull zwat<Entity> zwat2, boolean bl) {
        Intrinsics.checkParameterIsNotNull(zwat2, "gun");
        this.addNoise(bl ? this.getSilencedNoise(zwat2) : this.getNoise(zwat2));
    }

    private final float getSilencedNoise(@NotNull zwat<? extends Entity> zwat2) {
        return zwat2._y_() > 0.0f ? zwat2._y_() : NOISE_AMOUNT_SHOT_SILENCED;
    }

    private final float getNoise(@NotNull zwat<? extends Entity> zwat2) {
        return zwat2._x_() > 0.0f ? zwat2._x_() : NOISE_AMOUNT_SHOT;
    }

    public final void doAction() {
        this.addNoise(NOISE_AMOUNT_ACTION);
    }

    public final void addNoise(float f) {
        this.noiseAmount += f;
        this.noiseUpdate += f;
        this.clampNoise();
    }

    public final float getNoiseAmountForEntity(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        float f = this.player.func_70032_d(entity);
        float f2 = PlayerSoundSource.Companion.getNOISE_PER_BLOCK_LOSS();
        if (entity instanceof EntityMutant) {
            f2 = ((EntityMutant)entity).getProperties().getAi().getSoundLossPerBlock();
        }
        return owkq._b(this.noiseAmount - f * f2, 0.0f, MAX_NOISE_AMOUNT);
    }

    @NotNull
    public final EntityPlayer getPlayer() {
        return this.player;
    }

    public PlayerSoundSource(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        this.player = entityPlayer;
    }

    static {
        NOISE_AMOUNT_SHOT_SILENCED = 24.0f;
        NOISE_AMOUNT_SHOT = 100.0f;
        NOISE_AMOUNT_RUN = 24.0f;
        NOISE_AMOUNT_WALK = 12.0f;
        NOISE_AMOUNT_ACTION = 30.0f;
        NOISE_AMOUNT_CRAWL = 8.0f;
        NOISE_AMOUNT_LIE = 4.0f;
        MAX_NOISE_AMOUNT = 500.0f;
        ADD_LOUDNESS_BASIC = 1.5f;
        ADD_LOUDNESS_STEALTH = 0.15f;
        MAX_LOUDNESS_TIME_REACH = 15;
        NOISE_PER_BLOCK_LOSS = 0.8f;
        NOISE_CURVE = 0.91f;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/mods/stalker/mobs/player/PlayerSoundSource$Companion;", "", "()V", "ADD_LOUDNESS_BASIC", "", "getADD_LOUDNESS_BASIC", "()F", "ADD_LOUDNESS_STEALTH", "getADD_LOUDNESS_STEALTH", "MAX_LOUDNESS_TIME_REACH", "", "getMAX_LOUDNESS_TIME_REACH", "()I", "MAX_NOISE_AMOUNT", "NOISE_AMOUNT_ACTION", "NOISE_AMOUNT_CRAWL", "NOISE_AMOUNT_LIE", "NOISE_AMOUNT_RUN", "NOISE_AMOUNT_SHOT", "NOISE_AMOUNT_SHOT_SILENCED", "NOISE_AMOUNT_WALK", "NOISE_CURVE", "getNOISE_CURVE", "NOISE_PER_BLOCK_LOSS", "getNOISE_PER_BLOCK_LOSS", "minecraft"})
    public static final class Companion {
        private final float getADD_LOUDNESS_BASIC() {
            return ADD_LOUDNESS_BASIC;
        }

        private final float getADD_LOUDNESS_STEALTH() {
            return ADD_LOUDNESS_STEALTH;
        }

        private final int getMAX_LOUDNESS_TIME_REACH() {
            return MAX_LOUDNESS_TIME_REACH;
        }

        private final float getNOISE_PER_BLOCK_LOSS() {
            return NOISE_PER_BLOCK_LOSS;
        }

        private final float getNOISE_CURVE() {
            return NOISE_CURVE;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

