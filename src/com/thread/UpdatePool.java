package com.thread;

import com.bufferpool.Buffer;
import com.ui.PoolUI;
import com.ui.SendUI;

public class UpdatePool implements Runnable{
	PoolUI u = new PoolUI();
	public UpdatePool(PoolUI t){
		u=t;
	}
	@Override
	public void run() {
		u.repaint();
		// TODO Auto-generated method stub
		Buffer.poolStop=false;
	}

}
