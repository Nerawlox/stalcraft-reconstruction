/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.animation.state;

import gloomyfolken.mods.stalker.mobs.entity.animation.state.LogicState$WhenMappings;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/animation/state/LogicState;", "", "movementBlocked", "", "(Ljava/lang/String;IZ)V", "getMovementBlocked", "()Z", "getInverseSpeedFactor", "", "getInverseTurnFactor", "getMovementFactor", "configuration", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "getSpeedFactor", "getTurnFactor", "STAND", "WALK", "WALK_BACK", "RUN", "CRAWL", "minecraft"})
public final class LogicState
extends Enum<LogicState> {
    public static final /* enum */ LogicState STAND;
    public static final /* enum */ LogicState WALK;
    public static final /* enum */ LogicState WALK_BACK;
    public static final /* enum */ LogicState RUN;
    public static final /* enum */ LogicState CRAWL;
    private static final /* synthetic */ LogicState[] $VALUES;
    private final boolean movementBlocked;

    static {
        LogicState[] logicStateArray = new LogicState[5];
        LogicState[] logicStateArray2 = logicStateArray;
        logicStateArray[0] = STAND = new LogicState(true);
        logicStateArray[1] = WALK = new LogicState(false);
        logicStateArray[2] = WALK_BACK = new LogicState(false);
        logicStateArray[3] = RUN = new LogicState(false);
        logicStateArray[4] = CRAWL = new LogicState(false);
        $VALUES = logicStateArray;
    }

    public final float getMovementFactor(@NotNull MutantConfiguration mutantConfiguration) {
        float f;
        Intrinsics.checkParameterIsNotNull(mutantConfiguration, "configuration");
        switch (LogicState$WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: {
                f = 1.0f;
                break;
            }
            case 2: {
                f = mutantConfiguration.getMovement().getWalkBackSpeedFactor();
                break;
            }
            case 3: {
                f = mutantConfiguration.getMovement().getRunSpeedFactor();
                break;
            }
            case 4: {
                f = mutantConfiguration.getMovement().getCrawlSpeedFactor();
                break;
            }
            default: {
                f = 0.0f;
            }
        }
        return f;
    }

    public final float getSpeedFactor(@NotNull MutantConfiguration mutantConfiguration) {
        float f;
        Intrinsics.checkParameterIsNotNull(mutantConfiguration, "configuration");
        switch (LogicState$WhenMappings.$EnumSwitchMapping$1[this.ordinal()]) {
            case 1: {
                f = 1.0f;
                break;
            }
            default: {
                f = this.getMovementFactor(mutantConfiguration);
            }
        }
        return f;
    }

    public final float getTurnFactor(@NotNull MutantConfiguration mutantConfiguration) {
        float f;
        Intrinsics.checkParameterIsNotNull(mutantConfiguration, "configuration");
        switch (LogicState$WhenMappings.$EnumSwitchMapping$2[this.ordinal()]) {
            case 1: {
                f = 1.0f;
                break;
            }
            case 2: {
                f = mutantConfiguration.getTurn().getStandTurnFactor();
                break;
            }
            case 3: {
                f = mutantConfiguration.getTurn().getWalkTurnFactor();
                break;
            }
            default: {
                f = 0.0f;
            }
        }
        return f;
    }

    public final float getInverseSpeedFactor() {
        float f;
        switch (LogicState$WhenMappings.$EnumSwitchMapping$3[this.ordinal()]) {
            case 1: {
                f = 3.0f;
                break;
            }
            case 2: {
                f = 6.0f;
                break;
            }
            case 3: {
                f = 1.0f;
                break;
            }
            case 4: {
                f = 15.0f;
                break;
            }
            default: {
                f = 1.0f;
            }
        }
        return f;
    }

    public final float getInverseTurnFactor() {
        float f;
        switch (LogicState$WhenMappings.$EnumSwitchMapping$4[this.ordinal()]) {
            case 1: {
                f = 3.2653062f;
                break;
            }
            case 2: {
                f = 2.0f;
                break;
            }
            case 3: {
                f = 1.0f;
                break;
            }
            default: {
                f = 1.0f;
            }
        }
        return f;
    }

    public final boolean getMovementBlocked() {
        return this.movementBlocked;
    }

    protected LogicState(boolean bl) {
        this.movementBlocked = bl;
    }

    public static LogicState[] values() {
        return (LogicState[])$VALUES.clone();
    }

    public static LogicState valueOf(String string) {
        return Enum.valueOf(LogicState.class, string);
    }
}

