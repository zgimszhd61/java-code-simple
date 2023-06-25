package com.freedom.javacodesimple.api.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class SpelController {
    @GetMapping("/spel/bad01")
    public String rce01(String cmd) throws IOException {
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression expression = spelExpressionParser.parseExpression(cmd);
        String out = (String) expression.getValue();
        out = out.concat(" get");
        return out;
    }
}
