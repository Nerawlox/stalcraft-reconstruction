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
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.controllers.TransportCategory;
import noppes.npcs.controllers.TransportLocation;
import noppes.npcs.roles.RoleTransporter;

public class TransportController {
    private static TransportController instance;
    public HashMap categories = new HashMap();
    private HashMap locations = new HashMap();
    private int lastUsedID = 0;

    public TransportController() {
        instance = this;
        this.loadCategories();
        if (this.categories.isEmpty()) {
            TransportCategory transportCategory = new TransportCategory();
            transportCategory.id = 1;
            transportCategory.title = "Default";
            this.categories.put(transportCategory.id, transportCategory);
        }
    }

    public static TransportController getInstance() {
        return instance;
    }

    private void loadCategories() {
        File file = CustomNpcs.getWorldSaveDirectory();
        if (file != null) {
            try {
                File file2 = new File(file, "transport.dat");
                if (!file2.exists()) {
                    return;
                }
                this.loadCategoriesFile(file2);
            }
            catch (IOException iOException) {
                try {
                    File file3 = new File(file, "transport.dat_old");
                    if (!file3.exists()) {
                        return;
                    }
                    this.loadCategoriesFile(file3);
                }
                catch (IOException iOException2) {
                    // empty catch block
                }
            }
        }
    }

    private void loadCategoriesFile(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(file))));
        this.loadCategoriesStream(dataInputStream);
        dataInputStream.close();
    }

    public void loadCategoriesStream(DataInputStream dataInputStream) throws IOException {
        HashMap<Integer, TransportLocation> hashMap = new HashMap<Integer, TransportLocation>();
        HashMap<Integer, TransportCategory> hashMap2 = new HashMap<Integer, TransportCategory>();
        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
        this.lastUsedID = nBTTagCompound._f("lastID");
        NBTTagList nBTTagList = nBTTagCompound._n("NPCTransportCategories");
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                TransportCategory transportCategory = new TransportCategory();
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                transportCategory.readNBT(nBTTagCompound2);
                for (TransportLocation transportLocation : transportCategory.locations.values()) {
                    hashMap.put(transportLocation.id, transportLocation);
                }
                hashMap2.put(transportCategory.id, transportCategory);
            }
            this.locations = hashMap;
            this.categories = hashMap2;
        }
    }

    public NBTTagCompound getNBT() {
        Object object2;
        NBTTagList nBTTagList = new NBTTagList();
        for (Object object2 : this.categories.values()) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            ((TransportCategory)object2).writeNBT(nBTTagCompound);
            nBTTagList._a(nBTTagCompound);
        }
        object2 = new NBTTagCompound();
        ((NBTTagCompound)object2)._a("lastID", this.lastUsedID);
        ((NBTTagCompound)object2)._a("NPCTransportCategories", nBTTagList);
        return object2;
    }

    public void saveCategories() {
        if (FileWriteBlocker._a) {
            return;
        }
        try {
            File file = CustomNpcs.getWorldSaveDirectory();
            File file2 = new File(file, "transport.dat_new");
            File file3 = new File(file, "transport.dat_old");
            File file4 = new File(file, "transport.dat");
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
            System.err.println(exception.getMessage());
        }
    }

    public TransportLocation getTransport(int n) {
        return (TransportLocation)this.locations.get(n);
    }

    public TransportLocation getTransport(String string) {
        TransportLocation transportLocation;
        Iterator iterator2 = this.locations.values().iterator();
        do {
            if (!iterator2.hasNext()) {
                return null;
            }
            transportLocation = (TransportLocation)iterator2.next();
        } while (!transportLocation.name.equals(string));
        return transportLocation;
    }

    private int getUniqueIdLocation() {
        if (this.lastUsedID == 0) {
            Iterator iterator2 = this.locations.keySet().iterator();
            while (iterator2.hasNext()) {
                int n = (Integer)iterator2.next();
                if (n <= this.lastUsedID) continue;
                this.lastUsedID = n;
            }
        }
        ++this.lastUsedID;
        return this.lastUsedID;
    }

    private int getUniqueIdCategory() {
        int n = 0;
        Iterator iterator2 = this.categories.keySet().iterator();
        while (iterator2.hasNext()) {
            int n2 = (Integer)iterator2.next();
            if (n2 <= n) continue;
            n = n2;
        }
        return ++n;
    }

    public void setLocation(TransportLocation transportLocation) {
        if (this.locations.containsKey(transportLocation.id)) {
            for (TransportCategory transportCategory : this.categories.values()) {
                transportCategory.locations.remove(transportLocation.id);
            }
        }
        this.locations.put(transportLocation.id, transportLocation);
        transportLocation.category.locations.put(transportLocation.id, transportLocation);
    }

    public void removeLocation(int n) {
        TransportLocation transportLocation = (TransportLocation)this.locations.get(n);
        if (transportLocation != null) {
            transportLocation.category.locations.remove(n);
            this.locations.remove(n);
            this.saveCategories();
        }
    }

    private boolean containsCategoryName(String string) {
        TransportCategory transportCategory;
        string = string.toLowerCase();
        Iterator iterator2 = this.categories.values().iterator();
        do {
            if (!iterator2.hasNext()) {
                return false;
            }
            transportCategory = (TransportCategory)iterator2.next();
        } while (!transportCategory.title.toLowerCase().equals(string));
        return true;
    }

    public void saveCategory(DataInputStream dataInputStream) throws IOException {
        String string = dataInputStream.readUTF();
        int n = dataInputStream.readInt();
        if (n < 0) {
            n = this.getUniqueIdCategory();
        }
        if (this.categories.containsKey(n)) {
            TransportCategory transportCategory = (TransportCategory)this.categories.get(n);
            if (!transportCategory.title.equals(string)) {
                while (this.containsCategoryName(string)) {
                    string = string + "_";
                }
                ((TransportCategory)this.categories.get((Object)Integer.valueOf((int)n))).title = string;
            }
        } else {
            while (this.containsCategoryName(string)) {
                string = string + "_";
            }
            TransportCategory transportCategory = new TransportCategory();
            transportCategory.id = n;
            transportCategory.title = string;
            this.categories.put(n, transportCategory);
        }
        this.saveCategories();
    }

    public void removeCategory(int n) {
        TransportCategory transportCategory;
        if (this.categories.size() != 1 && (transportCategory = (TransportCategory)this.categories.get(n)) != null) {
            Iterator iterator2 = transportCategory.locations.keySet().iterator();
            while (iterator2.hasNext()) {
                int n2 = (Integer)iterator2.next();
                this.locations.remove(n2);
            }
            this.categories.remove(n);
            this.saveCategories();
        }
    }

    public boolean containsLocationName(String string) {
        TransportLocation transportLocation;
        string = string.toLowerCase();
        Iterator iterator2 = this.locations.values().iterator();
        do {
            if (!iterator2.hasNext()) {
                return false;
            }
            transportLocation = (TransportLocation)iterator2.next();
        } while (!transportLocation.name.toLowerCase().equals(string));
        return true;
    }

    public TransportLocation saveLocation(int n, DataInputStream dataInputStream, EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface) throws IOException {
        TransportCategory transportCategory = (TransportCategory)this.categories.get(n);
        if (transportCategory != null && entityNPCInterface.advanced.role == EnumRoleType.Transporter) {
            RoleTransporter roleTransporter = (RoleTransporter)entityNPCInterface.roleInterface;
            TransportLocation transportLocation = new TransportLocation();
            transportLocation.readNBT(bsvf._a(dataInputStream));
            transportLocation.category = transportCategory;
            if (roleTransporter.hasTransport()) {
                transportLocation.id = roleTransporter.transportId;
            }
            if (transportLocation.id < 0 || !((TransportLocation)this.locations.get((Object)Integer.valueOf((int)transportLocation.id))).name.equals(transportLocation.name)) {
                while (this.containsLocationName(transportLocation.name)) {
                    transportLocation.name = transportLocation.name + "_";
                }
            }
            if (transportLocation.id < 0) {
                transportLocation.id = this.getUniqueIdLocation();
            }
            transportCategory.locations.put(transportLocation.id, transportLocation);
            this.locations.put(transportLocation.id, transportLocation);
            this.saveCategories();
            return transportLocation;
        }
        return null;
    }
}

