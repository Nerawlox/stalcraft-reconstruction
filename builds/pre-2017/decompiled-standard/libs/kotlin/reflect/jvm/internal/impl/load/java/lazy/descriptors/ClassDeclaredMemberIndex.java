/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClassDeclaredMemberIndex
implements DeclaredMemberIndex {
    private final Function1<JavaMethod, Boolean> methodFilter;
    private final Map<Name, List<JavaMethod>> methods;
    private final Map<Name, JavaField> fields;
    @NotNull
    private final JavaClass jClass;
    @NotNull
    private final Function1<JavaMember, Boolean> memberFilter;

    @Override
    @NotNull
    public Collection<JavaMethod> findMethodsByName(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        List<JavaMethod> list = this.methods.get(name2);
        return list != null ? (Collection)list : (Collection)CollectionsKt.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getMethodNames() {
        void var2_2;
        void $receiver$iv;
        Sequence<JavaMethod> sequence = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getMethods()), this.methodFilter);
        Collection destination$iv = new LinkedHashSet();
        Iterator iterator2 = $receiver$iv.iterator();
        while (iterator2.hasNext()) {
            void receiver;
            Object item$iv;
            Object t = item$iv = iterator2.next();
            Collection collection = destination$iv;
            Name name2 = ((JavaMethod)receiver).getName();
            collection.add(name2);
        }
        return (Set)var2_2;
    }

    @Override
    @Nullable
    public JavaField findFieldByName(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return this.fields.get(name2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getFieldNames() {
        void var2_2;
        void $receiver$iv;
        Sequence<JavaMember> sequence = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getFields()), this.memberFilter);
        Collection destination$iv = new LinkedHashSet();
        Iterator iterator2 = $receiver$iv.iterator();
        while (iterator2.hasNext()) {
            void receiver;
            Object item$iv;
            Object t = item$iv = iterator2.next();
            Collection collection = destination$iv;
            Name name2 = ((JavaField)receiver).getName();
            collection.add(name2);
        }
        return (Set)var2_2;
    }

    @NotNull
    public final JavaClass getJClass() {
        return this.jClass;
    }

    @NotNull
    public final Function1<JavaMember, Boolean> getMemberFilter() {
        return this.memberFilter;
    }

    public ClassDeclaredMemberIndex(@NotNull JavaClass jClass, @NotNull Function1<? super JavaMember, Boolean> memberFilter) {
        Map map2;
        JavaMember m;
        Object element$iv$iv;
        Sequence<JavaMember> $receiver$iv$iv;
        Sequence<JavaMember> $receiver$iv;
        Intrinsics.checkParameterIsNotNull(jClass, "jClass");
        Intrinsics.checkParameterIsNotNull(memberFilter, "memberFilter");
        this.jClass = jClass;
        this.memberFilter = memberFilter;
        this.methodFilter = new Function1<JavaMethod, Boolean>(this){
            final /* synthetic */ ClassDeclaredMemberIndex this$0;

            public final boolean invoke(@NotNull JavaMethod m) {
                Intrinsics.checkParameterIsNotNull(m, "m");
                return this.this$0.getMemberFilter().invoke(m) != false && !DescriptorResolverUtils.isObjectMethodInInterface(m);
            }
            {
                this.this$0 = classDeclaredMemberIndex;
                super(1);
            }
        };
        Sequence<JavaMethod> sequence = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getMethods()), this.methodFilter);
        ClassDeclaredMemberIndex classDeclaredMemberIndex = this;
        void var5_5 = $receiver$iv;
        Map destination$iv$iv = new LinkedHashMap();
        Iterator<Object> iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object object;
            Map $receiver$iv$iv$iv = destination$iv$iv;
            element$iv$iv = iterator2.next();
            m = (JavaMethod)element$iv$iv;
            Name key$iv$iv = m.getName();
            Object value$iv$iv$iv = $receiver$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                ArrayList answer$iv$iv$iv = new ArrayList();
                $receiver$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                object = answer$iv$iv$iv;
            } else {
                object = value$iv$iv$iv;
            }
            List list$iv$iv = (List)object;
            list$iv$iv.add(element$iv$iv);
        }
        classDeclaredMemberIndex.methods = map2 = destination$iv$iv;
        $receiver$iv = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getFields()), this.memberFilter);
        classDeclaredMemberIndex = this;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new LinkedHashMap();
        iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            element$iv$iv = iterator2.next();
            m = (JavaField)element$iv$iv;
            map2 = destination$iv$iv;
            Name name2 = m.getName();
            map2.put(name2, element$iv$iv);
        }
        classDeclaredMemberIndex.fields = map2 = destination$iv$iv;
    }
}

