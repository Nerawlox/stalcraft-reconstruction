/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.common.EnumHelper
 *  wh
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.EnumHelper;
import ru.stalcraft.StalkerMain;

public class ItemSkin
extends wh {
    public bjo texture;

    public ItemSkin(int id, String localizedName, String texture) {
        super(id, EnumHelper.addArmorMaterial((String)"STALKERSKIN", (int)-1, (int[])new int[]{0, 0, 0, 0}, (int)15), 2, 2);
        super.a(StalkerMain.tab);
        super.b("stalkerskin=" + id);
        this.d("stalker:flag");
        if (FMLCommonHandler.instance().getSide().isClient()) {
            this.texture = new bjo("stalker", "textures/skins/" + texture + ".png");
        }
        LanguageRegistry.addName((Object)((Object)this), (String)localizedName);
    }

    @SideOnly(value=Side.CLIENT)
    public String getArmorTexture(ye stack, nn entity, int slot, int layer) {
        return "stalker:textures/armor/empty.png";
    }

    @SideOnly(value=Side.CLIENT)
    public boolean b() {
        return false;
    }

    public boolean a(ye par1ItemStack) {
        return false;
    }

    public int getEntityLifespan(ye itemStack, abw world) {
        return 288000;
    }
}

