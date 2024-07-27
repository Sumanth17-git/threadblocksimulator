package com.example.threadblocksimulator.service;

import org.springframework.stereotype.Service;

@Service
public class ThreadBlockService {
	 private final Object lock = new Object(); // Lock object to synchronize access
	 
	 
	 public void simulateBlockedThread(long sleepMillis) {
	        try {
	        	 performOperation(sleepMillis);// Simulate thread block
	        } catch (Exception e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	    private void performOperation(long sleepMillis) {
	        synchronized (lock) {
	            try {
	                level1(sleepMillis);
	            } finally {
	            }
	        }
	    }
	    private void level1(long sleepMillis) {
	        synchronized (lock) {
	            level2(sleepMillis);
	        }
	    }

	    private void level2(long sleepMillis) {
	        synchronized (lock) {
	            level3(sleepMillis);
	        }
	    }

	    private void level3(long sleepMillis) {
	        synchronized (lock) {
	            level4(sleepMillis);
	        }
	    }

	    private void level4(long sleepMillis) {
	        synchronized (lock) {
	            level5(sleepMillis);
	        }
	    }

	    private void level5(long sleepMillis) {
	        synchronized (lock) {
	            // Simulate a long-running task
	            try {
	                Thread.sleep(sleepMillis);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }
}
