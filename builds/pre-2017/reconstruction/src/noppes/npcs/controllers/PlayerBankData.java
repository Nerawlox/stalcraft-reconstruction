/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.Bank;
import noppes.npcs.controllers.BankController;
import noppes.npcs.controllers.BankData;
import noppes.npcs.controllers.IPlayerData;

public class PlayerBankData
implements IPlayerData {
    public HashMap banks = new HashMap();

    public void readNBT(NBTTagCompound nBTTagCompound) {
        HashMap<Integer, BankData> hashMap = new HashMap<Integer, BankData>();
        NBTTagList nBTTagList = nBTTagCompound._n("BankData");
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                BankData bankData = new BankData();
                bankData.readNBT(nBTTagCompound2);
                hashMap.put(bankData.bankId, bankData);
            }
            this.banks = hashMap;
        }
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (BankData bankData : this.banks.values()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            bankData.writeNBT(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("BankData", nBTTagList);
        return nBTTagCompound;
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

