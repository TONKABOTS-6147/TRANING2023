// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  public TalonFX frontLeftMotor;
  public TalonFX frontRightMotor;
  public TalonFX backLeftMotor;
  public TalonFX backRightMotor;
  public TalonFX[] driveMotorArray;

  public DriveSubsystem() {
    this.frontLeftMotor = new TalonFX(4);
    this.frontRightMotor = new TalonFX(2);
    this.backLeftMotor = new TalonFX(3);
    this.backRightMotor = new TalonFX(1);
    this.driveMotorArray = new TalonFX[] { this.frontLeftMotor, this.frontRightMotor, this.backLeftMotor, this.backRightMotor };

    for (TalonFX motor : this.driveMotorArray) {
      motor.configFactoryDefault();
      motor.setNeutralMode(NeutralMode.Brake);
      motor.config_kP(0, 0.1);
      motor.config_kI(0, 0);
      motor.config_kD(0, 0);
    }

    this.frontLeftMotor.setInverted(false);
    this.frontRightMotor.setInverted(true);
    this.backLeftMotor.setInverted(false);
    this.backRightMotor.setInverted(true);
  }

  public void velocityControl (double trigger){
    //the speed is in encoder ticks per second
    trigger *= 8000;
    this.frontLeftMotor.set(ControlMode.Velocity, trigger);
    this.frontRightMotor.set(ControlMode.Velocity, trigger);
    this.backLeftMotor.set(ControlMode.Velocity, trigger);
    this.backRightMotor.set(ControlMode.Velocity, trigger);
  }

  public void positionControl (double encoderTicks) {
    this.frontLeftMotor.set(ControlMode.Position, encoderTicks);
    this.frontRightMotor.set(ControlMode.Position, encoderTicks);
    this.backLeftMotor.set(ControlMode.Position, encoderTicks);
    this.backRightMotor.set(ControlMode.Position, encoderTicks);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
