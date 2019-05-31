package com.supwisdom.institute.oasv.compliance.validator.schema;

import com.supwisdom.institute.oasv.compliance.validator.OasComplianceTestBase;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.SchemaValidator;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
import com.supwisdom.institute.oasv.validation.config.OasValidatorsSkeletonConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.*;
import static com.supwisdom.institute.oasv.compliance.validator.schema.SchemaKeysValidators.PROPERTIES_LOWER_CAMEL_CASE_VALIDATOR;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = SchemaPropertiesKeysLowerCamelCaseValidatorTest.TestConfiguration.class)
public class SchemaPropertiesKeysLowerCamelCaseValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidateParameter1() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-param-1.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "paths", PATHS,
        "/pets", PATH_ITEM,
        "get", OPERATION,
        "parameters[0]", PARAMETER,
        "schema", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Test
  public void testValidateParameter2() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-param-2.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "parameters.'Foo'", PARAMETER,
        "schema", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Test
  public void testResponse1() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-resp-1.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "paths", PATHS,
        "/pets", PATH_ITEM,
        "get", OPERATION,
        "responses", RESPONSES,
        "200", RESPONSE,
        "content.'application/json'", MEDIA_TYPE,
        "schema", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Test
  public void testResponse2() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-resp-2.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "responses.'Foo'", RESPONSE,
        "content.'application/json'", MEDIA_TYPE,
        "schema", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Test
  public void testRequestBody1() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-req-1.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "paths", PATHS,
        "/pets", PATH_ITEM,
        "post", OPERATION,
        "requestBody", REQUEST_BODY,
        "content.'application/json'", MEDIA_TYPE,
        "schema", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Test
  public void testRequestBody2() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-req-2.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "requestBodies.'Foo'", REQUEST_BODY,
        "content.'application/json'", MEDIA_TYPE,
        "schema", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Test
  public void testComponent() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-comp.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "schemas.'Foo'", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Test
  public void testNested() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-nested.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "schemas.'Foo'", SCHEMA,
        "properties.'Foo'", null
      ),
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "schemas.'Foo'", SCHEMA,
        "properties.'Foo'", SCHEMA,
        "properties.'Bar'", null
      )
    );
  }

  @Test
  public void testAllOf() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-all-of.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "schemas.'Foo'", SCHEMA,
        "allOf[0]", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Test
  public void testAnyOf() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-any-of.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "schemas.'Foo'", SCHEMA,
        "anyOf[0]", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Test
  public void testOneOf() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-one-of.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "schemas.'Foo'", SCHEMA,
        "oneOf[0]", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Test
  public void testArray() {
    OpenAPI openAPI = loadRelative("petstore-schema-p-keys-lower-camel-case-array.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "schemas.'Foo'", SCHEMA,
        "items", SCHEMA,
        "properties.'Foo'", null
      )
    );
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {

    @Bean

    public SchemaValidator schemaValidator() {

      return PROPERTIES_LOWER_CAMEL_CASE_VALIDATOR;
    }
  }

}
