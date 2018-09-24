package com.github.ipan97.springbootquerydslexample.controller.api.v1;

import com.github.ipan97.springbootquerydslexample.entity.User;
import com.github.ipan97.springbootquerydslexample.querydsl.UserPredicatesBuilder;
import com.github.ipan97.springbootquerydslexample.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ipan Taupik Rahman
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserApiV1Controller {
    private final UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    @ResponseBody
    public Iterable<User> search(@RequestParam(value = "search") String search) {
        UserPredicatesBuilder builder = new UserPredicatesBuilder();

        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
            }
        }
        BooleanExpression exp = builder.build();
        return userRepository.findAll(exp);
    }
}
