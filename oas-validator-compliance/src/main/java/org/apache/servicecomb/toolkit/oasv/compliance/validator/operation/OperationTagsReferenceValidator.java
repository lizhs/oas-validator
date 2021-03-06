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

package org.apache.servicecomb.toolkit.oasv.compliance.validator.operation;

import org.apache.servicecomb.toolkit.oasv.common.OasObjectPropertyLocation;
import org.apache.servicecomb.toolkit.oasv.validation.api.OasValidationContext;
import org.apache.servicecomb.toolkit.oasv.validation.api.OasViolation;
import org.apache.servicecomb.toolkit.oasv.validation.api.OperationValidator;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.tags.Tag;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toSet;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#operationObject">Operation Object</a>
 * .tags属性校验器
 * <ul>
 * <li>必须在OpenAPI Object的tags属性里有对应</li>
 * </ul>
 */
public class OperationTagsReferenceValidator implements OperationValidator {

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    Operation oasObject) {

    List<String> tags = oasObject.getTags();
    if (CollectionUtils.isEmpty(tags)) {
      return emptyList();
    }

    List<OasViolation> violations = new ArrayList<>();

    Set<String> globalTagNames = getGlobalTagNames(context.getOpenAPI());
    for (int i = 0; i < tags.size(); i++) {
      String tagName = tags.get(i);
      if (!globalTagNames.contains(tagName)) {
        violations.add(
          new OasViolation(location.property("tags[" + i + "]"), "不在$.tags所定义的范围内"));
      }
    }

    return violations;
  }

  public Set<String> getGlobalTagNames(OpenAPI openAPI) {
    if (CollectionUtils.isEmpty(openAPI.getTags())) {
      return emptySet();
    }
    return openAPI.getTags().stream().map(Tag::getName).collect(toSet());
  }

}
