package com.zx.create.Singleton.enums;

/**
 * <p>
 * description: 枚举单例实现  <br>
 * create: 2024-03-22 15:44 <br>
 * </p>
 *
 * @author zhou  xun
 */
public enum SingletonEnum {
    INSTANCE;

    // 这里可以定义单例对象需要的方法
    public void showMessage() {
        System.out.println("枚举在JVM中本身就是单例的，且枚举的构造器是私有的，所以通过枚举来实现单例模式既简单又安全");
    }

    public static void main(String[] args) {
        // 使用枚举实现单例，直接通过枚举名访问唯一实例
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        singleton.showMessage();

        // 尝试通过反射攻击单例
        try {
            SingletonEnum anotherInstance = Enum.valueOf(SingletonEnum.class, "INSTANCE");
            System.out.println("另一个实例: " + (anotherInstance == singleton)); // 输出: true
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
