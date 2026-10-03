/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.xpzm;
import noppes.npcs.blocks.TileNpcSpawner;
import noppes.npcs.client.gui.GuiNpcSpawnerEdit;

public class BlockNpcSpawner
extends ieal {
    public BlockNpcSpawner(int n) {
        super(n);
        this.func_71864_b("npc_spawner");
        LanguageRegistry.addName(this, "\u0421\u043f\u0430\u0432\u043d\u0435\u0440 \u043d\u043f\u0441");
    }

    @Override
    protected void openEditGui(ozlu ozlu2, int n, int n2, int n3) {
        xpzm._E()._a(new GuiNpcSpawnerEdit(ozlu2, n, n2, n3));
    }

    @Override
    protected bqyt createSpawnerTileEntity() {
        return new TileNpcSpawner();
    }
}

