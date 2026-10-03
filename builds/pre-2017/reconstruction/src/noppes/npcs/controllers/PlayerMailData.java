/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.IPlayerData;
import noppes.npcs.controllers.PlayerMail;

public class PlayerMailData
implements IPlayerData {
    public ArrayList playermail = new ArrayList();

    public void readNBT(NBTTagCompound nBTTagCompound) {
        ArrayList<PlayerMail> arrayList = new ArrayList<PlayerMail>();
        NBTTagList nBTTagList = nBTTagCompound._n("MailData");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            PlayerMail playerMail = new PlayerMail();
            playerMail.readNBT((NBTTagCompound)nBTTagList._b(i));
            arrayList.add(playerMail);
        }
        this.playermail = arrayList;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (PlayerMail playerMail : this.playermail) {
            nBTTagList._a(playerMail.writeNBT());
        }
        nBTTagCompound._a("MailData", nBTTagList);
        return nBTTagCompound;
    }

    public boolean hasMail() {
        PlayerMail playerMail;
        Iterator iterator2 = this.playermail.iterator();
        do {
            if (!iterator2.hasNext()) {
                return false;
            }
            playerMail = (PlayerMail)iterator2.next();
        } while (playerMail.beenRead);
        return true;
    }
}

