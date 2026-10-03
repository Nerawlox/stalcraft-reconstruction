/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.permissions;

import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.server.MinecraftServer;
import noppes.npcs.permissions.PermissionsInterface;

public class CustomNpcsPermissions
implements PermissionsInterface {
    private static final String[] permissions = new String[]{"-customnpcs.*"};
    public static PermissionsInterface Instance = new CustomNpcsPermissions();

    @Override
    public boolean hasPermission(String string, String string2) {
        if (string2.equals("customnpcs.npc.editgroup") || string2.equals("customnpcs.npc.approve") || string2.equals("customnpcs.npc.editall") || string2.equals("customnpcs.npc.deleteall")) {
            return MinecraftServer._I().__ag()._g(string);
        }
        if (string2.equals("customnpcs.npc.reapprove") || string2.equals("customnpcs.npc.command")) {
            return GloomyCore.isSuperUser(string);
        }
        return true;
    }
}

