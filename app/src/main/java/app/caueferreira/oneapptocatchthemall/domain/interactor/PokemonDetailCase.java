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
 * Created by caueferreira on 8/28/16.
 */

public class PokemonDetailCase {

    private final Pokedex pokedex;

    private Subscription subscription = Subscriptions.empty();
    private Observable observable;

    @Inject
    public PokemonDetailCase(){
        pokedex = new Pokedex();
    }

    public Observable get(final int id){
        observable = pokedex.get(id);
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