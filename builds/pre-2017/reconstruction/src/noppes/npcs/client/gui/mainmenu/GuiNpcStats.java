/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.mainmenu;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.DataStats;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.SubGuiNpcMeleeProperties;
import noppes.npcs.client.gui.SubGuiNpcProjectiles;
import noppes.npcs.client.gui.SubGuiNpcRangeProperties;
import noppes.npcs.client.gui.SubGuiNpcResistanceProperties;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.GuiTimeRangesField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPacketType;

public class GuiNpcStats
extends GuiNPCInterface2
implements IGuiData,
ITextfieldListener {
    DataStats stats;

    public GuiNpcStats(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface, 2);
        this.stats = entityNPCInterface.stats;
        NoppesUtil.sendData(EnumPacketType.MainmenuStatsGet, new Object[0]);
        NoppesUtil.sendData(EnumPacketType.NpcAccess, new Object[0]);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addLabel(new GuiNpcLabel(0, "stats.health", this.guiLeft + 5, this.guiTop + 15, 0x404040));
        this.addTextField(new GuiNpcTextField(0, this, this.fontRenderer, this.guiLeft + 85, this.guiTop + 10, 50, 18, this.stats.maxHealth + ""));
        this.getTextField((int)0).numbersOnly = true;
        this.getTextField(0).setMinMaxDefault(1, Short.MAX_VALUE, 20);
        this.addLabel(new GuiNpcLabel(1, "stats.aggro", this.guiLeft + 140, this.guiTop + 15, 0x404040));
        this.addTextField(new GuiNpcTextField(1, this, this.fontRenderer, this.guiLeft + 220, this.guiTop + 10, 50, 18, this.stats.aggroRange + ""));
        this.getTextField((int)1).numbersOnly = true;
        this.getTextField(1).setMinMaxDefault(1, 64, 2);
        this.addLabel(new GuiNpcLabel(34, "stats.creaturetype", this.guiLeft + 275, this.guiTop + 15, 0x404040));
        this.addButton(new GuiNpcButton(8, this.guiLeft + 355, this.guiTop + 10, 56, 20, new String[]{"stats.normal", "stats.undead", "stats.arthropod"}, this.stats.creatureType.ordinal()));
        this.addLabel(new GuiNpcLabel(2, "stats.respawn", this.guiLeft + 5, this.guiTop + 35, 0x404040));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 82, this.guiTop + 30, 56, 20, new String[]{"gui.yes", "gui.no"}, this.stats.spawnCycle));
        if (this.stats.respawnTime > 0) {
            this.addLabel(new GuiNpcLabel(3, "\u0414\u043b\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c", this.guiLeft + 140, this.guiTop + 35, 0x404040));
            this.addTextField(new GuiNpcTextField(2, this, this.fontRenderer, this.guiLeft + 220, this.guiTop + 30, 50, 18, this.stats.respawnTime + ""));
            this.getTextField((int)2).numbersOnly = true;
            this.getTextField(2).setMinMaxDefault(1, 99999, 20);
            this.addLabel(new GuiNpcLabel(100, "\u0412\u0440\u0435\u043c\u044f", this.guiLeft + 275, this.guiTop + 60, 0x404040));
            this.addTextField(new GuiTimeRangesField(4, (GuiScreen)this, this.fontRenderer, this.guiLeft + 340, this.guiTop + 55, 70, 20, this.stats.spawnTimeRanges));
        }
        this.addLabel(new GuiNpcLabel(5, "stats.meleeproperties", this.guiLeft + 5, this.guiTop + 65, 0x404040));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 82, this.guiTop + 60, 56, 20, "selectServer.edit"));
        this.addLabel(new GuiNpcLabel(6, "stats.rangedproperties", this.guiLeft + 5, this.guiTop + 89, 0x404040));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 82, this.guiTop + 84, 56, 20, "selectServer.edit"));
        this.addLabel(new GuiNpcLabel(7, "stats.projectileproperties", this.guiLeft + 140, this.guiTop + 89, 0x404040));
        this.addButton(new GuiNpcButton(9, this.guiLeft + 217, this.guiTop + 84, 56, 20, "selectServer.edit"));
        this.addLabel(new GuiNpcLabel(15, "potion.resistance", this.guiLeft + 5, this.guiTop + 113, 0x404040));
        this.addButton(new GuiNpcButton(15, this.guiLeft + 82, this.guiTop + 108, 56, 20, "selectServer.edit"));
        this.addLabel(new GuiNpcLabel(8, "stats.walkspeed", this.guiLeft + 5, this.guiTop + 141, 0x404040));
        this.addTextField(new GuiNpcTextField(3, this, this.fontRenderer, this.guiLeft + 85, this.guiTop + 136, 50, 18, this.stats.moveSpeed + ""));
        this.getTextField((int)3).numbersOnly = true;
        this.getTextField(3).setMinMaxDefault(0, 10, 4);
        this.addLabel(new GuiNpcLabel(10, "stats.fireimmune", this.guiLeft + 5, this.guiTop + 163, 0x404040));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 82, this.guiTop + 158, 56, 20, new String[]{"gui.no", "gui.yes"}, this.npc.isImmuneToFire() ? 1 : 0));
        this.addLabel(new GuiNpcLabel(12, "stats.burninsun", this.guiLeft + 5, this.guiTop + 185, 0x404040));
        this.addButton(new GuiNpcButton(6, this.guiLeft + 82, this.guiTop + 180, 56, 20, new String[]{"gui.no", "gui.yes"}, this.stats.burnInSun ? 1 : 0));
        this.addLabel(new GuiNpcLabel(11, "stats.candrown", this.guiLeft + 140, this.guiTop + 143, 0x404040));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 217, this.guiTop + 138, 56, 20, new String[]{"gui.no", "gui.yes"}, this.stats.canDrown ? 1 : 0));
        this.addButton(new GuiNpcButton(14, this.guiLeft + 355, this.guiTop + 138, 56, 20, new String[]{"gui.no", "gui.yes"}, this.stats.healthRegen ? 1 : 0));
        this.addLabel(new GuiNpcLabel(14, "stats.regenhealth", this.guiLeft + 275, this.guiTop + 143, 0x404040));
        this.addLabel(new GuiNpcLabel(13, "stats.nofalldamage", this.guiLeft + 140, this.guiTop + 165, 0x404040));
        this.addButton(new GuiNpcButton(7, this.guiLeft + 217, this.guiTop + 160, 56, 20, new String[]{"gui.no", "gui.yes"}, this.stats.noFallDamage ? 1 : 0));
        this.addLabel(new GuiNpcLabel(117, "\u041d\u0435\u043f\u0440\u043e\u0445\u043e\u0434\u0438\u043c\u043e\u0441\u0442\u044c", this.guiLeft + 275, this.guiTop + 165, 0x404040));
        this.addButton(new GuiNpcButton(100, this.guiLeft + 355, this.guiTop + 160, 56, 20, new String[]{"gui.no", "gui.yes"}, this.stats.collidable ? 1 : 0));
        this.addLabel(new GuiNpcLabel(16, "\u0421\u0431\u0440\u0430\u0441\u044b\u0432\u0430\u043d\u0438\u0435 \u0438\u0433\u0440\u043e\u043a\u043e\u0432", this.guiLeft + 275, this.guiTop + 185, 0x404040));
        this.addButton(new GuiNpcButton(101, this.guiLeft + 355, this.guiTop + 183, 56, 20, new String[]{"gui.no", "gui.yes"}, this.stats.playersThrowOff ? 1 : 0));
        if (!this.npcAccess) {
            this.disableAll(null);
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 0) {
            this.stats.maxHealth = guiNpcTextField.getInteger();
            this.npc.heal(this.stats.maxHealth);
        } else if (guiNpcTextField.id == 1) {
            this.stats.aggroRange = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 2) {
            this.stats.respawnTime = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 3) {
            this.stats.moveSpeed = guiNpcTextField.getInteger();
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)guiButton;
        if (guiNpcButton.id == 0) {
            this.stats.spawnCycle = guiNpcButton.getValue();
            this.stats.respawnTime = this.stats.spawnCycle == 1 ? 0 : 20;
            this.initGui();
        } else if (guiNpcButton.id == 2) {
            this.setSubGui(new SubGuiNpcMeleeProperties(this.stats));
        } else if (guiNpcButton.id == 3) {
            this.setSubGui(new SubGuiNpcRangeProperties(this.stats));
        } else if (guiNpcButton.id == 4) {
            this.npc.setImmuneToFire(guiNpcButton.getValue() == 1);
        } else if (guiNpcButton.id == 5) {
            this.stats.canDrown = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.id == 6) {
            this.stats.burnInSun = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.id == 7) {
            this.stats.noFallDamage = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.id == 8) {
            this.stats.creatureType = EnumCreatureAttribute.values()[guiNpcButton.getValue()];
        } else if (guiNpcButton.id == 9) {
            this.setSubGui(new SubGuiNpcProjectiles(this.stats));
        } else if (guiNpcButton.id == 14) {
            this.stats.healthRegen = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.id == 15) {
            this.setSubGui(new SubGuiNpcResistanceProperties(this.stats.resistances));
        } else if (guiNpcButton.id == 100) {
            this.stats.collidable = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.id == 101) {
            this.stats.playersThrowOff = guiNpcButton.getValue() == 1;
        }
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuStatsSave, this.stats.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("NpcAccess")) {
            this.npcAccess = nBTTagCompound._o("NpcAccess");
        } else {
            this.stats.readToNBT(nBTTagCompound);
        }
        this.initGui();
    }
}

