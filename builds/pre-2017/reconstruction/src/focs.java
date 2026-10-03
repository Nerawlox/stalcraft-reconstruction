/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class focs
extends Item {
    public Block[] _b;
    public float _c = 4.0f;
    public float _d;
    public txfz _e;

    public focs(int n, float f, txfz txfz2, Block[] blockArray) {
        super(n);
        this._e = txfz2;
        this._b = blockArray;
        this.maxStackSize = 1;
        this.setMaxDamage(txfz2._a());
        this._c = txfz2._b();
        this._d = f + txfz2._c();
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public float getStrVsBlock(ItemStack itemStack, Block block) {
        for (int i = 0; i < this._b.length; ++i) {
            if (this._b[i] != block) continue;
            return this._c;
        }
        return 1.0f;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        itemStack._a(2, entityLivingBase2);
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, int n, int n2, int n3, int n4, EntityLivingBase entityLivingBase) {
        if ((double)Block.blocksList[n].getBlockHardness(world, n2, n3, n4) != 0.0) {
            itemStack._a(1, entityLivingBase);
        }
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    public int getItemEnchantability() {
        return this._e._e();
    }

    public String _a() {
        return this._e.toString();
    }

    @Override
    public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStack2) {
        return this._e._f() == itemStack2._d ? true : super.getIsRepairable(itemStack, itemStack2);
    }

    @Override
    public Multimap getItemAttributeModifiers() {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(sajz._e._a(), new AttributeModifier(field_111210_e, "Tool modifier", this._d, 0));
        return multimap;
    }

    @Override
    public float getStrVsBlock(ItemStack itemStack, Block block, int n) {
        if (ForgeHooks.isToolEffective(itemStack, block, n)) {
            return this._c;
        }
        return this.getStrVsBlock(itemStack, block);
    }
}

