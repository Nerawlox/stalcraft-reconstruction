/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class Modality
extends Enum<Modality> {
    public static final /* enum */ Modality FINAL;
    public static final /* enum */ Modality SEALED;
    public static final /* enum */ Modality OPEN;
    public static final /* enum */ Modality ABSTRACT;
    private static final /* synthetic */ Modality[] $VALUES;
    public static final Companion Companion;

    static {
        Modality[] modalityArray = new Modality[4];
        Modality[] modalityArray2 = modalityArray;
        modalityArray[0] = FINAL = new Modality();
        modalityArray[1] = SEALED = new Modality();
        modalityArray[2] = OPEN = new Modality();
        modalityArray[3] = ABSTRACT = new Modality();
        $VALUES = modalityArray;
        Companion = new Companion(null);
    }

    public static Modality[] values() {
        return (Modality[])$VALUES.clone();
    }

    public static Modality valueOf(String string) {
        return Enum.valueOf(Modality.class, string);
    }

    public static final class Companion {
        @NotNull
        public final Modality convertFromFlags(boolean bl, boolean open) {
            if (bl) {
                return ABSTRACT;
            }
            if (open) {
                return OPEN;
            }
            return FINAL;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

