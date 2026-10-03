/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.io.File;

public class WorldSpecificSaveHandler
implements mtms {
    private yfgy world;
    private mtms parent;
    private File dataDir;

    public WorldSpecificSaveHandler(yfgy yfgy2, mtms mtms2) {
        this.world = yfgy2;
        this.parent = mtms2;
        this.dataDir = new File(yfgy2.getChunkSaveLocation(), "data");
        this.dataDir.mkdirs();
    }

    @Override
    public iyev func_75757_d() {
        return this.parent.func_75757_d();
    }

    @Override
    public void func_75762_c() throws xcad {
        this.parent.func_75762_c();
    }

    @Override
    public bcgt func_75763_a(rrte rrte2) {
        return this.parent.func_75763_a(rrte2);
    }

    @Override
    public void func_75755_a(iyev iyev2, qoac qoac2) {
        this.parent.func_75755_a(iyev2, qoac2);
    }

    @Override
    public void func_75761_a(iyev iyev2) {
        this.parent.func_75761_a(iyev2);
    }

    @Override
    public lqjs func_75756_e() {
        return this.parent.func_75756_e();
    }

    @Override
    public void func_75759_a() {
        this.parent.func_75759_a();
    }

    @Override
    public String func_75760_g() {
        return this.parent.func_75760_g();
    }

    @Override
    public File func_75758_b(String string) {
        return new File(this.dataDir, string + ".dat");
    }
}

