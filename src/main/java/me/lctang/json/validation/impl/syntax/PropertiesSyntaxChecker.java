/**
 * File Name:    PropertiesSyntaxChecker.java
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
 * History:      7/20/12 created by 汤力丞
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
public class PropertiesSyntaxChecker extends BasicAttributeSyntaxChecker {

    public PropertiesSyntaxChecker() {
        super("properties", NodeType.OBJECT);
    }

    @Override
    protected void checkValue(SchemaSyntaxChecker schemaChecker,
                              JsonNode schema) {

        JsonNode node = schema.get(attribute);

        for (JsonNode child : node) {
            if (!child.isObject()) throw new InvalidSchemaException(
                "Property definition must be a schema");

            // TODO: do something!!!
            schemaChecker.checkSchema(child);
        }
    }
}
