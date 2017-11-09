/**
 * File Name:    NodeType.java
 *
 * File Desc:    TODO
 *
 * Product AB:   Spirit_1_0_0
 *
 * Product Name: Spirit
 *
 * Module Name:  TODO
 *
 * Module AB:    TODO
 *
 * Author:       汤力丞
 *
 * History:      6/25/12 created by 汤力丞
 */
package me.lctang.json.validation.impl;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public enum NodeType {
    STRING,
    NUMBER,
    INTEGER,
    BOOLEAN,
    OBJECT,
    ARRAY,
    NULL;
    //ANY;
    //UNKNOWN,
    //UNION;

    private static final Map<String, NodeType> reversedMap = new HashMap<>();

    static {
        for (NodeType type : NodeType.values())
            reversedMap.put(type.toString().toLowerCase(), type);
    }

    public static NodeType forName(String name) {
        return reversedMap.get(name);
    }

    public static NodeType getNodeType(JsonNode node) {
        if (node.isMissingNode())
            throw new IllegalArgumentException("The specified node does not exist");

        if (node.isObject())
            return OBJECT;
        else if (node.isArray())
            return ARRAY;
        else if (node.isTextual() || node.isBinary())
            return STRING;
        else if (node.isIntegralNumber())
            return INTEGER;
        else if (node.isNumber())
            return NUMBER;
        else if (node.isBoolean())
            return BOOLEAN;
        else if (node.isNull())
            return NULL;
        else
            throw new IllegalArgumentException("Unrecognized node type");
    }
}
