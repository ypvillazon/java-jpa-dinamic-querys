package cu.sacavix.springboot.jpa.specifications.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by ups on 7/07/18.
 */
@Controller
@ApiIgnore
public class Redirect {
    @RequestMapping(value = {"", "/swagger", "/docs"}, method = RequestMethod.GET)
    public String redirectSwagger() {
        return "redirect:/swagger-ui.html";
    }
}
