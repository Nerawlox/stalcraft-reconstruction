/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import com.google.common.collect.Sets;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import noppes.npcs.client.gui.global.GuiNPCManageDialogs;
import noppes.npcs.client.gui.global.GuiNPCManageQuest;
import noppes.npcs.controllers.DialogCategory;
import noppes.npcs.controllers.QuestCategory;
import org.apache.commons.lang3.ArrayUtils;

public class PacketUnusedCategories
extends zwat {
    private int[] unusedCategoryIds;

    public static PacketUnusedCategories createQuests(Collection<QuestCategory> collection) {
        return new PacketUnusedCategories(collection.stream().filter(questCategory -> questCategory.markedUnused).map(questCategory -> questCategory.id).collect(Collectors.toList()));
    }

    public static PacketUnusedCategories createDialogs(Collection<DialogCategory> collection) {
        return new PacketUnusedCategories(collection.stream().filter(dialogCategory -> dialogCategory.markedUnused).map(dialogCategory -> dialogCategory.id).collect(Collectors.toList()));
    }

    private PacketUnusedCategories(List<Integer> list) {
        this.unusedCategoryIds = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            this.unusedCategoryIds[i] = list.get(i);
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.unusedCategoryIds.length);
        for (int i = 0; i < this.unusedCategoryIds.length; ++i) {
            dataOutput.writeInt(this.unusedCategoryIds[i]);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.unusedCategoryIds = new int[dataInput.readInt()];
        for (int i = 0; i < this.unusedCategoryIds.length; ++i) {
            this.unusedCategoryIds[i] = dataInput.readInt();
        }
    }

    @Override
    public void processClient(boolean bl) {
        GuiScreen guiScreen = Minecraft._E()._B;
        HashSet<Integer> hashSet = Sets.newHashSet(ArrayUtils.toObject(this.unusedCategoryIds));
        if (guiScreen instanceof GuiNPCManageQuest) {
            ((GuiNPCManageQuest)guiScreen).unusedCategories = hashSet;
        } else if (guiScreen instanceof GuiNPCManageDialogs) {
            ((GuiNPCManageDialogs)guiScreen).unusedCategories = hashSet;
        }
    }

    public PacketUnusedCategories() {
    }
}

