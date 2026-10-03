/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model;

public interface IModelCustom {
    public String getType();

    public void renderAll();

    public void renderOnly(String ... var1);

    public void renderPart(String var1);

    public void renderAllExcept(String ... var1);
}

