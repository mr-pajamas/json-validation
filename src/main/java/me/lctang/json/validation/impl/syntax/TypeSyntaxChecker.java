/**
 * File Name:    TypeSyntaxChecker.java
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
 * History:      7/4/12 created by 汤力丞
 */
package me.lctang.json.validation.impl.syntax;

import com.fasterxml.jackson.databind.JsonNode;
import me.lctang.json.validation.InvalidSchemaException;
import me.lctang.json.validation.impl.NodeType;
import me.lctang.json.validation.impl.SchemaSyntaxChecker;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public class TypeSyntaxChecker extends BasicAttributeSyntaxChecker {

    public TypeSyntaxChecker() {
        //super("type", NodeType.STRING, NodeType.ARRAY);
        super("type", NodeType.STRING);
    }

    @Override
    protected void checkValue(SchemaSyntaxChecker schemaChecker,
                              JsonNode schema) {
        JsonNode node = schema.get(attribute);

        /*
        if (!node.isArray()) {
            checkSimpleType(node);
        } else {
            Set<JsonNode> set = new HashSet<JsonNode>();

            for (JsonNode value : node) {
                if (!set.add(value)) throw new InvalidSchemaException(
                    "Items in the array of union type must be unique");
                checkSimpleType(value);
            }
        }
        */

        checkSimpleType(node);
    }

    private void checkSimpleType(JsonNode value) {

        /*
        if (value.isObject()) // then it is a schema
            return; // TODO: do something!!!
        */

        /*
        if (!value.isTextual()) throw new InvalidSchemaException(
            "Wrong value type for attribute \"type\"");
        */

        String typeValue = value.textValue();

        if ("any".equals(typeValue)) return;

        NodeType nodeType = NodeType.forName(typeValue);

        if (nodeType == null)
            throw new InvalidSchemaException("Unknown simple type: " +
                typeValue);

        if (nodeType == NodeType.NULL)
            throw new InvalidSchemaException("Type attribute cannot be \"null\"");

        /*
        if (NodeType.forName(typeValue) == null)
            throw new InvalidSchemaException("Unknown simple type: " +
                typeValue);
        */
    }
}
