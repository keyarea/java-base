package DesignMode.策略模式;

/**
 * 飞行行为接口
 */
interface FlyBehavior {
    void fly();
}

/**
 * 叫声行为接口
 */
interface QuackBehavior {
    void quack();
}

/**
 * 不会飞的行为类
 */
class FlyNoWay implements FlyBehavior {

    @Override
    public void fly(){
        System.out.println("我不会飞");
    };
}

/**
 * 会飞的行为类
 */
class FlyWithWings implements FlyBehavior {

    @Override
    public void fly(){
        System.out.println("我会飞");
    }
}


/**
 * 嘎嘎叫的行为类
 */
class Quack implements QuackBehavior {

    @Override
    public void quack(){
        System.out.println("我会嘎嘎叫");
    }
}

/**
 * 吱吱叫的行为类
 */
class Squeak implements QuackBehavior {

    @Override
    public void quack(){
        System.out.println("我会吱吱叫");
    }
}

/**
 * 不会叫的行为类
 */
class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("我不会叫");
    }
}


abstract class Duck {

    // 为行为接口类型声明两个引用变量,所有的鸭子类都继承他们
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){};

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();  // 委托给行为类
    };

    public void performQuack(){
        quackBehavior.quack(); // 委托给行为类
    }

    public void swim() {
        System.out.println("我会游泳");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }

}


class MallardDuck extends Duck {

    public MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display(){
        System.out.println("红头");
    }

}

public class MiniDuckSimulator {

    public static void main(String[] args){
        Duck duck = new MallardDuck();
        // duck.setFlyBehavior(new FlyNoWay());
        // duck.setQuackBehavior(new MuteQuack());
        duck.display();
        duck.performFly();
        duck.performQuack();
        duck.swim();
    }

}