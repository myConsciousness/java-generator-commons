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

package org.thinkit.generator.common.duke.factory;

import java.util.ArrayList;
import java.util.List;

import org.thinkit.generator.common.duke.catalog.AnnotationPattern;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Javaコンポーネントにおけるアノテーションを抽象化したクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.2
 */
@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class Annotation extends JavaComponent {

    /**
     * アノテーションパターン
     */
    @Getter(AccessLevel.PROTECTED)
    private AnnotationPattern annotationPattern;

    /**
     * アノテーション引数リスト
     */
    @Getter(AccessLevel.PROTECTED)
    private List<AnnotationParameter> annotationParameters;

    /**
     * デフォルトコンストラクタ
     */
    @SuppressWarnings("unused")
    private Annotation() {
    }

    /**
     * コンストラクタ
     *
     * @param annotationPattern アノテーションパターン
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    protected Annotation(@NonNull AnnotationPattern annotationPattern) {
        this.annotationPattern = annotationPattern;
    }

    /**
     * アノテーション引数を追加します。
     *
     * @param annotationParameter アノテーション引数
     * @return 自分自身のインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public Annotation add(@NonNull AnnotationParameter annotationParameter) {

        if (this.annotationParameters == null) {
            this.annotationParameters = new ArrayList<>(0);
        }

        this.annotationParameters.add(annotationParameter);
        return this;
    }
}
