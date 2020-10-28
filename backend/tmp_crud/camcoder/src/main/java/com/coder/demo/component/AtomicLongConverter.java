package com.coder.demo.component;

import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AtomicLongConverter implements AttributeConverter<AtomicLong, Long> {


 @Override
 public Long convertToDatabaseColumn(AtomicLong attribute) {
  return attribute.get();
 }

 @Override
 public AtomicLong convertToEntityAttribute(Long dbData) {
  return new AtomicLong(dbData);
 }

}

//출처 : https://stackoverflow.com/questions/46173921/how-to-persist-an-atomicinteger-in-hibernate-instead-of-integer
