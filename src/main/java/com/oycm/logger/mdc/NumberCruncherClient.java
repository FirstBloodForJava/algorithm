package com.oycm.logger.mdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class NumberCruncherClient {

    // args[0] = localhost
    public static void main(String[] args) {

        String host;
        if (args.length == 1) {
            host = args[0];
        } else {
            host = "localhost";
        }

        try {
            String url = "rmi://" + host + "/Factor";
            NumberCruncher nc = (NumberCruncher) Naming.lookup(url);
            loop(nc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void loop(NumberCruncher nc) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;

        while (true) {
            System.out.print("输入要计算因数的数, '-1'表示退出: ");

            try {
                i = Integer.parseInt(in.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (i == -1) {
                System.out.print("退出循环");
                // 退出
                return;
            } else {
                try {
                    System.out.println("要计算的数" + i);

                    int[] factors = nc.factor(i);
                    System.out.print(i + "的因数有: ");

                    for (int k = 0; k < factors.length; k++) {
                        System.out.print(" " + factors[k]);
                    }

                    System.out.println(".");
                } catch (RemoteException e) {
                    System.err.println("不能计算因数" + i);
                    e.printStackTrace();
                }
            }
        }
    }
}
