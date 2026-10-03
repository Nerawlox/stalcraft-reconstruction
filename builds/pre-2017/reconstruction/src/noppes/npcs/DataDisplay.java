/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
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

    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Name", this.name);
        nBTTagCompound._a("SkinUsername", this.skinUsername);
        nBTTagCompound._a("Texture", this.texture);
        nBTTagCompound._a("CloakTexture", this.cloakTexture);
        nBTTagCompound._a("GlowTexture", this.glowTexture);
        nBTTagCompound._a("UsingSkinUrl", this.usingSkinUrl);
        nBTTagCompound._a("ModelType", this.modelType.ordinal());
        nBTTagCompound._a("Size", this.modelSize);
        nBTTagCompound._a("ShowName", this.showName);
        nBTTagCompound._a("SkinColor", this.skinColor);
        nBTTagCompound._a("NpcVisible", this.visible);
        nBTTagCompound._a("NoLivingAnimation", this.NoLivingAnimation);
        nBTTagCompound._a("SaveTexExtension", true);
        nBTTagCompound._a("showTip", this.showTip);
        nBTTagCompound._a("BloodStains", this.bloodStains);
        nBTTagCompound._a("IconName", this.iconName);
        return nBTTagCompound;
    }

    public void readToNBT(NBTTagCompound nBTTagCompound) {
        this.name = nBTTagCompound._j("Name");
        this.skinUsername = nBTTagCompound._j("SkinUsername");
        this.texture = nBTTagCompound._j("Texture");
        this.cloakTexture = nBTTagCompound._j("CloakTexture");
        this.glowTexture = nBTTagCompound._j("GlowTexture");
        this.usingSkinUrl = nBTTagCompound._o("UsingSkinUrl");
        this.modelType = EnumModelType.values()[nBTTagCompound._f("ModelType") % EnumModelType.values().length];
        this.modelSize = nBTTagCompound._f("Size");
        this.showName = nBTTagCompound._f("ShowName");
        this.skinColor = nBTTagCompound._f("SkinColor");
        this.visible = nBTTagCompound._f("NpcVisible");
        this.iconName = nBTTagCompound._j("IconName");
        this.NoLivingAnimation = nBTTagCompound._o("NoLivingAnimation");
        boolean bl = this.showTip = !nBTTagCompound._c("showTip") || nBTTagCompound._o("showTip");
        if (!nBTTagCompound._o("SaveTexExtension")) {
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
        this.bloodStains = !nBTTagCompound._c("BloodStains") || nBTTagCompound._o("BloodStains");
    }

    public boolean showName() {
        return this.npc.isKilled() ? false : this.showName == 0 || this.showName == 2 && this.npc.isAttacking();
    }
}

