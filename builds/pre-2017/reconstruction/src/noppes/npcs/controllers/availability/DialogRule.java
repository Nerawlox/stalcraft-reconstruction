/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.availability;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.constants.EnumAvailabilityDialog;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.availability.AvailabilityRule;
import noppes.npcs.controllers.availability.EnumRule;

public class DialogRule
extends EnumRule<EnumAvailabilityDialog> {
    public DialogRule(EnumAvailabilityDialog enumAvailabilityDialog, int n) {
        super(AvailabilityRule.RuleType.DIALOG);
        this.setEnum(enumAvailabilityDialog);
        this.setId(n);
    }

    @Override
    public boolean available(EntityPlayer entityPlayer) {
        EnumAvailabilityDialog enumAvailabilityDialog = (EnumAvailabilityDialog)((Object)this.getEnum());
        if (enumAvailabilityDialog == EnumAvailabilityDialog.Always) {
            return true;
        }
        boolean bl = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).dialogData.dialogsRead.contains(this.getId());
        return enumAvailabilityDialog == EnumAvailabilityDialog.After && bl || enumAvailabilityDialog == EnumAvailabilityDialog.Before && !bl;
    }

    EnumAvailabilityDialog[] getEnumValues() {
        return EnumAvailabilityDialog.values();
    }
}

