/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.mods.brushedit.eidj;
import gloomyfolken.mods.brushedit.pidb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ctqc
extends Item {
    public ctqc(int n) {
        super(n - 256);
        this.setUnlocalizedName("brush_maker");
        this.setTextureName("stone_axe");
        this.setMaxStackSize(1);
        this.setFull3D();
        LanguageRegistry.addName(this, "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043a\u0438\u0441\u0442\u044c");
    }

    @Override
    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!world.isRemote) {
            eidj eidj2;
            pidb pidb2 = pidb._a(entityPlayer);
            pidb2._c = eidj2 = new eidj(world, n, n2, n3);
            entityPlayer.addChatMessage("\u0422\u0435\u043f\u0435\u0440\u044c \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439\u0442\u0435 \u043a\u043e\u043c\u0430\u043d\u0434\u0443 /newbrush <brush_name>");
            return true;
        }
        return false;
    }
}

