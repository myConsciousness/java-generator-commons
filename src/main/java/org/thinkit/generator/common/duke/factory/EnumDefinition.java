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
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * プログラムリソースにおける列挙子の定義を抽象化した抽象クラスです。
 * <p>
 * この抽象クラスでは列挙子の基本情報を定義します。この抽象クラスを継承する具象クラスは必ず
 * {@link JavaComponent#createResource()} を実装してください。
 * <p>
 * 列挙子に固有の値を設定したい場合は {@link EnumDefinition} クラスのインスタンスを生成した後に
 * {@link #add(Object)} メソッドを呼び出してください。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class EnumDefinition extends JavaComponent {

    /**
     * 列挙子の値の区切り文字
     */
    private static final String CODE_VALUE_DELIMITER = ", ";

    /**
     * 列挙定数名
     */
    @Getter(AccessLevel.PROTECTED)
    private String literal;

    /**
     * 引数マップ
     */
    @Getter(AccessLevel.PROTECTED)
    private List<Map<Class<?>, Object>> values;

    /**
     * デフォルトコンストラクタ
     */
    @SuppressWarnings("unused")
    private EnumDefinition() {
    }

    /**
     * 引数として渡された情報を基に {@link EnumDefinition} クラスの新しいインスタンスを生成し返却します。
     *
     * @param literal 列挙定数名
     */
    protected EnumDefinition(@NonNull String literal) {
        this.literal = literal;
    }

    /**
     * 引数として渡された値を列挙子に設定する値として追加します。この {@link #add(Object)}
     * メソッドは自分自身のインスタンスを返却するため、メソッドチェーンの形式で後続の処理を行うことが可能です。
     *
     * @param clazz 引数のクラスオブジェクト
     * @param value 列挙子固有の値をとして設定する任意の型の値
     * @return 自分自身のインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public EnumDefinition put(@NonNull Class<?> clazz, @NonNull Object parameter) {

        if (this.values == null) {
            this.values = new ArrayList<>(0);
        }

        this.values.add(Map.of(clazz, parameter));
        return this;
    }

    /**
     * {@link #add(Object)} メソッドで設定された列挙子固有の値を実際のソースコードで解析可能な文字列に変換し返却します。
     * 列挙子固有の値が設定されなかった場合は必ず空文字列を返却します。
     * <p>
     * 参考に以下の例を提示します。
     *
     * <pre>
     * 列挙子の値が1つ設定されている場合:
     * <code>
     * getCodeValue();
     * >> {@code "\"test\""}
     * </code>
     * </pre>
     *
     * <pre>
     * 列挙子の値が複数設定されている場合（文字列型とその他のデータ型）:
     * <code>
     * getCodeValue();
     * >> {@code "\"test\", 10, true"}
     * </code>
     * </pre>
     *
     * @return ソースコードで解析可能な形式に変換された列挙子の値
     */
    protected String getCodeValue() {

        if (this.values.isEmpty()) {
            return "";
        }

        return String.join(CODE_VALUE_DELIMITER, this.toCodeValues());
    }

    /**
     * {@link #add(Object)}
     * メソッドで設定された列挙子の値リストを文字列型のリストに変換します。設定された任意のデータ型の値を文字列型へ変換する際に
     * {@link #toCode(Object)} メソッドを使用し実際のソースコードで解析可能な形式へ変換します。
     *
     * @return 文字列型へ変換された値のリスト
     */
    private List<String> toCodeValues() {
        return this.values.stream().map(value -> this.toCode(value)).collect(Collectors.toList());
    }

    /**
     * 引数として指定された任意のデータ型の値をソースコードで解析可能な文字列型の値に変換し返却します。
     * <p>
     * 引数として渡された値が {@link String} クラスのインスタンスを持つ場合は {@code "\""}
     * を値の前後に付与します。また、引数として渡された値が {@link Character} クラスのインスタンスを持つ場合は {@code "'"}
     * を値の前後に付与します。
     *
     * @param value 変換対象のオブジェクト
     * @return ソースコードで解析可能な形式に変換された文字列型の値
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private String toCode(@NonNull Map<Class<?>, Object> value) {

        for (final Entry<Class<?>, Object> entry : value.entrySet()) {
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
