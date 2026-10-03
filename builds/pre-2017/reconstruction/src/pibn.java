/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b\u00a8\u0006("}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldGlobalConfig;", "", "()V", "assistScorePoints", "", "getAssistScorePoints", "()I", "setAssistScorePoints", "(I)V", "captureFinishScorePoints", "getCaptureFinishScorePoints", "setCaptureFinishScorePoints", "capturePointCoverageScorePoints", "getCapturePointCoverageScorePoints", "setCapturePointCoverageScorePoints", "captureProgresScorePoints", "getCaptureProgresScorePoints", "setCaptureProgresScorePoints", "damageDealtScorePoints", "", "getDamageDealtScorePoints", "()F", "setDamageDealtScorePoints", "(F)V", "killResourcesAmount", "getKillResourcesAmount", "setKillResourcesAmount", "killResourcesFrequency", "getKillResourcesFrequency", "setKillResourcesFrequency", "killScorePoints", "getKillScorePoints", "setKillScorePoints", "spotScorePoints", "getSpotScorePoints", "setSpotScorePoints", "readFrom", "", "json", "", "minecraft"})
public final class pibn {
    private static int _b;
    private static int _c;
    private static int _d;
    private static int _e;
    private static int _f;
    private static int _g;
    private static float _h;
    private static int _i;
    private static int _j;
    public static final pibn _a;

    public final int _a() {
        return _b;
    }

    public final void _a(int n) {
        _b = n;
    }

    public final int _b() {
        return _c;
    }

    public final void _b(int n) {
        _c = n;
    }

    public final int _c() {
        return _d;
    }

    public final void _c(int n) {
        _d = n;
    }

    public final int _d() {
        return _e;
    }

    public final void _d(int n) {
        _e = n;
    }

    public final int _e() {
        return _f;
    }

    public final void _e(int n) {
        _f = n;
    }

    public final int _f() {
        return _g;
    }

    public final void _f(int n) {
        _g = n;
    }

    public final float _g() {
        return _h;
    }

    public final void _a(float f) {
        _h = f;
    }

    public final int _h() {
        return _i;
    }

    public final void _g(int n) {
        _i = n;
    }

    public final int _i() {
        return _j;
    }

    public final void _h(int n) {
        _j = n;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "json");
        JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
        JsonElement jsonElement = jsonObject.get("kill_resource_points");
        _b = jsonElement != null ? jsonElement.getAsInt() : 1;
        JsonElement jsonElement2 = jsonObject.get("kill_resources_freq_m");
        _c = jsonElement2 != null ? jsonElement2.getAsInt() : 60;
        JsonElement jsonElement3 = jsonObject.get("kill_score_points");
        _d = jsonElement3 != null ? jsonElement3.getAsInt() : 0;
        JsonElement jsonElement4 = jsonObject.get("assist_score_points");
        _e = jsonElement4 != null ? jsonElement4.getAsInt() : 0;
        JsonElement jsonElement5 = jsonObject.get("capture_progress_score_points");
        _f = jsonElement5 != null ? jsonElement5.getAsInt() : 0;
        JsonElement jsonElement6 = jsonObject.get("capture_finished_score_points");
        _g = jsonElement6 != null ? jsonElement6.getAsInt() : 0;
        JsonElement jsonElement7 = jsonObject.get("damage_dealt_score_points_k");
        _h = jsonElement7 != null ? jsonElement7.getAsFloat() : 0.0f;
        JsonElement jsonElement8 = jsonObject.get("spot_score_points");
        _i = jsonElement8 != null ? jsonElement8.getAsInt() : 0;
        JsonElement jsonElement9 = jsonObject.get("capture_point_coverage_score_points");
        _j = jsonElement9 != null ? jsonElement9.getAsInt() : 0;
    }

    private pibn() {
        _a = this;
    }

    static {
        new pibn();
    }
}

