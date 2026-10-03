/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorProperty;
import gloomyfolken.mods.stalker.mobs.client.tuning.SyntheticPropertyAnnotation;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006 "}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup;", "T", "", "objectToEdit", "groupName", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getGroupName", "()Ljava/lang/String;", "getObjectToEdit", "()Ljava/lang/Object;", "Ljava/lang/Object;", "properties", "Ljava/util/LinkedHashMap;", "Ljava/lang/reflect/Field;", "getProperties", "()Ljava/util/LinkedHashMap;", "syntheticPropertyAnnotations", "Lgloomyfolken/mods/stalker/mobs/client/tuning/SyntheticPropertyAnnotation;", "getSyntheticPropertyAnnotations", "extractAnnotatedFields", "", "extractFieldByName", "fieldName", "syntheticPropertyAnnotation", "getClassHierarchyFields", "", "clz", "Ljava/lang/Class;", "setValue", "value", "Companion", "minecraft"})
public final class EditorPropertyGroup<T> {
    @NotNull
    private final LinkedHashMap<String, Field> properties;
    @NotNull
    private final LinkedHashMap<String, SyntheticPropertyAnnotation> syntheticPropertyAnnotations;
    @NotNull
    private final T objectToEdit;
    @NotNull
    private final String groupName;
    private static final boolean OBFUSCATED = false;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final LinkedHashMap<String, Field> getProperties() {
        return this.properties;
    }

    @NotNull
    public final LinkedHashMap<String, SyntheticPropertyAnnotation> getSyntheticPropertyAnnotations() {
        return this.syntheticPropertyAnnotations;
    }

    public final void extractAnnotatedFields() {
        Iterable iterable;
        List<Field> list = this.getClassHierarchyFields(this.objectToEdit.getClass());
        Iterable iterable2 = iterable = (Iterable)list;
        Collection collection = new ArrayList();
        for (Object t : iterable2) {
            Object[] objectArray;
            Object[] objectArray2;
            Field field = (Field)t;
            Object[] objectArray3 = objectArray2 = (Object[])field.getDeclaredAnnotationsByType(EditorProperty.class);
            if (objectArray2 == null) {
                objectArray3 = new EditorProperty[]{};
            }
            if (!(!((objectArray = (objectArray2 = objectArray3)).length == 0))) continue;
            collection.add(t);
        }
        for (Field field : (List)collection) {
            field.setAccessible(true);
            this.properties.put(field.getName(), field);
        }
    }

    private final List<Field> getClassHierarchyFields(Class<?> clazz) {
        Field[] fieldArray = clazz.getDeclaredFields();
        Intrinsics.checkExpressionValueIsNotNull(fieldArray, "clz.declaredFields");
        ArrayList<Field> arrayList = CollectionsKt.arrayListOf(Arrays.copyOf(fieldArray, fieldArray.length));
        Class<?> clazz2 = this.objectToEdit.getClass().getSuperclass();
        while (Intrinsics.areEqual(clazz2, Object.class) ^ true) {
            Collection collection = arrayList;
            Field[] fieldArray2 = clazz2.getDeclaredFields();
            Intrinsics.checkExpressionValueIsNotNull(fieldArray2, "superClz.declaredFields");
            Object[] objectArray = fieldArray2;
            CollectionsKt.addAll(collection, objectArray);
            clazz2 = clazz2.getSuperclass();
        }
        return arrayList;
    }

    public final void setValue(@NotNull String string, @NotNull Object object) {
        block0: {
            Intrinsics.checkParameterIsNotNull(string, "fieldName");
            Intrinsics.checkParameterIsNotNull(object, "value");
            Field field = this.properties.get(string);
            if (field == null) break block0;
            field.set(this.objectToEdit, object);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @NotNull
    public final Field extractFieldByName(@NotNull String var1_1, @Nullable SyntheticPropertyAnnotation var2_2) {
        block21: {
            block20: {
                block19: {
                    Intrinsics.checkParameterIsNotNull(var1_1, "fieldName");
                    var3_3 = var2_2;
                    var4_4 = this.properties.get(var1_1);
                    if (var4_4 != null) {
                        return var4_4;
                    }
                    if (!EditorPropertyGroup.Companion.getOBFUSCATED()) break block20;
                    var5_5 = this.getClassHierarchyFields(this.objectToEdit.getClass());
                    var6_7 = var5_5.iterator();
                    while (var6_7.hasNext()) {
                        block18: {
                            block17: {
                                var7_8 /* !! */  = var6_7.next();
                                var8_9 = (Field)var7_8 /* !! */ ;
                                var10_11 = var9_10 = (Object[])var8_9.getAnnotations();
                                var11_13 = new ArrayList<E>();
                                var12_14 = var10_11;
                                for (var13_15 = 0; var13_15 < ((Object[])var12_14).length; ++var13_15) {
                                    var14_18 = var12_14[var13_15];
                                    var15_19 = var14_18;
                                    var16_20 = (Annotation)var15_19;
                                    v0 = var16_20;
                                    if (!(v0 instanceof EditorProperty)) {
                                        v0 = null;
                                    }
                                    if ((EditorProperty)v0 == null) continue;
                                    var18_22 = var17_21 /* !! */ ;
                                    var11_13.add(var18_22);
                                }
                                var9_10 = (List)var11_13;
                                var10_11 = var9_10.iterator();
                                while (var10_11.hasNext()) {
                                    var11_13 = var10_11.next();
                                    var12_14 = (EditorProperty)var11_13;
                                    if (!Intrinsics.areEqual(var12_14.name(), var1_1)) continue;
                                    v1 = true;
                                    break block17;
                                }
                                v1 = false;
                            }
                            if (v1) ** GOTO lbl-1000
                            var10_11 = var9_10 = (Object[])var8_9.getAnnotations();
                            var11_13 = new ArrayList<E>();
                            var12_14 = var10_11;
                            for (var13_15 = 0; var13_15 < ((Object)var12_14).length; ++var13_15) {
                                var14_18 = var12_14[var13_15];
                                var15_19 = var14_18;
                                var16_20 = (Annotation)var15_19;
                                v2 = var16_20;
                                if (!(v2 instanceof SerializedName)) {
                                    v2 = null;
                                }
                                if ((SerializedName)v2 == null) continue;
                                var18_22 = var17_21 /* !! */ ;
                                var11_13.add(var18_22);
                            }
                            var9_10 = (List)var11_13;
                            var10_11 = var9_10.iterator();
                            while (var10_11.hasNext()) {
                                var11_13 = var10_11.next();
                                var12_14 = (SerializedName)var11_13;
                                if (!Intrinsics.areEqual(var12_14.value(), var1_1)) continue;
                                v3 = true;
                                break block18;
                            }
                            v3 = false;
                        }
                        if (v3) lbl-1000:
                        // 2 sources

                        {
                            v4 = true;
                        } else {
                            v4 = false;
                        }
                        if (!v4) continue;
                        v5 = var7_8 /* !! */ ;
                        break block19;
                    }
                    v5 = null;
                }
                var4_4 = v5;
                if (var4_4 != null) {
                    var6_7 = var4_4.getAnnotations();
                    var7_8 /* !! */  = var6_7;
                    var8_9 = new ArrayList<E>();
                    var9_10 = var7_8 /* !! */ ;
                    for (var10_12 = 0; var10_12 < ((Object[])var9_10).length; ++var10_12) {
                        var11_13 = var9_10[var10_12];
                        var12_14 = var11_13;
                        var13_17 = (Annotation)var12_14;
                        v6 = var13_17;
                        if (!(v6 instanceof EditorProperty)) {
                            v6 = null;
                        }
                        if ((EditorProperty)v6 == null) continue;
                        var16_20 = var15_19;
                        var8_9.add(var16_20);
                    }
                    var5_5 = (EditorProperty)CollectionsKt.first((List)var8_9);
                    var3_3 = new SyntheticPropertyAnnotation(var5_5.name(), var5_5.min(), var5_5.max(), Intrinsics.areEqual(var5_5.show(), "true"), var5_5.special());
                }
                break block21;
            }
            try {
                var4_4 = this.objectToEdit.getClass().getField(var1_1);
            }
            catch (NoSuchFieldException var5_6) {
                var4_4 = this.objectToEdit.getClass().getDeclaredField(var1_1);
            }
        }
        v7 = var4_4;
        if (v7 == null) {
            throw (Throwable)new NoSuchFieldException("No field for name '" + var1_1 + "' was found in " + this.objectToEdit + '!');
        }
        this.properties.put(var1_1, v7);
        if (var3_3 != null) {
            this.syntheticPropertyAnnotations.put(var1_1, var3_3);
        }
        var4_4.setAccessible(true);
        return var4_4;
    }

    @NotNull
    public static /* synthetic */ Field extractFieldByName$default(EditorPropertyGroup editorPropertyGroup, String string, SyntheticPropertyAnnotation syntheticPropertyAnnotation, int n, Object object) {
        if ((n & 2) != 0) {
            syntheticPropertyAnnotation = new SyntheticPropertyAnnotation(string, "-5", "5", false, "");
        }
        return editorPropertyGroup.extractFieldByName(string, syntheticPropertyAnnotation);
    }

    @NotNull
    public final T getObjectToEdit() {
        return this.objectToEdit;
    }

    @NotNull
    public final String getGroupName() {
        return this.groupName;
    }

    public EditorPropertyGroup(@NotNull T t, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(t, "objectToEdit");
        Intrinsics.checkParameterIsNotNull(string, "groupName");
        this.objectToEdit = t;
        this.groupName = string;
        this.properties = new LinkedHashMap();
        this.syntheticPropertyAnnotations = new LinkedHashMap();
        this.extractAnnotatedFields();
    }

    public /* synthetic */ EditorPropertyGroup(Object object, String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            string = StringsKt.capitalize(StringsKt.substringAfterLast$default(object.getClass().getName(), ".", null, 2, null));
        }
        this(object, string);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup$Companion;", "", "()V", "OBFUSCATED", "", "getOBFUSCATED", "()Z", "minecraft"})
    public static final class Companion {
        public final boolean getOBFUSCATED() {
            return OBFUSCATED;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

