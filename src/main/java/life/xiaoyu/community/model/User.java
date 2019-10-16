package life.xiaoyu.community.model;

import lombok.Data;

/**
 * @ClassName:User
 * @Auther:Administrator
 * @Date:2019/10/16-0:29
 * @Version:0.1
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;

}
