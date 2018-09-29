package com.pablito.tidrafter.domain.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

abstract class GameBoard {
    private Map<Location, GameBoardElement> elements;

    public GameBoard() {
        this.elements = new HashMap<>();
    }

    public boolean addGameElement(final GameBoardElement element, final int longitude, final int latitude) {
        if (validateLocation(longitude, latitude) && validateElement(element)) {
            elements.put(new Location(latitude, longitude), element);
            return true;
        }
        return false;
    }

    public Optional<GameBoardElement> getGameElement(final int longitude, final int latitude) {
        return Optional.ofNullable(elements.get(new Location(latitude, longitude)));
    }

    abstract boolean validateLocation(final int longitude, final int latitude);

    boolean validateLocationBoundaries(final int longitude, final int latitude) {
        if (longitude <= 4 && longitude > 0) {
            return latitude > 0 && latitude <= longitude + 3;
        } else if (longitude == 5) {
            return latitude > 0 && latitude <= 6;
        } else if (longitude == 6) {
            return latitude > 0 && latitude <= 5;
        } else if (longitude == 7) {
            return latitude > 0 && latitude <= 4;
        } else {
            return false;
        }
    }

    boolean checkIfTaken(final int longitude, final int latitude) {
        return !getGameElement(longitude, latitude).isPresent();
    }

    private boolean validateElement(final GameBoardElement element) {
        return elements.entrySet().stream().noneMatch(existingElement -> existingElement.getValue().equals(element));
    }
}
