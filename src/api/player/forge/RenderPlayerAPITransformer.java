/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.IClassTransformer
 */
package api.player.forge;

import api.player.forge.RenderPlayerAPIPlugin;
import api.player.model.ModelPlayerClassVisitor;
import api.player.render.RenderPlayerClassVisitor;
import java.util.Hashtable;
import java.util.Stack;
import net.minecraft.launchwrapper.IClassTransformer;

public class RenderPlayerAPITransformer
implements IClassTransformer {
    public byte[] transform(String var1, String var2, byte[] var3) {
        if (var2.equals("net.minecraft.client.renderer.entity.RenderPlayer")) {
            Stack<String> var4 = new Stack<String>();
            var4.push("api/player/model/ModelPlayer:armor");
            var4.push("api/player/model/ModelPlayer:chestplate");
            var4.push("api/player/model/ModelPlayer:main");
            Hashtable<String, Stack<String>> var5 = new Hashtable<String, Stack<String>>();
            var5.put("bbj", var4);
            var5.put("net/minecraft/client/model/ModelBiped", var4);
            return RenderPlayerClassVisitor.transform(var3, RenderPlayerAPIPlugin.isObfuscated, var5);
        }
        return var2.equals("api.player.model.ModelPlayer") ? ModelPlayerClassVisitor.transform(var3, RenderPlayerAPIPlugin.isObfuscated) : var3;
    }
}

