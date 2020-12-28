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

import org.thinkit.api.catalog.Catalog;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * アノテーション引数の種別を管理するカタログです。
 *
 * @author Kato Shinya
 * @since 1.0.2
 */
@RequiredArgsConstructor
public enum AnnotationParameterType implements Catalog<AnnotationParameterType> {

    /**
     * デフォルト
     */
    DEFAULT(0),

    /**
     * 配列
     */
    ARRAY(1);

    /**
     * コード値
     */
    @Getter
    private final int code;
}
