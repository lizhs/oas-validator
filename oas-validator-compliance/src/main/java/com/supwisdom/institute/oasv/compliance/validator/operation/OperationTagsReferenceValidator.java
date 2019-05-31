package com.supwisdom.institute.oasv.compliance.validator.operation;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.OperationValidator;
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