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

package com.supwisdom.institute.oasv.diffvalidation.skeleton.openapi;

import com.supwisdom.institute.oasv.diffvalidation.api.InfoDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ObjectPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OpenApiDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.INFO;

public class OpenApiInfoDiffValidator
  extends ObjectPropertyDiffValidator<OpenAPI, Info>
  implements OpenApiDiffValidator {

  public OpenApiInfoDiffValidator(List<InfoDiffValidator> pathsDiffValidators) {
    super(pathsDiffValidators);
  }

  @Override
  protected Info getPropertyObject(OpenAPI oasObject) {
    return oasObject.getInfo();
  }

  @Override
  protected String getPropertyName() {
    return "info";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return INFO;
  }

}
