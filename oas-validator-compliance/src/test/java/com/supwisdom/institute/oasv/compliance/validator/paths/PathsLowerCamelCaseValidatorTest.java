package com.supwisdom.institute.oasv.compliance.validator.paths;

import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.PathsValidator;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
import com.supwisdom.institute.oasv.validation.config.OasValidatorsSkeletonConfiguration;


import com.supwisdom.institute.oasv.compliance.validator.OasComplianceTestBase;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.PATHS;
import static com.supwisdom.institute.oasv.common.OasObjectType.PATH_ITEM;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = PathsLowerCamelCaseValidatorTest.TestConfiguration.class)
public class PathsLowerCamelCaseValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidate() {
    OpenAPI openAPI = loadRelative("petstore-paths-lower-camel-case.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "paths", PATHS,
        "/pets/{PetId}", PATH_ITEM
      ),
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "paths", PATHS,
        "/Pets", PATH_ITEM
      )
    );
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {

    @Bean

    public PathsValidator pathsValidator() {

      return new PathsLowerCamelCaseValidator();
    }

  }

}