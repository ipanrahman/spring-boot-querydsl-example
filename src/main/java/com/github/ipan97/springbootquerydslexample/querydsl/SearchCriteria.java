package com.github.ipan97.springbootquerydslexample.querydsl;

import lombok.*;

/**
 * @author Ipan Taupik Rahman
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
