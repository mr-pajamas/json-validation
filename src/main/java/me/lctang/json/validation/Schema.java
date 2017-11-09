/**
 * File Name:    Schema.java
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
 * History:      6/20/12 created by 汤力丞
 */
package me.lctang.json.validation;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public interface Schema {

    /**
     * 根据此Schema创建一个新的Validator实例
     *
     * @return 总是返回一个非空实例
     */
    Validator newValidator();

    Validator newValidator(ValidationMode validationMode);
}
