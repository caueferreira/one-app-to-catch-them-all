package app.caueferreira.oneapptocatchthemall.domain.interactor;

import javax.inject.Inject;

import app.caueferreira.oneapptocatchthemall.data.repository.Pokedex;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by caueferreira on 8/26/16.
 */

public class ListPokemonCase {

    private final Pokedex pokedex;

    private Subscription subscription = Subscriptions.empty();
    private Observable observable;

    @Inject
    public ListPokemonCase(){
        pokedex = new Pokedex();
    }

    public Observable list(final int offset, final int limit){
        observable = pokedex.list(offset,limit);
        return observable;
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
