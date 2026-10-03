/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.HookPriority;
import gloomyfolken.hooklib.asm.ReturnCondition;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemAtlasHooks {
    public static boolean _a = System.getProperty("disable_item_atlas", "false").equals("true");

    @ezey(_a={eidj.CLIENT})
    public static void bindItemTexture(ItemStack itemStack, float f) {
        if (itemStack._c() == 0) {
            Minecraft._E()._h._a(sctd._c);
        } else {
            ItemAtlasHooks.bindItemTexture(itemStack._b(), f);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static void bindItemTexture(Icon icon, float f) {
        if (!_a) {
            return;
        }
        if (icon instanceof TextureAtlasFullSprite) {
            TextureAtlasFullSprite textureAtlasFullSprite = (TextureAtlasFullSprite)icon;
            sctg sctg2 = ((TextureAtlasFullSprite)icon)._a;
            if (sctg2 instanceof kkwv) {
                kkwv kkwv2 = (kkwv)sctg2;
                if (kkwv2._q()) {
                    temw temw2 = (temw)kkwv2._u_();
                    hbmu hbmu2 = temw2._c();
                    textureAtlasFullSprite.width = hbmu2._b(temw2._b());
                    textureAtlasFullSprite.height = hbmu2._c(temw2._b());
                }
                kkwv2._g();
                if (f > 0.0f) {
                    kkwv2._a(f);
                } else {
                    kkwv2._b(0);
                }
            } else {
                GL11.glBindTexture(3553, fmib._a(3553));
            }
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderItem(ItemRenderer itemRenderer, EntityLivingBase entityLivingBase, ItemStack itemStack, int n, IItemRenderer.ItemRenderType itemRenderType) {
        if (!_a) {
            return;
        }
        if (itemStack._c() == 1) {
            Icon icon = entityLivingBase.getItemIcon(itemStack, n);
            ItemAtlasHooks.bindItemTexture(icon, 0.0f);
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderDroppedItem(RenderItem renderItem, EntityItem entityItem, Icon icon, int n, float f, float f2, float f3, float f4, int n2) {
        if (!_a) {
            return;
        }
        if (entityItem.getEntityItem()._c() == 1) {
            ItemAtlasHooks.bindItemTexture(icon, 0.0f);
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderItemIntoGUI(RenderItem renderItem, FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int n, int n2, boolean bl) {
        if (!_a) {
            return;
        }
        ItemAtlasHooks.bindItemTexture(itemStack, 1024.0f);
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderEntityItem(ForgeHooksClient forgeHooksClient, EntityItem entityItem, ItemStack itemStack, float f, float f2, Random random, TextureManager textureManager, RenderBlocks renderBlocks) {
        if (!_a) {
            return;
        }
        ItemAtlasHooks.bindItemTexture(itemStack, 0.0f);
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderInventoryItem(ForgeHooksClient forgeHooksClient, RenderBlocks renderBlocks, TextureManager textureManager, ItemStack itemStack, boolean bl, float f, float f2, float f3) {
        if (!_a) {
            return;
        }
        ItemAtlasHooks.bindItemTexture(itemStack, 1024.0f);
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, priority=HookPriority.HIGHEST)
    @ezey(_a={eidj.CLIENT})
    public static boolean bindTexture(TextureManager textureManager, ResourceLocation resourceLocation) {
        if (!_a) {
            return false;
        }
        return resourceLocation == null || resourceLocation == sctd._e;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    @ezey(_a={eidj.CLIENT})
    public static boolean loadTextureAtlas(sctd sctd2, ResourceManager resourceManager) {
        if (!_a) {
            return false;
        }
        if (sctd2._m == 1) {
            sctd2._c();
            return true;
        }
        return false;
    }

    @Hook(returnCondition=ReturnCondition.ON_NOT_NULL)
    @ezey(_a={eidj.CLIENT})
    public static Icon registerIcon(sctd sctd2, String string) {
        TextureAtlasSprite textureAtlasSprite;
        if (sctd2._j() != 1 || !_a) {
            return null;
        }
        if (string == null) {
            new RuntimeException("Don't register null!").printStackTrace();
            string = "null";
        }
        if ((textureAtlasSprite = sctd2._k.get(string)) == null) {
            TextureAtlasFullSprite textureAtlasFullSprite = new TextureAtlasFullSprite(string);
            textureAtlasSprite = textureAtlasFullSprite;
            textureAtlasFullSprite.minV = 0.001f;
            textureAtlasFullSprite.minU = 0.001f;
            textureAtlasFullSprite.maxV = 0.999f;
            textureAtlasFullSprite.maxU = 0.999f;
            ResourceLocation resourceLocation = new ResourceLocation(string);
            ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), String.format("%s/%s%s", sctd2._n, resourceLocation.getResourcePath(), ".png"));
            textureAtlasFullSprite._a = fmib._b(resourceLocation2);
            sctd2._k.put(string, textureAtlasSprite);
        }
        return textureAtlasSprite;
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void drawTexturedModelRectFromIcon(Gui gui, int n, int n2, Icon icon, int n3, int n4) {
        ItemAtlasHooks.bindItemTexture(icon, 0.0f);
    }

    @ezey(_a={eidj.CLIENT})
    private static class TextureAtlasFullSprite
    extends TextureAtlasSprite {
        public sctg _a;

        public TextureAtlasFullSprite(String string) {
            super(string);
        }
    }
}

