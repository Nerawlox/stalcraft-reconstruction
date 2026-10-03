/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.availability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.constants.EnumAvailabilityDialog;
import noppes.npcs.constants.EnumAvailabilityFaction;
import noppes.npcs.constants.EnumAvailabilityFactionType;
import noppes.npcs.constants.EnumAvailabilityQuest;
import noppes.npcs.controllers.availability.DialogRule;
import noppes.npcs.controllers.availability.FactionPointsRule;
import noppes.npcs.controllers.availability.FactionRule;
import noppes.npcs.controllers.availability.QuestRule;
import noppes.npcs.controllers.availability.TradepackRule;

public abstract class AvailabilityRule {
    protected final RuleType type;

    protected AvailabilityRule(RuleType ruleType) {
        this.type = ruleType;
    }

    public RuleType getType() {
        return this.type;
    }

    public abstract boolean available(EntityPlayer var1);

    public abstract void save(NBTTagCompound var1);

    public abstract void load(NBTTagCompound var1);

    public static enum RuleType {
        DIALOG{

            @Override
            public AvailabilityRule createDefault() {
                return new DialogRule(EnumAvailabilityDialog.Always, -1);
            }
        }
        ,
        QUEST{

            @Override
            public AvailabilityRule createDefault() {
                return new QuestRule(EnumAvailabilityQuest.Always, -1);
            }
        }
        ,
        FACTION{

            @Override
            public AvailabilityRule createDefault() {
                return new FactionRule(EnumAvailabilityFaction.Neutral, EnumAvailabilityFactionType.Always, -1);
            }
        }
        ,
        FACTION_POINTS{

            @Override
            public AvailabilityRule createDefault() {
                return new FactionPointsRule(FactionPointsRule.Comparison.EQUALS, 0, -1);
            }
        }
        ,
        TRADEPACK_CHECK{

            @Override
            public AvailabilityRule createDefault() {
                return new TradepackRule(false);
            }
        };


        public abstract AvailabilityRule createDefault();
    }
}

