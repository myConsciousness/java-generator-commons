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

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * プログラムリソースにおけるフィールド定義を抽象化した抽象クラスです。<br>
 * この抽象クラスではフィールド定義に必要な情報を保持します。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class FieldDefinition extends JavaComponent {

    /**
     * データ型
     */
    @Getter(AccessLevel.PROTECTED)
    private String dataType;

    /**
     * 変数名
     */
    @Getter(AccessLevel.PROTECTED)
    private String variableName;

    /**
     * 初期値
     */
    private String initialValue = null;

    /**
     * デフォルトコンストラクタ
     */
    @SuppressWarnings("unused")
    private FieldDefinition() {
    }

    /**
     * コンストラクタ
     *
     * @param dataType     データ型
     * @param variableName 変数名
     * @param initialValue 初期値
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    protected FieldDefinition(@NonNull String dataType, @NonNull String variableName) {
        this.dataType = dataType;
        this.variableName = variableName;
    }

    /**
     * コンストラクタ
     *
     * @param dataType     データ型
     * @param variableName 変数名
     * @param initialValue 初期値
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    protected FieldDefinition(@NonNull String dataType, @NonNull String variableName, @NonNull String initialValue) {
        this.dataType = dataType;
        this.variableName = variableName;
        this.initialValue = initialValue;
    }

    /**
     * {@link FieldDefintiion} のインスタンス生成時に指定されたフィールドのデータ型に基づいて初期値を加工し返却します。
     * <p>
     * 指定されたデータ型が文字列型の場合はダブルクオーテーションを指定された初期値に付与し、文字型の場合はクオーテーションを指定された初期値に付与します。初期値が指定されていない場合は空文字列を返却します。
     *
     * @return {@link FieldDefintiion} のインスタンス生成時に指定されたフィールドのデータ型に基づいて加工された初期値
     */
    protected String getInitialValue() {

        if (this.initialValue == null) {
            return "";
        }

        return switch (this.dataType) {
            case "String" -> String.format("\"%s\"", initialValue);
            case "char", "Character" -> String.format("'%s'", initialValue);
            default -> initialValue;
        };
    }
}
