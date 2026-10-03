/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning;

import gloomyfolken.mods.stalker.mobs.client.tuning.EditorPropertyGroup;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J9\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t0\t2\u0012\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0006H\u0002\u00a2\u0006\u0002\u0010\u0014J2\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t0\t2\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0001J\u0006\u0010\u001a\u001a\u00020\u000eR&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyController;", "", "group", "Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup;", "(Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup;)V", "groups", "", "([Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup;)V", "clonedValueGroups", "", "", "groupMap", "[Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup;", "cancelAllEdits", "", "getPropertyGroups", "", "hasChanges", "", "setInitialValues", "([Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyGroup;)Ljava/util/Map;", "", "setValueForGroup", "groupKey", "key", "value", "updateValuesDirtyFlag", "minecraft"})
public final class EditorPropertyController {
    private Map<String, ? extends Map<String, ? extends Object>> clonedValueGroups;
    private final Map<String, EditorPropertyGroup<?>> groupMap;
    private final EditorPropertyGroup<?>[] groups;

    private final Map<String, Map<String, Object>> setInitialValues(EditorPropertyGroup<?>[] editorPropertyGroupArray) {
        return this.setInitialValues((Collection)ArraysKt.toList((Object[])editorPropertyGroupArray));
    }

    private final Map<String, Map<String, Object>> setInitialValues(Collection<? extends EditorPropertyGroup<?>> collection) {
        Iterable iterable;
        Iterable iterable2 = iterable = (Iterable)collection;
        Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object t : iterable2) {
            Collection collection3;
            EditorPropertyGroup editorPropertyGroup = (EditorPropertyGroup)t;
            Collection collection4 = collection2;
            Map map = editorPropertyGroup.getProperties();
            String string = editorPropertyGroup.getGroupName();
            Map map2 = map;
            Collection collection5 = new ArrayList(map.size());
            Map map3 = map2;
            Iterator iterator2 = map3.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry entry;
                Map.Entry entry2 = entry = iterator2.next();
                collection3 = collection5;
                Pair pair = TuplesKt.to(entry2.getKey(), ((Field)entry2.getValue()).get(editorPropertyGroup.getObjectToEdit()));
                collection3.add(pair);
            }
            collection3 = (List)collection5;
            Pair pair = TuplesKt.to(string, MapsKt.toMap(collection3));
            collection4.add(pair);
        }
        return MapsKt.toMap((List)collection2);
    }

    public final void updateValuesDirtyFlag() {
        this.clonedValueGroups = this.setInitialValues(this.groups);
    }

    public final boolean hasChanges() {
        EditorPropertyController editorPropertyController;
        boolean bl = false;
        EditorPropertyController editorPropertyController2 = editorPropertyController = this;
        Object[] objectArray = this.groups;
        block0: for (int i = 0; i < objectArray.length; ++i) {
            Map map;
            Object object = objectArray[i];
            EditorPropertyGroup editorPropertyGroup = (EditorPropertyGroup)object;
            Map map2 = map = (Map)editorPropertyGroup.getProperties();
            Iterator iterator2 = map2.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry entry;
                Map.Entry entry2 = entry = iterator2.next();
                Object object2 = ((Field)entry2.getValue()).get(editorPropertyGroup.getObjectToEdit());
                Map<String, ? extends Object> map3 = this.clonedValueGroups.get(editorPropertyGroup.getGroupName());
                if (map3 == null) {
                    Intrinsics.throwNpe();
                }
                Object object3 = map3.get(entry2.getKey());
                if (object3 == null) {
                    Intrinsics.throwNpe();
                }
                if (!(Intrinsics.areEqual(object2, object3) ^ true)) continue;
                bl = true;
                break block0;
            }
        }
        return bl;
    }

    @NotNull
    public final List<EditorPropertyGroup<?>> getPropertyGroups() {
        return ArraysKt.asList((Object[])this.groups);
    }

    public final void setValueForGroup(@NotNull String string, @NotNull String string2, @NotNull Object object) {
        block0: {
            Intrinsics.checkParameterIsNotNull(string, "groupKey");
            Intrinsics.checkParameterIsNotNull(string2, "key");
            Intrinsics.checkParameterIsNotNull(object, "value");
            EditorPropertyGroup<?> editorPropertyGroup = this.groupMap.get(string);
            if (editorPropertyGroup == null) break block0;
            editorPropertyGroup.setValue(string2, object);
        }
    }

    public final void cancelAllEdits() {
        Object[] objectArray = this.groups;
        for (int i = 0; i < objectArray.length; ++i) {
            Object object = objectArray[i];
            EditorPropertyGroup editorPropertyGroup = (EditorPropertyGroup)object;
            Iterable iterable = editorPropertyGroup.getProperties().keySet();
            for (Object t : iterable) {
                String string;
                String string2 = string = (String)t;
                Intrinsics.checkExpressionValueIsNotNull(string2, "key");
                Map<String, ? extends Object> map = this.clonedValueGroups.get(editorPropertyGroup.getGroupName());
                if (map == null) {
                    Intrinsics.throwNpe();
                }
                Object object2 = map.get(string);
                if (object2 == null) {
                    Intrinsics.throwNpe();
                }
                editorPropertyGroup.setValue(string2, object2);
            }
        }
    }

    public EditorPropertyController(@NotNull EditorPropertyGroup<?>[] editorPropertyGroupArray) {
        Collection<Pair<String, EditorPropertyGroup>> collection;
        Intrinsics.checkParameterIsNotNull(editorPropertyGroupArray, "groups");
        this.groups = editorPropertyGroupArray;
        this.clonedValueGroups = this.setInitialValues(this.groups);
        Object[] objectArray = this.groups;
        EditorPropertyController editorPropertyController = this;
        Object[] objectArray2 = objectArray;
        Collection collection2 = new ArrayList(objectArray.length);
        for (int i = 0; i < objectArray2.length; ++i) {
            Object object = objectArray2[i];
            EditorPropertyGroup editorPropertyGroup = (EditorPropertyGroup)object;
            collection = collection2;
            Pair<String, EditorPropertyGroup> pair = TuplesKt.to(editorPropertyGroup.getGroupName(), editorPropertyGroup);
            collection.add(pair);
        }
        collection = (List)collection2;
        editorPropertyController.groupMap = MapsKt.toMap((Iterable)collection);
    }

    public EditorPropertyController(@NotNull EditorPropertyGroup<?> editorPropertyGroup) {
        Intrinsics.checkParameterIsNotNull(editorPropertyGroup, "group");
        Object[] objectArray = new EditorPropertyGroup[]{editorPropertyGroup};
        EditorPropertyController editorPropertyController = this;
        Object[] objectArray2 = objectArray;
        editorPropertyController((EditorPropertyGroup[])objectArray2);
    }
}

