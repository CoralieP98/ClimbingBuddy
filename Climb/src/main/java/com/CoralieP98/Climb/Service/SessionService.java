package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Repository.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
}
