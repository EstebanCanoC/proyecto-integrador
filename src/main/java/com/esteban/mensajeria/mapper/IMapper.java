package com.esteban.mensajeria.mapper;

public interface IMapper<I, O> {
    public O map(I in);
}
