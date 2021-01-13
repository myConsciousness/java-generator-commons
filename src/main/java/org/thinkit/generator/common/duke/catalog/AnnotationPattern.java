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
 * クラスで使用するアノテーションパターンを管理するカタログです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@RequiredArgsConstructor
public enum AnnotationPattern implements BiCatalog<AnnotationPattern, String> {

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
    RETURN(9, "@return"),

    /**
     * RequiredArgsConstructor (Lombok)
     */
    LOMBOK_REQUIRED_ARGS_CONSTRUCTOR(10, "@RequiredArgsConstructor"),

    /**
     * AllArgsConstructor (Lombok)
     */
    LOMBOK_ALL_ARGS_CONSTRUCTOR(11, "@AllArgsConstructor"),

    /**
     * NoArgsConstructor (Lombok)
     */
    LOMBOK_NO_ARGS_CONSTRUCTOR(12, "@NoArgsConstructor"),

    /**
     * Builder (Lombok)
     */
    LOMBOK_BUILDER(13, "@Builder"),

    /**
     * Builder Default (Lombok)
     */
    LOMBOK_BUILDER_DEFAULT(14, "@Builder.Default"),

    /**
     * Require Non Null (Envali)
     */
    ENVALI_REQUIRE_NON_NULL(15, "@RequireNonNull"),

    /**
     * Require Non Blank (Envali)
     */
    ENVALI_REQUIRE_NON_BLANK(16, "@RequireNonBlank"),

    /**
     * Require Positive (Envali)
     */
    ENVALI_REQUIRE_POSITIVE(17, "@RequirePositive"),

    /**
     * Require Negative (Envali)
     */
    ENVALI_REQUIRE_NEGATIVE(18, "@RequireNegative"),

    /**
     * Require Range From (Envali)
     */
    ENVALI_REQUIRE_RANGE_FROM(19, "@RequireRangeFrom"),

    /**
     * Require Range To (Envali)
     */
    ENVALI_REQUIRE_RANGE_TO(20, "@RequireRangeTo"),

    /**
     * Require Range From To (Envali)
     */
    ENVALI_REQUIRE_RANGE_FROM_TO(21, "@RequireRangeFromTo"),

    /**
     * Require Start With (Envali)
     */
    ENVALI_REQUIRE_START_WITH(22, "@RequireStartWith"),

    /**
     * Require End With (Envali)
     */
    ENVALI_REQUIRE_END_WITH(23, "@RequireEndWith"),

    /**
     * Require Non Empty (Envali)
     */
    ENVALI_REQUIRE_NON_EMPTY(24, "@RequireNonEmpty"),

    /**
     * Nested Entity (Envali)
     */
    ENVALI_NESTED_ENTITY(25, "@NestedEntity"),

    /**
     * Require Match (Envali)
     */
    ENVALI_REQUIRE_MATCH(26, "@RequireMatch");

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
