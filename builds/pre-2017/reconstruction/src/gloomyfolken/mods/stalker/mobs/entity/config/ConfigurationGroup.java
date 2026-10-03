/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigurationGroup;", "", "groupId", "", "groupName", "(Ljava/lang/String;Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "getGroupName", "filterEditorGroup", "", "mobType", "minecraft"})
public abstract class ConfigurationGroup {
    @NotNull
    private final transient String groupId;
    @NotNull
    private final transient String groupName;

    public boolean filterEditorGroup(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "mobType");
        return true;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    public final String getGroupName() {
        return this.groupName;
    }

    public ConfigurationGroup(@NotNull String string, @NotNull String string2) {
        Intrinsics.checkParameterIsNotNull(string, "groupId");
        Intrinsics.checkParameterIsNotNull(string2, "groupName");
        this.groupId = string;
        this.groupName = string2;
    }
}

