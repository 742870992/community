package life.xiaoyu.community.mapper;

import life.xiaoyu.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName:UserMapper
 * @Auther:Administrator
 * @Date:2019/10/16-0:22
 * @Version:0.1
 */
@Mapper
public interface UserMapper {
    @Insert("insert into USER (NAME, ACCOUNT_ID, TOKEN, GMT_CREATE, GMT_MODIFIED) values (#{name} ,#{accountId} ,#{token} ,#{gmtCreate} ,#{gmtModified} )")
    void insert(User user);

    @Select("select * from USER where TOKEN= #{token}")
    User findByToken(@Param("token") String token);
}
