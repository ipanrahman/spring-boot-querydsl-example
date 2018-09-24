package com.github.ipan97.springbootquerydslexample.querydsl;

import com.github.ipan97.springbootquerydslexample.entity.User;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import lombok.AllArgsConstructor;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

/**
 * @author Ipan Taupik Rahman
 */
@AllArgsConstructor
public class UserPredicate {
    private SearchCriteria criteria;

    public BooleanExpression getPredicate() {
        PathBuilder<User> entityPath = new PathBuilder<>(User.class, "users");
        if (isNumeric(criteria.getValue().toString())) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            int value = Integer.parseInt(criteria.getKey());
            switch (criteria.getOperation()) {
                case ":":
                    return path.eq(value);
                case ">":
                    return path.goe(value);
                case "<":
                    return path.loe(value);
            }
        } else {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                return path.containsIgnoreCase(criteria.getValue().toString());
            }
        }
        return null;
    }
}
