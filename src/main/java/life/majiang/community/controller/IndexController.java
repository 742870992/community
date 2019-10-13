package life.majiang.community.controller;

/**
 * @ClassName:HelloController
 * @Auther:Administrator
 * @Date:2019/10/13-0:44
 * @Version:0.1
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Administrator
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

}
