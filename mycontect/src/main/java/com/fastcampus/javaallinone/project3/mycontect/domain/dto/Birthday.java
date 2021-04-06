package com.fastcampus.javaallinone.project3.mycontect.domain.dto;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Access;
import javax.persistence.Embeddable;
import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Data
public class Birthday {
    public Integer yearOfBirthday;
    public Integer monthOfBirthday;
    public Integer dayOfBirthday;

    private Birthday(LocalDate birthday) {
        this.yearOfBirthday = birthday.getYear();
        this.monthOfBirthday = birthday.getMonthValue();
        this.dayOfBirthday = birthday.getDayOfMonth();
    }

    public static Birthday of(LocalDate birthday){
        return new Birthday(birthday);
    }
}
