import Observer.Operators;
import observables.*;

public class MyRxClass {
    public static void main(String[] args) {
        FirstGenericTutorial.run();
        CreateBasicObservables.run();
        ObserverIntroduction.run();
        observables.ColdHotConnectableObservables.run();
        EmptyAndNeverObservable.run();
        ReactiveLoop.run();
        CallableToLazy.run();
        ObservableInterval.run();
        Operators.run();
    }

}
