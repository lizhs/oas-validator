package com.supwisdom.institute.oasv.compliance.validator.paths;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.PathsValidator;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
import io.swagger.v3.oas.models.Paths;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.supwisdom.institute.oasv.util.StringCaseUtils.isLowerCamelCase;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#pathsObject">Paths Object</a>lower camel case校验器
 * <p>
 *   <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#path-templating">Path Templating</a>的变量也要是lower camel case的
 * </p>
 */
public class PathsLowerCamelCaseValidator implements PathsValidator {

  private static final Pattern TEMPLATE_PATTERN = Pattern.compile("^\\{(.*)\\}$");

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location, Paths oasObject) {
    List<OasViolation> violations = new ArrayList<>();

    Set<String> paths = oasObject.keySet();

    for (String path : paths) {
      if (!matchCamelCase(path)) {
        OasObjectPropertyLocation pathLoc = location.property(path, OasObjectType.PATH_ITEM);
        violations.add(new OasViolation(pathLoc, ViolationMessages.LOWER_CAMEL_CASE));
      }

    }

    return violations;
  }

  private boolean matchCamelCase(String path) {

    String[] pathSegments = path.split("/");

    for (String pathSegment : pathSegments) {
      if (StringUtils.isEmpty(pathSegment)) {
        continue;
      }
      String matchingPart = pathSegment;
      if (isTemplate(pathSegment)) {
        matchingPart = extractTemplateVariable(pathSegment);
      }
      if (!isLowerCamelCase(matchingPart)) {
        return false;
      }
    }
    return true;

  }

  /**
   *
   *
   * @param pathSegment
   * @return
   */
  private boolean isTemplate(String pathSegment) {
    return TEMPLATE_PATTERN.matcher(pathSegment).matches();
  }

  private String extractTemplateVariable(String pathSegment) {
    Matcher matcher = TEMPLATE_PATTERN.matcher(pathSegment);
    if (matcher.matches()) {
      return matcher.group(1);
    }
    return "";
  }

}
