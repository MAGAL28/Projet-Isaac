package main;
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	GamePanel gp;

	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;

	// Debug
	boolean checkDrawTime = false;

	// #13
	// Pause play gamme
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	// RETURN, LEFT, UP, RIGHT, DOWN, MAJ, ESCAPE;
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		// TITLE STATE
		if (gp.gameState == gp.titleState) {
			if (code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if (gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}

			}
			if (code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if (gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}

			}
			if (code == KeyEvent.VK_ENTER) {
				if (gp.ui.commandNum == 0) {
					gp.gameState = gp.playState;
					// gp.playMusic(0);
				}
				if (gp.ui.commandNum == 1) {

					// add Later
				}
				if (gp.ui.commandNum == 2) {

					System.exit(0);
				}

			}
			if (code == KeyEvent.VK_I) {
				// enterPressed = true;
			}
		}

		else if (gp.gameState == gp.playState) {
			// PLAY STATE
			if (code == KeyEvent.VK_Z) {
				upPressed = true;
			}
			if (code == KeyEvent.VK_S) {
				downPressed = true;
			}
			if (code == KeyEvent.VK_Q) {
				leftPressed = true;
			}
			if (code == KeyEvent.VK_D) {
				rightPressed = true;
			}
			if (code == KeyEvent.VK_P) {
				gp.gameState = gp.pauseState;
			}
			if (code == KeyEvent.VK_ENTER) {
				enterPressed = true;
			}
			// DEBUG
			// Voir le temps qui s'écoule à l'écran
			if (code == KeyEvent.VK_T) {
				if (checkDrawTime == false) {
					checkDrawTime = true;
				} else if (checkDrawTime == true) {
					checkDrawTime = false;
				}
			}
		}
		// PAUSE STATE
		else if (gp.gameState == gp.pauseState) {
			if (code == KeyEvent.VK_P) {
				gp.gameState = gp.playState;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_Z) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_Q) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if (code == KeyEvent.VK_ENTER) {
			enterPressed = false;
		}

	}

}
