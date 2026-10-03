/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.questtypes;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jgro;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.controllers.Quest;
import noppes.npcs.quests.QuestKill;

public class GuiNpcQuestTypeKill
extends GuiNPCInterface
implements GuiCustomScrollActionListener,
ITextfieldListener {
    private gqjz parent;
    private GuiCustomScroll scroll;
    private QuestKill quest;
    private GuiNpcTextField lastSelected;

    public GuiNpcQuestTypeKill(EntityNPCInterface entityNPCInterface, Quest quest, gqjz gqjz2) {
        super(entityNPCInterface);
        this.parent = gqjz2;
        this.title = "Quest Kill Setup";
        this.quest = (QuestKill)quest.questInterface;
    }

    @Override
    public void func_73866_w_() {
        Object object2;
        super.func_73866_w_();
        int n = 0;
        this.addLabel(new GuiNpcLabel(0, "You can fill in npc or player names too", this.guiLeft - 100, this.guiTop + 50, 0xFFFFFF));
        for (Object object2 : this.quest.targets.keySet()) {
            this.addTextField(new GuiNpcTextField(n, this, this.field_73886_k, this.guiLeft - 100, this.guiTop + 70 + n * 22, 180, 20, (String)object2));
            this.addTextField(new GuiNpcTextField(n + 3, this, this.field_73886_k, this.guiLeft + 84, this.guiTop + 70 + n * 22, 30, 20, this.quest.targets.get(object2) + ""));
            this.getTextField((int)(n + 3)).numbersOnly = true;
            this.getTextField(n + 3).setMinMaxDefault(1, Integer.MAX_VALUE, 1);
            ++n;
        }
        while (n < 3) {
            this.addTextField(new GuiNpcTextField(n, this, this.field_73886_k, this.guiLeft - 100, this.guiTop + 70 + n * 22, 180, 20, ""));
            this.addTextField(new GuiNpcTextField(n + 3, this, this.field_73886_k, this.guiLeft + 84, this.guiTop + 70 + n * 22, 30, 20, "1"));
            this.getTextField((int)(n + 3)).numbersOnly = true;
            this.getTextField(n + 3).setMinMaxDefault(1, Integer.MAX_VALUE, 1);
            ++n;
        }
        Map map = jgro._a;
        object2 = new ArrayList();
        for (Object k : map.keySet()) {
            Class clazz = (Class)map.get(k);
            try {
                if (!EntityLivingBase.class.isAssignableFrom(clazz) || EntityNPCInterface.class.isAssignableFrom(clazz) || clazz.getConstructor(ozlu.class) == null || Modifier.isAbstract(clazz.getModifiers())) continue;
                ((ArrayList)object2).add(k.toString());
            }
            catch (SecurityException securityException) {
                securityException.printStackTrace();
            }
            catch (NoSuchMethodException noSuchMethodException) {}
        }
        this.scroll = new GuiCustomScroll(this, 0);
        this.scroll.setList((List)object2);
        this.scroll.func_73872_a(this.field_73882_e, 350, 250);
        this.scroll.setSize(140, 190);
        this.scroll.guiLeft = this.guiLeft + 120;
        this.scroll.guiTop = this.guiTop + 14;
        this.addButton(new GuiNpcButton(0, this.guiLeft - 100, this.guiTop + 140, 98, 20, "gui.back"));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        this.scroll.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        if (jiok2.field_73741_f == 0) {
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this.scroll.func_73864_a(n, n2, n3);
    }

    @Override
    public void save() {
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id < 3) {
            this.lastSelected = guiNpcTextField;
        }
        this.saveTargets();
    }

    private void saveTargets() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < 3; ++i) {
            String string = this.getTextField(i).func_73781_b();
            if (string.isEmpty()) continue;
            hashMap.put(string, this.getTextField(i + 3).getInteger());
        }
        this.quest.targets = hashMap;
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        if (this.lastSelected != null) {
            this.lastSelected.func_73782_a(guiCustomScroll.getSelected());
            this.saveTargets();
        }
    }
}

