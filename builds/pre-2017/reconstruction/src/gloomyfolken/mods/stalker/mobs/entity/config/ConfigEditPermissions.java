/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/ConfigEditPermissions;", "", "(Ljava/lang/String;I)V", "ALL", "SPECIAL_CONFIG_EDIT", "VIEWER", "minecraft"})
public final class ConfigEditPermissions
extends Enum<ConfigEditPermissions> {
    public static final /* enum */ ConfigEditPermissions ALL;
    public static final /* enum */ ConfigEditPermissions SPECIAL_CONFIG_EDIT;
    public static final /* enum */ ConfigEditPermissions VIEWER;
    private static final /* synthetic */ ConfigEditPermissions[] $VALUES;

    static {
        ConfigEditPermissions[] configEditPermissionsArray = new ConfigEditPermissions[3];
        ConfigEditPermissions[] configEditPermissionsArray2 = configEditPermissionsArray;
        configEditPermissionsArray[0] = ALL = new ConfigEditPermissions();
        configEditPermissionsArray[1] = SPECIAL_CONFIG_EDIT = new ConfigEditPermissions();
        configEditPermissionsArray[2] = VIEWER = new ConfigEditPermissions();
        $VALUES = configEditPermissionsArray;
    }

    public static ConfigEditPermissions[] values() {
        return (ConfigEditPermissions[])$VALUES.clone();
    }

    public static ConfigEditPermissions valueOf(String string) {
        return Enum.valueOf(ConfigEditPermissions.class, string);
    }
}

