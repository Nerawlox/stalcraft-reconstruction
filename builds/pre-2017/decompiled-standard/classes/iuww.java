/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.engine.Point;
import java.util.concurrent.TimeUnit;

public abstract class iuww {
    public static final long DEFAULT_EXPIRATION_TIME = TimeUnit.DAYS.toMillis(7L);
    public final String channelId;
    private String title;
    private long expirationTime;

    public iuww(String string, String string2, long l) {
        this.title = string;
        this.channelId = string2;
        this.expirationTime = l;
        ycdg._a(this);
    }

    public iuww(String string, String string2) {
        this(string, string2, DEFAULT_EXPIRATION_TIME);
    }

    public bqdo createNotification(qoac qoac2) {
        long l = System.currentTimeMillis();
        long l2 = this.expirationTime < 0L ? -1L : l + this.expirationTime;
        return new bqdo(this.channelId, l, l2, qoac2);
    }

    @ezey(_a={eidj.CLIENT})
    public Point getIcon(bqdo bqdo2) {
        return new Point(0, 48);
    }

    public long getExpirationTime(bqdo bqdo2) {
        return this.expirationTime;
    }

    public String getTitle(bqdo bqdo2) {
        return this.title;
    }

    public String getConfirmationText(bqdo bqdo2) {
        return this.getInfoText(bqdo2);
    }

    public abstract String getInfoText(bqdo var1);

    @ezey(_a={eidj.CLIENT})
    public abstract kjui getViewType(bqdo var1);

    @ezey(_a={eidj.CLIENT})
    public abstract void onAction(bqdo var1, boolean var2);

    public String getChannelId() {
        return this.channelId;
    }

    public String getTitle() {
        return this.title;
    }

    public static enum kjui {
        _a,
        _b,
        _c;

    }
}

