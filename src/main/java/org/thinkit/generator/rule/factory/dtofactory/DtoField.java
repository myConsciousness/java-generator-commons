/**
 * Project Name : Generator<br>
 * File Name : DtoField.java<br>
 * Encoding : UTF-8<br>
 * Creation Date : 2020/05/29<br>
 * <p>
 * Copyright © 2020 Kato Shinya. All rights reserved.
 * <p>
 * This source code or any portion thereof must not be<br>
 * reproduced or used in any manner whatsoever.
 */

package org.thinkit.generator.rule.factory.dtofactory;

import java.util.List;

import org.thinkit.generator.rule.factory.resource.Description;
import org.thinkit.generator.rule.factory.resource.Field;
import org.thinkit.generator.rule.factory.resource.FieldDefinition;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * DTOクラスのフィールドを生成する具象クラスです。<br>
 * DTOに必要なフィールドを生成する処理を{@link Component#createResource()}に実装します。
 * 
 * @author Kato Shinya
 * @since 1.0
 * @version 1.0
 * @see Component
 * @see Component#createResource()
 * @see Field
 */
@ToString
@EqualsAndHashCode(callSuper = false)
public class DtoField extends Field {

    @Override
    public String createResource() {
        final List<Description> descriptions = super.getDescriptions();
        final List<FieldDefinition> fieldDefinitions = super.getFieldDefinitions();

        final int descriptionsSize = descriptions.size();

        if (descriptionsSize != fieldDefinitions.size()) {
            // TODO: 例外処理
        }

        final String indentReturn = Indentation.getReturn();
        final StringBuilder fields = new StringBuilder();

        for (int i = 0; i < descriptionsSize; i++) {
            final StringBuilder field = new StringBuilder();
            final Description description = descriptions.get(i);
            final FieldDefinition fieldDefinition = fieldDefinitions.get(i);

            field.append(description.createResource()).append(indentReturn).append(fieldDefinition.createResource())
                    .append(indentReturn).append(indentReturn);

            fields.append(field.toString());
        }

        return fields.toString();
    }
}