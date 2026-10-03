/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.Random;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumModelType;

public class DataDisplay {
    public String name;
    public boolean usingSkinUrl = false;
    public String skinUsername = "";
    public String texture = "customnpcs:textures/entity/humanmale/Steve.png";
    public String cloakTexture = "";
    public String glowTexture = "";
    public int visible = 0;
    public EnumModelType modelType = EnumModelType.HumanMale;
    public int modelSize = 5;
    public int showName = 0;
    public int skinColor = 0xFFFFFF;
    public boolean NoLivingAnimation = false;
    EntityNPCInterface npc;
    public boolean showTip = true;
    public boolean bloodStains = true;
    public String iconName = "";

    public DataDisplay(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
        String[] stringArray = new String[]{"Noppes", "Noppes", "Noppes", "Noppes", "Atesson", "Rothcersul", "Achdranys", "Pegato", "Chald", "Gareld", "Nalworche", "Ineald", "Tia'kim", "Torerod", "Turturdar", "Ranler", "Dyntan", "Oldrake", "Gharis", "Elmn", "Tanal", "Waran-ess", "Ach-aldhat", "Athi", "Itageray", "Tasr", "Ightech", "Gakih", "Adkal", "Qua'an", "Sieq", "Urnp", "Rods", "Vorbani", "Smaik", "Fian", "Hir", "Ristai", "Kineth", "Naif", "Issraya", "Arisotura", "Honf", "Rilfom", "Estz", "Ghatroth", "Yosil", "Darage", "Aldny", "Tyltran", "Armos", "Loxiku", "Burhat", "Tinlt", "Ightyd", "Mia", "Ken", "Karla", "Lily", "Carina", "Daniel", "Slater", "Zidane", "Valentine", "Eirina", "Carnow", "Grave", "Shadow", "Drakken", "Kaoz", "Silk", "Drake", "Oldam", "Lynxx", "Lenyx", "Winter", "Seth", "Apolitho", "Amethyst", "Ankin", "Seinkan", "Ayumu", "Sakamoto", "Divina", "Div", "Magia", "Magnus", "Tiakono", "Ruin", "Hailinx", "Ethan", "Wate", "Carter", "William", "Brion", "Sparrow", "Basrrelen", "Gyaku", "Claire", "Crowfeather", "Blackwell", "Raven", "Farcri", "Lucas", "Bangheart", "Kamoku", "Kyoukan", "Blaze", "Benjamin", "Larianne", "Kakaragon", "Melancholy", "Epodyno", "Thanato", "Mika", "Dacks", "Ylander", "Neve", "Meadow", "Cuero", "Embrera", "Eldamore", "Faolan", "Chim", "Nasu", "Kathrine", "Ariel", "Arei", "Demytrix", "Kora", "Ava", "Larson", "Leonardo", "Wyrl", "Sakiama", "Lambton", "Kederath", "Malus", "Riplette", "Andern", "Ezall", "Lucien", "Droco", "Cray", "Tymen", "Zenix", "Entranger", "Saenorath", "Chris", "Christine", "Marble", "Mable", "Ross", "Rose", "Xalgan ", "Kennet"};
        this.name = stringArray[new Random().nextInt(stringArray.length)];
    }

    public qoac writeToNBT(qoac qoac2) {
        qoac2._a("Name", this.name);
        qoac2._a("SkinUsername", this.skinUsername);
        qoac2._a("Texture", this.texture);
        qoac2._a("CloakTexture", this.cloakTexture);
        qoac2._a("GlowTexture", this.glowTexture);
        qoac2._a("UsingSkinUrl", this.usingSkinUrl);
        qoac2._a("ModelType", this.modelType.ordinal());
        qoac2._a("Size", this.modelSize);
        qoac2._a("ShowName", this.showName);
        qoac2._a("SkinColor", this.skinColor);
        qoac2._a("NpcVisible", this.visible);
        qoac2._a("NoLivingAnimation", this.NoLivingAnimation);
        qoac2._a("SaveTexExtension", true);
        qoac2._a("showTip", this.showTip);
        qoac2._a("BloodStains", this.bloodStains);
        qoac2._a("IconName", this.iconName);
        return qoac2;
    }

    public void readToNBT(qoac qoac2) {
        this.name = qoac2._j("Name");
        this.skinUsername = qoac2._j("SkinUsername");
        this.texture = qoac2._j("Texture");
        this.cloakTexture = qoac2._j("CloakTexture");
        this.glowTexture = qoac2._j("GlowTexture");
        this.usingSkinUrl = qoac2._o("UsingSkinUrl");
        this.modelType = EnumModelType.values()[qoac2._f("ModelType") % EnumModelType.values().length];
        this.modelSize = qoac2._f("Size");
        this.showName = qoac2._f("ShowName");
        this.skinColor = qoac2._f("SkinColor");
        this.visible = qoac2._f("NpcVisible");
        this.iconName = qoac2._j("IconName");
        this.NoLivingAnimation = qoac2._o("NoLivingAnimation");
        boolean bl = this.showTip = !qoac2._c("showTip") || qoac2._o("showTip");
        if (!qoac2._o("SaveTexExtension")) {
            int n = this.texture.lastIndexOf(".");
            if (n != -1) {
                this.texture = this.texture.substring(0, n + 1) + "erk";
            }
            if ((n = this.cloakTexture.lastIndexOf(".")) != -1) {
                this.cloakTexture = this.cloakTexture.substring(0, n + 1) + "erk";
            }
            if ((n = this.glowTexture.lastIndexOf(".")) != -1) {
                this.glowTexture = this.glowTexture.substring(0, n + 1) + "erk";
            }
        }
        this.bloodStains = !qoac2._c("BloodStains") || qoac2._o("BloodStains");
    }

    public boolean showName() {
        return this.npc.isKilled() ? false : this.showName == 0 || this.showName == 2 && this.npc.isAttacking();
    }
}

