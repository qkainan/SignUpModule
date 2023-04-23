import com.qkainan.dao.UserDao;
import com.qkainan.domain.User;
import com.qkainan.service.impl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
//    @org.junit.Test
//    public void testUserDao() throws IOException {
//        //获取UserDao实现类对象(Mapper)
//        UserDao userDao = session.getMapper(UserDao.class);
//        User user = new User(22222,"hy", "6666666", "男装");
//        userDao.insertUser(user);
//    }


    @After
    public void destroy(){
        //提交事务，释放资源
        session.commit();
        session.close();
    }

//    public static void main(String[] args) {
//
//        //create a container
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext,xml") ;
//        //Fetch object
//        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserService");
//
//
//    }


}
