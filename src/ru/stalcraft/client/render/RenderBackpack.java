/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  net.minecraftforge.client.model.IModelCustom
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.models.ModelBackpackBig;
import ru.stalcraft.client.models.ModelBackpackMedium;
import ru.stalcraft.client.models.ModelBackpackSmall;

public class RenderBackpack {
    private static bjo texture_small = new bjo("stalker", "textures/backpack_small.png");
    private static bjo texture_medium = new bjo("stalker", "textures/backpack_medium.png");
    private static bjo texture_big = new bjo("stalker", "textures/backpack_big.png");
    private static ModelBackpackBig modelBackpackBig = new ModelBackpackBig();
    private static ModelBackpackMedium modelBackpackMedium = new ModelBackpackMedium();
    private static ModelBackpackSmall modelBackpackSmall = new ModelBackpackSmall();
    private static IModelCustom modelBackpack = ClientProxy.modelManager.getModel("items", "backpack.tcn");
    private static bjo textureBackpack = new bjo("stalker", "textures/items/backpack_texture.png");

    public static void renderBackpack(nn entity, int backpack) {
        if (backpack == StalkerMain.backpack1.cv) {
            atv.w().N.a(texture_small);
            modelBackpackSmall.a(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        } else if (backpack == StalkerMain.backpack2.cv) {
            modelBackpack = ClientProxy.modelManager.getModel("items", "backpack.tcn");
            textureBackpack = new bjo("stalker", "models/items/backpack_texture.png");
            ClientProxy.modelManager.tryLoadTexture(textureBackpack);
            if (modelBackpack != null && ClientProxy.modelManager.tryBindTexture(textureBackpack)) {
                GL11.glTranslatef((float)0.0f, (float)0.8f, (float)0.0f);
                GL11.glScalef((float)0.0325f, (float)0.0325f, (float)0.0325f);
                modelBackpack.renderAll();
            }
        } else if (backpack == StalkerMain.backpack3.cv) {
            atv.w().N.a(texture_big);
            modelBackpackBig.a(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        }
    }
}

