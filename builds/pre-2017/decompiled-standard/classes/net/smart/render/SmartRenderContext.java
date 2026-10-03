/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import java.util.Map;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
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
        tfvm tfvm2;
        if (map == null && gqqu._b != null) {
            map = (Map)Reflect.GetField(gqqu.class, gqqu._b, Install.RenderManager_entityRenderMap);
        }
        if (map == null) {
            return false;
        }
        try {
            tfvm2 = (tfvm)clazz.newInstance();
        }
        catch (Exception exception) {
            return false;
        }
        map.put(EntityPlayerSP.class, tfvm2);
        map.put(EntityOtherPlayerMP.class, tfvm2);
        tfvm2.func_76976_a(gqqu._b);
        return true;
    }
}

