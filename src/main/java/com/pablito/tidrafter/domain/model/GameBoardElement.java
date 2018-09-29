package com.pablito.tidrafter.domain.model;

import java.util.Objects;

public class GameBoardElement {
    private String name;

    public GameBoardElement(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } ;
        if (o == null || getClass() != o.getClass()) {
            return false;
        } ;
        final GameBoardElement element = (GameBoardElement) o;
        return Objects.equals(name, element.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
