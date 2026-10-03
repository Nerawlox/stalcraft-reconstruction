/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import noppes.npcs.controllers.Bank;
import noppes.npcs.controllers.BankController;
import noppes.npcs.controllers.PlayerBankData;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerMail;
import org.apache.commons.lang3.RandomStringUtils;

public class PlayerDataController {
    private static final String id = RandomStringUtils.random(12, true, true);
    public static PlayerDataController instance;

    public PlayerDataController() {
        instance = this;
    }

    public PlayerBankData getBankData(EntityPlayer entityPlayer, int n) {
        Bank bank = BankController.getInstance().getBank(n);
        PlayerBankData playerBankData = this.getPlayerData((EntityPlayer)entityPlayer).bankData;
        if (!playerBankData.hasBank(bank.id)) {
            playerBankData.loadNew(bank.id);
        }
        return playerBankData;
    }

    public PlayerData getPlayerData(EntityPlayer entityPlayer) {
        return PlayerData.getData(entityPlayer);
    }

    public void addPlayerMessage(String string, PlayerMail playerMail) {
        playerMail.time = System.currentTimeMillis();
        EntityPlayerMP entityPlayerMP = dzfd._I().__ag()._h(string);
        if (entityPlayerMP != null) {
            PlayerData playerData = this.getPlayerData(entityPlayerMP);
            playerData.mailData.playermail.add(playerMail);
        }
    }

    public boolean hasMail(EntityPlayer entityPlayer) {
        return this.getPlayerData((EntityPlayer)entityPlayer).mailData.hasMail();
    }
}

