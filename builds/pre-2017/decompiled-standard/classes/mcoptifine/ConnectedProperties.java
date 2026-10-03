/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.ArrayList;
import java.util.Properties;
import mcoptifine.Config;
import mcoptifine.TextureUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;

public class ConnectedProperties {
    public String name = null;
    public String basePath = null;
    public int[] matchBlocks = null;
    public String[] matchTiles = null;
    public int method = 0;
    public String[] tiles = null;
    public int connect = 0;
    public int faces = 63;
    public int[] metadatas = null;
    public foqh[] biomes = null;
    public int minHeight = 0;
    public int maxHeight = 1024;
    public int renderPass = 0;
    public boolean innerSeams = false;
    public int width = 0;
    public int height = 0;
    public int[] weights = null;
    public int symmetry = 1;
    public int[] sumWeights = null;
    public int sumAllWeights = 0;
    public dwan[] matchTileIcons = null;
    public dwan[] tileIcons = null;
    public static final int METHOD_NONE = 0;
    public static final int METHOD_CTM = 1;
    public static final int METHOD_HORIZONTAL = 2;
    public static final int METHOD_TOP = 3;
    public static final int METHOD_RANDOM = 4;
    public static final int METHOD_REPEAT = 5;
    public static final int METHOD_VERTICAL = 6;
    public static final int METHOD_FIXED = 7;
    public static final int CONNECT_NONE = 0;
    public static final int CONNECT_BLOCK = 1;
    public static final int CONNECT_TILE = 2;
    public static final int CONNECT_MATERIAL = 3;
    public static final int CONNECT_UNKNOWN = 128;
    public static final int FACE_BOTTOM = 1;
    public static final int FACE_TOP = 2;
    public static final int FACE_EAST = 4;
    public static final int FACE_WEST = 8;
    public static final int FACE_NORTH = 16;
    public static final int FACE_SOUTH = 32;
    public static final int FACE_SIDES = 60;
    public static final int FACE_ALL = 63;
    public static final int FACE_UNKNOWN = 128;
    public static final int SYMMETRY_NONE = 1;
    public static final int SYMMETRY_OPPOSITE = 2;
    public static final int SYMMETRY_ALL = 6;
    public static final int SYMMETRY_UNKNOWN = 128;

    public ConnectedProperties(Properties properties, String string) {
        this.name = ConnectedProperties.parseName(string);
        this.basePath = ConnectedProperties.parseBasePath(string);
        this.matchBlocks = ConnectedProperties.parseInts(properties.getProperty("matchBlocks"));
        this.matchTiles = this.parseMatchTiles(properties.getProperty("matchTiles"));
        this.method = ConnectedProperties.parseMethod(properties.getProperty("method"));
        this.tiles = this.parseTileNames(properties.getProperty("tiles"));
        this.connect = ConnectedProperties.parseConnect(properties.getProperty("connect"));
        this.faces = ConnectedProperties.parseFaces(properties.getProperty("faces"));
        this.metadatas = ConnectedProperties.parseInts(properties.getProperty("metadata"));
        this.biomes = ConnectedProperties.parseBiomes(properties.getProperty("biomes"));
        this.minHeight = ConnectedProperties.parseInt(properties.getProperty("minHeight"), -1);
        this.maxHeight = ConnectedProperties.parseInt(properties.getProperty("maxHeight"), 1024);
        this.renderPass = ConnectedProperties.parseInt(properties.getProperty("renderPass"));
        this.innerSeams = ConnectedProperties.parseBoolean(properties.getProperty("innerSeams"));
        this.width = ConnectedProperties.parseInt(properties.getProperty("width"));
        this.height = ConnectedProperties.parseInt(properties.getProperty("height"));
        this.weights = ConnectedProperties.parseInts(properties.getProperty("weights"));
        this.symmetry = ConnectedProperties.parseSymmetry(properties.getProperty("symmetry"));
    }

    private String[] parseMatchTiles(String string) {
        if (string == null) {
            return null;
        }
        String[] stringArray = Config.tokenize(string, " ");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (string2.endsWith(".png")) {
                string2 = string2.substring(0, string2.length() - 4);
            }
            stringArray[i] = string2 = TextureUtils.fixResourcePath(string2, this.basePath);
        }
        return stringArray;
    }

    private static String parseName(String string) {
        int n;
        String string2 = string;
        int n2 = string.lastIndexOf(47);
        if (n2 >= 0) {
            string2 = string.substring(n2 + 1);
        }
        if ((n = string2.lastIndexOf(46)) >= 0) {
            string2 = string2.substring(0, n);
        }
        return string2;
    }

    private static String parseBasePath(String string) {
        int n = string.lastIndexOf(47);
        return n < 0 ? "" : string.substring(0, n);
    }

    private static foqh[] parseBiomes(String string) {
        if (string == null) {
            return null;
        }
        String[] stringArray = Config.tokenize(string, " ");
        ArrayList<foqh> arrayList = new ArrayList<foqh>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            foqh foqh2 = ConnectedProperties.findBiome(string2);
            if (foqh2 == null) {
                Config.warn("Biome not found: " + string2);
                continue;
            }
            arrayList.add(foqh2);
        }
        foqh[] foqhArray = arrayList.toArray(new foqh[arrayList.size()]);
        return foqhArray;
    }

    private static foqh findBiome(String string) {
        string = string.toLowerCase();
        for (int i = 0; i < foqh._a.length; ++i) {
            String string2;
            foqh foqh2 = foqh._a[i];
            if (foqh2 == null || !(string2 = foqh2._y.replace(" ", "").toLowerCase()).equals(string)) continue;
            return foqh2;
        }
        return null;
    }

    private String[] parseTileNames(String string) {
        Object object;
        if (string == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = Config.tokenize(string, " ,");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (string2.contains("-") && ((String[])(object = Config.tokenize(string2, "-"))).length == 2) {
                int n = Config.parseInt(object[0], -1);
                int n2 = Config.parseInt(object[1], -1);
                if (n >= 0 && n2 >= 0) {
                    if (n <= n2) {
                        for (int j = n; j <= n2; ++j) {
                            arrayList.add(String.valueOf(j));
                        }
                        continue;
                    }
                    Config.warn("Invalid interval: " + string2 + ", when parsing: " + string);
                    continue;
                }
            }
            arrayList.add(string2);
        }
        String[] stringArray2 = arrayList.toArray(new String[arrayList.size()]);
        for (int i = 0; i < stringArray2.length; ++i) {
            String string3;
            object = stringArray2[i];
            if (!(((String)(object = TextureUtils.fixResourcePath((String)object, this.basePath))).startsWith(this.basePath) || ((String)object).startsWith("textures/") || ((String)object).startsWith("mcpatcher/"))) {
                object = this.basePath + "/" + (String)object;
            }
            if (((String)object).endsWith(".png")) {
                object = ((String)object).substring(0, ((String)object).length() - 4);
            }
            if (((String)object).startsWith(string3 = "textures/blocks/")) {
                object = ((String)object).substring(string3.length());
            }
            if (((String)object).startsWith("/")) {
                object = ((String)object).substring(1);
            }
            stringArray2[i] = object;
        }
        return stringArray2;
    }

    private static int parseInt(String string) {
        if (string == null) {
            return -1;
        }
        int n = Config.parseInt(string, -1);
        if (n < 0) {
            Config.warn("Invalid number: " + string);
        }
        return n;
    }

    private static int parseInt(String string, int n) {
        if (string == null) {
            return n;
        }
        int n2 = Config.parseInt(string, -1);
        if (n2 < 0) {
            Config.warn("Invalid number: " + string);
            return n;
        }
        return n2;
    }

    private static boolean parseBoolean(String string) {
        return string == null ? false : string.toLowerCase().equals("true");
    }

    private static int parseSymmetry(String string) {
        if (string == null) {
            return 1;
        }
        if (string.equals("opposite")) {
            return 2;
        }
        if (string.equals("all")) {
            return 6;
        }
        Config.warn("Unknown symmetry: " + string);
        return 1;
    }

    private static int parseFaces(String string) {
        if (string == null) {
            return 63;
        }
        String[] stringArray = Config.tokenize(string, " ,");
        int n = 0;
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            int n2 = ConnectedProperties.parseFace(string2);
            n |= n2;
        }
        return n;
    }

    private static int parseFace(String string) {
        if ((string = string.toLowerCase()).equals("bottom")) {
            return 1;
        }
        if (string.equals("top")) {
            return 2;
        }
        if (string.equals("north")) {
            return 4;
        }
        if (string.equals("south")) {
            return 8;
        }
        if (string.equals("east")) {
            return 32;
        }
        if (string.equals("west")) {
            return 16;
        }
        if (string.equals("sides")) {
            return 60;
        }
        if (string.equals("all")) {
            return 63;
        }
        Config.warn("Unknown face: " + string);
        return 128;
    }

    private static int parseConnect(String string) {
        if (string == null) {
            return 0;
        }
        if (string.equals("block")) {
            return 1;
        }
        if (string.equals("tile")) {
            return 2;
        }
        if (string.equals("material")) {
            return 3;
        }
        Config.warn("Unknown connect: " + string);
        return 128;
    }

    private static int[] parseInts(String string) {
        if (string == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        String[] stringArray = Config.tokenize(string, " ,");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (string2.contains("-")) {
                String[] stringArray2 = Config.tokenize(string2, "-");
                if (stringArray2.length != 2) {
                    Config.warn("Invalid interval: " + string2 + ", when parsing: " + string);
                    continue;
                }
                int n = Config.parseInt(stringArray2[0], -1);
                int n2 = Config.parseInt(stringArray2[1], -1);
                if (n >= 0 && n2 >= 0 && n <= n2) {
                    for (int j = n; j <= n2; ++j) {
                        arrayList.add(j);
                    }
                    continue;
                }
                Config.warn("Invalid interval: " + string2 + ", when parsing: " + string);
                continue;
            }
            int n = Config.parseInt(string2, -1);
            if (n < 0) {
                Config.warn("Invalid number: " + string2 + ", when parsing: " + string);
                continue;
            }
            arrayList.add(n);
        }
        int[] nArray = new int[arrayList.size()];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = (Integer)arrayList.get(i);
        }
        return nArray;
    }

    private static int parseMethod(String string) {
        if (string == null) {
            return 1;
        }
        if (!string.equals("ctm") && !string.equals("glass")) {
            if (!string.equals("horizontal") && !string.equals("bookshelf")) {
                if (string.equals("vertical")) {
                    return 6;
                }
                if (string.equals("top")) {
                    return 3;
                }
                if (string.equals("random")) {
                    return 4;
                }
                if (string.equals("repeat")) {
                    return 5;
                }
                if (string.equals("fixed")) {
                    return 7;
                }
                Config.warn("Unknown method: " + string);
                return 0;
            }
            return 2;
        }
        return 1;
    }

    public boolean isValid(String string) {
        if (this.name != null && this.name.length() > 0) {
            if (this.basePath == null) {
                Config.warn("No base path found: " + string);
                return false;
            }
            if (this.matchBlocks == null) {
                this.matchBlocks = this.detectMatchBlocks();
            }
            if (this.matchTiles == null && this.matchBlocks == null) {
                this.matchTiles = this.detectMatchTiles();
            }
            if (this.matchBlocks == null && this.matchTiles == null) {
                Config.warn("No matchBlocks or matchTiles specified: " + string);
                return false;
            }
            if (this.method == 0) {
                Config.warn("No method: " + string);
                return false;
            }
            if (this.tiles != null && this.tiles.length > 0) {
                if (this.connect == 0) {
                    this.connect = this.detectConnect();
                }
                if (this.connect == 128) {
                    Config.warn("Invalid connect in: " + string);
                    return false;
                }
                if (this.renderPass > 0) {
                    Config.warn("Render pass not supported: " + this.renderPass);
                    return false;
                }
                if ((this.faces & 0x80) != 0) {
                    Config.warn("Invalid faces in: " + string);
                    return false;
                }
                if ((this.symmetry & 0x80) != 0) {
                    Config.warn("Invalid symmetry in: " + string);
                    return false;
                }
                switch (this.method) {
                    case 1: {
                        return this.isValidCtm(string);
                    }
                    case 2: {
                        return this.isValidHorizontal(string);
                    }
                    case 3: {
                        return this.isValidTop(string);
                    }
                    case 4: {
                        return this.isValidRandom(string);
                    }
                    case 5: {
                        return this.isValidRepeat(string);
                    }
                    case 6: {
                        return this.isValidVertical(string);
                    }
                    case 7: {
                        return this.isValidFixed(string);
                    }
                }
                Config.warn("Unknown method: " + string);
                return false;
            }
            Config.warn("No tiles specified: " + string);
            return false;
        }
        Config.warn("No name found: " + string);
        return false;
    }

    private int detectConnect() {
        return this.matchBlocks != null ? 1 : (this.matchTiles != null ? 2 : 128);
    }

    private int[] detectMatchBlocks() {
        int[] nArray;
        int n;
        char c;
        int n2;
        if (!this.name.startsWith("block")) {
            return null;
        }
        for (n2 = n = "block".length(); n2 < this.name.length() && (c = this.name.charAt(n2)) >= '0' && c <= '9'; ++n2) {
        }
        if (n2 == n) {
            return null;
        }
        String string = this.name.substring(n, n2);
        int n3 = Config.parseInt(string, -1);
        if (n3 < 0) {
            nArray = null;
        } else {
            int[] nArray2 = new int[1];
            nArray = nArray2;
            nArray2[0] = n3;
        }
        return nArray;
    }

    private String[] detectMatchTiles() {
        String[] stringArray;
        dwan dwan2 = ConnectedProperties.getIcon(this.name);
        if (dwan2 == null) {
            stringArray = null;
        } else {
            String[] stringArray2 = new String[1];
            stringArray = stringArray2;
            stringArray2[0] = this.name;
        }
        return stringArray;
    }

    private static dwan getIcon(String string) {
        return sctd._f._f(string);
    }

    private boolean isValidCtm(String string) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("0-11 16-27 32-43 48-58");
        }
        if (this.tiles.length < 47) {
            Config.warn("Invalid tiles, must be at least 47: " + string);
            return false;
        }
        return true;
    }

    private boolean isValidHorizontal(String string) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("12-15");
        }
        if (this.tiles.length != 4) {
            Config.warn("Invalid tiles, must be exactly 4: " + string);
            return false;
        }
        return true;
    }

    private boolean isValidVertical(String string) {
        if (this.tiles == null) {
            Config.warn("No tiles defined for vertical: " + string);
            return false;
        }
        if (this.tiles.length != 4) {
            Config.warn("Invalid tiles, must be exactly 4: " + string);
            return false;
        }
        return true;
    }

    private boolean isValidRandom(String string) {
        if (this.tiles != null && this.tiles.length > 0) {
            if (this.weights != null && this.weights.length != this.tiles.length) {
                Config.warn("Number of weights must equal the number of tiles: " + string);
                this.weights = null;
            }
            if (this.weights != null) {
                this.sumWeights = new int[this.weights.length];
                int n = 0;
                for (int i = 0; i < this.weights.length; ++i) {
                    this.sumWeights[i] = n += this.weights[i];
                }
                this.sumAllWeights = n;
            }
            return true;
        }
        Config.warn("Tiles not defined: " + string);
        return false;
    }

    private boolean isValidRepeat(String string) {
        if (this.tiles == null) {
            Config.warn("Tiles not defined: " + string);
            return false;
        }
        if (this.width > 0 && this.width <= 16) {
            if (this.height > 0 && this.height <= 16) {
                if (this.tiles.length != this.width * this.height) {
                    Config.warn("Number of tiles does not equal width x height: " + string);
                    return false;
                }
                return true;
            }
            Config.warn("Invalid height: " + string);
            return false;
        }
        Config.warn("Invalid width: " + string);
        return false;
    }

    private boolean isValidFixed(String string) {
        if (this.tiles == null) {
            Config.warn("Tiles not defined: " + string);
            return false;
        }
        if (this.tiles.length != 1) {
            Config.warn("Number of tiles should be 1 for method: fixed.");
            return false;
        }
        return true;
    }

    private boolean isValidTop(String string) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("66");
        }
        if (this.tiles.length != 1) {
            Config.warn("Invalid tiles, must be exactly 1: " + string);
            return false;
        }
        return true;
    }

    public void updateIcons(sctd sctd2) {
        if (this.matchTiles != null) {
            this.matchTileIcons = ConnectedProperties.registerIcons(this.matchTiles, sctd2);
        }
        if (this.tiles != null) {
            this.tileIcons = ConnectedProperties.registerIcons(this.tiles, sctd2);
        }
    }

    private static dwan[] registerIcons(String[] stringArray, sctd sctd2) {
        if (stringArray == null) {
            return null;
        }
        ArrayList<dwan> arrayList = new ArrayList<dwan>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string;
            ResourceLocation resourceLocation;
            boolean bl;
            String string2;
            String string3 = string2 = stringArray[i];
            if (!string2.contains("/")) {
                string3 = "textures/blocks/" + string2;
            }
            if (!(bl = Config.hasResource(resourceLocation = new ResourceLocation(string = string3 + ".png")))) {
                Config.warn("File not found: " + string);
            }
            dwan dwan2 = sctd2._b(string2);
            arrayList.add(dwan2);
        }
        dwan[] dwanArray = arrayList.toArray(new dwan[arrayList.size()]);
        return dwanArray;
    }

    public String toString() {
        return "CTM name: " + this.name + ", basePath: " + this.basePath + ", matchBlocks: " + Config.arrayToString(this.matchBlocks) + ", matchTiles: " + Config.arrayToString(this.matchTiles);
    }
}

