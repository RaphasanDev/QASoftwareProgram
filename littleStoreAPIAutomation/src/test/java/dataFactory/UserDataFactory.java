package dataFactory;

import pojo.User;

public class UserDataFactory {

    public static User createAdminUser(){
        User user = new User();
        user.setUsuarioLogin("raphaelsan");
        user.setUsuarioSenha("123456");
        return user;
    }
}
