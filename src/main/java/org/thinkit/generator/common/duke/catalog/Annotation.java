/*
 * Copyright 2020 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.thinkit.generator.common.duke.catalog;

import org.thinkit.api.catalog.BiCatalog;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * クラスで使用するアノテーションを管理するカタログです。
 *
 * @author Kato Shinya
 * @since 1.0
 * @version 1.0
 */
@RequiredArgsConstructor
public enum Annotation implements BiCatalog<Annotation, String> {

    /**
     * 作成者
     */
    AUTHOR(0, "@author"),

    /**
     * 作成時バージョン
     */
    SINCE(1, "@since"),

    /**
     * 現行バージョン
     */
    VERSION(2, "@version"),

    /**
     * NonNull (Lombok)
     */
    LOMBOK_NON_NULL(3, "@NonNull"),

    /**
     * ToString (Lombok)
     */
    LOMBOK_TO_STRING(4, "@ToString"),

    /**
     * Equals and Hash code (Lombok)
     */
    LOMBOK_EQUALS_AND_HASH_CODE(5, "@EqualsAndHashCode"),

    /**
     * 引数情報
     */
    PARAM(6, "@param"),

    /**
     * Setter (Lombok)
     */
    LOMBOK_SETTER(7, "@Setter"),

    /**
     * Getter (Lombok)
     */
    LOMBOK_GETTER(8, "@Getter"),

    /**
     * 返却情報
     */
    RETURN(9, "@return");

    /**
     * コード値
     */
    @Getter
    private final int code;

    /**
     * タグ
     */
    @Getter
    private final String tag;
}
