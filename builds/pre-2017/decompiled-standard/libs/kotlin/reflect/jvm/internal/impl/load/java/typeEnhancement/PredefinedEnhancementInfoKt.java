/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

public final class PredefinedEnhancementInfoKt {
    private static final JavaTypeQualifiers NULLABLE;
    private static final JavaTypeQualifiers NOT_PLATFORM;
    private static final JavaTypeQualifiers NOT_NULLABLE;
    @NotNull
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;

    @NotNull
    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }

    private static final Map<String, PredefinedFunctionEnhancementInfo> enhancement(Function1<? super SignatureEnhancementBuilder, Unit> block) {
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        block.invoke(signatureEnhancementBuilder);
        return signatureEnhancementBuilder.build();
    }

    static {
        SignatureEnhancementBuilder this_$iv;
        SignatureEnhancementBuilder signatureEnhancementBuilder;
        SignatureEnhancementBuilder $receiver;
        SignatureBuildingComponents signatureBuildingComponents;
        NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false);
        NOT_PLATFORM = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, false);
        NOT_NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, true);
        SignatureBuildingComponents $receiver2 = signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String JLObject = $receiver2.javaLang("Object");
        String JFPredicate = $receiver2.javaFunction("Predicate");
        String JFFunction = $receiver2.javaFunction("Function");
        String JFConsumer = $receiver2.javaFunction("Consumer");
        String JFBiFunction = $receiver2.javaFunction("BiFunction");
        String JFBiConsumer = $receiver2.javaFunction("BiConsumer");
        String JFUnaryOperator = $receiver2.javaFunction("UnaryOperator");
        String JUStream = $receiver2.javaUtil("stream/Stream");
        String JUOptional = $receiver2.javaUtil("Optional");
        SignatureEnhancementBuilder signatureEnhancementBuilder2 = $receiver = (signatureEnhancementBuilder = new SignatureEnhancementBuilder());
        String internalName$iv = $receiver2.javaUtil("Iterator");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("forEachRemaining", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JFConsumer$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = $receiver2.javaLang("Iterable");
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("spliterator", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.returns(this.receiver$0$inlined.javaUtil("Spliterator"), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = $receiver2.javaUtil("Collection");
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("removeIf", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JFPredicate$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        $receiver3.function("stream", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.returns(this.$JUStream$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        $receiver3.function("parallelStream", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.returns(this.$JUStream$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = $receiver2.javaUtil("List");
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("replaceAll", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JFUnaryOperator$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = $receiver2.javaUtil("Map");
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("forEach", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JFBiConsumer$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        $receiver3.function("putIfAbsent", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNULLABLE$p());
            }
        });
        $receiver3.function("replace", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNULLABLE$p());
            }
        });
        $receiver3.function("replace", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        $receiver3.function("replaceAll", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JFBiFunction$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        $receiver3.function("compute", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JFBiFunction$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNULLABLE$p(), PredefinedEnhancementInfoKt.access$getNULLABLE$p());
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNULLABLE$p());
            }
        });
        $receiver3.function("computeIfAbsent", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JFFunction$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        $receiver3.function("computeIfPresent", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JFBiFunction$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_NULLABLE$p(), PredefinedEnhancementInfoKt.access$getNULLABLE$p());
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNULLABLE$p());
            }
        });
        $receiver3.function("merge", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_NULLABLE$p());
                $receiver.parameter(this.$JFBiFunction$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_NULLABLE$p(), PredefinedEnhancementInfoKt.access$getNOT_NULLABLE$p(), PredefinedEnhancementInfoKt.access$getNULLABLE$p());
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNULLABLE$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = JUOptional;
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("empty", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.returns(this.$JUOptional$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_NULLABLE$p());
            }
        });
        $receiver3.function("of", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_NULLABLE$p());
                $receiver.returns(this.$JUOptional$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_NULLABLE$p());
            }
        });
        $receiver3.function("ofNullable", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNULLABLE$p());
                $receiver.returns(this.$JUOptional$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_NULLABLE$p());
            }
        });
        $receiver3.function("get", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_NULLABLE$p());
            }
        });
        $receiver3.function("ifPresent", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JFConsumer$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p(), PredefinedEnhancementInfoKt.access$getNOT_NULLABLE$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = $receiver2.javaLang("ref/Reference");
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("get", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNULLABLE$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = JFPredicate;
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("test", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        this_$iv = $receiver;
        internalName$iv = $receiver2.javaFunction("BiPredicate");
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("test", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        this_$iv = $receiver;
        internalName$iv = JFConsumer;
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("accept", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = JFBiConsumer;
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("accept", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = JFFunction;
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("apply", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = JFBiFunction;
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("apply", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.parameter(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        this_$iv = $receiver;
        internalName$iv = $receiver2.javaFunction("Supplier");
        $receiver3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        $receiver3.function("get", (Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>)new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>($receiver2, JFConsumer, JFPredicate, JUStream, JFUnaryOperator, JFBiConsumer, JLObject, JFBiFunction, JFFunction, JUOptional){
            final /* synthetic */ SignatureBuildingComponents receiver$0$inlined;
            final /* synthetic */ String $JFConsumer$inlined;
            final /* synthetic */ String $JFPredicate$inlined;
            final /* synthetic */ String $JUStream$inlined;
            final /* synthetic */ String $JFUnaryOperator$inlined;
            final /* synthetic */ String $JFBiConsumer$inlined;
            final /* synthetic */ String $JLObject$inlined;
            final /* synthetic */ String $JFBiFunction$inlined;
            final /* synthetic */ String $JFFunction$inlined;
            final /* synthetic */ String $JUOptional$inlined;
            {
                this.receiver$0$inlined = signatureBuildingComponents;
                this.$JFConsumer$inlined = string;
                this.$JFPredicate$inlined = string2;
                this.$JUStream$inlined = string3;
                this.$JFUnaryOperator$inlined = string4;
                this.$JFBiConsumer$inlined = string5;
                this.$JLObject$inlined = string6;
                this.$JFBiFunction$inlined = string7;
                this.$JFFunction$inlined = string8;
                this.$JUOptional$inlined = string9;
                super(1);
            }

            public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $receiver) {
                $receiver.returns(this.$JLObject$inlined, PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p());
            }
        });
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder.build();
    }

    @NotNull
    public static final /* synthetic */ JavaTypeQualifiers access$getNOT_PLATFORM$p() {
        return NOT_PLATFORM;
    }

    @NotNull
    public static final /* synthetic */ JavaTypeQualifiers access$getNULLABLE$p() {
        return NULLABLE;
    }

    @NotNull
    public static final /* synthetic */ JavaTypeQualifiers access$getNOT_NULLABLE$p() {
        return NOT_NULLABLE;
    }
}

