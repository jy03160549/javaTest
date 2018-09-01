package com.alitest;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FileGroupFilter {

	private ExecutorService fileReadExecutor = new ThreadPoolExecutor(10, 100, 0L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>());

	private void readFile(String fileDirPath) {

		File f = new File(fileDirPath);
		if (f.isDirectory()) {
			String[] fileList = f.list();
			for (String file : fileList) {
				if (file.endsWith(".txt")) {
					fileReadExecutor.submit(new FileRead(file));
				} else {
					File fother = new File(file);
					if (fother.isDirectory()) {
						readFile(file);
					}
				}

			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
