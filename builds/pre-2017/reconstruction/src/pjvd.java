/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class pjvd
implements IItemRenderer {
    private static Minecraft _b = Minecraft._E();
    private static float[] _c = new float[]{-0.355f, -0.06f, 0.234f, -0.6f, -15.4f, -3.85f};
    private static float[] _d = new float[]{0.66f, 1.3f, 0.78f, -76.8f, 14.1f, 45.3f};
    private static float[] _e = new float[]{0.23f, 0.84f, 0.76f, 9.1f, 316.6f, 0.0f};
    protected ssbn _a = new ssbn();
    private ResourceLocation _f;
    private IModelCustom _g;
    private float _h = 0.0f;
    private float _i = 0.0f;
    private float _j = 0.0f;

    public pjvd(String string, String string2) {
        this._g = AdvancedModelLoader.loadModel("/assets/weapons/models/attachments/" + string);
        this._f = new ResourceLocation("weapons", "models/attachments/" + string2);
        fmib._b(this._f);
    }

    @Override
    public boolean handleRenderType(ItemStack itemStack, IItemRenderer.ItemRenderType itemRenderType) {
        return itemRenderType != IItemRenderer.ItemRenderType.ENTITY && itemRenderType != IItemRenderer.ItemRenderType.INVENTORY;
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, IItemRenderer.ItemRendererHelper itemRendererHelper) {
        return true;
    }

    private void _a(ItemStack itemStack) {
        pjvd._b._h._a(this._f);
        this._g.renderAll();
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, Object ... objectArray) {
        try {
            if (itemRenderType == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
                GL11.glTranslatef(_c[0], _c[1], _c[2]);
                GL11.glRotatef(_c[3], 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(_c[4], 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(_c[5], 0.0f, 0.0f, 1.0f);
                GL11.glPushMatrix();
                GL11.glRotatef(-33.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(this._h - 0.15f, this._i + 1.325f, this._j + 0.95f);
                GL11.glScalef(3.0f, 3.0f, 3.0f);
                this._a(itemStack);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-33.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.3f, -1.35f, 1.075f);
                this._a._a(pjvd._b._t, 1);
                GL11.glPopMatrix();
            } else if (itemRenderType == IItemRenderer.ItemRenderType.EQUIPPED) {
                GL11.glPushMatrix();
                if (objectArray[1] instanceof EntityPlayer) {
                    GL11.glTranslatef(_d[0] - 0.05f, _d[1] - 0.9f, _d[2]);
                    GL11.glRotatef(_d[3], 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(_d[4], 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(_d[5], 0.0f, 0.0f, 1.0f);
                    GL11.glScalef(4.0f, 4.0f, 4.0f);
                } else {
                    GL11.glTranslatef(_e[0] - 0.05f, _e[1] - 0.9f, _e[2]);
                    GL11.glRotatef(_e[3], 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(_e[4], 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(_e[5], 0.0f, 0.0f, 1.0f);
                    GL11.glScalef(2.0f, 2.0f, 2.0f);
                }
                this._a(itemStack);
                GL11.glPopMatrix();
            }
        }
        catch (NullPointerException nullPointerException) {
            nullPointerException.printStackTrace();
        }
    }
}

