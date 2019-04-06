import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;


public class Path {
	
	Waypoint[] points = new Waypoint[] {

			new Waypoint(0, 0, 0), // Waypoint @ x = 0, y = 0, exit angle = 0 radians, angle = -45 degrees
			new Waypoint(8, 8, 0), // Waypoint @ x = -2, y = -2, exit angle = 0 radians, angle = -45 degrees
			new Waypoint(10, 0, Pathfinder.d2r(-90))
	};

	public Trajectory.Config config;
	public Trajectory trajectory;
	
	public Path() {
		this.config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH,
				0.05, 3, 4, 60.0);
		this.trajectory = Pathfinder.generate(points, config);
	}
	
	public Trajectory getTrajectory() {
		return trajectory;
	}
}
