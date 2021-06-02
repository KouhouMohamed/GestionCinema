package com.kouhou.jee.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeanceResponse {
	private Long id;
	
	private Date dateDebut;
}
