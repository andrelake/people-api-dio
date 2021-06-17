package com.andrelake.person_api.utils;

import com.andrelake.person_api.dto.req.PhoneDTO;
import com.andrelake.person_api.enums.Phonetype;
import com.andrelake.person_api.model.Phone;

public class PhoneUtils {

	private static final Long PHONEID = 1L; 
	private static final Phonetype PHONETYPE = Phonetype.MOBILE; 
	private static final String PHONENUMBER = "(15)943219876"; 
	
	public static PhoneDTO createFakeDTO() {
		
		return PhoneDTO.builder()
				.type(PHONETYPE)
				.number(PHONENUMBER)
				.build();
	}
	
	public static Phone createFakeEntity() {
		
		return Phone.builder()
				.id(PHONEID)
				.type(PHONETYPE)
				.number(PHONENUMBER)
				.build();
	}
}
