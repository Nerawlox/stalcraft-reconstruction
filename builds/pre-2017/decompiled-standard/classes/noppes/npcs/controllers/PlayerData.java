/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.controllers.PlayerBankData;
import noppes.npcs.controllers.PlayerDialogData;
import noppes.npcs.controllers.PlayerFactionData;
import noppes.npcs.controllers.PlayerItemGiverData;
import noppes.npcs.controllers.PlayerMailData;
import noppes.npcs.controllers.PlayerQuestData;
import noppes.npcs.controllers.PlayerTransportData;

public class PlayerData
extends tehy {
    public static final String CUSTOM_HANDLER_ID = "customnpcs";
    public PlayerDialogData dialogData = new PlayerDialogData();
    public PlayerBankData bankData = new PlayerBankData();
    public PlayerQuestData questData = new PlayerQuestData();
    public PlayerTransportData transportData = new PlayerTransportData();
    public PlayerFactionData factionData = new PlayerFactionData();
    public PlayerItemGiverData itemgiverData = new PlayerItemGiverData();
    public PlayerMailData mailData = new PlayerMailData();
    public int activeQuest = -1;
    public UUID targetNpcUUID = null;
    public Map<UUID, Integer> storedDialogs = new HashMap<UUID, Integer>();
    public UUID currentDialogNpc = null;

    public PlayerData(ccxr ccxr2) {
        super(ccxr2);
        if (!ccxr2._a.field_70170_p.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public void tick() {
        InvokeSideOnly.frontend(!this.player.field_70170_p.field_72995_K, () -> {});
    }

    public void clearStoredDialog(UUID uUID) {
        this.storedDialogs.remove(uUID);
    }

    public static PlayerData getData(ccxr ccxr2) {
        return (PlayerData)ccxr2._h.get(CUSTOM_HANDLER_ID);
    }

    public static PlayerData getData(EntityPlayer entityPlayer) {
        return PlayerData.getData(ncwh._a(entityPlayer));
    }

    public void onQuestStatusUpdate(int n) {
        InvokeSideOnly.frontend(!this.player.field_70170_p.field_72995_K, () -> {});
    }

    public void onDialogStatusUpdate(int n) {
        InvokeSideOnly.frontend(!this.player.field_70170_p.field_72995_K, () -> {});
    }

    public void onFactionUpdate(int n) {
        InvokeSideOnly.frontend(!this.player.field_70170_p.field_72995_K, () -> {});
    }
}

