package refscheduler.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import refscheduler.domain.AffiliationType;

import javax.persistence.*;

/**
 * Team affiliation entity.
 */
@Entity
@Table(name = "TEAM_AFFILIATION")
public class TeamAffiliationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AFFILIATION_ID")
    private Long affiliationId;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private TeamEntity team;

    @Enumerated(EnumType.STRING)
    private AffiliationType affiliation;

    public Long getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(Long affiliationId) {
        this.affiliationId = affiliationId;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }

    public AffiliationType getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(AffiliationType affiliation) {
        this.affiliation = affiliation;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
