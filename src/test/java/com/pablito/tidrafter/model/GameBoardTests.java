package com.pablito.tidrafter.model;

import com.pablito.tidrafter.domain.model.GameBoardElement;
import com.pablito.tidrafter.domain.model.SixPlayerGameBoard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class GameBoardTests {
    @Test
    public void AddElement_WithNonExistingElementOnEmptyField_ShouldReturnTrue() {
        final SixPlayerGameBoard board = new SixPlayerGameBoard();
        final GameBoardElement newElement = new GameBoardElement("test");

        assertThat(board.addGameElement(newElement, 1, 2)).isTrue();
    }

    @Test
    public void AddElement_WithExistingElementOnEmptyField_ShouldReturnFalse() {
        final SixPlayerGameBoard board = new SixPlayerGameBoard();
        final GameBoardElement existingElement = new GameBoardElement("test");
        board.addGameElement(existingElement, 1, 2);

        final GameBoardElement newElement = new GameBoardElement("test");

        assertThat(board.addGameElement(newElement, 2, 3)).isFalse();
    }

    @Test
    public void AddElement_WithNonExistingElementOnTakenField_ShouldReturnFalse() {
        final SixPlayerGameBoard board = new SixPlayerGameBoard();
        final GameBoardElement existingElement = new GameBoardElement("existing");
        board.addGameElement(existingElement, 1, 2);

        final GameBoardElement newElement = new GameBoardElement("test");

        assertThat(board.addGameElement(newElement, 1, 2)).isFalse();
    }

    @Test
    public void AddElement_OnLockedField_ShouldReturnFalse() {
        final SixPlayerGameBoard board = new SixPlayerGameBoard();
        final GameBoardElement newElement = new GameBoardElement("test");

        assertThat(board.addGameElement(newElement, 1, 1)).isFalse();
    }

    @Test
    public void AddElement_ExceedingTopLeftBoundaries_ShouldReturnFalse() {
        final SixPlayerGameBoard board = new SixPlayerGameBoard();
        final GameBoardElement newElement = new GameBoardElement("test");

        assertThat(board.addGameElement(newElement, 0, -1)).isFalse();
    }

    @Test
    public void AddElement_ExceedingTopRightBoundaries_ShouldReturnFalse() {
        final SixPlayerGameBoard board = new SixPlayerGameBoard();
        final GameBoardElement newElement = new GameBoardElement("test");

        assertThat(board.addGameElement(newElement, 0, 5)).isFalse();
    }

    @Test
    public void AddElement_ExceedingBottomLeftBoundaries_ShouldReturnFalse() {
        final SixPlayerGameBoard board = new SixPlayerGameBoard();
        final GameBoardElement newElement = new GameBoardElement("test");

        assertThat(board.addGameElement(newElement, 7, -1)).isFalse();
    }

    @Test
    public void AddElement_ExceedingBottomRightBoundaries_ShouldReturnFalse() {
        final SixPlayerGameBoard board = new SixPlayerGameBoard();
        final GameBoardElement newElement = new GameBoardElement("test");

        assertThat(board.addGameElement(newElement, 7, 5)).isFalse();
    }

    @Test
    public void GetElement_WithTakenLocation_ShouldReturnElement() {
        final SixPlayerGameBoard board = new SixPlayerGameBoard();
        final GameBoardElement existingElement = new GameBoardElement("test");
        board.addGameElement(existingElement, 1, 2);

        assertThat(board.getGameElement(1, 2).get()).isEqualTo(existingElement);
    }

    @Test
    public void GetElement_WithNonExistingElement_ShouldReturnEmptyOptional() {
        final SixPlayerGameBoard board = new SixPlayerGameBoard();
        final GameBoardElement existingElement = new GameBoardElement("test");
        board.addGameElement(existingElement, 1, 2);

        assertThat(board.getGameElement(1, 3).isPresent()).isFalse();
    }
}
