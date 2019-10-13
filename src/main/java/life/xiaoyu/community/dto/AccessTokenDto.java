package life.xiaoyu.community.dto;

import lombok.Data;

/**
 * @ClassName:AccessTokenDto
 * @Auther:Administrator
 * @Date:2019/10/13-20:27
 * @Version:0.1
 */
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;

}
