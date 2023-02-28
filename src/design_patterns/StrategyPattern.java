package design_patterns;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class StrategyPattern {
    // Strategy is a behavioral design pattern that lets you
    // define a family of algorithms, put each of them into a
    // separate class, and make their objects interchangeable.

    // WithOut the Strategy pattern
    class Duck {
        void quack(){}
        void display(){}
        void fly(){}
    }
    class WildDuck extends Duck{
        @Override
        void quack(){
            // some different quack algo
        }
        void display(){
            // say this is algo 1
        }
    }
    class CityDuck extends Duck{
        @Override
        void quack(){
            // some different quack algo
        }
        void display(){
            // say this is also algo 1
        }
    }
    // how to remove the code redendecy in the display methord for both.
    class RubberDuck extends Duck{
        @Override
        void fly(){
            // no fly algo
        }
    }

    // with statergy pattern
    interface IFlyBehaviour {
        void fly();
    }
    interface IQuackBehaviour {
        void quack();
    }
    @FunctionalInterface
    interface IDisplayBehaviour {
        void display();
    }

    interface Iduck {
        void quack();
        void display();
        void fly();
    }

    class DuckWihtStrategy implements Iduck{
        IFlyBehaviour flyBehaviour;
        IDisplayBehaviour displayBehaviour;
        IQuackBehaviour quackBehaviour;
        public DuckWihtStrategy(IFlyBehaviour fb, IDisplayBehaviour db, IQuackBehaviour qb ){
            this.flyBehaviour = fb;
            this.displayBehaviour = db;
            this.quackBehaviour = qb;
        }
        @Override
        public void fly() {
            this.flyBehaviour.fly();
        }
        @Override
        public void quack() {
            this.quackBehaviour.quack();
        }
        @Override
        public void display() {
            this.displayBehaviour.display();
        }
    }

    class SimpleFly implements IFlyBehaviour{
        @Override
        public void fly() {
            // simple fly
        }
    }
    class JetFly implements IFlyBehaviour{
        @Override
        public void fly() {
            // Jet fly
        }
    }
    class TextDisplay implements IDisplayBehaviour {
        @Override
        public void display() {
            // text display logic
        }
    }
    class SimpleQuack implements IQuackBehaviour{
        @Override
        public void quack() {
            // simple quack
        }
    }

    // because it is a functional interface u can direcly create the objects like this
    IQuackBehaviour LoudQuack = ()->{};

    // Now when u want the CityDuck
    DuckWihtStrategy cityDuckS = new DuckWihtStrategy(new SimpleFly(), new TextDisplay(), new SimpleQuack());

    // similaly wild duck is
    DuckWihtStrategy wildDuckS = new DuckWihtStrategy(()->{}, ()->{}, LoudQuack);

    Class cls = wildDuckS.getClass();

    Method[] methods = cls.getMethods();

    // Printing method names
//    for( var i = 0 ; i < methods.length; i++ )
//        System.out.println(methods[i].getName());







}
