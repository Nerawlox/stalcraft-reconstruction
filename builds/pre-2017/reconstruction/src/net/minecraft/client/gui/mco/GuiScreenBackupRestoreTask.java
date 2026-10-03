/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.mco;

import net.minecraft.client.gui.TaskLongRunning;
import net.minecraft.client.mco.Backup;
import net.minecraft.client.mco.ExceptionMcoService;

public class GuiScreenBackupRestoreTask
extends TaskLongRunning {
    public final Backup _b;
    public final /* synthetic */ scox _c;

    public GuiScreenBackupRestoreTask(scox scox2, Backup backup) {
        this._c = scox2;
        this._b = backup;
    }

    @Override
    public void run() {
        this._b(wpcz._a("mco.backup.restoring"));
        try {
            rqmi rqmi2 = new rqmi(this._a()._P());
            rqmi2._c(scox._b(this._c), this._b._a);
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            this._a()._a(scox._d(this._c));
        }
        catch (ExceptionMcoService exceptionMcoService) {
            scox._e(this._c)._O()._c(exceptionMcoService.toString());
            this._a(exceptionMcoService.toString());
        }
        catch (Exception exception) {
            this._a(exception.getLocalizedMessage());
        }
    }

    public /* synthetic */ GuiScreenBackupRestoreTask(scox scox2, Backup backup, nvcw nvcw2) {
        this(scox2, backup);
    }
}

