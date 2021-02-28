package com.cliente.entity.dto;

public interface Parsable<T> {

	/**
	 * 
	 * @param parsable
	 * @return
	 */
	T convert();

}