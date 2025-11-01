package com.example;

import java.util.Scanner;

public class arr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String [][] user=new String[10][2];
        user[1][0]="aw";
        user[1][1]="123";

        while(true) {
            System.out.println("\n===== 用户系统 =====");
            System.out.println("1. 登录");
            System.out.println("2. 注册");
            System.out.println("3. 查看所有用户");
            System.out.println("4. 退出");
            System.out.print("请输入功能编号：");

            int num = Integer.parseInt(sc.nextLine());

            switch (num) {
                case 1:
                    System.out.println("使用登录功能");
                    System.out.println("***********************************");
                    System.out.println("请输入用户名：");
                    String username = sc.nextLine();
                    System.out.println("请输入密码：");
                    String password = sc.nextLine();

/*                System.out.println(username);
                System.out.println(password);*/
                    boolean found = false;
                    for (int i = 0; i < user.length; i++)

                        if (username.equals(user[i][0])) {
                            found = true;
                            if (password.equals(user[i][1])) {
                                System.out.println("登录成功");
                                break;
                            } else {
                                System.out.println("密码错误");
                            }
                        }
                    if (!found)
                        System.out.println("用户不存在");
                    break;
                case 2:
                    System.out.println("使用注册功能");
                    System.out.println("请输入用户名：");
                    String newusername = sc.nextLine();
                    System.out.println("请输入密码：");
                    String newpassword = sc.nextLine();
                    for(int i=0;i<user.length;i++){
                        if(user[i][0]==null){
                          user[i][0]=newusername;
                          user[i][1]=newpassword;
                          System.out.println("注册成功");
                          break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("使用查看功能");
                    for(int i=0;i<user.length;i++){
                        if(user[i][0]!=null){
                            System.out.println("第"+i+"个用户："+user[i][0]+"密码："+user[i][1]);
                        }
                    }
                    break;
                default:
                    System.out.println("退出系统");
                    System.exit(0);

            }
        }
        }
    }

