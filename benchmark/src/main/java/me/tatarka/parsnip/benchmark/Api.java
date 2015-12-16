/*
 * Copyright 2015 Evan Tatarka.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.tatarka.parsnip.benchmark;

import me.tatarka.parsnip.ParsnipConverterFactory;
import me.tatarka.parsnip.Xml;
import retrofit.Retrofit;

public class Api {

    public Api() {
        final Xml xml = new Xml.Builder().build();
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ParsnipConverterFactory.create())
                .build();
    }
}