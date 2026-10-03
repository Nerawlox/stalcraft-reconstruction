/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.jvm;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.serialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.PackageData;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.BitEncoding;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmProtoBufUtil {
    @NotNull
    private static final ExtensionRegistryLite EXTENSION_REGISTRY;
    public static final JvmProtoBufUtil INSTANCE;

    @NotNull
    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    @JvmStatic
    @NotNull
    public static final ClassData readClassDataFrom(@NotNull String[] data2, @NotNull String[] strings) {
        Intrinsics.checkParameterIsNotNull(data2, "data");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        byte[] byArray = BitEncoding.decodeBytes(data2);
        Intrinsics.checkExpressionValueIsNotNull(byArray, "BitEncoding.decodeBytes(data)");
        return JvmProtoBufUtil.readClassDataFrom(byArray, strings);
    }

    @JvmStatic
    @NotNull
    public static final ClassData readClassDataFrom(@NotNull byte[] bytes, @NotNull String[] strings) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        JvmProtoBuf.StringTableTypes stringTableTypes = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(input, EXTENSION_REGISTRY);
        Intrinsics.checkExpressionValueIsNotNull(stringTableTypes, "JvmProtoBuf.StringTableT\u2026nput, EXTENSION_REGISTRY)");
        JvmNameResolver nameResolver = new JvmNameResolver(stringTableTypes, strings);
        ProtoBuf.Class classProto = ProtoBuf.Class.parseFrom(input, EXTENSION_REGISTRY);
        NameResolver nameResolver2 = nameResolver;
        ProtoBuf.Class clazz = classProto;
        Intrinsics.checkExpressionValueIsNotNull(clazz, "classProto");
        return new ClassData(nameResolver2, clazz);
    }

    @JvmStatic
    @NotNull
    public static final PackageData readPackageDataFrom(@NotNull String[] data2, @NotNull String[] strings) {
        Intrinsics.checkParameterIsNotNull(data2, "data");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        byte[] byArray = BitEncoding.decodeBytes(data2);
        Intrinsics.checkExpressionValueIsNotNull(byArray, "BitEncoding.decodeBytes(data)");
        return JvmProtoBufUtil.readPackageDataFrom(byArray, strings);
    }

    @JvmStatic
    @NotNull
    public static final PackageData readPackageDataFrom(@NotNull byte[] bytes, @NotNull String[] strings) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        JvmProtoBuf.StringTableTypes stringTableTypes = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(input, EXTENSION_REGISTRY);
        Intrinsics.checkExpressionValueIsNotNull(stringTableTypes, "JvmProtoBuf.StringTableT\u2026nput, EXTENSION_REGISTRY)");
        JvmNameResolver nameResolver = new JvmNameResolver(stringTableTypes, strings);
        ProtoBuf.Package packageProto = ProtoBuf.Package.parseFrom(input, EXTENSION_REGISTRY);
        NameResolver nameResolver2 = nameResolver;
        ProtoBuf.Package package_ = packageProto;
        Intrinsics.checkExpressionValueIsNotNull(package_, "packageProto");
        return new PackageData(nameResolver2, package_);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final String getJvmMethodSignature(@NotNull ProtoBuf.Function proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        String string;
        int name2;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        JvmProtoBuf.JvmMethodSignature signature2 = proto.hasExtension(JvmProtoBuf.methodSignature) ? proto.getExtension(JvmProtoBuf.methodSignature) : null;
        int n = name2 = signature2 != null && signature2.hasName() ? signature2.getName() : proto.getName();
        if (signature2 != null && signature2.hasDesc()) {
            string = nameResolver.getString(signature2.getDesc());
        } else {
            void $receiver$iv$iv;
            Object object;
            void $receiver$iv$iv2;
            void $receiver$iv;
            Iterable iterable = proto.getValueParameterList();
            Collection collection = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.singletonOrEmptyList(ProtoTypeTableUtilKt.receiverType(proto, typeTable));
            void var8_8 = $receiver$iv;
            Iterable destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv2) {
                void it;
                ProtoBuf.ValueParameter valueParameter = (ProtoBuf.ValueParameter)item$iv$iv;
                object = destination$iv$iv;
                ProtoBuf.Type type2 = ProtoTypeTableUtilKt.type((ProtoBuf.ValueParameter)it, typeTable);
                object.add(type2);
            }
            object = (List)destination$iv$iv;
            List parameterTypes = CollectionsKt.plus(collection, (Iterable)object);
            Iterable $receiver$iv2 = parameterTypes;
            destination$iv$iv = $receiver$iv2;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void it;
                ProtoBuf.Type $i$a$1$map = (ProtoBuf.Type)item$iv$iv;
                collection = destination$iv$iv2;
                if (INSTANCE.mapTypeDefault((ProtoBuf.Type)it, nameResolver) == null) {
                    return null;
                }
                collection.add(object);
            }
            List parametersDesc = (List)destination$iv$iv2;
            String string2 = this.mapTypeDefault(ProtoTypeTableUtilKt.returnType(proto, typeTable), nameResolver);
            if (string2 == null) {
                return null;
            }
            String returnTypeDesc = string2;
            string = CollectionsKt.joinToString$default(parametersDesc, "", "(", ")", 0, null, null, 56, null) + returnTypeDesc;
        }
        String desc = string;
        return nameResolver.getString(name2) + desc;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final String getJvmConstructorSignature(@NotNull ProtoBuf.Constructor proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        String string;
        JvmProtoBuf.JvmMethodSignature signature2;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = signature2 = proto.hasExtension(JvmProtoBuf.constructorSignature) ? proto.getExtension(JvmProtoBuf.constructorSignature) : null;
        if (signature2 != null && signature2.hasDesc()) {
            string = nameResolver.getString(signature2.getDesc());
        } else {
            void $receiver$iv$iv;
            Iterable $receiver$iv;
            Iterable iterable = $receiver$iv = (Iterable)proto.getValueParameterList();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                String string2;
                void it;
                ProtoBuf.ValueParameter valueParameter = (ProtoBuf.ValueParameter)item$iv$iv;
                Collection collection = destination$iv$iv;
                if (INSTANCE.mapTypeDefault(ProtoTypeTableUtilKt.type((ProtoBuf.ValueParameter)it, typeTable), nameResolver) == null) {
                    return null;
                }
                collection.add(string2);
            }
            string = CollectionsKt.joinToString$default((List)destination$iv$iv, "", "(", ")V", 0, null, null, 56, null);
        }
        String desc = string;
        return "<init>" + desc;
    }

    @Nullable
    public final PropertySignature getJvmFieldSignature(@NotNull ProtoBuf.Property proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        String string;
        int name2;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (!proto.hasExtension(JvmProtoBuf.propertySignature)) {
            return null;
        }
        JvmProtoBuf.JvmPropertySignature signature2 = proto.getExtension(JvmProtoBuf.propertySignature);
        JvmProtoBuf.JvmFieldSignature field = signature2.hasField() ? signature2.getField() : null;
        int n = name2 = field != null && field.hasName() ? field.getName() : proto.getName();
        if (field != null && field.hasDesc()) {
            string = nameResolver.getString(field.getDesc());
        } else {
            string = this.mapTypeDefault(ProtoTypeTableUtilKt.returnType(proto, typeTable), nameResolver);
            if (string == null) {
                return null;
            }
        }
        String desc = string;
        String string2 = nameResolver.getString(name2);
        Intrinsics.checkExpressionValueIsNotNull(string2, "nameResolver.getString(name)");
        String string3 = desc;
        Intrinsics.checkExpressionValueIsNotNull(string3, "desc");
        return new PropertySignature(string2, string3);
    }

    private final String mapTypeDefault(ProtoBuf.Type type2, NameResolver nameResolver) {
        String string;
        if (type2.hasClassName()) {
            ClassId classId = nameResolver.getClassId(type2.getClassName());
            Intrinsics.checkExpressionValueIsNotNull(classId, "nameResolver.getClassId(type.className)");
            string = ClassMapperLite.mapClass(classId);
        } else {
            string = null;
        }
        return string;
    }

    private JvmProtoBufUtil() {
        JvmProtoBufUtil jvmProtoBufUtil;
        INSTANCE = this;
        JvmProtoBufUtil $receiver = jvmProtoBufUtil = this;
        ExtensionRegistryLite registry = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(registry);
        ExtensionRegistryLite extensionRegistryLite = registry;
        Intrinsics.checkExpressionValueIsNotNull(extensionRegistryLite, "registry");
        Intrinsics.checkExpressionValueIsNotNull(extensionRegistryLite, "run {\n        val regist\u2026y)\n        registry\n    }");
        EXTENSION_REGISTRY = extensionRegistryLite;
    }

    static {
        new JvmProtoBufUtil();
    }

    public static final class PropertySignature {
        @NotNull
        private final String name;
        @NotNull
        private final String desc;

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getDesc() {
            return this.desc;
        }

        public PropertySignature(@NotNull String name2, @NotNull String desc) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(desc, "desc");
            this.name = name2;
            this.desc = desc;
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final String component2() {
            return this.desc;
        }

        @NotNull
        public final PropertySignature copy(@NotNull String name2, @NotNull String desc) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(desc, "desc");
            return new PropertySignature(name2, desc);
        }

        @NotNull
        public static /* bridge */ /* synthetic */ PropertySignature copy$default(PropertySignature propertySignature, String string, String string2, int n, Object object) {
            if ((n & 1) != 0) {
                string = propertySignature.name;
            }
            if ((n & 2) != 0) {
                string2 = propertySignature.desc;
            }
            return propertySignature.copy(string, string2);
        }

        public String toString() {
            return "PropertySignature(name=" + this.name + ", desc=" + this.desc + ")";
        }

        public int hashCode() {
            String string = this.name;
            String string2 = this.desc;
            return (string != null ? string.hashCode() : 0) * 31 + (string2 != null ? string2.hashCode() : 0);
        }

        public boolean equals(Object object) {
            block3: {
                block2: {
                    if (this == object) break block2;
                    if (!(object instanceof PropertySignature)) break block3;
                    PropertySignature propertySignature = (PropertySignature)object;
                    if (!Intrinsics.areEqual(this.name, propertySignature.name) || !Intrinsics.areEqual(this.desc, propertySignature.desc)) break block3;
                }
                return true;
            }
            return false;
        }
    }
}

