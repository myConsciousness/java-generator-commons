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
 * プログラムリソースを抽象化した抽象クラスです。<br>
 * この抽象クラスではプログラムリソース定義に必要な情報を保持します。<br>
 * この抽象クラスを継承する具象クラスは必ず {@link #createResource()} を実装してください。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
public abstract class Resource {

    /**
     * 著作権
     */
    @Getter(AccessLevel.PROTECTED)
    private Copyright copyright;

    /**
     * パッケージ名
     */
    @Getter(AccessLevel.PROTECTED)
    private Package packageName;

    /**
     * 依存パッケージ
     */
    @Getter(AccessLevel.PROTECTED)
    private List<DependentPackage> dependentPackages;

    /**
     * クラスボディ部
     */
    @Getter(AccessLevel.PROTECTED)
    private ClassBody classBody;

    /**
     * デフォルトコンストラクタ
     */
    @SuppressWarnings("unused")
    private Resource() {
    }

    /**
     * コンストラクタ
     *
     * @param copyright   著作権
     * @param packageName パッケージ名
     * @param classBody   クラスボディ部
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    protected Resource(@NonNull Copyright copyright, @NonNull Package packageName, @NonNull ClassBody classBody) {
        this.copyright = copyright;
        this.packageName = packageName;
        this.classBody = classBody;
    }

    /**
     * 依存パッケージ定義を追加します。
     *
     * @param dependentPackage 依存パッケージ
     * @return 自分自身のインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public Resource add(@NonNull DependentPackage dependentPackage) {

        if (this.dependentPackages == null) {
            this.dependentPackages = new ArrayList<>(0);
        }

        this.dependentPackages.add(dependentPackage);
        return this;
    }

    /**
     * リソースを生成し文字列表現として返却する処理を定義するメソッドです。
     *
     * @return Javaリソース
     */
    public abstract String createResource();
}
