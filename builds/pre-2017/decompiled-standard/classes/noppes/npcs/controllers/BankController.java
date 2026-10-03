/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import noppes.npcs.CustomNpcs;
import noppes.npcs.controllers.Bank;

public class BankController {
    private static BankController instance;
    public HashMap banks;
    private String filePath = "";

    public BankController() {
        instance = this;
        this.banks = new HashMap();
        this.loadBanks();
        if (this.banks.isEmpty()) {
            Bank bank = new Bank();
            bank.id = 0;
            bank.name = "Default Bank";
            for (int i = 0; i < 6; ++i) {
                bank.slotTypes.put(i, 0);
            }
            this.banks.put(bank.id, bank);
        }
    }

    public static BankController getInstance() {
        if (BankController.newInstance()) {
            instance = new BankController();
        }
        return instance;
    }

    private static boolean newInstance() {
        if (instance == null) {
            return true;
        }
        File file = CustomNpcs.getWorldSaveDirectory();
        return file == null ? false : !BankController.instance.filePath.equals(file.getAbsolutePath());
    }

    private void loadBanks() {
        File file = CustomNpcs.getWorldSaveDirectory();
        if (file != null) {
            this.filePath = file.getAbsolutePath();
            try {
                File file2 = new File(file, "bank.dat");
                if (file2.exists()) {
                    this.loadBanks(file2);
                }
            }
            catch (Exception exception) {
                try {
                    File file3 = new File(file, "bank.dat_old");
                    if (file3.exists()) {
                        this.loadBanks(file3);
                    }
                }
                catch (Exception exception2) {
                    // empty catch block
                }
            }
        }
    }

    private void loadBanks(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(file))));
        this.loadBanks(dataInputStream);
        dataInputStream.close();
    }

    public void loadBanks(DataInputStream dataInputStream) throws IOException {
        HashMap<Integer, Bank> hashMap = new HashMap<Integer, Bank>();
        qoac qoac2 = bsvf._a(dataInputStream);
        bsyv bsyv2 = qoac2._n("Data");
        if (bsyv2 != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac3 = (qoac)bsyv2._b(i);
                Bank bank = new Bank();
                bank.readEntityFromNBT(qoac3);
                hashMap.put(bank.id, bank);
            }
        }
        this.banks = hashMap;
    }

    public qoac getNBT() {
        Object object2;
        bsyv bsyv2 = new bsyv();
        for (Object object2 : this.banks.values()) {
            qoac qoac2 = new qoac();
            ((Bank)object2).writeEntityToNBT(qoac2);
            bsyv2._a(qoac2);
        }
        object2 = new qoac();
        ((qoac)object2)._a("Data", bsyv2);
        return object2;
    }

    public Bank getBank(int n) {
        Bank bank = (Bank)this.banks.get(n);
        return bank != null ? bank : (Bank)this.banks.values().iterator().next();
    }

    public void saveBanks() {
        if (FileWriteBlocker._a) {
            return;
        }
        try {
            File file = CustomNpcs.getWorldSaveDirectory();
            File file2 = new File(file, "bank.dat_new");
            File file3 = new File(file, "bank.dat_old");
            File file4 = new File(file, "bank.dat");
            bsvf._a(this.getNBT(), new FileOutputStream(file2));
            if (file3.exists()) {
                file3.delete();
            }
            file4.renameTo(file3);
            if (file4.exists()) {
                file4.delete();
            }
            file2.renameTo(file4);
            if (file2.exists()) {
                file2.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void saveBank(Bank bank) {
        if (bank.id < 0) {
            bank.id = this.getUnusedId();
        }
        this.banks.put(bank.id, bank);
        this.saveBanks();
    }

    public int getUnusedId() {
        int n = 0;
        while (this.banks.containsKey(n)) {
            ++n;
        }
        return n;
    }

    public void removeBank(int n) {
        if (n >= 0 && this.banks.size() > 1) {
            this.banks.remove(n);
            this.saveBanks();
        }
    }
}

