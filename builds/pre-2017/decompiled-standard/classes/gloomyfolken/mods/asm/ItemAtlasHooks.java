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
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemAtlasHooks {
    public static boolean _a = System.getProperty("disable_item_atlas", "false").equals("true");

    @ezey(_a={eidj.CLIENT})
    public static void bindItemTexture(cvzo cvzo2, float f) {
        if (cvzo2._c() == 0) {
            xpzm._E()._h._a(sctd._c);
        } else {
            ItemAtlasHooks.bindItemTexture(cvzo2._b(), f);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static void bindItemTexture(dwan dwan2, float f) {
        if (!_a) {
            return;
        }
        if (dwan2 instanceof TextureAtlasFullSprite) {
            TextureAtlasFullSprite textureAtlasFullSprite = (TextureAtlasFullSprite)dwan2;
            sctg sctg2 = ((TextureAtlasFullSprite)dwan2)._a;
            if (sctg2 instanceof kkwv) {
                kkwv kkwv2 = (kkwv)sctg2;
                if (kkwv2._q()) {
                    temw temw2 = (temw)kkwv2._u_();
                    hbmu hbmu2 = temw2._c();
                    textureAtlasFullSprite.field_130223_c = hbmu2._b(temw2._b());
                    textureAtlasFullSprite.field_130224_d = hbmu2._c(temw2._b());
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
    public static void renderItem(jizq jizq2, EntityLivingBase entityLivingBase, cvzo cvzo2, int n, IItemRenderer.ItemRenderType itemRenderType) {
        if (!_a) {
            return;
        }
        if (cvzo2._c() == 1) {
            dwan dwan2 = entityLivingBase.func_70620_b(cvzo2, n);
            ItemAtlasHooks.bindItemTexture(dwan2, 0.0f);
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderDroppedItem(xsbj xsbj2, EntityItem entityItem, dwan dwan2, int n, float f, float f2, float f3, float f4, int n2) {
        if (!_a) {
            return;
        }
        if (entityItem.func_92059_d()._c() == 1) {
            ItemAtlasHooks.bindItemTexture(dwan2, 0.0f);
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderItemIntoGUI(xsbj xsbj2, qncw qncw2, apbu apbu2, cvzo cvzo2, int n, int n2, boolean bl) {
        if (!_a) {
            return;
        }
        ItemAtlasHooks.bindItemTexture(cvzo2, 1024.0f);
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderEntityItem(ForgeHooksClient forgeHooksClient, EntityItem entityItem, cvzo cvzo2, float f, float f2, Random random, apbu apbu2, htvc htvc2) {
        if (!_a) {
            return;
        }
        ItemAtlasHooks.bindItemTexture(cvzo2, 0.0f);
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void renderInventoryItem(ForgeHooksClient forgeHooksClient, htvc htvc2, apbu apbu2, cvzo cvzo2, boolean bl, float f, float f2, float f3) {
        if (!_a) {
            return;
        }
        ItemAtlasHooks.bindItemTexture(cvzo2, 1024.0f);
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, priority=HookPriority.HIGHEST)
    @ezey(_a={eidj.CLIENT})
    public static boolean bindTexture(apbu apbu2, ResourceLocation resourceLocation) {
        if (!_a) {
            return false;
        }
        return resourceLocation == null || resourceLocation == sctd._e;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    @ezey(_a={eidj.CLIENT})
    public static boolean loadTextureAtlas(sctd sctd2, xsfs xsfs2) {
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
    public static dwan registerIcon(sctd sctd2, String string) {
        dhji dhji2;
        if (sctd2._j() != 1 || !_a) {
            return null;
        }
        if (string == null) {
            new RuntimeException("Don't register null!").printStackTrace();
            string = "null";
        }
        if ((dhji2 = sctd2._k.get(string)) == null) {
            TextureAtlasFullSprite textureAtlasFullSprite = new TextureAtlasFullSprite(string);
            dhji2 = textureAtlasFullSprite;
            textureAtlasFullSprite.field_110977_n = 0.001f;
            textureAtlasFullSprite.field_110979_l = 0.001f;
            textureAtlasFullSprite.field_110978_o = 0.999f;
            textureAtlasFullSprite.field_110980_m = 0.999f;
            ResourceLocation resourceLocation = new ResourceLocation(string);
            ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.func_110624_b(), String.format("%s/%s%s", sctd2._n, resourceLocation.func_110623_a(), ".png"));
            textureAtlasFullSprite._a = fmib._b(resourceLocation2);
            sctd2._k.put(string, dhji2);
        }
        return dhji2;
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void drawTexturedModelRectFromIcon(bawa bawa2, int n, int n2, dwan dwan2, int n3, int n4) {
        ItemAtlasHooks.bindItemTexture(dwan2, 0.0f);
    }

    @ezey(_a={eidj.CLIENT})
    private static class TextureAtlasFullSprite
    extends dhji {
        public sctg _a;

        public TextureAtlasFullSprite(String string) {
            super(string);
        }
    }
}

