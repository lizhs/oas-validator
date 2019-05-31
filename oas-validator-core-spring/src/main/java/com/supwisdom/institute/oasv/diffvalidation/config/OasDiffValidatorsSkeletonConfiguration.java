package com.supwisdom.institute.oasv.diffvalidation.config;

import com.supwisdom.institute.oasv.diffvalidation.api.*;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.components.*;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.encoding.EncodingHeadersDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.header.HeaderSchemaDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.mediatype.MediaTypeEncodingDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.mediatype.MediaTypeSchemaDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.openapi.*;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.operation.OperationParametersDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.operation.OperationRequestBodyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.operation.OperationResponsesDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.parameter.ParameterContentDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.parameter.ParameterSchemaDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.pathitem.PathItemOperationsDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.pathitem.PathItemParametersDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.paths.PathsPathItemsDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.requestbody.RequestBodyContentDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.response.ResponseContentDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.response.ResponseHeadersDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.responses.ResponsesResponsesDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.skeleton.schema.SchemaDiffValidatorEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OasDiffValidatorsSkeletonConfiguration {

  @Bean
  public OasSpecDiffValidator oasSpecDiffValidator(List<OpenApiDiffValidator> openApiDiffValidators) {
    return new DefaultOasSpecDiffValidator(openApiDiffValidators);
  }

  @Bean
  public ComponentsDiffValidator componentsCallbacksDiffValidator(
    List<CallbackDiffValidator> diffValidators) {
    return new ComponentsCallbacksDiffValidator(diffValidators);
  }

  @Bean
  public ComponentsDiffValidator componentsExamplesDiffValidator(
    List<ExampleDiffValidator> diffValidators) {
    return new ComponentsExamplesDiffValidator(diffValidators);
  }

  @Bean
  public ComponentsDiffValidator componentsHeadersDiffValidator(
    List<HeaderDiffValidator> diffValidators) {
    return new ComponentsHeadersDiffValidator(diffValidators);
  }

  @Bean
  public ComponentsDiffValidator componentsLinksDiffValidator(
    List<LinkDiffValidator> diffValidators) {
    return new ComponentsLinksDiffValidator(diffValidators);
  }

  @Bean
  public ComponentsDiffValidator componentsParametersDiffValidator(
    List<ParameterDiffValidator> diffValidators) {
    return new ComponentsParametersDiffValidator(diffValidators);
  }

  @Bean
  public ComponentsDiffValidator componentsRequestBodiesDiffValidator(
    List<RequestBodyDiffValidator> diffValidators) {
    return new ComponentsRequestBodiesDiffValidator(diffValidators);
  }

  @Bean
  public ComponentsDiffValidator componentsResponsesDiffValidator(
    List<ResponseDiffValidator> diffValidators) {
    return new ComponentsResponsesDiffValidator(diffValidators);
  }

  @Bean
  public EncodingDiffValidator encodingHeadersDiffValidator(
    List<HeaderDiffValidator> diffValidators) {
    return new EncodingHeadersDiffValidator(diffValidators);
  }

  @Bean
  public HeaderDiffValidator headerSchemaDiffValidator(
    List<SchemaDiffValidator> diffValidators) {
    return new HeaderSchemaDiffValidator(diffValidators);
  }

  @Bean
  public MediaTypeDiffValidator mediaTypeEncodingDiffValidator(
    List<EncodingDiffValidator> diffValidators) {
    return new MediaTypeEncodingDiffValidator(diffValidators);
  }

  @Bean
  public MediaTypeDiffValidator mediaTypeSchemaDiffValidator(
    List<SchemaDiffValidator> diffValidators) {
    return new MediaTypeSchemaDiffValidator(diffValidators);
  }

  @Bean
  public OpenApiDiffValidator openApiComponentsDiffValidator(
    List<ComponentsDiffValidator> diffValidators) {
    return new OpenApiComponentsDiffValidator(diffValidators);
  }

  @Bean
  public OpenApiDiffValidator openApiInfoDiffValidator(
    List<InfoDiffValidator> diffValidators) {
    return new OpenApiInfoDiffValidator(diffValidators);
  }

  @Bean
  public OpenApiDiffValidator openApiPathsDiffValidator(
    List<PathsDiffValidator> diffValidators) {
    return new OpenApiPathsDiffValidator(diffValidators);
  }

  @Bean
  public OpenApiDiffValidator openApiServersDiffValidator(
    List<ServerDiffValidator> diffValidators) {
    return new OpenApiServersDiffValidator(diffValidators);
  }

  @Bean
  public OpenApiDiffValidator openApiTagsDiffValidator(
    List<TagDiffValidator> diffValidators) {
    return new OpenApiTagsDiffValidator(diffValidators);
  }

  @Bean
  public OperationDiffValidator operationParametersDiffValidator(
    List<ParameterDiffValidator> diffValidators) {
    return new OperationParametersDiffValidator(diffValidators);
  }

  @Bean
  public OperationDiffValidator operationRequestBodyDiffValidator(
    List<RequestBodyDiffValidator> diffValidators) {
    return new OperationRequestBodyDiffValidator(diffValidators);
  }

  @Bean
  public OperationDiffValidator operationResponsesDiffValidator(
    List<ResponsesDiffValidator> diffValidators) {
    return new OperationResponsesDiffValidator(diffValidators);
  }

  @Bean
  public ParameterDiffValidator parameterContentDiffValidator(
    List<MediaTypeDiffValidator> diffValidators) {
    return new ParameterContentDiffValidator(diffValidators);
  }

  @Bean
  public ParameterDiffValidator parameterSchemaDiffValidator(
    List<SchemaDiffValidator> diffValidators) {
    return new ParameterSchemaDiffValidator(diffValidators);
  }

  @Bean
  public PathItemDiffValidator pathItemOperationsDiffValidator(
    List<OperationDiffValidator> diffValidators) {
    return new PathItemOperationsDiffValidator(diffValidators);
  }

  @Bean
  public PathItemDiffValidator pathItemParametersDiffValidator(
    List<ParameterDiffValidator> diffValidators) {
    return new PathItemParametersDiffValidator(diffValidators);
  }

  @Bean
  public PathsDiffValidator pathsPathItemsDiffValidator(
    List<PathItemDiffValidator> diffValidators) {
    return new PathsPathItemsDiffValidator(diffValidators);
  }

  @Bean
  public RequestBodyDiffValidator requestBodyContentDiffValidator(
    List<MediaTypeDiffValidator> diffValidators) {
    return new RequestBodyContentDiffValidator(diffValidators);
  }

  @Bean
  public ResponseDiffValidator responseContentDiffValidator(
    List<MediaTypeDiffValidator> diffValidators) {
    return new ResponseContentDiffValidator(diffValidators);
  }

  @Bean
  public ResponseDiffValidator responseHeadersDiffValidator(
    List<HeaderDiffValidator> diffValidators) {
    return new ResponseHeadersDiffValidator(diffValidators);
  }

  @Bean
  public ResponsesDiffValidator responsesResponsesDiffValidator(
    List<ResponseDiffValidator> diffValidators) {
    return new ResponsesResponsesDiffValidator(diffValidators);
  }

  @Bean
  public SchemaDiffValidator schemaDiffValidatorEngine(
    List<SchemaAddValidator> schemaNewValidators,
    List<SchemaDelValidator> schemaDelValidators,
    List<SchemaCompareValidator> schemaCompareValidators) {
    return new SchemaDiffValidatorEngine(schemaNewValidators, schemaDelValidators, schemaCompareValidators);
  }

}