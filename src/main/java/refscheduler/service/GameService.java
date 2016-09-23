package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.util.DozerMapper;
import refscheduler.domain.GameCreate;
import refscheduler.domain.GameGet;
import refscheduler.entity.GameEntity;
import refscheduler.repository.GameRepository;
import refscheduler.repository.PersonRepository;
import refscheduler.repository.TeamRepository;

/**
 * Game service.
 */
@Service("gameService")
public class GameService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Long createGame(final GameCreate gameCreate) {
        final GameEntity entity = new GameEntity();

        if (gameCreate.getTeamA() != null) {
            entity.setTeamA(teamRepository.findOne(gameCreate.getTeamA()));
        }

        if (gameCreate.getTeamB() != null) {
            entity.setTeamB(teamRepository.findOne(gameCreate.getTeamB()));
        }

        entity.setTime(gameCreate.getTime().toDate());

        if (gameCreate.getHeadReferee() != null) {
            entity.setHeadReferee(personRepository.findOne(gameCreate.getHeadReferee()));
        }

        if (gameCreate.getAssistantRefereeA() != null) {
            entity.setAssistantRefereeA(personRepository.findOne(gameCreate.getAssistantRefereeA()));
        }

        if (gameCreate.getAssistantRefereeB() != null) {
            entity.setAssistantRefereeB(personRepository.findOne(gameCreate.getAssistantRefereeB()));
        }

        if (gameCreate.getAssistantRefereeC() != null) {
            entity.setAssistantRefereeC(personRepository.findOne(gameCreate.getAssistantRefereeC()));
        }

        if (gameCreate.getAssistantRefereeD() != null) {
            entity.setAssistantRefereeD(personRepository.findOne(gameCreate.getAssistantRefereeD()));
        }

        if (gameCreate.getSnitchReferee() != null) {
            entity.setSnitchReferee(personRepository.findOne(gameCreate.getSnitchReferee()));
        }

        if (gameCreate.getSnitch() != null) {
            entity.setSnitch(personRepository.findOne(gameCreate.getSnitch()));
        }

        entity.setPitch(gameCreate.getPitch());

        gameRepository.save(entity);

        return entity.getGameId();
    }

    public GameGet getGame(final Long gameId) {
        final GameEntity entity = gameRepository.findOne(gameId);

        return mapper.map(entity, GameGet.class);
    }
}
