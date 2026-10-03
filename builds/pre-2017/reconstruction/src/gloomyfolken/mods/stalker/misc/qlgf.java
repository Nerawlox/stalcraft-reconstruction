/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import cpw.mods.fml.common.registry.GameRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.weapon.kjui;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import org.lwjgl.opengl.GL11;

public class qlgf {
    public static boolean _a = false;

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void _a(BlockBed blockBed, World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(EntityLivingBase entityLivingBase, float f) {
        float f2 = entityLivingBase.getHealth();
        if (entityLivingBase instanceof EntityPlayer) {
            f /= xafi._a(tupg._a((EntityPlayer)((EntityPlayer)entityLivingBase))._d._z);
        }
        if (f2 > 0.0f) {
            entityLivingBase.setHealth(f2 + f);
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static ItemStack _a(CraftingManager craftingManager, InventoryCrafting inventoryCrafting, World world) {
        for (int i = 0; i < craftingManager._b().size(); ++i) {
            lpso lpso2 = (lpso)craftingManager._b().get(i);
            if (!lpso2.matches(inventoryCrafting, world)) continue;
            return lpso2.getCraftingResult(inventoryCrafting);
        }
        return null;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void _a(BlockAnvil blockAnvil, World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
    }

    @Hook(injectOnExit=true)
    @ezey(_a={eidj.CLIENT})
    public static void _a(GameSettings gameSettings) {
        if (!gameSettings.skin.startsWith("Stalcraft")) {
            gameSettings.skin = "Stalcraft.zip";
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void _a(EntityRenderer entityRenderer, float f) {
        Minecraft minecraft = Minecraft._E();
        minecraft._v = null;
        if (minecraft._u != null && minecraft._r != null) {
            double d = minecraft._j._d();
            double d2 = minecraft._j._j() ? 6.0 : 3.0;
            EntityLivingBase entityLivingBase = minecraft._u;
            Vec3 vec3 = entityLivingBase.getPosition(f);
            Vec3 vec32 = entityLivingBase.getLook(f);
            Vec3 vec33 = vec3._c(vec32._c * d, vec32._d * d, vec32._e * d);
            Vec3 vec34 = vec3._c(vec32._c * d2, vec32._d * d2, vec32._e * d2);
            _a = true;
            MovingObjectPosition movingObjectPosition = entityLivingBase.worldObj.func_72831_a(entityLivingBase.getPosition(f), vec33, false, true);
            MovingObjectPosition movingObjectPosition2 = entityLivingBase.worldObj.func_72933_a(entityLivingBase.getPosition(f), vec33);
            MovingObjectPosition movingObjectPosition3 = EntityTracer._a(entityLivingBase.worldObj, entityLivingBase.getPosition(f), vec34, (Entity)entityLivingBase, movingObjectPosition, true);
            _a = false;
            MovingObjectPosition movingObjectPosition4 = minecraft._L = movingObjectPosition3 == movingObjectPosition ? movingObjectPosition2 : movingObjectPosition3;
            if (movingObjectPosition3 != null && movingObjectPosition3._c == EnumMovingObjectType._b && movingObjectPosition3._i instanceof EntityLivingBase) {
                minecraft._v = (EntityLivingBase)movingObjectPosition3._i;
            }
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void _a(RenderItem renderItem, FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int n, int n2, boolean bl) {
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void _a(RenderPlayer renderPlayer, EntityPlayer entityPlayer) {
        dgmz dgmz2;
        tewl tewl2;
        ItemStack itemStack = entityPlayer.getCurrentArmor(2);
        if (itemStack == null || !(itemStack._a() instanceof dgmz) || (tewl2 = tewl._a(dgmz2 = (dgmz)itemStack._a())) != null) {
            // empty if block
        }
    }

    @Hook(injectOnExit=true, targetMethod="renderItemIntoGUI")
    @ezey(_a={eidj.CLIENT})
    public static void _b(RenderItem renderItem, FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int n, int n2, boolean bl) {
        GL11.glDisable(3042);
        GL11.glEnable(3008);
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean _a(vlzh vlzh2, EntityPlayer entityPlayer, Entity entity) {
        return entity instanceof EntityItem;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, booleanReturnConstant=false)
    public static boolean _a(EntityItem entityItem, DamageSource damageSource, float f) {
        return damageSource instanceof kjui;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void _a(EntityItem entityItem) {
        ItemStack itemStack;
        if (!entityItem.isDead && (itemStack = entityItem.getEntityItem()) != null && itemStack._a() instanceof cdit) {
            String string = fmsn._f();
            IExtendedEntityProperties iExtendedEntityProperties = entityItem.getExtendedProperties(string);
            if (iExtendedEntityProperties == null) {
                iExtendedEntityProperties = new fmsn(entityItem);
                entityItem.registerExtendedProperties(string, iExtendedEntityProperties);
            } else {
                ((fmsn)iExtendedEntityProperties)._b();
            }
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(EntityItem entityItem, EntityPlayer entityPlayer) {
    }

    public static void _b(EntityItem entityItem, EntityPlayer entityPlayer) {
        if (entityItem.worldObj.isRemote) {
            return;
        }
        EntityItemPickupEvent entityItemPickupEvent = new EntityItemPickupEvent(entityPlayer, entityItem);
        if (MinecraftForge.EVENT_BUS.post(entityItemPickupEvent)) {
            return;
        }
        ItemStack itemStack = entityItem.getEntityItem();
        int n = itemStack._b;
        if (entityItemPickupEvent.getResult() == Event.Result.ALLOW || n <= 0 || entityPlayer.inventory._c(itemStack)) {
            ItemStack itemStack2 = itemStack._l();
            itemStack2._b = n - itemStack._b;
            InvokeSideOnly.frontend(() -> {});
            GameRegistry.onPickupNotification(entityPlayer, entityItem);
            entityItem.playSound("random.pop", 0.2f, ((entityItem.worldObj.rand.nextFloat() - entityItem.worldObj.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            entityPlayer.onItemPickup(entityItem, n);
            if (itemStack._b <= 0) {
                entityItem.setDead();
            }
        }
    }

    public static void _a(float f, float f2, float f3, float f4) {
    }

    public static void _a(float f, float f2, float f3) {
    }

    public static void _a(Entity entity) {
        if (Math.random() > 0.95 && entity instanceof EntityPlayer) {
            entity.attackEntityFrom(gloomyfolken.mods.core.misc.ezey._q, GloomyCore.config._a);
        }
    }

    public static void _b(Entity entity) {
        entity.setInWeb();
    }

    public static boolean _a() {
        return true;
    }

    @ezey(_a={eidj.CLIENT})
    public static void _b(EntityItem entityItem) {
        GL11.glPushMatrix();
        if (!RenderItem.renderInFrame && Minecraft._E()._M.fancyGraphics) {
            if (entityItem.getEntityItem() != null && entityItem.getEntityItem()._a() instanceof aofo) {
                float f = Minecraft._E()._p._d;
                GL11.glTranslatef(0.0f, sajh._a(((float)entityItem.age + f) / 10.0f + entityItem.hoverStart) * 0.1f + 0.1f, 0.0f);
                GL11.glRotatef((((float)entityItem.age + f) / 20.0f + entityItem.hoverStart) * 57.295776f, 0.0f, 1.0f, 0.0f);
            } else {
                GL11.glTranslatef(0.0f, -0.12f, 0.0f);
                GL11.glRotatef(entityItem.rotationYaw, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static void _c(EntityItem entityItem) {
        GL11.glPopMatrix();
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, returnAnotherMethod="canStoreTradepack")
    public static boolean _a(InventoryPlayer inventoryPlayer, ItemStack itemStack) {
        if (itemStack != null && itemStack._b > 0 && itemStack._a() instanceof pjnz) {
            if (tupg._a(inventoryPlayer._e)._h()) {
                pjnz._a(inventoryPlayer._e, itemStack._l());
                itemStack._b = 0;
            } else {
                inventoryPlayer._e.addChatMessage((Object)((Object)EnumChatFormatting._m) + "\u0422\u043e\u0440\u0433\u043e\u0432\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a \u043d\u0435\u0441\u043e\u0432\u043c\u0435\u0441\u0442\u0438\u043c \u0441 \u0432\u0430\u0448\u0435\u0439 \u0431\u0440\u043e\u043d\u0435\u0439.");
            }
            return true;
        }
        return false;
    }

    public static boolean _b(InventoryPlayer inventoryPlayer, ItemStack itemStack) {
        return tupg._a(inventoryPlayer._e)._h();
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static float _a(DamageSource damageSource) {
        return 0.0f;
    }
}

