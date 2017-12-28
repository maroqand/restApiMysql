package me.nsarvar.repo;

import me.nsarvar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nsarvar on 12/27/17.
 * @Repository annotation allows the component scanning support to find and configure your DAOs and
 * repositories without having to provide XML configuration entries for them
 *
 * Spring data supports following interfaces.
 * CrudRepository – provides basic crud functionalities.
 * JpaRepository – provides JPA related functionalities such as persist, flush, batch delete, etc.
 * PagingAndSortingRepository – provides additional functionalities such as paging and sorting.
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
