/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.events;

import java.io.File;
import net.minecraft.client.xpzm;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;
import noppes.npcs.CustomNpcs;

public class TextureLoadEvent {
    @ForgeSubscribe
    public void invoke(TextureStitchEvent.Post post) {
        File file;
        File file2 = new File(CustomNpcs.Dir, "assets/customnpcs");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!(file = new File(file2, "sound")).exists()) {
            file.mkdir();
        }
        if (!(file = new File(file2, "music")).exists()) {
            file.mkdir();
        }
        if (!(file = new File(file2, "textures")).exists()) {
            file.mkdir();
        }
        scvi scvi2 = (scvi)xpzm._E()._S();
        yvjs yvjs2 = new yvjs(CustomNpcs.Dir);
        scvi2._a(yvjs2);
    }
}

