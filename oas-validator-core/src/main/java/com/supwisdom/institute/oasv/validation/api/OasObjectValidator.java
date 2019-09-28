/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.supwisdom.institute.oasv.validation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;

import java.util.List;

/**
 *
 * @param <T> <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#table-of-contents">OpenAPI Specification</a>所定义的对象
 */
public interface OasObjectValidator<T> {

  /**
   * @param context   校验上下文
   * @param location  OpenAPI Object的位置
   * @param oasObject OpenAPI Object
   * @return 校验违例
   */
  List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location, T oasObject);

}
