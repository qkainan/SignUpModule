import com.qkainan.dao.UserDao;
import com.qkainan.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    private SqlSession session;

    @Before
    public void  init() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //传入对应配置文件的输入流，读取配置文件获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过SqlSessionFactory获取SqlSession对象(理解为一个数据库连接),并用session接受。
        session = sqlSessionFactory.openSession();
    }
    @org.junit.Test
    public void testUserDao() throws IOException {
        //获取UserDao实现类对象(Mapper)
        UserDao userDao = session.getMapper(UserDao.class);
//        User user = new User(22222,"hy", "6666666", "男装");
//        userDao.insertUser(user);
    }

    /*@org.junit.Test
    public void testPageHelper(){
        //设置分页参数
        UserDao userDao = session.getMapper(UserDao.class);
        //设置分页查询参数
        PageHelper.startPage(1,1);
        List<User> users = userDao.findAll();
        System.out.println(users.get(0));

        PageInfo<User> pageInfo = new PageInfo<User>(users);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
    }*/
    @After
    public void destroy(){
        //提交事务，释放资源
        session.commit();
        session.close();
    }
}
