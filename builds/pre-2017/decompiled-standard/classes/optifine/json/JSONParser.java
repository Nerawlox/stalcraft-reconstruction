/*
 * Decompiled with CFR 0.152.
 */
package optifine.json;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import optifine.json.ContainerFactory;
import optifine.json.ContentHandler;
import optifine.json.JSONArray;
import optifine.json.JSONObject;
import optifine.json.ParseException;
import optifine.json.Yylex;
import optifine.json.Yytoken;

public class JSONParser {
    public static final int S_INIT = 0;
    public static final int S_IN_FINISHED_VALUE = 1;
    public static final int S_IN_OBJECT = 2;
    public static final int S_IN_ARRAY = 3;
    public static final int S_PASSED_PAIR_KEY = 4;
    public static final int S_IN_PAIR_VALUE = 5;
    public static final int S_END = 6;
    public static final int S_IN_ERROR = -1;
    private LinkedList handlerStatusStack;
    private Yylex lexer = new Yylex((Reader)null);
    private Yytoken token = null;
    private int status = 0;

    private int peekStatus(LinkedList linkedList) {
        if (linkedList.size() == 0) {
            return -1;
        }
        Integer n = (Integer)linkedList.getFirst();
        return n;
    }

    public void reset() {
        this.token = null;
        this.status = 0;
        this.handlerStatusStack = null;
    }

    public void reset(Reader reader) {
        this.lexer.yyreset(reader);
        this.reset();
    }

    public int getPosition() {
        return this.lexer.getPosition();
    }

    public Object parse(String string) throws ParseException {
        return this.parse(string, (ContainerFactory)null);
    }

    public Object parse(String string, ContainerFactory containerFactory) throws ParseException {
        StringReader stringReader = new StringReader(string);
        try {
            return this.parse((Reader)stringReader, containerFactory);
        }
        catch (IOException iOException) {
            throw new ParseException(-1, 2, iOException);
        }
    }

    public Object parse(Reader reader) throws IOException, ParseException {
        return this.parse(reader, (ContainerFactory)null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object parse(Reader reader, ContainerFactory containerFactory) throws IOException, ParseException {
        this.reset(reader);
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        LinkedList<Object> linkedList2 = new LinkedList<Object>();
        do {
            this.nextToken();
            block1 : switch (this.status) {
                case -1: {
                    throw new ParseException(this.getPosition(), 1, this.token);
                }
                case 0: {
                    switch (this.token.type) {
                        case 0: {
                            this.status = 1;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(this.token.value);
                            break block1;
                        }
                        case 1: {
                            this.status = 2;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(this.createObjectContainer(containerFactory));
                            break block1;
                        }
                        default: {
                            this.status = -1;
                            break block1;
                        }
                        case 3: 
                    }
                    this.status = 3;
                    linkedList.addFirst(new Integer(this.status));
                    linkedList2.addFirst(this.createArrayContainer(containerFactory));
                    break;
                }
                case 1: {
                    if (this.token.type != -1) throw new ParseException(this.getPosition(), 1, this.token);
                    return linkedList2.removeFirst();
                }
                case 2: {
                    String string;
                    switch (this.token.type) {
                        case 0: {
                            if (this.token.value instanceof String) {
                                string = (String)this.token.value;
                                linkedList2.addFirst(string);
                                this.status = 4;
                                linkedList.addFirst(new Integer(this.status));
                                break;
                            }
                            this.status = -1;
                            break;
                        }
                        default: {
                            this.status = -1;
                            break;
                        }
                        case 2: {
                            if (linkedList2.size() > 1) {
                                linkedList.removeFirst();
                                linkedList2.removeFirst();
                                this.status = this.peekStatus(linkedList);
                                break;
                            }
                            this.status = 1;
                            break;
                        }
                        case 5: 
                    }
                    break;
                }
                case 3: {
                    List list2;
                    Map map;
                    switch (this.token.type) {
                        case 0: {
                            List list3 = (List)linkedList2.getFirst();
                            list3.add(this.token.value);
                            break;
                        }
                        case 1: {
                            List list3 = (List)linkedList2.getFirst();
                            map = this.createObjectContainer(containerFactory);
                            list3.add(map);
                            this.status = 2;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(map);
                            break;
                        }
                        default: {
                            this.status = -1;
                            break;
                        }
                        case 3: {
                            List list3 = (List)linkedList2.getFirst();
                            list2 = this.createArrayContainer(containerFactory);
                            list3.add(list2);
                            this.status = 3;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(list2);
                            break;
                        }
                        case 4: {
                            if (linkedList2.size() > 1) {
                                linkedList.removeFirst();
                                linkedList2.removeFirst();
                                this.status = this.peekStatus(linkedList);
                                break;
                            }
                            this.status = 1;
                            break;
                        }
                        case 5: 
                    }
                    break;
                }
                case 4: {
                    List list2;
                    Map map;
                    String string;
                    switch (this.token.type) {
                        case 0: {
                            linkedList.removeFirst();
                            string = (String)linkedList2.removeFirst();
                            map = (Map)linkedList2.getFirst();
                            map.put(string, this.token.value);
                            this.status = this.peekStatus(linkedList);
                            break;
                        }
                        case 1: {
                            linkedList.removeFirst();
                            string = (String)linkedList2.removeFirst();
                            map = (Map)linkedList2.getFirst();
                            Map map2 = this.createObjectContainer(containerFactory);
                            map.put(string, map2);
                            this.status = 2;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(map2);
                            break;
                        }
                        default: {
                            this.status = -1;
                            break;
                        }
                        case 3: {
                            linkedList.removeFirst();
                            string = (String)linkedList2.removeFirst();
                            map = (Map)linkedList2.getFirst();
                            list2 = this.createArrayContainer(containerFactory);
                            map.put(string, list2);
                            this.status = 3;
                            linkedList.addFirst(new Integer(this.status));
                            linkedList2.addFirst(list2);
                        }
                        case 6: 
                    }
                    break;
                }
            }
            if (this.status != -1) continue;
            throw new ParseException(this.getPosition(), 1, this.token);
        } while (this.token.type != -1);
        throw new ParseException(this.getPosition(), 1, this.token);
    }

    private void nextToken() throws IOException, ParseException {
        this.token = this.lexer.yylex();
        if (this.token == null) {
            this.token = new Yytoken(-1, null);
        }
    }

    private Map createObjectContainer(ContainerFactory containerFactory) {
        if (containerFactory == null) {
            return new JSONObject();
        }
        Map map = containerFactory.createObjectContainer();
        return map == null ? new JSONObject() : map;
    }

    private List createArrayContainer(ContainerFactory containerFactory) {
        if (containerFactory == null) {
            return new JSONArray();
        }
        List list2 = containerFactory.creatArrayContainer();
        return list2 == null ? new JSONArray() : list2;
    }

    public void parse(String string, ContentHandler contentHandler) throws ParseException {
        this.parse(string, contentHandler, false);
    }

    public void parse(String string, ContentHandler contentHandler, boolean bl) throws ParseException {
        StringReader stringReader = new StringReader(string);
        try {
            this.parse(stringReader, contentHandler, bl);
        }
        catch (IOException iOException) {
            throw new ParseException(-1, 2, iOException);
        }
    }

    public void parse(Reader reader, ContentHandler contentHandler) throws IOException, ParseException {
        this.parse(reader, contentHandler, false);
    }

    public void parse(Reader reader, ContentHandler contentHandler, boolean bl) throws IOException, ParseException {
        if (!bl) {
            this.reset(reader);
            this.handlerStatusStack = new LinkedList();
        } else if (this.handlerStatusStack == null) {
            bl = false;
            this.reset(reader);
            this.handlerStatusStack = new LinkedList();
        }
        LinkedList linkedList = this.handlerStatusStack;
        try {
            do {
                block1 : switch (this.status) {
                    case -1: {
                        throw new ParseException(this.getPosition(), 1, this.token);
                    }
                    case 0: {
                        contentHandler.startJSON();
                        this.nextToken();
                        switch (this.token.type) {
                            case 0: {
                                this.status = 1;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.primitive(this.token.value)) break block1;
                                return;
                            }
                            case 1: {
                                this.status = 2;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startObject()) break block1;
                                return;
                            }
                            default: {
                                this.status = -1;
                                break block1;
                            }
                            case 3: 
                        }
                        this.status = 3;
                        linkedList.addFirst(new Integer(this.status));
                        if (contentHandler.startArray()) break;
                        return;
                    }
                    case 1: {
                        this.nextToken();
                        if (this.token.type == -1) {
                            contentHandler.endJSON();
                            this.status = 6;
                            return;
                        }
                        this.status = -1;
                        throw new ParseException(this.getPosition(), 1, this.token);
                    }
                    case 2: {
                        this.nextToken();
                        switch (this.token.type) {
                            case 0: {
                                if (this.token.value instanceof String) {
                                    String string = (String)this.token.value;
                                    this.status = 4;
                                    linkedList.addFirst(new Integer(this.status));
                                    if (contentHandler.startObjectEntry(string)) break block1;
                                    return;
                                }
                                this.status = -1;
                                break;
                            }
                            default: {
                                this.status = -1;
                                break;
                            }
                            case 2: {
                                if (linkedList.size() > 1) {
                                    linkedList.removeFirst();
                                    this.status = this.peekStatus(linkedList);
                                } else {
                                    this.status = 1;
                                }
                                if (!contentHandler.endObject()) {
                                    return;
                                }
                            }
                            case 5: {
                                break;
                            }
                        }
                        break;
                    }
                    case 3: {
                        this.nextToken();
                        switch (this.token.type) {
                            case 0: {
                                if (contentHandler.primitive(this.token.value)) break;
                                return;
                            }
                            case 1: {
                                this.status = 2;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startObject()) break;
                                return;
                            }
                            default: {
                                this.status = -1;
                                break;
                            }
                            case 3: {
                                this.status = 3;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startArray()) break;
                                return;
                            }
                            case 4: {
                                if (linkedList.size() > 1) {
                                    linkedList.removeFirst();
                                    this.status = this.peekStatus(linkedList);
                                } else {
                                    this.status = 1;
                                }
                                if (contentHandler.endArray()) break;
                                return;
                            }
                            case 5: 
                        }
                        break;
                    }
                    case 4: {
                        this.nextToken();
                        switch (this.token.type) {
                            case 0: {
                                linkedList.removeFirst();
                                this.status = this.peekStatus(linkedList);
                                if (!contentHandler.primitive(this.token.value)) {
                                    return;
                                }
                                if (contentHandler.endObjectEntry()) break;
                                return;
                            }
                            case 1: {
                                linkedList.removeFirst();
                                linkedList.addFirst(new Integer(5));
                                this.status = 2;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startObject()) break;
                                return;
                            }
                            default: {
                                this.status = -1;
                                break;
                            }
                            case 3: {
                                linkedList.removeFirst();
                                linkedList.addFirst(new Integer(5));
                                this.status = 3;
                                linkedList.addFirst(new Integer(this.status));
                                if (contentHandler.startArray()) break;
                                return;
                            }
                            case 6: 
                        }
                        break;
                    }
                    case 5: {
                        linkedList.removeFirst();
                        this.status = this.peekStatus(linkedList);
                        if (contentHandler.endObjectEntry()) break;
                        return;
                    }
                    case 6: {
                        return;
                    }
                }
                if (this.status != -1) continue;
                throw new ParseException(this.getPosition(), 1, this.token);
            } while (this.token.type != -1);
        }
        catch (IOException iOException) {
            this.status = -1;
            throw iOException;
        }
        catch (ParseException parseException) {
            this.status = -1;
            throw parseException;
        }
        catch (RuntimeException runtimeException) {
            this.status = -1;
            throw runtimeException;
        }
        catch (Error error) {
            this.status = -1;
            throw error;
        }
        this.status = -1;
        throw new ParseException(this.getPosition(), 1, this.token);
    }

    public static Date parseDate(String string) {
        if (string == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
        if (string.endsWith("Z")) {
            string = string.substring(0, string.length() - 1) + "GMT-00:00";
        } else {
            int n = 6;
            String string2 = string.substring(0, string.length() - n);
            String string3 = string.substring(string.length() - n, string.length());
            string = string2 + "GMT" + string3;
        }
        try {
            return simpleDateFormat.parse(string);
        }
        catch (java.text.ParseException parseException) {
            System.out.println("Error parsing date: " + string);
            System.out.println(parseException.getClass().getName() + ": " + parseException.getMessage());
            return null;
        }
    }
}

