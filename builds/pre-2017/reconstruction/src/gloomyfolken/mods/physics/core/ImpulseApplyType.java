/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core;

import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Lgloomyfolken/mods/physics/core/ImpulseApplyType;", "", "regex", "Lkotlin/text/Regex;", "(Ljava/lang/String;ILkotlin/text/Regex;)V", "getRegex", "()Lkotlin/text/Regex;", "NEAREST_PART", "BODY", "ALL", "minecraft"})
public final class ImpulseApplyType
extends Enum<ImpulseApplyType> {
    public static final /* enum */ ImpulseApplyType NEAREST_PART;
    public static final /* enum */ ImpulseApplyType BODY;
    public static final /* enum */ ImpulseApplyType ALL;
    private static final /* synthetic */ ImpulseApplyType[] $VALUES;
    @Nullable
    private final Regex regex;

    static {
        ImpulseApplyType[] impulseApplyTypeArray = new ImpulseApplyType[3];
        ImpulseApplyType[] impulseApplyTypeArray2 = impulseApplyTypeArray;
        impulseApplyTypeArray[0] = NEAREST_PART = new ImpulseApplyType(null);
        impulseApplyTypeArray[1] = BODY = new ImpulseApplyType(new Regex("body|spine"));
        impulseApplyTypeArray[2] = ALL = new ImpulseApplyType(new Regex("."));
        $VALUES = impulseApplyTypeArray;
    }

    @Nullable
    public final Regex getRegex() {
        return this.regex;
    }

    protected ImpulseApplyType(@Nullable Regex regex) {
        this.regex = regex;
    }

    public static ImpulseApplyType[] values() {
        return (ImpulseApplyType[])$VALUES.clone();
    }

    public static ImpulseApplyType valueOf(String string) {
        return Enum.valueOf(ImpulseApplyType.class, string);
    }
}

