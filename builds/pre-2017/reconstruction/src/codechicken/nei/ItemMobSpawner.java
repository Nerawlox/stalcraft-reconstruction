/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.api.API;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.jgro;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemMobSpawner
extends ItemBlock {
    private static Map<Integer, EntityLiving> entityHashMap;
    private static Map<Integer, String> IDtoNameMap;
    public static int idPig;
    private static boolean loaded;
    public static int placedX;
    public static int placedY;
    public static int placedZ;

    public ItemMobSpawner(World world) {
        super(Block.mobSpawner.blockID - 256);
        Item.itemsList[this.itemID] = this;
        this.hasSubtypes = true;
        entityHashMap = new HashMap<Integer, EntityLiving>();
        IDtoNameMap = new HashMap<Integer, String>();
        ItemMobSpawner.loadSpawners(world);
    }

    @Override
    public Icon getIconFromDamage(int n) {
        return Block.mobSpawner.getBlockTextureFromSide(0);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (super.onItemUse(itemStack, entityPlayer, world, n, n2, n3, n4, f, f2, f3) && world.isRemote) {
            xtcq xtcq2 = (xtcq)world.getBlockTileEntity(placedX, placedY, placedZ);
            if (xtcq2 != null) {
                this.setDefaultTag(itemStack);
                String string = IDtoNameMap.get(itemStack._j());
                if (string != null) {
                    NEICPH.sendMobSpawnerID(placedX, placedY, placedZ, string);
                    xtcq2._a()._a(string);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list2, boolean bl) {
        EntityLiving entityLiving;
        this.setDefaultTag(itemStack);
        int n = itemStack._j();
        if (n == 0) {
            n = idPig;
        }
        if ((entityLiving = ItemMobSpawner.getEntity(n)) == null) {
            return;
        }
        list2.add("\u00a7" + (entityLiving instanceof ezey ? "4" : "3") + IDtoNameMap.get(n));
    }

    public static EntityLiving getEntity(int n) {
        EntityLiving entityLiving = entityHashMap.get(n);
        if (entityLiving == null) {
            pkix pkix2 = NEIClientUtils.mc()._r;
            ItemMobSpawner.loadSpawners(pkix2);
            try {
                Class clazz = (Class)jgro._c.get(n);
                if (clazz != null && EntityLiving.class.isAssignableFrom(clazz)) {
                    entityLiving = (EntityLiving)clazz.getConstructor(World.class).newInstance(pkix2);
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            entityHashMap.put(n, entityLiving);
        }
        return entityLiving;
    }

    private void setDefaultTag(ItemStack itemStack) {
        if (!IDtoNameMap.containsKey(itemStack._j())) {
            itemStack._b(idPig);
        }
    }

    public static void loadSpawners(World world) {
        if (loaded) {
            return;
        }
        loaded = true;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        try {
            HashMap hashMap = (HashMap)jgro._b;
            HashMap hashMap2 = (HashMap)jgro._d;
            for (Class clazz : hashMap.keySet()) {
                if (!EntityLiving.class.isAssignableFrom(clazz)) continue;
                try {
                    EntityLiving entityLiving = (EntityLiving)clazz.getConstructor(World.class).newInstance(world);
                    entityLiving.isChild();
                    int n = (Integer)hashMap2.get(clazz);
                    String string = (String)hashMap.get(clazz);
                    if (string.equals("EnderDragon")) continue;
                    IDtoNameMap.put(n, string);
                    arrayList.add(n);
                    if (!string.equals("Pig")) continue;
                    idPig = n;
                }
                catch (Throwable throwable) {}
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        API.setItemDamageVariants(Block.mobSpawner.blockID, arrayList);
    }
}

