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

package com.supwisdom.institute.oasv.compatibility.validators.schema.request;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaTypeFormatChangeValidator;
import com.supwisdom.institute.oasv.compatibility.validators.schema.TypeFormat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInParameter;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInRequestBody;

public class SchemaTypeFormatChangeInRequestValidator extends SchemaTypeFormatChangeValidator {

  private static final List<Object[]> allowedChangedList;

  static {
    Object[][] allowedChange = new Object[][] {
      new Object[] { new TypeFormat("integer", null), new TypeFormat("integer", "int64") },
      new Object[] { new TypeFormat("integer", null), new TypeFormat("number", "double") },
      new Object[] { new TypeFormat("integer", null), new TypeFormat("number", null) },

      new Object[] { new TypeFormat("integer", "int32"), new TypeFormat("integer", "int64") },
      new Object[] { new TypeFormat("integer", "int32"), new TypeFormat("integer", null) },
      new Object[] { new TypeFormat("integer", "int32"), new TypeFormat("number", "float") },
      new Object[] { new TypeFormat("integer", "int32"), new TypeFormat("number", "double") },
      new Object[] { new TypeFormat("integer", "int32"), new TypeFormat("number", null) },

      new Object[] { new TypeFormat("integer", "int64"), new TypeFormat("integer", null) },
      new Object[] { new TypeFormat("integer", "int64"), new TypeFormat("number", "double") },
      new Object[] { new TypeFormat("integer", "int64"), new TypeFormat("number", null) },

      new Object[] { new TypeFormat("number", null), new TypeFormat("number", "double") },

      new Object[] { new TypeFormat("number", "float"), new TypeFormat("number", null) },
      new Object[] { new TypeFormat("number", "float"), new TypeFormat("number", "double") },

      new Object[] { new TypeFormat("number", "double"), new TypeFormat("number", null) },

      new Object[] { new TypeFormat("string", null), new TypeFormat("string", "password") },

      new Object[] { new TypeFormat("string", "password"), new TypeFormat("string", null) },
    };
    allowedChangedList = Collections.unmodifiableList(Arrays.asList(allowedChange));
  }

  @Override
  protected List<Object[]> getAllowedChangedList() {
    return allowedChangedList;
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInRequestBody(context) || isInParameter(context);
  }

}
