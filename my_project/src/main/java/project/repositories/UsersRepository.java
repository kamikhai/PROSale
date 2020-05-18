package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.dto.InformationDto;
import project.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {

    @Query("select new project.dto.InformationDto(user.name, (sum(document.size) / 1024/ 1024) ) " +
            "from User user left join user.documents as document where user.id = :userId " +
            "group by user.id")
    InformationDto getInformationByUser(@Param("userId") Long userId);
}
