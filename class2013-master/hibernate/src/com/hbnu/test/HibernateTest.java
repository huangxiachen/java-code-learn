package com.hbnu.test;

import com.hbnu.pojo.Customer;
import com.hbnu.pojo.LinkMan;
import com.hbnu.pojo.Player;
import com.hbnu.pojo.Role;
import com.hbnu.pojo.User;
import com.hbnu.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;
import sun.security.ssl.HandshakeInStream;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author chendikai
 * @date 2023-02-22 10:09
 */
public class HibernateTest {

    /**
     * 往数据库表中添加一条数据
     */
    @Test
    public void insertData() {
        // 1、解析并加载hibernate配置文件（直接加载核心配置文件，间接加载映射关系配置文件）
        Configuration configuration = new Configuration().configure();

        // 2、通过配置对象构建会话工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // 3、通过会话工厂生成会话对象
        Session session = sessionFactory.openSession();

        // 4、通过会话对象调用相关方法完成数据库的CRUD操作
        User user = new User();
        user.setUsername("陈迪凯");
        user.setAddress("湖北黄石");
        session.save(user);  // 通过操作实例对象的方式操作数据库

        // 5、关闭会话和会话工厂资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void queryData() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        User user = session.get(User.class, 1);
        System.out.println(user);

        session.close();
        sessionFactory.close();
    }

    @Test
    public void updateData() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // 只要对数据库表中的数据做了改变，则需要添加事务处理操作
        Transaction transaction = session.beginTransaction();  // 开启事务

        // 先查询出需要更新的数据
        User user = session.get(User.class, 1);
        user.setAddress("hubeihuangshi");
        session.update(user);

        transaction.commit();  // 提交事务

        session.close();
        sessionFactory.close();
    }

    @Test
    public void deleteData() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, 1);
        session.delete(user);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    @Test
    public void saveOrUpdateTest() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // 瞬时态：该对象没有id(主键)值，与session对象没有关联
        // User user = new User();
        // user.setUsername("陈小凯");
        // user.setAddress("湖北黄石");
        // session.saveOrUpdate(user);  // 对于瞬时态对象，如果使用saveOrUpdate方法操作该对象，则执行的是添加操作

        Transaction transaction = session.beginTransaction();

        // 托管态：该对象有id(主键)值，与session对象没有关联
        // User user = new User();
        // user.setUid(2);
        // user.setUsername("陈凯");
        // user.setAddress("湖北阳新");
        // session.saveOrUpdate(user);  // 对于托管态对象，使用saveOrUpdate方法操作时，执行的是更新操作，同时托管态对象的id必须在数据库表中已存在

        // 持久态：该对象有id(主键)值，同时与session对象有关联
        User user = session.get(User.class, 2);
        user.setAddress("湖北黄石");
        // session.saveOrUpdate(user);  // 对于持久态对象，使用saveOrUpdate方法操作时，执行的是更新操作

        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    /**
     * 验证一级缓存的存在
     */
    @Test
    public void validateCache() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        User user1 = session.get(User.class, 2);
        System.out.println(user1);

        User user2 = session.get(User.class, 2);
        System.out.println(user2);

        session.close();
        sessionFactory.close();

    }

    @Test
    public void transactionTest() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            User user = session.get(User.class, 1);
            user.setAddress("湖北黄石");

            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }

    @Test
    public void queryTest() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Session session = HibernateUtil.getSession();  // 获取与本地线程绑定的session对象，需要添加事务操作
        // Transaction transaction = session.beginTransaction();

        // 查询所有字段的数据
        // String HQL = "from User";
        // Query<User> query = session.createQuery(HQL, User.class);
        // List<User> list = query.list();

        // transaction.commit();
        // for (User user : list) {
        //     System.out.println(user);
        // }

        // 查询某一个字段的数据
        // String HQL = "select username from User";
        // Query<String> query = session.createQuery(HQL, String.class);
        // List<String> list = query.list();
        // for (String username : list) {
        //     System.out.println(username);
        // }

        // 查询多个属性值
        // String HQL = "SELECT username, address from User";
        // Query<Object[]> query = session.createQuery(HQL, Object[].class);
        // List<Object[]> objects = query.list();
        // for (Object[] object : objects) {
        //     System.out.println(object[0] + "-->" + object[1]);
        // }

        // 条件查询  需求：根据用户名和地址查询数据库数据->  select * from tb_user where name = ? and addr = ?
        // String HQL = "from User where username = ?0 and address = ?1";
        // Query<User> query = session.createQuery(HQL, User.class);
        // query.setParameter(0, "小小凯");
        // query.setParameter(1, "湖北黄石");
        // List<User> userList = query.list();
        // for (User user : userList) {
        //     System.out.println(user);
        // }

        String HQL = "from User where username = :username and address = :address";
        Query<User> query = session.createQuery(HQL, User.class);
        query.setParameter("username", "小小凯");
        query.setParameter("address", "湖北黄石");
        List<User> userList = query.list();
        for (User user : userList) {
            System.out.println(user);
        }

        session.close();
        sessionFactory.close();
    }

    @Test
    public void testCriteria() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        // 查询所有字段
        // CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        // criteriaQuery.from(User.class);
        // Query<User> query = session.createQuery(criteriaQuery);
        // List<User> userList = query.list();
        // for (User user : userList) {
        //     System.out.println(user);
        // }

        // 查询某一个具体的字段
        // CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        // Root<User> root = criteriaQuery.from(User.class);  // 查询的根
        // criteriaQuery.select(root.get("username"));
        // Query<String> query = session.createQuery(criteriaQuery);
        // List<String> userList = query.list();
        // for (String username : userList) {
        //     System.out.println(username);
        // }

        // 条件查询
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("username"), "小小凯"));
        Query<User> query = session.createQuery(criteriaQuery);
        List<User> userList = query.list();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSQLQuery() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // 查询所有字段的数据
        // String sql = "select * from tb_user";
        // NativeQuery sqlQuery = session.createSQLQuery(sql);
        // sqlQuery.addEntity(User.class);
        // List<User> userList = sqlQuery.list();
        // for (User user : userList) {
        //     System.out.println(user);
        // }

        // 查询某一个具体字段的数据
        // String sql = "select name from tb_user";
        // NativeQuery<String> sqlQuery = session.createSQLQuery(sql);
        // List<String> usernames = sqlQuery.list();
        // for (String username : usernames) {
        //     System.out.println(username);
        // }

        // 条件查询
        String sql = "select * from tb_user where name = :name and addr = :addr";
        NativeQuery<User> sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(User.class);
        // sqlQuery.setParameter(0, "小小凯");
        // sqlQuery.setParameter(1, "湖北黄石");
        sqlQuery.setParameter("name", "小小凯");
        sqlQuery.setParameter("addr", "湖北黄石");
        List<User> userList = sqlQuery.list();
        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void testOneToManySaveTest() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // 创建数据
        Customer customer1 = new Customer();
        customer1.setName("百度");
        customer1.setAddress("北京");

        Customer customer2 = new Customer();
        customer2.setName("腾讯");
        customer2.setAddress("深圳");

        LinkMan linkMan1 = new LinkMan();
        linkMan1.setName("小陈");
        linkMan1.setTel("18675241258");
        linkMan1.setGender("男");

        LinkMan linkMan2 = new LinkMan();
        linkMan2.setName("小李");
        linkMan2.setTel("18675241258");
        linkMan2.setGender("男");

        LinkMan linkMan3 = new LinkMan();
        linkMan3.setName("小王");
        linkMan3.setTel("18675241258");
        linkMan3.setGender("男");

        LinkMan linkMan4 = new LinkMan();
        linkMan4.setName("小马");
        linkMan4.setTel("18675241258");
        linkMan4.setGender("男");

        LinkMan linkMan5 = new LinkMan();
        linkMan5.setName("小张");
        linkMan5.setTel("18675241258");
        linkMan5.setGender("男");

        // 维护关系
        customer1.getLinkManSet().add(linkMan1);
        customer1.getLinkManSet().add(linkMan2);
        customer1.getLinkManSet().add(linkMan3);

        customer2.getLinkManSet().add(linkMan4);
        customer2.getLinkManSet().add(linkMan5);

        linkMan1.setCustomer(customer1);
        linkMan2.setCustomer(customer1);
        linkMan3.setCustomer(customer1);

        linkMan4.setCustomer(customer2);
        linkMan5.setCustomer(customer2);

        // 将数据保存到数据库中
        session.save(customer1);
        session.save(customer2);
        //
        // session.save(linkMan1);
        // session.save(linkMan2);
        // session.save(linkMan3);
        // session.save(linkMan4);
        // session.save(linkMan5);

        Customer customer3 = new Customer();
        customer3.setName("小米");
        customer3.setAddress("武汉");

        LinkMan linkMan6 = new LinkMan();
        linkMan6.setName("小贾");
        linkMan6.setTel("028-79456421");
        linkMan6.setGender("女");

        LinkMan linkMan7 = new LinkMan();
        linkMan7.setName("小徐");
        linkMan7.setTel("028-79456421");
        linkMan7.setGender("女");

        customer3.getLinkManSet().add(linkMan6);
        customer3.getLinkManSet().add(linkMan7);

        linkMan6.setCustomer(customer3);
        linkMan7.setCustomer(customer3);

        session.save(customer3);

        session.close();
        sessionFactory.close();
    }

    @Test
    public void testOneToManyDelete() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 3);
        session.delete(customer);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    @Test
    public void testOneToManyUpdate() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 1);
        LinkMan linkMan = session.get(LinkMan.class, 3);
        customer.getLinkManSet().add(linkMan);
        linkMan.setCustomer(customer);

        session.update(customer);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    @Test
    public void testManyToManySave() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // 准备数据
        Player player1 = new Player();
        player1.setName("骚白");
        player1.setGender("男");

        Player player2 = new Player();
        player2.setName("一条小团团");
        player2.setGender("女");

        Role role1 = new Role();
        role1.setName("射手");
        role1.setDescription("远程AD输出");

        Role role2 = new Role();
        role2.setName("辅助");
        role2.setDescription("保护我方输出");

        Role role3 = new Role();
        role3.setName("法师");
        role3.setDescription("远程AP输出");

        // 维护数据关系
        player1.getRoles().add(role1);
        player1.getRoles().add(role2);

        player2.getRoles().add(role2);
        player2.getRoles().add(role3);

        // 保存数据
        session.save(player1);
        session.save(player2);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    @Test
    public void testManyToManyDelete() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Player player = session.get(Player.class, 2);
        session.delete(player);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    @Test
    public void testManyToManyUpdate() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Player player = session.get(Player.class, 1);
        // Role role = session.get(Role.class, 3);
        Role role = session.get(Role.class, 2);

        // player.getRoles().add(role);
        player.getRoles().remove(role);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}