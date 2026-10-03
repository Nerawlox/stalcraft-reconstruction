/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.availability;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerFactionData;
import noppes.npcs.controllers.availability.AvailabilityRule;
import noppes.npcs.controllers.availability.EnumRule;

public class FactionPointsRule
extends EnumRule<Comparison> {
    private int points;

    public FactionPointsRule(Comparison comparison, int n, int n2) {
        super(AvailabilityRule.RuleType.FACTION_POINTS);
        this.setEnum(comparison);
        this.setId(n);
        this.points = n2;
    }

    public int getPoints() {
        return this.points;
    }

    public FactionPointsRule setPoints(int n) {
        this.points = n;
        return this;
    }

    @Override
    public boolean available(EntityPlayer entityPlayer) {
        PlayerFactionData playerFactionData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).factionData;
        int n = playerFactionData.getFactionPoints(this.id);
        switch ((Comparison)((Object)this.getEnum())) {
            case EQUALS: {
                return n == this.points;
            }
            case LESS: {
                return n < this.points;
            }
            case GREATER: {
                return n > this.points;
            }
            case GREATER_EQ: {
                return n >= this.points;
            }
            case LESS_EQ: {
                return n <= this.points;
            }
        }
        return false;
    }

    @Override
    public void save(qoac qoac2) {
        super.save(qoac2);
        qoac2._a("points", this.points);
    }

    @Override
    public void load(qoac qoac2) {
        super.load(qoac2);
        this.points = qoac2._f("points");
    }

    Comparison[] getEnumValues() {
        return Comparison.values();
    }

    public static enum Comparison {
        EQUALS("="),
        LESS("<"),
        GREATER(">"),
        LESS_EQ("<="),
        GREATER_EQ(">=");

        public final String symbol;

        private Comparison(String string2) {
            this.symbol = string2;
        }
    }
}

