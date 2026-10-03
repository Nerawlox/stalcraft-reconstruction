/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import java.util.Map;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.smart.render.RenderPlayer;
import net.smart.utilities.Install;
import net.smart.utilities.Reflect;
import net.smart.utilities.Utilities;

public abstract class SmartRenderContext
extends Utilities {
    public static boolean registerAnimation(Map map) {
        return SmartRenderContext.registerAnimation(map, RenderPlayer.class);
    }

    public static boolean registerAnimation(Map map, Class clazz) {
        Render render;
        if (map == null && RenderManager._b != null) {
            map = (Map)Reflect.GetField(RenderManager.class, RenderManager._b, Install.RenderManager_entityRenderMap);
        }
        if (map == null) {
            return false;
        }
        try {
            render = (Render)clazz.newInstance();
        }
        catch (Exception exception) {
            return false;
        }
        map.put(EntityPlayerSP.class, render);
        map.put(EntityOtherPlayerMP.class, render);
        render.setRenderManager(RenderManager._b);
        return true;
    }
}

