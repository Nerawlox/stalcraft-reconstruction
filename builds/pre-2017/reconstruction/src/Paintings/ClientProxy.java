/*
 * Decompiled with CFR 0.152.
 */
package Paintings;

import Paintings.CommonProxy;
import Paintings.RenderPaintingLate;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.entity.item.EntityPainting;

public class ClientProxy
extends CommonProxy {
    @Override
    public void registerRenderInformation() {
        RenderingRegistry.registerEntityRenderingHandler(EntityPainting.class, new RenderPaintingLate());
    }
}

