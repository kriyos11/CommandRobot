package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

    private PWMVictorSPX driveLeftMotor = new PWMVictorSPX(DriveConstants.kLeftMotorPort);
    private PWMVictorSPX driveRightMotor = new PWMVictorSPX(DriveConstants.kRightMotorPort);
    private Encoder leftEncoder = new Encoder(//
            DriveConstants.kLeftEncoderChannelA, DriveConstants.kLeftEncoderChannelB);
    private Encoder rightEncoder = new Encoder(//
            DriveConstants.kRightEncoderChannelA, DriveConstants.kRightEncoderChannelB);

    public double getEncoderMeters() {
        return (leftEncoder.get() + -rightEncoder.get()) / 2 * DriveConstants.kEncoderTick2Meter;
    }

    public DriveSubsystem() {
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Drive encoder value", getEncoderMeters());
    }

    public void setMotors(double leftSpeed, double rightSpeed) {
        driveLeftMotor.set(leftSpeed);
        driveRightMotor.set(-rightSpeed);
    }

}