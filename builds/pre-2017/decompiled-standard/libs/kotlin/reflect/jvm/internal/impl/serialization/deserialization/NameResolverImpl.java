/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverImpl$WhenMappings;
import org.jetbrains.annotations.NotNull;

public final class NameResolverImpl
implements NameResolver {
    private final ProtoBuf.StringTable strings;
    private final ProtoBuf.QualifiedNameTable qualifiedNames;

    @Override
    @NotNull
    public String getString(int index) {
        String string = this.strings.getString(index);
        Intrinsics.checkExpressionValueIsNotNull(string, "strings.getString(index)");
        return string;
    }

    @Override
    @NotNull
    public Name getName(int index) {
        return Name.guessByFirstCharacter(this.strings.getString(index));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public ClassId getClassId(int index) {
        void isLocal;
        void relativeClassNameSegments;
        void packageFqNameSegments;
        Triple<List<String>, List<String>, Boolean> triple = this.traverseIds(index);
        List<String> list = triple.component1();
        List<String> list2 = triple.component2();
        boolean bl = triple.component3();
        triple = null;
        return new ClassId(FqName.fromSegments((List<String>)packageFqNameSegments), FqName.fromSegments((List<String>)relativeClassNameSegments), (boolean)isLocal);
    }

    @NotNull
    public final FqName getPackageFqName(int index) {
        List<String> packageNameSegments = this.traverseIds(index).getFirst();
        FqName fqName2 = FqName.fromSegments(packageNameSegments);
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "FqName.fromSegments(packageNameSegments)");
        return fqName2;
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int startingIndex) {
        int index = startingIndex;
        LinkedList<String> packageNameSegments = new LinkedList<String>();
        LinkedList<String> relativeClassNameSegments = new LinkedList<String>();
        boolean local = false;
        while (index != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName proto = this.qualifiedNames.getQualifiedName(index);
            String shortName = this.strings.getString(proto.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = proto.getKind();
            if (kind == null) {
                Intrinsics.throwNpe();
            }
            switch (NameResolverImpl$WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
                case 1: {
                    relativeClassNameSegments.addFirst(shortName);
                    break;
                }
                case 2: {
                    packageNameSegments.addFirst(shortName);
                    break;
                }
                case 3: {
                    relativeClassNameSegments.addFirst(shortName);
                    local = true;
                }
            }
            index = proto.getParentQualifiedName();
        }
        return new Triple<List<String>, List<String>, Boolean>(packageNameSegments, relativeClassNameSegments, local);
    }

    public NameResolverImpl(@NotNull ProtoBuf.StringTable strings, @NotNull ProtoBuf.QualifiedNameTable qualifiedNames) {
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        Intrinsics.checkParameterIsNotNull(qualifiedNames, "qualifiedNames");
        this.strings = strings;
        this.qualifiedNames = qualifiedNames;
    }
}

