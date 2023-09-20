package article_guide.article_guide_rest.service;

import article_guide.article_guide_rest.dto.UserInfo;
import article_guide.article_guide_rest.entity.User;
import article_guide.article_guide_rest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * 회원등록 서비스
     */
    public boolean signUpService(UserInfo userInfo) {
        /*회원가입 조건 있을 경우 추가
         * 현재 조건 x */

        User insertObject = User
                .builder()
                .id(userInfo.getUserId())
                .password(userInfo.getUserPassword())
                .name(userInfo.getUserName())
                .email(userInfo.getUserEmail())
                .build();
        User savedUser = userRepository.save(insertObject);

        return savedUser != null;
    }

    /**
     * 회원 조회 서비스
     */
    public UserInfo findUserInformation(String userId) {
        User byUserId = userRepository.findByUserId(userId);

        if (byUserId == null) {
            return null;
        }

        UserInfo result = UserInfo.builder()
                .userId(byUserId.getUserId())
                .userPassword(byUserId.getUserPassword())
                .userName(byUserId.getUserName())
                .userEmail(byUserId.getUserEmail())
                .build();

        return result;
    }


}

