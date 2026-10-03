/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.client.model.IModelCustom
 *  net.minecraftforge.client.model.ModelFormatException
 *  net.minecraftforge.client.model.obj.Face
 *  net.minecraftforge.client.model.obj.GroupObject
 *  net.minecraftforge.client.model.obj.TextureCoordinate
 *  net.minecraftforge.client.model.obj.Vertex
 */
package ru.stalcraft.client.loaders;

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
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.ModelFormatException;
import net.minecraftforge.client.model.obj.Face;
import net.minecraftforge.client.model.obj.GroupObject;
import net.minecraftforge.client.model.obj.TextureCoordinate;
import net.minecraftforge.client.model.obj.Vertex;

@SideOnly(value=Side.CLIENT)
public class StalkerWavefrontObject
implements IModelCustom {
    private static Pattern vertexPattern = Pattern.compile("(vertex( (\\-){0,1}\\d+\\.\\d+){3,4} *\\n)|(vertex( (\\-){0,1}\\d+\\.\\d+){3,4} *$)");
    private static Pattern vertexNormalPattern = Pattern.compile("(normalvertex( (\\-){0,1}\\d+\\.\\d+){3,4} *\\n)|(normalvertex( (\\-){0,1}\\d+\\.\\d+){3,4} *$)");
    private static Pattern textureCoordinatePattern = Pattern.compile("(coordinatevertex( (\\-){0,1}\\d+\\.\\d+){2,3} *\\n)|(coordinatevertex( (\\-){0,1}\\d+\\.\\d+){2,3} *$)");
    private static Pattern face_V_VT_VN_Pattern = Pattern.compile("(face( \\d+/\\d+/\\d+){3,4} *\\n)|(face( \\d+/\\d+/\\d+){3,4} *$)");
    private static Pattern face_V_VT_Pattern = Pattern.compile("(face( \\d+/\\d+){3,4} *\\n)|(face( \\d+/\\d+){3,4} *$)");
    private static Pattern face_V_VN_Pattern = Pattern.compile("(face( \\d+//\\d+){3,4} *\\n)|(face( \\d+//\\d+){3,4} *$)");
    private static Pattern face_V_Pattern = Pattern.compile("(face( \\d+){3,4} *\\n)|(f( \\d+){3,4} *$)");
    private static Pattern groupObjectPattern = Pattern.compile("([go]( [\\w\\d]+) *\\n)|([go]( [\\w\\d]+) *$)");
    private static Matcher vertexMatcher;
    private static Matcher vertexNormalMatcher;
    private static Matcher textureCoordinateMatcher;
    private static Matcher face_V_VT_VN_Matcher;
    private static Matcher face_V_VT_Matcher;
    private static Matcher face_V_VN_Matcher;
    private static Matcher face_V_Matcher;
    private static Matcher groupObjectMatcher;
    public ArrayList vertices = new ArrayList();
    public ArrayList vertexNormals = new ArrayList();
    public ArrayList textureCoordinates = new ArrayList();
    public ArrayList groupObjects = new ArrayList();
    private GroupObject currentGroupObject;
    private String fileName;

    public StalkerWavefrontObject(String fileName, URL resource) throws ModelFormatException {
        this.fileName = fileName;
        try {
            this.loadObjModel(resource.openStream());
        }
        catch (IOException var4) {
            throw new ModelFormatException("IO Exception reading model format", (Throwable)var4);
        }
    }

    public StalkerWavefrontObject(String filename, InputStream inputStream) throws ModelFormatException {
        this.fileName = filename;
        this.loadObjModel(inputStream);
    }

    private void loadObjModel(InputStream inputStream) throws ModelFormatException {
        BufferedReader reader = null;
        String currentLine = null;
        int lineCount = 0;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((currentLine = reader.readLine()) != null) {
                Vertex e2;
                ++lineCount;
                if ((currentLine = currentLine.replaceAll("\\s+", " ").trim()).startsWith("#") || currentLine.length() == 0) continue;
                if (currentLine.startsWith("vertex ")) {
                    e2 = this.parseVertex(currentLine, lineCount);
                    if (e2 == null) continue;
                    this.vertices.add(e2);
                    continue;
                }
                if (currentLine.startsWith("normalvertex ")) {
                    e2 = this.parseVertexNormal(currentLine, lineCount);
                    if (e2 == null) continue;
                    this.vertexNormals.add(e2);
                    continue;
                }
                if (currentLine.startsWith("coordinatevertex ")) {
                    TextureCoordinate var18 = this.parseTextureCoordinate(currentLine, lineCount);
                    if (var18 == null) continue;
                    this.textureCoordinates.add(var18);
                    continue;
                }
                if (currentLine.startsWith("face ")) {
                    Face var19;
                    if (this.currentGroupObject == null) {
                        this.currentGroupObject = new GroupObject("Default");
                    }
                    if ((var19 = this.parseFace(currentLine, lineCount)) == null) continue;
                    this.currentGroupObject.faces.add(var19);
                    continue;
                }
                if (!(currentLine.startsWith("g ") | currentLine.startsWith("o "))) continue;
                GroupObject var20 = this.parseGroupObject(currentLine, lineCount);
                if (var20 != null && this.currentGroupObject != null) {
                    this.groupObjects.add(this.currentGroupObject);
                }
                this.currentGroupObject = var20;
            }
            this.groupObjects.add(this.currentGroupObject);
        }
        catch (IOException var16) {
            throw new ModelFormatException("IO Exception reading model format", (Throwable)var16);
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException iOException) {}
            try {
                inputStream.close();
            }
            catch (IOException iOException) {}
        }
    }

    public void renderAll() {
        bfq tessellator = bfq.a;
        if (this.currentGroupObject != null) {
            tessellator.b(this.currentGroupObject.glDrawingMode);
        } else {
            tessellator.b(4);
        }
        this.tessellateAll(tessellator);
        tessellator.a();
    }

    public void tessellateAll(bfq tessellator) {
        for (GroupObject groupObject : this.groupObjects) {
            groupObject.render(tessellator);
        }
    }

    public void renderOnly(String ... groupNames) {
        for (GroupObject groupObject : this.groupObjects) {
            String[] arr$ = groupNames;
            int len$ = groupNames.length;
            for (int i$1 = 0; i$1 < len$; ++i$1) {
                String groupName = arr$[i$1];
                if (!groupName.equalsIgnoreCase(groupObject.name)) continue;
                groupObject.render();
            }
        }
    }

    public void tessellateOnly(bfq tessellator, String ... groupNames) {
        for (GroupObject groupObject : this.groupObjects) {
            String[] arr$ = groupNames;
            int len$ = groupNames.length;
            for (int i$1 = 0; i$1 < len$; ++i$1) {
                String groupName = arr$[i$1];
                if (!groupName.equalsIgnoreCase(groupObject.name)) continue;
                groupObject.render(tessellator);
            }
        }
    }

    public void renderPart(String partName) {
        for (GroupObject groupObject : this.groupObjects) {
            if (!partName.equalsIgnoreCase(groupObject.name)) continue;
            groupObject.render();
        }
    }

    public void tessellatePart(bfq tessellator, String partName) {
        for (GroupObject groupObject : this.groupObjects) {
            if (!partName.equalsIgnoreCase(groupObject.name)) continue;
            groupObject.render(tessellator);
        }
    }

    public void renderAllExcept(String ... excludedGroupNames) {
        for (GroupObject groupObject : this.groupObjects) {
            boolean skipPart = false;
            String[] arr$ = excludedGroupNames;
            int len$ = excludedGroupNames.length;
            for (int i$1 = 0; i$1 < len$; ++i$1) {
                String excludedGroupName = arr$[i$1];
                if (!excludedGroupName.equalsIgnoreCase(groupObject.name)) continue;
                skipPart = true;
            }
            if (skipPart) continue;
            groupObject.render();
        }
    }

    public void tessellateAllExcept(bfq tessellator, String ... excludedGroupNames) {
        for (GroupObject groupObject : this.groupObjects) {
            boolean exclude = false;
            String[] arr$ = excludedGroupNames;
            int len$ = excludedGroupNames.length;
            for (int i$1 = 0; i$1 < len$; ++i$1) {
                String excludedGroupName = arr$[i$1];
                if (!excludedGroupName.equalsIgnoreCase(groupObject.name)) continue;
                exclude = true;
            }
            if (exclude) continue;
            groupObject.render(tessellator);
        }
    }

    private Vertex parseVertex(String line, int lineCount) throws ModelFormatException {
        Object vertex = null;
        if (StalkerWavefrontObject.isValidVertexLine(line)) {
            line = line.substring(line.indexOf(" ") + 1);
            String[] tokens = line.split(" ");
            try {
                return tokens.length == 2 ? new Vertex(Float.parseFloat(tokens[0]), Float.parseFloat(tokens[1])) : (tokens.length == 3 ? new Vertex(Float.parseFloat(tokens[0]), Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])) : vertex);
            }
            catch (NumberFormatException var6) {
                throw new ModelFormatException(String.format("Number formatting error at line %d", lineCount), (Throwable)var6);
            }
        }
        throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
    }

    private Vertex parseVertexNormal(String line, int lineCount) throws ModelFormatException {
        Vertex vertexNormal = null;
        if (StalkerWavefrontObject.isValidVertexNormalLine(line)) {
            line = line.substring(line.indexOf(" ") + 1);
            String[] tokens = line.split(" ");
            try {
                return tokens.length == 3 ? new Vertex(Float.parseFloat(tokens[0]), Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])) : vertexNormal;
            }
            catch (NumberFormatException var6) {
                throw new ModelFormatException(String.format("Number formatting error at line %d", lineCount), (Throwable)var6);
            }
        }
        throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
    }

    private TextureCoordinate parseTextureCoordinate(String line, int lineCount) throws ModelFormatException {
        Object textureCoordinate = null;
        if (StalkerWavefrontObject.isValidTextureCoordinateLine(line)) {
            line = line.substring(line.indexOf(" ") + 1);
            String[] tokens = line.split(" ");
            try {
                return tokens.length == 2 ? new TextureCoordinate(Float.parseFloat(tokens[0]), 1.0f - Float.parseFloat(tokens[1])) : (tokens.length == 3 ? new TextureCoordinate(Float.parseFloat(tokens[0]), 1.0f - Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])) : textureCoordinate);
            }
            catch (NumberFormatException var6) {
                throw new ModelFormatException(String.format("Number formatting error at line %d", lineCount), (Throwable)var6);
            }
        }
        throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
    }

    private Face parseFace(String line, int lineCount) throws ModelFormatException {
        Face face = null;
        if (StalkerWavefrontObject.isValidFaceLine(line)) {
            face = new Face();
            String trimmedLine = line.substring(line.indexOf(" ") + 1);
            String[] tokens = trimmedLine.split(" ");
            String[] subTokens = null;
            if (tokens.length == 3) {
                if (this.currentGroupObject.glDrawingMode == -1) {
                    this.currentGroupObject.glDrawingMode = 4;
                } else if (this.currentGroupObject.glDrawingMode != 4) {
                    throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Invalid number of points for face (expected 4, found " + tokens.length + ")");
                }
            } else if (tokens.length == 4) {
                if (this.currentGroupObject.glDrawingMode == -1) {
                    this.currentGroupObject.glDrawingMode = 7;
                } else if (this.currentGroupObject.glDrawingMode != 7) {
                    throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Invalid number of points for face (expected 3, found " + tokens.length + ")");
                }
            }
            if (StalkerWavefrontObject.isValidFace_V_VT_VN_Line(line)) {
                face.vertices = new Vertex[tokens.length];
                face.textureCoordinates = new TextureCoordinate[tokens.length];
                face.vertexNormals = new Vertex[tokens.length];
                for (int i2 = 0; i2 < tokens.length; ++i2) {
                    subTokens = tokens[i2].split("/");
                    face.vertices[i2] = (Vertex)this.vertices.get(Integer.parseInt(subTokens[0]) - 1);
                    face.textureCoordinates[i2] = (TextureCoordinate)this.textureCoordinates.get(Integer.parseInt(subTokens[1]) - 1);
                    face.vertexNormals[i2] = (Vertex)this.vertexNormals.get(Integer.parseInt(subTokens[2]) - 1);
                }
                face.faceNormal = face.calculateFaceNormal();
            } else if (StalkerWavefrontObject.isValidFace_V_VT_Line(line)) {
                face.vertices = new Vertex[tokens.length];
                face.textureCoordinates = new TextureCoordinate[tokens.length];
                for (int i3 = 0; i3 < tokens.length; ++i3) {
                    subTokens = tokens[i3].split("/");
                    face.vertices[i3] = (Vertex)this.vertices.get(Integer.parseInt(subTokens[0]) - 1);
                    face.textureCoordinates[i3] = (TextureCoordinate)this.textureCoordinates.get(Integer.parseInt(subTokens[1]) - 1);
                }
                face.faceNormal = face.calculateFaceNormal();
            } else if (StalkerWavefrontObject.isValidFace_V_VN_Line(line)) {
                face.vertices = new Vertex[tokens.length];
                face.vertexNormals = new Vertex[tokens.length];
                for (int i4 = 0; i4 < tokens.length; ++i4) {
                    subTokens = tokens[i4].split("//");
                    face.vertices[i4] = (Vertex)this.vertices.get(Integer.parseInt(subTokens[0]) - 1);
                    face.vertexNormals[i4] = (Vertex)this.vertexNormals.get(Integer.parseInt(subTokens[1]) - 1);
                }
                face.faceNormal = face.calculateFaceNormal();
            } else {
                if (!StalkerWavefrontObject.isValidFace_V_Line(line)) {
                    throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
                }
                face.vertices = new Vertex[tokens.length];
                for (int i5 = 0; i5 < tokens.length; ++i5) {
                    face.vertices[i5] = (Vertex)this.vertices.get(Integer.parseInt(tokens[i5]) - 1);
                }
                face.faceNormal = face.calculateFaceNormal();
            }
            return face;
        }
        throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
    }

    private GroupObject parseGroupObject(String line, int lineCount) throws ModelFormatException {
        GroupObject group = null;
        if (StalkerWavefrontObject.isValidGroupObjectLine(line)) {
            String trimmedLine = line.substring(line.indexOf(" ") + 1);
            if (trimmedLine.length() > 0) {
                group = new GroupObject(trimmedLine);
            }
            return group;
        }
        throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
    }

    private static boolean isValidVertexLine(String line) {
        return vertexPattern.matcher(line).matches();
    }

    private static boolean isValidVertexNormalLine(String line) {
        return vertexNormalPattern.matcher(line).matches();
    }

    private static boolean isValidTextureCoordinateLine(String line) {
        return textureCoordinatePattern.matcher(line).matches();
    }

    private static boolean isValidFace_V_VT_VN_Line(String line) {
        return face_V_VT_VN_Pattern.matcher(line).matches();
    }

    private static boolean isValidFace_V_VT_Line(String line) {
        return face_V_VT_Pattern.matcher(line).matches();
    }

    private static boolean isValidFace_V_VN_Line(String line) {
        return face_V_VN_Pattern.matcher(line).matches();
    }

    private static boolean isValidFace_V_Line(String line) {
        return face_V_Pattern.matcher(line).matches();
    }

    private static boolean isValidFaceLine(String line) {
        return StalkerWavefrontObject.isValidFace_V_VT_VN_Line(line) || StalkerWavefrontObject.isValidFace_V_VT_Line(line) || StalkerWavefrontObject.isValidFace_V_VN_Line(line) || StalkerWavefrontObject.isValidFace_V_Line(line);
    }

    private static boolean isValidGroupObjectLine(String line) {
        return groupObjectPattern.matcher(line).matches();
    }

    public String getType() {
        return "suck";
    }
}

