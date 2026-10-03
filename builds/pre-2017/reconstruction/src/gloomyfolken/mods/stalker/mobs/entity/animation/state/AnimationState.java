/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.animation.state;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationProperty;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationType;
import gloomyfolken.mods.stalker.mobs.entity.animation.EnumPlayMode;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.LogicState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 T2\u00020\u0001:\u0001TB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u00104\u001a\u00020'H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\nH\u0016J\b\u00107\u001a\u000208H\u0016J\u0006\u00109\u001a\u000208J\u0006\u0010:\u001a\u000208J\n\u0010;\u001a\u0004\u0018\u00010<H\u0007J\b\u0010=\u001a\u00020\u0006H\u0016J\u001a\u0010>\u001a\u0004\u0018\u00010\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u0016H\u0016J\u0006\u0010A\u001a\u00020'J\b\u0010B\u001a\u00020'H\u0016J\u0006\u0010C\u001a\u000208J\u0010\u0010D\u001a\u0002082\u0006\u00106\u001a\u00020\nH\u0016J\u001a\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020\n2\b\b\u0002\u0010G\u001a\u00020HH\u0016J\u0006\u0010I\u001a\u000208J\u0010\u0010J\u001a\u0002082\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u000208H\u0007J\u0012\u0010N\u001a\u0002082\b\u0010O\u001a\u0004\u0018\u00010<H\u0007J\u0010\u0010P\u001a\u00020'2\u0006\u00106\u001a\u00020\nH\u0016J\b\u0010Q\u001a\u000208H\u0016J\u0006\u0010R\u001a\u000208J\u0010\u0010S\u001a\u0002082\u0006\u0010K\u001a\u00020LH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0085\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010(R(\u0010)\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u000e\u0010/\u001a\u00020'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u00100\u001a\u00020'2\u0006\u0010\t\u001a\u00020'@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u00103\u00a8\u0006U"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/animation/state/AnimationState;", "", "entity", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "MAGIC_SPEED_VALUE", "", "getMAGIC_SPEED_VALUE", "()F", "<set-?>", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "activeAnimation", "getActiveAnimation", "()Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "setActiveAnimation", "(Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;)V", "activeAnimationClip", "getActiveAnimationClip", "()Ljava/lang/Object;", "setActiveAnimationClip", "(Ljava/lang/Object;)V", "animationDuration", "", "getAnimationDuration", "()I", "setAnimationDuration", "(I)V", "animationTicksLeft", "getAnimationTicksLeft", "setAnimationTicksLeft", "animationType", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationType;", "getAnimationType", "()Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationType;", "setAnimationType", "(Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationType;)V", "getEntity", "()Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "isClient", "", "()Z", "nextAnimation", "getNextAnimation", "setNextAnimation", "randomAnimationIndex", "getRandomAnimationIndex", "setRandomAnimationIndex", "shouldSendUpdate", "stateActive", "getStateActive", "setStateActive", "(Z)V", "blocksMovement", "calculateAnimationSpeed", "animation", "execute", "", "exit", "generateNextRandomAnimationIndex", "getActiveClip", "Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationEntryClip;", "getMovementSpeedFactor", "getRandomAnimation", "baseAnimation", "index", "hasAnimationEnded", "isInterruptible", "markDirty", "onAnimationEnd", "playAnimation", "animationProperty", "blendMode", "Lgloomyfolken/mods/stalker/mobs/entity/animation/EnumPlayMode;", "playNextAnimation", "readNbt", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "sendUpdatesIfNeeded", "setActiveClip", "clip", "shouldAnimationLoop", "tickAnimation", "updateState", "writeNbt", "Companion", "minecraft"})
public abstract class AnimationState {
    private final float MAGIC_SPEED_VALUE = 12.121212f;
    private boolean shouldSendUpdate;
    private int animationTicksLeft;
    private int animationDuration;
    private final boolean isClient;
    private boolean stateActive;
    @Nullable
    private AnimationProperty nextAnimation;
    @Nullable
    private AnimationProperty activeAnimation;
    @Nullable
    private AnimationType animationType;
    @ezey(_a={eidj.CLIENT})
    @Nullable
    private Object activeAnimationClip;
    private int randomAnimationIndex;
    @NotNull
    private final EntityMutant entity;
    @NotNull
    private static final String ID_CUSTOM_ANIM = "0";
    @NotNull
    private static final String ID_REST_STAGE = "1";
    @NotNull
    private static final String ID_RAND_INDEX = "2";
    @NotNull
    private static final String ID_LOOP_INDEX = "3";
    @NotNull
    private static final String ID_LONG_ANIM_NAME = "4";
    public static final Companion Companion = new Companion(null);

    protected final float getMAGIC_SPEED_VALUE() {
        return this.MAGIC_SPEED_VALUE;
    }

    protected final int getAnimationTicksLeft() {
        return this.animationTicksLeft;
    }

    protected final void setAnimationTicksLeft(int n) {
        this.animationTicksLeft = n;
    }

    protected final int getAnimationDuration() {
        return this.animationDuration;
    }

    protected final void setAnimationDuration(int n) {
        this.animationDuration = n;
    }

    protected final boolean isClient() {
        return this.isClient;
    }

    public final boolean getStateActive() {
        return this.stateActive;
    }

    private final void setStateActive(boolean bl) {
        this.stateActive = bl;
    }

    @Nullable
    public final AnimationProperty getNextAnimation() {
        return this.nextAnimation;
    }

    protected final void setNextAnimation(@Nullable AnimationProperty animationProperty) {
        this.nextAnimation = animationProperty;
    }

    @Nullable
    public final AnimationProperty getActiveAnimation() {
        return this.activeAnimation;
    }

    private final void setActiveAnimation(AnimationProperty animationProperty) {
        this.activeAnimation = animationProperty;
    }

    @Nullable
    public final AnimationType getAnimationType() {
        return this.animationType;
    }

    public final void setAnimationType(@Nullable AnimationType animationType) {
        this.animationType = animationType;
    }

    @ezey(_a={eidj.CLIENT})
    @Nullable
    protected final Object getActiveAnimationClip() {
        return this.activeAnimationClip;
    }

    @ezey(_a={eidj.CLIENT})
    protected final void setActiveAnimationClip(@Nullable Object object) {
        this.activeAnimationClip = object;
    }

    public final int getRandomAnimationIndex() {
        return this.randomAnimationIndex;
    }

    public final void setRandomAnimationIndex(int n) {
        this.randomAnimationIndex = n;
    }

    @ezey(_a={eidj.CLIENT})
    @Nullable
    public final jytp getActiveClip() {
        Object object = this.activeAnimationClip;
        if (!(object instanceof jytp)) {
            object = null;
        }
        return (jytp)object;
    }

    @ezey(_a={eidj.CLIENT})
    public final void setActiveClip(@Nullable jytp jytp2) {
        this.activeAnimationClip = jytp2;
    }

    public final void updateState() {
        if (this.stateActive) {
            this.tickAnimation();
        }
    }

    public void tickAnimation() {
        if (this.animationTicksLeft > 0) {
            int n = this.animationTicksLeft;
            this.animationTicksLeft = n + -1;
            if (this.animationTicksLeft == 0 && this.activeAnimation != null) {
                AnimationProperty animationProperty = this.activeAnimation;
                if (animationProperty == null) {
                    Intrinsics.throwNpe();
                }
                this.onAnimationEnd(animationProperty);
                this.activeAnimation = null;
                this.playNextAnimation();
            }
        }
    }

    public void onAnimationEnd(@NotNull AnimationProperty animationProperty) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animation");
    }

    public void execute() {
        this.playNextAnimation();
        this.markDirty();
    }

    @Nullable
    public AnimationProperty getRandomAnimation(@NotNull AnimationProperty animationProperty, int n) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "baseAnimation");
        if (n < 0) {
            return animationProperty;
        }
        int n2 = 1;
        String string = n > 0 ? "" + '#' + (n - 1) % n2 : "";
        return this.entity.findAnimation("" + animationProperty.getBaseAnimationName() + "" + string);
    }

    public final void playNextAnimation() {
        if (this.nextAnimation != null) {
            AnimationProperty animationProperty;
            AnimationProperty animationProperty2 = this.nextAnimation;
            if (animationProperty2 == null) {
                Intrinsics.throwNpe();
            }
            if ((animationProperty = this.getRandomAnimation(animationProperty2, this.randomAnimationIndex)) != null) {
                AnimationState.playAnimation$default(this, animationProperty, null, 2, null);
            } else {
                AnimationProperty animationProperty3 = this.nextAnimation;
                if (animationProperty3 == null) {
                    Intrinsics.throwNpe();
                }
                AnimationState.playAnimation$default(this, animationProperty3, null, 2, null);
            }
        }
    }

    public final void generateNextRandomAnimationIndex() {
        this.randomAnimationIndex = this.entity.getRNG().nextInt(10);
        this.markDirty();
    }

    public final void markDirty() {
        this.shouldSendUpdate = true;
    }

    public final void exit() {
        this.stateActive = false;
    }

    public final boolean hasAnimationEnded() {
        return this.animationTicksLeft <= 0;
    }

    public boolean blocksMovement() {
        return this.entity.getLogicState().getMovementBlocked();
    }

    public void writeNbt(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        nBTTagCompound._a(Companion.getID_RAND_INDEX(), (byte)this.randomAnimationIndex);
    }

    public void readNbt(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        this.randomAnimationIndex = nBTTagCompound._d(Companion.getID_RAND_INDEX());
    }

    public boolean isInterruptible() {
        return this.hasAnimationEnded() || !this.stateActive;
    }

    public float calculateAnimationSpeed(@NotNull AnimationProperty animationProperty) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animation");
        float f = 1.0f;
        if (this.entity.getLogicState() != LogicState.STAND) {
            f *= this.entity.getProperties().getMovement().getMovementSpeed() * this.MAGIC_SPEED_VALUE;
            f *= this.getMovementSpeedFactor();
            f /= this.entity.getProperties().getCommon().getScale();
        }
        return f;
    }

    public boolean shouldAnimationLoop(@NotNull AnimationProperty animationProperty) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animation");
        return false;
    }

    public float getMovementSpeedFactor() {
        return this.entity.getLogicState().getSpeedFactor(this.entity.getProperties()) * this.entity.getLogicState().getInverseSpeedFactor();
    }

    public void playAnimation(@NotNull AnimationProperty animationProperty, @NotNull EnumPlayMode enumPlayMode) {
        Intrinsics.checkParameterIsNotNull(animationProperty, "animationProperty");
        Intrinsics.checkParameterIsNotNull((Object)enumPlayMode, "blendMode");
        float f = this.calculateAnimationSpeed(animationProperty);
        InvokeSideOnly.client(this.isClient, new InvokeSideOnly.InvokeClientOnly(this, animationProperty, enumPlayMode, f){
            final /* synthetic */ AnimationState this$0;
            final /* synthetic */ AnimationProperty $animationProperty;
            final /* synthetic */ EnumPlayMode $blendMode;
            final /* synthetic */ float $speedModifier;

            public final void run() {
                this.this$0.setActiveClip(this.this$0.getEntity().getAnimationHandler().playAnimation(this.$animationProperty, this.$blendMode, this.$speedModifier, this.this$0.shouldAnimationLoop(this.$animationProperty)));
            }
            {
                this.this$0 = animationState;
                this.$animationProperty = animationProperty;
                this.$blendMode = enumPlayMode;
                this.$speedModifier = f;
            }
        });
        this.animationDuration = this.animationTicksLeft = (int)((float)animationProperty.getDuration() / (animationProperty.getAnimationSpeed() * f));
        this.activeAnimation = animationProperty;
        this.entity.setLastPlayedAnimation(animationProperty);
    }

    public static /* synthetic */ void playAnimation$default(AnimationState animationState, AnimationProperty animationProperty, EnumPlayMode enumPlayMode, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playAnimation");
        }
        if ((n & 2) != 0) {
            enumPlayMode = EnumPlayMode.BLEND_IN;
        }
        animationState.playAnimation(animationProperty, enumPlayMode);
    }

    @NotNull
    public final EntityMutant getEntity() {
        return this.entity;
    }

    public AnimationState(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "entity");
        this.entity = entityMutant;
        this.MAGIC_SPEED_VALUE = 12.121212f;
        this.animationDuration = -1;
        this.isClient = this.entity.worldObj.isRemote;
        this.stateActive = true;
        this.randomAnimationIndex = -1;
    }

    static {
        ID_CUSTOM_ANIM = ID_CUSTOM_ANIM;
        ID_REST_STAGE = ID_REST_STAGE;
        ID_RAND_INDEX = ID_RAND_INDEX;
        ID_LOOP_INDEX = ID_LOOP_INDEX;
        ID_LONG_ANIM_NAME = ID_LONG_ANIM_NAME;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0084\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/animation/state/AnimationState$Companion;", "", "()V", "ID_CUSTOM_ANIM", "", "getID_CUSTOM_ANIM", "()Ljava/lang/String;", "ID_LONG_ANIM_NAME", "getID_LONG_ANIM_NAME", "ID_LOOP_INDEX", "getID_LOOP_INDEX", "ID_RAND_INDEX", "getID_RAND_INDEX", "ID_REST_STAGE", "getID_REST_STAGE", "minecraft"})
    protected static final class Companion {
        @NotNull
        public final String getID_CUSTOM_ANIM() {
            return ID_CUSTOM_ANIM;
        }

        @NotNull
        public final String getID_REST_STAGE() {
            return ID_REST_STAGE;
        }

        @NotNull
        public final String getID_RAND_INDEX() {
            return ID_RAND_INDEX;
        }

        @NotNull
        public final String getID_LOOP_INDEX() {
            return ID_LOOP_INDEX;
        }

        @NotNull
        public final String getID_LONG_ANIM_NAME() {
            return ID_LONG_ANIM_NAME;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

