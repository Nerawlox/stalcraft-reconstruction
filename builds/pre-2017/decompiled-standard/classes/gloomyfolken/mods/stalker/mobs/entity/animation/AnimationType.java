/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.animation;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.AnimationState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0017"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationType;", "", "factory", "Lkotlin/Function1;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "Lgloomyfolken/mods/stalker/mobs/entity/animation/state/AnimationState;", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "getFactory", "()Lkotlin/jvm/functions/Function1;", "createState", "entityMutant", "ATTACK_JUMP", "VAMPIRE_KISS", "CUSTOM", "CHECK_CORPSE", "SCARE", "THREAT", "REST", "TURN_STAND_JUMP", "TURN_BRAKE", "STOMP", "MOVE", "IDLE", "minecraft"})
public final class AnimationType
extends Enum<AnimationType> {
    public static final /* enum */ AnimationType ATTACK_JUMP;
    public static final /* enum */ AnimationType VAMPIRE_KISS;
    public static final /* enum */ AnimationType CUSTOM;
    public static final /* enum */ AnimationType CHECK_CORPSE;
    public static final /* enum */ AnimationType SCARE;
    public static final /* enum */ AnimationType THREAT;
    public static final /* enum */ AnimationType REST;
    public static final /* enum */ AnimationType TURN_STAND_JUMP;
    public static final /* enum */ AnimationType TURN_BRAKE;
    public static final /* enum */ AnimationType STOMP;
    public static final /* enum */ AnimationType MOVE;
    public static final /* enum */ AnimationType IDLE;
    private static final /* synthetic */ AnimationType[] $VALUES;
    @NotNull
    private final Function1<EntityMutant, AnimationState> factory;

    static {
        AnimationType[] animationTypeArray = new AnimationType[12];
        AnimationType[] animationTypeArray2 = animationTypeArray;
        animationTypeArray[0] = ATTACK_JUMP = new AnimationType(1.INSTANCE);
        animationTypeArray[1] = VAMPIRE_KISS = new AnimationType(2.INSTANCE);
        animationTypeArray[2] = CUSTOM = new AnimationType(3.INSTANCE);
        animationTypeArray[3] = CHECK_CORPSE = new AnimationType(4.INSTANCE);
        animationTypeArray[4] = SCARE = new AnimationType(5.INSTANCE);
        animationTypeArray[5] = THREAT = new AnimationType(6.INSTANCE);
        animationTypeArray[6] = REST = new AnimationType(7.INSTANCE);
        animationTypeArray[7] = TURN_STAND_JUMP = new AnimationType(8.INSTANCE);
        animationTypeArray[8] = TURN_BRAKE = new AnimationType(9.INSTANCE);
        animationTypeArray[9] = STOMP = new AnimationType(10.INSTANCE);
        animationTypeArray[10] = MOVE = new AnimationType(11.INSTANCE);
        animationTypeArray[11] = IDLE = new AnimationType(12.INSTANCE);
        $VALUES = animationTypeArray;
    }

    @NotNull
    public final AnimationState createState(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "entityMutant");
        return this.factory.invoke(entityMutant);
    }

    @NotNull
    public final Function1<EntityMutant, AnimationState> getFactory() {
        return this.factory;
    }

    protected AnimationType(@NotNull Function1<? super EntityMutant, ? extends AnimationState> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        this.factory = function1;
    }

    public static AnimationType[] values() {
        return (AnimationType[])$VALUES.clone();
    }

    public static AnimationType valueOf(String string) {
        return Enum.valueOf(AnimationType.class, string);
    }
}

