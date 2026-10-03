/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.client.xpzm;
import noppes.npcs.NpcSynchronizer;
import noppes.npcs.blocks.TileNpcSpawner;
import noppes.npcs.client.gui.GuiDupliNpc;
import noppes.npcs.client.gui.SubGuiNpcAvailability;
import noppes.npcs.controllers.Availability;
import org.apache.commons.lang3.StringUtils;

public class GuiNpcSpawnerEdit
extends GuiScreenAdvanced
implements NpcSynchronizer.DupliNpcsConsumer {
    private ozlu world;
    private int x;
    private int y;
    private int z;
    private McTextArea blocksArea;
    private McTextArea dungeonsArea;
    private List<TileNpcSpawner.NpcSpawnEntry> spawnEntries;
    private Map<Integer, String> dupliNpcsNames = new HashMap<Integer, String>();
    private Availability availability;
    private boolean extendedCheck;
    private TileNpcSpawner spawner;

    public GuiNpcSpawnerEdit(ozlu ozlu2, int n, int n2, int n3) {
        this.world = ozlu2;
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.spawner = this.getSpawner();
        this.availability = this.spawner.availabilityCheck.copy();
        this.extendedCheck = this.spawner.extendedCheck;
        new NpcSynchronizer.PacketDupliNpcsList().sendToServer();
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        GuiHelper.addBackground(this, point.x - 400, point.y - 400, 800, 800, true);
        this.initSideControls(point);
        this.initSpawnEntries(point);
        this.initAvailability(point);
        GuiHelper.addButton(this, point.add(-150, 300), new Dimension(150, 38), "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> {
            this.saveData();
            this.closeScreen();
        });
        GuiHelper.addButton(this, point.add(5, 300), new Dimension(150, 38), "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen());
    }

    private void initSideControls(Point point) {
        TileNpcSpawner tileNpcSpawner = this.spawner;
        Point point2 = point.add(-370, -350);
        int n = 0;
        int n2 = 35;
        int n3 = n++;
        this.addNumberField(point2.x, point2.y + n2 * n3, "Min X", tileNpcSpawner.getXMin(), tileNpcSpawner::setXMin);
        int n4 = n++;
        this.addNumberField(point2.x, point2.y + n2 * n4, "Min Y", tileNpcSpawner.getYMin(), tileNpcSpawner::setYMin);
        int n5 = n++;
        this.addNumberField(point2.x, point2.y + n2 * n5, "Min Z", tileNpcSpawner.getZMin(), tileNpcSpawner::setZMin);
        int n6 = n++;
        this.addNumberField(point2.x, point2.y + n2 * n6, "Max X", tileNpcSpawner.getXMax(), tileNpcSpawner::setXMax);
        int n7 = n++;
        this.addNumberField(point2.x, point2.y + n2 * n7, "Max Y", tileNpcSpawner.getYMax(), tileNpcSpawner::setYMax);
        int n8 = n++;
        this.addNumberField(point2.x, point2.y + n2 * n8, "Max Z", tileNpcSpawner.getZMax(), tileNpcSpawner::setZMax);
        hskr hskr2 = tileNpcSpawner.getConfiguration();
        int n9 = n++;
        this.addNumberField(point2.x, point2.y + n2 * n9, "\u041c\u0430\u043a\u0441. \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439", hskr2.getMaxEntityCount(), hskr2::setMaxEntityCount);
        int n10 = n++;
        this.addNumberField(point2.x, point2.y + n2 * n10, "\u041a\u0443\u043b\u0434\u0430\u0443\u043d \u0441\u043f\u0430\u0432\u043d\u0430 \u043c\u0438\u043d (\u0432 \u0442\u0438\u043a\u0430\u0445)", (int)hskr2.getSpawnCooldownMin(), hskr2::setSpawnCooldownMin);
        int n11 = n++;
        this.addNumberField(point2.x, point2.y + n2 * n11, "\u041a\u0443\u043b\u0434\u0430\u0443\u043d \u0441\u043f\u0430\u0432\u043d\u0430 \u043c\u0430\u043a\u0441 (\u0432 \u0442\u0438\u043a\u0430\u0445)", (int)hskr2.getSpawnCooldownMax(), hskr2::setSpawnCooldownMax);
        int n12 = point2.y + n * n2 + 20;
        Dimension dimension = new Dimension(350, 100);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0421\u043f\u0438\u0441\u043e\u043a id \u0431\u043b\u043e\u043a\u043e\u0432 \u0434\u043b\u044f \u0441\u043f\u0430\u0432\u043d\u0430 (\u0447\u0435\u0440\u0435\u0437 \u0437\u0430\u043f\u044f\u0442\u0443\u044e):", point2.x, n12 - 20));
        this.blocksArea = new McTextArea(this, new Point(point2.x, n12), dimension);
        this.blocksArea.setText(StringUtils.join((Object[])hskr2.getSufficientBlocks(), ", "));
        this.blocksArea.isEditable = true;
        this.addElement(this.blocksArea);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0421\u0435\u0440\u0432\u0435\u0440\u0430 \u0434\u043b\u044f \u0441\u043f\u0430\u0432\u043d\u0430 (\u0441\u043f\u0430\u0432\u043d \u0432\u0435\u0437\u0434\u0435 \u0435\u0441\u043b\u0438 \u043f\u0443\u0441\u0442\u043e):", point2.x, n12 + 110));
        this.dungeonsArea = new McTextArea(this, new Point(point2.x, n12 + 130), dimension);
        this.dungeonsArea.setText(String.join((CharSequence)", ", hskr2.getDungeons()));
        this.dungeonsArea.isEditable = true;
        this.addElement(this.dungeonsArea);
        GuiHelper.addButton(this, new Point(point2.x, n12 + 260), new Dimension(250, 30), "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0437\u0430\u0441\u043f\u0430\u0432\u043d\u0435\u043d\u043d\u044b\u0445 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439").onClick(guiActionButtonClick -> new ncxk(null, this.x, this.y, this.z, 1).sendToServer());
    }

    private void initAvailability(Point point) {
        GuiHelper.addButton(this, point.add(20, 240), new Dimension(150, 38), "\u0423\u0441\u043b\u043e\u0432\u0438\u044f").onClick(guiActionButtonClick -> {
            SubGuiNpcAvailability subGuiNpcAvailability = new SubGuiNpcAvailability(this.availability);
            subGuiNpcAvailability.parent2 = this;
            subGuiNpcAvailability.parent = this;
            xpzm._E()._a(subGuiNpcAvailability);
        });
        McCheckBox mcCheckBox = GuiHelper.createCheckBox(this, point.add(20, 220), "\u0420\u0430\u0441\u0448\u0438\u0440\u0435\u043d\u043d\u044b\u0439 \u0440\u0435\u0433\u0438\u043e\u043d \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0438");
        mcCheckBox.setActive(this.extendedCheck);
        this.actionManager.registerActionHandler(mcCheckBox, GuiActionCheckboxToggle.class, guiActionCheckboxToggle -> {
            this.extendedCheck = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
        });
        this.addElement(mcCheckBox);
    }

    private void initSpawnEntries(Point point) {
        if (this.spawnEntries == null) {
            this.spawnEntries = new ArrayList<TileNpcSpawner.NpcSpawnEntry>();
            for (qman qman2 : this.spawner.getConfiguration().getPossibleSpawnEntries()) {
                if (!(qman2 instanceof TileNpcSpawner.NpcSpawnEntry)) continue;
                this.spawnEntries.add((TileNpcSpawner.NpcSpawnEntry)qman2);
            }
        }
        this.addElement(new McLabel((IAdvancedGui)this, "\u041d\u043f\u0441 \u0434\u043b\u044f \u0441\u043f\u0430\u0432\u043d\u0430:", point.add(55, -350)));
        McScrollPane mcScrollPane = GuiHelper.addScrollPane(this, point.add(50, -300), new Dimension(320, 500), new Dimension(320, this.spawnEntries.size() * 33 + 30), true);
        int n = 0;
        for (TileNpcSpawner.NpcSpawnEntry npcSpawnEntry : this.spawnEntries) {
            if (npcSpawnEntry.npcId == -1) continue;
            int n2 = n++ * 33;
            String string = this.dupliNpcsNames.getOrDefault(npcSpawnEntry.npcId, String.valueOf(npcSpawnEntry.npcId));
            mcScrollPane.getViewport().addElement(new McLabel((IAdvancedGui)this, string, 5, n2));
            McNumberField mcNumberField = GuiHelper.createNumberField(this, new Point(200, n2), new Dimension(80, 27), (int)npcSpawnEntry.getSpawnWeight(), Integer.MAX_VALUE, 0L);
            this.actionManager.registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> npcSpawnEntry.setWeight(((McNumberField)guiActionTextFieldChanged.component).getValue()));
            mcScrollPane.getViewport().addElement(mcNumberField);
            McButton mcButton = GuiHelper.createButton(this, new Point(285, n2), new Dimension(15, 15), "X").onClick(guiActionButtonClick -> {
                this.spawnEntries.remove(npcSpawnEntry);
                this.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
            });
            mcScrollPane.getViewport().addElement(mcButton);
        }
        McButton mcButton = GuiHelper.createButton(this, new Point(0, n * 33), new Dimension(150, 30), "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.field_73882_e._a(new GuiDupliNpc(this, 0, true).setSelectionListener(n -> this.spawnEntries.add(new TileNpcSpawner.NpcSpawnEntry((int)n, 1.0f)))));
        mcScrollPane.getViewport().addElement(mcButton);
    }

    private void addNumberField(int n, int n2, String string, int n3, Consumer<Integer> consumer) {
        this.addElement(new McLabel((IAdvancedGui)this, string, n, n2));
        int n4 = 250;
        McNumberField mcNumberField = GuiHelper.createNumberField(this, new Point(n + n4, n2), new Dimension(100, 27), n3, Long.MAX_VALUE, Long.MIN_VALUE);
        mcNumberField.userData = consumer;
        this.addElement(mcNumberField);
        GuiHelper.addButton(this, new Point(n + n4 - 25, n2), new Dimension(20, 20), "-").onClick(guiActionButtonClick -> mcNumberField.setNumber(mcNumberField.getValue() - 1L));
        GuiHelper.addButton(this, new Point(n + n4 + 100 + 5, n2), new Dimension(20, 20), "+").onClick(guiActionButtonClick -> mcNumberField.setNumber(mcNumberField.getValue() + 1L));
    }

    private TileNpcSpawner getSpawner() {
        return (TileNpcSpawner)this.world.func_72796_p(this.x, this.y, this.z);
    }

    private void saveData() {
        Object object;
        TileNpcSpawner tileNpcSpawner = this.getSpawner();
        if (tileNpcSpawner == null) {
            return;
        }
        for (GuiComponent object22 : this.getElementsList()) {
            if (!(object22 instanceof McNumberField) || object22.userData == null || !(object22.userData instanceof Consumer)) continue;
            object = (Consumer)object22.userData;
            object.accept((int)((McNumberField)object22).getValue());
        }
        hskr hskr2 = tileNpcSpawner.getConfiguration();
        try {
            Integer[] numberFormatException = (Integer[])Stream.of(this.blocksArea.getText().split(",")).map(string -> Integer.parseInt(string.trim())).toArray(Integer[]::new);
            hskr2.setSufficientBlocks(numberFormatException);
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        hskr2.getDungeons().clear();
        List list2 = Stream.of(this.dungeonsArea.getText().split(",")).map(String::trim).collect(Collectors.toList());
        hskr2.getDungeons().addAll(list2);
        hskr2.getPossibleSpawnEntries().clear();
        hskr2.getPossibleSpawnEntries().addAll(this.spawnEntries);
        tileNpcSpawner.extendedCheck = this.extendedCheck;
        tileNpcSpawner.availabilityCheck = this.availability.copy();
        object = new qoac();
        tileNpcSpawner.func_70310_b((qoac)object);
        new ncxk((qoac)object, this.x, this.y, this.z, 0).sendToServer();
    }

    @Override
    public void func_73874_b() {
        super.func_73874_b();
        new ncxk(null, this.x, this.y, this.z, 3).sendToServer();
    }

    @Override
    public void update(List<NpcSynchronizer.DupliNpcEntry> list2) {
        this.dupliNpcsNames.clear();
        for (NpcSynchronizer.DupliNpcEntry dupliNpcEntry : list2) {
            this.dupliNpcsNames.put(dupliNpcEntry.id, dupliNpcEntry.name);
        }
        this.func_73872_a(this.field_73882_e, this.field_73880_f, this.field_73881_g);
    }
}

