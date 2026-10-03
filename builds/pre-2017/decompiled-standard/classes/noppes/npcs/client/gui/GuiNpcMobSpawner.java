/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.jgro;
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
    public void func_73866_w_() {
        super.func_73866_w_();
        this.guiTop += 10;
        if (this.scroll == null) {
            this.scroll = new GuiCustomScroll(this, 0);
            this.scroll.setSize(165, 188);
            this.scroll.guiLeft = this.guiLeft + 4;
            this.scroll.guiTop = this.guiTop + 26;
        } else {
            this.scroll.clear();
        }
        this.addScroll(this.scroll, this.field_73882_e);
        this.addTextField(new GuiNpcTextField(1, this, this.field_73886_k, this.guiLeft + 4, this.guiTop + 4, 165, 20, search));
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
                if (!EntityLiving.class.isAssignableFrom(clazz) || clazz.getConstructor(ozlu.class) == null || Modifier.isAbstract(clazz.getModifiers())) continue;
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
        for (qoac qoac2 : CloneController.getClones()) {
            String string = qoac2._j("ClonedName");
            int n = 1;
            while (arrayList.contains(string)) {
                string = String.format("%s%s", qoac2._j("ClonedName"), ++n);
            }
            n = 1;
            if (qoac2._c("ClonedTab")) {
                n = qoac2._f("ClonedTab");
            }
            if (this.activeTab != n) continue;
            arrayList.add(string);
            this.cloneData.put(string, qoac2);
        }
        this.list = arrayList;
        this.scroll.setList(this.getSearchList());
    }

    @Override
    public void func_73869_a(char c, int n) {
        super.func_73869_a(c, n);
        if (!search.equals(this.getTextField(1).func_73781_b())) {
            search = this.getTextField(1).func_73781_b().toLowerCase();
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

    private qoac getCompound() {
        String string = this.scroll.getSelected();
        if (string == null) {
            return null;
        }
        if (showingClones) {
            qoac qoac2 = (qoac)this.cloneData.get(string);
            qoac2._p("StartPos");
            qoac2._p("Pos");
            if (!qoac2._c("ModRev")) {
                qoac2._a("ModRev", 1);
            }
            return qoac2;
        }
        Entity entity = jgro._a(string, (ozlu)xpzm._E()._r);
        qoac qoac3 = new qoac();
        entity.func_70039_c(qoac3);
        return qoac3;
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        qoac qoac2;
        if (jiok2.field_73741_f == 0) {
            this.close();
        }
        if (jiok2.field_73741_f == 1 && (qoac2 = this.getCompound()) != null) {
            qoac2._a("Pos", this.newDoubleNBTList((double)this.posX + 0.5, this.posY + 1, (double)this.posZ + 0.5));
            qoac2._a("ItemGiverId", 0);
            qoac2._a("TransporterId", -1);
            qoac2._a("owner", "");
            qoac2._a("sharedDataId", 0);
            NoppesUtil.sendData(EnumPacketType.SpawnMob, qoac2);
            this.close();
        }
        if (jiok2.field_73741_f == 2 && (qoac2 = this.getCompound()) != null) {
            qoac2._a("owner", "");
            qoac2._a("sharedDataId", 0);
            NoppesUtil.sendData(EnumPacketType.MobSpawner, this.posX, this.posY, this.posZ, qoac2);
            this.close();
        }
        if (jiok2.field_73741_f == 3) {
            showingClones = true;
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f == 4) {
            showingClones = false;
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f == 5 && this.scroll.getSelected() != null) {
            qoac2 = (qoac)this.cloneData.get(this.scroll.getSelected());
            this.data.remove(qoac2);
            CloneController.saveClones(this.data);
            this.scroll.selected = -1;
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f > 20) {
            this.activeTab = jiok2.field_73741_f - 20;
            this.func_73866_w_();
        }
    }

    protected bsyv newDoubleNBTList(double ... dArray) {
        bsyv bsyv2 = new bsyv();
        double[] dArray2 = dArray;
        int n = dArray.length;
        for (int i = 0; i < n; ++i) {
            double d = dArray2[i];
            bsyv2._a(new qoae(null, d));
        }
        return bsyv2;
    }

    @Override
    public void save() {
    }
}

