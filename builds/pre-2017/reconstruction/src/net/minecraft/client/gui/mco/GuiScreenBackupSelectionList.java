/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.mco;

import java.text.DateFormat;
import java.util.Date;
import net.minecraft.client.mco.Backup;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.server.MinecraftServer;

public class GuiScreenBackupSelectionList
extends maxt {
    public final /* synthetic */ scox _u;

    public GuiScreenBackupSelectionList(scox scox2) {
        this._u = scox2;
        super(scox._f(scox2), scox2.width, scox2.height, 32, scox2.height - 64, 36);
    }

    @Override
    public int _a() {
        return scox._g(this._u).size() + 1;
    }

    @Override
    public void _a(int n, boolean bl) {
        if (n >= scox._g(this._u).size()) {
            return;
        }
        scox._a(this._u, n);
    }

    @Override
    public boolean _a(int n) {
        return n == scox._h(this._u);
    }

    @Override
    public boolean _b(int n) {
        return false;
    }

    @Override
    public int _b() {
        return this._a() * 36;
    }

    @Override
    public void _c() {
        this._u.drawDefaultBackground();
    }

    @Override
    public void _a(int n, int n2, int n3, int n4, Tessellator tessellator) {
        if (n < scox._g(this._u).size()) {
            this._b(n, n2, n3, n4, tessellator);
        }
    }

    public void _b(int n, int n2, int n3, int n4, Tessellator tessellator) {
        Backup backup = (Backup)scox._g(this._u).get(n);
        this._u.drawString(scox._i(this._u), "Backup (" + this._a(MinecraftServer.__aq() - backup._b.getTime()) + ")", n2 + 2, n3 + 1, 0xFFFFFF);
        this._u.drawString(scox._j(this._u), this._a(backup._b), n2 + 2, n3 + 12, 0x6C6C6C);
    }

    public String _a(Date date) {
        return DateFormat.getDateTimeInstance(3, 3).format(date);
    }

    public String _a(Long l) {
        if (l < 0L) {
            return "right now";
        }
        long l2 = l / 1000L;
        if (l2 < 60L) {
            return (l2 == 1L ? "1 second" : l2 + " seconds") + " ago";
        }
        if (l2 < 3600L) {
            long l3 = l2 / 60L;
            return (l3 == 1L ? "1 minute" : l3 + " minutes") + " ago";
        }
        if (l2 < 86400L) {
            long l4 = l2 / 3600L;
            return (l4 == 1L ? "1 hour" : l4 + " hours") + " ago";
        }
        long l5 = l2 / 86400L;
        return (l5 == 1L ? "1 day" : l5 + " days") + " ago";
    }
}

