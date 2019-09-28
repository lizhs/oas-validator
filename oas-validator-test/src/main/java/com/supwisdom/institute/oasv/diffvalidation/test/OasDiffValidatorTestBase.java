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

package com.supwisdom.institute.oasv.diffvalidation.test;

import com.supwisdom.institute.oasv.OasSpecLoader;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasSpecDiffValidator;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public abstract class OasDiffValidatorTestBase extends OasSpecLoader {

  @Autowired
  protected OasSpecDiffValidator oasSpecDiffValidator;

  protected final OasDiffValidationContext createContext(OpenAPI leftOpenAPI, OpenAPI rightOpenAPI) {
    OasDiffValidationContext context = new OasDiffValidationContext(leftOpenAPI, rightOpenAPI);
    return context;
  }

  protected void initContext(OasDiffValidationContext context) {
  }

  /**
   * 两边path一样
   *
   * @param error
   * @param path
   * @return
   */
  protected final OasDiffViolation createViolationBoth(String error, Object[] path) {
    OasObjectPropertyLocation location = createLocation(path);
    return new OasDiffViolation(location, location, error);
  }

  protected final OasDiffViolation createViolationLeft(String error, Object[] leftPath) {
    return new OasDiffViolation(createLocation(leftPath), null, error);
  }

  protected final OasDiffViolation createViolationRight(String error, Object[] rightPath) {
    return new OasDiffViolation(null, createLocation(rightPath), error);
  }

  protected final OasDiffViolation createViolation(String error, Object[] leftPath, Object[] rightPath) {
    return new OasDiffViolation(createLocation(leftPath), createLocation(rightPath), error);
  }

  private final OasObjectPropertyLocation createLocation(Object[] path) {
    if (path == null) {
      return null;
    }
    OasObjectPropertyLocation loc = OasObjectPropertyLocation.root();
    for (int i = 0; i < path.length; i = i + 2) {
      loc = loc.property((String) path[i], (OasObjectType) path[i + 1]);
    }
    return loc;
  }

}
