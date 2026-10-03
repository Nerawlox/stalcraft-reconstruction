// 
// Decompiled by Procyon v0.6.0
// 

package gloomyfolken.mods.stalker.mobs.client.tuning;

import kotlin.text.StringsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Annotation;
import org.jetbrains.annotations.Nullable;
import kotlin.collections.CollectionsKt;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import kotlin.Metadata;

@Metadata(mv = { 1, 1, 7 }, bv = { 1, 0, 2 }, k = 1, d1 = { "\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005?\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0002R\u0011\u0010\u0004\u001a\u00020\u0005?\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000?\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r?\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\r?\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010?\u0006 " }, d2 = { "Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup;", "T", "", "objectToEdit", "groupName", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getGroupName", "()Ljava/lang/String;", "getObjectToEdit", "()Ljava/lang/Object;", "Ljava/lang/Object;", "properties", "Ljava/util/LinkedHashMap;", "Ljava/lang/reflect/Field;", "getProperties", "()Ljava/util/LinkedHashMap;", "syntheticPropertyAnnotations", "Lgloomyfolken/mods/stalker/mobs/client/tuning/SyntheticPropertyAnnotation;", "getSyntheticPropertyAnnotations", "extractAnnotatedFields", "", "extractFieldByName", "fieldName", "syntheticPropertyAnnotation", "getClassHierarchyFields", "", "clz", "Ljava/lang/Class;", "setValue", "value", "Companion", "minecraft" })
public final class EditorPropertyGroup<T>
{
    @NotNull
    private final LinkedHashMap<String, Field> properties;
    @NotNull
    private final LinkedHashMap<String, SyntheticPropertyAnnotation> syntheticPropertyAnnotations;
    @NotNull
    private final T objectToEdit;
    @NotNull
    private final String groupName;
    private static final boolean OBFUSCATED = false;
    public static final Companion Companion;
    
    @NotNull
    public final LinkedHashMap<String, Field> getProperties() {
        return this.properties;
    }
    
    @NotNull
    public final LinkedHashMap<String, SyntheticPropertyAnnotation> getSyntheticPropertyAnnotations() {
        return this.syntheticPropertyAnnotations;
    }
    
    public final void extractAnnotatedFields() {
        final Iterable iterable = this.getClassHierarchyFields(this.objectToEdit.getClass());
        final Collection collection = new ArrayList();
        for (final Object next : iterable) {
            Object[] array;
            if ((array = ((Field)next).getDeclaredAnnotationsByType(EditorProperty.class)) == null) {
                array = new EditorProperty[0];
            }
            if (array.length != 0) {
                collection.add(next);
            }
        }
        for (final Field field : (List)collection) {
            field.setAccessible(true);
            this.properties.put(field.getName(), field);
        }
    }
    
    private final List<Field> getClassHierarchyFields(final Class<?> clazz) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        Intrinsics.checkExpressionValueIsNotNull((Object)declaredFields, "clz.declaredFields");
        final ArrayList arrayList = CollectionsKt.arrayListOf((Object[])Arrays.copyOf(declaredFields, declaredFields.length));
        for (Class<?> clazz2 = this.objectToEdit.getClass().getSuperclass(); Intrinsics.areEqual((Object)clazz2, (Object)Object.class) ^ true; clazz2 = clazz2.getSuperclass()) {
            final Collection collection = arrayList;
            final Field[] declaredFields2 = clazz2.getDeclaredFields();
            Intrinsics.checkExpressionValueIsNotNull((Object)declaredFields2, "superClz.declaredFields");
            CollectionsKt.addAll(collection, (Object[])declaredFields2);
        }
        return arrayList;
    }
    
    public final void setValue(@NotNull final String s, @NotNull final Object o) {
        Intrinsics.checkParameterIsNotNull((Object)s, "fieldName");
        Intrinsics.checkParameterIsNotNull(o, "value");
        final Field field = this.properties.get(s);
        if (field != null) {
            field.set(this.objectToEdit, o);
        }
    }
    
    @NotNull
    public final Field extractFieldByName(@NotNull final String s, @Nullable final SyntheticPropertyAnnotation syntheticPropertyAnnotation) {
        Intrinsics.checkParameterIsNotNull((Object)s, "fieldName");
        SyntheticPropertyAnnotation syntheticPropertyAnnotation2 = syntheticPropertyAnnotation;
        final Field field = this.properties.get(s);
        if (field != null) {
            return field;
        }
        Field field4 = null;
        Label_0666: {
            if (EditorPropertyGroup.Companion.getOBFUSCATED()) {
            Label_0456:
                while (true) {
                    for (final Object next : this.getClassHierarchyFields(this.objectToEdit.getClass())) {
                        final Field field2 = (Field)next;
                        final Object[] array = field2.getAnnotations();
                        final Collection collection = new ArrayList();
                        final Object[] array2 = array;
                        for (int i = 0; i < array2.length; ++i) {
                            Annotation annotation;
                            if (!((annotation = (Annotation)array2[i]) instanceof EditorProperty)) {
                                annotation = null;
                            }
                            final EditorProperty editorProperty = (EditorProperty)annotation;
                            if (editorProperty != null) {
                                collection.add(editorProperty);
                            }
                        }
                        final Iterator iterator2 = collection.iterator();
                        Field field3;
                        while (true) {
                            while (iterator2.hasNext()) {
                                if (Intrinsics.areEqual((Object)((EditorProperty)iterator2.next()).name(), (Object)s)) {
                                    final boolean b = true;
                                    boolean b3 = false;
                                    Label_0444: {
                                        Label_0439: {
                                            if (!b) {
                                                final Object[] array3 = field2.getAnnotations();
                                                final Collection collection2 = new ArrayList();
                                                final Object[] array4 = array3;
                                                for (int j = 0; j < array4.length; ++j) {
                                                    Annotation annotation2;
                                                    if (!((annotation2 = (Annotation)array4[j]) instanceof SerializedName)) {
                                                        annotation2 = null;
                                                    }
                                                    final SerializedName serializedName = (SerializedName)annotation2;
                                                    if (serializedName != null) {
                                                        collection2.add(serializedName);
                                                    }
                                                }
                                                final Iterator iterator3 = collection2.iterator();
                                                while (true) {
                                                    while (iterator3.hasNext()) {
                                                        if (Intrinsics.areEqual((Object)((SerializedName)iterator3.next()).value(), (Object)s)) {
                                                            final boolean b2 = true;
                                                            if (b2) {
                                                                break Label_0439;
                                                            }
                                                            b3 = false;
                                                            break Label_0444;
                                                        }
                                                    }
                                                    final boolean b2 = false;
                                                    continue;
                                                }
                                            }
                                        }
                                        b3 = true;
                                    }
                                    if (b3) {
                                        field3 = (Field)next;
                                        break Label_0456;
                                    }
                                    continue Label_0456;
                                }
                            }
                            final boolean b = false;
                            continue;
                        }
                        field4 = field3;
                        if (field4 != null) {
                            final Object[] array5 = field4.getAnnotations();
                            final Collection collection3 = new ArrayList();
                            final Object[] array6 = array5;
                            for (int k = 0; k < array6.length; ++k) {
                                Annotation annotation3;
                                if (!((annotation3 = (Annotation)array6[k]) instanceof EditorProperty)) {
                                    annotation3 = null;
                                }
                                final EditorProperty editorProperty2 = (EditorProperty)annotation3;
                                if (editorProperty2 != null) {
                                    collection3.add(editorProperty2);
                                }
                            }
                            final EditorProperty editorProperty3 = (EditorProperty)CollectionsKt.first((List)collection3);
                            syntheticPropertyAnnotation2 = new SyntheticPropertyAnnotation(editorProperty3.name(), editorProperty3.min(), editorProperty3.max(), Intrinsics.areEqual((Object)editorProperty3.show(), (Object)"true"), editorProperty3.special());
                        }
                        break Label_0666;
                    }
                    Field field3 = null;
                    continue Label_0456;
                }
            }
            try {
                field4 = this.objectToEdit.getClass().getField(s);
            }
            catch (final NoSuchFieldException ex) {
                field4 = this.objectToEdit.getClass().getDeclaredField(s);
            }
        }
        final LinkedHashMap<String, Field> properties = this.properties;
        final Field field5 = field4;
        if (field5 != null) {
            properties.put(s, field5);
            if (syntheticPropertyAnnotation2 != null) {
                this.syntheticPropertyAnnotations.put(s, syntheticPropertyAnnotation2);
            }
            field4.setAccessible(true);
            return field4;
        }
        throw new NoSuchFieldException("No field for name '" + s + "' was found in " + this.objectToEdit + '!');
    }
    
    @NotNull
    public final T getObjectToEdit() {
        return this.objectToEdit;
    }
    
    @NotNull
    public final String getGroupName() {
        return this.groupName;
    }
    
    public EditorPropertyGroup(@NotNull final T objectToEdit, @NotNull final String groupName) {
        Intrinsics.checkParameterIsNotNull((Object)objectToEdit, "objectToEdit");
        Intrinsics.checkParameterIsNotNull((Object)groupName, "groupName");
        this.objectToEdit = objectToEdit;
        this.groupName = groupName;
        this.properties = new LinkedHashMap<String, Field>();
        this.syntheticPropertyAnnotations = new LinkedHashMap<String, SyntheticPropertyAnnotation>();
        this.extractAnnotatedFields();
    }
    
    static {
        Companion = new Companion(null);
    }
    
    public static final /* synthetic */ boolean access$getOBFUSCATED$cp() {
        return EditorPropertyGroup.OBFUSCATED;
    }
    
    @Metadata(mv = { 1, 1, 7 }, bv = { 1, 0, 2 }, k = 1, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002?\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D?\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006?\u0006\u0007" }, d2 = { "Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup$Companion;", "", "()V", "OBFUSCATED", "", "getOBFUSCATED", "()Z", "minecraft" })
    public static final class Companion
    {
        public final boolean getOBFUSCATED() {
            return EditorPropertyGroup.access$getOBFUSCATED$cp();
        }
        
        private Companion() {
        }
    }
}
