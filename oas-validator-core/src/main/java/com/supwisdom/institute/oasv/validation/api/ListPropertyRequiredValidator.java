package com.supwisdom.institute.oasv.validation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public abstract class ListPropertyRequiredValidator<T, P> implements OasObjectValidator<T> {

  @Override
  final public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    T oasObject) {

    if (StringUtils.isNotBlank(get$ref(oasObject))) {
      return emptyList();
    }

    List<P> listProperty = getListProperty(oasObject);
    if (CollectionUtils.isEmpty(listProperty)) {
      OasObjectPropertyLocation propertyLoc = location.property(getListPropertyName(), getElementType());
      return singletonList(new OasViolation(propertyLoc, ViolationMessages.REQUIRED));
    }
    return emptyList();

  }

  protected abstract String get$ref(T oasObject);

  protected abstract List<P> getListProperty(T oasObject);

  protected abstract String getListPropertyName();

  protected abstract OasObjectType getElementType();
}