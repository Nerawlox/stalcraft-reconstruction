/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class ifvk
extends RenderLiving {
    public ModelBiped _a;
    public float _b;
    public ModelBiped _c;
    public ModelBiped _d;
    public static final Map _e = Maps.newHashMap();
    public static String[] _f = new String[]{"leather", "chainmail", "iron", "diamond", "gold"};

    public ifvk(ModelBiped modelBiped, float f) {
        this(modelBiped, f, 1.0f);
    }

    public ifvk(ModelBiped modelBiped, float f, float f2) {
        super(modelBiped, f);
        this._a = modelBiped;
        this._b = f2;
        this._a();
    }

    public void _a() {
        this._c = new ModelBiped(1.0f);
        this._d = new ModelBiped(0.5f);
    }

    @Deprecated
    public static ResourceLocation _a(ItemArmor itemArmor, int n) {
        return ifvk._a(itemArmor, n, null);
    }

    @Deprecated
    public static ResourceLocation _a(ItemArmor itemArmor, int n, String string) {
        String string2 = String.format("textures/models/armor/%s_layer_%d%s.png", _f[itemArmor.renderIndex], n == 2 ? 2 : 1, string == null ? "" : String.format("_%s", string));
        ResourceLocation resourceLocation = (ResourceLocation)_e.get(string2);
        if (resourceLocation == null) {
            resourceLocation = new ResourceLocation(string2);
            _e.put(string2, resourceLocation);
        }
        return resourceLocation;
    }

    public static ResourceLocation _a(Entity entity, ItemStack itemStack, int n, String string) {
        ItemArmor itemArmor = (ItemArmor)itemStack._a();
        String string2 = String.format("textures/models/armor/%s_layer_%d%s.png", _f[itemArmor.renderIndex], n == 2 ? 2 : 1, string == null ? "" : String.format("_%s", string));
        ResourceLocation resourceLocation = (ResourceLocation)_e.get(string2 = ForgeHooksClient.getArmorTexture(entity, itemStack, string2, n, string));
        if (resourceLocation == null) {
            resourceLocation = new ResourceLocation(string2);
            _e.put(string2, resourceLocation);
        }
        return resourceLocation;
    }

    public int _a(EntityLiving entityLiving, int n, float f) {
        Item item;
        ItemStack itemStack = entityLiving.func_130225_q(3 - n);
        if (itemStack != null && (item = itemStack._a()) instanceof ItemArmor) {
            ItemArmor itemArmor = (ItemArmor)item;
            this.bindTexture(ifvk._a(entityLiving, itemStack, n, null));
            ModelBiped modelBiped = n == 2 ? this._d : this._c;
            modelBiped.bipedHead.showModel = n == 0;
            modelBiped.bipedHeadwear.showModel = n == 0;
            modelBiped.bipedBody.showModel = n == 1 || n == 2;
            modelBiped.bipedRightArm.showModel = n == 1;
            modelBiped.bipedLeftArm.showModel = n == 1;
            modelBiped.bipedRightLeg.showModel = n == 2 || n == 3;
            modelBiped.bipedLeftLeg.showModel = n == 2 || n == 3;
            modelBiped = ForgeHooksClient.getArmorModel(entityLiving, itemStack, n, modelBiped);
            this.setRenderPassModel(modelBiped);
            modelBiped.onGround = this.mainModel.onGround;
            modelBiped.isRiding = this.mainModel.isRiding;
            modelBiped.isChild = this.mainModel.isChild;
            float f2 = 1.0f;
            int n2 = itemArmor.getColor(itemStack);
            if (n2 != -1) {
                float f3 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                float f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                float f5 = (float)(n2 & 0xFF) / 255.0f;
                GL11.glColor3f(f2 * f3, f2 * f4, f2 * f5);
                if (itemStack._y()) {
                    return 31;
                }
                return 16;
            }
            GL11.glColor3f(f2, f2, f2);
            if (itemStack._y()) {
                return 15;
            }
            return 1;
        }
        return -1;
    }

    public void _b(EntityLiving entityLiving, int n, float f) {
        Item item;
        ItemStack itemStack = entityLiving.func_130225_q(3 - n);
        if (itemStack != null && (item = itemStack._a()) instanceof ItemArmor) {
            this.bindTexture(ifvk._a(entityLiving, itemStack, n, "overlay"));
            float f2 = 1.0f;
            GL11.glColor3f(f2, f2, f2);
        }
    }

    @Override
    public void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        float f3 = 1.0f;
        GL11.glColor3f(f3, f3, f3);
        ItemStack itemStack = entityLiving.getHeldItem();
        this._a(entityLiving, itemStack);
        double d4 = d2 - (double)entityLiving.yOffset;
        if (entityLiving.isSneaking()) {
            d4 -= 0.125;
        }
        super.doRenderLiving(entityLiving, d, d4, d3, f, f2);
        this._a.aimedBow = false;
        this._d.aimedBow = false;
        this._c.aimedBow = false;
        this._a.isSneak = false;
        this._d.isSneak = false;
        this._c.isSneak = false;
        this._a.heldItemRight = 0;
        this._d.heldItemRight = 0;
        this._c.heldItemRight = 0;
    }

    public ResourceLocation _a(EntityLiving entityLiving) {
        return null;
    }

    public void _a(EntityLiving entityLiving, ItemStack itemStack) {
        this._a.heldItemRight = itemStack != null ? 1 : 0;
        this._d.heldItemRight = this._a.heldItemRight;
        this._c.heldItemRight = this._a.heldItemRight;
        this._d.isSneak = this._a.isSneak = entityLiving.isSneaking();
        this._c.isSneak = this._a.isSneak;
    }

    public void _a(EntityLiving entityLiving, float f) {
        float f2;
        boolean bl;
        IItemRenderer iItemRenderer;
        float f3 = 1.0f;
        GL11.glColor3f(f3, f3, f3);
        super.renderEquippedItems(entityLiving, f);
        ItemStack itemStack = entityLiving.getHeldItem();
        ItemStack itemStack2 = entityLiving.func_130225_q(3);
        if (itemStack2 != null) {
            GL11.glPushMatrix();
            this._a.bipedHead.postRender(0.0625f);
            iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack2, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl2 = bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemStack2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (itemStack2._a() instanceof ItemBlock) {
                if (bl || RenderBlocks._a(Block.blocksList[itemStack2._d].getRenderType())) {
                    f2 = 0.625f;
                    GL11.glTranslatef(0.0f, -0.25f, 0.0f);
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glScalef(f2, -f2, -f2);
                }
                this.renderManager._h.renderItem(entityLiving, itemStack2, 0);
            } else if (itemStack2._a().itemID == Item.skull.itemID) {
                f2 = 1.0625f;
                GL11.glScalef(f2, -f2, -f2);
                String string = "";
                if (itemStack2._p() && itemStack2._q()._c("SkullOwner")) {
                    string = itemStack2._q()._j("SkullOwner");
                }
                bsiw._e._a(-0.5f, 0.0f, -0.5f, 1, 180.0f, itemStack2._j(), string);
            }
            GL11.glPopMatrix();
        }
        if (itemStack != null) {
            GL11.glPushMatrix();
            if (this.mainModel.isChild) {
                f2 = 0.5f;
                GL11.glTranslatef(0.0f, 0.625f, 0.0f);
                GL11.glRotatef(-20.0f, -1.0f, 0.0f, 0.0f);
                GL11.glScalef(f2, f2, f2);
            }
            this._a.bipedRightArm.postRender(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl3 = bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemStack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (itemStack._a() instanceof ItemBlock && (bl || RenderBlocks._a(Block.blocksList[itemStack._d].getRenderType()))) {
                f2 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-(f2 *= 0.75f), -f2, f2);
            } else if (itemStack._d == Item.bow.itemID) {
                f2 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (Item.itemsList[itemStack._d].isFull3D()) {
                f2 = 0.625f;
                if (Item.itemsList[itemStack._d].shouldRotateAroundWhenRendering()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                this._b();
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                f2 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f2, f2, f2);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            this.renderManager._h.renderItem(entityLiving, itemStack, 0);
            if (itemStack._a().requiresMultipleRenderPasses()) {
                for (int i = 1; i < itemStack._a().getRenderPasses(itemStack._j()); ++i) {
                    this.renderManager._h.renderItem(entityLiving, itemStack, i);
                }
            }
            GL11.glPopMatrix();
        }
    }

    public void _b() {
        GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
    }

    public void _a(EntityLivingBase entityLivingBase, int n, float f) {
        this._b((EntityLiving)entityLivingBase, n, f);
    }

    @Override
    public int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityLiving)entityLivingBase, n, f);
    }

    @Override
    public void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityLiving)entityLivingBase, f);
    }

    @Override
    public void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this.doRenderLiving((EntityLiving)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityLiving)entity);
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.doRenderLiving((EntityLiving)entity, d, d2, d3, f, f2);
    }
}

