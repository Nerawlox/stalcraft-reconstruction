/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationProperty;
import gloomyfolken.mods.stalker.mobs.entity.config.AttackEffector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&\u00a8\u0006/"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/AttackConfig;", "", "()V", "animationName", "", "getAnimationName", "()Ljava/lang/String;", "setAnimationName", "(Ljava/lang/String;)V", "attackEffector", "Lgloomyfolken/mods/stalker/mobs/entity/config/AttackEffector;", "getAttackEffector", "()Lgloomyfolken/mods/stalker/mobs/entity/config/AttackEffector;", "setAttackEffector", "(Lgloomyfolken/mods/stalker/mobs/entity/config/AttackEffector;)V", "impulse", "", "getImpulse", "()D", "setImpulse", "(D)V", "impulseDirX", "getImpulseDirX", "setImpulseDirX", "impulseDirY", "getImpulseDirY", "setImpulseDirY", "impulseDirZ", "getImpulseDirZ", "setImpulseDirZ", "movementType", "getMovementType", "setMovementType", "rotationLimit", "", "getRotationLimit", "()F", "setRotationLimit", "(F)V", "timeOfAttack", "getTimeOfAttack", "setTimeOfAttack", "getAnimation", "Lgloomyfolken/mods/stalker/mobs/entity/animation/AnimationProperty;", "entityMutant", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "toString", "minecraft"})
public final class AttackConfig {
    @SerializedName(value="timeOfAttack")
    private float timeOfAttack = 0.3f;
    @SerializedName(value="rotationLimit")
    private float rotationLimit;
    @SerializedName(value="animationName")
    @NotNull
    private String animationName = "attack_stand";
    @SerializedName(value="movementType")
    @NotNull
    private String movementType = "stand";
    @SerializedName(value="impulse")
    private double impulse;
    @SerializedName(value="impulseDirX")
    private double impulseDirX;
    @SerializedName(value="impulseDirY")
    private double impulseDirY;
    @SerializedName(value="impulseDirZ")
    private double impulseDirZ;
    @SerializedName(value="effector")
    @NotNull
    private AttackEffector attackEffector = new AttackEffector();

    public final float getTimeOfAttack() {
        return this.timeOfAttack;
    }

    public final void setTimeOfAttack(float f) {
        this.timeOfAttack = f;
    }

    public final float getRotationLimit() {
        return this.rotationLimit;
    }

    public final void setRotationLimit(float f) {
        this.rotationLimit = f;
    }

    @NotNull
    public final String getAnimationName() {
        return this.animationName;
    }

    public final void setAnimationName(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this.animationName = string;
    }

    @NotNull
    public final String getMovementType() {
        return this.movementType;
    }

    public final void setMovementType(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this.movementType = string;
    }

    public final double getImpulse() {
        return this.impulse;
    }

    public final void setImpulse(double d) {
        this.impulse = d;
    }

    public final double getImpulseDirX() {
        return this.impulseDirX;
    }

    public final void setImpulseDirX(double d) {
        this.impulseDirX = d;
    }

    public final double getImpulseDirY() {
        return this.impulseDirY;
    }

    public final void setImpulseDirY(double d) {
        this.impulseDirY = d;
    }

    public final double getImpulseDirZ() {
        return this.impulseDirZ;
    }

    public final void setImpulseDirZ(double d) {
        this.impulseDirZ = d;
    }

    @NotNull
    public final AttackEffector getAttackEffector() {
        return this.attackEffector;
    }

    public final void setAttackEffector(@NotNull AttackEffector attackEffector) {
        Intrinsics.checkParameterIsNotNull(attackEffector, "<set-?>");
        this.attackEffector = attackEffector;
    }

    @Nullable
    public final AnimationProperty getAnimation(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "entityMutant");
        return entityMutant.findAnimation(this.animationName);
    }

    @NotNull
    public String toString() {
        return "[ATTACK_CONFIG: animation = " + this.animationName + ", movementType = " + this.movementType + ", time = " + this.timeOfAttack + ']';
    }
}

