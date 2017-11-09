/**
 * File Name:    BasicAttributeSyntaxChecker.java
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
 * History:      6/26/12 created by 汤力丞
 */
package me.lctang.json.validation.impl.syntax;

import java.util.EnumSet;

import com.fasterxml.jackson.databind.JsonNode;
import me.lctang.json.validation.InvalidSchemaException;
import me.lctang.json.validation.impl.*;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public class BasicAttributeSyntaxChecker implements AttributeSyntaxChecker {

    protected final String attribute;
    private final EnumSet<NodeType> validTypes;
    //private final NodeType validType;

    public BasicAttributeSyntaxChecker(String attribute,
                                       NodeType firstValidType,
                                       NodeType... restValidTypes) {
        this.attribute = attribute;
        validTypes = EnumSet.of(firstValidType, restValidTypes);

    }

    /*
    public BasicAttributeSyntaxChecker(String attribute, NodeType validType) {
        this.attribute = attribute;
        this.validType = validType;
    }
    */

    @Override
    public final void checkAttribute(SchemaSyntaxChecker schemaChecker,
                                     JsonNode schema) {
        checkType(schema);
        checkValue(schemaChecker, schema);
    }

    private void checkType(JsonNode schema) {
        NodeType nodeType = NodeType.getNodeType(schema.get(attribute));
        if (!validTypes.contains(nodeType)) throw new InvalidSchemaException(
            "Wrong value type for attribute \"" + attribute + "\"");
    }

    /*
    private void checkType(JsonNode schema) {
        if (validType != NodeType.getNodeType(schema.get(attribute)))
            throw new InvalidSchemaException("Wrong value type for attribute \""
                + attribute + "\"");
    }
    */

    protected void checkValue(SchemaSyntaxChecker schemaChecker,
                              JsonNode schema) {

    }
}
