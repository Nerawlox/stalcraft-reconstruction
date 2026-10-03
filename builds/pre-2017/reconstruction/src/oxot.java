/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.mods.stalker.clans.zwat;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.weapon.ugqx;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import noppes.npcs.DataInventory;
import noppes.npcs.EntityNPCInterface;

public class oxot
extends qlgf {
    public float _a;
    public int _b;

    public oxot() {
    }

    public oxot(float f) {
        this._a = f;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this._a);
        dataOutput.writeInt(this._b);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readFloat();
        this._b = dataInput.readInt();
    }

    public float _a() {
        return this._a;
    }

    public boolean _b() {
        return false;
    }

    public static oxot _a(EntityLivingBase entityLivingBase, boolean bl) {
        if (entityLivingBase instanceof EntityPlayer) {
            return oxot._a((EntityPlayer)entityLivingBase, bl);
        }
        if (zgpv._a(entityLivingBase)) {
            return oxot._a((EntityNPCInterface)entityLivingBase);
        }
        if (entityLivingBase instanceof EntityMutant) {
            return oxot._a((EntityMutant)entityLivingBase);
        }
        return new uzai(entityLivingBase);
    }

    public static zgmg _a(EntityMutant entityMutant) {
        String string = entityMutant.getSkin().getSkinName();
        String string2 = entityMutant.getProperties().getCommon().getName();
        float f = entityMutant.getHealth() / entityMutant.getMaxHealth();
        return new zgmg(string2, string, f);
    }

    public static oxoq _a(EntityNPCInterface entityNPCInterface) {
        DataInventory dataInventory = entityNPCInterface.inventory;
        ItemStack itemStack = dataInventory.getFirearm();
        ItemStack itemStack2 = (ItemStack)dataInventory.getArmor().get(1);
        float f = entityNPCInterface.getHealth() / entityNPCInterface.getMaxHealth();
        return new oxoq("", entityNPCInterface.display.name, itemStack2, null, f, itemStack);
    }

    public static oxoq _a(EntityPlayer entityPlayer, boolean bl) {
        Object object;
        InventoryPlayer inventoryPlayer = entityPlayer.inventory;
        ItemStack itemStack = inventoryPlayer._a();
        ItemStack itemStack2 = itemStack != null && itemStack._a() instanceof wolf ? itemStack : (((ugqx)(object = ugqx._a(entityPlayer)))._j() != null ? ((ugqx)object)._j() : ((ugqx)object)._i());
        object = inventoryPlayer._b[2];
        ItemStack itemStack3 = bl ? tupg._a((EntityPlayer)entityPlayer)._c._e() : null;
        float f = entityPlayer.getHealth() / entityPlayer.getMaxHealth();
        String string = zwat._b((EntityPlayer)entityPlayer)._c._b();
        if (string == null) {
            string = "";
        }
        return new oxoq(string, entityPlayer.username, (ItemStack)object, itemStack3, f, itemStack2);
    }
}

