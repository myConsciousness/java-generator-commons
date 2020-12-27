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

import org.thinkit.generator.common.duke.catalog.LombokState;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Javaの構成部品を抽象化したクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
public abstract class JavaComponent implements Component {

    /**
     * Lombok適用状態
     */
    @Getter(AccessLevel.PROTECTED)
    private LombokState lombokState = LombokState.NONE;

    /**
     * Lombokを適用します。
     */
    public void applyLombok() {
        this.lombokState = LombokState.LOMBOK;
    }

    /**
     * JavaコンポーネントがLombokを適用されているか判定します。
     *
     * @return JavaコンポーネントがLombokを適用している場合は {@code true} , それ以外は {@code false}
     */
    public boolean isLombok() {
        return this.lombokState == LombokState.LOMBOK;
    }
}
