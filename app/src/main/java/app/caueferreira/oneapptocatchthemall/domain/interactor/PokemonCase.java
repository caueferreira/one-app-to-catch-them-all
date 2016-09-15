package app.caueferreira.oneapptocatchthemall.domain.interactor;

import app.caueferreira.oneapptocatchthemall.domain.executor.ThreadExecutor;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by caueferreira on 8/28/16.
 */

public abstract class PokemonCase {

    private Subscription subscription = Subscriptions.empty();
    private Observable observable;

    private ThreadExecutor subscriberOn, observerOn;

    public PokemonCase() {
        subscriberOn = new ThreadExecutor(Schedulers.newThread());
        observerOn = new ThreadExecutor(AndroidSchedulers.mainThread());
    }

    public PokemonCase(final ThreadExecutor subscriberOn, final ThreadExecutor observerOn) {
        this.subscriberOn = subscriberOn;
        this.observerOn = observerOn;
    }

    protected Observable withObservable(final Observable observable) {
        this.observable = observable;
        return this.observable;
    }

    public void execute(final Subscriber pokemonCaseSubscriber) {
        this.subscription =  observable
                .subscribeOn(subscriberOn.getScheduler())
                .observeOn(observerOn.getScheduler())
                .subscribe(pokemonCaseSubscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
