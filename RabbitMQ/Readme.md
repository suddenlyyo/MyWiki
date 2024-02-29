# rabbitMQ

## 安装

```
brew install rabbitmq
```

## 启动

方式一：

```
brew services start rabbitmq;
```

**#方式二：进入默认的安装目录下，手动启动**

RabbitMQWeb管理界面及授权操作
默认情况下，rabbitmq是没有安装的

```
rabbitmq-plugins enable rabbitmq_management
```
#新建用户
rabbitmqctl add_user 账号 密码
#给用户分配操作权限
rabbitmqctl set_user_tags 账号 administrator
#修改密码
rabbitmqctl change_password Username Newpassword 修改密码
#删除用户
rabbitmqctl delete_user Username 删除用户
#查看所有用户
rabbitmqctl list_users 查看用户清单
#为用户设置访问权限
rabbitmqctl set_permissions -p / 用户名 ".*" ".*" ".*"
rabbitmqctl set_permissions -p / root ".*" ".*" ".*"

![img.png](img.png)