package com.fastcampus.javaallinone.project3.mycontect.domain.dto;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Access;
import javax.persistence.Embeddable;
import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Data
public class Birthday {
    public Integer yearOfBirthday;
    @Min(1)
    @Max(12)
    public Integer monthOfBirthday;
    @Min(1)
    @Max(31)
    public Integer dayOfBirthday;
}
