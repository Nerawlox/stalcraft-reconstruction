/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model.obj;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.ModelFormatException;
import net.minecraftforge.client.model.obj.Face;
import net.minecraftforge.client.model.obj.GroupObject;
import net.minecraftforge.client.model.obj.TextureCoordinate;
import net.minecraftforge.client.model.obj.Vertex;

@SideOnly(value=Side.CLIENT)
public class WavefrontObject
implements IModelCustom {
    private static Pattern vertexPattern = Pattern.compile("(v( (\\-){0,1}\\d+\\.\\d+){3,4} *\\n)|(v( (\\-){0,1}\\d+\\.\\d+){3,4} *$)");
    private static Pattern vertexNormalPattern = Pattern.compile("(vn( (\\-){0,1}\\d+\\.\\d+){3,4} *\\n)|(vn( (\\-){0,1}\\d+\\.\\d+){3,4} *$)");
    private static Pattern textureCoordinatePattern = Pattern.compile("(vt( (\\-){0,1}\\d+\\.\\d+){2,3} *\\n)|(vt( (\\-){0,1}\\d+\\.\\d+){2,3} *$)");
    private static Pattern face_V_VT_VN_Pattern = Pattern.compile("(f( \\d+/\\d+/\\d+){3,4} *\\n)|(f( \\d+/\\d+/\\d+){3,4} *$)");
    private static Pattern face_V_VT_Pattern = Pattern.compile("(f( \\d+/\\d+){3,4} *\\n)|(f( \\d+/\\d+){3,4} *$)");
    private static Pattern face_V_VN_Pattern = Pattern.compile("(f( \\d+//\\d+){3,4} *\\n)|(f( \\d+//\\d+){3,4} *$)");
    private static Pattern face_V_Pattern = Pattern.compile("(f( \\d+){3,4} *\\n)|(f( \\d+){3,4} *$)");
    private static Pattern groupObjectPattern = Pattern.compile("([go]( [\\w\\d]+) *\\n)|([go]( [\\w\\d]+) *$)");
    private static Matcher vertexMatcher;
    private static Matcher vertexNormalMatcher;
    private static Matcher textureCoordinateMatcher;
    private static Matcher face_V_VT_VN_Matcher;
    private static Matcher face_V_VT_Matcher;
    private static Matcher face_V_VN_Matcher;
    private static Matcher face_V_Matcher;
    private static Matcher groupObjectMatcher;
    public ArrayList<Vertex> vertices = new ArrayList();
    public ArrayList<Vertex> vertexNormals = new ArrayList();
    public ArrayList<TextureCoordinate> textureCoordinates = new ArrayList();
    public ArrayList<GroupObject> groupObjects = new ArrayList();
    private GroupObject currentGroupObject;
    private String fileName;

    public WavefrontObject(String string, URL uRL) throws ModelFormatException {
        this.fileName = string;
        try {
            this.loadObjModel(uRL.openStream());
        }
        catch (IOException iOException) {
            throw new ModelFormatException("IO Exception reading model format", iOException);
        }
    }

    public WavefrontObject(String string, InputStream inputStream) throws ModelFormatException {
        this.fileName = string;
        this.loadObjModel(inputStream);
    }

    private void loadObjModel(InputStream inputStream) throws ModelFormatException {
        BufferedReader bufferedReader = null;
        String string = null;
        int n = 0;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((string = bufferedReader.readLine()) != null) {
                Object object;
                ++n;
                if ((string = string.replaceAll("\\s+", " ").trim()).startsWith("#") || string.length() == 0) continue;
                if (string.startsWith("v ")) {
                    object = this.parseVertex(string, n);
                    if (object == null) continue;
                    this.vertices.add((Vertex)object);
                    continue;
                }
                if (string.startsWith("vn ")) {
                    object = this.parseVertexNormal(string, n);
                    if (object == null) continue;
                    this.vertexNormals.add((Vertex)object);
                    continue;
                }
                if (string.startsWith("vt ")) {
                    object = this.parseTextureCoordinate(string, n);
                    if (object == null) continue;
                    this.textureCoordinates.add((TextureCoordinate)object);
                    continue;
                }
                if (string.startsWith("f ")) {
                    if (this.currentGroupObject == null) {
                        this.currentGroupObject = new GroupObject("Default");
                    }
                    if ((object = this.parseFace(string, n)) == null) continue;
                    this.currentGroupObject.faces.add((Face)object);
                    continue;
                }
                if (!(string.startsWith("g ") | string.startsWith("o "))) continue;
                object = this.parseGroupObject(string, n);
                if (object != null && this.currentGroupObject != null) {
                    this.groupObjects.add(this.currentGroupObject);
                }
                this.currentGroupObject = object;
            }
            this.groupObjects.add(this.currentGroupObject);
        }
        catch (IOException iOException) {
            throw new ModelFormatException("IO Exception reading model format", iOException);
        }
        finally {
            try {
                bufferedReader.close();
            }
            catch (IOException iOException) {}
            try {
                inputStream.close();
            }
            catch (IOException iOException) {}
        }
    }

    @Override
    public void renderAll() {
        Tessellator tessellator = Tessellator.instance;
        if (this.currentGroupObject != null) {
            tessellator.startDrawing(this.currentGroupObject.glDrawingMode);
        } else {
            tessellator.startDrawing(4);
        }
        this.tessellateAll(tessellator);
        tessellator.draw();
    }

    public void tessellateAll(Tessellator tessellator) {
        for (GroupObject groupObject : this.groupObjects) {
            groupObject.render(tessellator);
        }
    }

    @Override
    public void renderOnly(String ... stringArray) {
        for (GroupObject groupObject : this.groupObjects) {
            for (String string : stringArray) {
                if (!string.equalsIgnoreCase(groupObject.name)) continue;
                groupObject.render();
            }
        }
    }

    public void tessellateOnly(Tessellator tessellator, String ... stringArray) {
        for (GroupObject groupObject : this.groupObjects) {
            for (String string : stringArray) {
                if (!string.equalsIgnoreCase(groupObject.name)) continue;
                groupObject.render(tessellator);
            }
        }
    }

    @Override
    public void renderPart(String string) {
        for (GroupObject groupObject : this.groupObjects) {
            if (!string.equalsIgnoreCase(groupObject.name)) continue;
            groupObject.render();
        }
    }

    public void tessellatePart(Tessellator tessellator, String string) {
        for (GroupObject groupObject : this.groupObjects) {
            if (!string.equalsIgnoreCase(groupObject.name)) continue;
            groupObject.render(tessellator);
        }
    }

    @Override
    public void renderAllExcept(String ... stringArray) {
        for (GroupObject groupObject : this.groupObjects) {
            boolean bl = false;
            for (String string : stringArray) {
                if (!string.equalsIgnoreCase(groupObject.name)) continue;
                bl = true;
            }
            if (bl) continue;
            groupObject.render();
        }
    }

    public void tessellateAllExcept(Tessellator tessellator, String ... stringArray) {
        for (GroupObject groupObject : this.groupObjects) {
            boolean bl = false;
            for (String string : stringArray) {
                if (!string.equalsIgnoreCase(groupObject.name)) continue;
                bl = true;
            }
            if (bl) continue;
            groupObject.render(tessellator);
        }
    }

    private Vertex parseVertex(String string, int n) throws ModelFormatException {
        Vertex vertex;
        block5: {
            vertex = null;
            if (WavefrontObject.isValidVertexLine(string)) {
                string = string.substring(string.indexOf(" ") + 1);
                String[] stringArray = string.split(" ");
                try {
                    if (stringArray.length == 2) {
                        return new Vertex(Float.parseFloat(stringArray[0]), Float.parseFloat(stringArray[1]));
                    }
                    if (stringArray.length == 3) {
                        return new Vertex(Float.parseFloat(stringArray[0]), Float.parseFloat(stringArray[1]), Float.parseFloat(stringArray[2]));
                    }
                    break block5;
                }
                catch (NumberFormatException numberFormatException) {
                    throw new ModelFormatException(String.format("Number formatting error at line %d", n), numberFormatException);
                }
            }
            throw new ModelFormatException("Error parsing entry ('" + string + "'" + ", line " + n + ") in file '" + this.fileName + "' - Incorrect format");
        }
        return vertex;
    }

    private Vertex parseVertexNormal(String string, int n) throws ModelFormatException {
        Vertex vertex;
        block4: {
            vertex = null;
            if (WavefrontObject.isValidVertexNormalLine(string)) {
                string = string.substring(string.indexOf(" ") + 1);
                String[] stringArray = string.split(" ");
                try {
                    if (stringArray.length == 3) {
                        return new Vertex(Float.parseFloat(stringArray[0]), Float.parseFloat(stringArray[1]), Float.parseFloat(stringArray[2]));
                    }
                    break block4;
                }
                catch (NumberFormatException numberFormatException) {
                    throw new ModelFormatException(String.format("Number formatting error at line %d", n), numberFormatException);
                }
            }
            throw new ModelFormatException("Error parsing entry ('" + string + "'" + ", line " + n + ") in file '" + this.fileName + "' - Incorrect format");
        }
        return vertex;
    }

    private TextureCoordinate parseTextureCoordinate(String string, int n) throws ModelFormatException {
        TextureCoordinate textureCoordinate;
        block5: {
            textureCoordinate = null;
            if (WavefrontObject.isValidTextureCoordinateLine(string)) {
                string = string.substring(string.indexOf(" ") + 1);
                String[] stringArray = string.split(" ");
                try {
                    if (stringArray.length == 2) {
                        return new TextureCoordinate(Float.parseFloat(stringArray[0]), 1.0f - Float.parseFloat(stringArray[1]));
                    }
                    if (stringArray.length == 3) {
                        return new TextureCoordinate(Float.parseFloat(stringArray[0]), 1.0f - Float.parseFloat(stringArray[1]), Float.parseFloat(stringArray[2]));
                    }
                    break block5;
                }
                catch (NumberFormatException numberFormatException) {
                    throw new ModelFormatException(String.format("Number formatting error at line %d", n), numberFormatException);
                }
            }
            throw new ModelFormatException("Error parsing entry ('" + string + "'" + ", line " + n + ") in file '" + this.fileName + "' - Incorrect format");
        }
        return textureCoordinate;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Face parseFace(String string, int n) throws ModelFormatException {
        Face face = null;
        if (!WavefrontObject.isValidFaceLine(string)) throw new ModelFormatException("Error parsing entry ('" + string + "'" + ", line " + n + ") in file '" + this.fileName + "' - Incorrect format");
        face = new Face();
        String string2 = string.substring(string.indexOf(" ") + 1);
        String[] stringArray = string2.split(" ");
        String[] stringArray2 = null;
        if (stringArray.length == 3) {
            if (this.currentGroupObject.glDrawingMode == -1) {
                this.currentGroupObject.glDrawingMode = 4;
            } else if (this.currentGroupObject.glDrawingMode != 4) {
                throw new ModelFormatException("Error parsing entry ('" + string + "'" + ", line " + n + ") in file '" + this.fileName + "' - Invalid number of points for face (expected 4, found " + stringArray.length + ")");
            }
        } else if (stringArray.length == 4) {
            if (this.currentGroupObject.glDrawingMode == -1) {
                this.currentGroupObject.glDrawingMode = 7;
            } else if (this.currentGroupObject.glDrawingMode != 7) {
                throw new ModelFormatException("Error parsing entry ('" + string + "'" + ", line " + n + ") in file '" + this.fileName + "' - Invalid number of points for face (expected 3, found " + stringArray.length + ")");
            }
        }
        if (WavefrontObject.isValidFace_V_VT_VN_Line(string)) {
            face.vertices = new Vertex[stringArray.length];
            face.textureCoordinates = new TextureCoordinate[stringArray.length];
            face.vertexNormals = new Vertex[stringArray.length];
            for (int i = 0; i < stringArray.length; ++i) {
                stringArray2 = stringArray[i].split("/");
                face.vertices[i] = this.vertices.get(Integer.parseInt(stringArray2[0]) - 1);
                face.textureCoordinates[i] = this.textureCoordinates.get(Integer.parseInt(stringArray2[1]) - 1);
                face.vertexNormals[i] = this.vertexNormals.get(Integer.parseInt(stringArray2[2]) - 1);
            }
            face.faceNormal = face.calculateFaceNormal();
            return face;
        } else if (WavefrontObject.isValidFace_V_VT_Line(string)) {
            face.vertices = new Vertex[stringArray.length];
            face.textureCoordinates = new TextureCoordinate[stringArray.length];
            for (int i = 0; i < stringArray.length; ++i) {
                stringArray2 = stringArray[i].split("/");
                face.vertices[i] = this.vertices.get(Integer.parseInt(stringArray2[0]) - 1);
                face.textureCoordinates[i] = this.textureCoordinates.get(Integer.parseInt(stringArray2[1]) - 1);
            }
            face.faceNormal = face.calculateFaceNormal();
            return face;
        } else if (WavefrontObject.isValidFace_V_VN_Line(string)) {
            face.vertices = new Vertex[stringArray.length];
            face.vertexNormals = new Vertex[stringArray.length];
            for (int i = 0; i < stringArray.length; ++i) {
                stringArray2 = stringArray[i].split("//");
                face.vertices[i] = this.vertices.get(Integer.parseInt(stringArray2[0]) - 1);
                face.vertexNormals[i] = this.vertexNormals.get(Integer.parseInt(stringArray2[1]) - 1);
            }
            face.faceNormal = face.calculateFaceNormal();
            return face;
        } else {
            if (!WavefrontObject.isValidFace_V_Line(string)) throw new ModelFormatException("Error parsing entry ('" + string + "'" + ", line " + n + ") in file '" + this.fileName + "' - Incorrect format");
            face.vertices = new Vertex[stringArray.length];
            for (int i = 0; i < stringArray.length; ++i) {
                face.vertices[i] = this.vertices.get(Integer.parseInt(stringArray[i]) - 1);
            }
            face.faceNormal = face.calculateFaceNormal();
        }
        return face;
    }

    private GroupObject parseGroupObject(String string, int n) throws ModelFormatException {
        GroupObject groupObject = null;
        if (WavefrontObject.isValidGroupObjectLine(string)) {
            String string2 = string.substring(string.indexOf(" ") + 1);
            if (string2.length() > 0) {
                groupObject = new GroupObject(string2);
            }
        } else {
            throw new ModelFormatException("Error parsing entry ('" + string + "'" + ", line " + n + ") in file '" + this.fileName + "' - Incorrect format");
        }
        return groupObject;
    }

    private static boolean isValidVertexLine(String string) {
        if (vertexMatcher != null) {
            vertexMatcher.reset();
        }
        vertexMatcher = vertexPattern.matcher(string);
        return vertexMatcher.matches();
    }

    private static boolean isValidVertexNormalLine(String string) {
        if (vertexNormalMatcher != null) {
            vertexNormalMatcher.reset();
        }
        vertexNormalMatcher = vertexNormalPattern.matcher(string);
        return vertexNormalMatcher.matches();
    }

    private static boolean isValidTextureCoordinateLine(String string) {
        if (textureCoordinateMatcher != null) {
            textureCoordinateMatcher.reset();
        }
        textureCoordinateMatcher = textureCoordinatePattern.matcher(string);
        return textureCoordinateMatcher.matches();
    }

    private static boolean isValidFace_V_VT_VN_Line(String string) {
        if (face_V_VT_VN_Matcher != null) {
            face_V_VT_VN_Matcher.reset();
        }
        face_V_VT_VN_Matcher = face_V_VT_VN_Pattern.matcher(string);
        return face_V_VT_VN_Matcher.matches();
    }

    private static boolean isValidFace_V_VT_Line(String string) {
        if (face_V_VT_Matcher != null) {
            face_V_VT_Matcher.reset();
        }
        face_V_VT_Matcher = face_V_VT_Pattern.matcher(string);
        return face_V_VT_Matcher.matches();
    }

    private static boolean isValidFace_V_VN_Line(String string) {
        if (face_V_VN_Matcher != null) {
            face_V_VN_Matcher.reset();
        }
        face_V_VN_Matcher = face_V_VN_Pattern.matcher(string);
        return face_V_VN_Matcher.matches();
    }

    private static boolean isValidFace_V_Line(String string) {
        if (face_V_Matcher != null) {
            face_V_Matcher.reset();
        }
        face_V_Matcher = face_V_Pattern.matcher(string);
        return face_V_Matcher.matches();
    }

    private static boolean isValidFaceLine(String string) {
        return WavefrontObject.isValidFace_V_VT_VN_Line(string) || WavefrontObject.isValidFace_V_VT_Line(string) || WavefrontObject.isValidFace_V_VN_Line(string) || WavefrontObject.isValidFace_V_Line(string);
    }

    private static boolean isValidGroupObjectLine(String string) {
        if (groupObjectMatcher != null) {
            groupObjectMatcher.reset();
        }
        groupObjectMatcher = groupObjectPattern.matcher(string);
        return groupObjectMatcher.matches();
    }

    @Override
    public String getType() {
        return "obj";
    }
}

