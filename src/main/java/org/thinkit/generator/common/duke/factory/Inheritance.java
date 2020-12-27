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
 * プログラムリソースにおける継承を抽象化した抽象クラスです。<br>
 * この抽象クラスでは継承の定義に必要な情報を保持します。<br>
 * この抽象クラスを継承する具象クラスは必ず {@link JavaComponent#createResource()} を実装してください。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class Inheritance extends JavaComponent {

    /**
     * 継承名
     */
    @Getter(AccessLevel.PROTECTED)
    private String literal;

    /**
     * 総称型
     */
    @Getter(AccessLevel.PROTECTED)
    private Generics generics;

    /**
     * デフォルトコンストラクタ
     */
    @SuppressWarnings("unused")
    private Inheritance() {
    }

    /**
     * コンストラクタ
     *
     * @param literal 継承名
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    protected Inheritance(@NonNull String literal) {
        this.literal = literal;
    }

    /**
     * コンストラクタ
     *
     * @param literal  継承名
     * @param generics 総称型
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    protected Inheritance(@NonNull String literal, @NonNull Generics generics) {
        this.literal = literal;
        this.generics = generics;
    }

    /**
     * 総称型が設定されているか判定します。
     * <p>
     * 総称型が設定されている場合は {@code true} を返却し、それ以外の場合は {@code false} を設定します。
     *
     * @return 総称型が設定されている場合は {@code true} 、それ以外は {@code false}
     */
    protected boolean hasGenerics() {
        return this.generics != null;
    }
}
