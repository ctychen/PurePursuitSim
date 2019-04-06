/**
 * Models drivetrain with 2 gearboxes 
 * Does some quicc math
 */
 
public class DriveTrain {

	private DriveTrainGearbox left, right;
	
	private double kWheelBase;
	
	private double kDt, pos_, posx_, posy_, angle_ = 0, anglev_;
	
	public DriveTrain(DriveTrainGearbox left, DriveTrainGearbox right, double kWheelBase, double kDt) {
		this.left = left;
		this.right = right;
		this.kWheelBase = kWheelBase;
		this.kDt = kDt;
	}
	
		
	public double getPos_() {
		return pos_;
	}
	
	public double getAngle_() {
		return angle_;
	}
	
	public double getPosx_() {
		return posx_;
	}
	
	public double getPosy_() {
		return posy_;
	}

	public DriveTrainGearbox getLeft() {
		return this.left;
	}
	
	public DriveTrainGearbox getRight() {
		return this.right;
	}
	
	/**
	 * Heading and position math
	 */
	public void calculate() {
		
		//Estimates heading. Collect some actual data from robot though
		anglev_ = (1/kWheelBase) * (right.velocity_ - left.velocity_);
		angle_ += anglev_ *kDt;
		
		// position is average of that of the 2 sides
		double d_pos_ =( left.velocity_ *kDt + right.velocity_ *kDt ) /2;
		pos_ += d_pos_;
		
		//find x and y with trig + linear approximation
		posx_ += d_pos_ * Math.cos(angle_);
		posy_ += d_pos_ * Math.sin(angle_);
		
		
	}

}
