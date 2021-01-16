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
 * プログラムリソースにおける処理を抽象化した抽象クラスです。<br>
 * この抽象クラスでは処理定義に必要な情報を保持します。<br>
 * この抽象クラスを継承する具象クラスは必ず {@link JavaComponent#createResource()} を実装してください。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class Process extends JavaComponent {

    /**
     * 処理
     */
    @Getter(AccessLevel.PROTECTED)
    private String process;

    /**
     * デフォルトコンストラクタ
     */
    @SuppressWarnings("unused")
    private Process() {
    }

    /**
     * コンストラクタ
     *
     * @param process 処理
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    protected Process(@NonNull String process) {
        this.process = process;
    }
}
