package life.xiaoyu.community.controller;

import life.xiaoyu.community.dto.AccessTokenDto;
import life.xiaoyu.community.dto.GithubUser;
import life.xiaoyu.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName:AuthorizeController
 * @Auther:Administrator
 * @Date:2019/10/13-18:30
 * @Version:0.1
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.Client.id}")
    private String clientId;

    @Value("${github.Client_secret}")
    private String clientSecret;

    @Value("${github.Redirect_url}")
    private String redirectUrl;

    @GetMapping("/callback")
    public String callback(@RequestParam(name= "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_url(redirectUrl);
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }

}
