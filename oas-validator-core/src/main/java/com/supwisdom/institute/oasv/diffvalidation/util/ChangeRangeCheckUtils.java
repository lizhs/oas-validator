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

package com.supwisdom.institute.oasv.diffvalidation.util;

import java.util.List;
import java.util.Objects;

public class ChangeRangeCheckUtils {

  public static boolean isNotViolated(Object left, Object right, List<Object[]> allowedList) {

    if (Objects.equals(left, right)) {
      return true;
    }
    for (Object[] objects : allowedList) {
      if (Objects.equals(objects[0], left) && Objects.equals(objects[1], right)) {
        return true;
      }
    }
    return false;

  }
}
