/**
 * File Name:    SchemaImpl.java
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

import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import me.lctang.json.validation.*;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public class SchemaImpl implements Schema {

    private static final JsonNode EMPTY_SCHEMA =
        JsonNodeFactory.instance.objectNode();

    private JsonNode items = EMPTY_SCHEMA;
    private Map<String, JsonNode> properties =
        new HashMap<String, JsonNode>();

    private List<AttributeValidator> validators;

    private JsonNode schemaNode;

    //private final SchemaSyntaxChecker schemaChecker;

    public SchemaImpl(JsonNode schemaNode) {
        this.schemaNode = schemaNode;
        //new SchemaSyntaxChecker().checkSchema(schemaNode);
        //checkSyntax();
        //this.schemaNode = schemaNode;
        //if (checkSyntax) checkSyntax();
    }

    //private void checkSyntax(JsonNode schemaNode) {

        /*
        Iterator<String> properties = schemaNode.fieldNames();
        while (properties.hasNext()) {
            //String property =
        }
        */
        //schemaChecker.checkSchema(schemaNode);
    //}


    private void initValidators(JsonNode schemaNode) {
        /*
        Set<String> keywords = new HashSet<String>();

        Iterator<String> fieldNameIterator = schema.fieldNames();
        while (fieldNameIterator.hasNext())
            keywords.add(fieldNameIterator.next());

        keywords.retainAll(Attributes.getAttributeNames());

        for (String keyword : keywords)
            Attributes.getAttribute(keyword)
                .getSyntaxChecker().checkAttribute(this, schema);
        */


    }

    private Map<String, Class<? extends AttributeValidator>> allValidatorClasses() {
        Map<String, Class<? extends AttributeValidator>> validatorClasses =
            new HashMap<String, Class<? extends AttributeValidator>>();
        for (String attributeName : Attributes.getAttributeNames()) {
            Class<? extends AttributeValidator> validatorClass =
                Attributes.getAttribute(attributeName).getValidatorClass();
            if (validatorClass != null)
                validatorClasses.put(attributeName, validatorClass);
        }
        return validatorClasses;
    }

    private AttributeValidator buildValidator(Class<? extends AttributeValidator> validatorClass,
                                              JsonNode schema) {
        try {
            AttributeValidator
        }
    }

    @Override
    public Validator newValidator() {
        return new ValidatorImpl(ValidationMode.COMPLETE);
    }

    @Override
    public Validator newValidator(ValidationMode validationMode) {
        return new ValidatorImpl(validationMode);
    }

    private class ValidatorImpl implements Validator {

        private ValidationMode validationMode;

        //private ErrorReporter errorReporter;

        public ValidatorImpl(ValidationMode validationMode) {

            setValidationMode(validationMode);
            /*
            this.validationMode = validationMode;
            errorReporter = ErrorReporterFactory.newErrorReporter(validationMode);
            */
        }

        @Override
        public void setValidationMode(ValidationMode mode) {
            this.validationMode = mode;
            //errorReporter = ErrorReporterFactory.newErrorReporter(mode, "$");
        }

        @Override
        public ValidationMode getValidationMode() {
            return validationMode;
        }

        @Override
        public boolean validate(JsonNode instance) {

            ValidationMode mode = this.validationMode;

            try {
                throw new BreakException();
            } catch (BreakException be) {

            }

            return getErrors().size() == 0;

            //return false;  // TODO
        }

        @Override
        public List<ErrorReport> getErrors() {
            //return errorReporter.getErrorReports();
            return null;
        }
    }
}
