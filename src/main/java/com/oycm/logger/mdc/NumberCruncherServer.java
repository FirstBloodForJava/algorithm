package com.oycm.logger.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyangcm
 * create 2025/4/16 9:07
 */
public class NumberCruncherServer extends UnicastRemoteObject
        implements NumberCruncher {

    private static final long serialVersionUID = 1L;

    static Logger logger = LoggerFactory.getLogger(NumberCruncherServer.class);

    public NumberCruncherServer() throws RemoteException {
    }

    public int[] factor(int number) throws RemoteException {
        // MDC 设置client 主机
        try {
            MDC.put("client", NumberCruncherServer.getClientHost());
        } catch (java.rmi.server.ServerNotActiveException e) {
            logger.warn("Caught unexpected ServerNotActiveException.", e);
        }

        // 请求参数
        MDC.put("number", String.valueOf(number));

        logger.info("开始计算因数");

        if (number <= 0) {
            throw new IllegalArgumentException(number + "不能是负数");
        } else if (number == 1) {
            return new int[]{1};
        }

        List<Integer> list = new ArrayList<>();
        int n = number;

        for (int i = 2; i <= n; i++) {

            if ((n % i) == 0) {
                logger.info("找到因数r " + i);
                list.add(i);
            }

            // sleep 100 ms
            delay(100);
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        // clean up
        MDC.remove("client");
        MDC.remove("number");

        return result;
    }



    public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {

        NumberCruncherServer ncs;

        // 设置logback.xml

        try {
            ncs = new NumberCruncherServer();
            logger.info("Creating registry.");

            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            registry.rebind("Factor", ncs);
            logger.info("NumberCruncherServer bound and ready.");
        } catch (Exception e) {
            logger.error("Could not bind NumberCruncherServer.", e);

        }
    }
}
