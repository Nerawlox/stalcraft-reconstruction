/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;", "", "(Ljava/lang/String;I)V", "DEATH", "IDLE", "PAIN", "PANIC", "ATTACK", "THREATEN", "EAT", "ANOMALY", "ANOMALY_DEATH", "AGGRESSIVE", "STEP", "minecraft"})
public final class MutantSoundType
extends Enum<MutantSoundType> {
    public static final /* enum */ MutantSoundType DEATH;
    public static final /* enum */ MutantSoundType IDLE;
    public static final /* enum */ MutantSoundType PAIN;
    public static final /* enum */ MutantSoundType PANIC;
    public static final /* enum */ MutantSoundType ATTACK;
    public static final /* enum */ MutantSoundType THREATEN;
    public static final /* enum */ MutantSoundType EAT;
    public static final /* enum */ MutantSoundType ANOMALY;
    public static final /* enum */ MutantSoundType ANOMALY_DEATH;
    public static final /* enum */ MutantSoundType AGGRESSIVE;
    public static final /* enum */ MutantSoundType STEP;
    private static final /* synthetic */ MutantSoundType[] $VALUES;

    static {
        MutantSoundType[] mutantSoundTypeArray = new MutantSoundType[11];
        MutantSoundType[] mutantSoundTypeArray2 = mutantSoundTypeArray;
        mutantSoundTypeArray[0] = DEATH = new MutantSoundType();
        mutantSoundTypeArray[1] = IDLE = new MutantSoundType();
        mutantSoundTypeArray[2] = PAIN = new MutantSoundType();
        mutantSoundTypeArray[3] = PANIC = new MutantSoundType();
        mutantSoundTypeArray[4] = ATTACK = new MutantSoundType();
        mutantSoundTypeArray[5] = THREATEN = new MutantSoundType();
        mutantSoundTypeArray[6] = EAT = new MutantSoundType();
        mutantSoundTypeArray[7] = ANOMALY = new MutantSoundType();
        mutantSoundTypeArray[8] = ANOMALY_DEATH = new MutantSoundType();
        mutantSoundTypeArray[9] = AGGRESSIVE = new MutantSoundType();
        mutantSoundTypeArray[10] = STEP = new MutantSoundType();
        $VALUES = mutantSoundTypeArray;
    }

    public static MutantSoundType[] values() {
        return (MutantSoundType[])$VALUES.clone();
    }

    public static MutantSoundType valueOf(String string) {
        return Enum.valueOf(MutantSoundType.class, string);
    }
}

