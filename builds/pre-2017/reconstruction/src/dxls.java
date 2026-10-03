/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class dxls
implements kkll,
IItemRenderer {
    private static Minecraft _b = Minecraft._E();
    private ResourceLocation _c = new ResourceLocation("stalker", "models/knife.dds");
    private ResourceLocation _d = new ResourceLocation("stalker", "models/knife.mcsa");
    protected kjui _a = kjui._a(this._d, this._c);
    private static float[] _e = new float[]{0.66f, 1.3f, 0.78f, -76.8f, 14.1f, 45.3f};

    public dxls() {
        fmib._b(this._c);
    }

    @Override
    public boolean handleRenderType(ItemStack itemStack, IItemRenderer.ItemRenderType itemRenderType) {
        return itemRenderType != IItemRenderer.ItemRenderType.INVENTORY;
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, IItemRenderer.ItemRendererHelper itemRendererHelper) {
        return itemRendererHelper != IItemRenderer.ItemRendererHelper.EQUIPPED_BLOCK;
    }

    private void _a() {
        this._a._c.renderAll();
    }

    @Override
    public void _a(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        this._a();
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, Object ... objectArray) {
        ezfc._a();
        ezfc._d();
        if (itemRenderType == IItemRenderer.ItemRenderType.EQUIPPED) {
            ezfc._a(_e[0], _e[1], _e[2]);
            ezfc._a(_e[3], 1.0f, 0.0f, 0.0f);
            ezfc._a(_e[4], 0.0f, 1.0f, 0.0f);
            ezfc._a(_e[5], 0.0f, 0.0f, 1.0f);
            ezfc._b(4.0f, 4.0f, 4.0f);
        } else if (itemRenderType == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
            // empty if block
        }
        this._a();
        if (itemRenderType == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
            ezfa._a._a();
        }
        ezfc._b();
    }
}

