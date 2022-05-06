package Virtus;

import robocode.*;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;
import robocode.robotinterfaces.peer.IBasicRobotPeer;
import robocode.robotinterfaces.peer.IStandardRobotPeer;
import java.awt.*;

import java.io.PrintStream;

public class Loketa implements IBasicEvents, IBasicRobot, Runnable {
	
	PrintStream out;
	IStandardRobotPeer peer;

	public Runnable getRobotRunnable() {
		return this;
	}

	public IBasicEvents getBasicEventListener() {
		return this;
	}

	public void setPeer(IBasicRobotPeer iRobotPeer) {
		peer = (IStandardRobotPeer) iRobotPeer;
		peer.setGunColor(Color.white);
		peer.setBodyColor(Color.white);
		peer.setRadarColor(Color.white);
		peer.setScanColor(Color.white);
	}

	public void setOut(PrintStream printStream) {
		out = printStream;
	}

	public void run() {
		while (true) {
			peer.setGunColor(Color.white);
			peer.setBodyColor(Color.white);
			peer.setRadarColor(Color.white);
			peer.setScanColor(Color.white);
			peer.move(200);
			peer.turnGun(Math.PI * 2);
			peer.move(-200);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		peer.setGunColor(Color.red);
		peer.setFire(5);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		peer.turnBody(Math.PI / 2 + e.getBearingRadians());
		peer.move(200);
		peer.execute();
	}

	public void onStatus(StatusEvent e) {}

	public void onBulletHit(BulletHitEvent e) {
		peer.fire(1);
		peer.turnBody(Math.PI / 2);
		peer.move(200);
		peer.execute();
	}

	public void onBulletHitBullet(BulletHitBulletEvent e) {
		peer.fire(1);
		peer.execute();
	}

	public void onBulletMissed(BulletMissedEvent e) {
		peer.turnBody(Math.PI / 2);
		peer.move(200);
		peer.execute();
	}

	public void onDeath(DeathEvent e) {}

	public void onHitRobot(HitRobotEvent e) {}

	public void onHitWall(HitWallEvent e) {
	}

	public void onRobotDeath(RobotDeathEvent e) {}

	public void onWin(WinEvent e) {}	
}
