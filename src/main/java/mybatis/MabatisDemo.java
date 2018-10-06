package mybatis;

import mybatis.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author fxd
 * @date 2018/10/6
 */
public class MabatisDemo {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        try {
            Blog blog = (Blog)session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 1);
            System.out.println("id:"+blog.getId()+" name:"+blog.getName());

            BlogMapper mapper = session.getMapper(BlogMapper.class);
            blog = mapper.selectBlog(2);
            System.out.println("id:"+blog.getId()+" name:"+blog.getName());
        } finally {
            session.close();
        }

        return ;
    }
}
