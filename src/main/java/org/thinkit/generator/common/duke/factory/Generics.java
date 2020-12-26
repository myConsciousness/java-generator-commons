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

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * プログラムリソースにおける総称型を抽象化した抽象クラスです。<br>
 * この抽象クラスでは総称型の定義に必要な情報を保持します。<br>
 * この抽象クラスを継承する具象クラスは必ず {@link JavaComponent#createResource()} を実装してください。
 *
 * @author Kato Shinya
 * @since 1.0
 * @version 1.0
 */
@ToString
@EqualsAndHashCode
public abstract class Generics implements JavaComponent {

    /**
     * 総称型リスト
     */
    @Getter(AccessLevel.PROTECTED)
    private List<String> generics = new ArrayList<>(0);

    /**
     * デフォルトコンストラクタ
     */
    protected Generics() {
    }

    /**
     * 引数として渡された文字列を総称型で指定するデータ型として追加します。
     *
     * @param dataType 総称型に設定するデータ型
     * @return 自分自身のインスタンス
     */
    public Generics add(@NonNull String dataType) {
        this.generics.add(dataType);
        return this;
    }

    /**
     * 設定された総称型が存在するか判定します。
     * <p>
     * 設定された総称型が存在する場合は {@code true} を返却し、それ以外の場合は {@code false} を返却します。
     *
     * @return 設定された総称型が存在する場合は {@code true} 、それ以外は {@code false}
     */
    public boolean isEmpty() {
        return this.generics.isEmpty();
    }
}
