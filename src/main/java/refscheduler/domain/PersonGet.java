package refscheduler.domain;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Random;

/**
 * Person Get DTO.
 */
public class PersonGet implements Comparable<PersonGet> {

    private Long personId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private Level headRefereeLevel;

    private Level assistantRefereeLevel;

    private Level snitchRefereeLevel;

    private Boolean snitch;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Level getHeadRefereeLevel() {
        return headRefereeLevel;
    }

    public void setHeadRefereeLevel(Level headRefereeLevel) {
        this.headRefereeLevel = headRefereeLevel;
    }

    public Level getAssistantRefereeLevel() {
        return assistantRefereeLevel;
    }

    public void setAssistantRefereeLevel(Level assistantRefereeLevel) {
        this.assistantRefereeLevel = assistantRefereeLevel;
    }

    public Level getSnitchRefereeLevel() {
        return snitchRefereeLevel;
    }

    public void setSnitchRefereeLevel(Level snitchRefereeLevel) {
        this.snitchRefereeLevel = snitchRefereeLevel;
    }

    public Boolean getSnitch() {
        return snitch;
    }

    public void setSnitch(Boolean snitch) {
        this.snitch = snitch;
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

    @Override
    public int compareTo(final PersonGet that) {
        if (this.equals(that)) {
            return 0;
        }

        final int hrComparison = this.headRefereeLevel.compareTo(that.headRefereeLevel);
        final int arComparison = this.assistantRefereeLevel.compareTo(that.assistantRefereeLevel);
        final int srComparison = this.snitchRefereeLevel.compareTo(that.snitchRefereeLevel);

        if (hrComparison == 0) {
            if (arComparison == 0) {
                if (srComparison == 0) {
                    Random random = new Random();
                    return random.nextInt(3) - 1;
                } else {
                    return srComparison;
                }
            } else {
                return arComparison;
            }
        } else {
            return hrComparison;
        }
    }
}
