/**
 * Models drivetrain gearboxes (duh). Values for the fields below are samples, 
 * so replace with your own observed values.
 */
public class DriveTrainGearbox {


	double position_ ;
	double velocity_ ;

	double kDt;

	// Stall Torque in Nm
	public final double k_STALL_TORQUE = 2;
	// Stall Current in Amps
	public final double k_STALL_CURRENT = 90;
	// Free Speed in RPM
	public final double k_FREE_SPEED = 5800;
	// Free Current in Amps
	public final double k_FREE_CURRENT = 5;
	// Mass of stuff on the robot
	public final double k_MASS = 40;

	// Number of motors
	public final double kNumMotors = 3.0;
	// Resistance of the motor
	public final double kResistance = 12.0 / k_STALL_CURRENT;
	// Motor velocity constant
	public final double Kv = ((k_FREE_SPEED / 60.0 * 2.0 * Math.PI) / (12.0 - kResistance * k_FREE_CURRENT));
	// Torque constant
	public final double Kt = (kNumMotors * k_STALL_TORQUE) / k_STALL_CURRENT;
	// Gear ratio
	public final double kG = 7.0;
	// Radius of pulley
	public final double kR = 2.0 * (0.0254);// / Math.PI / 2.0);

	public DriveTrainGearbox(double pos, double vel, double kDt) {
		this.position_ = pos;
		this.velocity_ = vel;
		this.kDt = kDt;
	}

	
	public double getAcceleration(double voltage, double velocity) {
		return -Kt * kG * kG / (Kv * kResistance * kR * kR * k_MASS) * velocity
				+ kG * Kt / (kResistance * kR * k_MASS) * voltage;
	}

	
	public void calcPosVel(double voltage) {
		
		this.position_ += this.velocity_ * kDt;
		this.velocity_ += getAcceleration(voltage, this.velocity_)*kDt;
	}
	
	public double getPosition_() {
		return position_;
	}
	
	public double getVelocity_() {
		return velocity_;
	}

}
