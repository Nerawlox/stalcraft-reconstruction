/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibility$InternalProtected$WhenMappings;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibility$Protected$WhenMappings;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibility$WhenMappings;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibilityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class EffectiveVisibility {
    @NotNull
    private final String name;
    private final boolean publicApi;
    private final boolean privateApi;

    @NotNull
    public String toString() {
        return this.name;
    }

    @NotNull
    public abstract Permissiveness relation(@NotNull EffectiveVisibility var1);

    @NotNull
    public abstract Visibility toVisibility();

    @NotNull
    public EffectiveVisibility lowerBound$kotlin_core(@NotNull EffectiveVisibility other) {
        EffectiveVisibility effectiveVisibility;
        Intrinsics.checkParameterIsNotNull(other, "other");
        switch (EffectiveVisibility$WhenMappings.$EnumSwitchMapping$0[this.relation(other).ordinal()]) {
            case 1: 
            case 2: {
                effectiveVisibility = this;
                break;
            }
            case 3: {
                effectiveVisibility = other;
                break;
            }
            case 4: {
                effectiveVisibility = Private.INSTANCE;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return effectiveVisibility;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getPublicApi() {
        return this.publicApi;
    }

    public final boolean getPrivateApi() {
        return this.privateApi;
    }

    private EffectiveVisibility(String name2, boolean publicApi, boolean privateApi) {
        this.name = name2;
        this.publicApi = publicApi;
        this.privateApi = privateApi;
    }

    /* synthetic */ EffectiveVisibility(String string, boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            bl2 = false;
        }
        this(string, bl, bl2);
    }

    public static final class Private
    extends EffectiveVisibility {
        public static final Private INSTANCE;

        @Override
        @NotNull
        public Permissiveness relation(@NotNull EffectiveVisibility other) {
            Intrinsics.checkParameterIsNotNull(other, "other");
            return Intrinsics.areEqual(this, other) || Intrinsics.areEqual(Local.INSTANCE, other) ? Permissiveness.SAME : Permissiveness.LESS;
        }

        @Override
        @NotNull
        public Visibility toVisibility() {
            return Visibilities.PRIVATE;
        }

        private Private() {
            super("private", false, true, 2, null);
            INSTANCE = this;
        }

        static {
            new Private();
        }
    }

    public static final class Local
    extends EffectiveVisibility {
        public static final Local INSTANCE;

        @Override
        @NotNull
        public Permissiveness relation(@NotNull EffectiveVisibility other) {
            Intrinsics.checkParameterIsNotNull(other, "other");
            return Intrinsics.areEqual(this, other) || Intrinsics.areEqual(Private.INSTANCE, other) ? Permissiveness.SAME : Permissiveness.LESS;
        }

        @Override
        @NotNull
        public Visibility toVisibility() {
            return Visibilities.LOCAL;
        }

        private Local() {
            super("local", false, false, 6, null);
            INSTANCE = this;
        }

        static {
            new Local();
        }
    }

    public static final class Public
    extends EffectiveVisibility {
        public static final Public INSTANCE;

        @Override
        @NotNull
        public Permissiveness relation(@NotNull EffectiveVisibility other) {
            Intrinsics.checkParameterIsNotNull(other, "other");
            return Intrinsics.areEqual(this, other) ? Permissiveness.SAME : Permissiveness.MORE;
        }

        @Override
        @NotNull
        public Visibility toVisibility() {
            return Visibilities.PUBLIC;
        }

        private Public() {
            super("public", true, false, 4, null);
            INSTANCE = this;
        }

        static {
            new Public();
        }
    }

    public static abstract class InternalOrPackage
    extends EffectiveVisibility {
        @Override
        @NotNull
        public Permissiveness relation(@NotNull EffectiveVisibility other) {
            Permissiveness permissiveness;
            Intrinsics.checkParameterIsNotNull(other, "other");
            EffectiveVisibility effectiveVisibility = other;
            if (Intrinsics.areEqual(effectiveVisibility, Public.INSTANCE)) {
                permissiveness = Permissiveness.LESS;
            } else if (Intrinsics.areEqual(effectiveVisibility, Private.INSTANCE) || Intrinsics.areEqual(effectiveVisibility, Local.INSTANCE) || Intrinsics.areEqual(effectiveVisibility, InternalProtectedBound.INSTANCE) || effectiveVisibility instanceof InternalProtected) {
                permissiveness = Permissiveness.MORE;
            } else if (effectiveVisibility instanceof InternalOrPackage) {
                permissiveness = Permissiveness.SAME;
            } else if (Intrinsics.areEqual(effectiveVisibility, ProtectedBound.INSTANCE) || effectiveVisibility instanceof Protected) {
                permissiveness = Permissiveness.UNKNOWN;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return permissiveness;
        }

        @Override
        @NotNull
        public EffectiveVisibility lowerBound$kotlin_core(@NotNull EffectiveVisibility other) {
            EffectiveVisibility effectiveVisibility;
            Intrinsics.checkParameterIsNotNull(other, "other");
            EffectiveVisibility effectiveVisibility2 = other;
            if (Intrinsics.areEqual(effectiveVisibility2, Public.INSTANCE)) {
                effectiveVisibility = this;
            } else if (Intrinsics.areEqual(effectiveVisibility2, Private.INSTANCE) || Intrinsics.areEqual(effectiveVisibility2, Local.INSTANCE) || Intrinsics.areEqual(effectiveVisibility2, InternalProtectedBound.INSTANCE) || effectiveVisibility2 instanceof InternalOrPackage || effectiveVisibility2 instanceof InternalProtected) {
                effectiveVisibility = other;
            } else if (effectiveVisibility2 instanceof Protected) {
                effectiveVisibility = new InternalProtected(((Protected)other).getContainer());
            } else if (Intrinsics.areEqual(effectiveVisibility2, ProtectedBound.INSTANCE)) {
                effectiveVisibility = InternalProtectedBound.INSTANCE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return effectiveVisibility;
        }

        protected InternalOrPackage(boolean internal) {
            super(internal ? "internal" : "public/*package*/", false, false, 6, null);
        }
    }

    public static final class Internal
    extends InternalOrPackage {
        public static final Internal INSTANCE;

        @Override
        @NotNull
        public Visibility toVisibility() {
            return Visibilities.INTERNAL;
        }

        private Internal() {
            super(true);
            INSTANCE = this;
        }

        static {
            new Internal();
        }
    }

    public static final class PackagePrivate
    extends InternalOrPackage {
        public static final PackagePrivate INSTANCE;

        @Override
        @NotNull
        public Visibility toVisibility() {
            return Visibilities.PRIVATE;
        }

        private PackagePrivate() {
            super(false);
            INSTANCE = this;
        }

        static {
            new PackagePrivate();
        }
    }

    public static final class Protected
    extends EffectiveVisibility {
        @Nullable
        private final ClassDescriptor container;

        public boolean equals(@Nullable Object other) {
            return other instanceof Protected && Intrinsics.areEqual(this.container, ((Protected)other).container);
        }

        public int hashCode() {
            ClassDescriptor classDescriptor = this.container;
            return classDescriptor != null ? classDescriptor.hashCode() : 0;
        }

        @Override
        @NotNull
        public String toString() {
            Object object;
            return super.toString() + " (in " + ((object = this.container) != null && (object = object.getName()) != null ? (Comparable)object : (Comparable)Character.valueOf('?')) + ")";
        }

        @Override
        @NotNull
        public Permissiveness relation(@NotNull EffectiveVisibility other) {
            Permissiveness permissiveness;
            Intrinsics.checkParameterIsNotNull(other, "other");
            EffectiveVisibility effectiveVisibility = other;
            if (Intrinsics.areEqual(effectiveVisibility, Public.INSTANCE)) {
                permissiveness = Permissiveness.LESS;
            } else if (Intrinsics.areEqual(effectiveVisibility, Private.INSTANCE) || Intrinsics.areEqual(effectiveVisibility, Local.INSTANCE) || Intrinsics.areEqual(effectiveVisibility, ProtectedBound.INSTANCE) || Intrinsics.areEqual(effectiveVisibility, InternalProtectedBound.INSTANCE)) {
                permissiveness = Permissiveness.MORE;
            } else if (effectiveVisibility instanceof Protected) {
                permissiveness = EffectiveVisibilityKt.containerRelation(this.container, ((Protected)other).container);
            } else if (effectiveVisibility instanceof InternalProtected) {
                switch (EffectiveVisibility$Protected$WhenMappings.$EnumSwitchMapping$0[EffectiveVisibilityKt.containerRelation(this.container, ((InternalProtected)other).getContainer()).ordinal()]) {
                    case 1: 
                    case 2: {
                        permissiveness = Permissiveness.MORE;
                        break;
                    }
                    case 3: 
                    case 4: {
                        permissiveness = Permissiveness.UNKNOWN;
                        break;
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else if (effectiveVisibility instanceof InternalOrPackage) {
                permissiveness = Permissiveness.UNKNOWN;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return permissiveness;
        }

        @Override
        @NotNull
        public EffectiveVisibility lowerBound$kotlin_core(@NotNull EffectiveVisibility other) {
            EffectiveVisibility effectiveVisibility;
            Intrinsics.checkParameterIsNotNull(other, "other");
            EffectiveVisibility effectiveVisibility2 = other;
            if (Intrinsics.areEqual(effectiveVisibility2, Public.INSTANCE)) {
                effectiveVisibility = this;
            } else if (Intrinsics.areEqual(effectiveVisibility2, Private.INSTANCE) || Intrinsics.areEqual(effectiveVisibility2, Local.INSTANCE) || Intrinsics.areEqual(effectiveVisibility2, ProtectedBound.INSTANCE) || Intrinsics.areEqual(effectiveVisibility2, InternalProtectedBound.INSTANCE)) {
                effectiveVisibility = other;
            } else if (effectiveVisibility2 instanceof Protected) {
                switch (EffectiveVisibility$Protected$WhenMappings.$EnumSwitchMapping$1[this.relation(other).ordinal()]) {
                    case 1: 
                    case 2: {
                        effectiveVisibility = this;
                        break;
                    }
                    case 3: {
                        effectiveVisibility = other;
                        break;
                    }
                    case 4: {
                        effectiveVisibility = ProtectedBound.INSTANCE;
                        break;
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else if (effectiveVisibility2 instanceof InternalProtected) {
                switch (EffectiveVisibility$Protected$WhenMappings.$EnumSwitchMapping$2[this.relation(other).ordinal()]) {
                    case 1: {
                        effectiveVisibility = other;
                        break;
                    }
                    default: {
                        effectiveVisibility = InternalProtectedBound.INSTANCE;
                        break;
                    }
                }
            } else if (effectiveVisibility2 instanceof InternalOrPackage) {
                effectiveVisibility = new InternalProtected(this.container);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return effectiveVisibility;
        }

        @Override
        @NotNull
        public Visibility toVisibility() {
            return Visibilities.PROTECTED;
        }

        @Nullable
        public final ClassDescriptor getContainer() {
            return this.container;
        }

        public Protected(@Nullable ClassDescriptor container) {
            super("protected", true, false, 4, null);
            this.container = container;
        }
    }

    public static final class ProtectedBound
    extends EffectiveVisibility {
        public static final ProtectedBound INSTANCE;

        @Override
        @NotNull
        public Permissiveness relation(@NotNull EffectiveVisibility other) {
            Permissiveness permissiveness;
            Intrinsics.checkParameterIsNotNull(other, "other");
            EffectiveVisibility effectiveVisibility = other;
            if (Intrinsics.areEqual(effectiveVisibility, Public.INSTANCE) || effectiveVisibility instanceof Protected) {
                permissiveness = Permissiveness.LESS;
            } else if (Intrinsics.areEqual(effectiveVisibility, Private.INSTANCE) || Intrinsics.areEqual(effectiveVisibility, Local.INSTANCE) || Intrinsics.areEqual(effectiveVisibility, InternalProtectedBound.INSTANCE)) {
                permissiveness = Permissiveness.MORE;
            } else if (Intrinsics.areEqual(effectiveVisibility, INSTANCE)) {
                permissiveness = Permissiveness.SAME;
            } else if (effectiveVisibility instanceof InternalOrPackage || effectiveVisibility instanceof InternalProtected) {
                permissiveness = Permissiveness.UNKNOWN;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return permissiveness;
        }

        @Override
        @NotNull
        public EffectiveVisibility lowerBound$kotlin_core(@NotNull EffectiveVisibility other) {
            EffectiveVisibility effectiveVisibility;
            Intrinsics.checkParameterIsNotNull(other, "other");
            EffectiveVisibility effectiveVisibility2 = other;
            if (Intrinsics.areEqual(effectiveVisibility2, Public.INSTANCE) || effectiveVisibility2 instanceof Protected) {
                effectiveVisibility = this;
            } else if (Intrinsics.areEqual(effectiveVisibility2, Private.INSTANCE) || Intrinsics.areEqual(effectiveVisibility2, Local.INSTANCE) || Intrinsics.areEqual(effectiveVisibility2, INSTANCE) || Intrinsics.areEqual(effectiveVisibility2, InternalProtectedBound.INSTANCE)) {
                effectiveVisibility = other;
            } else if (effectiveVisibility2 instanceof InternalOrPackage || effectiveVisibility2 instanceof InternalProtected) {
                effectiveVisibility = InternalProtectedBound.INSTANCE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return effectiveVisibility;
        }

        @Override
        @NotNull
        public Visibility toVisibility() {
            return Visibilities.PROTECTED;
        }

        private ProtectedBound() {
            super("protected (in different classes)", true, false, 4, null);
            INSTANCE = this;
        }

        static {
            new ProtectedBound();
        }
    }

    public static final class InternalProtected
    extends EffectiveVisibility {
        @Nullable
        private final ClassDescriptor container;

        public boolean equals(@Nullable Object other) {
            return other instanceof InternalProtected && Intrinsics.areEqual(this.container, ((InternalProtected)other).container);
        }

        public int hashCode() {
            ClassDescriptor classDescriptor = this.container;
            return classDescriptor != null ? classDescriptor.hashCode() : 0;
        }

        @Override
        @NotNull
        public String toString() {
            Object object;
            return super.toString() + " (in " + ((object = this.container) != null && (object = object.getName()) != null ? (Comparable)object : (Comparable)Character.valueOf('?')) + ")";
        }

        @Override
        @NotNull
        public Permissiveness relation(@NotNull EffectiveVisibility other) {
            Permissiveness permissiveness;
            Intrinsics.checkParameterIsNotNull(other, "other");
            EffectiveVisibility effectiveVisibility = other;
            if (Intrinsics.areEqual(effectiveVisibility, Public.INSTANCE) || effectiveVisibility instanceof InternalOrPackage) {
                permissiveness = Permissiveness.LESS;
            } else if (Intrinsics.areEqual(effectiveVisibility, Private.INSTANCE) || Intrinsics.areEqual(effectiveVisibility, Local.INSTANCE) || Intrinsics.areEqual(effectiveVisibility, InternalProtectedBound.INSTANCE)) {
                permissiveness = Permissiveness.MORE;
            } else if (effectiveVisibility instanceof InternalProtected) {
                permissiveness = EffectiveVisibilityKt.containerRelation(this.container, ((InternalProtected)other).container);
            } else if (effectiveVisibility instanceof Protected) {
                switch (EffectiveVisibility$InternalProtected$WhenMappings.$EnumSwitchMapping$0[EffectiveVisibilityKt.containerRelation(this.container, ((Protected)other).getContainer()).ordinal()]) {
                    case 1: 
                    case 2: {
                        permissiveness = Permissiveness.LESS;
                        break;
                    }
                    case 3: 
                    case 4: {
                        permissiveness = Permissiveness.UNKNOWN;
                        break;
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else if (Intrinsics.areEqual(effectiveVisibility, ProtectedBound.INSTANCE)) {
                permissiveness = Permissiveness.UNKNOWN;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return permissiveness;
        }

        @Override
        @NotNull
        public EffectiveVisibility lowerBound$kotlin_core(@NotNull EffectiveVisibility other) {
            EffectiveVisibility effectiveVisibility;
            Intrinsics.checkParameterIsNotNull(other, "other");
            EffectiveVisibility effectiveVisibility2 = other;
            if (Intrinsics.areEqual(effectiveVisibility2, Public.INSTANCE) || effectiveVisibility2 instanceof InternalOrPackage) {
                effectiveVisibility = this;
            } else if (Intrinsics.areEqual(effectiveVisibility2, Private.INSTANCE) || Intrinsics.areEqual(effectiveVisibility2, Local.INSTANCE) || Intrinsics.areEqual(effectiveVisibility2, InternalProtectedBound.INSTANCE)) {
                effectiveVisibility = other;
            } else if (effectiveVisibility2 instanceof Protected || effectiveVisibility2 instanceof InternalProtected) {
                switch (EffectiveVisibility$InternalProtected$WhenMappings.$EnumSwitchMapping$1[this.relation(other).ordinal()]) {
                    case 1: 
                    case 2: {
                        effectiveVisibility = this;
                        break;
                    }
                    case 3: {
                        effectiveVisibility = other;
                        break;
                    }
                    case 4: {
                        effectiveVisibility = InternalProtectedBound.INSTANCE;
                        break;
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else if (Intrinsics.areEqual(effectiveVisibility2, ProtectedBound.INSTANCE)) {
                effectiveVisibility = InternalProtectedBound.INSTANCE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return effectiveVisibility;
        }

        @Override
        @NotNull
        public Visibility toVisibility() {
            return Visibilities.PRIVATE;
        }

        @Nullable
        public final ClassDescriptor getContainer() {
            return this.container;
        }

        public InternalProtected(@Nullable ClassDescriptor container) {
            super("internal & protected", false, false, 6, null);
            this.container = container;
        }
    }

    public static final class InternalProtectedBound
    extends EffectiveVisibility {
        public static final InternalProtectedBound INSTANCE;

        @Override
        @NotNull
        public Permissiveness relation(@NotNull EffectiveVisibility other) {
            Permissiveness permissiveness;
            Intrinsics.checkParameterIsNotNull(other, "other");
            EffectiveVisibility effectiveVisibility = other;
            if (Intrinsics.areEqual(effectiveVisibility, Public.INSTANCE) || effectiveVisibility instanceof Protected || effectiveVisibility instanceof InternalProtected || Intrinsics.areEqual(effectiveVisibility, ProtectedBound.INSTANCE) || effectiveVisibility instanceof InternalOrPackage) {
                permissiveness = Permissiveness.LESS;
            } else if (Intrinsics.areEqual(effectiveVisibility, Private.INSTANCE) || Intrinsics.areEqual(effectiveVisibility, Local.INSTANCE)) {
                permissiveness = Permissiveness.MORE;
            } else if (Intrinsics.areEqual(effectiveVisibility, INSTANCE)) {
                permissiveness = Permissiveness.SAME;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return permissiveness;
        }

        @Override
        @NotNull
        public Visibility toVisibility() {
            return Visibilities.PRIVATE;
        }

        private InternalProtectedBound() {
            super("internal & protected (in different classes)", false, false, 6, null);
            INSTANCE = this;
        }

        static {
            new InternalProtectedBound();
        }
    }

    public static final class Permissiveness
    extends Enum<Permissiveness> {
        public static final /* enum */ Permissiveness LESS;
        public static final /* enum */ Permissiveness SAME;
        public static final /* enum */ Permissiveness MORE;
        public static final /* enum */ Permissiveness UNKNOWN;
        private static final /* synthetic */ Permissiveness[] $VALUES;

        static {
            Permissiveness[] permissivenessArray = new Permissiveness[4];
            Permissiveness[] permissivenessArray2 = permissivenessArray;
            permissivenessArray[0] = LESS = new Permissiveness();
            permissivenessArray[1] = SAME = new Permissiveness();
            permissivenessArray[2] = MORE = new Permissiveness();
            permissivenessArray[3] = UNKNOWN = new Permissiveness();
            $VALUES = permissivenessArray;
        }

        public static Permissiveness[] values() {
            return (Permissiveness[])$VALUES.clone();
        }

        public static Permissiveness valueOf(String string) {
            return Enum.valueOf(Permissiveness.class, string);
        }
    }
}

