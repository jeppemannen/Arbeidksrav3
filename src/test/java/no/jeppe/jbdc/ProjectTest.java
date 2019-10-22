package no.jeppe.jbdc;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class ProjectTest {

    @Test
    void shouldRetriveProjectParticipant() {
        ParticipantDao dao = new ParticipantDao();
        String participantName = pickOne(new String[] {"Knut", "Asbjørn", "Magda", "Silje"});
        dao.insertParticipant(participantName);
        assertThat(dao.listAll()).contains(participantName);

    }

    private String pickOne(String[] strings) {
        return strings[new Random().nextInt(strings.length)];
    }
}
