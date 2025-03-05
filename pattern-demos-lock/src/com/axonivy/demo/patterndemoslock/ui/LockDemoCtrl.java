package com.axonivy.demo.patterndemoslock.ui;

import com.axonivy.demo.patterndemoslock.service.LockService;

public class LockDemoCtrl {
	
	public LockDemoCtrl() {
	}

	private static final String DEMO_LOCK_NAME = "demoLock";

	public void lock() {
		LockService.get().lock(DEMO_LOCK_NAME);
	}
	
	public void unlock() {
		LockService.get().unlock(DEMO_LOCK_NAME);
	}
	
	public boolean isLocked() {
		return LockService.get().isLocked(DEMO_LOCK_NAME);
	}
	
}
