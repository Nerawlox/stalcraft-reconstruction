/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning.gui;

import gloomyfolken.mods.stalker.mobs.client.tuning.EditorPropertyController;
import gloomyfolken.mods.stalker.mobs.client.tuning.EditorPropertyGroup;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigurationGroup;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/gui/ClientConfigHelper;", "", "()V", "getConfigController", "Lgloomyfolken/mods/stalker/mobs/client/tuning/EditorPropertyController;", "config", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "validateName", "", "name", "", "minecraft"})
public final class ClientConfigHelper {
    public static final ClientConfigHelper INSTANCE;

    @NotNull
    public final EditorPropertyController getConfigController(@NotNull MutantConfiguration mutantConfiguration) {
        EditorPropertyController editorPropertyController;
        Iterable iterable;
        Intrinsics.checkParameterIsNotNull(mutantConfiguration, "config");
        Iterable iterable2 = iterable = (Iterable)mutantConfiguration.getConfigurationGroups();
        Collection collection = new ArrayList();
        Iterable iterable3 = iterable2;
        for (Object t : iterable3) {
            EditorPropertyGroup<ConfigurationGroup> editorPropertyGroup;
            Object t2 = t;
            ConfigurationGroup configurationGroup = (ConfigurationGroup)t2;
            EditorPropertyGroup<ConfigurationGroup> editorPropertyGroup2 = configurationGroup.filterEditorGroup(mutantConfiguration.getCommon().getEntityClass()) ? new EditorPropertyGroup<ConfigurationGroup>(configurationGroup, configurationGroup.getGroupName()) : null;
            if (editorPropertyGroup2 == null) continue;
            EditorPropertyGroup<ConfigurationGroup> editorPropertyGroup3 = editorPropertyGroup = editorPropertyGroup2;
            collection.add(editorPropertyGroup3);
        }
        List list2 = (List)collection;
        iterable = list2;
        EditorPropertyController editorPropertyController2 = editorPropertyController;
        EditorPropertyController editorPropertyController3 = editorPropertyController;
        iterable2 = iterable;
        EditorPropertyGroup[] editorPropertyGroupArray = iterable2.toArray(new EditorPropertyGroup[iterable2.size()]);
        if (editorPropertyGroupArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        EditorPropertyGroup[] editorPropertyGroupArray2 = editorPropertyGroupArray;
        editorPropertyController2(editorPropertyGroupArray2);
        return editorPropertyController3;
    }

    public final boolean validateName(@NotNull String string) {
        String string2;
        Regex regex;
        Intrinsics.checkParameterIsNotNull(string, "name");
        CharSequence charSequence = string;
        charSequence = ((Object)StringsKt.trim(charSequence)).toString();
        return !(charSequence.length() == 0) && Regex.find$default(regex = new Regex("[^a-zA-Z0-9_]"), string2 = ((Object)StringsKt.trim(charSequence = string)).toString(), 0, 2, null) == null;
    }

    private ClientConfigHelper() {
        INSTANCE = this;
    }

    static {
        new ClientConfigHelper();
    }
}

