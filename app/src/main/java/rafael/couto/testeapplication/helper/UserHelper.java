package rafael.couto.testeapplication.helper;

import rafael.couto.testeapplication.model.User;

/**
 * Created by rafael.couto on 08/06/2018.
 */

public class UserHelper {
    public String concat(User user){
        if (user == null) throw new NullPointerException("User cannot be null.");
        return "Usuário: "+user.getName()+" default";
    }

}
