package app.caueferreira.oneapptocatchthemall.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import app.caueferreira.oneapptocatchthemall.domain.executor.ThreadExecutor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by caue.ferreira on 9/9/16.
 */

public class ListPokemonCaseTest {

    @Mock
    private Pokedex pokedex;
    @Mock
    private ThreadExecutor subscriberOn;
    @Mock
    private ThreadExecutor observerOn;


    private ListPokemonCase listPokemonCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.listPokemonCase = new ListPokemonCase(subscriberOn, observerOn, pokedex);
    }


    @Test
    public void testGetPokemonListPokemonCaseObservableHappyCase() {
        listPokemonCase.list(0, 10);

        verify(pokedex).list(0, 10);
        verifyNoMoreInteractions(pokedex);
        verifyZeroInteractions(subscriberOn);
        verifyZeroInteractions(observerOn);
    }
}