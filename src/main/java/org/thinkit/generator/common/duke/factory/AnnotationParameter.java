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
import java.util.Map;
import java.util.Map.Entry;

import org.thinkit.common.catalog.Brace;
import org.thinkit.common.catalog.Delimiter;
import org.thinkit.generator.common.duke.catalog.AnnotationParameterType;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Javaコンポーネントにおけるアノテーションの引数を抽象化したクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.2
 */
@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class AnnotationParameter extends JavaComponent {

    /**
     * フィールド名
     */
    @Getter(AccessLevel.PROTECTED)
    private String fieldName;

    /**
     * 引数マップ
     */
    @Getter(AccessLevel.PROTECTED)
    private List<Map<Class<?>, Object>> parameters;

    /**
     * アノテーション引数の種別
     */
    @Getter(AccessLevel.PROTECTED)
    private AnnotationParameterType annotationParameterType = AnnotationParameterType.DEFAULT;

    /**
     * デフォルトコンストラクタ
     */
    @SuppressWarnings("unused")
    private AnnotationParameter() {
    }

    /**
     * コンストラクタ
     *
     * @param fieldName フィールド名
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    protected AnnotationParameter(@NonNull String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 引数を追加します。
     *
     * @param clazz     引数のクラスオブジェクト
     * @param parameter 引数
     * @return 自分自身のインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public AnnotationParameter put(@NonNull Class<?> clazz, @NonNull Object parameter) {

        if (this.parameters == null) {
            this.parameters = new ArrayList<>(0);
        }

        this.parameters.add(Map.of(clazz, parameter));
        return this;
    }

    /**
     * 引数種別を配列へ変更します。
     *
     * @return 自分自身のインスタンス
     */
    public AnnotationParameter toArray() {
        this.annotationParameterType = AnnotationParameterType.ARRAY;
        return this;
    }

    /**
     * インスタンスの生成時に渡された情報を基にアノテーションの引数を表現する文字列を生成し返却します。
     *
     * @return アノテーションの引数を表現する文字列
     *
     * @exception IllegalStateException アノテーションの引数種別が
     *                                  {@link AnnotationParameterType#DEFAULT}
     *                                  でかつ複数のパラメーターが設定されていた場合
     */
    protected String createParameter() {
        return switch (this.annotationParameterType) {
            case DEFAULT -> {

                if (this.parameters == null) {
                    yield "";
                }

                if (this.parameters.size() > 1) {
                    throw new IllegalStateException();
                }

                yield this.toString(this.parameters.get(0));
            }

            case ARRAY -> {

                if (this.parameters == null) {
                    yield "{}";
                }

                final StringBuilder parameters = new StringBuilder().append(Brace.START.getTag());
                final String comma = Delimiter.comma();

                this.parameters.forEach(parameter -> {
                    parameters.append(this.toString(parameter));
                    parameters.append(comma);
                });

                parameters.setLength(parameters.length() - comma.length());
                parameters.append(Brace.END.getTag());

                yield parameters.toString();
            }
        };
    }

    /**
     * オブジェクトの型を判定し対応する文字列表現へ変換し返却します。
     * <p>
     * 引数として渡された値が {@link String} クラスのインスタンスを持つ場合は {@code "\""}
     * を値の前後に付与します。また、引数として渡された値が {@link Character} クラスのインスタンスを持つ場合は {@code "'"}
     * を値の前後に付与します。
     *
     * @param parameter 変換対象のオブジェクト
     * @return {@code object} を文字列表現へ変換した値
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private String toString(@NonNull Map<Class<?>, Object> parameter) {

        for (final Entry<Class<?>, Object> entry : parameter.entrySet()) {
            final Class<?> clazz = entry.getKey();

            if (clazz.equals(String.class)) {
                return String.format("\"%s\"", String.valueOf(entry.getKey()));
            } else if (clazz.equals(Character.class)) {
                return String.format("'%s'", String.valueOf(entry.getKey()));
            } else {
                return String.valueOf(entry.getKey());
            }
        }

        // it doesn't happen
        return "";
    }
}
