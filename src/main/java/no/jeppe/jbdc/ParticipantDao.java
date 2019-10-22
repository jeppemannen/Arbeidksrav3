package no.jeppe.jbdc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParticipantDao {

    private List<String> participants = new ArrayList<>();

    public void insertParticipant(String participantName) {
        participants.add(participantName);
    }

    public List<String> listAll() {
        return participants;
    }
}
