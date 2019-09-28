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

package com.supwisdom.institute.oasv.compatibility.validators.header;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.headers.Header;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInResponse;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * 不允许在responses.'response'.headers.headers 下删除Header Object
 */
public class HeaderDelInResponseNotAllowedDiffValidator extends OasObjectDiffValidatorTemplate<Header>
  implements HeaderDiffValidator {

  @Override
  protected List<OasDiffViolation> validateDel(OasDiffValidationContext context,
    OasObjectPropertyLocation rightLocation, Header rightOasObject) {
    if (!isInResponse(context)) {
      return emptyList();
    }
    return singletonList(OasDiffViolation.onlyLeft(rightLocation, DiffViolationMessages.OP_DEL_FORBIDDEN));
  }

}
