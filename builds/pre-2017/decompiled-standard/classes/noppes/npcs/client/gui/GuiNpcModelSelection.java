/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.HashMap;
import java.util.Vector;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNPCStringSlot;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.constants.EnumModelType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.entity.EntityNPCDwarfFemale;
import noppes.npcs.entity.EntityNPCDwarfMale;
import noppes.npcs.entity.EntityNPCElfFemale;
import noppes.npcs.entity.EntityNPCElfMale;
import noppes.npcs.entity.EntityNPCEnderman;
import noppes.npcs.entity.EntityNPCFurryFemale;
import noppes.npcs.entity.EntityNPCFurryMale;
import noppes.npcs.entity.EntityNPCGolem;
import noppes.npcs.entity.EntityNPCHumanFemale;
import noppes.npcs.entity.EntityNPCHumanMale;
import noppes.npcs.entity.EntityNPCOrcFemale;
import noppes.npcs.entity.EntityNPCOrcMale;
import noppes.npcs.entity.EntityNPCPony;
import noppes.npcs.entity.EntityNPCVillager;
import noppes.npcs.entity.EntityNpcCrystal;
import noppes.npcs.entity.EntityNpcDragon;
import noppes.npcs.entity.EntityNpcEnderchibi;
import noppes.npcs.entity.EntityNpcMonsterFemale;
import noppes.npcs.entity.EntityNpcMonsterMale;
import noppes.npcs.entity.EntityNpcNagaFemale;
import noppes.npcs.entity.EntityNpcNagaMale;
import noppes.npcs.entity.EntityNpcSkeleton;
import noppes.npcs.entity.EntityNpcSlime;

public class GuiNpcModelSelection
extends GuiNPCInterface {
    private GuiNPCStringSlot slot;
    private GuiNPCInterface2 parent;
    private HashMap data = new HashMap();

    public GuiNpcModelSelection(EntityNPCInterface entityNPCInterface, GuiNPCInterface2 guiNPCInterface2) {
        super(entityNPCInterface);
        this.drawDefaultBackground = false;
        this.title = "Select Npc Model";
        this.parent = guiNPCInterface2;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        Vector<String> vector = new Vector<String>();
        for (EnumModelType enumModelType : EnumModelType.values()) {
            vector.add(enumModelType.name);
            this.data.put(enumModelType.name, enumModelType);
        }
        this.slot = new GuiNPCStringSlot(vector, this, this.npc, false, 18);
        this.slot.func_77220_a(4, 5);
        this.slot.selected = this.npc.display.modelType.name;
        this.addButton(2, new GuiNpcButton(2, this.field_73880_f / 2 - 100, this.field_73881_g - 41, 98, 20, "gui.back"));
        this.addButton(4, new GuiNpcButton(4, this.field_73880_f / 2 + 2, this.field_73881_g - 41, 98, 20, "mco.template.button.select"));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.slot.func_77211_a(n, n2, f);
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 2) {
            NoppesUtil.openGUI(this.player, this.parent);
        }
        if (jiok2.field_73741_f == 4) {
            this.close();
        }
    }

    @Override
    public void doubleClicked() {
        this.close();
    }

    @Override
    public void save() {
        if (this.npc.display.modelType != this.data.get(this.slot.selected)) {
            this.npc.display.modelType = (EnumModelType)((Object)this.data.get(this.slot.selected));
            EntityNPCInterface entityNPCInterface = null;
            if (this.npc.display.modelType == EnumModelType.HumanMale) {
                entityNPCInterface = new EntityNPCHumanMale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.Villager) {
                entityNPCInterface = new EntityNPCVillager(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.Pony) {
                entityNPCInterface = new EntityNPCPony(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.HumanFemale) {
                entityNPCInterface = new EntityNPCHumanFemale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.DwarfMale) {
                entityNPCInterface = new EntityNPCDwarfMale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.FurryMale) {
                entityNPCInterface = new EntityNPCFurryMale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.MonsterMale) {
                entityNPCInterface = new EntityNpcMonsterMale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.MonsterFemale) {
                entityNPCInterface = new EntityNpcMonsterFemale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.Skeleton) {
                entityNPCInterface = new EntityNpcSkeleton(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.DwarfFemale) {
                entityNPCInterface = new EntityNPCDwarfFemale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.FurryFemale) {
                entityNPCInterface = new EntityNPCFurryFemale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.OrcMale) {
                entityNPCInterface = new EntityNPCOrcMale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.OrcFemale) {
                entityNPCInterface = new EntityNPCOrcFemale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.ElfMale) {
                entityNPCInterface = new EntityNPCElfMale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.ElfFemale) {
                entityNPCInterface = new EntityNPCElfFemale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.Crystal) {
                entityNPCInterface = new EntityNpcCrystal(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.EnderChibi) {
                entityNPCInterface = new EntityNpcEnderchibi(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.EnderMan) {
                entityNPCInterface = new EntityNPCEnderman(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.NagaFemale) {
                entityNPCInterface = new EntityNpcNagaFemale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.NagaMale) {
                entityNPCInterface = new EntityNpcNagaMale(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.Dragon) {
                entityNPCInterface = new EntityNpcDragon(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.Slime) {
                entityNPCInterface = new EntityNpcSlime(this.npc.field_70170_p);
            }
            if (this.npc.display.modelType == EnumModelType.Golem) {
                entityNPCInterface = new EntityNPCGolem(this.npc.field_70170_p);
            }
            String string = ((EntityNPCInterface)entityNPCInterface).display.texture;
            qoac qoac2 = this.npc.copy();
            ((EntityNPCInterface)entityNPCInterface).func_70020_e(qoac2);
            ((EntityNPCInterface)entityNPCInterface).display.texture = string;
            NoppesUtil.sendData(EnumPacketType.ChangeModel, this.npc.startPos[0], this.npc.startPos[1], this.npc.startPos[2], ((EntityNPCInterface)entityNPCInterface).copy());
        }
    }
}

