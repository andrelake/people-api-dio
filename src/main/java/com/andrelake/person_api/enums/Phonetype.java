package com.andrelake.person_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Phonetype {
	
	HOME("Home"),
	MOBILE("Mobile"),
	COMMERCIAL("Commercial");

	private String description;
} 
