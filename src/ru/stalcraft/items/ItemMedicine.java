/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  mt
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.ArrayList;
import java.util.List;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class ItemMedicine
extends yc {
    private int heal;
    private int[] contaminationModifiers;
    private boolean removePoison;
    private List info;
    private String textureName;
    private int cost;
    public final String sound;

    public ItemMedicine(int id, String textureName, String localizedName, int heal, int[] contaminationModifiers, boolean removePoison, int cost, String sound) {
        super(id);
        this.heal = heal;
        this.contaminationModifiers = contaminationModifiers;
        this.removePoison = removePoison;
        this.cost = cost;
        this.info = this.getAdditionalLines();
        this.textureName = textureName;
        this.sound = "stalker:" + sound;
        this.a(StalkerMain.tab);
        this.b(textureName);
        LanguageRegistry.addName((Object)this, (String)localizedName);
    }

    private List getAdditionalLines() {
        ArrayList<String> lines = new ArrayList<String>();
        if (this.heal != 0) {
            if (this.heal > 0) {
                lines.add("+" + this.heal + " \u043a \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u044e");
            } else {
                lines.add("-" + this.heal + " \u043a \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u044e");
            }
        }
        if (this.contaminationModifiers[0] != 0) {
            lines.add(this.contaminationModifiers[0] + " \u043a \u0440\u0430\u0434\u0438\u0430\u0446\u0438\u0438");
        }
        if (this.contaminationModifiers[1] != 0) {
            lines.add(this.contaminationModifiers[1] + " \u043a \u043f\u043e\u0432\u044b\u0448\u0435\u043d\u043d\u043e\u0439 \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0435");
        }
        if (this.contaminationModifiers[2] != 0) {
            lines.add(this.contaminationModifiers[2] + " \u043a \u0431\u0438\u043e\u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044e");
        }
        if (this.contaminationModifiers[3] < 0) {
            lines.add("\u0421\u043d\u0438\u043c\u0430\u0435\u0442 \u043f\u0441\u0438-\u0430\u0442\u0430\u043a\u0443");
        }
        if (this.removePoison) {
            lines.add("\u0421\u043d\u0438\u043c\u0430\u0435\u0442 \u043a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u0435");
        }
        if (this.cost != 0) {
            lines.add("\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c: " + this.cost);
        }
        return lines;
    }

    @Override
    public void a(ye par1ItemStack, uf par2EntityPlayer, List par3List, boolean par4) {
        par3List.addAll(this.info);
    }

    public void useHealing(uf player) {
        player.f((float)this.heal);
        PlayerInfo info = PlayerUtils.getInfo(player);
        for (int i2 = 0; i2 < 4; ++i2) {
            info.cont.removeEffect(i2, -this.contaminationModifiers[i2]);
        }
        if (this.removePoison) {
            player.k(19);
        }
    }

    @Override
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:" + this.textureName);
    }
}

