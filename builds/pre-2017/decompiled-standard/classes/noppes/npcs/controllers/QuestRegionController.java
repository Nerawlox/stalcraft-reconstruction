/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import com.google.gson.JsonElement;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import mods.regions.Region;
import mods.regions.RegionFlag;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.controllers.Availability;

public class QuestRegionController {
    public static RegionFlag.FlagAdapter<Availability> availabilityAd = new RegionFlag.FlagAdapter<Availability>(){

        @Override
        public Availability fromJson(JsonElement jsonElement) {
            Availability availability = new Availability();
            availability.readFromNBT(ezob._a.fromJson(jsonElement, qoac.class));
            return availability;
        }

        @Override
        public JsonElement toJson(Availability availability) {
            return ezob._a.toJsonTree(availability.writeToNBT(new qoac()));
        }
    };
    public static RegionFlag regionQuestId = new RegionFlag("quest", RegionFlag.integerAd, false, new String[0]);
    public static RegionFlag availabilityFlag = new RegionFlag("quest_availability", availabilityAd, false, new String[0]);
    public static final QuestRegionController instance = new QuestRegionController();

    public void setup() {
        Region.registerFlag(regionQuestId).setOnUpdate((region, entityPlayer, object) -> this.onQuestUpdate(region, entityPlayer, (Integer)object));
        Region.registerFlag(availabilityFlag);
    }

    public void onQuestUpdate(Region region, EntityPlayer entityPlayer, int n) {
        InvokeSideOnly.frontend(!entityPlayer.field_70170_p.field_72995_K, () -> {});
    }
}

