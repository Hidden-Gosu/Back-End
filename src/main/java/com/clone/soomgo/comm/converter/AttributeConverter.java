package com.clone.soomgo.comm.converter;

public interface AttributeConverter<X,Y>{

    Y convertToDatabaseColumn(X var1);

    X convertToEntityAttribute(Y var1);
}
