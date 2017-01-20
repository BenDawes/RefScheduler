package refscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import refscheduler.entity.TeamAffiliationEntity;
import refscheduler.entity.TeamEntity;

import java.util.List;

/**
 * The team affiliation repository.
 */
@Repository
public interface TeamAffiliationRepository extends JpaRepository<TeamAffiliationEntity, Long> {

    List<TeamAffiliationEntity> findByTeam(final TeamEntity teamEntity);
}
