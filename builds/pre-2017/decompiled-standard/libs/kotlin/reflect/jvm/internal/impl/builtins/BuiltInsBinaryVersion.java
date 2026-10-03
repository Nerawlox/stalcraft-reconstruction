/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsBinaryVersion
extends BinaryVersion {
    @JvmField
    @NotNull
    public static final BuiltInsBinaryVersion INSTANCE;
    public static final Companion Companion;

    @Override
    public boolean isCompatible() {
        return this.isCompatibleTo(INSTANCE);
    }

    public BuiltInsBinaryVersion(int ... numbers) {
        Intrinsics.checkParameterIsNotNull(numbers, "numbers");
        super(Arrays.copyOf(numbers, numbers.length));
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new BuiltInsBinaryVersion(1, 0, 0);
    }

    public static final class Companion {
        /*
         * WARNING - void declaration
         */
        @NotNull
        public final BuiltInsBinaryVersion readFrom(@NotNull InputStream stream) {
            Collection<Integer> collection;
            void $receiver$iv$iv;
            void $receiver$iv;
            BuiltInsBinaryVersion builtInsBinaryVersion;
            Intrinsics.checkParameterIsNotNull(stream, "stream");
            DataInputStream dataInput = new DataInputStream(stream);
            Iterable iterable = new IntRange(1, dataInput.readInt());
            BuiltInsBinaryVersion builtInsBinaryVersion2 = builtInsBinaryVersion;
            BuiltInsBinaryVersion builtInsBinaryVersion3 = builtInsBinaryVersion;
            void var6_6 = $receiver$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            Iterator iterator2 = $receiver$iv$iv.iterator();
            while (iterator2.hasNext()) {
                int item$iv$iv;
                int n = item$iv$iv = ((IntIterator)iterator2).nextInt();
                collection = destination$iv$iv;
                Integer n2 = dataInput.readInt();
                collection.add(n2);
            }
            collection = (List)destination$iv$iv;
            int[] nArray = CollectionsKt.toIntArray(collection);
            builtInsBinaryVersion2(Arrays.copyOf(nArray, nArray.length));
            return builtInsBinaryVersion3;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

