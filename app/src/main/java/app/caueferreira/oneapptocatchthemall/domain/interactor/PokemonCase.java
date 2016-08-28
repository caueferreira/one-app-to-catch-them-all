package app.caueferreira.oneapptocatchthemall.domain.interactor;

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

    protected Observable withObservable(final Observable observable){
        this.observable = observable;
        return this.observable;
    }

    public void execute(final Subscriber pokemonCaseSubscriber) {
        this.subscription = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pokemonCaseSubscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
