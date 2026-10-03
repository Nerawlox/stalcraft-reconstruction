/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import noppes.npcs.controllers.Bank;
import noppes.npcs.controllers.BankController;
import noppes.npcs.controllers.BankData;
import noppes.npcs.controllers.IPlayerData;

public class PlayerBankData
implements IPlayerData {
    public HashMap banks = new HashMap();

    public void readNBT(qoac qoac2) {
        HashMap<Integer, BankData> hashMap = new HashMap<Integer, BankData>();
        bsyv bsyv2 = qoac2._n("BankData");
        if (bsyv2 != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac3 = (qoac)bsyv2._b(i);
                BankData bankData = new BankData();
                bankData.readNBT(qoac3);
                hashMap.put(bankData.bankId, bankData);
            }
            this.banks = hashMap;
        }
    }

    @Override
    public qoac writeNBT(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (BankData bankData : this.banks.values()) {
            qoac qoac3 = new qoac();
            bankData.writeNBT(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("BankData", bsyv2);
        return qoac2;
    }

    public BankData getBank(int n) {
        return (BankData)this.banks.get(n);
    }

    public BankData getBankOrDefault(int n) {
        BankData bankData = (BankData)this.banks.get(n);
        if (bankData != null) {
            return bankData;
        }
        Bank bank = BankController.getInstance().getBank(n);
        return (BankData)this.banks.get(bank.id);
    }

    public boolean hasBank(int n) {
        return this.banks.containsKey(n);
    }

    public void loadNew(int n) {
        BankData bankData = new BankData();
        bankData.bankId = n;
        this.banks.put(n, bankData);
    }
}

