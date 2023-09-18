package article_guide.article_guide_rest.repository;

import article_guide.article_guide_rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserId(String userId);
}
