package app.caueferreira.oneapptocatchthemall.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.caueferreira.oneapptocatchthemall.domain.executor.ThreadExecutor;
import rx.Observable;
import rx.Subscriber;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by caueferreira on 9/8/16.
 */

public class PokemonCaseTest {

    @Mock
    private ThreadExecutor subscriberOn;
    @Mock
    private ThreadExecutor observerOn;

    private PokemonCaseTestClass pokemonCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.pokemonCase = new PokemonCaseTestClass(subscriberOn, observerOn);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testBuildPokemonCaseObservableReturnCorrectResult() {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();

        given(observerOn.getScheduler()).willReturn(Schedulers.immediate());
        given(subscriberOn.getScheduler()).willReturn(Schedulers.immediate());

        pokemonCase.withObservable(Observable.just(1,2,3,4,5));
        pokemonCase.execute(testSubscriber);

        assertThat(testSubscriber.getOnNextEvents().size(), is(5));
    }

    @Test
    public void testSubscriptionWhenExecutingPokemonCase() {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();

        pokemonCase.withObservable(Observable.empty());
        pokemonCase.execute(testSubscriber);
        pokemonCase.unsubscribe();

        assertThat(testSubscriber.isUnsubscribed(), is(true));
    }

    private static class PokemonCaseTestClass extends PokemonCase {

        protected PokemonCaseTestClass(final ThreadExecutor subscriberOn, final ThreadExecutor observerOn) {
            super(subscriberOn, observerOn);
        }

        @Override
        protected Observable withObservable(final Observable observable){
            return super.withObservable(observable);
        }

        @Override
        public void execute(final Subscriber pokemonUseSubscriber) {
            super.execute(pokemonUseSubscriber);
        }
    }
}