package mybatis.mapper;

import mybatis.Blog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author fxd
 * @date 2018/10/6
 */
public interface BlogMapper {

    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog selectBlog(int id);

    @Update("UPDATE blog set name = #{str} where id = #{id}")
    void updateBlog(@Param("id") int id, @Param("str") String str);
}
