package com.zx.docdemo;

import java.io.IOException;
import java.io.Serializable;

/**
 * 这是一个示例类，用于展示Javadoc标签的用法。
 *
 * @author YourName
 * @since 1.0
 * @deprecated 该类已过时，请使用NewExampleClass代替
 */
public class ExampleClass implements Serializable {

    /**
     * 一个序列化的字段
     *
     * @serial 这是一个序列化的字段
     */
    private String serializedField;

    /**
     * 示例方法的说明
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     * @return 返回结果的描述
     * @throws IllegalArgumentException 如果参数无效
     * @see OtherClass 对于相关类的更多信息
     * @deprecated 该方法已过时，请使用newMethod代替
     */
    @Deprecated
    public String exampleMethod(String param1, int param2) throws IllegalArgumentException {
        // 方法实现
        if (param1 == null || param2 < 0) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        return "Example result";
    }

    /**
     * 从父类继承的说明（通常不需要显式添加，除非父类没有注释）
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ExampleClass [serializedField=" + serializedField + "]";
    }

    /**
     * 一个简单的链接到另一个类的示例
     * {@link OtherClass} 是另一个类。
     * {@linkplain OtherClass} 是以纯文本形式链接到另一个类的。
     */
    public void linkToOtherClass() {
        // 方法实现
    }

    // ... 其他方法和字段

    /**
     * 序列化方法的说明（通常不需要为标准的序列化方法添加注释）
     *
     * @serialData 序列化的数据包括serializedField字段的值
     */
    private void writeObject(java.io.ObjectOutputStream out)
            throws java.io.IOException {
        out.defaultWriteObject();
        // 序列化自定义字段（如果需要）
    }

    /**
     * 反序列化方法的说明（通常不需要为标准的反序列化方法添加注释）
     *
     * @throws IOException            如果发生I/O错误
     * @throws ClassNotFoundException 如果找不到类
     */
    private void readObject(java.io.ObjectInputStream in)
            throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject();
        // 反序列化自定义字段（如果需要）
    }

    /**
     * 这是另一个类的示例，用于{@link}和{@linkplain}标签
     */
    class OtherClass {
        // ... 类的实现
    }
}

