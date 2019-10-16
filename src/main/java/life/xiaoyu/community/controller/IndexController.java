package life.xiaoyu.community.controller;

/**
 * @ClassName:HelloController
 * @Auther:Administrator
 * @Date:2019/10/13-0:44
 * @Version:0.1
 */
import life.xiaoyu.community.mapper.UserMapper;
import life.xiaoyu.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            System.out.println("请重新登录");
        }else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }else {
                        System.out.println("用户不存在");
                    }
                    break;
                }
            }
        }
            return "index";
    }
}
