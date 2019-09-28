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

package com.supwisdom.institute.oasv.validation.skeleton.mediatype;

import com.supwisdom.institute.oasv.validation.api.MediaTypeValidator;
import com.supwisdom.institute.oasv.validation.api.SchemaValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#media-type-object">Media Type Object</a>
 * .schema属性校验器
 */
public class MediaTypeSchemaValidator extends ObjectPropertyValidator<MediaType, Schema>
  implements MediaTypeValidator {

  public MediaTypeSchemaValidator(List<SchemaValidator> schemaValidators) {
    super(schemaValidators);
  }

  @Override
  protected String get$ref(MediaType oasObject) {
    return null;
  }

  @Override
  protected Schema getPropertyObject(MediaType oasObject) {
    return oasObject.getSchema();
  }

  @Override
  protected String getPropertyName() {
    return "schema";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return SCHEMA;
  }

}
