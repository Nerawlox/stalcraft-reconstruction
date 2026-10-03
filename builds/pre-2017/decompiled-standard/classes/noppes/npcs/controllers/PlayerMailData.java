/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import noppes.npcs.controllers.IPlayerData;
import noppes.npcs.controllers.PlayerMail;

public class PlayerMailData
implements IPlayerData {
    public ArrayList playermail = new ArrayList();

    public void readNBT(qoac qoac2) {
        ArrayList<PlayerMail> arrayList = new ArrayList<PlayerMail>();
        bsyv bsyv2 = qoac2._n("MailData");
        for (int i = 0; i < bsyv2._d(); ++i) {
            PlayerMail playerMail = new PlayerMail();
            playerMail.readNBT((qoac)bsyv2._b(i));
            arrayList.add(playerMail);
        }
        this.playermail = arrayList;
    }

    @Override
    public qoac writeNBT(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (PlayerMail playerMail : this.playermail) {
            bsyv2._a(playerMail.writeNBT());
        }
        qoac2._a("MailData", bsyv2);
        return qoac2;
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

