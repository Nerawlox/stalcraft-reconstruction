/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.animation;

import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/animation/EnumPlayMode;", "", "(Ljava/lang/String;I)V", "IMMEDIATELY", "BLEND_IN", "minecraft"})
public final class EnumPlayMode
extends Enum<EnumPlayMode> {
    public static final /* enum */ EnumPlayMode IMMEDIATELY;
    public static final /* enum */ EnumPlayMode BLEND_IN;
    private static final /* synthetic */ EnumPlayMode[] $VALUES;

    static {
        EnumPlayMode[] enumPlayModeArray = new EnumPlayMode[2];
        EnumPlayMode[] enumPlayModeArray2 = enumPlayModeArray;
        enumPlayModeArray[0] = IMMEDIATELY = new EnumPlayMode();
        enumPlayModeArray[1] = BLEND_IN = new EnumPlayMode();
        $VALUES = enumPlayModeArray;
    }

    public static EnumPlayMode[] values() {
        return (EnumPlayMode[])$VALUES.clone();
    }

    public static EnumPlayMode valueOf(String string) {
        return Enum.valueOf(EnumPlayMode.class, string);
    }
}

