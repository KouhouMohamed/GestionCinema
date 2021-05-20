package com.kouhou.jee.response;

import java.util.List;

import com.kouhou.jee.entities.Film;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CategorieResponse {

	private Long id;
	
	private String name;
	
	private List<Film> films;
}
