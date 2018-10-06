package mybatis.mapper;

import mybatis.Blog;
import org.apache.ibatis.annotations.Select;

/**
 * @author fxd
 * @date 2018/10/6
 */
public interface BlogMapper {

    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog selectBlog(int id);
}
