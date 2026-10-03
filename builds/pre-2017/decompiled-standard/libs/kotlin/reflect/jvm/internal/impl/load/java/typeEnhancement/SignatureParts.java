/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PartEnhancementResult;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SignatureParts {
    @NotNull
    private final KotlinType fromOverride;
    @NotNull
    private final Collection<KotlinType> fromOverridden;
    private final boolean isCovariant;

    @NotNull
    public final PartEnhancementResult enhance(@Nullable TypeEnhancementInfo predefined) {
        PartEnhancementResult partEnhancementResult;
        Function1 qualifiersWithPredefined;
        Function1 function1;
        Function1 function12;
        Object object;
        Function1 qualifiers = TypeQualifiersKt.computeIndexedQualifiersForOverride(this.fromOverride, this.fromOverridden, this.isCovariant);
        TypeEnhancementInfo typeEnhancementInfo = predefined;
        if (typeEnhancementInfo != null) {
            object = typeEnhancementInfo;
            TypeEnhancementInfo it = object;
            function12 = new Function1<Integer, JavaTypeQualifiers>(predefined, qualifiers){
                final /* synthetic */ TypeEnhancementInfo $predefined$inlined;
                final /* synthetic */ Function1 $qualifiers$inlined;
                {
                    this.$predefined$inlined = typeEnhancementInfo;
                    this.$qualifiers$inlined = function1;
                    super(1);
                }

                public final JavaTypeQualifiers invoke(int index) {
                    JavaTypeQualifiers javaTypeQualifiers = this.$predefined$inlined.getMap().get(index);
                    if (javaTypeQualifiers == null) {
                        javaTypeQualifiers = (JavaTypeQualifiers)this.$qualifiers$inlined.invoke(index);
                    }
                    return javaTypeQualifiers;
                }
            };
        } else {
            function12 = null;
        }
        if ((function1 = (qualifiersWithPredefined = function12)) == null) {
            function1 = qualifiers;
        }
        KotlinType kotlinType = TypeEnhancementKt.enhance(this.fromOverride, function1);
        if (kotlinType != null) {
            object = kotlinType;
            KotlinType enhanced = (KotlinType)object;
            partEnhancementResult = new PartEnhancementResult(enhanced, true);
        } else {
            partEnhancementResult = new PartEnhancementResult(this.fromOverride, false);
        }
        return partEnhancementResult;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ PartEnhancementResult enhance$default(SignatureParts signatureParts, TypeEnhancementInfo typeEnhancementInfo, int n, Object object) {
        if ((n & 1) != 0) {
            typeEnhancementInfo = null;
        }
        return signatureParts.enhance(typeEnhancementInfo);
    }

    @NotNull
    public final KotlinType getFromOverride() {
        return this.fromOverride;
    }

    @NotNull
    public final Collection<KotlinType> getFromOverridden() {
        return this.fromOverridden;
    }

    public final boolean isCovariant() {
        return this.isCovariant;
    }

    public SignatureParts(@NotNull KotlinType fromOverride, @NotNull Collection<? extends KotlinType> fromOverridden, boolean isCovariant) {
        Intrinsics.checkParameterIsNotNull(fromOverride, "fromOverride");
        Intrinsics.checkParameterIsNotNull(fromOverridden, "fromOverridden");
        this.fromOverride = fromOverride;
        this.fromOverridden = fromOverridden;
        this.isCovariant = isCovariant;
    }
}

