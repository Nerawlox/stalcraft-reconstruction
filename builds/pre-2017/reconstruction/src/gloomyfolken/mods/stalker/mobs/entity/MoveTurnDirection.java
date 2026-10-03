/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/MoveTurnDirection;", "", "(Ljava/lang/String;I)V", "getAnimSuffix", "", "NONE", "LEFT", "RIGHT", "minecraft"})
public final class MoveTurnDirection
extends Enum<MoveTurnDirection> {
    public static final /* enum */ MoveTurnDirection NONE;
    public static final /* enum */ MoveTurnDirection LEFT;
    public static final /* enum */ MoveTurnDirection RIGHT;
    private static final /* synthetic */ MoveTurnDirection[] $VALUES;

    static {
        MoveTurnDirection[] moveTurnDirectionArray = new MoveTurnDirection[3];
        MoveTurnDirection[] moveTurnDirectionArray2 = moveTurnDirectionArray;
        moveTurnDirectionArray[0] = NONE = new MoveTurnDirection();
        moveTurnDirectionArray[1] = LEFT = new MoveTurnDirection();
        moveTurnDirectionArray[2] = RIGHT = new MoveTurnDirection();
        $VALUES = moveTurnDirectionArray;
    }

    @NotNull
    public final String getAnimSuffix() {
        String string;
        if (Intrinsics.areEqual((Object)this, (Object)NONE) ^ true) {
            String string2 = this.name();
            StringBuilder stringBuilder = new StringBuilder().append("_");
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.String).toLowerCase()");
            String string5 = string4;
            string = stringBuilder.append(StringsKt.first(string5)).toString();
        } else {
            string = "";
        }
        return string;
    }

    public static MoveTurnDirection[] values() {
        return (MoveTurnDirection[])$VALUES.clone();
    }

    public static MoveTurnDirection valueOf(String string) {
        return Enum.valueOf(MoveTurnDirection.class, string);
    }
}

