package com.csci4050.movie.api.showing;

import com.csci4050.movie.api.model.Showing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowingService {

    @Autowired
    private ShowingRepository showingRepository;

    public Optional<Showing> saveShowing(Showing showing) {
        showingRepository.save(showing);
        return Optional.empty();
    }

    public Optional<Showing> getConflictingShow(Showing showing) {
        // check for date and time conflict

        // optional return object
        Optional<Showing> returnShowing = Optional.empty();

        // find everything with same date
        List<Showing> showDate = showingRepository.findAllByDateAndRoomid(showing.getDate(), showing.getRoomid());
        // convert to showing object
        Showing[] showingDate = new Showing[showDate.size()];
        for(int i = 0; i < showDate.size(); i++) {
            showingDate[i] = showDate.get(i);
        }



        // if showing's start time or end time is within the duration of an existing showing, return the existing showing
        for(Showing s : showingDate) {
            // starting time check (if showing starts after start of another show, or before the end of another show)
            if (showing.getTime() >= s.getTime() && showing.getTime() <= s.getTime() + s.getDuration()) {
                returnShowing = Optional.of(s);
            }

            // ending time check (if show ends after the start of another show, or before the end of another show)
            if (showing.getTime() + showing.getDuration() >= s.getTime() && showing.getTime() + showing.getDuration() <= s.getTime() + s.getDuration()) {
                returnShowing = Optional.of(s);
            }
        }

        return returnShowing;
    }

    public Optional<Showing> removeShowing(Showing showing) {
        showingRepository.delete(showing);
        return Optional.of(showing);
    }
}
