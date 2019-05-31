package com.supwisdom.institute.oasv.validation.skeleton.paths;

import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.PathItemValidator;
import com.supwisdom.institute.oasv.validation.api.PathsValidator;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.validation.util.OasObjectValidatorUtils.doValidateProperty;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#pathsObject">Paths Object</a>
 * /{path} (Map [String, <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#pathItemObject">Path Item Object</a>])校验器
 */
public class PathsPathItemsValidator implements PathsValidator {

  private final List<PathItemValidator> pathItemValidators;

  public PathsPathItemsValidator(List<PathItemValidator> pathItemValidators) {
    this.pathItemValidators = pathItemValidators;
  }

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location, Paths oasObject) {
    List<OasViolation> violations = new ArrayList<>();

    for (Map.Entry<String, PathItem> entry : oasObject.entrySet()) {
      String path = entry.getKey();
      PathItem pathItem = entry.getValue();
      OasObjectPropertyLocation pathItemLocation = location.property(path, OasObjectType.PATH_ITEM);
      violations.addAll(doValidateProperty(context, pathItemLocation, pathItem, pathItemValidators));
    }

    return violations;
  }

}