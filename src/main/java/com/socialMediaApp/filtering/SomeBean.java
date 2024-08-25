package com.socialMediaApp.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIgnoreProperties("field1")
public class SomeBean {
    private String field1;
    @JsonIgnore
    private String field2;
    private String field3;

}
