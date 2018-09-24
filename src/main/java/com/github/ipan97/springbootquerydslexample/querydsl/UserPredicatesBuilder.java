package com.github.ipan97.springbootquerydslexample.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ipan Taupik Rahman
 */
public class UserPredicatesBuilder {
    private List<SearchCriteria> params;

    public UserPredicatesBuilder(List<SearchCriteria> params) {
        this.params = params;
    }

    public UserPredicatesBuilder with(String key, String operation, Object value) {
        params.add(SearchCriteria.builder()
                .key(key)
                .operation(operation)
                .value(value)
                .build());

        return this;
    }

    public BooleanExpression build() {
        if (params.size() == 0) {
            return null;
        }

        List<BooleanExpression> predicates = new ArrayList<>();
        UserPredicate predicate;
        for (SearchCriteria param : params) {
            predicate = new UserPredicate(param);
            BooleanExpression exp = predicate.getPredicate();
            if (exp != null) {
                predicates.add(exp);
            }
        }
        BooleanExpression result = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            result = result.and(predicates.get(i));
        }
        return result;
    }
}
