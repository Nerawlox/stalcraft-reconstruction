/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.jgro;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.zwat;
import noppes.npcs.EntityNPCInterface;

public class CommandSlay
extends ohnk {
    private Map map = new HashMap();

    public CommandSlay() {
        HashMap hashMap = new HashMap(jgro._a);
        for (String string : hashMap.keySet()) {
            Class clazz = (Class)hashMap.get(string);
            if (EntityNPCInterface.class.isAssignableFrom(clazz) || !EntityLivingBase.class.isAssignableFrom(clazz)) continue;
            this.map.put(string.toLowerCase(), hashMap.get(string));
        }
        this.map.remove("monster");
        this.map.remove("mob");
        this.map.put("all", EntityLivingBase.class);
        this.map.put("mobs", EntityMob.class);
        this.map.put("animals", EntityAnimal.class);
        this.map.put("items", EntityItem.class);
        this.map.put("xporbs", EntityXPOrb.class);
    }

    @Override
    public String func_71517_b() {
        return "slay";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "/slay all, /slay mobs, /slay animals, /slay <entityname>";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (!(nemo2 instanceof EntityPlayer)) {
            nemo2.func_70006_a(zwat._d("Can only be used by players"));
        } else if (stringArray.length == 0) {
            nemo2.func_70006_a(zwat._d("No entities given"));
        } else {
            Entity entity;
            Object object;
            Object object2;
            int n;
            EntityPlayer entityPlayer = (EntityPlayer)nemo2;
            ArrayList<Class> arrayList = new ArrayList<Class>();
            String[] stringArray2 = stringArray;
            int n2 = stringArray.length;
            for (n = 0; n < n2; ++n) {
                object2 = stringArray2[n];
                object = (Class)this.map.get(((String)object2).toLowerCase());
                if (object != null) {
                    arrayList.add((Class)object);
                }
                if (!((String)object2).equals("mobs")) continue;
                arrayList.add(EntityGhast.class);
                arrayList.add(EntityDragon.class);
            }
            n = 0;
            object2 = entityPlayer.field_70121_D._b(120.0, 120.0, 120.0);
            object = entityPlayer.field_70170_p.func_72872_a(EntityLivingBase.class, (eidj)object2);
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                entity = (Entity)iterator2.next();
                if (entity instanceof EntityPlayer || entity instanceof EntityTameable && ((EntityTameable)entity).func_70909_n() || entity instanceof EntityNPCInterface || !this.delete(entity, arrayList)) continue;
                ++n;
            }
            if (arrayList.contains(EntityXPOrb.class)) {
                object = entityPlayer.field_70170_p.func_72872_a(EntityXPOrb.class, (eidj)object2);
                iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    entity = (Entity)iterator2.next();
                    entity.field_70128_L = true;
                    ++n;
                }
            }
            if (arrayList.contains(EntityItem.class)) {
                object = entityPlayer.field_70170_p.func_72872_a(EntityItem.class, (eidj)object2);
                iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    entity = (Entity)iterator2.next();
                    entity.field_70128_L = true;
                    ++n;
                }
            }
            nemo2.func_70006_a(zwat._d(n + " entities deleted"));
        }
    }

    private boolean delete(Entity entity, ArrayList arrayList) {
        Class clazz;
        Iterator iterator2 = arrayList.iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while ((clazz = (Class)iterator2.next()) == EntityAnimal.class && entity instanceof EntityHorse || !clazz.isAssignableFrom(entity.getClass()));
        entity.field_70128_L = true;
        return true;
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        ArrayList arrayList = new ArrayList(this.map.keySet());
        Collections.sort(arrayList);
        return CommandSlay.func_71531_a(stringArray, arrayList);
    }
}

