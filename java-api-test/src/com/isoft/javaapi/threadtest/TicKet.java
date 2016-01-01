package com.isoft.javaapi.threadtest;

import java.util.concurrent.TimeUnit;

public class TicKet implements Runnable {

	private int ticketNum = 100;
	Object obj = new Object();

	private long toaltime;

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		while (true) {
			synchronized (obj) {
				if (ticketNum > 0) {
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":"
							+ ticketNum--);
				}
			}
			if (ticketNum == 0) {
				break;
			}

		}
		long end = System.currentTimeMillis();
		long timecost = end - start;
		System.out.println("execute:" + timecost);
		//这个地方有线程安全问题
		toaltime = toaltime + timecost;
		System.out.println("toaltime:" + toaltime);
	}
}
