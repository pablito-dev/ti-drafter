package com.pablito.tidrafter.domain.model;

import java.util.Arrays;
import java.util.List;

public class SixPlayerGameBoard extends GameBoard {
    @Override
    boolean validateLocation(int longitude, int latitude) {
        final Location newLocation = new Location(latitude, longitude);

        return LockedFields.LOCKED_FIELDS.stream().noneMatch(lockedLocation -> lockedLocation.equals(newLocation)) &&
                validateLocationBoundaries(longitude, latitude) && checkIfTaken(longitude, latitude);
    }

    private static class LockedFields {
        private static Location FIRST_PLAYER_LOCATION = new Location(1, 1);
        private static Location SECOND_PLAYER_LOCATION = new Location(1, 4);
        private static Location THIRD_PLAYER_LOCATION = new Location(4, 1);
        private static Location FOURTH_PLAYER_LOCATION = new Location(4, 7);
        private static Location FIFTH_PLAYER_LOCATION = new Location(7, 1);
        private static Location SIXTH_PLAYER_LOCATION = new Location(7, 4);

        private static Location METACOL_LOCATION = new Location(4, 4);

        private static List<Location> LOCKED_FIELDS = Arrays.asList(FIRST_PLAYER_LOCATION,
                SECOND_PLAYER_LOCATION,
                THIRD_PLAYER_LOCATION,
                FOURTH_PLAYER_LOCATION,
                FIFTH_PLAYER_LOCATION,
                SIXTH_PLAYER_LOCATION,
                METACOL_LOCATION);
    }
}
