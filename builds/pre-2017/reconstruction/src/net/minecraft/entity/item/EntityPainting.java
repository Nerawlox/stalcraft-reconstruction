/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ugqi;
import net.minecraft.world.World;

public class EntityPainting
extends EntityHanging {
    public ugqi art;

    public EntityPainting(World world) {
        super(world);
    }

    public EntityPainting(World world, int n, int n2, int n3, int n4) {
        super(world, n, n2, n3, n4);
        ArrayList<ugqi> arrayList = new ArrayList<ugqi>();
        ugqi[] ugqiArray = ugqi.values();
        int n5 = ugqiArray.length;
        for (int i = 0; i < n5; ++i) {
            ugqi ugqi2;
            this.art = ugqi2 = ugqiArray[i];
            this.setDirection(n4);
            if (!this.onValidSurface()) continue;
            arrayList.add(ugqi2);
        }
        if (!arrayList.isEmpty()) {
            this.art = (ugqi)((Object)arrayList.get(this.rand.nextInt(arrayList.size())));
        }
        this.setDirection(n4);
    }

    public EntityPainting(World world, int n, int n2, int n3, int n4, String string) {
        this(world, n, n2, n3, n4);
        for (ugqi ugqi2 : ugqi.values()) {
            if (!ugqi2.__aK.equals(string)) continue;
            this.art = ugqi2;
            break;
        }
        this.setDirection(n4);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Motive", this.art.__aK);
        super.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        String string = nBTTagCompound._j("Motive");
        for (ugqi ugqi2 : ugqi.values()) {
            if (!ugqi2.__aK.equals(string)) continue;
            this.art = ugqi2;
        }
        if (this.art == null) {
            this.art = ugqi._a;
        }
        super.readEntityFromNBT(nBTTagCompound);
    }

    @Override
    public int getWidthPixels() {
        return this.art.__aL;
    }

    @Override
    public int getHeightPixels() {
        return this.art.__aM;
    }

    @Override
    public void onBroken(Entity entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            if (entityPlayer.capabilities._d) {
                return;
            }
        }
        this.entityDropItem(new ItemStack(Item.painting), 0.0f);
    }
}

