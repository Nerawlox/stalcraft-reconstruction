/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.entity;

import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;
import api.player.client.IClientPlayerAPI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiCommandBlock;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.gui.inventory.GuiScreenHorseInventory;
import net.minecraft.client.particle.EntityCrit2FX;
import net.minecraft.client.particle.EntityPickupFX;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumEntitySize;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.sajz;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Icon;
import net.minecraft.util.MouseFilter;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.hanr;
import net.minecraft.util.kjwj;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;

@SideOnly(value=Side.CLIENT)
public class EntityPlayerSP
extends AbstractClientPlayer
implements IClientPlayerAPI {
    public kjwj movementInput;
    public Minecraft mc;
    public int sprintToggleTimer;
    public int sprintingTicksLeft;
    public float renderArmYaw;
    public float renderArmPitch;
    public float prevRenderArmYaw;
    public float prevRenderArmPitch;
    public int horseJumpPowerCounter;
    public float horseJumpPower;
    public MouseFilter field_71162_ch;
    public MouseFilter field_71160_ci;
    public MouseFilter field_71161_cj;
    public float timeInPortal;
    public float prevTimeInPortal;
    private final ClientPlayerAPI clientPlayerAPI = ClientPlayerAPI.create(this);

    public EntityPlayerSP(Minecraft minecraft, World world, hanr hanr2, int n) {
        super(world, hanr2._a());
        ClientPlayerAPI.beforeLocalConstructing(this, minecraft, world, hanr2, n);
        this.field_71162_ch = new MouseFilter();
        this.field_71160_ci = new MouseFilter();
        this.field_71161_cj = new MouseFilter();
        this.mc = minecraft;
        this.dimension = n;
        ClientPlayerAPI.afterLocalConstructing(this, minecraft, world, hanr2, n);
    }

    @Override
    public final void localUpdateEntityActionState() {
        super.updateEntityActionState();
        this.moveStrafing = this.movementInput._a;
        this.moveForward = this.movementInput._b;
        this.isJumping = this.movementInput._c;
        this.prevRenderArmYaw = this.renderArmYaw;
        this.prevRenderArmPitch = this.renderArmPitch;
        this.renderArmPitch = (float)((double)this.renderArmPitch + (double)(this.rotationPitch - this.renderArmPitch) * 0.5);
        this.renderArmYaw = (float)((double)this.renderArmYaw + (double)(this.rotationYaw - this.renderArmYaw) * 0.5);
    }

    @Override
    public final void localOnLivingUpdate() {
        if (this.sprintingTicksLeft > 0) {
            --this.sprintingTicksLeft;
            if (this.sprintingTicksLeft == 0) {
                this.setSprinting(false);
            }
        }
        if (this.sprintToggleTimer > 0) {
            --this.sprintToggleTimer;
        }
        if (this.mc._j._a()) {
            this.posZ = 0.5;
            this.posX = 0.5;
            this.posX = 0.0;
            this.posZ = 0.0;
            this.rotationYaw = (float)this.ticksExisted / 12.0f;
            this.rotationPitch = 10.0f;
            this.posY = 68.5;
        } else {
            boolean bl;
            if (!this.mc._X._a(AchievementList._f)) {
                this.mc._I._b(AchievementList._f);
            }
            this.prevTimeInPortal = this.timeInPortal;
            if (this.inPortal) {
                if (this.mc._B != null) {
                    this.mc._a((GuiScreen)null);
                }
                if (this.timeInPortal == 0.0f) {
                    this.mc._N._a("portal.trigger", 1.0f, this.rand.nextFloat() * 0.4f + 0.8f);
                }
                this.timeInPortal += 0.0125f;
                if (this.timeInPortal >= 1.0f) {
                    this.timeInPortal = 1.0f;
                }
                this.inPortal = false;
            } else if (this.isPotionActive(Potion._k) && this.getActivePotionEffect(Potion._k)._b() > 60) {
                this.timeInPortal += 0.006666667f;
                if (this.timeInPortal > 1.0f) {
                    this.timeInPortal = 1.0f;
                }
            } else {
                if (this.timeInPortal > 0.0f) {
                    this.timeInPortal -= 0.05f;
                }
                if (this.timeInPortal < 0.0f) {
                    this.timeInPortal = 0.0f;
                }
            }
            if (this.timeUntilPortal > 0) {
                --this.timeUntilPortal;
            }
            boolean bl2 = this.movementInput._c;
            float f = 0.8f;
            boolean bl3 = this.movementInput._b >= f;
            this.movementInput._a();
            if (this.isUsingItem() && !this.isRiding()) {
                this.movementInput._a *= 0.2f;
                this.movementInput._b *= 0.2f;
                this.sprintToggleTimer = 0;
            }
            if (this.movementInput._d && this.ySize < 0.2f) {
                this.ySize = 0.2f;
            }
            this.pushOutOfBlocks(this.posX - (double)this.width * 0.35, this.boundingBox._c + 0.5, this.posZ + (double)this.width * 0.35);
            this.pushOutOfBlocks(this.posX - (double)this.width * 0.35, this.boundingBox._c + 0.5, this.posZ - (double)this.width * 0.35);
            this.pushOutOfBlocks(this.posX + (double)this.width * 0.35, this.boundingBox._c + 0.5, this.posZ - (double)this.width * 0.35);
            this.pushOutOfBlocks(this.posX + (double)this.width * 0.35, this.boundingBox._c + 0.5, this.posZ + (double)this.width * 0.35);
            boolean bl4 = bl = (float)this.getFoodStats()._a() > 6.0f || this.capabilities._c;
            if (this.onGround && !bl3 && this.movementInput._b >= f && !this.isSprinting() && bl && !this.isUsingItem() && !this.isPotionActive(Potion._q)) {
                if (this.sprintToggleTimer == 0) {
                    this.sprintToggleTimer = 7;
                } else {
                    this.setSprinting(true);
                    this.sprintToggleTimer = 0;
                }
            }
            if (this.isSneaking()) {
                this.sprintToggleTimer = 0;
            }
            if (this.isSprinting() && (this.movementInput._b < f || this.isCollidedHorizontally || !bl)) {
                this.setSprinting(false);
            }
            if (this.capabilities._c && !bl2 && this.movementInput._c) {
                if (this.flyToggleTimer == 0) {
                    this.flyToggleTimer = 7;
                } else {
                    this.capabilities._b = !this.capabilities._b;
                    this.sendPlayerAbilities();
                    this.flyToggleTimer = 0;
                }
            }
            if (this.capabilities._b) {
                if (this.movementInput._d) {
                    this.motionY -= 0.15;
                }
                if (this.movementInput._c) {
                    this.motionY += 0.15;
                }
            }
            if (this.isRidingHorse()) {
                if (this.horseJumpPowerCounter < 0) {
                    ++this.horseJumpPowerCounter;
                    if (this.horseJumpPowerCounter == 0) {
                        this.horseJumpPower = 0.0f;
                    }
                }
                if (bl2 && !this.movementInput._c) {
                    this.horseJumpPowerCounter = -10;
                    this.func_110318_g();
                } else if (!bl2 && this.movementInput._c) {
                    this.horseJumpPowerCounter = 0;
                    this.horseJumpPower = 0.0f;
                } else if (bl2) {
                    ++this.horseJumpPowerCounter;
                    this.horseJumpPower = this.horseJumpPowerCounter < 10 ? (float)this.horseJumpPowerCounter * 0.1f : 0.8f + 2.0f / (float)(this.horseJumpPowerCounter - 9) * 0.1f;
                }
            } else {
                this.horseJumpPower = 0.0f;
            }
            super.onLivingUpdate();
            if (this.onGround && this.capabilities._b) {
                this.capabilities._b = false;
                this.sendPlayerAbilities();
            }
        }
    }

    @Override
    public final float localGetFOVMultiplier() {
        float f = 1.0f;
        if (this.capabilities._b) {
            f *= 1.1f;
        }
        hubf hubf2 = this.getEntityAttribute(sajz._d);
        f = (float)((double)f * ((hubf2._e() / (double)this.capabilities._b() + 1.0) / 2.0));
        if (this.isUsingItem() && this.getItemInUse()._d == Item.bow.itemID) {
            int n = this.getItemInUseDuration();
            float f2 = (float)n / 20.0f;
            f2 = f2 > 1.0f ? 1.0f : (f2 *= f2);
            f *= 1.0f - f2 * 0.15f;
        }
        return ForgeHooksClient.getOffsetFOV(this, f);
    }

    @Override
    public final void localCloseScreen() {
        super.closeScreen();
        this.mc._a((GuiScreen)null);
    }

    @Override
    public final void localDisplayGUIEditSign(TileEntity tileEntity) {
        if (tileEntity instanceof TileEntitySign) {
            this.mc._a(new GuiEditSign((TileEntitySign)tileEntity));
        } else if (tileEntity instanceof TileEntityCommandBlock) {
            this.mc._a(new GuiCommandBlock((TileEntityCommandBlock)tileEntity));
        }
    }

    @Override
    public void displayGUIBook(ItemStack itemStack) {
        Item item = itemStack._a();
        if (item == Item.writtenBook) {
            this.mc._a(new htmc(this, itemStack, false));
        } else if (item == Item.writableBook) {
            this.mc._a(new htmc(this, itemStack, true));
        }
    }

    @Override
    public final void localDisplayGUIChest(IInventory iInventory) {
        this.mc._a(new GuiChest(this.inventory, iInventory));
    }

    @Override
    public void displayGUIHopper(TileEntityHopper tileEntityHopper) {
        this.mc._a(new GuiHopper(this.inventory, tileEntityHopper));
    }

    @Override
    public void displayGUIHopperMinecart(EntityMinecartHopper entityMinecartHopper) {
        this.mc._a(new GuiHopper(this.inventory, entityMinecartHopper));
    }

    @Override
    public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
        this.mc._a(new GuiScreenHorseInventory(this.inventory, iInventory, entityHorse));
    }

    @Override
    public final void localDisplayGUIWorkbench(int n, int n2, int n3) {
        this.mc._a(new GuiCrafting(this.inventory, this.worldObj, n, n2, n3));
    }

    @Override
    public final void localDisplayGUIEnchantment(int n, int n2, int n3, String string) {
        this.mc._a(new GuiEnchantment(this.inventory, this.worldObj, n, n2, n3, string));
    }

    @Override
    public void displayGUIAnvil(int n, int n2, int n3) {
        this.mc._a(new GuiRepair(this.inventory, this.worldObj, n, n2, n3));
    }

    @Override
    public final void localDisplayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
        this.mc._a(new GuiFurnace(this.inventory, tileEntityFurnace));
    }

    @Override
    public final void localDisplayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
        this.mc._a(new GuiBrewingStand(this.inventory, tileEntityBrewingStand));
    }

    @Override
    public void displayGUIBeacon(TileEntityBeacon tileEntityBeacon) {
        this.mc._a(new GuiBeacon(this.inventory, tileEntityBeacon));
    }

    @Override
    public final void localDisplayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
        this.mc._a(new GuiDispenser(this.inventory, tileEntityDispenser));
    }

    @Override
    public void displayGUIMerchant(IMerchant iMerchant, String string) {
        this.mc._a(new xayk(this.inventory, iMerchant, this.worldObj, string));
    }

    @Override
    public void onCriticalHit(Entity entity) {
        this.mc._w._a(new EntityCrit2FX(this.mc._r, entity));
    }

    @Override
    public void onEnchantmentCritical(Entity entity) {
        EntityCrit2FX entityCrit2FX = new EntityCrit2FX(this.mc._r, entity, "magicCrit");
        this.mc._w._a(entityCrit2FX);
    }

    @Override
    public void onItemPickup(Entity entity, int n) {
        this.mc._w._a(new EntityPickupFX((World)this.mc._r, entity, this, -0.5f));
    }

    @Override
    public final boolean localIsSneaking() {
        return this.movementInput._d && !this.sleeping;
    }

    @Override
    public final void localSetPlayerSPHealth(float f) {
        float f2 = this.getHealth() - f;
        if (f2 <= 0.0f) {
            this.setHealth(f);
            if (f2 < 0.0f) {
                this.hurtResistantTime = this.maxHurtResistantTime / 2;
            }
        } else {
            this.lastDamage = f2;
            this.setHealth(this.getHealth());
            this.hurtResistantTime = this.maxHurtResistantTime;
            this.damageEntity(DamageSource.generic, f2);
            this.maxHurtTime = 10;
            this.hurtTime = 10;
        }
    }

    @Override
    public void addChatMessage(String string) {
        this.mc._J.getChatGUI()._a(string, new Object[0]);
    }

    @Override
    public final void localAddStat(StatBase statBase, int n) {
        if (statBase != null) {
            if (statBase.isAchievement()) {
                Achievement achievement = (Achievement)statBase;
                if (achievement.parentAchievement == null || this.mc._X._a(achievement.parentAchievement)) {
                    if (!this.mc._X._a(achievement)) {
                        this.mc._I._a(achievement);
                    }
                    this.mc._X._a(statBase, n);
                }
            } else {
                this.mc._X._a(statBase, n);
            }
        }
    }

    public boolean isBlockTranslucent(int n, int n2, int n3) {
        return this.worldObj.isBlockNormalCube(n, n2, n3);
    }

    @Override
    public final boolean localPushOutOfBlocks(double d, double d2, double d3) {
        int n;
        if (this.noClip) {
            return false;
        }
        int n2 = sajh._c(d);
        int n3 = sajh._c(d2);
        int n4 = sajh._c(d3);
        double d4 = d - (double)n2;
        double d5 = d3 - (double)n4;
        int n5 = Math.max(Math.round(this.height), 1);
        boolean bl = true;
        for (n = 0; n < n5; ++n) {
            if (this.isBlockTranslucent(n2, n3 + n, n4)) continue;
            bl = false;
        }
        if (bl) {
            int n6;
            n = 1;
            boolean bl2 = true;
            boolean bl3 = true;
            boolean bl4 = true;
            for (n6 = 0; n6 < n5; ++n6) {
                if (!this.isBlockTranslucent(n2 - 1, n3 + n6, n4)) continue;
                n = 0;
                break;
            }
            for (n6 = 0; n6 < n5; ++n6) {
                if (!this.isBlockTranslucent(n2 + 1, n3 + n6, n4)) continue;
                bl2 = false;
                break;
            }
            for (n6 = 0; n6 < n5; ++n6) {
                if (!this.isBlockTranslucent(n2, n3 + n6, n4 - 1)) continue;
                bl3 = false;
                break;
            }
            for (n6 = 0; n6 < n5; ++n6) {
                if (!this.isBlockTranslucent(n2, n3 + n6, n4 + 1)) continue;
                bl4 = false;
                break;
            }
            n6 = -1;
            double d6 = 9999.0;
            if (n != 0 && d4 < d6) {
                d6 = d4;
                n6 = 0;
            }
            if (bl2 && 1.0 - d4 < d6) {
                d6 = 1.0 - d4;
                n6 = 1;
            }
            if (bl3 && d5 < d6) {
                d6 = d5;
                n6 = 4;
            }
            if (bl4 && 1.0 - d5 < d6) {
                d6 = 1.0 - d5;
                n6 = 5;
            }
            float f = 0.1f;
            if (n6 == 0) {
                this.motionX = -f;
            }
            if (n6 == 1) {
                this.motionX = f;
            }
            if (n6 == 4) {
                this.motionZ = -f;
            }
            if (n6 == 5) {
                this.motionZ = f;
            }
        }
        return false;
    }

    @Override
    public void setSprinting(boolean bl) {
        super.setSprinting(bl);
        this.sprintingTicksLeft = bl ? 600 : 0;
    }

    public void setXPStats(float f, int n, int n2) {
        this.experience = f;
        this.experienceTotal = n;
        this.experienceLevel = n2;
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
        this.mc._J.getChatGUI()._a(chatMessageComponent._a(true));
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return n <= 0;
    }

    @Override
    public ChunkCoordinates func_82114_b() {
        return new ChunkCoordinates(sajh._c(this.posX + 0.5), sajh._c(this.posY + 0.5), sajh._c(this.posZ + 0.5));
    }

    @Override
    public ItemStack getHeldItem() {
        return this.inventory._a();
    }

    @Override
    public void playSound(String string, float f, float f2) {
        PlaySoundAtEntityEvent playSoundAtEntityEvent = new PlaySoundAtEntityEvent(this, string, f, f2);
        if (MinecraftForge.EVENT_BUS.post(playSoundAtEntityEvent)) {
            return;
        }
        string = playSoundAtEntityEvent.name;
        this.worldObj.playSound(this.posX, this.posY - (double)this.yOffset, this.posZ, string, f, f2, false);
    }

    @Override
    public boolean isClientWorld() {
        return true;
    }

    public boolean isRidingHorse() {
        return this.ridingEntity != null && this.ridingEntity instanceof EntityHorse;
    }

    public float getHorseJumpPower() {
        return this.horseJumpPower;
    }

    public void func_110318_g() {
    }

    @Override
    public void addExhaustion(float f) {
        ClientPlayerAPI.addExhaustion(this, f);
    }

    @Override
    public final void realAddExhaustion(float f) {
        this.addExhaustion(f);
    }

    @Override
    public final void superAddExhaustion(float f) {
        super.addExhaustion(f);
    }

    @Override
    public final void localAddExhaustion(float f) {
        super.addExhaustion(f);
    }

    @Override
    public void addMovementStat(double d, double d2, double d3) {
        ClientPlayerAPI.addMovementStat(this, d, d2, d3);
    }

    @Override
    public final void realAddMovementStat(double d, double d2, double d3) {
        this.addMovementStat(d, d2, d3);
    }

    @Override
    public final void superAddMovementStat(double d, double d2, double d3) {
        super.addMovementStat(d, d2, d3);
    }

    @Override
    public final void localAddMovementStat(double d, double d2, double d3) {
        super.addMovementStat(d, d2, d3);
    }

    @Override
    public void addStat(StatBase statBase, int n) {
        ClientPlayerAPI.addStat(this, statBase, n);
    }

    @Override
    public final void realAddStat(StatBase statBase, int n) {
        this.addStat(statBase, n);
    }

    @Override
    public final void superAddStat(StatBase statBase, int n) {
        super.addStat(statBase, n);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        return ClientPlayerAPI.attackEntityFrom(this, damageSource, f);
    }

    @Override
    public final boolean realAttackEntityFrom(DamageSource damageSource, float f) {
        return this.attackEntityFrom(damageSource, f);
    }

    @Override
    public final boolean superAttackEntityFrom(DamageSource damageSource, float f) {
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public final boolean localAttackEntityFrom(DamageSource damageSource, float f) {
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public void attackTargetEntityWithCurrentItem(Entity entity) {
        ClientPlayerAPI.attackTargetEntityWithCurrentItem(this, entity);
    }

    @Override
    public final void realAttackTargetEntityWithCurrentItem(Entity entity) {
        this.attackTargetEntityWithCurrentItem(entity);
    }

    @Override
    public final void superAttackTargetEntityWithCurrentItem(Entity entity) {
        super.attackTargetEntityWithCurrentItem(entity);
    }

    @Override
    public final void localAttackTargetEntityWithCurrentItem(Entity entity) {
        super.attackTargetEntityWithCurrentItem(entity);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return ClientPlayerAPI.canBreatheUnderwater(this);
    }

    @Override
    public final boolean realCanBreatheUnderwater() {
        return this.canBreatheUnderwater();
    }

    @Override
    public final boolean superCanBreatheUnderwater() {
        return super.canBreatheUnderwater();
    }

    @Override
    public final boolean localCanBreatheUnderwater() {
        return super.canBreatheUnderwater();
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        return ClientPlayerAPI.canHarvestBlock(this, block);
    }

    @Override
    public final boolean realCanHarvestBlock(Block block) {
        return this.canHarvestBlock(block);
    }

    @Override
    public final boolean superCanHarvestBlock(Block block) {
        return super.canHarvestBlock(block);
    }

    @Override
    public final boolean localCanHarvestBlock(Block block) {
        return super.canHarvestBlock(block);
    }

    @Override
    public boolean canPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        return ClientPlayerAPI.canPlayerEdit(this, n, n2, n3, n4, itemStack);
    }

    @Override
    public final boolean realCanPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        return this.canPlayerEdit(n, n2, n3, n4, itemStack);
    }

    @Override
    public final boolean superCanPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        return super.canPlayerEdit(n, n2, n3, n4, itemStack);
    }

    @Override
    public final boolean localCanPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        return super.canPlayerEdit(n, n2, n3, n4, itemStack);
    }

    @Override
    public boolean canTriggerWalking() {
        return ClientPlayerAPI.canTriggerWalking(this);
    }

    @Override
    public final boolean realCanTriggerWalking() {
        return this.canTriggerWalking();
    }

    @Override
    public final boolean superCanTriggerWalking() {
        return super.canTriggerWalking();
    }

    @Override
    public final boolean localCanTriggerWalking() {
        return super.canTriggerWalking();
    }

    @Override
    public void closeScreen() {
        ClientPlayerAPI.closeScreen(this);
    }

    @Override
    public final void realCloseScreen() {
        this.closeScreen();
    }

    @Override
    public final void superCloseScreen() {
        super.closeScreen();
    }

    @Override
    public void damageEntity(DamageSource damageSource, float f) {
        ClientPlayerAPI.damageEntity(this, damageSource, f);
    }

    @Override
    public final void realDamageEntity(DamageSource damageSource, float f) {
        this.damageEntity(damageSource, f);
    }

    @Override
    public final void superDamageEntity(DamageSource damageSource, float f) {
        super.damageEntity(damageSource, f);
    }

    @Override
    public final void localDamageEntity(DamageSource damageSource, float f) {
        super.damageEntity(damageSource, f);
    }

    @Override
    public void displayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
        ClientPlayerAPI.displayGUIBrewingStand(this, tileEntityBrewingStand);
    }

    @Override
    public final void realDisplayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
        this.displayGUIBrewingStand(tileEntityBrewingStand);
    }

    @Override
    public final void superDisplayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
        super.displayGUIBrewingStand(tileEntityBrewingStand);
    }

    @Override
    public void displayGUIChest(IInventory iInventory) {
        ClientPlayerAPI.displayGUIChest(this, iInventory);
    }

    @Override
    public final void realDisplayGUIChest(IInventory iInventory) {
        this.displayGUIChest(iInventory);
    }

    @Override
    public final void superDisplayGUIChest(IInventory iInventory) {
        super.displayGUIChest(iInventory);
    }

    @Override
    public void displayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
        ClientPlayerAPI.displayGUIDispenser(this, tileEntityDispenser);
    }

    @Override
    public final void realDisplayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
        this.displayGUIDispenser(tileEntityDispenser);
    }

    @Override
    public final void superDisplayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
        super.displayGUIDispenser(tileEntityDispenser);
    }

    @Override
    public void displayGUIEditSign(TileEntity tileEntity) {
        ClientPlayerAPI.displayGUIEditSign(this, tileEntity);
    }

    @Override
    public final void realDisplayGUIEditSign(TileEntity tileEntity) {
        this.displayGUIEditSign(tileEntity);
    }

    @Override
    public final void superDisplayGUIEditSign(TileEntity tileEntity) {
        super.displayGUIEditSign(tileEntity);
    }

    @Override
    public void displayGUIEnchantment(int n, int n2, int n3, String string) {
        ClientPlayerAPI.displayGUIEnchantment(this, n, n2, n3, string);
    }

    @Override
    public final void realDisplayGUIEnchantment(int n, int n2, int n3, String string) {
        this.displayGUIEnchantment(n, n2, n3, string);
    }

    @Override
    public final void superDisplayGUIEnchantment(int n, int n2, int n3, String string) {
        super.displayGUIEnchantment(n, n2, n3, string);
    }

    @Override
    public void displayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
        ClientPlayerAPI.displayGUIFurnace(this, tileEntityFurnace);
    }

    @Override
    public final void realDisplayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
        this.displayGUIFurnace(tileEntityFurnace);
    }

    @Override
    public final void superDisplayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
        super.displayGUIFurnace(tileEntityFurnace);
    }

    @Override
    public void displayGUIWorkbench(int n, int n2, int n3) {
        ClientPlayerAPI.displayGUIWorkbench(this, n, n2, n3);
    }

    @Override
    public final void realDisplayGUIWorkbench(int n, int n2, int n3) {
        this.displayGUIWorkbench(n, n2, n3);
    }

    @Override
    public final void superDisplayGUIWorkbench(int n, int n2, int n3) {
        super.displayGUIWorkbench(n, n2, n3);
    }

    @Override
    public EntityItem dropOneItem(boolean bl) {
        return ClientPlayerAPI.dropOneItem(this, bl);
    }

    @Override
    public final EntityItem realDropOneItem(boolean bl) {
        return this.dropOneItem(bl);
    }

    @Override
    public final EntityItem superDropOneItem(boolean bl) {
        return super.dropOneItem(bl);
    }

    @Override
    public final EntityItem localDropOneItem(boolean bl) {
        return super.dropOneItem(bl);
    }

    @Override
    public EntityItem dropPlayerItem(ItemStack itemStack) {
        return ClientPlayerAPI.dropPlayerItem(this, itemStack);
    }

    @Override
    public final EntityItem realDropPlayerItem(ItemStack itemStack) {
        return this.dropPlayerItem(itemStack);
    }

    @Override
    public final EntityItem superDropPlayerItem(ItemStack itemStack) {
        return super.dropPlayerItem(itemStack);
    }

    @Override
    public final EntityItem localDropPlayerItem(ItemStack itemStack) {
        return super.dropPlayerItem(itemStack);
    }

    @Override
    public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean bl) {
        return ClientPlayerAPI.dropPlayerItemWithRandomChoice(this, itemStack, bl);
    }

    @Override
    public final EntityItem realDropPlayerItemWithRandomChoice(ItemStack itemStack, boolean bl) {
        return this.dropPlayerItemWithRandomChoice(itemStack, bl);
    }

    @Override
    public final EntityItem superDropPlayerItemWithRandomChoice(ItemStack itemStack, boolean bl) {
        return super.dropPlayerItemWithRandomChoice(itemStack, bl);
    }

    @Override
    public final EntityItem localDropPlayerItemWithRandomChoice(ItemStack itemStack, boolean bl) {
        return super.dropPlayerItemWithRandomChoice(itemStack, bl);
    }

    @Override
    public void fall(float f) {
        ClientPlayerAPI.fall(this, f);
    }

    @Override
    public final void realFall(float f) {
        this.fall(f);
    }

    @Override
    public final void superFall(float f) {
        super.fall(f);
    }

    @Override
    public final void localFall(float f) {
        super.fall(f);
    }

    @Override
    public float getBrightness(float f) {
        return ClientPlayerAPI.getBrightness(this, f);
    }

    @Override
    public final float realGetBrightness(float f) {
        return this.getBrightness(f);
    }

    @Override
    public final float superGetBrightness(float f) {
        return super.getBrightness(f);
    }

    @Override
    public final float localGetBrightness(float f) {
        return super.getBrightness(f);
    }

    @Override
    public int getBrightnessForRender(float f) {
        return ClientPlayerAPI.getBrightnessForRender(this, f);
    }

    @Override
    public final int realGetBrightnessForRender(float f) {
        return this.getBrightnessForRender(f);
    }

    @Override
    public final int superGetBrightnessForRender(float f) {
        return super.getBrightnessForRender(f);
    }

    @Override
    public final int localGetBrightnessForRender(float f) {
        return super.getBrightnessForRender(f);
    }

    @Override
    public float getCurrentPlayerStrVsBlock(Block block, boolean bl) {
        return ClientPlayerAPI.getCurrentPlayerStrVsBlock(this, block, bl);
    }

    @Override
    public final float realGetCurrentPlayerStrVsBlock(Block block, boolean bl) {
        return this.getCurrentPlayerStrVsBlock(block, bl);
    }

    @Override
    public final float superGetCurrentPlayerStrVsBlock(Block block, boolean bl) {
        return super.getCurrentPlayerStrVsBlock(block, bl);
    }

    @Override
    public final float localGetCurrentPlayerStrVsBlock(Block block, boolean bl) {
        return super.getCurrentPlayerStrVsBlock(block, bl);
    }

    @Override
    public float getCurrentPlayerStrVsBlock(Block block, boolean bl, int n) {
        return ClientPlayerAPI.getCurrentPlayerStrVsBlockForge(this, block, bl, n);
    }

    @Override
    public final float realGetCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
        return this.getCurrentPlayerStrVsBlock(block, bl, n);
    }

    @Override
    public final float superGetCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
        return super.getCurrentPlayerStrVsBlock(block, bl, n);
    }

    @Override
    public final float localGetCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
        return super.getCurrentPlayerStrVsBlock(block, bl, n);
    }

    @Override
    public double getDistanceSq(double d, double d2, double d3) {
        return ClientPlayerAPI.getDistanceSq(this, d, d2, d3);
    }

    @Override
    public final double realGetDistanceSq(double d, double d2, double d3) {
        return this.getDistanceSq(d, d2, d3);
    }

    @Override
    public final double superGetDistanceSq(double d, double d2, double d3) {
        return super.getDistanceSq(d, d2, d3);
    }

    @Override
    public final double localGetDistanceSq(double d, double d2, double d3) {
        return super.getDistanceSq(d, d2, d3);
    }

    @Override
    public double getDistanceSqToEntity(Entity entity) {
        return ClientPlayerAPI.getDistanceSqToEntity(this, entity);
    }

    @Override
    public final double realGetDistanceSqToEntity(Entity entity) {
        return this.getDistanceSqToEntity(entity);
    }

    @Override
    public final double superGetDistanceSqToEntity(Entity entity) {
        return super.getDistanceSqToEntity(entity);
    }

    @Override
    public final double localGetDistanceSqToEntity(Entity entity) {
        return super.getDistanceSqToEntity(entity);
    }

    public float getFOVMultiplier() {
        return ClientPlayerAPI.getFOVMultiplier(this);
    }

    @Override
    public final float realGetFOVMultiplier() {
        return this.getFOVMultiplier();
    }

    public final float superGetFOVMultiplier() {
        return super.t();
    }

    @Override
    public String getHurtSound() {
        return ClientPlayerAPI.getHurtSound(this);
    }

    @Override
    public final String realGetHurtSound() {
        return this.getHurtSound();
    }

    @Override
    public final String superGetHurtSound() {
        return super.getHurtSound();
    }

    @Override
    public final String localGetHurtSound() {
        return super.getHurtSound();
    }

    @Override
    public Icon getItemIcon(ItemStack itemStack, int n) {
        return ClientPlayerAPI.getItemIcon(this, itemStack, n);
    }

    @Override
    public final Icon realGetItemIcon(ItemStack itemStack, int n) {
        return this.getItemIcon(itemStack, n);
    }

    @Override
    public final Icon superGetItemIcon(ItemStack itemStack, int n) {
        return super.getItemIcon(itemStack, n);
    }

    @Override
    public final Icon localGetItemIcon(ItemStack itemStack, int n) {
        return super.getItemIcon(itemStack, n);
    }

    @Override
    public int getSleepTimer() {
        return ClientPlayerAPI.getSleepTimer(this);
    }

    @Override
    public final int realGetSleepTimer() {
        return this.getSleepTimer();
    }

    @Override
    public final int superGetSleepTimer() {
        return super.getSleepTimer();
    }

    @Override
    public final int localGetSleepTimer() {
        return super.getSleepTimer();
    }

    @Override
    public boolean handleLavaMovement() {
        return ClientPlayerAPI.handleLavaMovement(this);
    }

    @Override
    public final boolean realHandleLavaMovement() {
        return this.handleLavaMovement();
    }

    @Override
    public final boolean superHandleLavaMovement() {
        return super.handleLavaMovement();
    }

    @Override
    public final boolean localHandleLavaMovement() {
        return super.handleLavaMovement();
    }

    @Override
    public boolean handleWaterMovement() {
        return ClientPlayerAPI.handleWaterMovement(this);
    }

    @Override
    public final boolean realHandleWaterMovement() {
        return this.handleWaterMovement();
    }

    @Override
    public final boolean superHandleWaterMovement() {
        return super.handleWaterMovement();
    }

    @Override
    public final boolean localHandleWaterMovement() {
        return super.handleWaterMovement();
    }

    @Override
    public void heal(float f) {
        ClientPlayerAPI.heal(this, f);
    }

    @Override
    public final void realHeal(float f) {
        this.heal(f);
    }

    @Override
    public final void superHeal(float f) {
        super.heal(f);
    }

    @Override
    public final void localHeal(float f) {
        super.heal(f);
    }

    @Override
    public boolean isEntityInsideOpaqueBlock() {
        return ClientPlayerAPI.isEntityInsideOpaqueBlock(this);
    }

    @Override
    public final boolean realIsEntityInsideOpaqueBlock() {
        return this.isEntityInsideOpaqueBlock();
    }

    @Override
    public final boolean superIsEntityInsideOpaqueBlock() {
        return super.isEntityInsideOpaqueBlock();
    }

    @Override
    public final boolean localIsEntityInsideOpaqueBlock() {
        return super.isEntityInsideOpaqueBlock();
    }

    @Override
    public boolean isInWater() {
        return ClientPlayerAPI.isInWater(this);
    }

    @Override
    public final boolean realIsInWater() {
        return this.isInWater();
    }

    @Override
    public final boolean superIsInWater() {
        return super.isInWater();
    }

    @Override
    public final boolean localIsInWater() {
        return super.isInWater();
    }

    @Override
    public boolean isInsideOfMaterial(Material material) {
        return ClientPlayerAPI.isInsideOfMaterial(this, material);
    }

    @Override
    public final boolean realIsInsideOfMaterial(Material material) {
        return this.isInsideOfMaterial(material);
    }

    @Override
    public final boolean superIsInsideOfMaterial(Material material) {
        return super.isInsideOfMaterial(material);
    }

    @Override
    public final boolean localIsInsideOfMaterial(Material material) {
        return super.isInsideOfMaterial(material);
    }

    @Override
    public boolean isOnLadder() {
        return ClientPlayerAPI.isOnLadder(this);
    }

    @Override
    public final boolean realIsOnLadder() {
        return this.isOnLadder();
    }

    @Override
    public final boolean superIsOnLadder() {
        return super.isOnLadder();
    }

    @Override
    public final boolean localIsOnLadder() {
        return super.isOnLadder();
    }

    @Override
    public boolean isPlayerSleeping() {
        return ClientPlayerAPI.isPlayerSleeping(this);
    }

    @Override
    public final boolean realIsPlayerSleeping() {
        return this.isPlayerSleeping();
    }

    @Override
    public final boolean superIsPlayerSleeping() {
        return super.isPlayerSleeping();
    }

    @Override
    public final boolean localIsPlayerSleeping() {
        return super.isPlayerSleeping();
    }

    @Override
    public boolean isSneaking() {
        return ClientPlayerAPI.isSneaking(this);
    }

    @Override
    public final boolean realIsSneaking() {
        return this.isSneaking();
    }

    @Override
    public final boolean superIsSneaking() {
        return super.isSneaking();
    }

    @Override
    public boolean isSprinting() {
        return ClientPlayerAPI.isSprinting(this);
    }

    @Override
    public final boolean realIsSprinting() {
        return this.isSprinting();
    }

    @Override
    public final boolean superIsSprinting() {
        return super.isSprinting();
    }

    @Override
    public final boolean localIsSprinting() {
        return super.isSprinting();
    }

    @Override
    public void jump() {
        ClientPlayerAPI.jump(this);
    }

    @Override
    public final void realJump() {
        this.jump();
    }

    @Override
    public final void superJump() {
        super.jump();
    }

    @Override
    public final void localJump() {
        super.jump();
    }

    @Override
    public void knockBack(Entity entity, float f, double d, double d2) {
        ClientPlayerAPI.knockBack(this, entity, f, d, d2);
    }

    @Override
    public final void realKnockBack(Entity entity, float f, double d, double d2) {
        this.knockBack(entity, f, d, d2);
    }

    @Override
    public final void superKnockBack(Entity entity, float f, double d, double d2) {
        super.knockBack(entity, f, d, d2);
    }

    @Override
    public final void localKnockBack(Entity entity, float f, double d, double d2) {
        super.knockBack(entity, f, d, d2);
    }

    @Override
    public void moveEntity(double d, double d2, double d3) {
        ClientPlayerAPI.moveEntity(this, d, d2, d3);
    }

    @Override
    public final void realMoveEntity(double d, double d2, double d3) {
        this.moveEntity(d, d2, d3);
    }

    @Override
    public final void superMoveEntity(double d, double d2, double d3) {
        super.moveEntity(d, d2, d3);
    }

    @Override
    public final void localMoveEntity(double d, double d2, double d3) {
        super.moveEntity(d, d2, d3);
    }

    @Override
    public void moveEntityWithHeading(float f, float f2) {
        ClientPlayerAPI.moveEntityWithHeading(this, f, f2);
    }

    @Override
    public final void realMoveEntityWithHeading(float f, float f2) {
        this.moveEntityWithHeading(f, f2);
    }

    @Override
    public final void superMoveEntityWithHeading(float f, float f2) {
        super.moveEntityWithHeading(f, f2);
    }

    @Override
    public final void localMoveEntityWithHeading(float f, float f2) {
        super.moveEntityWithHeading(f, f2);
    }

    @Override
    public void moveFlying(float f, float f2, float f3) {
        ClientPlayerAPI.moveFlying(this, f, f2, f3);
    }

    @Override
    public final void realMoveFlying(float f, float f2, float f3) {
        this.moveFlying(f, f2, f3);
    }

    @Override
    public final void superMoveFlying(float f, float f2, float f3) {
        super.moveFlying(f, f2, f3);
    }

    @Override
    public final void localMoveFlying(float f, float f2, float f3) {
        super.moveFlying(f, f2, f3);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        ClientPlayerAPI.onDeath(this, damageSource);
    }

    @Override
    public final void realOnDeath(DamageSource damageSource) {
        this.onDeath(damageSource);
    }

    @Override
    public final void superOnDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
    }

    @Override
    public final void localOnDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
    }

    @Override
    public void onLivingUpdate() {
        ClientPlayerAPI.onLivingUpdate(this);
    }

    @Override
    public final void realOnLivingUpdate() {
        this.onLivingUpdate();
    }

    @Override
    public final void superOnLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    public void onKillEntity(EntityLivingBase entityLivingBase) {
        ClientPlayerAPI.onKillEntity(this, entityLivingBase);
    }

    @Override
    public final void realOnKillEntity(EntityLivingBase entityLivingBase) {
        this.onKillEntity(entityLivingBase);
    }

    @Override
    public final void superOnKillEntity(EntityLivingBase entityLivingBase) {
        super.onKillEntity(entityLivingBase);
    }

    @Override
    public final void localOnKillEntity(EntityLivingBase entityLivingBase) {
        super.onKillEntity(entityLivingBase);
    }

    @Override
    public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
        ClientPlayerAPI.onStruckByLightning(this, entityLightningBolt);
    }

    @Override
    public final void realOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
        this.onStruckByLightning(entityLightningBolt);
    }

    @Override
    public final void superOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
        super.onStruckByLightning(entityLightningBolt);
    }

    @Override
    public final void localOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
        super.onStruckByLightning(entityLightningBolt);
    }

    @Override
    public void onUpdate() {
        ClientPlayerAPI.onUpdate(this);
    }

    @Override
    public final void realOnUpdate() {
        this.onUpdate();
    }

    @Override
    public final void superOnUpdate() {
        super.onUpdate();
    }

    @Override
    public final void localOnUpdate() {
        super.onUpdate();
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        ClientPlayerAPI.playStepSound(this, n, n2, n3, n4);
    }

    @Override
    public final void realPlayStepSound(int n, int n2, int n3, int n4) {
        this.playStepSound(n, n2, n3, n4);
    }

    @Override
    public final void superPlayStepSound(int n, int n2, int n3, int n4) {
        super.playStepSound(n, n2, n3, n4);
    }

    @Override
    public final void localPlayStepSound(int n, int n2, int n3, int n4) {
        super.playStepSound(n, n2, n3, n4);
    }

    @Override
    public boolean pushOutOfBlocks(double d, double d2, double d3) {
        return ClientPlayerAPI.pushOutOfBlocks(this, d, d2, d3);
    }

    @Override
    public final boolean realPushOutOfBlocks(double d, double d2, double d3) {
        return this.pushOutOfBlocks(d, d2, d3);
    }

    @Override
    public final boolean superPushOutOfBlocks(double d, double d2, double d3) {
        return super.pushOutOfBlocks(d, d2, d3);
    }

    @Override
    public MovingObjectPosition rayTrace(double d, float f) {
        return ClientPlayerAPI.rayTrace(this, d, f);
    }

    @Override
    public final MovingObjectPosition realRayTrace(double d, float f) {
        return this.rayTrace(d, f);
    }

    @Override
    public final MovingObjectPosition superRayTrace(double d, float f) {
        return super.rayTrace(d, f);
    }

    @Override
    public final MovingObjectPosition localRayTrace(double d, float f) {
        return super.rayTrace(d, f);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        ClientPlayerAPI.readEntityFromNBT(this, nBTTagCompound);
    }

    @Override
    public final void realReadEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.readEntityFromNBT(nBTTagCompound);
    }

    @Override
    public final void superReadEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
    }

    @Override
    public final void localReadEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
    }

    @Override
    public void respawnPlayer() {
        ClientPlayerAPI.respawnPlayer(this);
    }

    @Override
    public final void realRespawnPlayer() {
        this.respawnPlayer();
    }

    @Override
    public final void superRespawnPlayer() {
        super.respawnPlayer();
    }

    @Override
    public final void localRespawnPlayer() {
        super.respawnPlayer();
    }

    @Override
    public void setDead() {
        ClientPlayerAPI.setDead(this);
    }

    @Override
    public final void realSetDead() {
        this.setDead();
    }

    @Override
    public final void superSetDead() {
        super.setDead();
    }

    @Override
    public final void localSetDead() {
        super.setDead();
    }

    public void setPlayerSPHealth(float f) {
        ClientPlayerAPI.setPlayerSPHealth(this, f);
    }

    @Override
    public final void realSetPlayerSPHealth(float f) {
        this.setPlayerSPHealth(f);
    }

    public final void superSetPlayerSPHealth(float f) {
        super.n(f);
    }

    @Override
    public void setPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        ClientPlayerAPI.setPositionAndRotation(this, d, d2, d3, f, f2);
    }

    @Override
    public final void realSetPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        this.setPositionAndRotation(d, d2, d3, f, f2);
    }

    @Override
    public final void superSetPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        super.setPositionAndRotation(d, d2, d3, f, f2);
    }

    @Override
    public final void localSetPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        super.setPositionAndRotation(d, d2, d3, f, f2);
    }

    @Override
    public EnumStatus sleepInBedAt(int n, int n2, int n3) {
        return ClientPlayerAPI.sleepInBedAt(this, n, n2, n3);
    }

    @Override
    public final EnumStatus realSleepInBedAt(int n, int n2, int n3) {
        return this.sleepInBedAt(n, n2, n3);
    }

    @Override
    public final EnumStatus superSleepInBedAt(int n, int n2, int n3) {
        return super.sleepInBedAt(n, n2, n3);
    }

    @Override
    public final EnumStatus localSleepInBedAt(int n, int n2, int n3) {
        return super.sleepInBedAt(n, n2, n3);
    }

    @Override
    public void swingItem() {
        ClientPlayerAPI.swingItem(this);
    }

    @Override
    public final void realSwingItem() {
        this.swingItem();
    }

    @Override
    public final void superSwingItem() {
        super.swingItem();
    }

    @Override
    public final void localSwingItem() {
        super.swingItem();
    }

    @Override
    public void updateEntityActionState() {
        ClientPlayerAPI.updateEntityActionState(this);
    }

    @Override
    public final void realUpdateEntityActionState() {
        this.updateEntityActionState();
    }

    @Override
    public final void superUpdateEntityActionState() {
        super.updateEntityActionState();
    }

    @Override
    public void updateRidden() {
        ClientPlayerAPI.updateRidden(this);
    }

    @Override
    public final void realUpdateRidden() {
        this.updateRidden();
    }

    @Override
    public final void superUpdateRidden() {
        super.updateRidden();
    }

    @Override
    public final void localUpdateRidden() {
        super.updateRidden();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        ClientPlayerAPI.writeEntityToNBT(this, nBTTagCompound);
    }

    @Override
    public final void realWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
        this.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public final void superWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public final void localWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public final boolean getAddedToChunkField() {
        return this.addedToChunk;
    }

    @Override
    public final void setAddedToChunkField(boolean bl) {
        this.addedToChunk = bl;
    }

    @Override
    public final int getArrowHitTimerField() {
        return this.arrowHitTimer;
    }

    @Override
    public final void setArrowHitTimerField(int n) {
        this.arrowHitTimer = n;
    }

    @Override
    public final int getAttackTimeField() {
        return this.attackTime;
    }

    @Override
    public final void setAttackTimeField(int n) {
        this.attackTime = n;
    }

    @Override
    public final float getAttackedAtYawField() {
        return this.attackedAtYaw;
    }

    @Override
    public final void setAttackedAtYawField(float f) {
        this.attackedAtYaw = f;
    }

    @Override
    public final EntityPlayer getAttackingPlayerField() {
        return this.attackingPlayer;
    }

    @Override
    public final void setAttackingPlayerField(EntityPlayer entityPlayer) {
        this.attackingPlayer = entityPlayer;
    }

    @Override
    public final AxisAlignedBB getBoundingBoxField() {
        return this.boundingBox;
    }

    @Override
    public final float getCameraPitchField() {
        return this.cameraPitch;
    }

    @Override
    public final void setCameraPitchField(float f) {
        this.cameraPitch = f;
    }

    @Override
    public final float getCameraYawField() {
        return this.cameraYaw;
    }

    @Override
    public final void setCameraYawField(float f) {
        this.cameraYaw = f;
    }

    @Override
    public final PlayerCapabilities getCapabilitiesField() {
        return this.capabilities;
    }

    @Override
    public final void setCapabilitiesField(PlayerCapabilities playerCapabilities) {
        this.capabilities = playerCapabilities;
    }

    @Override
    public final int getChunkCoordXField() {
        return this.chunkCoordX;
    }

    @Override
    public final void setChunkCoordXField(int n) {
        this.chunkCoordX = n;
    }

    @Override
    public final int getChunkCoordYField() {
        return this.chunkCoordY;
    }

    @Override
    public final void setChunkCoordYField(int n) {
        this.chunkCoordY = n;
    }

    @Override
    public final int getChunkCoordZField() {
        return this.chunkCoordZ;
    }

    @Override
    public final void setChunkCoordZField(int n) {
        this.chunkCoordZ = n;
    }

    @Override
    public final DataWatcher getDataWatcherField() {
        return this.dataWatcher;
    }

    @Override
    public final void setDataWatcherField(DataWatcher dataWatcher) {
        this.dataWatcher = dataWatcher;
    }

    @Override
    public final boolean getDeadField() {
        return this.dead;
    }

    @Override
    public final void setDeadField(boolean bl) {
        this.dead = bl;
    }

    @Override
    public final int getDeathTimeField() {
        return this.deathTime;
    }

    @Override
    public final void setDeathTimeField(int n) {
        this.deathTime = n;
    }

    @Override
    public final int getDimensionField() {
        return this.dimension;
    }

    @Override
    public final void setDimensionField(int n) {
        this.dimension = n;
    }

    @Override
    public final float getDistanceWalkedModifiedField() {
        return this.distanceWalkedModified;
    }

    @Override
    public final void setDistanceWalkedModifiedField(float f) {
        this.distanceWalkedModified = f;
    }

    @Override
    public final float getDistanceWalkedOnStepModifiedField() {
        return this.distanceWalkedOnStepModified;
    }

    @Override
    public final void setDistanceWalkedOnStepModifiedField(float f) {
        this.distanceWalkedOnStepModified = f;
    }

    @Override
    public final int getEntityAgeField() {
        return this.entityAge;
    }

    @Override
    public final void setEntityAgeField(int n) {
        this.entityAge = n;
    }

    @Override
    public final float getEntityCollisionReductionField() {
        return this.entityCollisionReduction;
    }

    @Override
    public final void setEntityCollisionReductionField(float f) {
        this.entityCollisionReduction = f;
    }

    @Override
    public final int getEntityIdField() {
        return this.entityId;
    }

    @Override
    public final void setEntityIdField(int n) {
        this.entityId = n;
    }

    @Override
    public final float getExperienceField() {
        return this.experience;
    }

    @Override
    public final void setExperienceField(float f) {
        this.experience = f;
    }

    @Override
    public final int getExperienceLevelField() {
        return this.experienceLevel;
    }

    @Override
    public final void setExperienceLevelField(int n) {
        this.experienceLevel = n;
    }

    @Override
    public final int getExperienceTotalField() {
        return this.experienceTotal;
    }

    @Override
    public final void setExperienceTotalField(int n) {
        this.experienceTotal = n;
    }

    @Override
    public final float getFallDistanceField() {
        return this.fallDistance;
    }

    @Override
    public final void setFallDistanceField(float f) {
        this.fallDistance = f;
    }

    @Override
    public final float getField_110154_aXField() {
        return this.field_110154_aX;
    }

    @Override
    public final void setField_110154_aXField(float f) {
        this.field_110154_aX = f;
    }

    @Override
    public final boolean getField_70135_KField() {
        return this.field_70135_K;
    }

    @Override
    public final void setField_70135_KField(boolean bl) {
        this.field_70135_K = bl;
    }

    @Override
    public final float getField_70741_aBField() {
        return this.field_70741_aB;
    }

    @Override
    public final void setField_70741_aBField(float f) {
        this.field_70741_aB = f;
    }

    @Override
    public final float getField_70763_axField() {
        return this.field_70763_ax;
    }

    @Override
    public final void setField_70763_axField(float f) {
        this.field_70763_ax = f;
    }

    @Override
    public final float getField_70764_awField() {
        return this.field_70764_aw;
    }

    @Override
    public final void setField_70764_awField(float f) {
        this.field_70764_aw = f;
    }

    @Override
    public final float getField_70768_auField() {
        return this.field_70768_au;
    }

    @Override
    public final void setField_70768_auField(float f) {
        this.field_70768_au = f;
    }

    @Override
    public final float getField_70769_aoField() {
        return this.field_70769_ao;
    }

    @Override
    public final void setField_70769_aoField(float f) {
        this.field_70769_ao = f;
    }

    @Override
    public final float getField_70770_apField() {
        return this.field_70770_ap;
    }

    @Override
    public final void setField_70770_apField(float f) {
        this.field_70770_ap = f;
    }

    @Override
    public final float getField_71079_bUField() {
        return this.field_71079_bU;
    }

    @Override
    public final void setField_71079_bUField(float f) {
        this.field_71079_bU = f;
    }

    @Override
    public final float getField_71082_cxField() {
        return this.field_71082_cx;
    }

    @Override
    public final void setField_71082_cxField(float f) {
        this.field_71082_cx = f;
    }

    @Override
    public final double getField_71085_bRField() {
        return this.field_71085_bR;
    }

    @Override
    public final void setField_71085_bRField(double d) {
        this.field_71085_bR = d;
    }

    @Override
    public final float getField_71089_bVField() {
        return this.field_71089_bV;
    }

    @Override
    public final void setField_71089_bVField(float f) {
        this.field_71089_bV = f;
    }

    @Override
    public final double getField_71091_bMField() {
        return this.field_71091_bM;
    }

    @Override
    public final void setField_71091_bMField(double d) {
        this.field_71091_bM = d;
    }

    @Override
    public final double getField_71094_bPField() {
        return this.field_71094_bP;
    }

    @Override
    public final void setField_71094_bPField(double d) {
        this.field_71094_bP = d;
    }

    @Override
    public final double getField_71095_bQField() {
        return this.field_71095_bQ;
    }

    @Override
    public final void setField_71095_bQField(double d) {
        this.field_71095_bQ = d;
    }

    @Override
    public final double getField_71096_bNField() {
        return this.field_71096_bN;
    }

    @Override
    public final void setField_71096_bNField(double d) {
        this.field_71096_bN = d;
    }

    @Override
    public final double getField_71097_bOField() {
        return this.field_71097_bO;
    }

    @Override
    public final void setField_71097_bOField(double d) {
        this.field_71097_bO = d;
    }

    @Override
    public final MouseFilter getField_71160_ciField() {
        return this.field_71160_ci;
    }

    @Override
    public final void setField_71160_ciField(MouseFilter mouseFilter) {
        this.field_71160_ci = mouseFilter;
    }

    @Override
    public final MouseFilter getField_71161_cjField() {
        return this.field_71161_cj;
    }

    @Override
    public final void setField_71161_cjField(MouseFilter mouseFilter) {
        this.field_71161_cj = mouseFilter;
    }

    @Override
    public final MouseFilter getField_71162_chField() {
        return this.field_71162_ch;
    }

    @Override
    public final void setField_71162_chField(MouseFilter mouseFilter) {
        this.field_71162_ch = mouseFilter;
    }

    @Override
    public final int getFireResistanceField() {
        return this.fireResistance;
    }

    @Override
    public final void setFireResistanceField(int n) {
        this.fireResistance = n;
    }

    @Override
    public final EntityFishHook getFishEntityField() {
        return this.fishEntity;
    }

    @Override
    public final void setFishEntityField(EntityFishHook entityFishHook) {
        this.fishEntity = entityFishHook;
    }

    @Override
    public final int getFlyToggleTimerField() {
        return this.flyToggleTimer;
    }

    @Override
    public final void setFlyToggleTimerField(int n) {
        this.flyToggleTimer = n;
    }

    @Override
    public final FoodStats getFoodStatsField() {
        return this.foodStats;
    }

    @Override
    public final void setFoodStatsField(FoodStats foodStats) {
        this.foodStats = foodStats;
    }

    @Override
    public final boolean getForceSpawnField() {
        return this.forceSpawn;
    }

    @Override
    public final void setForceSpawnField(boolean bl) {
        this.forceSpawn = bl;
    }

    @Override
    public final float getHeightField() {
        return this.height;
    }

    @Override
    public final void setHeightField(float f) {
        this.height = f;
    }

    @Override
    public final float getHorseJumpPowerField() {
        return this.horseJumpPower;
    }

    @Override
    public final void setHorseJumpPowerField(float f) {
        this.horseJumpPower = f;
    }

    @Override
    public final int getHorseJumpPowerCounterField() {
        return this.horseJumpPowerCounter;
    }

    @Override
    public final void setHorseJumpPowerCounterField(int n) {
        this.horseJumpPowerCounter = n;
    }

    @Override
    public final int getHurtResistantTimeField() {
        return this.hurtResistantTime;
    }

    @Override
    public final void setHurtResistantTimeField(int n) {
        this.hurtResistantTime = n;
    }

    @Override
    public final int getHurtTimeField() {
        return this.hurtTime;
    }

    @Override
    public final void setHurtTimeField(int n) {
        this.hurtTime = n;
    }

    @Override
    public final boolean getIgnoreFrustumCheckField() {
        return this.ignoreFrustumCheck;
    }

    @Override
    public final void setIgnoreFrustumCheckField(boolean bl) {
        this.ignoreFrustumCheck = bl;
    }

    @Override
    public final boolean getInPortalField() {
        return this.inPortal;
    }

    @Override
    public final void setInPortalField(boolean bl) {
        this.inPortal = bl;
    }

    @Override
    public final boolean getInWaterField() {
        return this.inWater;
    }

    @Override
    public final void setInWaterField(boolean bl) {
        this.inWater = bl;
    }

    @Override
    public final InventoryPlayer getInventoryField() {
        return this.inventory;
    }

    @Override
    public final void setInventoryField(InventoryPlayer inventoryPlayer) {
        this.inventory = inventoryPlayer;
    }

    @Override
    public final Container getInventoryContainerField() {
        return this.inventoryContainer;
    }

    @Override
    public final void setInventoryContainerField(Container container) {
        this.inventoryContainer = container;
    }

    @Override
    public final boolean getIsAirBorneField() {
        return this.isAirBorne;
    }

    @Override
    public final void setIsAirBorneField(boolean bl) {
        this.isAirBorne = bl;
    }

    @Override
    public final boolean getIsCollidedField() {
        return this.isCollided;
    }

    @Override
    public final void setIsCollidedField(boolean bl) {
        this.isCollided = bl;
    }

    @Override
    public final boolean getIsCollidedHorizontallyField() {
        return this.isCollidedHorizontally;
    }

    @Override
    public final void setIsCollidedHorizontallyField(boolean bl) {
        this.isCollidedHorizontally = bl;
    }

    @Override
    public final boolean getIsCollidedVerticallyField() {
        return this.isCollidedVertically;
    }

    @Override
    public final void setIsCollidedVerticallyField(boolean bl) {
        this.isCollidedVertically = bl;
    }

    @Override
    public final boolean getIsDeadField() {
        return this.isDead;
    }

    @Override
    public final void setIsDeadField(boolean bl) {
        this.isDead = bl;
    }

    @Override
    public final boolean getIsImmuneToFireField() {
        return this.isImmuneToFire;
    }

    @Override
    public final void setIsImmuneToFireField(boolean bl) {
        this.isImmuneToFire = bl;
    }

    @Override
    public final boolean getIsInWebField() {
        return this.isInWeb;
    }

    @Override
    public final void setIsInWebField(boolean bl) {
        this.isInWeb = bl;
    }

    @Override
    public final boolean getIsJumpingField() {
        return this.isJumping;
    }

    @Override
    public final void setIsJumpingField(boolean bl) {
        this.isJumping = bl;
    }

    @Override
    public final boolean getIsSwingInProgressField() {
        return this.isSwingInProgress;
    }

    @Override
    public final void setIsSwingInProgressField(boolean bl) {
        this.isSwingInProgress = bl;
    }

    @Override
    public final float getJumpMovementFactorField() {
        return this.jumpMovementFactor;
    }

    @Override
    public final void setJumpMovementFactorField(float f) {
        this.jumpMovementFactor = f;
    }

    @Override
    public final float getLastDamageField() {
        return this.lastDamage;
    }

    @Override
    public final void setLastDamageField(float f) {
        this.lastDamage = f;
    }

    @Override
    public final double getLastTickPosXField() {
        return this.lastTickPosX;
    }

    @Override
    public final void setLastTickPosXField(double d) {
        this.lastTickPosX = d;
    }

    @Override
    public final double getLastTickPosYField() {
        return this.lastTickPosY;
    }

    @Override
    public final void setLastTickPosYField(double d) {
        this.lastTickPosY = d;
    }

    @Override
    public final double getLastTickPosZField() {
        return this.lastTickPosZ;
    }

    @Override
    public final void setLastTickPosZField(double d) {
        this.lastTickPosZ = d;
    }

    @Override
    public final float getLimbSwingField() {
        return this.limbSwing;
    }

    @Override
    public final void setLimbSwingField(float f) {
        this.limbSwing = f;
    }

    @Override
    public final float getLimbSwingAmountField() {
        return this.limbSwingAmount;
    }

    @Override
    public final void setLimbSwingAmountField(float f) {
        this.limbSwingAmount = f;
    }

    @Override
    public final int getMaxHurtResistantTimeField() {
        return this.maxHurtResistantTime;
    }

    @Override
    public final void setMaxHurtResistantTimeField(int n) {
        this.maxHurtResistantTime = n;
    }

    @Override
    public final int getMaxHurtTimeField() {
        return this.maxHurtTime;
    }

    @Override
    public final void setMaxHurtTimeField(int n) {
        this.maxHurtTime = n;
    }

    @Override
    public final Minecraft getMcField() {
        return this.mc;
    }

    @Override
    public final void setMcField(Minecraft minecraft) {
        this.mc = minecraft;
    }

    @Override
    public final double getMotionXField() {
        return this.motionX;
    }

    @Override
    public final void setMotionXField(double d) {
        this.motionX = d;
    }

    @Override
    public final double getMotionYField() {
        return this.motionY;
    }

    @Override
    public final void setMotionYField(double d) {
        this.motionY = d;
    }

    @Override
    public final double getMotionZField() {
        return this.motionZ;
    }

    @Override
    public final void setMotionZField(double d) {
        this.motionZ = d;
    }

    @Override
    public final float getMoveForwardField() {
        return this.moveForward;
    }

    @Override
    public final void setMoveForwardField(float f) {
        this.moveForward = f;
    }

    @Override
    public final float getMoveStrafingField() {
        return this.moveStrafing;
    }

    @Override
    public final void setMoveStrafingField(float f) {
        this.moveStrafing = f;
    }

    @Override
    public final kjwj getMovementInputField() {
        return this.movementInput;
    }

    @Override
    public final void setMovementInputField(kjwj kjwj2) {
        this.movementInput = kjwj2;
    }

    @Override
    public final EnumEntitySize getMyEntitySizeField() {
        return this.myEntitySize;
    }

    @Override
    public final void setMyEntitySizeField(EnumEntitySize enumEntitySize) {
        this.myEntitySize = enumEntitySize;
    }

    @Override
    public final int getNewPosRotationIncrementsField() {
        return this.newPosRotationIncrements;
    }

    @Override
    public final void setNewPosRotationIncrementsField(int n) {
        this.newPosRotationIncrements = n;
    }

    @Override
    public final double getNewPosXField() {
        return this.newPosX;
    }

    @Override
    public final void setNewPosXField(double d) {
        this.newPosX = d;
    }

    @Override
    public final double getNewPosYField() {
        return this.newPosY;
    }

    @Override
    public final void setNewPosYField(double d) {
        this.newPosY = d;
    }

    @Override
    public final double getNewPosZField() {
        return this.newPosZ;
    }

    @Override
    public final void setNewPosZField(double d) {
        this.newPosZ = d;
    }

    @Override
    public final double getNewRotationPitchField() {
        return this.newRotationPitch;
    }

    @Override
    public final void setNewRotationPitchField(double d) {
        this.newRotationPitch = d;
    }

    @Override
    public final double getNewRotationYawField() {
        return this.newRotationYaw;
    }

    @Override
    public final void setNewRotationYawField(double d) {
        this.newRotationYaw = d;
    }

    @Override
    public final boolean getNoClipField() {
        return this.noClip;
    }

    @Override
    public final void setNoClipField(boolean bl) {
        this.noClip = bl;
    }

    @Override
    public final boolean getOnGroundField() {
        return this.onGround;
    }

    @Override
    public final void setOnGroundField(boolean bl) {
        this.onGround = bl;
    }

    @Override
    public final Container getOpenContainerField() {
        return this.openContainer;
    }

    @Override
    public final void setOpenContainerField(Container container) {
        this.openContainer = container;
    }

    @Override
    public final ChunkCoordinates getPlayerLocationField() {
        return this.playerLocation;
    }

    @Override
    public final void setPlayerLocationField(ChunkCoordinates chunkCoordinates) {
        this.playerLocation = chunkCoordinates;
    }

    @Override
    public final int getPortalCounterField() {
        return this.portalCounter;
    }

    @Override
    public final void setPortalCounterField(int n) {
        this.portalCounter = n;
    }

    @Override
    public final double getPosXField() {
        return this.posX;
    }

    @Override
    public final void setPosXField(double d) {
        this.posX = d;
    }

    @Override
    public final double getPosYField() {
        return this.posY;
    }

    @Override
    public final void setPosYField(double d) {
        this.posY = d;
    }

    @Override
    public final double getPosZField() {
        return this.posZ;
    }

    @Override
    public final void setPosZField(double d) {
        this.posZ = d;
    }

    @Override
    public final float getPrevCameraPitchField() {
        return this.prevCameraPitch;
    }

    @Override
    public final void setPrevCameraPitchField(float f) {
        this.prevCameraPitch = f;
    }

    @Override
    public final float getPrevCameraYawField() {
        return this.prevCameraYaw;
    }

    @Override
    public final void setPrevCameraYawField(float f) {
        this.prevCameraYaw = f;
    }

    @Override
    public final float getPrevDistanceWalkedModifiedField() {
        return this.prevDistanceWalkedModified;
    }

    @Override
    public final void setPrevDistanceWalkedModifiedField(float f) {
        this.prevDistanceWalkedModified = f;
    }

    @Override
    public final float getPrevHealthField() {
        return this.prevHealth;
    }

    @Override
    public final void setPrevHealthField(float f) {
        this.prevHealth = f;
    }

    @Override
    public final float getPrevLimbSwingAmountField() {
        return this.prevLimbSwingAmount;
    }

    @Override
    public final void setPrevLimbSwingAmountField(float f) {
        this.prevLimbSwingAmount = f;
    }

    @Override
    public final double getPrevPosXField() {
        return this.prevPosX;
    }

    @Override
    public final void setPrevPosXField(double d) {
        this.prevPosX = d;
    }

    @Override
    public final double getPrevPosYField() {
        return this.prevPosY;
    }

    @Override
    public final void setPrevPosYField(double d) {
        this.prevPosY = d;
    }

    @Override
    public final double getPrevPosZField() {
        return this.prevPosZ;
    }

    @Override
    public final void setPrevPosZField(double d) {
        this.prevPosZ = d;
    }

    @Override
    public final float getPrevRenderArmPitchField() {
        return this.prevRenderArmPitch;
    }

    @Override
    public final void setPrevRenderArmPitchField(float f) {
        this.prevRenderArmPitch = f;
    }

    @Override
    public final float getPrevRenderArmYawField() {
        return this.prevRenderArmYaw;
    }

    @Override
    public final void setPrevRenderArmYawField(float f) {
        this.prevRenderArmYaw = f;
    }

    @Override
    public final float getPrevRenderYawOffsetField() {
        return this.prevRenderYawOffset;
    }

    @Override
    public final void setPrevRenderYawOffsetField(float f) {
        this.prevRenderYawOffset = f;
    }

    @Override
    public final float getPrevRotationPitchField() {
        return this.prevRotationPitch;
    }

    @Override
    public final void setPrevRotationPitchField(float f) {
        this.prevRotationPitch = f;
    }

    @Override
    public final float getPrevRotationYawField() {
        return this.prevRotationYaw;
    }

    @Override
    public final void setPrevRotationYawField(float f) {
        this.prevRotationYaw = f;
    }

    @Override
    public final float getPrevRotationYawHeadField() {
        return this.prevRotationYawHead;
    }

    @Override
    public final void setPrevRotationYawHeadField(float f) {
        this.prevRotationYawHead = f;
    }

    @Override
    public final float getPrevSwingProgressField() {
        return this.prevSwingProgress;
    }

    @Override
    public final void setPrevSwingProgressField(float f) {
        this.prevSwingProgress = f;
    }

    @Override
    public final float getPrevTimeInPortalField() {
        return this.prevTimeInPortal;
    }

    @Override
    public final void setPrevTimeInPortalField(float f) {
        this.prevTimeInPortal = f;
    }

    @Override
    public final boolean getPreventEntitySpawningField() {
        return this.preventEntitySpawning;
    }

    @Override
    public final void setPreventEntitySpawningField(boolean bl) {
        this.preventEntitySpawning = bl;
    }

    @Override
    public final Random getRandField() {
        return this.rand;
    }

    @Override
    public final void setRandField(Random random) {
        this.rand = random;
    }

    @Override
    public final float getRandomYawVelocityField() {
        return this.randomYawVelocity;
    }

    @Override
    public final void setRandomYawVelocityField(float f) {
        this.randomYawVelocity = f;
    }

    @Override
    public final int getRecentlyHitField() {
        return this.recentlyHit;
    }

    @Override
    public final void setRecentlyHitField(int n) {
        this.recentlyHit = n;
    }

    @Override
    public final float getRenderArmPitchField() {
        return this.renderArmPitch;
    }

    @Override
    public final void setRenderArmPitchField(float f) {
        this.renderArmPitch = f;
    }

    @Override
    public final float getRenderArmYawField() {
        return this.renderArmYaw;
    }

    @Override
    public final void setRenderArmYawField(float f) {
        this.renderArmYaw = f;
    }

    @Override
    public final double getRenderDistanceWeightField() {
        return this.renderDistanceWeight;
    }

    @Override
    public final void setRenderDistanceWeightField(double d) {
        this.renderDistanceWeight = d;
    }

    @Override
    public final float getRenderYawOffsetField() {
        return this.renderYawOffset;
    }

    @Override
    public final void setRenderYawOffsetField(float f) {
        this.renderYawOffset = f;
    }

    @Override
    public final Entity getRiddenByEntityField() {
        return this.riddenByEntity;
    }

    @Override
    public final void setRiddenByEntityField(Entity entity) {
        this.riddenByEntity = entity;
    }

    @Override
    public final Entity getRidingEntityField() {
        return this.ridingEntity;
    }

    @Override
    public final void setRidingEntityField(Entity entity) {
        this.ridingEntity = entity;
    }

    @Override
    public final float getRotationPitchField() {
        return this.rotationPitch;
    }

    @Override
    public final void setRotationPitchField(float f) {
        this.rotationPitch = f;
    }

    @Override
    public final float getRotationYawField() {
        return this.rotationYaw;
    }

    @Override
    public final void setRotationYawField(float f) {
        this.rotationYaw = f;
    }

    @Override
    public final float getRotationYawHeadField() {
        return this.rotationYawHead;
    }

    @Override
    public final void setRotationYawHeadField(float f) {
        this.rotationYawHead = f;
    }

    @Override
    public final int getScoreValueField() {
        return this.scoreValue;
    }

    @Override
    public final void setScoreValueField(int n) {
        this.scoreValue = n;
    }

    @Override
    public final int getServerPosXField() {
        return this.serverPosX;
    }

    @Override
    public final void setServerPosXField(int n) {
        this.serverPosX = n;
    }

    @Override
    public final int getServerPosYField() {
        return this.serverPosY;
    }

    @Override
    public final void setServerPosYField(int n) {
        this.serverPosY = n;
    }

    @Override
    public final int getServerPosZField() {
        return this.serverPosZ;
    }

    @Override
    public final void setServerPosZField(int n) {
        this.serverPosZ = n;
    }

    @Override
    public final int getSleepTimerField() {
        return this.sleepTimer;
    }

    @Override
    public final void setSleepTimerField(int n) {
        this.sleepTimer = n;
    }

    @Override
    public final boolean getSleepingField() {
        return this.sleeping;
    }

    @Override
    public final void setSleepingField(boolean bl) {
        this.sleeping = bl;
    }

    @Override
    public final float getSpeedInAirField() {
        return this.speedInAir;
    }

    @Override
    public final void setSpeedInAirField(float f) {
        this.speedInAir = f;
    }

    @Override
    public final float getSpeedOnGroundField() {
        return this.speedOnGround;
    }

    @Override
    public final void setSpeedOnGroundField(float f) {
        this.speedOnGround = f;
    }

    @Override
    public final int getSprintToggleTimerField() {
        return this.sprintToggleTimer;
    }

    @Override
    public final void setSprintToggleTimerField(int n) {
        this.sprintToggleTimer = n;
    }

    @Override
    public final int getSprintingTicksLeftField() {
        return this.sprintingTicksLeft;
    }

    @Override
    public final void setSprintingTicksLeftField(int n) {
        this.sprintingTicksLeft = n;
    }

    @Override
    public final float getStepHeightField() {
        return this.stepHeight;
    }

    @Override
    public final void setStepHeightField(float f) {
        this.stepHeight = f;
    }

    @Override
    public final float getSwingProgressField() {
        return this.swingProgress;
    }

    @Override
    public final void setSwingProgressField(float f) {
        this.swingProgress = f;
    }

    @Override
    public final int getSwingProgressIntField() {
        return this.swingProgressInt;
    }

    @Override
    public final void setSwingProgressIntField(int n) {
        this.swingProgressInt = n;
    }

    @Override
    public final int getTeleportDirectionField() {
        return this.teleportDirection;
    }

    @Override
    public final void setTeleportDirectionField(int n) {
        this.teleportDirection = n;
    }

    @Override
    public final int getTicksExistedField() {
        return this.ticksExisted;
    }

    @Override
    public final void setTicksExistedField(int n) {
        this.ticksExisted = n;
    }

    @Override
    public final float getTimeInPortalField() {
        return this.timeInPortal;
    }

    @Override
    public final void setTimeInPortalField(float f) {
        this.timeInPortal = f;
    }

    @Override
    public final int getTimeUntilPortalField() {
        return this.timeUntilPortal;
    }

    @Override
    public final void setTimeUntilPortalField(int n) {
        this.timeUntilPortal = n;
    }

    @Override
    public final String getUsernameField() {
        return this.username;
    }

    @Override
    public final boolean getVelocityChangedField() {
        return this.velocityChanged;
    }

    @Override
    public final void setVelocityChangedField(boolean bl) {
        this.velocityChanged = bl;
    }

    @Override
    public final float getWidthField() {
        return this.width;
    }

    @Override
    public final void setWidthField(float f) {
        this.width = f;
    }

    @Override
    public final World getWorldObjField() {
        return this.worldObj;
    }

    @Override
    public final void setWorldObjField(World world) {
        this.worldObj = world;
    }

    @Override
    public final int getXpCooldownField() {
        return this.xpCooldown;
    }

    @Override
    public final void setXpCooldownField(int n) {
        this.xpCooldown = n;
    }

    @Override
    public final float getYOffsetField() {
        return this.yOffset;
    }

    @Override
    public final void setYOffsetField(float f) {
        this.yOffset = f;
    }

    @Override
    public final float getYSizeField() {
        return this.ySize;
    }

    @Override
    public final void setYSizeField(float f) {
        this.ySize = f;
    }

    @Override
    public final ClientPlayerBase getClientPlayerBase(String string) {
        return ClientPlayerAPI.getClientPlayerBase(this, string);
    }

    public final Set getClientPlayerBaseIds() {
        return ClientPlayerAPI.getClientPlayerBaseIds(this);
    }

    @Override
    public final Object dynamic(String string, Object[] objectArray) {
        return ClientPlayerAPI.dynamic(this, string, objectArray);
    }

    @Override
    public final ClientPlayerAPI getClientPlayerAPI() {
        return this.clientPlayerAPI;
    }

    @Override
    public final EntityPlayerSP getEntityPlayerSP() {
        return this;
    }
}

