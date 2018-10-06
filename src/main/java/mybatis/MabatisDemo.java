package mybatis;

import mybatis.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

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

            Random rd = new Random(System.currentTimeMillis());
            mapper.updateBlog(1, String.valueOf(rd.nextInt()%100));
            blog = mapper.selectBlog(1);
            System.out.println("id:"+blog.getId()+" name:"+blog.getName());
        } finally {
            session.commit();
            session.close();
        }

        return ;
    }
}
