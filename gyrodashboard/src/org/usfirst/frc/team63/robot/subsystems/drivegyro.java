package org.usfirst.frc.team63.robot.subsystems;

import org.usfirst.frc.team63.robot.RobotMap;import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class drivegyro extends Subsystem {

	private final AHRS imu_;
	private final WPI_TalonSRX TalonFrontLeft;
	private final WPI_TalonSRX TalonBackLeft;
	private final WPI_TalonSRX TalonFrontRight;
	private final WPI_TalonSRX TalonBackRight;
	private final SpeedControllerGroup leftSide;
	private final SpeedControllerGroup rightSide;
	private DifferentialDrive m_robotDrive;
	
	public drivegyro() {
		imu_ = new AHRS(SPI.Port.kMXP);
		TalonFrontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_MOTOR);
		TalonBackLeft = new WPI_TalonSRX(RobotMap.REAR_LEFT_MOTOR);
		TalonFrontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MOTOR);
		TalonBackRight = new WPI_TalonSRX(RobotMap.REAR_RIGHT_MOTOR);
		
		TalonFrontLeft.setInverted(false);
		TalonBackLeft.setInverted(false);
		TalonFrontRight.setInverted(false);
		TalonBackRight.setInverted(false);

		leftSide = new SpeedControllerGroup(TalonFrontLeft, TalonBackLeft);
		rightSide = new SpeedControllerGroup(TalonFrontRight, TalonBackRight);
		
		m_robotDrive = new DifferentialDrive(leftSide, rightSide);
		
		setTalonBaseConfigurationTelop();
		
	}
	boolean Xdirection;
	boolean Zdirection;
	
	/* allows us to make motors spin backwards */
//	private void setWithDirection(WPI_TalonSRX talon, boolean Inverted)
//	{
//		
//		
//	}
	
    public void initDefaultCommand() {
   
    }
    
    public void teleopDrive(double speed, double rotate)
    {
//    	System.out.println("speed: " + speed + ", rotate: " + rotate);
    	m_robotDrive.arcadeDrive(speed, rotate);
//    	double leftOutput = speed + rotate;
//    	double rightOutput = speed - rotate;
//    	
//    	if(leftOutput < -1.0) leftOutput = -1.0;
//    	if(rightOutput < -1.0) rightOutput = -1.0;
//    	if(leftOutput > 1.0) leftOutput = 1.0;
//    	if(rightOutput > 1.0) rightOutput = 1.0;
    	
//    	leftSide.set(leftOutput);
//    	rightSide.set(rightOutput);
    	
    }
    
    public synchronized boolean isNavXCalibrating()
    {
    	return imu_.isCalibrating();
    }
    
    public synchronized boolean isNavXConnected()
    {
    	return imu_.isConnected();
    }
    
    public synchronized void resetGyro()
    {
    	imu_.reset();
    }
    
    public synchronized double getGyroAngleDegrees() {
        return -imu_.getAngle() % 360.0;
    }
    
    public void setTalonBaseConfigurationTelop()
    {
    	TalonFrontLeft.configNominalOutputForward(0.0, 10);
    	TalonFrontLeft.configNominalOutputReverse(-0.0, 10);
    	TalonFrontLeft.configPeakOutputForward(+12.0, 10);    	    
    	TalonFrontLeft.configPeakOutputReverse(-12.0, 10);  
    	
    	TalonBackLeft.configNominalOutputForward(0.0, 10);
    	TalonBackLeft.configNominalOutputReverse(-0.0, 10);
    	TalonBackLeft.configPeakOutputForward(+12.0, 10);    	    
    	TalonBackLeft.configPeakOutputReverse(-12.0, 10);   	    
    	
    	TalonFrontRight.configNominalOutputForward(0.0, 10);
    	TalonFrontRight.configNominalOutputReverse(-0.0, 10);
    	TalonFrontRight.configPeakOutputForward(+12.0, 10);    	    
    	TalonFrontRight.configPeakOutputReverse(-12.0, 10);   	    
    	
    	TalonBackRight.configNominalOutputForward(0.0, 10);
    	TalonBackRight.configNominalOutputReverse(-0.0, 10);
    	TalonBackRight.configPeakOutputForward(+12.0, 10);    	    
    	TalonBackRight.configPeakOutputReverse(-12.0, 10);     	    

        // Load velocity control gains
//    	TalonFrontLeft.config_kP(0,RobotMap.kDriveVelocityKpAuto, 10);
//    	TalonFrontLeft.config_kI(0, RobotMap.kDriveVelocityKiAuto, 10);
//    	TalonFrontLeft.config_kD(0,RobotMap.kDriveVelocityKdAuto, 10);
//    	TalonFrontLeft.config_kF(0,RobotMap.kDriveVelocityKfAuto, 10);
//    	TalonFrontLeft.config_IntegralZone(0,RobotMap.kDriveVelocityIZone, 10);
//    	
//    	TalonFrontRight.config_kP(0,RobotMap.kDriveVelocityKpAuto, 10);
//    	TalonFrontRight.config_kI(0, RobotMap.kDriveVelocityKiAuto, 10);
//    	TalonFrontRight.config_kD(0,RobotMap.kDriveVelocityKdAuto, 10);
//    	TalonFrontRight.config_kF(0,RobotMap.kDriveVelocityKfAuto, 10);
//    	TalonFrontRight.config_IntegralZone(0,RobotMap.kDriveVelocityIZone, 10);
//    	
//    	TalonBackLeft.config_kP(0,RobotMap.kDriveVelocityKpAuto, 10);
//    	TalonBackLeft.config_kI(0, RobotMap.kDriveVelocityKiAuto, 10);
//    	TalonBackLeft.config_kD(0,RobotMap.kDriveVelocityKdAuto, 10);
//    	TalonBackLeft.config_kF(0,RobotMap.kDriveVelocityKfAuto, 10);
//    	TalonBackLeft.config_IntegralZone(0,RobotMap.kDriveVelocityIZone, 10);
//    	
//    	
//    	TalonBackRight.config_kP(0,RobotMap.kDriveVelocityKpAuto, 10);
//    	TalonBackRight.config_kI(0, RobotMap.kDriveVelocityKiAuto, 10);
//    	TalonBackRight.config_kD(0,RobotMap.kDriveVelocityKdAuto, 10);
//    	TalonBackRight.config_kF(0,RobotMap.kDriveVelocityKfAuto, 10);
//    	TalonBackRight.config_IntegralZone(0,RobotMap.kDriveVelocityIZone, 10);
    	
    }
    
}

