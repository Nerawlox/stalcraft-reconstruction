/*
 * Decompiled with CFR 0.152.
 */
package api.player.forge;

import api.player.client.ClientPlayerClassVisitor;
import api.player.forge.PlayerAPIPlugin;
import api.player.server.ServerPlayerClassVisitor;
import net.minecraft.launchwrapper.IClassTransformer;

public class PlayerAPITransformer
implements IClassTransformer {
    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (string2.equals("net.minecraft.client.entity.EntityPlayerSP")) {
            return ClientPlayerClassVisitor.transform(byArray, PlayerAPIPlugin.isObfuscated);
        }
        if (string2.equals("net.minecraft.entity.player.EntityPlayerMP")) {
            return ServerPlayerClassVisitor.transform(byArray, PlayerAPIPlugin.isObfuscated);
        }
        return byArray;
    }
}

