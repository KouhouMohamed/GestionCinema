package com.kouhou.jee.response;

import java.util.List;

import com.kouhou.jee.entities.Film;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategorieResponse {

	private Long id;
	
	private String name;
}
