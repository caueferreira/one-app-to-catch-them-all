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
 * Created by caueferreira on 9/11/16.
 */

public class PokemonDetailCaseTest {


    @Mock
    private Pokedex pokedex;
    @Mock
    private ThreadExecutor subscriberOn;
    @Mock
    private ThreadExecutor observerOn;


    private PokemonDetailCase pokemonDetailCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.pokemonDetailCase = new PokemonDetailCase(subscriberOn, observerOn, pokedex);
    }


    @Test
    public void testGetPokemonDetailPokemonCaseObservableHappyCase() {
        pokemonDetailCase.get(4);

        verify(pokedex).get(4);
        verifyNoMoreInteractions(pokedex);
        verifyZeroInteractions(subscriberOn);
        verifyZeroInteractions(observerOn);
    }
}