package com.sergei.server;


import com.sergei.entity.User;
import java.util.List;

/**
 * @author sergei
 * @create 2020-03-17
 */
public interface UserService {

    int add(User user);

    List<User> findPage(int pageNum, int PageSize);

    User findByUser(long id);

    User findByUser(String userName,String passWord);

    User selectByUserName(String userName);

    int updateUser(User user);

    int delete(Long id);

    List<User> list();
}
