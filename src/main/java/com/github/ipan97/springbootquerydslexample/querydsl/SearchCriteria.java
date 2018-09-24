package com.github.ipan97.springbootquerydslexample.querydsl;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ipan Taupik Rahman
 */
@Getter
@Setter
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
