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
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatMessageComponent;
import noppes.npcs.EntityNPCInterface;

public class CommandSlay
extends CommandBase {
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
    public String getCommandName() {
        return "slay";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/slay all, /slay mobs, /slay animals, /slay <entityname>";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (!(iCommandSender instanceof EntityPlayer)) {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._d("Can only be used by players"));
        } else if (stringArray.length == 0) {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._d("No entities given"));
        } else {
            Entity entity;
            Object object;
            Object object2;
            int n;
            EntityPlayer entityPlayer = (EntityPlayer)iCommandSender;
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
            object2 = entityPlayer.boundingBox._b(120.0, 120.0, 120.0);
            object = entityPlayer.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, (AxisAlignedBB)object2);
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                entity = (Entity)iterator2.next();
                if (entity instanceof EntityPlayer || entity instanceof EntityTameable && ((EntityTameable)entity).isTamed() || entity instanceof EntityNPCInterface || !this.delete(entity, arrayList)) continue;
                ++n;
            }
            if (arrayList.contains(EntityXPOrb.class)) {
                object = entityPlayer.worldObj.getEntitiesWithinAABB(EntityXPOrb.class, (AxisAlignedBB)object2);
                iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    entity = (Entity)iterator2.next();
                    entity.isDead = true;
                    ++n;
                }
            }
            if (arrayList.contains(EntityItem.class)) {
                object = entityPlayer.worldObj.getEntitiesWithinAABB(EntityItem.class, (AxisAlignedBB)object2);
                iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    entity = (Entity)iterator2.next();
                    entity.isDead = true;
                    ++n;
                }
            }
            iCommandSender.sendChatToPlayer(ChatMessageComponent._d(n + " entities deleted"));
        }
    }

    private boolean delete(Entity entity, ArrayList arrayList) {
        Class clazz;
        Iterator iterator2 = arrayList.iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while ((clazz = (Class)iterator2.next()) == EntityAnimal.class && entity instanceof EntityHorse || !clazz.isAssignableFrom(entity.getClass()));
        entity.isDead = true;
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        ArrayList arrayList = new ArrayList(this.map.keySet());
        Collections.sort(arrayList);
        return CommandSlay.getListOfStringsFromIterableMatchingLastWord(stringArray, arrayList);
    }
}

