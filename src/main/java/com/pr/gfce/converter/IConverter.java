package com.pr.gfce.converter;

import com.pr.gfce.exception.TransformException;

/**
 * @author Oscar Blancarte
 */
public interface IConverter<I,T> {
    
    public T converte(I object) throws TransformException;
}
