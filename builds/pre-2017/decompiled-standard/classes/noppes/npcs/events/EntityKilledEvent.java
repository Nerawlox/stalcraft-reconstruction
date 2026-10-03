/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.events;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import java.lang.invoke.LambdaMetafactory;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import noppes.npcs.CustomItems;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumQuestType;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerQuestData;
import noppes.npcs.controllers.QuestData;
import noppes.npcs.items.ItemExcalibur;
import noppes.npcs.quests.QuestKill;

public class EntityKilledEvent {
    private static final double PARTY_KILL_RADIUS = 200.0;

    @ForgeSubscribe
    public void invoke(LivingDeathEvent livingDeathEvent) {
        if (!livingDeathEvent.entityLiving.field_70170_p.field_72995_K) {
            this.entityDied(livingDeathEvent.entityLiving, livingDeathEvent);
        }
    }

    private void entityDied(EntityLivingBase entityLivingBase, LivingDeathEvent livingDeathEvent) {
        if (livingDeathEvent.source.func_76346_g() != null && livingDeathEvent.source.func_76346_g() instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)livingDeathEvent.source.func_76346_g();
            this.doExcalibur(entityPlayer, entityLivingBase);
            if (!this.doQuestParty(entityPlayer, entityLivingBase)) {
                this.doQuest(entityPlayer, entityLivingBase);
            }
            if (entityLivingBase instanceof EntityNPCInterface) {
                this.doFactionPoints(entityPlayer, (EntityNPCInterface)entityLivingBase);
            }
        }
    }

    private boolean doQuestParty(EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        ofgy ofgy2 = cceu._a._a(entityPlayer.func_70005_c_());
        if (ofgy2 != null && !ofgy2._c().isEmpty()) {
            ofgy2._c().stream().map((Function<String, EntityPlayerMP>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, getPlayer(java.lang.String ), (Ljava/lang/String;)Lnet/minecraft/entity/player/EntityPlayerMP;)()).filter(Objects::nonNull).filter(entityPlayerMP -> (double)entityPlayer.func_70032_d((Entity)entityPlayerMP) <= 200.0).forEach(entityPlayerMP -> this.doQuest((EntityPlayer)entityPlayerMP, entityLivingBase));
            return true;
        }
        return false;
    }

    private void doExcalibur(EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        cvzo cvzo2 = entityPlayer.func_71045_bC();
        if (cvzo2 != null && cvzo2._a() == CustomItems.excalibur) {
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.PlayMusic, "Failboat103 - Excalibuuur");
            entityPlayer.func_71035_c("<" + cvzo2._a().func_77635_s() + "> " + ItemExcalibur.quotes[entityPlayer.func_70681_au().nextInt(ItemExcalibur.quotes.length)]);
        }
    }

    private void doFactionPoints(EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface) {
        entityNPCInterface.advanced.factions.addPoints(entityPlayer);
        entityNPCInterface.advanced.addReputation(entityPlayer);
    }

    private void doQuest(EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        PlayerData playerData = PlayerDataController.instance.getPlayerData(entityPlayer);
        PlayerQuestData playerQuestData = playerData.questData;
        boolean bl = false;
        String string = jgro._b(entityLivingBase);
        for (QuestData questData : playerQuestData.activeQuests.values()) {
            HashMap hashMap;
            int n;
            if (questData.quest.type != EnumQuestType.Kill) continue;
            QuestKill questKill = (QuestKill)questData.quest.questInterface;
            HashMap hashMap2 = questKill.targets;
            String string2 = entityLivingBase.func_70023_ak();
            boolean bl2 = hashMap2.containsKey(string2);
            if (entityLivingBase instanceof EntityMutant && !bl2) {
                string2 = ((EntityMutant)entityLivingBase).getProperties().getCommon().getQuestid();
                bl2 = hashMap2.containsKey(string2);
            }
            if (!bl2 || (n = Optional.ofNullable((hashMap = questKill.getKilled(questData)).get(string2)).orElse(0).intValue()) >= (Integer)hashMap2.get(string2)) continue;
            hashMap.put(string2, n + 1);
            questKill.setKilled(questData, hashMap);
            bl = true;
        }
        if (bl) {
            playerQuestData.checkQuestCompletion(entityPlayer, EnumQuestType.Kill);
            InvokeSideOnly.frontend(!entityPlayer.field_70170_p.field_72995_K, () -> {});
        }
    }
}

