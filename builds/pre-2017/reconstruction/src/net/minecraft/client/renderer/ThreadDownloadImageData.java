/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import mcoptifine.ThreadDownloadImage;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.util.ResourceLocation;

public class ThreadDownloadImageData
extends zhix {
    public final String _a;
    public final xbbs _b;
    public BufferedImage _c;
    public Thread _d;
    public cegk _e;
    public boolean _f;
    public boolean _g = true;

    public ThreadDownloadImageData(String string, ResourceLocation resourceLocation, xbbs xbbs2) {
        this._a = string;
        this._b = xbbs2;
        this._e = resourceLocation != null ? new cegk(resourceLocation) : null;
    }

    @Override
    public int getGlTextureId() {
        int n = super.getGlTextureId();
        if (!this._f && this._c != null) {
            bsfn._a(n, this._c);
            this._f = true;
        }
        return n;
    }

    public void _a(BufferedImage bufferedImage) {
        this._c = bufferedImage;
    }

    @Override
    public void loadTexture(ResourceManager resourceManager) throws IOException {
        if (this._c == null) {
            if (this._e != null) {
                this._e.loadTexture(resourceManager);
                this._h = this._e.getGlTextureId();
            }
        } else {
            bsfn._a(this.getGlTextureId(), this._c);
        }
        if (this._d == null) {
            this._d = new hcta(this);
            this._d.setDaemon(true);
            this._d.setName("Skin downloader: " + this._a);
            this._d.start();
            try {
                URL uRL = new URL(this._a);
                String string = uRL.getPath();
                String string2 = "/MinecraftSkins/";
                String string3 = "/MinecraftCloaks/";
                if (string.startsWith(string3)) {
                    String string4 = string.substring(string3.length());
                    String string5 = "http://s.optifine.net/capes/" + string4;
                    ThreadDownloadImage threadDownloadImage = new ThreadDownloadImage(this, string5, new scss());
                    threadDownloadImage.setDaemon(true);
                    threadDownloadImage.setName("Cape downloader: " + this._a);
                    threadDownloadImage.start();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public boolean _a() {
        if (!this._g) {
            return false;
        }
        this.getGlTextureId();
        return this._f;
    }

    public static String _a(ThreadDownloadImageData threadDownloadImageData) {
        return threadDownloadImageData._a;
    }

    public static xbbs _b(ThreadDownloadImageData threadDownloadImageData) {
        return threadDownloadImageData._b;
    }
}

