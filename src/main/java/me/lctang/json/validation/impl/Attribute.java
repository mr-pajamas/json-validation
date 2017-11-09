/**
 * File Name:    Attribute.java
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
package me.lctang.json.validation.impl;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public class Attribute {

    private final String name;
    private final AttributeSyntaxChecker syntaxChecker;
    private final Class<? extends AttributeValidator> validatorClass;

    Attribute(String name,
              AttributeSyntaxChecker syntaxChecker,
              Class<? extends AttributeValidator> validatorClass) {
        this.name = name;
        this.syntaxChecker = syntaxChecker;
        this.validatorClass = validatorClass;
    }

    public String getName() {
        return name;
    }

    public AttributeSyntaxChecker getSyntaxChecker() {
        return syntaxChecker;
    }

    public Class<? extends AttributeValidator> getValidatorClass() {
        return validatorClass;
    }
}
