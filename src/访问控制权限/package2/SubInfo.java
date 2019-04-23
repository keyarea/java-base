package 访问控制权限.package2;  // 不同包
import 访问控制权限.package1.Info;

// 不同包的子类

public class SubInfo extends Info{ // Info的子类
    public void priint(){
        System.out.println(super.str); // 在父类中属于protected权限
    }
}
