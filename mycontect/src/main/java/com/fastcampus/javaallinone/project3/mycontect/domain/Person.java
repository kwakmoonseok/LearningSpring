package com.fastcampus.javaallinone.project3.mycontect.domain;

import com.fastcampus.javaallinone.project3.mycontect.domain.dto.Birthday;
import lombok.*;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    private String hobby;
    @NonNull
    private String bloodType;
    private String address;

    @Embedded
    private Birthday birthday = new Birthday();

    private String job;
    @ToString.Exclude
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Block block;
}
