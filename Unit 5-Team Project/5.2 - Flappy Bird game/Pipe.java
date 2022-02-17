// Yunseo
public class Pipe {
	
	// Declare variables 
	private int xPos;
	private int gapPos;
	private boolean display;
	private boolean collide = false;
	
	// Set initial values with constructor
	public Pipe(int xPos, int gapPos, boolean display) {
		this.xPos = xPos;
		this.gapPos = gapPos;
		this.display = display;
	}

	// Get the x-position of the pipe
	public int getXPos() {
		return this.xPos;
	}
	// Set x-position of the pipe  
	public void setXPos(int XPos) {
		this.xPos = XPos;
	}
	// Get the position of the gap 
	public int getGapPos() {
		return this.gapPos;
	}
	// Get the value of display to determine visibility of the pipe 
	public boolean getDisplay() {
		return this.display;
	}

	// Check if the bird collides with the pipe based on the gap position
	public boolean collision(int birdXPos, int pipeXPos, int gapPos, int birdYPos) {
		
		// Check if the bird is passing the pipe  
		if ((birdXPos <= pipeXPos + 55) && (birdXPos >= pipeXPos - 20)) {
			
			// If the gap position is 1
			if (gapPos == 1) {
				// Check if the bird is not flying within the y values of the gap
				if (birdYPos <= 500 || (birdYPos + 20) >= 700) {
					// If not, the bird will collide
					collide = true;
				} 
			}
			// If the gap position is 2, check if the bird is not flying within the y values of the gap
			else if (gapPos == 2) {
				if (birdYPos <= 400 || (birdYPos + 20) >= 600) {
					collide = true;
				}
			}
			// If the gap position is 3, check if the bird is not flying within the y values of the gap
			else if (gapPos == 3) {
				if (birdYPos <= 300 || (birdYPos + 20) >= 500) {
					collide = true;

				}
			}
			// If the gap position is 4, check if the bird is not flying within the y values of the gap
			else if (gapPos == 4) {
				if (birdYPos <= 200 || (birdYPos + 20) >= 400) {
					collide = true;

				}
			}
			// If the gap position is 5, check if the bird is not flying within the y values of the gap
			else if (gapPos == 5) {
				if (birdYPos <= 100 || (birdYPos + 20) >= 300) {
					collide = true;

				}
			}
			// If the gap position is 6, check if the bird is not flying within the y values of the gap
			else if (gapPos == 6) {
				if (birdYPos <= 0 || (birdYPos + 20) >= 200) {
					collide = true;
				}
			}
 		}
		
		return collide;
	}

}
