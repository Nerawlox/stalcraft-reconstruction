/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.jgro;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.controllers.CloneController;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiMenuSideButton;
import noppes.npcs.client.gui.util.GuiMenuTopButton;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumPacketType;

public class GuiNpcMobSpawner
extends GuiNPCInterface {
    private static boolean showingClones = true;
    private static String search = "";
    private GuiCustomScroll scroll;
    private int posX;
    private int posY;
    private int posZ;
    private HashMap cloneData = new HashMap();
    private List data = new ArrayList();
    private ArrayList list;
    private int activeTab = 1;

    public GuiNpcMobSpawner(int n, int n2, int n3) {
        this.xSize = 256;
        this.posX = n;
        this.posY = n2;
        this.posZ = n3;
        this.closeOnEsc = true;
        this.setBackground("menubg.png");
    }

    @Override
    public void initGui() {
        super.initGui();
        this.guiTop += 10;
        if (this.scroll == null) {
            this.scroll = new GuiCustomScroll(this, 0);
            this.scroll.setSize(165, 188);
            this.scroll.guiLeft = this.guiLeft + 4;
            this.scroll.guiTop = this.guiTop + 26;
        } else {
            this.scroll.clear();
        }
        this.addScroll(this.scroll, this.mc);
        this.addTextField(new GuiNpcTextField(1, this, this.fontRenderer, this.guiLeft + 4, this.guiTop + 4, 165, 20, search));
        GuiMenuTopButton guiMenuTopButton = new GuiMenuTopButton(3, this.guiLeft + 4, this.guiTop - 17, "spawner.clones");
        this.addTopButton(guiMenuTopButton);
        guiMenuTopButton.active = showingClones;
        guiMenuTopButton = new GuiMenuTopButton(4, guiMenuTopButton, "spawner.entities");
        this.addTopButton(guiMenuTopButton);
        guiMenuTopButton.active = !showingClones;
        this.addButton(new GuiNpcButton(1, this.guiLeft + 170, this.guiTop + 6, 82, 20, "item.monsterPlacer.name"));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 170, this.guiTop + 100, 82, 20, "spawner.mobspawner"));
        if (showingClones) {
            this.addSideButton(new GuiMenuSideButton(21, this.guiLeft - 69, this.guiTop + 2, 70, 22, "Tab 1"));
            this.addSideButton(new GuiMenuSideButton(22, this.guiLeft - 69, this.guiTop + 23, 70, 22, "Tab 2"));
            this.addSideButton(new GuiMenuSideButton(23, this.guiLeft - 69, this.guiTop + 44, 70, 22, "Tab 3"));
            this.addSideButton(new GuiMenuSideButton(24, this.guiLeft - 69, this.guiTop + 65, 70, 22, "Tab 4"));
            this.addSideButton(new GuiMenuSideButton(25, this.guiLeft - 69, this.guiTop + 86, 70, 22, "Tab 5"));
            this.addSideButton(new GuiMenuSideButton(26, this.guiLeft - 69, this.guiTop + 107, 70, 22, "Tab 6"));
            this.addSideButton(new GuiMenuSideButton(27, this.guiLeft - 69, this.guiTop + 128, 70, 22, "Tab 7"));
            this.addSideButton(new GuiMenuSideButton(28, this.guiLeft - 69, this.guiTop + 149, 70, 22, "Tab 8"));
            this.addSideButton(new GuiMenuSideButton(29, this.guiLeft - 69, this.guiTop + 170, 70, 22, "Tab 9"));
            this.getSideButton((int)(20 + this.activeTab)).active = true;
            this.showClones();
        } else {
            this.showEntities();
        }
    }

    private void showEntities() {
        Map map = jgro._a;
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Object k : map.keySet()) {
            Class clazz = (Class)map.get(k);
            try {
                if (!EntityLiving.class.isAssignableFrom(clazz) || clazz.getConstructor(World.class) == null || Modifier.isAbstract(clazz.getModifiers())) continue;
                arrayList.add(k.toString());
            }
            catch (SecurityException securityException) {
                securityException.printStackTrace();
            }
            catch (NoSuchMethodException noSuchMethodException) {}
        }
        this.list = arrayList;
        this.scroll.setList(this.getSearchList());
    }

    private void showClones() {
        this.addButton(new GuiNpcButton(5, this.guiLeft + 170, this.guiTop + 30, 82, 20, "gui.remove"));
        this.cloneData.clear();
        ArrayList<String> arrayList = new ArrayList<String>();
        this.data = CloneController.getClones();
        for (NBTTagCompound nBTTagCompound : CloneController.getClones()) {
            String string = nBTTagCompound._j("ClonedName");
            int n = 1;
            while (arrayList.contains(string)) {
                string = String.format("%s%s", nBTTagCompound._j("ClonedName"), ++n);
            }
            n = 1;
            if (nBTTagCompound._c("ClonedTab")) {
                n = nBTTagCompound._f("ClonedTab");
            }
            if (this.activeTab != n) continue;
            arrayList.add(string);
            this.cloneData.put(string, nBTTagCompound);
        }
        this.list = arrayList;
        this.scroll.setList(this.getSearchList());
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (!search.equals(this.getTextField(1).getText())) {
            search = this.getTextField(1).getText().toLowerCase();
            this.scroll.setList(this.getSearchList());
        }
    }

    private List getSearchList() {
        if (search.isEmpty()) {
            return new ArrayList(this.list);
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string : this.list) {
            if (!string.toLowerCase().contains(search)) continue;
            arrayList.add(string);
        }
        return arrayList;
    }

    private NBTTagCompound getCompound() {
        String string = this.scroll.getSelected();
        if (string == null) {
            return null;
        }
        if (showingClones) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)this.cloneData.get(string);
            nBTTagCompound._p("StartPos");
            nBTTagCompound._p("Pos");
            if (!nBTTagCompound._c("ModRev")) {
                nBTTagCompound._a("ModRev", 1);
            }
            return nBTTagCompound;
        }
        Entity entity = jgro._a(string, (World)Minecraft._E()._r);
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        entity.writeToNBTOptional(nBTTagCompound);
        return nBTTagCompound;
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        NBTTagCompound nBTTagCompound;
        if (guiButton.id == 0) {
            this.close();
        }
        if (guiButton.id == 1 && (nBTTagCompound = this.getCompound()) != null) {
            nBTTagCompound._a("Pos", this.newDoubleNBTList((double)this.posX + 0.5, this.posY + 1, (double)this.posZ + 0.5));
            nBTTagCompound._a("ItemGiverId", 0);
            nBTTagCompound._a("TransporterId", -1);
            nBTTagCompound._a("owner", "");
            nBTTagCompound._a("sharedDataId", 0);
            NoppesUtil.sendData(EnumPacketType.SpawnMob, nBTTagCompound);
            this.close();
        }
        if (guiButton.id == 2 && (nBTTagCompound = this.getCompound()) != null) {
            nBTTagCompound._a("owner", "");
            nBTTagCompound._a("sharedDataId", 0);
            NoppesUtil.sendData(EnumPacketType.MobSpawner, this.posX, this.posY, this.posZ, nBTTagCompound);
            this.close();
        }
        if (guiButton.id == 3) {
            showingClones = true;
            this.initGui();
        }
        if (guiButton.id == 4) {
            showingClones = false;
            this.initGui();
        }
        if (guiButton.id == 5 && this.scroll.getSelected() != null) {
            nBTTagCompound = (NBTTagCompound)this.cloneData.get(this.scroll.getSelected());
            this.data.remove(nBTTagCompound);
            CloneController.saveClones(this.data);
            this.scroll.selected = -1;
            this.initGui();
        }
        if (guiButton.id > 20) {
            this.activeTab = guiButton.id - 20;
            this.initGui();
        }
    }

    protected NBTTagList newDoubleNBTList(double ... dArray) {
        NBTTagList nBTTagList = new NBTTagList();
        double[] dArray2 = dArray;
        int n = dArray.length;
        for (int i = 0; i < n; ++i) {
            double d = dArray2[i];
            nBTTagList._a(new qoae(null, d));
        }
        return nBTTagList;
    }

    @Override
    public void save() {
    }
}

