/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.animation.state;

import gloomyfolken.mods.stalker.mobs.entity.animation.state.LogicState;
import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=3)
public final class LogicState$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;
    public static final /* synthetic */ int[] $EnumSwitchMapping$3;
    public static final /* synthetic */ int[] $EnumSwitchMapping$4;

    static {
        $EnumSwitchMapping$0 = new int[LogicState.values().length];
        LogicState$WhenMappings.$EnumSwitchMapping$0[LogicState.WALK.ordinal()] = 1;
        LogicState$WhenMappings.$EnumSwitchMapping$0[LogicState.WALK_BACK.ordinal()] = 2;
        LogicState$WhenMappings.$EnumSwitchMapping$0[LogicState.RUN.ordinal()] = 3;
        LogicState$WhenMappings.$EnumSwitchMapping$0[LogicState.CRAWL.ordinal()] = 4;
        $EnumSwitchMapping$1 = new int[LogicState.values().length];
        LogicState$WhenMappings.$EnumSwitchMapping$1[LogicState.STAND.ordinal()] = 1;
        $EnumSwitchMapping$2 = new int[LogicState.values().length];
        LogicState$WhenMappings.$EnumSwitchMapping$2[LogicState.RUN.ordinal()] = 1;
        LogicState$WhenMappings.$EnumSwitchMapping$2[LogicState.STAND.ordinal()] = 2;
        LogicState$WhenMappings.$EnumSwitchMapping$2[LogicState.WALK.ordinal()] = 3;
        $EnumSwitchMapping$3 = new int[LogicState.values().length];
        LogicState$WhenMappings.$EnumSwitchMapping$3[LogicState.WALK.ordinal()] = 1;
        LogicState$WhenMappings.$EnumSwitchMapping$3[LogicState.WALK_BACK.ordinal()] = 2;
        LogicState$WhenMappings.$EnumSwitchMapping$3[LogicState.RUN.ordinal()] = 3;
        LogicState$WhenMappings.$EnumSwitchMapping$3[LogicState.CRAWL.ordinal()] = 4;
        $EnumSwitchMapping$4 = new int[LogicState.values().length];
        LogicState$WhenMappings.$EnumSwitchMapping$4[LogicState.STAND.ordinal()] = 1;
        LogicState$WhenMappings.$EnumSwitchMapping$4[LogicState.WALK.ordinal()] = 2;
        LogicState$WhenMappings.$EnumSwitchMapping$4[LogicState.RUN.ordinal()] = 3;
    }
}

