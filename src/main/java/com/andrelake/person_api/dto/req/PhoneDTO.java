package com.andrelake.person_api.dto.req;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.andrelake.person_api.enums.Phonetype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

	private Long id;

    @Enumerated(EnumType.STRING)
    private Phonetype type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
