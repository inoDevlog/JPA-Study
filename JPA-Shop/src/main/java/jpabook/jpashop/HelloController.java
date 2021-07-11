/*
 * Copyright (c) 2021, ino, Inc. All rights reserved.
 */

package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Choi, Inho <inho.choi@softwareinlife.com>
 * @since 2021/07/10
 */
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello";
    }
}
