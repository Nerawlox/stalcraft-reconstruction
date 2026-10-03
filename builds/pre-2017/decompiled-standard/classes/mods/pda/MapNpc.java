/*
 * Decompiled with CFR 0.152.
 */
package mods.pda;

import com.google.common.collect.ImmutableMap;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.engine.Point;
import java.util.Map;
import java.util.Objects;
import mods.pda.client.PdaClient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import noppes.npcs.constants.EnumJobType;
import noppes.npcs.constants.EnumRoleType;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.util.vector.Vector2f;
import znw.mods.auction.AuctionMod;

public class MapNpc {
    public static final ResourceLocation ICON_RES = new ResourceLocation("pda", "textures/gui/npc_icons.png");
    public static Map<EnumRoleType, Pair<String, String>> roleIconProps = ImmutableMap.builder().put(EnumRoleType.Postman, Pair.of("\u041a\u0443\u0440\u044c\u0435\u0440", "mail")).put(EnumRoleType.Auctioneer, Pair.of("\u0410\u0443\u043a\u0446\u0438\u043e\u043d\u0435\u0440", "auctioneer")).put(EnumRoleType.Trader, Pair.of("\u0422\u043e\u0440\u0433\u043e\u0432\u0435\u0446", "trader")).put(EnumRoleType.Exchanger, Pair.of("\u041e\u0431\u043c\u0435\u043d\u043d\u0438\u043a", "barter")).put(EnumRoleType.Researcher, Pair.of("\u0418\u0441\u0441\u043b\u0435\u0434\u043e\u0432\u0430\u0442\u0435\u043b\u044c", "researcher")).put(EnumRoleType.Bank, Pair.of("\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435", "bank")).put(EnumRoleType.Supplier, Pair.of("\u041f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a", "trader")).put(EnumRoleType.Guide, Pair.of("\u041f\u0440\u043e\u0432\u043e\u0434\u043d\u0438\u043a", "guide")).build();
    public final int entityId;
    public final EnumRoleType role;
    public final float xPos;
    public final float yPos;
    public final float zPos;
    public EnumJobType job;
    public String iconName;
    public boolean confirmed;
    public String name;
    public boolean cloned;
    public String creator;
    public String owner;
    public String approver;

    public MapNpc(EnumRoleType enumRoleType, int n, String string, float f, float f2, float f3) {
        this.role = enumRoleType;
        this.entityId = n;
        this.iconName = string;
        this.xPos = f;
        this.yPos = f2;
        this.zPos = f3;
    }

    public MapNpc(EnumRoleType enumRoleType, EnumJobType enumJobType, float f, float f2, boolean bl, String string, boolean bl2, String string2, String string3, String string4) {
        this.entityId = 0;
        this.role = enumRoleType;
        this.job = enumJobType;
        this.xPos = f;
        this.yPos = 0.0f;
        this.zPos = f2;
        this.confirmed = bl;
        this.name = string;
        this.cloned = bl2;
        this.creator = string2;
        this.owner = string3;
        this.approver = string4;
    }

    public EnumRoleType getRole() {
        return this.role;
    }

    @ezey(_a={eidj.CLIENT})
    public Vector2f getLoc() {
        return new Vector2f(this.xPos, this.zPos);
    }

    @ezey(_a={eidj.CLIENT})
    public String getDisplayText() {
        String string;
        Pair<String, String> pair = roleIconProps.get((Object)this.role);
        String string2 = string = pair != null ? pair.getLeft() : wpcz._a(this.role.getTitle());
        if (this.role == EnumRoleType.Postman && AuctionMod.instance._b > 0) {
            string = string + "\n" + (Object)((Object)ezfc._o) + "\u041d\u0435\u043f\u0440\u043e\u0447\u0438\u0442\u0430\u043d\u043d\u044b\u0445 \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0439: " + AuctionMod.instance._b;
        }
        return string;
    }

    @ezey(_a={eidj.CLIENT})
    public int getColor() {
        if (this.role == EnumRoleType.Supplier) {
            return -27904;
        }
        if (this.role == EnumRoleType.Postman && AuctionMod.instance._b > 0) {
            return -16711936;
        }
        return -1;
    }

    @ezey(_a={eidj.CLIENT})
    public Point getTextureUv() {
        String string;
        String string2 = string = this.iconName.isEmpty() ? roleIconProps.get((Object)this.role).getRight() : this.iconName;
        if (string == null || string.isEmpty()) {
            return null;
        }
        return PdaClient.NPC_ICONS_POS.get(string);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        MapNpc mapNpc = (MapNpc)object;
        return this.role == mapNpc.role && this.xPos == mapNpc.xPos && this.zPos == this.zPos;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.role, Float.valueOf(this.xPos), Float.valueOf(this.zPos)});
    }
}

