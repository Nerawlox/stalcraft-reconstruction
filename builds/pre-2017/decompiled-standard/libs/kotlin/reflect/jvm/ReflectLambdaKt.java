/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm;

import java.io.ByteArrayInputStream;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.EmptyContainerForLocal;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.ModuleByClassLoaderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.BitEncoding;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u00a8\u0006\u0004"}, d2={"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"})
public final class ReflectLambdaKt {
    @Nullable
    public static final <R> KFunction<R> reflect(@NotNull Function<? extends R> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Metadata metadata = $receiver.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        Metadata annotation = metadata;
        byte[] byArray = BitEncoding.decodeBytes(annotation.d1());
        ByteArrayInputStream input = new ByteArrayInputStream(byArray);
        JvmProtoBuf.StringTableTypes stringTableTypes = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(input, JvmProtoBufUtil.INSTANCE.getEXTENSION_REGISTRY());
        Intrinsics.checkExpressionValueIsNotNull(stringTableTypes, "JvmProtoBuf.StringTableT\u2026fUtil.EXTENSION_REGISTRY)");
        JvmNameResolver nameResolver = new JvmNameResolver(stringTableTypes, annotation.d2());
        ProtoBuf.Function proto = ProtoBuf.Function.parseFrom(input, JvmProtoBufUtil.INSTANCE.getEXTENSION_REGISTRY());
        RuntimeModuleData moduleData2 = ModuleByClassLoaderKt.getOrCreateModule($receiver.getClass());
        DeserializationComponents deserializationComponents = moduleData2.getDeserialization();
        NameResolver nameResolver2 = nameResolver;
        DeclarationDescriptor declarationDescriptor = moduleData2.getModule();
        ProtoBuf.TypeTable typeTable = proto.getTypeTable();
        Intrinsics.checkExpressionValueIsNotNull(typeTable, "proto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        SinceKotlinInfoTable sinceKotlinInfoTable = SinceKotlinInfoTable.Companion.getEMPTY();
        List<ProtoBuf.TypeParameter> list = proto.getTypeParameterList();
        Intrinsics.checkExpressionValueIsNotNull(list, "proto.typeParameterList");
        DeserializationContext context = new DeserializationContext(deserializationComponents, nameResolver2, declarationDescriptor, typeTable2, sinceKotlinInfoTable, null, null, list);
        MemberDeserializer memberDeserializer = new MemberDeserializer(context);
        ProtoBuf.Function function = proto;
        Intrinsics.checkExpressionValueIsNotNull(function, "proto");
        SimpleFunctionDescriptor descriptor2 = memberDeserializer.loadFunction(function);
        return new KFunctionImpl(EmptyContainerForLocal.INSTANCE, descriptor2);
    }
}

