/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.builtins.BuiltInsProtoBuf;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class BuiltInSerializerProtocol
extends SerializerExtensionProtocol {
    @NotNull
    private static final String BUILTINS_FILE_EXTENSION = "kotlin_builtins";
    public static final BuiltInSerializerProtocol INSTANCE;

    @NotNull
    public final String getBUILTINS_FILE_EXTENSION() {
        return BUILTINS_FILE_EXTENSION;
    }

    @NotNull
    public final String getBuiltInsFilePath(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return StringsKt.replace$default(fqName2.asString(), '.', '/', false, 4, null) + "/" + this.getBuiltInsFileName(fqName2);
    }

    @NotNull
    public final String getBuiltInsFileName(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return this.shortName(fqName2) + "." + BUILTINS_FILE_EXTENSION;
    }

    private final String shortName(FqName fqName2) {
        String string;
        if (fqName2.isRoot()) {
            string = "default-package";
        } else {
            String string2 = fqName2.shortName().asString();
            string = string2;
            Intrinsics.checkExpressionValueIsNotNull(string2, "fqName.shortName().asString()");
        }
        return string;
    }

    private BuiltInSerializerProtocol() {
        ExtensionRegistryLite extensionRegistryLite;
        ExtensionRegistryLite extensionRegistryLite2 = ExtensionRegistryLite.newInstance();
        BuiltInSerializerProtocol builtInSerializerProtocol = this;
        ExtensionRegistryLite $receiver = extensionRegistryLite2;
        BuiltInsProtoBuf.registerAllExtensions($receiver);
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite = extensionRegistryLite2;
        Intrinsics.checkExpressionValueIsNotNull(extensionRegistryLite3, "ExtensionRegistryLite.ne\u2026sterAllExtensions(this) }");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> generatedExtension = BuiltInsProtoBuf.constructorAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension, "BuiltInsProtoBuf.constructorAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> generatedExtension2 = BuiltInsProtoBuf.classAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension2, "BuiltInsProtoBuf.classAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> generatedExtension3 = BuiltInsProtoBuf.functionAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension3, "BuiltInsProtoBuf.functionAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension4 = BuiltInsProtoBuf.propertyAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension4, "BuiltInsProtoBuf.propertyAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> generatedExtension5 = BuiltInsProtoBuf.enumEntryAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension5, "BuiltInsProtoBuf.enumEntryAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> generatedExtension6 = BuiltInsProtoBuf.compileTimeValue;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension6, "BuiltInsProtoBuf.compileTimeValue");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> generatedExtension7 = BuiltInsProtoBuf.parameterAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension7, "BuiltInsProtoBuf.parameterAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> generatedExtension8 = BuiltInsProtoBuf.typeAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension8, "BuiltInsProtoBuf.typeAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> generatedExtension9 = BuiltInsProtoBuf.typeParameterAnnotation;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension9, "BuiltInsProtoBuf.typeParameterAnnotation");
        super(extensionRegistryLite3, generatedExtension, generatedExtension2, generatedExtension3, generatedExtension4, generatedExtension5, generatedExtension6, generatedExtension7, generatedExtension8, generatedExtension9);
        INSTANCE = this;
        BUILTINS_FILE_EXTENSION = BUILTINS_FILE_EXTENSION;
    }

    static {
        new BuiltInSerializerProtocol();
    }
}

