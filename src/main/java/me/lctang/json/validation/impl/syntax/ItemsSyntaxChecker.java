/**
 * File Name:    ItemsSyntaxChecker.java
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
 * History:      7/24/12 created by 汤力丞
 */
package me.lctang.json.validation.impl.syntax;

import com.fasterxml.jackson.databind.JsonNode;
import me.lctang.json.validation.impl.NodeType;
import me.lctang.json.validation.impl.SchemaSyntaxChecker;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public class ItemsSyntaxChecker extends BasicAttributeSyntaxChecker{

    public ItemsSyntaxChecker() {

        super("items", NodeType.OBJECT);
    }

    @Override
    protected void checkValue(SchemaSyntaxChecker schemaChecker,
                              JsonNode schema) {
        JsonNode node = schema.get(attribute);
        /*
        if (!node.isObject()) throw new InvalidSchemaException(
            "Wrong value type for attribute \"items\"");
        */

        // TODO: do something!!!
        schemaChecker.checkSchema(node);
    }
}
