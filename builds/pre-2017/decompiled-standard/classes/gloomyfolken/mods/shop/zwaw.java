/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop;

import net.minecraftforge.common.Configuration;

public class zwaw {
    public String _a;
    public String _b;
    public String _c;
    public eidj[] _d;
    public pidb _e = new pidb();
    public kjui _f = new kjui();
    public int _g;

    public zwaw(Configuration configuration) {
        String string = configuration.get("general", "db_url", "127.0.0.1:3306").getString();
        String string2 = configuration.get("general", "db_name", "dbname").getString();
        this._a = "jdbc:mysql://" + string + "/" + string2;
        this._b = configuration.get("general", "db_user", "admin").getString();
        this._c = configuration.get("general", "db_password", "qwerty").getString();
        this._g = configuration.get("general", "server_id", 0).getInt();
        String[] stringArray = configuration.get("general", "db_tables", new String[]{"money:user:amount:1:true", "realmoney:user:amount:1:false"}).getStringList();
        this._d = new eidj[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            String[] stringArray2 = stringArray[i].split(":");
            this._d[i] = new eidj(stringArray2[0], stringArray2[1], stringArray2[2], Float.parseFloat(stringArray2[3]), Boolean.parseBoolean(stringArray2[4]));
        }
    }

    public static class kjui {
        public final String _a = "ms_case_buy_log";
        public final String _b = "username";
        public final String _c = "case_id";
        public final String _d = "price";
        public final String _e = "paid";
        public final String _f = "server_id";
    }

    public static class pidb {
        public final String _a = "ms_ingame_shop_log";
        public final String _b = "username";
        public final String _c = "item_id";
        public final String _d = "item_durability";
        public final String _e = "stack_size";
        public final String _f = "item_name";
        public final String _g = "nbt_json";
        public final String _h = "price";
        public final String _i = "paid";
        public final String _j = "retrieved";
        public final String _k = "date";
        public final String _l = "operation";
        public final String _m = "server_id";
    }

    public static class eidj {
        public final String _a;
        public final String _b;
        public final String _c;
        public final float _d;
        public final boolean _e;

        public eidj(String string, String string2, String string3, float f, boolean bl) {
            this._a = string;
            this._b = string2;
            this._c = string3;
            this._d = f;
            this._e = bl;
        }
    }
}

