/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet107CreativeSetSlot;
import net.minecraft.network.packet.Packet108EnchantItem;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet7UseEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

@SideOnly(value=Side.CLIENT)
public class vlzh {
    public final Minecraft _a;
    public final bscn _b;
    public int _c = -1;
    public int _d = -1;
    public int _e = -1;
    public ItemStack _f;
    public float _g;
    public float _h;
    public int _i;
    public boolean _j;
    public EnumGameType _k = EnumGameType._b;
    public int _l;

    public vlzh(Minecraft minecraft, bscn bscn2) {
        this._a = minecraft;
        this._b = bscn2;
    }

    public static void _a(Minecraft minecraft, vlzh vlzh2, int n, int n2, int n3, int n4) {
        if (!minecraft._r.extinguishFire(minecraft._t, n, n2, n3, n4)) {
            vlzh2._a(n, n2, n3, n4);
        }
    }

    public void _a(EntityPlayer entityPlayer) {
        this._k._a(entityPlayer.capabilities);
    }

    public boolean _a() {
        return false;
    }

    public void _a(EnumGameType enumGameType) {
        this._k = enumGameType;
        this._k._a(this._a._t.capabilities);
    }

    public void _b(EntityPlayer entityPlayer) {
        entityPlayer.rotationYaw = -180.0f;
    }

    public boolean _b() {
        return this._k._e();
    }

    public boolean _a(int n, int n2, int n3, int n4) {
        ItemStack itemStack;
        ItemStack itemStack2 = this._a._t.getCurrentEquippedItem();
        if (itemStack2 != null && itemStack2._a() != null && itemStack2._a().onBlockStartBreak(itemStack2, n, n2, n3, this._a._t)) {
            return false;
        }
        if (this._k._c() && !this._a._t.isCurrentToolAdventureModeExempt(n, n2, n3)) {
            return false;
        }
        if (this._k._d() && this._a._t.getHeldItem() != null && this._a._t.getHeldItem()._a() instanceof ItemSword) {
            return false;
        }
        pkix pkix2 = this._a._r;
        Block block = Block.blocksList[pkix2.getBlockId(n, n2, n3)];
        if (block == null) {
            return false;
        }
        pkix2.playAuxSFX(2001, n, n2, n3, block.blockID + (pkix2.getBlockMetadata(n, n2, n3) << 12));
        int n5 = pkix2.getBlockMetadata(n, n2, n3);
        boolean bl = block.removeBlockByPlayer(pkix2, this._a._t, n, n2, n3);
        if (bl) {
            block.onBlockDestroyedByPlayer(pkix2, n, n2, n3, n5);
        }
        this._d = -1;
        if (!this._k._d() && (itemStack = this._a._t.getCurrentEquippedItem()) != null) {
            itemStack._a(pkix2, block.blockID, n, n2, n3, this._a._t);
            if (itemStack._b == 0) {
                this._a._t.destroyCurrentEquippedItem();
            }
        }
        return bl;
    }

    public void _b(int n, int n2, int n3, int n4) {
        if (!this._k._c() || this._a._t.isCurrentToolAdventureModeExempt(n, n2, n3)) {
            if (this._k._d()) {
                this._b._b(new Packet14BlockDig(0, n, n2, n3, n4));
                vlzh._a(this._a, this, n, n2, n3, n4);
                this._i = 5;
            } else if (!this._j || !this._a(n, n2, n3)) {
                if (this._j) {
                    this._b._b(new Packet14BlockDig(1, this._c, this._d, this._e, n4));
                }
                this._b._b(new Packet14BlockDig(0, n, n2, n3, n4));
                int n5 = this._a._r.getBlockId(n, n2, n3);
                if (n5 > 0 && this._g == 0.0f) {
                    Block.blocksList[n5].onBlockClicked(this._a._r, n, n2, n3, this._a._t);
                }
                if (n5 > 0 && Block.blocksList[n5].getPlayerRelativeBlockHardness(this._a._t, this._a._t.worldObj, n, n2, n3) >= 1.0f) {
                    this._a(n, n2, n3, n4);
                } else {
                    this._j = true;
                    this._c = n;
                    this._d = n2;
                    this._e = n3;
                    this._f = this._a._t.getHeldItem();
                    this._g = 0.0f;
                    this._h = 0.0f;
                    this._a._r.destroyBlockInWorldPartially(this._a._t.entityId, this._c, this._d, this._e, (int)(this._g * 10.0f) - 1);
                }
            }
        }
    }

    public void _c() {
        if (this._j) {
            this._b._b(new Packet14BlockDig(1, this._c, this._d, this._e, -1));
        }
        this._j = false;
        this._g = 0.0f;
        this._a._r.destroyBlockInWorldPartially(this._a._t.entityId, this._c, this._d, this._e, -1);
    }

    public void _c(int n, int n2, int n3, int n4) {
        this._f();
        if (this._i > 0) {
            --this._i;
        } else if (this._k._d()) {
            this._i = 5;
            this._b._b(new Packet14BlockDig(0, n, n2, n3, n4));
            vlzh._a(this._a, this, n, n2, n3, n4);
        } else if (this._a(n, n2, n3)) {
            int n5 = this._a._r.getBlockId(n, n2, n3);
            if (n5 == 0) {
                this._j = false;
                return;
            }
            Block block = Block.blocksList[n5];
            this._g += block.getPlayerRelativeBlockHardness(this._a._t, this._a._t.worldObj, n, n2, n3);
            if (this._h % 4.0f == 0.0f && block != null) {
                this._a._N._a(block.stepSound._d(), (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, (block.stepSound._a() + 1.0f) / 8.0f, block.stepSound._b() * 0.5f);
            }
            this._h += 1.0f;
            if (this._g >= 1.0f) {
                this._j = false;
                this._b._b(new Packet14BlockDig(2, n, n2, n3, n4));
                this._a(n, n2, n3, n4);
                this._g = 0.0f;
                this._h = 0.0f;
                this._i = 5;
            }
            this._a._r.destroyBlockInWorldPartially(this._a._t.entityId, this._c, this._d, this._e, (int)(this._g * 10.0f) - 1);
        } else {
            this._b(n, n2, n3, n4);
        }
    }

    public float _d() {
        return this._k._d() ? 5.0f : 4.5f;
    }

    public void _e() {
        this._f();
        this._a._N._e();
    }

    public boolean _a(int n, int n2, int n3) {
        boolean bl;
        ItemStack itemStack = this._a._t.getHeldItem();
        boolean bl2 = bl = this._f == null && itemStack == null;
        if (this._f != null && itemStack != null) {
            bl = itemStack._d == this._f._d && ItemStack._a(itemStack, this._f) && (itemStack._f() || itemStack._j() == this._f._j());
        }
        return n == this._c && n2 == this._d && n3 == this._e && bl;
    }

    public void _f() {
        int n = this._a._t.inventory._c;
        if (n != this._l) {
            this._l = n;
            this._b._b(new Packet16BlockItemSwitch(this._l));
        }
    }

    public boolean _a(EntityPlayer entityPlayer, World world, ItemStack itemStack, int n, int n2, int n3, int n4, Vec3 vec3) {
        ItemBlock itemBlock;
        int n5;
        this._f();
        float f = (float)vec3._c - (float)n;
        float f2 = (float)vec3._d - (float)n2;
        float f3 = (float)vec3._e - (float)n3;
        boolean bl = false;
        if (itemStack != null && itemStack._a() != null && itemStack._a().onItemUseFirst(itemStack, entityPlayer, world, n, n2, n3, n4, f, f2, f3)) {
            return true;
        }
        if ((!entityPlayer.isSneaking() || entityPlayer.getHeldItem() == null || entityPlayer.getHeldItem()._a().shouldPassSneakingClickToBlock(world, n, n2, n3)) && (n5 = world.getBlockId(n, n2, n3)) > 0 && Block.blocksList[n5].onBlockActivated(world, n, n2, n3, entityPlayer, n4, f, f2, f3)) {
            bl = true;
        }
        if (!bl && itemStack != null && itemStack._a() instanceof ItemBlock && !(itemBlock = (ItemBlock)itemStack._a()).canPlaceItemBlockOnSide(world, n, n2, n3, n4, entityPlayer, itemStack)) {
            return false;
        }
        this._b._b(new Packet15Place(n, n2, n3, n4, entityPlayer.inventory._a(), f, f2, f3));
        if (bl) {
            return true;
        }
        if (itemStack == null) {
            return false;
        }
        if (this._k._d()) {
            n5 = itemStack._j();
            int n6 = itemStack._b;
            boolean bl2 = itemStack._a(entityPlayer, world, n, n2, n3, n4, f, f2, f3);
            itemStack._b(n5);
            itemStack._b = n6;
            return bl2;
        }
        if (!itemStack._a(entityPlayer, world, n, n2, n3, n4, f, f2, f3)) {
            return false;
        }
        if (itemStack._b <= 0) {
            MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(entityPlayer, itemStack));
        }
        return true;
    }

    public boolean _a(EntityPlayer entityPlayer, World world, ItemStack itemStack) {
        this._f();
        this._b._b(new Packet15Place(-1, -1, -1, 255, entityPlayer.inventory._a(), 0.0f, 0.0f, 0.0f));
        int n = itemStack._b;
        ItemStack itemStack2 = itemStack._a(world, entityPlayer);
        if (itemStack2 == itemStack && (itemStack2 == null || itemStack2._b == n)) {
            return false;
        }
        entityPlayer.inventory._a[entityPlayer.inventory._c] = itemStack2;
        if (itemStack2._b <= 0) {
            entityPlayer.inventory._a[entityPlayer.inventory._c] = null;
            MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(entityPlayer, itemStack2));
        }
        return true;
    }

    public EntityClientPlayerMP _a(World world) {
        return new EntityClientPlayerMP(this._a, world, this._a._P(), this._b);
    }

    public void _a(EntityPlayer entityPlayer, Entity entity) {
        boolean bl = qlgf._a(this, entityPlayer, entity);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        this._f();
        this._b._b(new Packet7UseEntity(entityPlayer.entityId, entity.entityId, 1));
        entityPlayer.attackTargetEntityWithCurrentItem(entity);
    }

    public boolean _b(EntityPlayer entityPlayer, Entity entity) {
        this._f();
        this._b._b(new Packet7UseEntity(entityPlayer.entityId, entity.entityId, 0));
        return entityPlayer.interactWith(entity);
    }

    public ItemStack _a(int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        short s = entityPlayer.openContainer.getNextTransactionID(entityPlayer.inventory);
        ItemStack itemStack = entityPlayer.openContainer.slotClick(n2, n3, n4, entityPlayer);
        this._b._b(new Packet102WindowClick(n, n2, n3, n4, itemStack, s));
        return itemStack;
    }

    public void _a(int n, int n2) {
        this._b._b(new Packet108EnchantItem(n, n2));
    }

    public void _a(ItemStack itemStack, int n) {
        if (this._k._d()) {
            this._b._b(new Packet107CreativeSetSlot(n, itemStack));
        }
    }

    public void _a(ItemStack itemStack) {
        if (this._k._d() && itemStack != null) {
            this._b._b(new Packet107CreativeSetSlot(-1, itemStack));
        }
    }

    public void _c(EntityPlayer entityPlayer) {
        GloomyHooks.onStoppedUsingItem(this, entityPlayer);
    }

    public boolean _g() {
        return this._k._e();
    }

    public boolean _h() {
        return !this._k._d();
    }

    public boolean _i() {
        return this._k._d();
    }

    public boolean _j() {
        return this._k._d();
    }

    public boolean _k() {
        return this._a._t.isRiding() && this._a._t.ridingEntity instanceof EntityHorse;
    }
}

