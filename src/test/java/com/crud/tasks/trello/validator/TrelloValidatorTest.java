package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrelloValidatorTest {
    private TrelloValidator trelloValidator = new TrelloValidator();

    @Test
    public void testValidateTrelloBoards() {
        //Given
        TrelloBoard firstBoardStub = new TrelloBoard("0", "test", new ArrayList<>());
        TrelloBoard secondBoardStub = new TrelloBoard("1", "board name (shall pass the validator)", new ArrayList<>());
        List<TrelloBoard> trelloBoardsStub = new ArrayList<>();
        trelloBoardsStub.add(firstBoardStub);
        trelloBoardsStub.add(secondBoardStub);

        //When
        List<TrelloBoard> validatedTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoardsStub);

        List<TrelloBoard> validatedEmptyTrelloBoards = trelloValidator.validateTrelloBoards(new ArrayList<>());

        //Then
        assertEquals(1, validatedTrelloBoards.size());
        assertEquals("board name (shall pass the validator)", validatedTrelloBoards.get(0).getName());
        assertEquals(0, validatedEmptyTrelloBoards.size());
    }
}