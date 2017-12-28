package me.nsarvar;

import me.nsarvar.model.User;
import me.nsarvar.util.UserUtil;
import me.nsarvar.vo.CreateUserVO;
import me.nsarvar.vo.UpdateUserVO;
import me.nsarvar.vo.UserVO;
import org.springframework.stereotype.Component;

/**
 * Created by nsarvar on 12/27/17.
 */
@Component
public class UserAssembler {
    /**
     * CreateUserVO convert to User.
     *
     * @param createUserVO
     * @return
     */
    public User toUser(CreateUserVO createUserVO) {
        User user = new User();
        user.setFirstName(createUserVO.getFirstName());
        user.setLastName(createUserVO.getLastName());
        user.setUsername(createUserVO.getUsername());
        return user;
    }


    /**
     * User to UserVO.
     *
     * @param user
     * @return
     */
    public UserVO toUserVO(User user) {
        UserVO userVO = new UserVO();
        userVO.setUserId(user.getId());
        userVO.setFullName(UserUtil.convertToFullName(user.getFirstName(), user.getLastName()));
        userVO.setUsername(user.getUsername());
        return userVO;

    }

    /**
     * UpdateUserVO to user.
     *
     * @param updateUserVO
     * @return
     */
    public User toUser(UpdateUserVO updateUserVO) {
        User user = new User();
        user.setId(updateUserVO.getUserId());
        user.setFirstName(updateUserVO.getFirstName());
        user.setLastName(updateUserVO.getLastName());
        user.setUsername(updateUserVO.getUsername());
        return user;
    }
}
