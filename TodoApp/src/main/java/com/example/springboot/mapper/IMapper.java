package com.example.springboot.mapper;

public interface IMapper <I, O>{
	public O map(I in);
}
